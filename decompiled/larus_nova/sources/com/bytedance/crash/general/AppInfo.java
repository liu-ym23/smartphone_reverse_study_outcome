package com.bytedance.crash.general;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.s;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import zg4.h;

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: loaded from: classes15.dex */
    public static class a implements FilenameFilter {
        public a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return r101.endsWith(AppInfo.SUFFIX);
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class b implements Comparator<File> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(File r100, File r101) {
            return Long.compare(AppInfo.access$000(r101), AppInfo.access$000(r100));
        }
    }

    public AppInfo() {
    }

    public static /* synthetic */ long access$000(File r100) {
        return getLastUpdateTime(r100);
    }

    private static void clear(File r100) {
        File[] r101 = getSortedFilesArray(r100);
        if (r101 == null) goto L15;
        int r102 = 3;
        if (r101.length <= 3) goto L19;
        long r103 = System.currentTimeMillis();
    L8:
        if (r102 >= r101.length) goto L20;
        long r104 = getLastUpdateTime(r101[r102]);
        if (r104 >= 0) goto L12;
    L13:
        r101[r102].delete();
    L14:
        r102 = r102 + 1;
        goto L8
    L12:
        if ((r103 - r104) <= TOW_WEEKS) goto L14;
    L20:
        return;
    L19:
        return;
    }

    private static long getLastUpdateTime(File r100) {
        String r101 = r100.getName();     // Catch: Throwable -> L4
        return CastLongProtector.parseLong(r101.substring(0, r101.length() - 4));
    L4:
        return -1;
    }

    private static File[] getSortedFilesArray(File r100) {
        File[] r101 = r100.listFiles(new a());
        if (r101 == null) goto L5;
        Arrays.sort(r101, new b());
    L5:
        return r101;
    }

    public void putTo(JSONObject r100) {
        j.h(r100, "package", this.mPackageName);
        j.h(r100, "display_name", this.mDisplayName);
        j.h(r100, "app_version", this.mAppVersionName);
        j.h(r100, "version_code", Integer.valueOf(this.mAppVersionCode));
        j.h(r100, KEY_APP_VERIFY_INFO, this.mBitWide);
        j.h(r100, KEY_APP_RELEASE_BUILD, this.mReleaseBuild);
        j.h(r100, KEY_NPTH_BYTRACE_ID, this.mNpthBytraceId);
        j.h(r100, "sdk_version", Integer.valueOf(this.mNpthVersionCode));
        j.h(r100, KEY_NPTH_VERSION_NAME, this.mNpthVersionName);
        j.h(r100, "last_update_time", Long.valueOf(this.mLastUpdateTime));
        Map<String, Object> r101 = this.mAppExtension;
        if (r101 == null) goto L8;
        Iterator<String> r102 = r101.keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        j.h(r100, r103, this.mAppExtension.get(r103));
        goto L6
    L10:
        return;
    }

    public static AppInfo findAppInfo(File r100, long r101) {
        File[] r102 = getSortedFilesArray(r100);
        if (r102 == null) goto L14;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L23;
        AppInfo r105 = (AppInfo) s.a(r102[r104]);     // Catch: Throwable -> L16
        if (r105 == null) goto L13;
        if (r101 <= r105.mLastUpdateTime) goto L13;
        return r105;
    L13:
        r104 = r104 + 1;
        goto L5
    L23:
        return null;
    L14:
        return null;
    }

    public static AppInfo get(Context r100, File r101) {
        String r102 = r100.getPackageName();
        PackageInfo r103 = null;
        PolarisFileWrapper r104 = null;
        PackageInfo r105 = r100.getPackageManager().getPackageInfo(r102, 0);     // Catch: Throwable -> L11
        PolarisFileWrapper r106 = new PolarisFileWrapper(r101, r105.lastUpdateTime + SUFFIX);     // Catch: Throwable -> L9
        AppInfo r107 = (AppInfo) s.a(r106);     // Catch: Throwable -> L8
        if (r107 == null) goto L13;
        return r107;
    L13:
        AppInfo r108 = new AppInfo();
        r108.mPackageName = r102;
        if (NativeBridge.G() == false) goto L16;
        String r109 = BDLocationException.ERROR_RESTRICTED_MODE_ON;
    L17:
        r108.mBitWide = r109;
        r108.mReleaseBuild = zg4.a.a();
        r108.mNpthVersionCode = 4020259;
        r108.mNpthVersionName = h.f572084a;
        r108.mNpthBytraceId = com.bytedance.crash.dumper.c.b().f203156d;
        if (zg4.a.f572043b != null) goto L20;
        zg4.a.f572043b = new zg4.a();
    L20:
        r108.mAppExtension = zg4.a.f572043b.f572044a;
        if (r105 == null) goto L27;
        r108.mLastUpdateTime = r105.lastUpdateTime;
        r108.mAppVersionCode = r105.versionCode;
        r108.mAppVersionName = r105.versionName;
        ApplicationInfo r110 = r105.applicationInfo;
        if (r110 == null) goto L27;
        int r111 = r110.labelRes;
        if (r111 <= 0) goto L27;
        r108.mDisplayName = r100.getString(r111);
    L27:
        if (r106 == null) goto L29;
        clear(r101);
        s.b(r106, r108);
    L29:
        return r108;
    L16:
        r109 = BDLocationException.ERROR_CONNECT_GOOGLE_FAIL;
    L8:
        r104 = r106;
    L10:
        PolarisFileWrapper r112 = r104;
        r103 = r105;
    L12:
        r106 = r112;
        r105 = r103;
    L11:
        r112 = null;
        goto L12
    }
}
