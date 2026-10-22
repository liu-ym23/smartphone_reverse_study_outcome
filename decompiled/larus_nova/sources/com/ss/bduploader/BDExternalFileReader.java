package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public interface BDExternalFileReader {
    public static final int KeyIsGetAvailableFileSize = 4;
    public static final int KeyIsGetFileSize = 0;
    public static final int KeyIsGetHeaderSize = 2;
    public static final int KeyIsGetOffset = 1;
    public static final int ReadSliceEnd = 0;
    public static final int ReadSliceError = -1;
    public static final int ReadSliceErrorIsCancel = -2;

    void cancel();

    long getCrc32ByOffset(long r100, int r101);

    long getValue(int r100);

    int readSlice(int r100, byte[] r101, int r102);

    int readSliceByOffset(long r100, byte[] r101, int r102, int r103);
}
