package kotlin.reflect.jvm.internal.impl.protobuf;

import androidx.camera.video.AudioStats;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final class WireFormat {
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static enum FieldType extends Enum<FieldType> {
        private static final /* synthetic */ FieldType[] $VALUES = null;
        public static final FieldType BOOL = null;
        public static final FieldType BYTES = null;
        public static final FieldType DOUBLE = null;
        public static final FieldType ENUM = null;
        public static final FieldType FIXED32 = null;
        public static final FieldType FIXED64 = null;
        public static final FieldType FLOAT = null;
        public static final FieldType GROUP = null;
        public static final FieldType INT32 = null;
        public static final FieldType INT64 = null;
        public static final FieldType MESSAGE = null;
        public static final FieldType SFIXED32 = null;
        public static final FieldType SFIXED64 = null;
        public static final FieldType SINT32 = null;
        public static final FieldType SINT64 = null;
        public static final FieldType STRING = null;
        public static final FieldType UINT32 = null;
        public static final FieldType UINT64 = null;
        private final JavaType javaType;
        private final int wireType;

        public boolean isPackable() {
            return true;
        }

        static {
            FieldType r100 = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            DOUBLE = r100;
            FieldType r101 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            FLOAT = r101;
            JavaType r102 = JavaType.LONG;
            final int r103 = 2;
            FieldType r104 = new FieldType("INT64", 2, r102, 0);
            INT64 = r104;
            final int r110 = 3;
            FieldType r105 = new FieldType("UINT64", 3, r102, 0);
            UINT64 = r105;
            JavaType r111 = JavaType.INT;
            FieldType r106 = new FieldType("INT32", 4, r111, 0);
            INT32 = r106;
            FieldType r112 = new FieldType("FIXED64", 5, r102, 1);
            FIXED64 = r112;
            FieldType r113 = new FieldType("FIXED32", 6, r111, 5);
            FIXED32 = r113;
            FieldType r114 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            BOOL = r114;
            final JavaType r115 = JavaType.STRING;
            final String r107 = "STRING";
            final int r108 = 8;
            FieldType r109 = new AnonymousClass1(r107, r108, r115, r103);
            STRING = r109;
            final JavaType r116 = JavaType.MESSAGE;
            final String r117 = "GROUP";
            final int r118 = 9;
            FieldType r119 = new AnonymousClass2(r117, r118, r116, r110);
            GROUP = r119;
            final String r120 = "MESSAGE";
            final int r121 = 10;
            final int r122 = 2;
            FieldType r123 = new AnonymousClass3(r120, r121, r116, r122);
            MESSAGE = r123;
            final JavaType r124 = JavaType.BYTE_STRING;
            final String r125 = "BYTES";
            final int r126 = 11;
            FieldType r127 = new AnonymousClass4(r125, r126, r124, r122);
            BYTES = r127;
            FieldType r128 = new FieldType("UINT32", 12, r111, 0);
            UINT32 = r128;
            FieldType r129 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            ENUM = r129;
            FieldType r130 = new FieldType("SFIXED32", 14, r111, 5);
            SFIXED32 = r130;
            FieldType r131 = new FieldType("SFIXED64", 15, r102, 1);
            SFIXED64 = r131;
            FieldType r132 = new FieldType("SINT32", 16, r111, 0);
            SINT32 = r132;
            FieldType r133 = new FieldType("SINT64", 17, r102, 0);
            SINT64 = r133;
            $VALUES = new FieldType[]{r100, r101, r104, r105, r106, r112, r113, r114, r109, r119, r123, r127, r128, r129, r130, r131, r132, r133};
        }

        public static FieldType[] values() {
            return (FieldType[]) $VALUES.clone();
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public static FieldType valueOf(String r100) {
            return (FieldType) a.a(FieldType.class, r100);
        }

        private FieldType(String r100, int r101, JavaType r102, int r103) {
            super(r100, r101);
            this.javaType = r102;
            this.wireType = r103;
        }

        public /* synthetic */ FieldType(String r100, int r101, JavaType r102, int r103, AnonymousClass1 r104) {
            this(r100, r101, r102, r103);
        }
    }

    public static final enum JavaType extends Enum<JavaType> {
        private static final /* synthetic */ JavaType[] $VALUES = null;
        public static final JavaType BOOLEAN = null;
        public static final JavaType BYTE_STRING = null;
        public static final JavaType DOUBLE = null;
        public static final JavaType ENUM = null;
        public static final JavaType FLOAT = null;
        public static final JavaType INT = null;
        public static final JavaType LONG = null;
        public static final JavaType MESSAGE = null;
        public static final JavaType STRING = null;
        private final Object defaultDefault;

        static {
            JavaType r100 = new JavaType("INT", 0, 0);
            INT = r100;
            JavaType r101 = new JavaType("LONG", 1, 0L);
            LONG = r101;
            JavaType r102 = new JavaType("FLOAT", 2, Float.valueOf(0.0f));
            FLOAT = r102;
            JavaType r103 = new JavaType("DOUBLE", 3, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
            DOUBLE = r103;
            JavaType r104 = new JavaType("BOOLEAN", 4, Boolean.FALSE);
            BOOLEAN = r104;
            JavaType r105 = new JavaType("STRING", 5, "");
            STRING = r105;
            JavaType r110 = new JavaType("BYTE_STRING", 6, ByteString.EMPTY);
            BYTE_STRING = r110;
            JavaType r111 = new JavaType("ENUM", 7, null);
            ENUM = r111;
            JavaType r112 = new JavaType("MESSAGE", 8, null);
            MESSAGE = r112;
            $VALUES = new JavaType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        }

        public static JavaType[] values() {
            return (JavaType[]) $VALUES.clone();
        }

        public static JavaType valueOf(String r100) {
            return (JavaType) a.a(JavaType.class, r100);
        }

        private JavaType(String r100, int r101, Object r102) {
            super(r100, r101);
            this.defaultDefault = r102;
        }
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    public static int getTagFieldNumber(int r100) {
        return r100 >>> 3;
    }

    public static int getTagWireType(int r100) {
        return r100 & 7;
    }

    public static int makeTag(int r100, int r101) {
        return (r100 << 3) | r101;
    }
}
