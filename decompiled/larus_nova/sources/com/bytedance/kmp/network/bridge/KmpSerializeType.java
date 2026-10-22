package com.bytedance.kmp.network.bridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/network/bridge/KmpSerializeType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "JSON", "PB", "FORM", "network_service_release"}, k = 1, mv = {1, 7, 0})
public final enum KmpSerializeType extends Enum<KmpSerializeType> {
    public static final KmpSerializeType FORM = null;
    public static final KmpSerializeType JSON = null;
    public static final KmpSerializeType PB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KmpSerializeType[] f252486a = null;
    private final String typeName;

    public static KmpSerializeType valueOf(String r100) {
        return (KmpSerializeType) r27.a.a(KmpSerializeType.class, r100);
    }

    public static KmpSerializeType[] values() {
        return (KmpSerializeType[]) f252486a.clone();
    }

    static {
        KmpSerializeType r100 = new KmpSerializeType("JSON", 0, "json");
        JSON = r100;
        KmpSerializeType r101 = new KmpSerializeType("PB", 1, "pb");
        PB = r101;
        KmpSerializeType r102 = new KmpSerializeType("FORM", 2, "form");
        FORM = r102;
        f252486a = new KmpSerializeType[]{r100, r101, r102};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public KmpSerializeType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
