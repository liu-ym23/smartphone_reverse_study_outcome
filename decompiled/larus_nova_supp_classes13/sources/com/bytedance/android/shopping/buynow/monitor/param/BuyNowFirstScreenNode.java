package com.bytedance.android.shopping.buynow.monitor.param;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, d2 = {"Lcom/bytedance/android/shopping/buynow/monitor/param/BuyNowFirstScreenNode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PRELOAD_TEMPLATE_START", "PRELOAD_TEMPLATE_END", "PARSE_SCHEMA_START", "PARSE_SCHEMA_END", "QUERY_PARAM_START", "QUERY_PARAM_END", "NATIVE_NET_START", "NATIVE_NET_END", "FETCH_START", "FETCH_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "T_REAL_SERVER_START", "T_REAL_SERVER_END", "CONTAINER_INIT_START", "PAGE_START", "PAGE_INIT_END", "YATA_INIT_START", "YATA_INIT_END", "YATA_RENDER_START", "YATA_RENDER_END", "CACHE_RENDER_START", "CACHE_RENDER_END", "RENDER_START", "RENDER_END", "INTERACTIVE", "INITIAL", "REQUEST_START", "REQUEST_END", "STANDARD_RENDER_START", "STANDARD_RENDER_END", "END", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BuyNowFirstScreenNode extends Enum<BuyNowFirstScreenNode> {
    public static final BuyNowFirstScreenNode CACHE_RENDER_END = null;
    public static final BuyNowFirstScreenNode CACHE_RENDER_START = null;
    public static final BuyNowFirstScreenNode CONTAINER_INIT_START = null;
    public static final BuyNowFirstScreenNode END = null;
    public static final BuyNowFirstScreenNode FETCH_END = null;
    public static final BuyNowFirstScreenNode FETCH_START = null;
    public static final BuyNowFirstScreenNode INITIAL = null;
    public static final BuyNowFirstScreenNode INTERACTIVE = null;
    public static final BuyNowFirstScreenNode NATIVE_NET_END = null;
    public static final BuyNowFirstScreenNode NATIVE_NET_START = null;
    public static final BuyNowFirstScreenNode PAGE_INIT_END = null;
    public static final BuyNowFirstScreenNode PAGE_START = null;
    public static final BuyNowFirstScreenNode PARSE_RESPONSE_END = null;
    public static final BuyNowFirstScreenNode PARSE_RESPONSE_START = null;
    public static final BuyNowFirstScreenNode PARSE_SCHEMA_END = null;
    public static final BuyNowFirstScreenNode PARSE_SCHEMA_START = null;
    public static final BuyNowFirstScreenNode PRELOAD_TEMPLATE_END = null;
    public static final BuyNowFirstScreenNode PRELOAD_TEMPLATE_START = null;
    public static final BuyNowFirstScreenNode QUERY_PARAM_END = null;
    public static final BuyNowFirstScreenNode QUERY_PARAM_START = null;
    public static final BuyNowFirstScreenNode RENDER_END = null;
    public static final BuyNowFirstScreenNode RENDER_START = null;
    public static final BuyNowFirstScreenNode REQUEST_END = null;
    public static final BuyNowFirstScreenNode REQUEST_START = null;
    public static final BuyNowFirstScreenNode STANDARD_RENDER_END = null;
    public static final BuyNowFirstScreenNode STANDARD_RENDER_START = null;
    public static final BuyNowFirstScreenNode T_REAL_SERVER_END = null;
    public static final BuyNowFirstScreenNode T_REAL_SERVER_START = null;
    public static final BuyNowFirstScreenNode YATA_INIT_END = null;
    public static final BuyNowFirstScreenNode YATA_INIT_START = null;
    public static final BuyNowFirstScreenNode YATA_RENDER_END = null;
    public static final BuyNowFirstScreenNode YATA_RENDER_START = null;
    public static final /* synthetic */ BuyNowFirstScreenNode[] a = null;
    private final String value;

    public static BuyNowFirstScreenNode valueOf(String r1) {
        return (BuyNowFirstScreenNode) a.a(BuyNowFirstScreenNode.class, r1);
    }

    public static BuyNowFirstScreenNode[] values() {
        return (BuyNowFirstScreenNode[]) a.clone();
    }

    static {
        BuyNowFirstScreenNode r1 = new BuyNowFirstScreenNode("PRELOAD_TEMPLATE_START", 0, "preload_template_start");
        PRELOAD_TEMPLATE_START = r1;
        BuyNowFirstScreenNode r2 = new BuyNowFirstScreenNode("PRELOAD_TEMPLATE_END", 1, "preload_template_end");
        PRELOAD_TEMPLATE_END = r2;
        BuyNowFirstScreenNode r3 = new BuyNowFirstScreenNode("PARSE_SCHEMA_START", 2, "C_PARSE_SCHEMA_START");
        PARSE_SCHEMA_START = r3;
        BuyNowFirstScreenNode r4 = new BuyNowFirstScreenNode("PARSE_SCHEMA_END", 3, "C_PARSE_SCHEMA_END");
        PARSE_SCHEMA_END = r4;
        BuyNowFirstScreenNode r5 = new BuyNowFirstScreenNode("QUERY_PARAM_START", 4, "C_QUERY_PARAM_START");
        QUERY_PARAM_START = r5;
        BuyNowFirstScreenNode r6 = new BuyNowFirstScreenNode("QUERY_PARAM_END", 5, "C_QUERY_PARAM_END");
        QUERY_PARAM_END = r6;
        BuyNowFirstScreenNode r7 = new BuyNowFirstScreenNode("NATIVE_NET_START", 6, "C_native_net_start_time");
        NATIVE_NET_START = r7;
        BuyNowFirstScreenNode r8 = new BuyNowFirstScreenNode("NATIVE_NET_END", 7, "C_native_net_end_time");
        NATIVE_NET_END = r8;
        BuyNowFirstScreenNode r9 = new BuyNowFirstScreenNode("FETCH_START", 8, "T_MAIN_FETCH_START");
        FETCH_START = r9;
        BuyNowFirstScreenNode r10 = new BuyNowFirstScreenNode("FETCH_END", 9, "T_MAIN_FETCH_END");
        FETCH_END = r10;
        BuyNowFirstScreenNode r11 = new BuyNowFirstScreenNode("PARSE_RESPONSE_START", 10, "C_PARSE_RESPONSE_START");
        PARSE_RESPONSE_START = r11;
        BuyNowFirstScreenNode r12 = new BuyNowFirstScreenNode("PARSE_RESPONSE_END", 11, "C_PARSE_RESPONSE_END");
        PARSE_RESPONSE_END = r12;
        BuyNowFirstScreenNode r13 = new BuyNowFirstScreenNode("T_REAL_SERVER_START", 12, "T_REAL_SERVER_START");
        T_REAL_SERVER_START = r13;
        BuyNowFirstScreenNode r14 = new BuyNowFirstScreenNode("T_REAL_SERVER_END", 13, "T_REAL_SERVER_END");
        T_REAL_SERVER_END = r14;
        BuyNowFirstScreenNode r15 = new BuyNowFirstScreenNode("CONTAINER_INIT_START", 14, "T_CONTAINER_INIT");
        CONTAINER_INIT_START = r15;
        BuyNowFirstScreenNode r16 = new BuyNowFirstScreenNode("PAGE_START", 15, "T_PAGE_START");
        PAGE_START = r16;
        BuyNowFirstScreenNode r17 = new BuyNowFirstScreenNode("PAGE_INIT_END", 16, "C_PAGE_INIT_END");
        PAGE_INIT_END = r17;
        BuyNowFirstScreenNode r18 = new BuyNowFirstScreenNode("YATA_INIT_START", 17, "C_INIT_YATA_START");
        YATA_INIT_START = r18;
        BuyNowFirstScreenNode r19 = new BuyNowFirstScreenNode("YATA_INIT_END", 18, "C_INIT_YATA_END");
        YATA_INIT_END = r19;
        BuyNowFirstScreenNode r20 = new BuyNowFirstScreenNode("YATA_RENDER_START", 19, "C_YATA_RENDER_START");
        YATA_RENDER_START = r20;
        BuyNowFirstScreenNode r21 = new BuyNowFirstScreenNode("YATA_RENDER_END", 20, "C_YATA_RENDER_END");
        YATA_RENDER_END = r21;
        BuyNowFirstScreenNode r22 = new BuyNowFirstScreenNode("CACHE_RENDER_START", 21, "C_CACHE_RENDER_START");
        CACHE_RENDER_START = r22;
        BuyNowFirstScreenNode r23 = new BuyNowFirstScreenNode("CACHE_RENDER_END", 22, "C_CACHE_RENDER_END");
        CACHE_RENDER_END = r23;
        BuyNowFirstScreenNode r24 = new BuyNowFirstScreenNode("RENDER_START", 23, "T_RENDER_START");
        RENDER_START = r24;
        BuyNowFirstScreenNode r25 = new BuyNowFirstScreenNode("RENDER_END", 24, "T_RENDER_END");
        RENDER_END = r25;
        BuyNowFirstScreenNode r26 = new BuyNowFirstScreenNode("INTERACTIVE", 25, "T_INTERACTIVE");
        INTERACTIVE = r26;
        BuyNowFirstScreenNode r27 = new BuyNowFirstScreenNode("INITIAL", 26, "initial");
        INITIAL = r27;
        BuyNowFirstScreenNode r28 = new BuyNowFirstScreenNode("REQUEST_START", 27, "request_start");
        REQUEST_START = r28;
        BuyNowFirstScreenNode r29 = new BuyNowFirstScreenNode("REQUEST_END", 28, "request_end");
        REQUEST_END = r29;
        BuyNowFirstScreenNode r30 = new BuyNowFirstScreenNode("STANDARD_RENDER_START", 29, "render_start");
        STANDARD_RENDER_START = r30;
        BuyNowFirstScreenNode r31 = new BuyNowFirstScreenNode("STANDARD_RENDER_END", 30, "render_end");
        STANDARD_RENDER_END = r31;
        BuyNowFirstScreenNode r32 = new BuyNowFirstScreenNode("END", 31, "end");
        END = r32;
        a = new BuyNowFirstScreenNode[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32};
    }

    public final String getValue() {
        return this.value;
    }

    public BuyNowFirstScreenNode(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
