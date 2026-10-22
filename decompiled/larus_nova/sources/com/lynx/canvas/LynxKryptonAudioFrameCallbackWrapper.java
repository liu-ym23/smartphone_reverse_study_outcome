package com.lynx.canvas;

import com.lynx.canvas.callback.AudioFrameCallback;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonAudioFrameCallback;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes32.dex */
class LynxKryptonAudioFrameCallbackWrapper implements AudioFrameCallback {
    private final LynxKryptonAudioFrameCallback mCallback;

    public LynxKryptonAudioFrameCallbackWrapper(LynxKryptonAudioFrameCallback r100) {
        Objects.requireNonNull(r100, "callback");
        this.mCallback = r100;
    }

    @Override // com.lynx.canvas.callback.AudioFrameCallback
    public void onAudioFrame(ByteBuffer r100, int r110, int r111, int r112, int r113, long r114) {
        this.mCallback.onAudioFrame(r100, r110, r111, r112, r113, r114);
    }
}
