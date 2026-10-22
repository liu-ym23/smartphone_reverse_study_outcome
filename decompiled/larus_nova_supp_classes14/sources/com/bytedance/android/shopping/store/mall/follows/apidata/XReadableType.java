package com.bytedance.android.shopping.store.mall.follows.apidata;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0083\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/apidata/XReadableType;", "", "(Ljava/lang/String;I)V", "Null", "Boolean", "Number", "Int", "String", "Map", "Array", "Long", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final enum XReadableType extends Enum<XReadableType> {
    private static final /* synthetic */ XReadableType[] $VALUES = null;
    public static final XReadableType Array = null;
    public static final XReadableType Boolean = null;
    public static final XReadableType Int = null;
    public static final XReadableType Long = null;
    public static final XReadableType Map = null;
    public static final XReadableType Null = null;
    public static final XReadableType Number = null;
    public static final XReadableType String = null;

    static {
        XReadableType r1 = new XReadableType("Null", 0);
        Null = r1;
        XReadableType r2 = new XReadableType("Boolean", 1);
        Boolean = r2;
        XReadableType r3 = new XReadableType("Number", 2);
        Number = r3;
        XReadableType r4 = new XReadableType("Int", 3);
        Int = r4;
        XReadableType r5 = new XReadableType("String", 4);
        String = r5;
        XReadableType r6 = new XReadableType("Map", 5);
        Map = r6;
        XReadableType r7 = new XReadableType("Array", 6);
        Array = r7;
        XReadableType r8 = new XReadableType("Long", 7);
        Long = r8;
        $VALUES = new XReadableType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public static XReadableType valueOf(String r1) {
        return (XReadableType) r27.a.a(XReadableType.class, r1);
    }

    public static XReadableType[] values() {
        return (XReadableType[]) $VALUES.clone();
    }

    private XReadableType(String r1, int r2) {
        super(r1, r2);
    }
}
