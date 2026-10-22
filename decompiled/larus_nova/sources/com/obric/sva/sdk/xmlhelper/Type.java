package com.obric.sva.sdk.xmlhelper;

import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public final enum Type extends Enum<Type> {
    private static final /* synthetic */ Type[] $VALUES = null;
    public static final Type BOOLEAN = null;
    public static final Type FLOAT = null;
    public static final Type INTEGER = null;
    public static final Type STRING = null;
    public static final Type UNKNOWN = null;
    private final String mValue;

    static {
        Type r100 = new Type("UNKNOWN", 0, "UNKNOWN");
        UNKNOWN = r100;
        Type r101 = new Type("STRING", 1, "STRING");
        STRING = r101;
        Type r102 = new Type("INTEGER", 2, "INTEGER");
        INTEGER = r102;
        Type r103 = new Type("FLOAT", 3, "FLOAT");
        FLOAT = r103;
        Type r104 = new Type("BOOLEAN", 4, "BOOLEAN");
        BOOLEAN = r104;
        $VALUES = new Type[]{r100, r101, r102, r103, r104};
    }

    public static Type[] values() {
        return (Type[]) $VALUES.clone();
    }

    public boolean isBoolean() {
        if (this != BOOLEAN) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFloat() {
        if (this != FLOAT) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInt() {
        if (this != INTEGER) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isString() {
        if (this != STRING) goto L5;
        return true;
    L5:
        return false;
    }

    public String getValue() {
        return this.mValue;
    }

    public static Type convert(String r100) {
        Type[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        Type r104 = r101[r103];
        if (r104.getValue().equals(r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static Type valueOf(String r100) {
        return (Type) a.a(Type.class, r100);
    }

    private Type(String r100, int r101, String r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
