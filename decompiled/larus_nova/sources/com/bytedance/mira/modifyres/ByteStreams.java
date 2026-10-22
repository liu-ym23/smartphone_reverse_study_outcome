package com.bytedance.mira.modifyres;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes21.dex */
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    public static byte[] createBuffer() {
        return new byte[8192];
    }

    private ByteStreams() {
    }

    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public static long copy(ReadableByteChannel r110, WritableByteChannel r111) throws IOException {
        checkNotNull(r110);
        checkNotNull(r111);
        long r100 = 0;
        if ((r110 instanceof FileChannel) == false) goto L11;
        FileChannel r101 = (FileChannel) r110;
        long r102 = r101.position();
        long r112 = r102;
    L5:
        long r103 = r101.transferTo(r112, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, r111);
        r112 = r112 + r103;
        r101.position(r112);
        if (r103 > 0) goto L5;
        if (r112 < r101.size()) goto L5;
        return r112 - r102;
    L11:
        ByteBuffer r104 = ByteBuffer.wrap(createBuffer());
    L13:
        if (r110.read(r104) == (-1)) goto L19;
        r104.flip();
    L16:
        if (r104.hasRemaining() == false) goto L18;
        r100 = r100 + ((long) r111.write(r104));
        goto L16
    L18:
        r104.clear();
        goto L13
    L19:
        return r100;
    }

    public static void readFully(InputStream r100, byte[] r101) throws IOException {
        readFully(r100, r101, 0, r101.length);
    }

    public static long copy(InputStream r100, OutputStream r101) throws IOException {
        checkNotNull(r100);
        checkNotNull(r101);
        byte[] r102 = createBuffer();
        long r103 = 0;
    L3:
        int r104 = r100.read(r102);
        if (r104 == (-1)) goto L5;
        r101.write(r102, 0, r104);
        r103 = r103 + ((long) r104);
        goto L3
    L5:
        return r103;
    }

    public static void checkPositionIndexes(int r100, int r101, int r102) {
        if (r100 < 0) goto L7;
        if (r101 < r100) goto L7;
        if (r101 > r102) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException("" + r100 + "" + r101 + "" + r102);
    }

    public static int read(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        checkNotNull(r100);
        checkNotNull(r101);
        int r104 = 0;
        if (r103 < 0) goto L12;
        checkPositionIndexes(r102, r102 + r103, r101.length);
    L5:
        if (r104 >= r103) goto L10;
        int r105 = r100.read(r101, r102 + r104, r103 - r104);
        if (r105 == (-1)) goto L10;
        r104 = r104 + r105;
    L10:
        return r104;
    L12:
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(r103)}));
    }

    public static void readFully(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        int r104 = read(r100, r101, r102, r103);
        if (r104 != r103) goto L6;
        return;
    L6:
        throw new EOFException("reached end of stream after reading " + r104 + " bytes; " + r103 + " bytes expected");
    }
}
