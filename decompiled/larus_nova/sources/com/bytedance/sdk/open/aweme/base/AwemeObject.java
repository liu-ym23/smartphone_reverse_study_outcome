package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public class AwemeObject implements IMediaObject {
    public String videoId;

    public AwemeObject() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString(ParamKeyConstants.ShareParams.SHARE_AWEME_VIDEO_ID, this.videoId);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 8;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle r100) {
        this.videoId = r100.getString(ParamKeyConstants.ShareParams.SHARE_AWEME_VIDEO_ID);
    }
}
