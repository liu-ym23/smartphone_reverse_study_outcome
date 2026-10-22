package com.bytedance.salamander.adapter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/salamander/adapter/SLStorageValueType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SLInt32", "SLInt64", "SLFloat32", "SLFloat64", "SLBoolean", "SLString", "runtime_release"}, k = 1, mv = {1, 7, 1})
public final enum SLStorageValueType extends Enum<SLStorageValueType> {
    public static final SLStorageValueType SLBoolean = null;
    public static final SLStorageValueType SLFloat32 = null;
    public static final SLStorageValueType SLFloat64 = null;
    public static final SLStorageValueType SLInt32 = null;
    public static final SLStorageValueType SLInt64 = null;
    public static final SLStorageValueType SLString = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SLStorageValueType[] f267777a = null;
    private final String value;

    public static SLStorageValueType valueOf(String r100) {
        return (SLStorageValueType) r27.a.a(SLStorageValueType.class, r100);
    }

    public static SLStorageValueType[] values() {
        return (SLStorageValueType[]) f267777a.clone();
    }

    static {
        SLStorageValueType r100 = new SLStorageValueType("SLInt32", 0, "int32");
        SLInt32 = r100;
        SLStorageValueType r101 = new SLStorageValueType("SLInt64", 1, "int64");
        SLInt64 = r101;
        SLStorageValueType r102 = new SLStorageValueType("SLFloat32", 2, "float32");
        SLFloat32 = r102;
        SLStorageValueType r103 = new SLStorageValueType("SLFloat64", 3, "float64");
        SLFloat64 = r103;
        SLStorageValueType r104 = new SLStorageValueType("SLBoolean", 4, "boolean");
        SLBoolean = r104;
        SLStorageValueType r105 = new SLStorageValueType("SLString", 5, "string");
        SLString = r105;
        f267777a = new SLStorageValueType[]{r100, r101, r102, r103, r104, r105};
    }

    public final String getValue() {
        return this.value;
    }

    public SLStorageValueType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
