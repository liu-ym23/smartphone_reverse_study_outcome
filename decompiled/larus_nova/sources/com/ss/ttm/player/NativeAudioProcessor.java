package com.ss.ttm.player;

import android.util.AndroidRuntimeException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class NativeAudioProcessor extends AudioProcessor {
    protected long mNativeWrapper;

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioClose() {
        throw new AndroidRuntimeException("Should not be here");
    }

    public NativeAudioProcessor() {
        this.mNativeWrapper = 0;
    }

    private long getNativeWrapper() {
        return this.mNativeWrapper;
    }

    public static boolean isNativeAudioProcessor(AudioProcessor r100) {
        return r100 instanceof NativeAudioProcessor;
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioRelease(int r100) {
        throw new AndroidRuntimeException("Should not be here");
    }

    public void setNativeWrapper(long r100) {
        this.mNativeWrapper = r100;
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioProcess(ByteBuffer[] r100, int r101, long r102) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioOpen(int r100, int r101, int r102, int r103) {
        throw new AndroidRuntimeException("Should not be here");
    }
}
