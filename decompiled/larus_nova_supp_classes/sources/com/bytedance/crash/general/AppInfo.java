package com.bytedance.crash.general;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bytedance.crash.dumper.c;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.s;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import zg4.a;
import zg4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class AppInfo implements Serializable {
    private static final String KEY_APP_DISPLAY_NAME = "display_name";
    private static final String KEY_APP_PACKAGE = "package";
    private static final String KEY_APP_RELEASE_BUILD = "release_build";
    private static final String KEY_APP_VERIFY_INFO = "verify_info";
    private static final String KEY_NPTH_BYTRACE_ID = "bytrace_id";
    public static final String KEY_NPTH_VERSION_CODE = "sdk_version";
    public static final String KEY_NPTH_VERSION_NAME = "sdk_version_name";
    private static final int MAX_FILE_COUNT = 3;
    private static final String SUFFIX = ".aif";
    private static final long TOW_WEEKS = 1209600000;
    private static final long serialVersionUID = 1;
    Map<String, Object> mAppExtension;
    int mAppVersionCode;
    String mAppVersionName;
    String mBitWide;
    String mDisplayName;
    long mLastUpdateTime;
    String mNpthBytraceId;
    int mNpthVersionCode;
    String mNpthVersionName;
    String mPackageName;
    String mReleaseBuild;

    public AppInfo() {
    }

    public static /* synthetic */ long access$000(File r2) {
        return getLastUpdateTime(r2);
    }

    private static void clear(File r8) {
        File[] r9 = getSortedFilesArray(r8);
        if (r9 == null) goto L15;
        int r1 = 3;
        if (r9.length <= 3) goto L19;
        long r2 = System.currentTimeMillis();
    L8:
        if (r1 >= r9.length) goto L20;
        long r4 = getLastUpdateTime(r9[r1]);
        if (r4 >= 0) goto L12;
    L13:
        r9[r1].delete();
    L14:
        r1 = r1 + 1;
        goto L8
    L12:
        if ((r2 - r4) <= TOW_WEEKS) goto L14;
    L20:
        return;
    L19:
        return;
    }

    private static long getLastUpdateTime(File r2) {
        String r3 = r2.getName();     // Catch: Throwable -> L4
        return CastLongProtector.parseLong(r3.substring(0, r3.length() - 4));
    L4:
        return -1;
    }

    private static File[] getSortedFilesArray(File r1) {
        File[] r2 = r1.listFiles(new a());
        if (r2 == null) goto L5;
        Arrays.sort(r2, new b());
    L5:
        return r2;
    }

    public void putTo(JSONObject r4) {
        j.h(r4, KEY_APP_PACKAGE, this.mPackageName);
        j.h(r4, KEY_APP_DISPLAY_NAME, this.mDisplayName);
        j.h(r4, "app_version", this.mAppVersionName);
        j.h(r4, "version_code", Integer.valueOf(this.mAppVersionCode));
        j.h(r4, KEY_APP_VERIFY_INFO, this.mBitWide);
        j.h(r4, KEY_APP_RELEASE_BUILD, this.mReleaseBuild);
        j.h(r4, KEY_NPTH_BYTRACE_ID, this.mNpthBytraceId);
        j.h(r4, KEY_NPTH_VERSION_CODE, Integer.valueOf(this.mNpthVersionCode));
        j.h(r4, KEY_NPTH_VERSION_NAME, this.mNpthVersionName);
        j.h(r4, "last_update_time", Long.valueOf(this.mLastUpdateTime));
        Map<String, Object> r0 = this.mAppExtension;
        if (r0 == null) goto L8;
        Iterator<String> r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        j.h(r4, r2, this.mAppExtension.get(r2));
        goto L6
    L10:
        return;
    }

    public static AppInfo findAppInfo(File r6, long r7) {
        File[] r8 = getSortedFilesArray(r6);
        if (r8 == null) goto L14;
        int r0 = r8.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L23;
        AppInfo r2 = (AppInfo) s.a(r8[r1]);     // Catch: Throwable -> L16
        if (r2 == null) goto L13;
        if (r7 <= r2.mLastUpdateTime) goto L13;
        return r2;
    L13:
        r1 = r1 + 1;
        goto L5
    L23:
        return null;
    L14:
        return null;
    }

    public static AppInfo get(Context r8, File r9) {
        String r0 = r8.getPackageName();
        PackageInfo r1 = null;
        PolarisFileWrapper r2 = null;
        PackageInfo r3 = r8.getPackageManager().getPackageInfo(r0, 0);     // Catch: Throwable -> L11
        PolarisFileWrapper r4 = new PolarisFileWrapper(r9, r3.lastUpdateTime + SUFFIX);     // Catch: Throwable -> L9
        AppInfo r5 = (AppInfo) s.a(r4);     // Catch: Throwable -> L8
        if (r5 == null) goto L13;
        return r5;
    L13:
        AppInfo r6 = new AppInfo();
        r6.mPackageName = r0;
        if (NativeBridge.G() == false) goto L16;
        String r7 = "64";
    L17:
        r6.mBitWide = r7;
        r6.mReleaseBuild = a.a();
        r6.mNpthVersionCode = 4020259;
        r6.mNpthVersionName = h.a;
        r6.mNpthBytraceId = c.b().d;
        if (a.b != null) goto L20;
        a.b = new a();
    L20:
        r6.mAppExtension = a.b.a;
        if (r3 == null) goto L27;
        r6.mLastUpdateTime = r3.lastUpdateTime;
        r6.mAppVersionCode = r3.versionCode;
        r6.mAppVersionName = r3.versionName;
        ApplicationInfo r10 = r3.applicationInfo;
        if (r10 == null) goto L27;
        int r11 = r10.labelRes;
        if (r11 <= 0) goto L27;
        r6.mDisplayName = r8.getString(r11);
    L27:
        if (r4 == null) goto L29;
        clear(r9);
        s.b(r4, r6);
    L29:
        return r6;
    L16:
        r7 = "32";
    L8:
        r2 = r4;
    L10:
        PolarisFileWrapper r12 = r2;
        r1 = r3;
    L12:
        r4 = r12;
        r3 = r1;
    L11:
        r12 = null;
        goto L12
    }
}
