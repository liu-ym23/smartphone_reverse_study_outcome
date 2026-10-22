package com.bytedance.android.shopping.card_list.monitor.firstScreen;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/card_list/monitor/firstScreen/CardListFirstScreenPoint;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "START", "REQUEST_START", "QUERY_NET_START", "QUERY_NET_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "REQUEST_END", "RENDER_START", "RENDER_END", "END", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardListFirstScreenPoint extends Enum<CardListFirstScreenPoint> {
    public static final CardListFirstScreenPoint END = null;
    public static final CardListFirstScreenPoint PARSE_RESPONSE_END = null;
    public static final CardListFirstScreenPoint PARSE_RESPONSE_START = null;
    public static final CardListFirstScreenPoint QUERY_NET_END = null;
    public static final CardListFirstScreenPoint QUERY_NET_START = null;
    public static final CardListFirstScreenPoint RENDER_END = null;
    public static final CardListFirstScreenPoint RENDER_START = null;
    public static final CardListFirstScreenPoint REQUEST_END = null;
    public static final CardListFirstScreenPoint REQUEST_START = null;
    public static final CardListFirstScreenPoint START = null;
    public static final /* synthetic */ CardListFirstScreenPoint[] a = null;
    private final String value;

    public static CardListFirstScreenPoint valueOf(String r1) {
        return (CardListFirstScreenPoint) r27.a.a(CardListFirstScreenPoint.class, r1);
    }

    public static CardListFirstScreenPoint[] values() {
        return (CardListFirstScreenPoint[]) a.clone();
    }

    static {
        CardListFirstScreenPoint r1 = new CardListFirstScreenPoint("START", 0, "initial");
        START = r1;
        CardListFirstScreenPoint r2 = new CardListFirstScreenPoint("REQUEST_START", 1, "request_start");
        REQUEST_START = r2;
        CardListFirstScreenPoint r3 = new CardListFirstScreenPoint("QUERY_NET_START", 2, "query_net_start");
        QUERY_NET_START = r3;
        CardListFirstScreenPoint r4 = new CardListFirstScreenPoint("QUERY_NET_END", 3, "query_net_end");
        QUERY_NET_END = r4;
        CardListFirstScreenPoint r5 = new CardListFirstScreenPoint("PARSE_RESPONSE_START", 4, "parse_response_start");
        PARSE_RESPONSE_START = r5;
        CardListFirstScreenPoint r6 = new CardListFirstScreenPoint("PARSE_RESPONSE_END", 5, "parse_response_end");
        PARSE_RESPONSE_END = r6;
        CardListFirstScreenPoint r7 = new CardListFirstScreenPoint("REQUEST_END", 6, "request_end");
        REQUEST_END = r7;
        CardListFirstScreenPoint r8 = new CardListFirstScreenPoint("RENDER_START", 7, "render_start");
        RENDER_START = r8;
        CardListFirstScreenPoint r9 = new CardListFirstScreenPoint("RENDER_END", 8, "render_end");
        RENDER_END = r9;
        CardListFirstScreenPoint r10 = new CardListFirstScreenPoint("END", 9, "end");
        END = r10;
        a = new CardListFirstScreenPoint[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getValue() {
        return this.value;
    }

    public CardListFirstScreenPoint(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
