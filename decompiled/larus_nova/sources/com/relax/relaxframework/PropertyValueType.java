package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/PropertyValueType;", "", "", "value", "I", "getValue", "()I", "EMPTY", "INT32", "DOUBLE", "PATTERN", "OBJECT", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum PropertyValueType extends Enum<PropertyValueType> {
    public static final PropertyValueType DOUBLE = null;
    public static final PropertyValueType EMPTY = null;
    public static final PropertyValueType INT32 = null;
    public static final PropertyValueType OBJECT = null;
    public static final PropertyValueType PATTERN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PropertyValueType[] f404849a = null;
    private final int value;

    public static PropertyValueType valueOf(String r100) {
        return (PropertyValueType) r27.a.a(PropertyValueType.class, r100);
    }

    public static PropertyValueType[] values() {
        return (PropertyValueType[]) f404849a.clone();
    }

    static {
        PropertyValueType r100 = new PropertyValueType("EMPTY", 0, 0);
        EMPTY = r100;
        PropertyValueType r101 = new PropertyValueType("INT32", 1, 1);
        INT32 = r101;
        PropertyValueType r102 = new PropertyValueType("DOUBLE", 2, 2);
        DOUBLE = r102;
        PropertyValueType r103 = new PropertyValueType("PATTERN", 3, 3);
        PATTERN = r103;
        PropertyValueType r104 = new PropertyValueType("OBJECT", 4, 4);
        OBJECT = r104;
        f404849a = new PropertyValueType[]{r100, r101, r102, r103, r104};
    }

    public final int getValue() {
        return this.value;
    }

    public PropertyValueType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
