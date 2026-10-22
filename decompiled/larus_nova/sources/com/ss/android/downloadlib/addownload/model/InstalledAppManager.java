package com.ss.android.downloadlib.addownload.model;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.utils.ToolUtils;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes34.dex */
public class InstalledAppManager {
    private static final long EXPIRE_TIME = 1800000;
    private static final int[] INSTALL_FINISH_HIJACK_ERROR_CODES = null;
    private static final String[] PKG_NAME_FUZZY_MATCH_EXCLUDES = null;
    private static volatile InstalledAppManager sInstance;
    private final LinkedList<AppInfo> mApkList;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.addownload.model.InstalledAppManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AppInfo {
        public final String appName;
        public final long installedTime;
        public final String pkgName;
        public final int versionCode;
        public final String versionName;

        private AppInfo(String r100, int r101, String r102, String r103, long r104) {
            this.pkgName = r100;
            this.versionCode = r101;
            String r105 = null;
            if (r102 == null) goto L5;
            String r106 = r102.toLowerCase();
        L6:
            this.versionName = r106;
            if (r103 == null) goto L9;
            r105 = r103.toLowerCase();
        L9:
            this.appName = r105;
            this.installedTime = r104;
            return;
        L5:
            r106 = null;
            goto L6
        }

        public /* synthetic */ AppInfo(String r100, int r101, String r102, String r103, long r104, AnonymousClass1 r105) {
            this(r100, r101, r102, r103, r104);
        }
    }

    static {
        PKG_NAME_FUZZY_MATCH_EXCLUDES = new String[]{"com", "android", "ss"};
        INSTALL_FINISH_HIJACK_ERROR_CODES = new int[]{3101, 3102, NewToolbarButtonConstants.TOOLBAR_ANCHOR_MORE_LIVE_MANAGE, 3201, 3202, 3203};
    }

    public static InstalledAppManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(InstalledAppManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new InstalledAppManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(InstalledAppManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private InstalledAppManager() {
        this.mApkList = new LinkedList();
    }

    private void checkExpireTime() {
        long r100 = System.currentTimeMillis();
        LinkedList<AppInfo> r101 = this.mApkList;
        monitor-enter(r101);
        Iterator<AppInfo> r102 = this.mApkList.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        if ((r100 - r102.next().installedTime) <= 1800000) goto L10;
        r102.remove();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public AppInfo peek() {
        checkExpireTime();
        LinkedList<AppInfo> r100 = this.mApkList;
        monitor-enter(r100);
        AppInfo r101 = this.mApkList.peek();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    private AppInfo createApkInfo(String r110) {
        PackageManager r100 = GlobalInfo.getContext().getPackageManager();     // Catch: Throwable -> L6
        PackageInfo r101 = r100.getPackageInfo(r110, 0);     // Catch: Throwable -> L6
        if (r101 == null) goto L12;
        return new AppInfo(r110, r101.versionCode, r101.versionName, (String) r100.getApplicationLabel(r101.applicationInfo), System.currentTimeMillis(), null);
    L12:
        return null;
    L6:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public void add(String r100) {
        checkExpireTime();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        AppInfo r101 = createApkInfo(r100);
        if (r101 == null) goto L15;
        LinkedList<AppInfo> r102 = this.mApkList;
        monitor-enter(r102);
        this.mApkList.add(r101);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public Pair<AppInfo, Integer> checkIfHijackedByAnotherInstalledApp(NativeDownloadModel r110) {
        if (r110 != null) goto L98;
        return null;
    L98:
        checkExpireTime();     // Catch: Throwable -> L94
        if (this.mApkList.isEmpty() == false) goto L8;
        return null;
    L8:
        String r100 = r110.getAppName();     // Catch: Throwable -> L94
        String r101 = r110.getPackageName();     // Catch: Throwable -> L94
        String r102 = r110.getVersionName();     // Catch: Throwable -> L94
        int r103 = r110.getVersionCode();     // Catch: Throwable -> L94
        int r104 = INSTALL_FINISH_HIJACK_ERROR_CODES.length;     // Catch: Throwable -> L94
        AppInfo[] r105 = new AppInfo[r104];     // Catch: Throwable -> L94
        LinkedList<AppInfo> r106 = this.mApkList;     // Catch: Throwable -> L94
        monitor-enter(r106);     // Catch: Throwable -> L94
        Iterator<AppInfo> r107 = this.mApkList.iterator();     // Catch: Throwable -> L91
        PackageInfo r111 = null;
    L11:
        int r112 = 0;
        if (r107.hasNext() == false) goto L84;
        AppInfo r113 = r107.next();     // Catch: Throwable -> L91
        if (r113.installedTime < r110.getJumpInstallTime()) goto L11;
        if (TextUtils.isEmpty(r100) == false) goto L24;
        if (r111 != null) goto L20;
        r111 = ToolUtils.getApkFilePackageInfo(r110);     // Catch: Throwable -> L91
    L20:
        if (r111 == null) goto L24;
        r100 = (String) GlobalInfo.getContext().getPackageManager().getApplicationLabel(r111.applicationInfo);     // Catch: Throwable -> L97
    L24:
        if (TextUtils.isEmpty(r100) == true) goto L36;
        if (TextUtils.isEmpty(r113.appName) == true) goto L36;
        r100 = r100.toLowerCase();     // Catch: Throwable -> L91
        if (r100.equals(r113.appName) == true) goto L29;
        if (r100.contains(r113.appName) == true) goto L34;
        if (r113.appName.contains(r100) == false) goto L36;
    L34:
        r105[1] = r113;     // Catch: Throwable -> L91
        goto L84
    L29:
        r105[0] = r113;     // Catch: Throwable -> L91
    L36:
        if (TextUtils.isEmpty(r101) == false) goto L42;
        if (r111 != null) goto L39;
        r111 = ToolUtils.getApkFilePackageInfo(r110);     // Catch: Throwable -> L91
    L39:
        if (r111 == null) goto L42;
        r101 = r111.packageName;     // Catch: Throwable -> L91
    L42:
        if (TextUtils.isEmpty(r101) == true) goto L58;
        if (TextUtils.isEmpty(r113.pkgName) == true) goto L58;
        r101 = r101.toLowerCase();     // Catch: Throwable -> L91
        if (r101.contains(r113.pkgName) == true) goto L56;
        if (r113.pkgName.contains(r101) == true) goto L56;
        if (r105[3] != null) goto L11;
        if (isPkgNameFuzzyMatched(r101, r113.pkgName) == false) goto L58;
        r105[3] = r113;     // Catch: Throwable -> L91
    L56:
        r105[2] = r113;     // Catch: Throwable -> L91
    L58:
        if (r105[4] != null) goto L11;
        if (TextUtils.isEmpty(r102) == false) goto L67;
        if (r111 != null) goto L64;
        r111 = ToolUtils.getApkFilePackageInfo(r110);     // Catch: Throwable -> L91
    L64:
        if (r111 == null) goto L67;
        r102 = r111.versionName;     // Catch: Throwable -> L91
    L67:
        if (TextUtils.isEmpty(r102) == true) goto L74;
        if (TextUtils.isEmpty(r113.versionName) == true) goto L74;
        r102 = r102.toLowerCase();     // Catch: Throwable -> L91
        if (r102.equals(r113.versionName) == false) goto L74;
        r105[4] = r113;     // Catch: Throwable -> L91
    L74:
        if (r105[5] != null) goto L11;
        if (r103 > 0) goto L82;
        if (r111 != null) goto L79;
        r111 = ToolUtils.getApkFilePackageInfo(r110);     // Catch: Throwable -> L91
    L79:
        if (r111 == null) goto L82;
        r103 = r111.versionCode;     // Catch: Throwable -> L91
    L82:
        if (r103 != r113.versionCode) goto L11;
        r105[5] = r113;     // Catch: Throwable -> L91
    L84:
        monitor-exit(r106);     // Catch: Throwable -> L91
    L85:
        if (r112 >= r104) goto L96;
        if (r105[r112] != null) goto L89;
        r112 = r112 + 1;
        goto L85
    L89:
        return new Pair(r105[r112], Integer.valueOf(INSTALL_FINISH_HIJACK_ERROR_CODES[r112]));
    L96:
        return null;
    L91:
        th = move-exception;
        throw th;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        th.printStackTrace();
        goto L96
    }

    public AppInfo get(String r100) {
        checkExpireTime();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        LinkedList<AppInfo> r101 = this.mApkList;
        monitor-enter(r101);
        Iterator<AppInfo> r102 = this.mApkList.iterator();     // Catch: Throwable -> L16
    L9:
        if (r102.hasNext() == false) goto L14;
        AppInfo r103 = r102.next();     // Catch: Throwable -> L16
        if (r100.equals(r103.pkgName) == false) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r103;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public AppInfo getLatestInstalledApp(NativeDownloadModel r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        checkExpireTime();
        LinkedList<AppInfo> r100 = this.mApkList;
        monitor-enter(r100);
        Iterator<AppInfo> r101 = this.mApkList.iterator();     // Catch: Throwable -> L16
    L9:
        if (r101.hasNext() == false) goto L14;
        AppInfo r102 = r101.next();     // Catch: Throwable -> L16
        if (r102.installedTime <= r110.getJumpInstallTime()) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L16
        return r102;
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public void remove(String r100) {
        checkExpireTime();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        LinkedList<AppInfo> r101 = this.mApkList;
        monitor-enter(r101);
        Iterator<AppInfo> r102 = this.mApkList.iterator();     // Catch: Throwable -> L17
    L9:
        if (r102.hasNext() == false) goto L15;
        if (r100.equals(r102.next().pkgName) == false) goto L9;
        r102.remove();     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private static boolean isPkgNameFuzzyMatched(String r110, String r111) {
        String[] r112 = r110.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Throwable -> L38
        String[] r113 = r111.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: Throwable -> L38
        if (r112.length != 0) goto L6;
    L37:
        return false;
    L6:
        if (r113.length == 0) goto L37;
        int r100 = r112.length;     // Catch: Throwable -> L38
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r101 >= r100) goto L40;
        String r104 = r112[r101];     // Catch: Throwable -> L38
        String[] r105 = PKG_NAME_FUZZY_MATCH_EXCLUDES;     // Catch: Throwable -> L38
        int r106 = r105.length;     // Catch: Throwable -> L38
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L22;
        String r114 = r105[r107];     // Catch: Throwable -> L38
        if (r114.equals(r104) == true) goto L16;
        r107 = r107 + 1;     // Catch: Throwable -> L38
        goto L12
    L16:
        if (r102 < r113.length) goto L18;
    L20:
        boolean r108 = true;
    L23:
        if (r108 == true) goto L36;
        int r109 = r103;
        int r115 = r102;
    L26:
        if (r102 >= r113.length) goto L35;
        if (r104.equals(r113[r102]) == false) goto L34;
        if (r102 != r115) goto L31;
        r115 = r115 + 1;
    L31:
        r109 = r109 + 1;
        if (r109 < 2) goto L34;
        return true;
    L34:
        r102 = r102 + 1;
        goto L26
    L35:
        r102 = r115;
        r103 = r109;
    L36:
        r101 = r101 + 1;
        goto L9
    L18:
        if (r114.equals(r113[r102]) == false) goto L20;
        r102 = r102 + 1;     // Catch: Throwable -> L38
        goto L20
    L22:
        r108 = false;
    L40:
        return false;
    L38:
        th = move-exception;
        th.printStackTrace();
        goto L40
    }
}
