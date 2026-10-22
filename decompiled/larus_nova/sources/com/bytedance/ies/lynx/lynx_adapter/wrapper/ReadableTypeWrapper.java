package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableTypeWrapper;", "", "(Ljava/lang/String;I)V", "Null", "Boolean", "Int", "Number", "String", "Map", "Array", "Long", "ByteArray", "lynx-adapter_release"}, k = 1, mv = {1, 1, 15})
public final enum ReadableTypeWrapper extends Enum<ReadableTypeWrapper> {
    private static final /* synthetic */ ReadableTypeWrapper[] $VALUES = null;
    public static final ReadableTypeWrapper Array = null;
    public static final ReadableTypeWrapper Boolean = null;
    public static final ReadableTypeWrapper ByteArray = null;
    public static final ReadableTypeWrapper Int = null;
    public static final ReadableTypeWrapper Long = null;
    public static final ReadableTypeWrapper Map = null;
    public static final ReadableTypeWrapper Null = null;
    public static final ReadableTypeWrapper Number = null;
    public static final ReadableTypeWrapper String = null;

    static {
        ReadableTypeWrapper r100 = new ReadableTypeWrapper("Null", 0);
        Null = r100;
        ReadableTypeWrapper r101 = new ReadableTypeWrapper("Boolean", 1);
        Boolean = r101;
        ReadableTypeWrapper r102 = new ReadableTypeWrapper("Int", 2);
        Int = r102;
        ReadableTypeWrapper r103 = new ReadableTypeWrapper("Number", 3);
        Number = r103;
        ReadableTypeWrapper r104 = new ReadableTypeWrapper("String", 4);
        String = r104;
        ReadableTypeWrapper r105 = new ReadableTypeWrapper("Map", 5);
        Map = r105;
        ReadableTypeWrapper r106 = new ReadableTypeWrapper("Array", 6);
        Array = r106;
        ReadableTypeWrapper r107 = new ReadableTypeWrapper("Long", 7);
        Long = r107;
        ReadableTypeWrapper r108 = new ReadableTypeWrapper("ByteArray", 8);
        ByteArray = r108;
        $VALUES = new ReadableTypeWrapper[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static ReadableTypeWrapper valueOf(String r100) {
        return (ReadableTypeWrapper) a.a(ReadableTypeWrapper.class, r100);
    }

    public static ReadableTypeWrapper[] values() {
        return (ReadableTypeWrapper[]) $VALUES.clone();
    }

    private ReadableTypeWrapper(String r100, int r101) {
        super(r100, r101);
    }
}
