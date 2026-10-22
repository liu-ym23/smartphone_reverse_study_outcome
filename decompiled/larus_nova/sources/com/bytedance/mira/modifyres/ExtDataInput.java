package com.bytedance.mira.modifyres;

import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public class ExtDataInput extends DataInputDelegate {
    public void skipInt() throws IOException {
        skipBytes(4);
    }

    public long getCount() {
        return this.mDelegate.getInputStream().getCount();
    }

    public ExtDataInput(LittleEndianDataInputStream r100) {
        super(r100);
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

    @Override // com.bytedance.mira.modifyres.DataInputDelegate, java.io.DataInput
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

    public void skipCheckChunkTypeInt(int r100, int r101) throws IOException {
        int r102 = readInt();
        if (r102 == r101) goto L10;
        if (r102 < r100) goto L10;
        if (r102 != r100) goto L9;
        return;
    L9:
        throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{Integer.valueOf(r100), Integer.valueOf(r102)}));
    L10:
        skipCheckChunkTypeInt(r100, -1);
    }

    public void skipCheckInt(int r100, int r101) throws IOException {
        int r102 = readInt();
        if (r102 == r100) goto L8;
        if (r102 != r101) goto L7;
        return;
    L7:
        throw new IOException(String.format("Expected: 0x%08x or 0x%08x, got: 0x%08x", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102)}));
    }
}
