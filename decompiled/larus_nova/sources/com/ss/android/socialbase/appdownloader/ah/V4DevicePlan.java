package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public class V4DevicePlan extends AbsDevicePlan {
    public static final int SAVE_PATH_IN_EXTERNAL_PRIMARY = 2;
    public static final int SAVE_PATH_IN_EXTERNAL_PUBIC = 1;
    public static final int SAVE_PATH_NOT_MATCH = 0;
    private static final String TAG = "V4DevicePlan";
    public static String V4_REQUIRE_PATH_1;
    public static String V4_REQUIRE_PATH_2;

    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String r100 = this.mSetting.optString("s");
        String r101 = DecryptUtils.decrypt(this.mSetting.optString("bq"), r100);
        String r102 = DecryptUtils.decrypt(this.mSetting.optString("bp_1"), r100);
        String r103 = DecryptUtils.decrypt(this.mSetting.optString("bp_2"), r100);
        int r104 = checkSavePathLocation(this.mJumpPath);
        String r105 = "";
        if (r104 != 1) goto L12;
        r105 = this.mJumpPath.replace(V4_REQUIRE_PATH_1, "");     // Catch: Exception -> L9
        if (r105.startsWith(HTTP.URL_DEFAULT) == false) goto L7;
        r105 = r105.substring(1);     // Catch: Exception -> L9
    L7:
        String r106 = r105.replace(HTTP.URL_DEFAULT, "%2f");     // Catch: Exception -> L9
    L10:
        Uri r107 = UriProtector.parse(r102 + r106);
    L26:
        Intent r108 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r108.setDataAndType(r107, r101);
        r108.addFlags(268435456);
        r108.addFlags(32768);
        r108.addFlags(1073741824);
        return r108;
    L9:
        r106 = r105;
        goto L10
    L12:
        if (r104 != 2) goto L25;
        String r109 = V4_REQUIRE_PATH_2;
        if (r109 == null) goto L25;
        String[] r110 = this.mJumpPath.replace(r109, "").split(HTTP.URL_DEFAULT);
        if (TextUtils.isEmpty(r103) == true) goto L25;
        StringBuilder r111 = new StringBuilder(r103);
        int r112 = r110.length;
        int r113 = 0;
    L18:
        if (r113 >= r112) goto L24;
        String r114 = r110[r113];
        if (r114.length() == 0) goto L23;
        r111.append("%2F");
        r111.append(r114);
    L23:
        r113 = r113 + 1;
        goto L18
    L24:
        r107 = UriProtector.parse(r111.toString());
    L25:
        r107 = null;
        goto L26
    }

    static {
        V4_REQUIRE_PATH_1 = DownloadDirUtils.getExtPublicDownloadPath();     // Catch: Throwable -> L4
        V4_REQUIRE_PATH_2 = DownloadDirUtils.getExternalStorageDirectory(false).getAbsolutePath() + "/Android/data";     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "init", "Error:" + th);
    }

    private static int checkSavePathLocation(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        String r101 = V4_REQUIRE_PATH_1;
        if (r101 != null) goto L8;
    L11:
        String r102 = V4_REQUIRE_PATH_2;
        if (r102 != null) goto L14;
    L17:
        return 0;
    L14:
        if (r100.startsWith(r102) == false) goto L17;
        return 2;
    L8:
        if (r100.startsWith(r101) == false) goto L11;
        return 1;
    }

    public static boolean isSavePathCorrect(DownloadInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        DownloadFile r101 = new DownloadFile(r100.getSavePath(), r100.getName());
        if (r101.getFile() != null) goto L8;
        return false;
    L8:
        File r102 = r101.getFile().getParentFile();
        if (r102 != null) goto L11;
        return false;
    L11:
        String r103 = r102.getAbsolutePath();
        if (TextUtils.isEmpty(r103) == false) goto L15;
        return false;
    L15:
        if (checkSavePathLocation(r103) <= 0) goto L18;
        return true;
    L18:
        return false;
    }

    public V4DevicePlan(Context r100, DownloadSetting r101, String r102) {
        super(r100, r101, r102);
    }
}
