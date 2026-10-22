package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final enum Value$KindCase extends Enum<Value$KindCase> {
    public static final Value$KindCase BOOL_VALUE = null;
    public static final Value$KindCase KIND_NOT_SET = null;
    public static final Value$KindCase LIST_VALUE = null;
    public static final Value$KindCase NULL_VALUE = null;
    public static final Value$KindCase NUMBER_VALUE = null;
    public static final Value$KindCase STRING_VALUE = null;
    public static final Value$KindCase STRUCT_VALUE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Value$KindCase[] f275850a = null;
    private final int value;

    static {
        Value$KindCase r100 = new Value$KindCase("NULL_VALUE", 0, 1);
        NULL_VALUE = r100;
        Value$KindCase r101 = new Value$KindCase("NUMBER_VALUE", 1, 2);
        NUMBER_VALUE = r101;
        Value$KindCase r102 = new Value$KindCase("STRING_VALUE", 2, 3);
        STRING_VALUE = r102;
        Value$KindCase r103 = new Value$KindCase("BOOL_VALUE", 3, 4);
        BOOL_VALUE = r103;
        Value$KindCase r104 = new Value$KindCase("STRUCT_VALUE", 4, 5);
        STRUCT_VALUE = r104;
        Value$KindCase r110 = new Value$KindCase("LIST_VALUE", 5, 6);
        LIST_VALUE = r110;
        Value$KindCase r111 = new Value$KindCase("KIND_NOT_SET", 6, 0);
        KIND_NOT_SET = r111;
        f275850a = new Value$KindCase[]{r100, r101, r102, r103, r104, r110, r111};
    }

    public static Value$KindCase[] values() {
        return (Value$KindCase[]) f275850a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static Value$KindCase forNumber(int r100) {
        switch(r100) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return LIST_VALUE;
    L8:
        return STRUCT_VALUE;
    L10:
        return BOOL_VALUE;
    L12:
        return STRING_VALUE;
    L14:
        return NUMBER_VALUE;
    L16:
        return NULL_VALUE;
    L18:
        return KIND_NOT_SET;
    }

    public static Value$KindCase valueOf(String r100) {
        return (Value$KindCase) r27.a.a(Value$KindCase.class, r100);
    }

    public static Value$KindCase valueOf(int r100) {
        return forNumber(r100);
    }

    public Value$KindCase(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
