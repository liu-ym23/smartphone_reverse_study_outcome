package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* JADX INFO: loaded from: classes22.dex */
public class MediaContent {
    private static final String TAG = "AWEME.SDK.MediaContent";
    public IMediaObject mMediaObject;

    public static class Builder {
        public static final String KEY_IDENTIFIER = "_dyobject_identifier_";

        public Builder() {
        }

        public static MediaContent fromBundle(Bundle r100) {
            MediaContent r101 = new MediaContent();
            int r102 = r100.getInt(ParamKeyConstants.BaseParams.MEDIA_CONTENT_TYPE);
            if (r102 != 2) goto L6;
            IMediaObject r103 = new ImageObject();
        L21:
            if (r103 == null) goto L23;
            r103.unserialize(r100);
        L23:
            r101.mMediaObject = r103;
            return r101;
        L6:
            if (r102 != 3) goto L9;
            r103 = new VideoObject();
            goto L21
        L9:
            if (r102 != 6) goto L12;
            r103 = new MixObject();
            goto L21
        L12:
            if (r102 != 7) goto L15;
            r103 = new MusicObject();
            goto L21
        L15:
            if (r102 != 8) goto L18;
            r103 = new AwemeObject();
            goto L21
        L18:
            if (r102 != 9) goto L20;
            r103 = new MicroAppObject();
            goto L21
        L20:
            r103 = null;
            goto L21
        }

        public static Bundle toBundle(MediaContent r100) {
            Bundle r101 = new Bundle();
            if (r100.mMediaObject == null) goto L5;
            r101.putInt(ParamKeyConstants.BaseParams.MEDIA_CONTENT_TYPE, r100.getType());
            r101.putInt(ParamKeyConstants.BaseParams.MEDIA_CONTENT_VERSION, 2);
            r100.mMediaObject.serialize(r101);
        L5:
            return r101;
        }
    }

    public MediaContent() {
    }

    public MediaContent(IMediaObject r100) {
        this.mMediaObject = r100;
    }

    public final boolean checkArgs() {
        return this.mMediaObject.checkArgs();
    }

    public final int getType() {
        IMediaObject r100 = this.mMediaObject;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.type();
    }
}
