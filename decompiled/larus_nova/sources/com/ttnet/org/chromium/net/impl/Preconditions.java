package com.ttnet.org.chromium.net.impl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkDirect(ByteBuffer r100) {
        if (r100.isDirect() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("byteBuffer must be a direct ByteBuffer.");
    }

    public static void checkHasRemaining(ByteBuffer r100) {
        if (r100.hasRemaining() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer is already full.");
    }
}
