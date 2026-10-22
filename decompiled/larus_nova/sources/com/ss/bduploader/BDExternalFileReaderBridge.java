package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public class BDExternalFileReaderBridge {
    private static final String TAG = "ttmn";

    public BDExternalFileReaderBridge() {
    }

    public void cancel(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((BDExternalFileReader) r100).cancel();
    }

    public void closeFileWithIndex(Object r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((BDMultiExternalFileReader) r100).closeFileWithIndex(r101);
    }

    public long getValue(Object r100, int r101) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return ((BDExternalFileReader) r100).getValue(r101);
    }

    public int openFileWithIndex(Object r100, int r101) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return ((BDMultiExternalFileReader) r100).openFileWithIndex(r101);
    }

    public long getCrc32ByOffset(Object r100, long r101, int r102) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return ((BDExternalFileReader) r100).getCrc32ByOffset(r101, r102);
    }

    public long multiGetValue(Object r100, int r101, int r102) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return ((BDMultiExternalFileReader) r100).multiGetValue(r101, r102);
    }

    public int readSlice(Object r100, int r101, byte[] r102, int r103) {
        if (r100 == null) goto L8;
        if (r102 == null) goto L10;
        if (r103 != 0) goto L7;
        return 0;
    L7:
        return ((BDExternalFileReader) r100).readSlice(r101, r102, r103);
    L10:
        return 0;
    L8:
        return 0;
    }

    public int readSliceByOffset(Object r100, long r101, byte[] r110, int r111, int r112) {
        if (r100 == null) goto L8;
        if (r110 == null) goto L10;
        if (r111 != 0) goto L7;
        return 0;
    L7:
        return ((BDExternalFileReader) r100).readSliceByOffset(r101, r110, r111, r112);
    L10:
        return 0;
    L8:
        return 0;
    }

    public int multiReadSliceByOffset(Object r100, long r101, byte[] r110, int r111, int r112, int r113) {
        if (r100 == null) goto L9;
        if (r110 == null) goto L11;
        if (r112 == 0) goto L12;
        if (r111 >= 0) goto L8;
        return 0;
    L8:
        return ((BDMultiExternalFileReader) r100).readSliceByOffset(r101, r110, r111, r112, r113);
    L12:
        return 0;
    L11:
        return 0;
    L9:
        return 0;
    }
}
