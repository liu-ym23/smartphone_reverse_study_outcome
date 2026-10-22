package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes38.dex */
public class ExtDataInput extends DataInputDelegate {
    public void skipInt() throws IOException {
        skipBytes(4);
    }

    public void skipShort() throws IOException {
        skipBytes(2);
    }

    public ExtDataInput(InputStream r100) {
        this(new DataInputStream(r100));
    }

    public int[] readIntArray(int r100) throws IOException {
        int[] r101 = new int[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = readInt();
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.DataInputDelegate, java.io.DataInput
    public final int skipBytes(int r100) throws IOException {
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L7;
        int r102 = super.skipBytes(r100 - r101);
        if (r102 <= 0) goto L7;
        r101 = r101 + r102;
    L7:
        return r101;
    }

    public void skipCheckByte(byte r100) throws IOException {
        byte r101 = readByte();
        if (r101 != r100) goto L6;
        return;
    L6:
        throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{Byte.valueOf(r100), Byte.valueOf(r101)}));
    }

    public void skipCheckShort(short r100) throws IOException {
        short r101 = readShort();
        if (r101 != r100) goto L6;
        return;
    L6:
        throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{Short.valueOf(r100), Short.valueOf(r101)}));
    }

    public ExtDataInput(DataInput r100) {
        super(r100);
    }

    public String readNullEndedString(int r100, boolean r101) throws IOException {
        StringBuilder r102 = new StringBuilder(16);
    L3:
        int r103 = r100 - 1;
        if (r100 == 0) goto L9;
        short r104 = readShort();
        if (r104 == 0) goto L9;
        r102.append((char) r104);
        r100 = r103;
    L9:
        if (r101 == false) goto L12;
        skipBytes(r103 * 2);
    L12:
        return r102.toString();
    }
}
