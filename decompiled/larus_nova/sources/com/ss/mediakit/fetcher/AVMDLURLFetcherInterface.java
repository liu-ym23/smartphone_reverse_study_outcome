package com.ss.mediakit.fetcher;

/* JADX INFO: loaded from: classes40.dex */
public interface AVMDLURLFetcherInterface {
    void close();

    String[] getURLs();

    int start(String r100, String r101, String r102, AVMDLURLFetcherListener r103);
}
