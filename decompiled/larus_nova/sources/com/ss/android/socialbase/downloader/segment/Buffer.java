package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes38.dex */
public final class Buffer {
    public final byte[] data;
    public Buffer next;
    IOutput output;
    public int size;

    public Buffer(int r100) {
        this.data = new byte[r100];
    }
}
