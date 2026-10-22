package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class ImageObject implements IMediaObject {
    private static final String TAG = "ImageObject";
    public ArrayList<String> mImagePaths;

    public ImageObject() {
    }

    public ImageObject(ArrayList<String> r100) {
        ArrayList<String> r101 = new ArrayList();
        this.mImagePaths = r101;
        r101.addAll(r100);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle r100) {
        r100.putStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_IMAGE_PATH, this.mImagePaths);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 2;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle r100) {
        this.mImagePaths = r100.getStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_IMAGE_PATH);
    }
}
