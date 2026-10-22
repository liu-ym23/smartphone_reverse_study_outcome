package com.bytedance.memory.shrink;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final enum BaseType extends Enum<BaseType> {
    public static final BaseType BOOLEAN = null;
    public static final BaseType BYTE = null;
    public static final BaseType CHAR = null;
    public static final BaseType DOUBLE = null;
    public static final BaseType FLOAT = null;
    public static final BaseType INT = null;
    public static final BaseType LONG = null;
    public static final BaseType OBJECT = null;
    public static final BaseType SHORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, BaseType> f265500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ BaseType[] f265501b = null;
    private int mId;
    private int mSize;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f265502a = null;

        static {
            int[] r100 = new int[BaseType.values().length];
            f265502a = r100;
            r100[BaseType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            f265502a[BaseType.CHAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            f265502a[BaseType.FLOAT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            f265502a[BaseType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            f265502a[BaseType.BYTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            f265502a[BaseType.SHORT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            f265502a[BaseType.INT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            f265502a[BaseType.LONG.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        int r100 = 0;
        BaseType r101 = new BaseType("OBJECT", 0, 2, 0);
        OBJECT = r101;
        BaseType r102 = new BaseType("BOOLEAN", 1, 4, 1);
        BOOLEAN = r102;
        BaseType r103 = new BaseType("CHAR", 2, 5, 2);
        CHAR = r103;
        BaseType r104 = new BaseType("FLOAT", 3, 6, 4);
        FLOAT = r104;
        BaseType r105 = new BaseType("DOUBLE", 4, 7, 8);
        DOUBLE = r105;
        BaseType r110 = new BaseType("BYTE", 5, 8, 1);
        BYTE = r110;
        BaseType r111 = new BaseType("SHORT", 6, 9, 2);
        SHORT = r111;
        BaseType r106 = new BaseType("INT", 7, 10, 4);
        INT = r106;
        BaseType r107 = new BaseType("LONG", 8, 11, 8);
        LONG = r107;
        f265501b = new BaseType[]{r101, r102, r103, r104, r105, r110, r111, r106, r107};
        f265500a = new HashMap();
        BaseType[] r108 = values();
        int r109 = r108.length;
    L3:
        if (r100 >= r109) goto L5;
        BaseType r112 = r108[r100];
        f265500a.put(Integer.valueOf(r112.mId), r112);
        r100 = r100 + 1;
        goto L3
    }

    public static BaseType[] values() {
        return (BaseType[]) f265501b.clone();
    }

    public int getTypeId() {
        return this.mId;
    }

    public static String getClassNameOfPrimitiveArray(BaseType r100) {
        switch(a.f265502a[r100.ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        return "long[]";
    L8:
        return "int[]";
    L10:
        return "short[]";
    L12:
        return "byte[]";
    L14:
        return "double[]";
    L16:
        return "float[]";
    L18:
        return "char[]";
    L20:
        return "boolean[]";
    L5:
        throw new IllegalArgumentException("OBJECT type is not a primitive type");
    }

    public static BaseType getType(int r100) {
        Map<Integer, BaseType> r101 = f265500a;
        HashMap r102 = (HashMap) r101;
        return (BaseType) r102.get(Integer.valueOf(r100));
    }

    public static BaseType valueOf(String r100) {
        return (BaseType) r27.a.a(BaseType.class, r100);
    }

    public int getSize(int r100) {
        int r101 = this.mSize;
        if (r101 != 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    public BaseType(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.mId = r102;
        this.mSize = r103;
    }
}
