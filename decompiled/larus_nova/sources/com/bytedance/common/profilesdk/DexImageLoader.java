package com.bytedance.common.profilesdk;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.profilesdk.core.Profman;
import com.bytedance.common.profilesdk.deximage.DeximageHelper;
import com.bytedance.common.profilesdk.util.FileUtils;
import com.bytedance.common.profilesdk.util.Logger;
import com.bytedance.common.profilesdk.util.VersionUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.bytedance.services.apm.api.EnsureManager;
import dalvik.system.DexFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class DexImageLoader {

    public static class ProfileChoreographer {
        public static boolean createAllClassProfile(String r100, String r101) {
            if (VersionUtils.supportProfman() == true) goto L5;
            return false;
        L5:
            List<String> r102 = DexImageLoader.dumpClassesFromDexFile(r100, true);
            if (r101 == null) goto L8;
            File r103 = new PolarisFileWrapper(r101);
            r103.getParentFile().mkdirs();
        L9:
            PolarisFileWrapper r104 = new PolarisFileWrapper(r100 + ".list");
            if (r102.isEmpty() == true) goto L42;
            PolarisFileWriterWrapper r105 = new PolarisFileWriterWrapper(r104, false);     // Catch: Exception -> L39
            BufferedWriter r106 = new BufferedWriter(r105);     // Catch: Throwable -> L31
            int r107 = 0;
        L51:
        L23:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            r106.close();     // Catch: Throwable -> L28
        L30:
            throw th;     // Catch: Throwable -> L31
        L28:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L31
            goto L30
        L15:
            if (r107 >= r102.size()) goto L17;
            r106.newLine();     // Catch: Throwable -> L23
            r106.write(r102.get(r107));     // Catch: Throwable -> L23
            r107 = r107 + 1;     // Catch: Throwable -> L23
            goto L51
        L17:
            r106.close();     // Catch: Throwable -> L23
            r105.close();     // Catch: Throwable -> L23
            PolarisFileWrapper r108 = new PolarisFileWrapper(r100 + ".prof.intermediate");     // Catch: Throwable -> L23
            createProfileFromList(r100, r104, r108);     // Catch: Throwable -> L23
            if (FileUtils.isFileValid(r108) == false) goto L20;
            mergeProfiles(r108, r103, false, true);     // Catch: Throwable -> L23
        L20:
            r106.close();     // Catch: Throwable -> L31
            r105.close();     // Catch: Exception -> L39
        L31:
            th = move-exception;
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            r105.close();     // Catch: Throwable -> L36
        L38:
            throw th;     // Catch: Exception -> L39
        L36:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Exception -> L39
        L39:
            e = move-exception;
            Logger.d("createFinalProfile error " + e.getMessage());
        L42:
            if (FileUtils.isFileValid(r103) == false) goto L45;
            mergeProfiles(DexImageLoader.getSecondaryCurrentProfile(r100), r103, false);
            return true;
        L45:
            return false;
        L8:
            r103 = DexImageLoader.getSecondaryProfile(r100);
            goto L9
        }

        public static boolean createProfileFromList(String r100, File r101, File r102) {
            if (FileUtils.isFileValid(r101) == true) goto L6;
            return false;
        L6:
            if (TextUtils.isEmpty(r100) == false) goto L9;
            Logger.d("illegal dex location.");
            return false;
        L9:
            PolarisFileWrapper r103 = new PolarisFileWrapper(r100);
            if (r103.exists() == true) goto L14;
            Logger.d("dex location does not exist.");
            return false;
        L14:
            if (new Profman.Builder().addOption("--create-profile-from=" + r101.toString()).addOption("--apk=" + r103.toString()).addOption("--dex-location=" + r103.getName()).addOption("--reference-profile-file=" + r102.toString()).build().run() != 0) goto L17;
            return true;
        L17:
            return false;
        }

        public static boolean mergeProfiles(File r100, File r101, boolean r102) {
            return mergeProfiles(r100, r101, r102, false);
        }

        public static synchronized boolean mergeProfiles(File r110, File r111, boolean r112, boolean r113) {
            monitor-enter(ProfileChoreographer.class);
            Logger.d("Try to merge current profile:" + r110 + " with reference profile:" + r111);     // Catch: Throwable -> L54
            boolean r100 = false;
            if (FileUtils.isFileValid(r110) == false) goto L52;
            if (r111 == null) goto L52;
        L47:
            e = e;
        L48:
            EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L54
            Logger.e(e.toString(), e);     // Catch: Throwable -> L54
            boolean r101 = r100;
        L50:
            monitor-exit(ProfileChoreographer.class);
            return r101;
        L10:
            if (TextUtils.equals(r110.getCanonicalPath(), r111.getCanonicalPath()) == false) goto L15;
            Logger.d("Skip identical currentProfile and referenceProfile");     // Catch: Exception -> L47 Throwable -> L54
            monitor-exit(ProfileChoreographer.class);
            return false;
        L15:
            if (FileUtils.createIfNotExist(r111) == true) goto L17;
            Logger.d("fail to create " + r111.getAbsolutePath());     // Catch: Exception -> L47 Throwable -> L54
        L17:
            Profman.Builder r102 = new Profman.Builder().addOption("--profile-file=" + r110.toString()).addOption("--reference-profile-file=" + r111.toString());     // Catch: Exception -> L47 Throwable -> L54
            if (r113 == false) goto L20;
            r102.addOption("--force-merge");     // Catch: Exception -> L47 Throwable -> L54
        L20:
            int r114 = r102.build().run();     // Catch: Exception -> L47 Throwable -> L54
            r101 = true;
            if (r114 == 0) goto L34;
            if (r114 != 1) goto L24;
            String r115 = "There is not enough new information added by the current profiles, skip.";
        L33:
            boolean r103 = false;
            r101 = false;
        L57:
            Logger.e(r115);     // Catch: Exception -> L45 Throwable -> L54
            if (r112 == false) goto L41;
            if (r100 == false) goto L41;
            Logger.d("Clearing profile: " + r110);     // Catch: Exception -> L45 Throwable -> L54
            DexImageLoader.deleteFile(r110);     // Catch: Exception -> L45 Throwable -> L54
            r110.createNewFile();     // Catch: Exception -> L45 Throwable -> L54
        L41:
            if (r112 == false) goto L50;
            if (r103 == false) goto L50;
            DexImageLoader.deleteFile(r111);     // Catch: Exception -> L45 Throwable -> L54
        L45:
            e = e;
            r100 = r101;
            goto L48
        L24:
            if (r114 != 2) goto L26;
            r115 = "Bad profiles in merging " + r110 + " and " + r111 + ", do clean-up.";     // Catch: Exception -> L47 Throwable -> L54
            r103 = true;
            r101 = false;
        L36:
            r100 = true;
            goto L57
        L26:
            if (r114 != 3) goto L28;
        L30:
            r115 = "IO error while reading profiles " + r110 + " and " + r111;     // Catch: Exception -> L47 Throwable -> L54
            goto L33
        L28:
            if (r114 == 4) goto L30;
            r115 = "Unknown error code while processing profiles " + r110 + " and " + r111;     // Catch: Exception -> L47 Throwable -> L54
            goto L33
        L34:
            r115 = "Profiles merged successfully.";
            r103 = false;
        L52:
            monitor-exit(ProfileChoreographer.class);
            return false;
        L54:
            th = move-exception;
            throw th;
        }
    }

    public DexImageLoader() {
    }

    public static boolean deleteFile(File r100) {
        if (r100.isFile() == true) goto L5;
        return false;
    L5:
        if (r100.exists() == true) goto L7;
        return false;
    L7:
        return r100.delete();
    }

    public static File getSecondaryCurrentProfile(String r100) {
        if (VersionUtils.supportLegacySecondaryProfile() == false) goto L7;
        return new PolarisFileWrapper(r100 + ".prof");
    L7:
        if (VersionUtils.supportSecondaryProfile() == false) goto L10;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        return new PolarisFileWrapper(new PolarisFileWrapper(r101.getParent(), "oat"), r101.getName() + ".cur.prof");
    L10:
        return null;
    }

    public static File getSecondaryProfile(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        return new PolarisFileWrapper(new PolarisFileWrapper(r101.getParent(), "oat"), r101.getName() + ".prof");
    }

    public static String getSecondaryProfilePath(String r100) {
        return getSecondaryProfile(r100).getAbsolutePath();
    }

    public static List<String> dumpClassesFromDexFile(String r100, boolean r101) {
        List r102 = new ArrayList();
        long r103 = SystemClock.uptimeMillis();
    L9:
        e = move-exception;
        Logger.e("Failed to loadDexFileInMemory", e);
    L11:
        if (r102 != null) goto L32;
    L14:
        r102.add(DexFile.loadDex(r100, null, 0));     // Catch: IOException -> L16
    L18:
        if (r102 == null) goto L29;
        if (r102.isEmpty() == true) goto L29;
        long r104 = SystemClock.uptimeMillis();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r102.iterator();
    L24:
        if (r106.hasNext() == false) goto L26;
        r105.addAll(dumpClassesFromDexFile((DexFile) r106.next(), r101));
        goto L24
    L26:
        Logger.d("open dexfile[" + r100 + "] took " + (r104 - r103) + "ms, dump classes took " + (SystemClock.uptimeMillis() - r104) + "ms, classlist_size=" + r105.size());
        return r105;
    L29:
        return Collections.EMPTY_LIST;
    L16:
        e = move-exception;
        Logger.e("Failed to loadDex", e);
        goto L18
    L32:
        if (r102.isEmpty() == false) goto L18;
    L4:
        if (VersionUtils.isNOP() == false) goto L11;
        if (DexFile.isDexOptNeeded(r100) == false) goto L11;
        r102 = DeximageHelper.loadDexFileInMemory(r100);     // Catch: Exception -> L9
        Logger.d("[" + r100 + "] need opt, loadDexFileInMemory took " + (SystemClock.uptimeMillis() - r103) + "ms");     // Catch: Exception -> L9
        goto L11
    }

    public static List<String> dumpClassesFromDexFile(DexFile r100, boolean r101) {
        ArrayList r102 = new ArrayList();
        if (r100 != null) goto L15;
        return r102;
    L15:
        Enumeration<String> r103 = r100.entries();     // Catch: Exception -> L13
    L6:
        if (r103.hasMoreElements() == false) goto L14;
        String r104 = r103.nextElement();     // Catch: Exception -> L13
        if (r101 == true) goto L10;
        r102.add(r104);     // Catch: Exception -> L13
        goto L6
    L10:
        r102.add("L" + r104.replace('.', '/') + i.f25853b);     // Catch: Exception -> L13
    L14:
        return r102;
    L13:
        Logger.d("exception dumping classes.");
        goto L14
    }
}
