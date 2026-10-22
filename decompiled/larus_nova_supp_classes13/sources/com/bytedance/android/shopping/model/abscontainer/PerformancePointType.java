package com.bytedance.android.shopping.model.abscontainer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/model/abscontainer/PerformancePointType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "C_PAGE_START", "PARSE_SCHEMA_START", "PARSE_SCHEMA_END", "INNER_START", "QUERY_PARAM_START", "QUERY_PARAM_END", "REQUEST_START", "REQUEST_END", "FETCH_START", "FETCH_END", "PARSE_RESPONSE_START", "PARSE_RESPONSE_END", "CONTAINER_INIT_START", "T_PAGE_START", "RENDER_START", "RENDER_END", "INTERACTIVE", "YATA_RENDER_START", "YATA_RENDER_END", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PerformancePointType extends Enum<PerformancePointType> {
    public static final PerformancePointType CONTAINER_INIT_START = null;
    public static final PerformancePointType C_PAGE_START = null;
    public static final PerformancePointType FETCH_END = null;
    public static final PerformancePointType FETCH_START = null;
    public static final PerformancePointType INNER_START = null;
    public static final PerformancePointType INTERACTIVE = null;
    public static final PerformancePointType PARSE_RESPONSE_END = null;
    public static final PerformancePointType PARSE_RESPONSE_START = null;
    public static final PerformancePointType PARSE_SCHEMA_END = null;
    public static final PerformancePointType PARSE_SCHEMA_START = null;
    public static final PerformancePointType QUERY_PARAM_END = null;
    public static final PerformancePointType QUERY_PARAM_START = null;
    public static final PerformancePointType RENDER_END = null;
    public static final PerformancePointType RENDER_START = null;
    public static final PerformancePointType REQUEST_END = null;
    public static final PerformancePointType REQUEST_START = null;
    public static final PerformancePointType T_PAGE_START = null;
    public static final PerformancePointType YATA_RENDER_END = null;
    public static final PerformancePointType YATA_RENDER_START = null;
    public static final /* synthetic */ PerformancePointType[] a = null;
    private final String value;

    public static PerformancePointType valueOf(String r1) {
        return (PerformancePointType) a.a(PerformancePointType.class, r1);
    }

    public static PerformancePointType[] values() {
        return (PerformancePointType[]) a.clone();
    }

    static {
        PerformancePointType r1 = new PerformancePointType("C_PAGE_START", 0, "C_PAGE_START");
        C_PAGE_START = r1;
        PerformancePointType r2 = new PerformancePointType("PARSE_SCHEMA_START", 1, "C_PARSE_SCHEMA_START");
        PARSE_SCHEMA_START = r2;
        PerformancePointType r3 = new PerformancePointType("PARSE_SCHEMA_END", 2, "C_PARSE_SCHEMA_END");
        PARSE_SCHEMA_END = r3;
        PerformancePointType r4 = new PerformancePointType("INNER_START", 3, "C_INNER_START");
        INNER_START = r4;
        PerformancePointType r5 = new PerformancePointType("QUERY_PARAM_START", 4, "C_QUERY_PARAM_START");
        QUERY_PARAM_START = r5;
        PerformancePointType r6 = new PerformancePointType("QUERY_PARAM_END", 5, "C_QUERY_PARAM_END");
        QUERY_PARAM_END = r6;
        PerformancePointType r7 = new PerformancePointType("REQUEST_START", 6, "request_start");
        REQUEST_START = r7;
        PerformancePointType r8 = new PerformancePointType("REQUEST_END", 7, "request_end");
        REQUEST_END = r8;
        PerformancePointType r9 = new PerformancePointType("FETCH_START", 8, "T_MAIN_FETCH_START");
        FETCH_START = r9;
        PerformancePointType r10 = new PerformancePointType("FETCH_END", 9, "T_MAIN_FETCH_END");
        FETCH_END = r10;
        PerformancePointType r11 = new PerformancePointType("PARSE_RESPONSE_START", 10, "C_PARSE_RESPONSE_START");
        PARSE_RESPONSE_START = r11;
        PerformancePointType r12 = new PerformancePointType("PARSE_RESPONSE_END", 11, "C_PARSE_RESPONSE_END");
        PARSE_RESPONSE_END = r12;
        PerformancePointType r13 = new PerformancePointType("CONTAINER_INIT_START", 12, "T_CONTAINER_INIT");
        CONTAINER_INIT_START = r13;
        PerformancePointType r14 = new PerformancePointType("T_PAGE_START", 13, "T_PAGE_START");
        T_PAGE_START = r14;
        PerformancePointType r15 = new PerformancePointType("RENDER_START", 14, "T_RENDER_START");
        RENDER_START = r15;
        PerformancePointType r16 = new PerformancePointType("RENDER_END", 15, "T_RENDER_END");
        RENDER_END = r16;
        PerformancePointType r17 = new PerformancePointType("INTERACTIVE", 16, "T_INTERACTIVE");
        INTERACTIVE = r17;
        PerformancePointType r18 = new PerformancePointType("YATA_RENDER_START", 17, "C_YATA_RENDER_START");
        YATA_RENDER_START = r18;
        PerformancePointType r19 = new PerformancePointType("YATA_RENDER_END", 18, "C_YATA_RENDER_END");
        YATA_RENDER_END = r19;
        a = new PerformancePointType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19};
    }

    public final String getValue() {
        return this.value;
    }

    public PerformancePointType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
