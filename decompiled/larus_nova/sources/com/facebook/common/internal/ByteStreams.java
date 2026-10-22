package com.facebook.common.internal;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public final class ByteStreams {
    private static final int BUF_SIZE = 4096;

    /* JADX INFO: renamed from: com.facebook.common.internal.ByteStreams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class FastByteArrayOutputStream extends ByteArrayOutputStream {
        private FastByteArrayOutputStream() {
        }

        public /* synthetic */ FastByteArrayOutputStream(AnonymousClass1 r100) {
            this();
        }

        public void writeTo(byte[] r100, int r101) {
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, r100, r101, ((ByteArrayOutputStream) this).count);
        }
    }

    private ByteStreams() {
    }

    public static byte[] toByteArray(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        copy(r100, r101);
        return r101.toByteArray();
    }

    public static long copy(InputStream r100, OutputStream r101) throws IOException {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        byte[] r102 = new byte[4096];
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

    public static byte[] toByteArray(InputStream r100, int r101) throws IOException {
        byte[] r102 = new byte[r101];
        int r103 = r101;
    L4:
        if (r103 <= 0) goto L10;
        int r104 = r101 - r103;
        int r105 = r100.read(r102, r104, r103);
        if (r105 == (-1)) goto L8;
        r103 = r103 - r105;
        goto L4
    L8:
        return Arrays.copyOf(r102, r104);
    L10:
        int r106 = r100.read();
        if (r106 != (-1)) goto L13;
        return r102;
    L13:
        FastByteArrayOutputStream r107 = new FastByteArrayOutputStream(null);
        r107.write(r106);
        copy(r100, r107);
        byte[] r108 = new byte[r107.size() + r101];
        System.arraycopy(r102, 0, r108, 0, r101);
        r107.writeTo(r108, r101);
        return r108;
    }

    public static int read(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        if (r103 < 0) goto L12;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        int r105 = r100.read(r101, r102 + r104, r103 - r104);
        if (r105 == (-1)) goto L10;
        r104 = r104 + r105;
    L10:
        return r104;
    L12:
        throw new IndexOutOfBoundsException("len is negative");
    }

    public static void readFully(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        int r104 = read(r100, r101, r102, r103);
        if (r104 != r103) goto L6;
        return;
    L6:
        throw new EOFException("reached end of stream after reading " + r104 + " bytes; " + r103 + " bytes expected");
    }
}
