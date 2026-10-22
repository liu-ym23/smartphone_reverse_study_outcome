package com.bytedance.android.livesdk.livecommerce.livereplay.repository;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/repository/NetState;", "", "SUCCESS", "ERROR", "PAGE_TIMESTAMP_EMPTY", "COUNT_EMPTY", "PAGE_SIZE_ERROR", "REPLAY_CARDS_EMPTY", "LOAD_MORE_ERROR", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum NetState extends Enum<NetState> {
    public static final NetState COUNT_EMPTY = null;
    public static final NetState ERROR = null;
    public static final NetState LOAD_MORE_ERROR = null;
    public static final NetState PAGE_SIZE_ERROR = null;
    public static final NetState PAGE_TIMESTAMP_EMPTY = null;
    public static final NetState REPLAY_CARDS_EMPTY = null;
    public static final NetState SUCCESS = null;
    public static final /* synthetic */ NetState[] a = null;

    static {
        NetState r1 = new NetState("SUCCESS", 0);
        SUCCESS = r1;
        NetState r2 = new NetState("ERROR", 1);
        ERROR = r2;
        NetState r3 = new NetState("PAGE_TIMESTAMP_EMPTY", 2);
        PAGE_TIMESTAMP_EMPTY = r3;
        NetState r4 = new NetState("COUNT_EMPTY", 3);
        COUNT_EMPTY = r4;
        NetState r5 = new NetState("PAGE_SIZE_ERROR", 4);
        PAGE_SIZE_ERROR = r5;
        NetState r6 = new NetState("REPLAY_CARDS_EMPTY", 5);
        REPLAY_CARDS_EMPTY = r6;
        NetState r7 = new NetState("LOAD_MORE_ERROR", 6);
        LOAD_MORE_ERROR = r7;
        a = new NetState[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static NetState valueOf(String r1) {
        return (NetState) r27.a.a(NetState.class, r1);
    }

    public static NetState[] values() {
        return (NetState[]) a.clone();
    }

    public NetState(String r1, int r2) {
        super(r1, r2);
    }
}
