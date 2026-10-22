package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(ByteBuffer r100) {
        return ByteString.wrap(r100);
    }

    public static ByteString unsafeWrap(byte[] r100) {
        return ByteString.wrap(r100);
    }

    public static void unsafeWriteTo(ByteString r100, ByteOutput r101) throws IOException {
        r100.writeTo(r101);
    }

    public static ByteString unsafeWrap(byte[] r100, int r101, int r102) {
        return ByteString.wrap(r100, r101, r102);
    }
}
