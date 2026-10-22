package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class MixObject implements IMediaObject {
    public boolean isImageAlbum;
    public ArrayList<String> mMediaPaths;

    public MixObject() {
        this.mMediaPaths = new ArrayList();
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle r100) {
        r100.putStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_MIX_PATH, this.mMediaPaths);
        r100.putString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM, String.valueOf(this.isImageAlbum));
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 6;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle r100) {
        this.mMediaPaths.clear();
        ArrayList<String> r101 = r100.getStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_MIX_PATH);
        if (r101 == null) goto L5;
        this.mMediaPaths = r101;
    L5:
        this.isImageAlbum = Boolean.parseBoolean(r100.getString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM));
    }
}
