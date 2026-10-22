package com.bytedance.kmp.network.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpRequestBodyType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "BODY_STRING", "BODY_STRING_MAP", "BODY_OBJECT", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum KmpRequestBodyType extends Enum<KmpRequestBodyType> {
    public static final KmpRequestBodyType BODY_OBJECT = null;
    public static final KmpRequestBodyType BODY_STRING = null;
    public static final KmpRequestBodyType BODY_STRING_MAP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpRequestBodyType[] f252483a = null;
    private final String type;

    public static KmpRequestBodyType valueOf(String r100) {
        return (KmpRequestBodyType) r27.a.a(KmpRequestBodyType.class, r100);
    }

    public static KmpRequestBodyType[] values() {
        return (KmpRequestBodyType[]) f252483a.clone();
    }

    static {
        KmpRequestBodyType r100 = new KmpRequestBodyType("BODY_STRING", 0, "string");
        BODY_STRING = r100;
        KmpRequestBodyType r101 = new KmpRequestBodyType("BODY_STRING_MAP", 1, "string_map");
        BODY_STRING_MAP = r101;
        KmpRequestBodyType r102 = new KmpRequestBodyType("BODY_OBJECT", 2, "object");
        BODY_OBJECT = r102;
        f252483a = new KmpRequestBodyType[]{r100, r101, r102};
    }

    public final String getType() {
        return this.type;
    }

    public KmpRequestBodyType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
