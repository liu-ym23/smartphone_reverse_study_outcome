package com.bytedance.byted_bach_sdk.buffer;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public class BachObject {
    public BachObjectType infoType;
    public HashMap<String, BachObject> mapResult;
    public AlgorithmResultUnion valueResult;
    public BachObject[] vectorResult;

    public static final enum BachObjectType extends Enum<BachObjectType> {
        private static final /* synthetic */ BachObjectType[] $VALUES = null;
        public static final BachObjectType INFO_TYPE_BITMAP = null;
        public static final BachObjectType INFO_TYPE_BOOL = null;
        public static final BachObjectType INFO_TYPE_BYTEARRAY = null;
        public static final BachObjectType INFO_TYPE_HASHMAP = null;
        public static final BachObjectType INFO_TYPE_INT = null;
        public static final BachObjectType INFO_TYPE_MATXF = null;
        public static final BachObjectType INFO_TYPE_NONE = null;
        public static final BachObjectType INFO_TYPE_REAL = null;
        public static final BachObjectType INFO_TYPE_STRING = null;
        public static final BachObjectType INFO_TYPE_VEC = null;
        public static final BachObjectType INFO_TYPE_VECXF = null;
        public static final BachObjectType INFO_TYPE_VECXI = null;
        public static final BachObjectType INFO_TYPE_VECXS = null;

        static {
            BachObjectType r100 = new BachObjectType("INFO_TYPE_NONE", 0);
            INFO_TYPE_NONE = r100;
            BachObjectType r101 = new BachObjectType("INFO_TYPE_INT", 1);
            INFO_TYPE_INT = r101;
            BachObjectType r102 = new BachObjectType("INFO_TYPE_REAL", 2);
            INFO_TYPE_REAL = r102;
            BachObjectType r103 = new BachObjectType("INFO_TYPE_STRING", 3);
            INFO_TYPE_STRING = r103;
            BachObjectType r104 = new BachObjectType("INFO_TYPE_VECXI", 4);
            INFO_TYPE_VECXI = r104;
            BachObjectType r105 = new BachObjectType("INFO_TYPE_VECXF", 5);
            INFO_TYPE_VECXF = r105;
            BachObjectType r110 = new BachObjectType("INFO_TYPE_VECXS", 6);
            INFO_TYPE_VECXS = r110;
            BachObjectType r111 = new BachObjectType("INFO_TYPE_MATXF", 7);
            INFO_TYPE_MATXF = r111;
            BachObjectType r112 = new BachObjectType("INFO_TYPE_BITMAP", 8);
            INFO_TYPE_BITMAP = r112;
            BachObjectType r113 = new BachObjectType("INFO_TYPE_HASHMAP", 9);
            INFO_TYPE_HASHMAP = r113;
            BachObjectType r114 = new BachObjectType("INFO_TYPE_VEC", 10);
            INFO_TYPE_VEC = r114;
            BachObjectType r115 = new BachObjectType("INFO_TYPE_BYTEARRAY", 11);
            INFO_TYPE_BYTEARRAY = r115;
            BachObjectType r106 = new BachObjectType("INFO_TYPE_BOOL", 12);
            INFO_TYPE_BOOL = r106;
            $VALUES = new BachObjectType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        }

        public static BachObjectType[] values() {
            return (BachObjectType[]) $VALUES.clone();
        }

        public static BachObjectType valueOf(String r100) {
            return (BachObjectType) a.a(BachObjectType.class, r100);
        }

        private BachObjectType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BachObject() {
        this.infoType = BachObjectType.INFO_TYPE_NONE;
    }
}
