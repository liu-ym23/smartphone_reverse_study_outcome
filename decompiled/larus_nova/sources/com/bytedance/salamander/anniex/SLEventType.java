package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/salamander/anniex/SLEventType;", "", "", "value", "I", "getValue", "()I", "PV", "FETCH_ERROR", "JSB_ERROR", "JSB_PERF", "JS_EXCEPTION", "END_TO_END", "PERFORMANCE", "JSB_CONFIG", "MEMORY", "CUSTOM", "BLANK", "JSB_PAGE_VISIT", "NATIVE_ERROR", "CONTAINER_ERROR", "RESOURCE_PERFORMANCE", "RES_LOADER_PERF", "RES_LOADER_PERF_TEMPLATE", "RES_LOADER_ERROR", "RES_LOADER_ERROR_TEMPLATE", "AJAX", "STATIC", "STATIC_SRI", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SLEventType extends Enum<SLEventType> {
    public static final SLEventType AJAX = null;
    public static final SLEventType BLANK = null;
    public static final SLEventType CONTAINER_ERROR = null;
    public static final SLEventType CUSTOM = null;
    public static final SLEventType END_TO_END = null;
    public static final SLEventType FETCH_ERROR = null;
    public static final SLEventType JSB_CONFIG = null;
    public static final SLEventType JSB_ERROR = null;
    public static final SLEventType JSB_PAGE_VISIT = null;
    public static final SLEventType JSB_PERF = null;
    public static final SLEventType JS_EXCEPTION = null;
    public static final SLEventType MEMORY = null;
    public static final SLEventType NATIVE_ERROR = null;
    public static final SLEventType PERFORMANCE = null;
    public static final SLEventType PV = null;
    public static final SLEventType RESOURCE_PERFORMANCE = null;
    public static final SLEventType RES_LOADER_ERROR = null;
    public static final SLEventType RES_LOADER_ERROR_TEMPLATE = null;
    public static final SLEventType RES_LOADER_PERF = null;
    public static final SLEventType RES_LOADER_PERF_TEMPLATE = null;
    public static final SLEventType STATIC = null;
    public static final SLEventType STATIC_SRI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SLEventType[] f267911a = null;
    private final int value;

    public static SLEventType valueOf(String r100) {
        return (SLEventType) r27.a.a(SLEventType.class, r100);
    }

    public static SLEventType[] values() {
        return (SLEventType[]) f267911a.clone();
    }

    static {
        SLEventType r100 = new SLEventType("PV", 0, 0);
        PV = r100;
        SLEventType r101 = new SLEventType("FETCH_ERROR", 1, 1);
        FETCH_ERROR = r101;
        SLEventType r102 = new SLEventType("JSB_ERROR", 2, 2);
        JSB_ERROR = r102;
        SLEventType r103 = new SLEventType("JSB_PERF", 3, 3);
        JSB_PERF = r103;
        SLEventType r104 = new SLEventType("JS_EXCEPTION", 4, 4);
        JS_EXCEPTION = r104;
        SLEventType r105 = new SLEventType("END_TO_END", 5, 5);
        END_TO_END = r105;
        SLEventType r110 = new SLEventType("PERFORMANCE", 6, 6);
        PERFORMANCE = r110;
        SLEventType r111 = new SLEventType("JSB_CONFIG", 7, 7);
        JSB_CONFIG = r111;
        SLEventType r112 = new SLEventType("MEMORY", 8, 8);
        MEMORY = r112;
        SLEventType r113 = new SLEventType("CUSTOM", 9, 9);
        CUSTOM = r113;
        SLEventType r114 = new SLEventType("BLANK", 10, 10);
        BLANK = r114;
        SLEventType r115 = new SLEventType("JSB_PAGE_VISIT", 11, 11);
        JSB_PAGE_VISIT = r115;
        SLEventType r106 = new SLEventType("NATIVE_ERROR", 12, 12);
        NATIVE_ERROR = r106;
        SLEventType r107 = new SLEventType("CONTAINER_ERROR", 13, 13);
        CONTAINER_ERROR = r107;
        SLEventType r108 = new SLEventType("RESOURCE_PERFORMANCE", 14, 14);
        RESOURCE_PERFORMANCE = r108;
        SLEventType r109 = new SLEventType("RES_LOADER_PERF", 15, 15);
        RES_LOADER_PERF = r109;
        SLEventType r116 = new SLEventType("RES_LOADER_PERF_TEMPLATE", 16, 16);
        RES_LOADER_PERF_TEMPLATE = r116;
        SLEventType r117 = new SLEventType("RES_LOADER_ERROR", 17, 17);
        RES_LOADER_ERROR = r117;
        SLEventType r118 = new SLEventType("RES_LOADER_ERROR_TEMPLATE", 18, 18);
        RES_LOADER_ERROR_TEMPLATE = r118;
        SLEventType r119 = new SLEventType("AJAX", 19, 19);
        AJAX = r119;
        SLEventType r120 = new SLEventType("STATIC", 20, 20);
        STATIC = r120;
        SLEventType r121 = new SLEventType("STATIC_SRI", 21, 21);
        STATIC_SRI = r121;
        f267911a = new SLEventType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121};
    }

    public final int getValue() {
        return this.value;
    }

    public SLEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
