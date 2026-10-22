package com.bytedance.lynx.service.security.decrypt;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
final class LynxDecryptNative {
    public LynxDecryptNative() {
    }

    public static native ByteBuffer nativeDecompressPayload(byte[] r100, int[] r101);

    public static native ByteBuffer nativeDecompressPayloadBuffer(ByteBuffer r100, int r101, int[] r102);

    public static native ByteBuffer nativeDecryptArtifact(byte[] r100, byte[] r101, byte[] r102, int[] r103);

    public static native ByteBuffer nativeDecryptArtifactBuffer(ByteBuffer r100, int r101, byte[] r102, byte[] r103, int[] r104);

    public static native ByteBuffer nativeDecryptArtifactBufferWithKek(ByteBuffer r100, int r101, byte[] r102, byte[] r103, int[] r104);

    public static native ByteBuffer nativeDecryptArtifactWithKek(byte[] r100, byte[] r101, byte[] r102, int[] r103);

    private static ByteBuffer allocateDirectBufferFromNative(int r100) {
        return ByteBuffer.allocateDirect(r100);
    }
}
