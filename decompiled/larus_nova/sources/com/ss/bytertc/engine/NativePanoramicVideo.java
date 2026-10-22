package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.Quaternionf;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IPanoramicVideo;

/* JADX INFO: loaded from: classes40.dex */
public class NativePanoramicVideo implements IPanoramicVideo {
    private static final String TAG = "NativePanoramicVideo}";
    private long mNaiveInstance;

    public static native int nativeUpdateQuaternionf(long r100, float r101, float r102, float r103, float r104);

    public void release() {
        this.mNaiveInstance = 0;
    }

    public NativePanoramicVideo(long r100) {
        this.mNaiveInstance = r100;
    }

    @Override // com.ss.bytertc.engine.video.IPanoramicVideo
    public int updateQuaternionf(Quaternionf r100) {
        long r101 = this.mNaiveInstance;
        if (r101 != 0) goto L7;
        LogUtil.e(TAG, "native Panoramic is invalid, updateQuaternionf failed.");
        return -1;
    L7:
        return nativeUpdateQuaternionf(r101, r100.f456206x, r100.f456207y, r100.f456208z, r100.f456205w);
    }
}
