package com.ss.android.socialbase.appdownloader.util.package_info;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes38.dex */
public class IntReader {
    private boolean m_bigEndian;
    private int m_position;
    private InputStream m_stream;

    public final int readByte() throws IOException {
        return readInt(1);
    }

    public final int readInt() throws IOException {
        return readInt(4);
    }

    public final int readShort() throws IOException {
        return readInt(2);
    }

    public final void skipInt() throws IOException {
        skip(4);
    }

    public final int available() throws IOException {
        return this.m_stream.available();
    }

    public final void close() {
        InputStream r100 = this.m_stream;
        if (r100 == null) goto L10;
        r100.close();     // Catch: IOException -> L7
    L5:
        reset(null, false);
        return;
    }

    public IntReader() {
    }

    public final int getPosition() {
        return this.m_position;
    }

    public final InputStream getStream() {
        return this.m_stream;
    }

    public final boolean isBigEndian() {
        return this.m_bigEndian;
    }

    public final byte[] readByteArray(int r100) throws IOException {
        byte[] r101 = new byte[r100];
        int r102 = this.m_stream.read(r101);
        this.m_position += r102;
        if (r102 != r100) goto L6;
        return r101;
    L6:
        throw new EOFException();
    }

    public final int readInt(int r100) throws IOException {
        if (r100 < 0) goto L24;
        if (r100 > 4) goto L24;
        int r101 = 0;
        if (this.m_bigEndian == false) goto L14;
        int r102 = (r100 - 1) * 8;
    L8:
        if (r102 < 0) goto L29;
        int r103 = this.m_stream.read();
        if (r103 == (-1)) goto L13;
        this.m_position++;
        r101 = r101 | (r103 << r102);
        r102 = r102 - 8;
        goto L8
    L13:
        throw new EOFException();
    L29:
        return r101;
    L14:
        int r104 = r100 * 8;
        int r105 = 0;
    L15:
        if (r101 == r104) goto L22;
        int r106 = this.m_stream.read();
        if (r106 == (-1)) goto L20;
        this.m_position++;
        r105 = r105 | (r106 << r101);
        r101 = r101 + 8;
        goto L15
    L20:
        throw new EOFException();
    L22:
        return r105;
    L24:
        throw new IllegalArgumentException();
    }

    public final int[] readIntArray(int r100) throws IOException {
        int[] r101 = new int[r100];
        readIntArray(r101, 0, r100);
        return r101;
    }

    public final void setBigEndian(boolean r100) {
        this.m_bigEndian = r100;
    }

    public final void skip(int r100) throws IOException {
        if (r100 <= 0) goto L8;
        long r101 = r100;
        long r102 = this.m_stream.skip(r101);
        this.m_position = (int) (((long) this.m_position) + r102);
        if (r102 != r101) goto L7;
        return;
    L7:
        throw new EOFException();
    }

    public IntReader(InputStream r100, boolean r101) {
        reset(r100, r101);
    }

    public final void reset(InputStream r100, boolean r101) {
        this.m_stream = r100;
        this.m_bigEndian = r101;
        this.m_position = 0;
    }

    public final void readIntArray(int[] r100, int r101, int r102) throws IOException {
    L2:
        if (r102 <= 0) goto L4;
        r100[r101] = readInt();
        r102 = r102 - 1;
        r101 = r101 + 1;
        goto L2
    }
}
