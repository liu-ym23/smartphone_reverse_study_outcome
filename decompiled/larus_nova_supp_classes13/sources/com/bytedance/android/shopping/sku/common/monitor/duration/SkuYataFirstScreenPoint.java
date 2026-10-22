package com.bytedance.android.shopping.sku.common.monitor.duration;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/monitor/duration/SkuYataFirstScreenPoint;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "START", "REQUEST_START", "QUERY_NET_START", "QUERY_NET_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "REQUEST_END", "RENDER_START", "RENDER_END", "END", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkuYataFirstScreenPoint extends Enum<SkuYataFirstScreenPoint> {
    public static final SkuYataFirstScreenPoint END = null;
    public static final SkuYataFirstScreenPoint PARSE_RESPONSE_END = null;
    public static final SkuYataFirstScreenPoint PARSE_RESPONSE_START = null;
    public static final SkuYataFirstScreenPoint QUERY_NET_END = null;
    public static final SkuYataFirstScreenPoint QUERY_NET_START = null;
    public static final SkuYataFirstScreenPoint RENDER_END = null;
    public static final SkuYataFirstScreenPoint RENDER_START = null;
    public static final SkuYataFirstScreenPoint REQUEST_END = null;
    public static final SkuYataFirstScreenPoint REQUEST_START = null;
    public static final SkuYataFirstScreenPoint START = null;
    public static final /* synthetic */ SkuYataFirstScreenPoint[] a = null;
    private final String value;

    public static SkuYataFirstScreenPoint valueOf(String r1) {
        return (SkuYataFirstScreenPoint) a.a(SkuYataFirstScreenPoint.class, r1);
    }

    public static SkuYataFirstScreenPoint[] values() {
        return (SkuYataFirstScreenPoint[]) a.clone();
    }

    static {
        SkuYataFirstScreenPoint r1 = new SkuYataFirstScreenPoint("START", 0, "initial");
        START = r1;
        SkuYataFirstScreenPoint r2 = new SkuYataFirstScreenPoint("REQUEST_START", 1, "request_start");
        REQUEST_START = r2;
        SkuYataFirstScreenPoint r3 = new SkuYataFirstScreenPoint("QUERY_NET_START", 2, "query_net_start");
        QUERY_NET_START = r3;
        SkuYataFirstScreenPoint r4 = new SkuYataFirstScreenPoint("QUERY_NET_END", 3, "query_net_end");
        QUERY_NET_END = r4;
        SkuYataFirstScreenPoint r5 = new SkuYataFirstScreenPoint("PARSE_RESPONSE_START", 4, "parse_response_start");
        PARSE_RESPONSE_START = r5;
        SkuYataFirstScreenPoint r6 = new SkuYataFirstScreenPoint("PARSE_RESPONSE_END", 5, "parse_response_end");
        PARSE_RESPONSE_END = r6;
        SkuYataFirstScreenPoint r7 = new SkuYataFirstScreenPoint("REQUEST_END", 6, "request_end");
        REQUEST_END = r7;
        SkuYataFirstScreenPoint r8 = new SkuYataFirstScreenPoint("RENDER_START", 7, "render_start");
        RENDER_START = r8;
        SkuYataFirstScreenPoint r9 = new SkuYataFirstScreenPoint("RENDER_END", 8, "render_end");
        RENDER_END = r9;
        SkuYataFirstScreenPoint r10 = new SkuYataFirstScreenPoint("END", 9, "end");
        END = r10;
        a = new SkuYataFirstScreenPoint[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getValue() {
        return this.value;
    }

    public SkuYataFirstScreenPoint(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
