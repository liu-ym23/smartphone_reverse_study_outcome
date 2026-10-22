package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public class MusicObject implements IMediaObject {
    private static final String TAG = "ImageObject";
    public String mMusicId;

    public MusicObject() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString(ParamKeyConstants.AWEME_EXTRA_LUNA_MUSIC_ID, this.mMusicId);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 7;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle r100) {
        this.mMusicId = r100.getString(ParamKeyConstants.AWEME_EXTRA_LUNA_MUSIC_ID);
    }
}
