package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public class BDMediaDataReaderBridge {
    public BDMediaDataReaderBridge() {
    }

    public int close(Object r100, int r101) {
        if (r100 == null) goto L7;
        if (r101 >= 0) goto L6;
        return 0;
    L6:
        return ((BDMediaDataReader) r100).close(r101);
    L7:
        return 0;
    }

    public int open(Object r100, int r101) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return ((BDMediaDataReader) r100).open(r101);
    }

    public long getValue(Object r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return ((BDMediaDataReader) r100).getValue(r101, r102);
    }

    public int read(Object r100, int r101, long r102, byte[] r110, int r111) {
        if (r100 == null) goto L8;
        if (r110 == null) goto L10;
        if (r111 != 0) goto L7;
        return 0;
    L7:
        return ((BDMediaDataReader) r100).read(r101, r102, r110, r111);
    L10:
        return 0;
    L8:
        return 0;
    }
}
