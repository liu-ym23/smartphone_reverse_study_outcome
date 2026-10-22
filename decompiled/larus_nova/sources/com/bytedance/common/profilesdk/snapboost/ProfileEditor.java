package com.bytedance.common.profilesdk.snapboost;

import android.os.SystemClock;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.profilesdk.AppContext;
import com.bytedance.common.profilesdk.DexImageLoader;
import com.bytedance.common.profilesdk.DeximageMonitor;
import com.bytedance.common.profilesdk.core.DexOptimizer;
import com.bytedance.common.profilesdk.util.FileUtils;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.common.profilesdk.util.PathUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes15.dex */
public class ProfileEditor {
    public static int RESULT_COMPILED_NOIMAGE = 107;
    public static int RESULT_FAILED_COMPILED = 108;
    public static int RESULT_FAILED_CREATE_LIST = 102;
    public static int RESULT_FAILED_CREATE_PROFILE = 103;
    public static int RESULT_FAILED_MERGE_CUR = 104;
    public static int RESULT_FAILED_UNSUPPORTED = 101;
    public static int RESULT_SUCCESS_IMAGE = 1;
    public static int RESULT_SUCCESS_MERGED = 2;
    public static int RESULT_SUCCESS_NOTHINGTODO = 5;
    public static int RESULT_SUCCESS_SKIP_IMAGE = 3;
    public static int RESULT_SUCCESS_SKIP_NOIMAGE = 4;
    boolean mAllMethod;
    List<ClassList> mClassLists;
    Set<String> mClassSet;
    String mDexPath;
    String mName;
    boolean mNeedCompile;
    boolean mNeverSkip;
    List<String> mPendingClasses;
    String mVersion;

    private void checkClasses() {
        Iterator<String> r100 = this.mPendingClasses.iterator();
        List<String> r101 = null;
    L4:
        if (r100.hasNext() == false) goto L17;
        String r102 = r100.next();
        if (r102.endsWith("*") == true) goto L7;
        this.mClassSet.add(r102);
        goto L4
    L7:
        if (r101 != null) goto L9;
        r101 = AppContext.getDexClassNames();
    L9:
        int r103 = 0;
        String r104 = r102.substring(0, r102.lastIndexOf(42));
        Iterator<String> r105 = r101.iterator();
    L11:
        if (r105.hasNext() == false) goto L15;
        String r106 = r105.next();
        if (r106.startsWith(r104) == false) goto L11;
        this.mClassSet.add(r106);
        r103 = r103 + 1;
        goto L11
    L15:
        Logger.d("CheckClasses: " + r102 + " match " + r103);
        goto L4
    L17:
        Iterator<ClassList> r107 = this.mClassLists.iterator();
    L19:
        if (r107.hasNext() == false) goto L21;
        ClassList r108 = r107.next();
        r108.processWildcardIfNeeded();
        this.mClassSet.addAll(r108.getClassNames());
        goto L19
    }

    private int commitInternal() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(AppContext.getProfilesDir(), getProfileFileName());
        PolarisFileWrapper r101 = new PolarisFileWrapper(AppContext.getProfilesDir(), "cart.list");
        BufferedWriter r102 = new BufferedWriter(new PolarisFileWriterWrapper(r101, false));     // Catch: IOException -> L23
        Iterator<String> r103 = this.mClassSet.iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();     // Catch: Throwable -> L15
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L15
        r105.append("L");     // Catch: Throwable -> L15
        r105.append(r104.replace('.', '/'));     // Catch: Throwable -> L15
        if (this.mAllMethod == false) goto L10;
        String r106 = ";->*";
    L11:
        r105.append(r106);     // Catch: Throwable -> L15
        r102.write(r105.toString());     // Catch: Throwable -> L15
        r102.newLine();     // Catch: Throwable -> L15
        goto L6
    L10:
        r106 = i.f25853b;
        goto L11
    L12:
        r102.flush();     // Catch: Throwable -> L15
        r102.close();     // Catch: IOException -> L23
    L25:
        if (FileUtils.isFileValid(r101) == true) goto L29;
        return RESULT_FAILED_CREATE_LIST;
    L29:
        if (this.mDexPath != null) goto L31;
        this.mDexPath = AppContext.getContext().getPackageCodePath();
    L31:
        Logger.d("Target dex: " + this.mDexPath);
        if (DexImageLoader.ProfileChoreographer.createProfileFromList(this.mDexPath, r101, r100) == true) goto L36;
        return RESULT_FAILED_CREATE_PROFILE;
    L36:
        if (DexImageLoader.ProfileChoreographer.mergeProfiles(r100, PathUtils.getPrimaryCurProfile(), false, true) == true) goto L40;
        return RESULT_FAILED_MERGE_CUR;
    L40:
        if (this.mNeedCompile == true) goto L44;
        return RESULT_SUCCESS_MERGED;
    L44:
        if (DexOptimizer.compilePrimaryDex() == false) goto L48;
        return RESULT_SUCCESS_IMAGE;
    L48:
        return RESULT_FAILED_COMPILED;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L23
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L23
    L23:
        Logger.e(MonitorConstants.IO);
        goto L25
    }

    private String getProfileFileName() {
        return "cart_" + this.mName + "_" + this.mVersion + ".prof";
    }

    private boolean profileCommited() {
        return FileUtils.isFileValid(new PolarisFileWrapper(AppContext.getProfilesDir(), getProfileFileName()));
    }

    public ProfileEditor() {
        this.mPendingClasses = new ArrayList();
        this.mClassSet = new HashSet();
        this.mName = "none";
        this.mVersion = "0";
        this.mClassLists = new ArrayList();
    }

    public int commit() {
        if (SnapBoost.hasInited() == true) goto L6;
        Logger.w("Please make sure SnapBoost.init(...) before ProfileEditor.commit()");
        return 0;
    L6:
        Logger.d("ProfileEditor.commit");
        if (SnapBoost.versionSupportProfile() == true) goto L11;
        Logger.w("Image only support Android 9/10/11");
        return RESULT_FAILED_UNSUPPORTED;
    L11:
        if (this.mNeverSkip == false) goto L13;
    L20:
        checkClasses();
        if (this.mClassSet.isEmpty() == true) goto L23;
        long r100 = SystemClock.uptimeMillis();
        int r101 = commitInternal();
        DeximageMonitor.monitorProfileCommit(SystemClock.uptimeMillis() - r100, r101);
        return r101;
    L23:
        return RESULT_SUCCESS_NOTHINGTODO;
    L13:
        if (profileCommited() == false) goto L20;
        if (new PolarisFileWrapper(AppContext.getPackageImagePath()).exists() == false) goto L18;
        Logger.w("CommitProfile: skip, base.art exists");
        return RESULT_SUCCESS_SKIP_IMAGE;
    L18:
        Logger.w("CommitProfile: skip, base.art not exists");
        return RESULT_SUCCESS_SKIP_NOIMAGE;
    }

    public void addClassList(ClassList r100) {
        if (r100 == null) goto L5;
        this.mClassLists.add(r100);
        return;
    }
}
