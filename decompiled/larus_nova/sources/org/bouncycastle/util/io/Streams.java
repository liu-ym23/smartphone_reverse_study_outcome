package org.bouncycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes42.dex */
public final class Streams {
    private static int BUFFER_SIZE = 4096;

    public Streams() {
    }

    public static void drain(InputStream r100) throws IOException {
        int r101 = BUFFER_SIZE;
        byte[] r102 = new byte[r101];
    L4:
        if (r100.read(r102, 0, r101) >= 0) goto L4;
    }

    public static void pipeAll(InputStream r100, OutputStream r101) throws IOException {
        int r102 = BUFFER_SIZE;
        byte[] r103 = new byte[r102];
    L3:
        int r104 = r100.read(r103, 0, r102);
        if (r104 < 0) goto L6;
        r101.write(r103, 0, r104);
        goto L3
    }

    public static long pipeAllLimited(InputStream r110, long r111, OutputStream r112) throws IOException {
        int r100 = BUFFER_SIZE;
        byte[] r101 = new byte[r100];
        long r102 = 0;
    L3:
        int r103 = r110.read(r101, 0, r100);
        if (r103 < 0) goto L10;
        long r104 = r103;
        if ((r111 - r102) < r104) goto L9;
        r102 = r102 + r104;
        r112.write(r101, 0, r103);
        goto L3
    L9:
        throw new StreamOverflowException("Data Overflow");
    L10:
        return r102;
    }

    public static byte[] readAll(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        pipeAll(r100, r101);
        return r101.toByteArray();
    }

    public static byte[] readAllLimited(InputStream r100, int r101) throws IOException {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        pipeAllLimited(r100, r101, r102);
        return r102.toByteArray();
    }

    public static int readFully(InputStream r100, byte[] r101) throws IOException {
        return readFully(r100, r101, 0, r101.length);
    }

    public static int readFully(InputStream r100, byte[] r101, int r102, int r103) throws IOException {
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        int r105 = r100.read(r101, r102 + r104, r103 - r104);
        if (r105 < 0) goto L8;
        r104 = r104 + r105;
    L8:
        return r104;
    }

    public static void writeBufTo(ByteArrayOutputStream r100, OutputStream r101) throws IOException {
        r100.writeTo(r101);
    }
}
