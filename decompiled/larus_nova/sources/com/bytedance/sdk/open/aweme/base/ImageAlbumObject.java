package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class ImageAlbumObject extends ImageObject {
    private boolean isImageAlbum;

    public ImageAlbumObject() {
    }

    public ImageAlbumObject(ArrayList<String> r100) {
        super(r100);
    }

    public ImageAlbumObject(ArrayList<String> r100, boolean r101) {
        this(r100);
        this.isImageAlbum = r101;
    }

    public final boolean isImageAlbum() {
        return this.isImageAlbum;
    }

    @Override // com.bytedance.sdk.open.aweme.base.ImageObject, com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle r100) {
        super.serialize(r100);
        r100.putString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM, String.valueOf(this.isImageAlbum));
    }

    public final void setImageAlbum(boolean r100) {
        this.isImageAlbum = r100;
    }

    @Override // com.bytedance.sdk.open.aweme.base.ImageObject, com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle r100) {
        super.unserialize(r100);
        this.isImageAlbum = Boolean.parseBoolean(r100.getString(ParamKeyConstants.ShareParams.SHARE_IMAGE_ALBUM));
    }
}
