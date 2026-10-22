package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/FeAuthConfigSource;", "", "", "code", "I", "getCode", "()I", "CONTENT_V2_FROM_LYNX_UN_FOUND", "LOGIC_ERROR", "NOT_FOUND", "UN_KNOWN", "CONTENT_V2_FROM_CACHE", "CONTENT_V2_FROM_CALL", "CONTENT_V2_FROM_AUTO_MATCH", "CONTENT_V1_FROM_MATCH", "PRIVATE_DOMAINS", "CONTENT_V1_FROM_CACHE", "CONTENT_V2_FROM_LYNX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum FeAuthConfigSource extends Enum<FeAuthConfigSource> {
    public static final FeAuthConfigSource CONTENT_V1_FROM_CACHE = null;
    public static final FeAuthConfigSource CONTENT_V1_FROM_MATCH = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_AUTO_MATCH = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_CACHE = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_CALL = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_LYNX = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_LYNX_UN_FOUND = null;
    public static final FeAuthConfigSource LOGIC_ERROR = null;
    public static final FeAuthConfigSource NOT_FOUND = null;
    public static final FeAuthConfigSource PRIVATE_DOMAINS = null;
    public static final FeAuthConfigSource UN_KNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeAuthConfigSource[] f245832a = null;
    private final int code;

    public static FeAuthConfigSource valueOf(String r100) {
        return (FeAuthConfigSource) r27.a.a(FeAuthConfigSource.class, r100);
    }

    public static FeAuthConfigSource[] values() {
        return (FeAuthConfigSource[]) f245832a.clone();
    }

    static {
        FeAuthConfigSource r100 = new FeAuthConfigSource("CONTENT_V2_FROM_LYNX_UN_FOUND", 0, -3);
        CONTENT_V2_FROM_LYNX_UN_FOUND = r100;
        FeAuthConfigSource r101 = new FeAuthConfigSource("LOGIC_ERROR", 1, -2);
        LOGIC_ERROR = r101;
        FeAuthConfigSource r102 = new FeAuthConfigSource("NOT_FOUND", 2, -1);
        NOT_FOUND = r102;
        FeAuthConfigSource r103 = new FeAuthConfigSource("UN_KNOWN", 3, 0);
        UN_KNOWN = r103;
        FeAuthConfigSource r104 = new FeAuthConfigSource("CONTENT_V2_FROM_CACHE", 4, 1);
        CONTENT_V2_FROM_CACHE = r104;
        FeAuthConfigSource r105 = new FeAuthConfigSource("CONTENT_V2_FROM_CALL", 5, 2);
        CONTENT_V2_FROM_CALL = r105;
        FeAuthConfigSource r110 = new FeAuthConfigSource("CONTENT_V2_FROM_AUTO_MATCH", 6, 3);
        CONTENT_V2_FROM_AUTO_MATCH = r110;
        FeAuthConfigSource r111 = new FeAuthConfigSource("CONTENT_V1_FROM_MATCH", 7, 4);
        CONTENT_V1_FROM_MATCH = r111;
        FeAuthConfigSource r112 = new FeAuthConfigSource("PRIVATE_DOMAINS", 8, 5);
        PRIVATE_DOMAINS = r112;
        FeAuthConfigSource r113 = new FeAuthConfigSource("CONTENT_V1_FROM_CACHE", 9, 6);
        CONTENT_V1_FROM_CACHE = r113;
        FeAuthConfigSource r106 = new FeAuthConfigSource("CONTENT_V2_FROM_LYNX", 10, 7);
        CONTENT_V2_FROM_LYNX = r106;
        f245832a = new FeAuthConfigSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106};
    }

    public final int getCode() {
        return this.code;
    }

    public FeAuthConfigSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
