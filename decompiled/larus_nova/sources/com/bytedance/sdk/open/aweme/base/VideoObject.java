package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class VideoObject implements IMediaObject {
    private static final String TAG = "VideoObject";
    public ArrayList<String> mVideoPaths;

    public VideoObject() {
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle r100) {
        r100.putStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_VIDEO_PATH, this.mVideoPaths);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle r100) {
        this.mVideoPaths = r100.getStringArrayList(ParamKeyConstants.AWEME_EXTRA_MEDIA_MESSAGE_VIDEO_PATH);
    }
}
