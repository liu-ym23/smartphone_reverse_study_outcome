package com.ss.android.lark.chat.core.model;

/* JADX INFO: loaded from: classes35.dex */
public final enum ChannelDataFetcherStrategy extends Enum<ChannelDataFetcherStrategy> {
    public static final ChannelDataFetcherStrategy IGNORE_LOCAL_DATA = null;
    public static final ChannelDataFetcherStrategy RETURN_LOCAL_DATA = null;
    public static final ChannelDataFetcherStrategy SYNC_SERVER_DATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChannelDataFetcherStrategy[] f414749a = null;
    private int value;

    static {
        ChannelDataFetcherStrategy r100 = new ChannelDataFetcherStrategy("IGNORE_LOCAL_DATA", 0, 1);
        IGNORE_LOCAL_DATA = r100;
        ChannelDataFetcherStrategy r101 = new ChannelDataFetcherStrategy("RETURN_LOCAL_DATA", 1, 2);
        RETURN_LOCAL_DATA = r101;
        ChannelDataFetcherStrategy r102 = new ChannelDataFetcherStrategy("SYNC_SERVER_DATA", 2, 3);
        SYNC_SERVER_DATA = r102;
        f414749a = new ChannelDataFetcherStrategy[]{r100, r101, r102};
    }

    public static ChannelDataFetcherStrategy[] values() {
        return (ChannelDataFetcherStrategy[]) f414749a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static ChannelDataFetcherStrategy fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return SYNC_SERVER_DATA;
    L11:
        return SYNC_SERVER_DATA;
    L13:
        return RETURN_LOCAL_DATA;
    L15:
        return IGNORE_LOCAL_DATA;
    }

    public static ChannelDataFetcherStrategy valueOf(String r100) {
        return (ChannelDataFetcherStrategy) r27.a.a(ChannelDataFetcherStrategy.class, r100);
    }

    public ChannelDataFetcherStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
