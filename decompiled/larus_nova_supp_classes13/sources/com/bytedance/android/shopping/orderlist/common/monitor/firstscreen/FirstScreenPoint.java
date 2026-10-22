package com.bytedance.android.shopping.orderlist.common.monitor.firstscreen;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/monitor/firstscreen/FirstScreenPoint;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INITIAL", "PRELOAD_TEMPLATE_START", "PRELOAD_TEMPLATE_END", "PARSE_SCHEMA_START", "PARSE_SCHEMA_END", "REQUEST_START", "REQUEST_END", "QUERY_NET_START", "QUERY_NET_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "CONTAINER_INIT_START", "CONTAINER_INIT_END", "PAGE_INIT_START", "PAGE_INIT_END", "YATA_INIT_START", "YATA_INIT_END", "YATA_RENDER_START", "YATA_RENDER_END", "RENDER_START", "RENDER_END", "C_PAGE_INIT", "T_CONTAINER_INIT", "FETCH_START", "FETCH_END", "INTERACTIVE", "END", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FirstScreenPoint extends Enum<FirstScreenPoint> {
    public static final FirstScreenPoint CONTAINER_INIT_END = null;
    public static final FirstScreenPoint CONTAINER_INIT_START = null;
    public static final FirstScreenPoint C_PAGE_INIT = null;
    public static final FirstScreenPoint END = null;
    public static final FirstScreenPoint FETCH_END = null;
    public static final FirstScreenPoint FETCH_START = null;
    public static final FirstScreenPoint INITIAL = null;
    public static final FirstScreenPoint INTERACTIVE = null;
    public static final FirstScreenPoint PAGE_INIT_END = null;
    public static final FirstScreenPoint PAGE_INIT_START = null;
    public static final FirstScreenPoint PARSE_RESPONSE_END = null;
    public static final FirstScreenPoint PARSE_RESPONSE_START = null;
    public static final FirstScreenPoint PARSE_SCHEMA_END = null;
    public static final FirstScreenPoint PARSE_SCHEMA_START = null;
    public static final FirstScreenPoint PRELOAD_TEMPLATE_END = null;
    public static final FirstScreenPoint PRELOAD_TEMPLATE_START = null;
    public static final FirstScreenPoint QUERY_NET_END = null;
    public static final FirstScreenPoint QUERY_NET_START = null;
    public static final FirstScreenPoint RENDER_END = null;
    public static final FirstScreenPoint RENDER_START = null;
    public static final FirstScreenPoint REQUEST_END = null;
    public static final FirstScreenPoint REQUEST_START = null;
    public static final FirstScreenPoint T_CONTAINER_INIT = null;
    public static final FirstScreenPoint YATA_INIT_END = null;
    public static final FirstScreenPoint YATA_INIT_START = null;
    public static final FirstScreenPoint YATA_RENDER_END = null;
    public static final FirstScreenPoint YATA_RENDER_START = null;
    public static final /* synthetic */ FirstScreenPoint[] a = null;
    private final String value;

    public static FirstScreenPoint valueOf(String r1) {
        return (FirstScreenPoint) a.a(FirstScreenPoint.class, r1);
    }

    public static FirstScreenPoint[] values() {
        return (FirstScreenPoint[]) a.clone();
    }

    static {
        FirstScreenPoint r1 = new FirstScreenPoint("INITIAL", 0, "initial");
        INITIAL = r1;
        FirstScreenPoint r2 = new FirstScreenPoint("PRELOAD_TEMPLATE_START", 1, "preload_template_start");
        PRELOAD_TEMPLATE_START = r2;
        FirstScreenPoint r3 = new FirstScreenPoint("PRELOAD_TEMPLATE_END", 2, "preload_template_end");
        PRELOAD_TEMPLATE_END = r3;
        FirstScreenPoint r4 = new FirstScreenPoint("PARSE_SCHEMA_START", 3, "parse_schema_start");
        PARSE_SCHEMA_START = r4;
        FirstScreenPoint r5 = new FirstScreenPoint("PARSE_SCHEMA_END", 4, "parse_schema_end");
        PARSE_SCHEMA_END = r5;
        FirstScreenPoint r6 = new FirstScreenPoint("REQUEST_START", 5, "request_start");
        REQUEST_START = r6;
        FirstScreenPoint r7 = new FirstScreenPoint("REQUEST_END", 6, "request_end");
        REQUEST_END = r7;
        FirstScreenPoint r8 = new FirstScreenPoint("QUERY_NET_START", 7, "query_net_start");
        QUERY_NET_START = r8;
        FirstScreenPoint r9 = new FirstScreenPoint("QUERY_NET_END", 8, "query_net_end");
        QUERY_NET_END = r9;
        FirstScreenPoint r10 = new FirstScreenPoint("PARSE_RESPONSE_START", 9, "parse_response_start");
        PARSE_RESPONSE_START = r10;
        FirstScreenPoint r11 = new FirstScreenPoint("PARSE_RESPONSE_END", 10, "parse_response_end");
        PARSE_RESPONSE_END = r11;
        FirstScreenPoint r12 = new FirstScreenPoint("CONTAINER_INIT_START", 11, "container_init_start");
        CONTAINER_INIT_START = r12;
        FirstScreenPoint r13 = new FirstScreenPoint("CONTAINER_INIT_END", 12, "container_init_end");
        CONTAINER_INIT_END = r13;
        FirstScreenPoint r14 = new FirstScreenPoint("PAGE_INIT_START", 13, "page_init_start");
        PAGE_INIT_START = r14;
        FirstScreenPoint r15 = new FirstScreenPoint("PAGE_INIT_END", 14, "page_init_end");
        PAGE_INIT_END = r15;
        FirstScreenPoint r16 = new FirstScreenPoint("YATA_INIT_START", 15, "yata_init_start");
        YATA_INIT_START = r16;
        FirstScreenPoint r17 = new FirstScreenPoint("YATA_INIT_END", 16, "yata_init_end");
        YATA_INIT_END = r17;
        FirstScreenPoint r18 = new FirstScreenPoint("YATA_RENDER_START", 17, "yata_render_start");
        YATA_RENDER_START = r18;
        FirstScreenPoint r19 = new FirstScreenPoint("YATA_RENDER_END", 18, "yata_render_end");
        YATA_RENDER_END = r19;
        FirstScreenPoint r20 = new FirstScreenPoint("RENDER_START", 19, "render_start");
        RENDER_START = r20;
        FirstScreenPoint r21 = new FirstScreenPoint("RENDER_END", 20, "render_end");
        RENDER_END = r21;
        FirstScreenPoint r22 = new FirstScreenPoint("C_PAGE_INIT", 21, "C_PAGE_INIT");
        C_PAGE_INIT = r22;
        FirstScreenPoint r23 = new FirstScreenPoint("T_CONTAINER_INIT", 22, "T_CONTAINER_INIT");
        T_CONTAINER_INIT = r23;
        FirstScreenPoint r24 = new FirstScreenPoint("FETCH_START", 23, "T_MAIN_FETCH_START");
        FETCH_START = r24;
        FirstScreenPoint r25 = new FirstScreenPoint("FETCH_END", 24, "T_MAIN_FETCH_END");
        FETCH_END = r25;
        FirstScreenPoint r26 = new FirstScreenPoint("INTERACTIVE", 25, "T_INTERACTIVE");
        INTERACTIVE = r26;
        FirstScreenPoint r27 = new FirstScreenPoint("END", 26, "end");
        END = r27;
        a = new FirstScreenPoint[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27};
    }

    public final String getValue() {
        return this.value;
    }

    public FirstScreenPoint(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
