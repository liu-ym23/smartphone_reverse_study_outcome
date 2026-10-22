package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public interface BDMediaDataReader {
    public static final int KeyIsGetFileCrc32 = 1;
    public static final int KeyIsGetFileSize = 0;
    public static final int ReadFileEnd = 0;
    public static final int ReadFileError = -1;

    int close(int r100);

    long getValue(int r100, int r101);

    int open(int r100);

    int read(int r100, long r101, byte[] r102, int r103);
}
