package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;", "", "", "code", "I", "getCode", "()I", "LOGIC_ERROR", "NOT_FOUND", "UN_KNOWN", "CONTENT_V2_FROM_CACHE", "CONTENT_V2_FROM_CALL", "CONTENT_V2_FROM_AUTO_MATCH", "CONTENT_V1_FROM_MATCH", "PRIVATE_DOMAINS", "CONTENT_V1_FROM_CACHE", "CONTENT_V2_FROM_LYNX", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum FeAuthConfigSource extends Enum<FeAuthConfigSource> {
    public static final FeAuthConfigSource CONTENT_V1_FROM_CACHE = null;
    public static final FeAuthConfigSource CONTENT_V1_FROM_MATCH = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_AUTO_MATCH = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_CACHE = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_CALL = null;
    public static final FeAuthConfigSource CONTENT_V2_FROM_LYNX = null;
    public static final FeAuthConfigSource LOGIC_ERROR = null;
    public static final FeAuthConfigSource NOT_FOUND = null;
    public static final FeAuthConfigSource PRIVATE_DOMAINS = null;
    public static final FeAuthConfigSource UN_KNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeAuthConfigSource[] f269828a = null;
    private final int code;

    public static FeAuthConfigSource valueOf(String r100) {
        return (FeAuthConfigSource) a.a(FeAuthConfigSource.class, r100);
    }

    public static FeAuthConfigSource[] values() {
        return (FeAuthConfigSource[]) f269828a.clone();
    }

    static {
        FeAuthConfigSource r100 = new FeAuthConfigSource("LOGIC_ERROR", 0, -2);
        LOGIC_ERROR = r100;
        FeAuthConfigSource r101 = new FeAuthConfigSource("NOT_FOUND", 1, -1);
        NOT_FOUND = r101;
        FeAuthConfigSource r102 = new FeAuthConfigSource("UN_KNOWN", 2, 0);
        UN_KNOWN = r102;
        FeAuthConfigSource r103 = new FeAuthConfigSource("CONTENT_V2_FROM_CACHE", 3, 1);
        CONTENT_V2_FROM_CACHE = r103;
        FeAuthConfigSource r104 = new FeAuthConfigSource("CONTENT_V2_FROM_CALL", 4, 2);
        CONTENT_V2_FROM_CALL = r104;
        FeAuthConfigSource r105 = new FeAuthConfigSource("CONTENT_V2_FROM_AUTO_MATCH", 5, 3);
        CONTENT_V2_FROM_AUTO_MATCH = r105;
        FeAuthConfigSource r110 = new FeAuthConfigSource("CONTENT_V1_FROM_MATCH", 6, 4);
        CONTENT_V1_FROM_MATCH = r110;
        FeAuthConfigSource r111 = new FeAuthConfigSource("PRIVATE_DOMAINS", 7, 5);
        PRIVATE_DOMAINS = r111;
        FeAuthConfigSource r112 = new FeAuthConfigSource("CONTENT_V1_FROM_CACHE", 8, 6);
        CONTENT_V1_FROM_CACHE = r112;
        FeAuthConfigSource r113 = new FeAuthConfigSource("CONTENT_V2_FROM_LYNX", 9, 7);
        CONTENT_V2_FROM_LYNX = r113;
        f269828a = new FeAuthConfigSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getCode() {
        return this.code;
    }

    public FeAuthConfigSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
