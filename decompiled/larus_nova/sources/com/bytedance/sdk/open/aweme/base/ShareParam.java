package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public class ShareParam {
    private static final float DAILY_SCALE_NORMAL = 0.58f;
    public float dailyScale;
    public MusicParamObject musicParamObject;
    public String poiId;
    public int shareDailyBGBaseColor;
    public int shareDailyBGComplementaryColor;
    public String shareDailyBGUrl;
    public String shareDailyH5Path;
    public StickersObject stickersObject;
    public TitleObject titleObject;

    public ShareParam() {
        this.shareDailyBGBaseColor = 0;
        this.shareDailyBGComplementaryColor = 0;
        this.dailyScale = DAILY_SCALE_NORMAL;
    }

    public static ShareParam unserialize(Bundle r100) {
        ShareParam r101 = new ShareParam();
        r101.stickersObject = StickersObject.unSerialize(r100);
        r101.titleObject = TitleObject.unSerialize(r100);
        r101.musicParamObject = MusicParamObject.unSerialize(r100);
        r101.shareDailyH5Path = r100.getString(ParamKeyConstants.ShareParams.SHARE_DAILY_H5_PATH);
        r101.shareDailyBGUrl = r100.getString(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_URL);
        r101.shareDailyBGBaseColor = r100.getInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_BASE_COLOR, 0);
        r101.shareDailyBGComplementaryColor = r100.getInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_COMPLEMENTARY_COLOR, 0);
        r101.poiId = r100.getString(ParamKeyConstants.ShareParams.SHARE_POI_ID);
        r101.dailyScale = r100.getFloat(ParamKeyConstants.ShareParams.SHARE_DAILY_SCALE, DAILY_SCALE_NORMAL);
        return r101;
    }

    public void serialize(Bundle r100) {
        StickersObject r101 = this.stickersObject;
        if (r101 == null) goto L5;
        r101.serialize(r100);
    L5:
        TitleObject r102 = this.titleObject;
        if (r102 == null) goto L8;
        r102.serialize(r100);
    L8:
        MusicParamObject r103 = this.musicParamObject;
        if (r103 == null) goto L11;
        r103.serialize(r100);
    L11:
        String r104 = this.shareDailyH5Path;
        if (r104 == null) goto L14;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_DAILY_H5_PATH, r104);
    L14:
        String r105 = this.shareDailyBGUrl;
        if (r105 == null) goto L17;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_URL, r105);
    L17:
        r100.putInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_BASE_COLOR, this.shareDailyBGBaseColor);
        r100.putInt(ParamKeyConstants.ShareParams.SHARE_DAILY_BG_COMPLEMENTARY_COLOR, this.shareDailyBGComplementaryColor);
        if (TextUtils.isEmpty(this.poiId) == true) goto L20;
        r100.putString(ParamKeyConstants.ShareParams.SHARE_POI_ID, this.poiId);
    L20:
        r100.putFloat(ParamKeyConstants.ShareParams.SHARE_DAILY_SCALE, this.dailyScale);
    }
}
