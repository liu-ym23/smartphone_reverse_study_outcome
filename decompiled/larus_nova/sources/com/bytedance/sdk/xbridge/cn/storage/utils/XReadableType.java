package com.bytedance.sdk.xbridge.cn.storage.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/XReadableType;", "", "Null", "Boolean", "Number", "Int", "String", "Map", "Array", "Long", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum XReadableType extends Enum<XReadableType> {
    public static final XReadableType Array = null;
    public static final XReadableType Boolean = null;
    public static final XReadableType Int = null;
    public static final XReadableType Long = null;
    public static final XReadableType Map = null;
    public static final XReadableType Null = null;
    public static final XReadableType Number = null;
    public static final XReadableType String = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XReadableType[] f270151a = null;

    public static XReadableType valueOf(String r100) {
        return (XReadableType) r27.a.a(XReadableType.class, r100);
    }

    public static XReadableType[] values() {
        return (XReadableType[]) f270151a.clone();
    }

    static {
        XReadableType r100 = new XReadableType("Null", 0);
        Null = r100;
        XReadableType r101 = new XReadableType("Boolean", 1);
        Boolean = r101;
        XReadableType r102 = new XReadableType("Number", 2);
        Number = r102;
        XReadableType r103 = new XReadableType("Int", 3);
        Int = r103;
        XReadableType r104 = new XReadableType("String", 4);
        String = r104;
        XReadableType r105 = new XReadableType("Map", 5);
        Map = r105;
        XReadableType r110 = new XReadableType("Array", 6);
        Array = r110;
        XReadableType r111 = new XReadableType("Long", 7);
        Long = r111;
        f270151a = new XReadableType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public XReadableType(String r100, int r101) {
        super(r100, r101);
    }
}
