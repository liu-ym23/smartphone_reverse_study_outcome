package com.ss.android.lark.chat.core.model;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends PageLoader.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MessageFetchScene f414776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChannelDataFetcherStrategy f414777d;

    public c(PageLoader.c r100, int r101) {
        super(r100, r101);
        this.f414777d = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
    }

    public c(int r100, int r101, MessageFetchScene r102, ChannelDataFetcherStrategy r103) {
        super(r100, r101);
        this.f414777d = ChannelDataFetcherStrategy.SYNC_SERVER_DATA;
        this.f414776c = r102;
        this.f414777d = r103;
    }
}
