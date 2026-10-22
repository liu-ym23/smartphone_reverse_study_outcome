package com.bytedance.lark.sdk;

import com.bytedance.lark.pb.basic.v1.RequestPacket;

/* JADX INFO: loaded from: classes20.dex */
public final enum StreamDataSource extends Enum<StreamDataSource> {
    public static final StreamDataSource DEFAULT_SMART = null;
    public static final StreamDataSource ONCE_LOCAL = null;
    public static final StreamDataSource ONCE_NET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StreamDataSource[] f254117a = null;
    private int value;

    static {
        StreamDataSource r100 = new StreamDataSource("DEFAULT_SMART", 0, 1);
        DEFAULT_SMART = r100;
        StreamDataSource r101 = new StreamDataSource("ONCE_LOCAL", 1, 2);
        ONCE_LOCAL = r101;
        StreamDataSource r102 = new StreamDataSource("ONCE_NET", 2, 3);
        ONCE_NET = r102;
        f254117a = new StreamDataSource[]{r100, r101, r102};
    }

    public static StreamDataSource[] values() {
        return (StreamDataSource[]) f254117a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static RequestPacket.BizConfig.DataSource forNumber(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return RequestPacket.BizConfig.DataSource.DEFAULT;
    L11:
        return RequestPacket.BizConfig.DataSource.PREFERRED_ONLINE;
    L13:
        return RequestPacket.BizConfig.DataSource.LOCAL;
    L15:
        return RequestPacket.BizConfig.DataSource.DEFAULT;
    }

    public static StreamDataSource valueOf(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return DEFAULT_SMART;
    L11:
        return ONCE_NET;
    L13:
        return ONCE_LOCAL;
    L15:
        return DEFAULT_SMART;
    }

    public static StreamDataSource valueOf(String r100) {
        return (StreamDataSource) r27.a.a(StreamDataSource.class, r100);
    }

    public StreamDataSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
