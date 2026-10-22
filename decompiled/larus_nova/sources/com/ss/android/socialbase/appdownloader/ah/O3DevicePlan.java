package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class O3DevicePlan extends AbsDevicePlan {
    private String mApkName;
    private String mContentUri;

    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String r100 = this.mSetting.optString("s");
        String r101 = DecryptUtils.decrypt(this.mSetting.optString("ak"), r100);
        String r102 = DecryptUtils.decrypt(this.mSetting.optString("am"), r100);
        String r103 = DecryptUtils.decrypt(this.mSetting.optString(a.f25763u), r100);
        String r104 = null;
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L27:
        return null;
    L5:
        if (r103.split(",").length != 2) goto L27;
        String[] r105 = r103.split(",");
        String r106 = DecryptUtils.decrypt(this.mSetting.optString("al"), r100);
        String r107 = DecryptUtils.decrypt(this.mSetting.optString("ao"), r100);
        if (TextUtils.isEmpty(r107) == true) goto L27;
        if (r107.split(",").length != 2) goto L27;
        String[] r108 = r107.split(",");
        JSONObject r109 = this.mSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (r109 == null) goto L25;
        String r110 = r109.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (TextUtils.isEmpty(r110) == false) goto L17;
    L21:
        String r111 = this.mApkName;
    L22:
        r104 = r111;
        if (r104.length() <= 255) goto L25;
        r104 = r106.substring(r104.length() - 255);
        goto L25
    L17:
        if (r110.contains("%s") == false) goto L21;
        r111 = String.format(r110, new Object[]{this.mApkName});     // Catch: Throwable -> L20
    L20:
        r111 = this.mApkName;
    L25:
        Intent r112 = new Intent(r101);
        r112.putExtra(r108[0], r108[1]);
        r112.putExtra(r102, this.mContentUri);
        r112.putExtra(r106, r104);
        r112.putExtra(r105[0], CastIntegerProtector.parseInt(r105[1]));
        r112.addFlags(268468224);
        return r112;
    }

    public O3DevicePlan(Context r100, DownloadSetting r101, String r102, String r103, String r104) {
        super(r100, r101, r102);
        this.mContentUri = r103;
        this.mApkName = r104;
    }
}
