package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public class MusicParamObject {
    public String musicId;
    public int start;

    public MusicParamObject() {
        this.musicId = "";
        this.start = 0;
    }

    public static MusicParamObject unSerialize(Bundle r100) {
        MusicParamObject r101 = new MusicParamObject();
        r101.musicId = r100.getString(ParamKeyConstants.ShareParams.SHARE_MUSIC_ID, "");
        r101.start = r100.getInt(ParamKeyConstants.ShareParams.SHARE_MUSIC_START, 0);
        return r101;
    }

    public void serialize(Bundle r100) {
        r100.putString(ParamKeyConstants.ShareParams.SHARE_MUSIC_ID, this.musicId);
        r100.putInt(ParamKeyConstants.ShareParams.SHARE_MUSIC_START, this.start);
    }
}
