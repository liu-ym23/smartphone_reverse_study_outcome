package com.lynx.canvas.callback;

import com.lynx.canvas.KryptonLLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes32.dex */
public class AudioFrameCallbackWrapper implements AudioFrameCallback {
    private static final String TAG = "AudioFrameCallbackWrapper";
    private final AudioFrameCallback mCallback;

    public AudioFrameCallbackWrapper(AudioFrameCallback r100) {
        this.mCallback = r100;
    }

    @Override // com.lynx.canvas.callback.AudioFrameCallback
    public void onAudioFrame(ByteBuffer r110, int r111, int r112, int r113, int r114, long r115) {
        if (this.mCallback != null) goto L5;
        return;
    L5:
        if (r111 != 0) goto L7;
        return;
    L7:
        ByteBuffer r100 = r110.duplicate().order(ByteOrder.nativeOrder());
        int r101 = r100.capacity();
        if (r111 < 0) goto L13;
        if (r111 > r101) goto L13;
        r100.position(0);
        r100.limit(r111);
        this.mCallback.onAudioFrame(r100, r111, r112, r113, r114, r115);
        return;
    L13:
        KryptonLLog.e(TAG, "invalid audio frame byteLength=" + r111 + ", capacity=" + r101);
    }
}
