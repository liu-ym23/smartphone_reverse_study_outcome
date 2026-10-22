package com.lynx.animax.base.bridge;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum ReadableType extends Enum<ReadableType> {
    private static final /* synthetic */ ReadableType[] $VALUES = null;
    public static final ReadableType Array = null;
    public static final ReadableType Boolean = null;
    public static final ReadableType ByteArray = null;
    public static final ReadableType Int = null;
    public static final ReadableType Long = null;
    public static final ReadableType LynxObject = null;
    public static final ReadableType Map = null;
    public static final ReadableType Null = null;
    public static final ReadableType Number = null;
    public static final ReadableType PiperData = null;
    public static final ReadableType String = null;

    static {
        ReadableType r100 = new ReadableType("Null", 0);
        Null = r100;
        ReadableType r101 = new ReadableType("Boolean", 1);
        Boolean = r101;
        ReadableType r102 = new ReadableType("Int", 2);
        Int = r102;
        ReadableType r103 = new ReadableType("Number", 3);
        Number = r103;
        ReadableType r104 = new ReadableType("String", 4);
        String = r104;
        ReadableType r105 = new ReadableType("Map", 5);
        Map = r105;
        ReadableType r110 = new ReadableType("Array", 6);
        Array = r110;
        ReadableType r111 = new ReadableType("Long", 7);
        Long = r111;
        ReadableType r112 = new ReadableType("ByteArray", 8);
        ByteArray = r112;
        ReadableType r113 = new ReadableType("PiperData", 9);
        PiperData = r113;
        ReadableType r114 = new ReadableType("LynxObject", 10);
        LynxObject = r114;
        $VALUES = new ReadableType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
    }

    public static ReadableType[] values() {
        return (ReadableType[]) $VALUES.clone();
    }

    public static ReadableType valueOf(String r100) {
        return (ReadableType) a.a(ReadableType.class, r100);
    }

    private ReadableType(String r100, int r101) {
        super(r100, r101);
    }
}
