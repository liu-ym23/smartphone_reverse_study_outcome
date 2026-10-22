package com.ttnet.org.chromium.net.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
final class InputStreamChannel implements ReadableByteChannel {
    private static final int MAX_TMP_BUFFER_SIZE = 16384;
    private static final int MIN_TMP_BUFFER_SIZE = 4096;
    private final InputStream mInputStream;
    private final AtomicBoolean mIsOpen;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mIsOpen.compareAndSet(true, false) == false) goto L6;
        this.mInputStream.close();
        return;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    private InputStreamChannel(InputStream r100) {
        this.mIsOpen = new AtomicBoolean(true);
        this.mInputStream = r100;
    }

    public static ReadableByteChannel wrap(InputStream r100) {
        if ((r100 instanceof FileInputStream) == false) goto L7;
        return ((FileInputStream) r100).getChannel();
    L7:
        return new InputStreamChannel(r100);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r100) throws IOException {
        if (r100.hasArray() == false) goto L7;
        int r101 = this.mInputStream.read(r100.array(), r100.arrayOffset() + r100.position(), r100.remaining());
        if (r101 <= 0) goto L12;
        r100.position(r100.position() + r101);
        return r101;
    L12:
        return r101;
    L7:
        byte[] r102 = new byte[Math.min(16384, Math.min(Math.max(this.mInputStream.available(), 4096), r100.remaining()))];
        int r103 = this.mInputStream.read(r102);
        if (r103 <= 0) goto L11;
        r100.put(r102, 0, r103);
    L11:
        return r103;
    }
}
