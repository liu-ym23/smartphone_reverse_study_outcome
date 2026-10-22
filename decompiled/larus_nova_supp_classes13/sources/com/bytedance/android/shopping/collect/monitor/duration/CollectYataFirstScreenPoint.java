package com.bytedance.android.shopping.collect.monitor.duration;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/collect/monitor/duration/CollectYataFirstScreenPoint;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "START", "REQUEST_START", "QUERY_NET_START", "QUERY_NET_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "REQUEST_END", "RENDER_START", "RENDER_END", "END", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CollectYataFirstScreenPoint extends Enum<CollectYataFirstScreenPoint> {
    public static final CollectYataFirstScreenPoint END = null;
    public static final CollectYataFirstScreenPoint PARSE_RESPONSE_END = null;
    public static final CollectYataFirstScreenPoint PARSE_RESPONSE_START = null;
    public static final CollectYataFirstScreenPoint QUERY_NET_END = null;
    public static final CollectYataFirstScreenPoint QUERY_NET_START = null;
    public static final CollectYataFirstScreenPoint RENDER_END = null;
    public static final CollectYataFirstScreenPoint RENDER_START = null;
    public static final CollectYataFirstScreenPoint REQUEST_END = null;
    public static final CollectYataFirstScreenPoint REQUEST_START = null;
    public static final CollectYataFirstScreenPoint START = null;
    public static final /* synthetic */ CollectYataFirstScreenPoint[] a = null;
    private final String value;

    public static CollectYataFirstScreenPoint valueOf(String r1) {
        return (CollectYataFirstScreenPoint) a.a(CollectYataFirstScreenPoint.class, r1);
    }

    public static CollectYataFirstScreenPoint[] values() {
        return (CollectYataFirstScreenPoint[]) a.clone();
    }

    static {
        CollectYataFirstScreenPoint r1 = new CollectYataFirstScreenPoint("START", 0, "initial");
        START = r1;
        CollectYataFirstScreenPoint r2 = new CollectYataFirstScreenPoint("REQUEST_START", 1, "request_start");
        REQUEST_START = r2;
        CollectYataFirstScreenPoint r3 = new CollectYataFirstScreenPoint("QUERY_NET_START", 2, "query_net_start");
        QUERY_NET_START = r3;
        CollectYataFirstScreenPoint r4 = new CollectYataFirstScreenPoint("QUERY_NET_END", 3, "query_net_end");
        QUERY_NET_END = r4;
        CollectYataFirstScreenPoint r5 = new CollectYataFirstScreenPoint("PARSE_RESPONSE_START", 4, "parse_response_start");
        PARSE_RESPONSE_START = r5;
        CollectYataFirstScreenPoint r6 = new CollectYataFirstScreenPoint("PARSE_RESPONSE_END", 5, "parse_response_end");
        PARSE_RESPONSE_END = r6;
        CollectYataFirstScreenPoint r7 = new CollectYataFirstScreenPoint("REQUEST_END", 6, "request_end");
        REQUEST_END = r7;
        CollectYataFirstScreenPoint r8 = new CollectYataFirstScreenPoint("RENDER_START", 7, "render_start");
        RENDER_START = r8;
        CollectYataFirstScreenPoint r9 = new CollectYataFirstScreenPoint("RENDER_END", 8, "render_end");
        RENDER_END = r9;
        CollectYataFirstScreenPoint r10 = new CollectYataFirstScreenPoint("END", 9, "end");
        END = r10;
        a = new CollectYataFirstScreenPoint[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getValue() {
        return this.value;
    }

    public CollectYataFirstScreenPoint(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
