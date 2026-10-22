package com.ss.bduploader;

/* JADX INFO: loaded from: classes40.dex */
public interface BDMultiExternalFileReader {
    void closeFileWithIndex(int r100);

    long multiGetValue(int r100, int r101);

    int openFileWithIndex(int r100);

    int readSliceByOffset(long r100, byte[] r101, int r102, int r103, int r104);
}
