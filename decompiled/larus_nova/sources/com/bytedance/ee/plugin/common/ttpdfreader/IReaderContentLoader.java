package com.bytedance.ee.plugin.common.ttpdfreader;

/* JADX INFO: loaded from: classes19.dex */
public interface IReaderContentLoader {
    long getTotalSize();

    int load(int r100, byte[] r101, int r102);
}
