package com.google.protobuf;

import androidx.camera.video.AudioStats;
import java.io.IOException;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class WireFormat {
    static final int FIXED32_SIZE = 4;
    static final int FIXED64_SIZE = 8;
    static final int MAX_VARINT32_SIZE = 5;
    static final int MAX_VARINT64_SIZE = 10;
    static final int MAX_VARINT_SIZE = 10;
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_ITEM_END_TAG = 0;
    static final int MESSAGE_SET_ITEM_TAG = 0;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_MESSAGE_TAG = 0;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int MESSAGE_SET_TYPE_ID_TAG = 0;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;

    /* JADX INFO: renamed from: com.google.protobuf.WireFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = null;

        static {
            int[] r100 = new int[FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = r100;
            r100[FieldType.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public static enum FieldType extends java.lang.Enum<FieldType> {
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

    public static final enum JavaType extends java.lang.Enum<JavaType> {
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

        public Object getDefaultDefault() {
            return this.defaultDefault;
        }

        public static JavaType valueOf(String r100) {
            return (JavaType) a.a(JavaType.class, r100);
        }

        private JavaType(String r100, int r101, Object r102) {
            super(r100, r101);
            this.defaultDefault = r102;
        }
    }

    public static abstract enum Utf8Validation extends java.lang.Enum<Utf8Validation> {
        private static final /* synthetic */ Utf8Validation[] $VALUES = null;
        public static final Utf8Validation LAZY = null;
        public static final Utf8Validation LOOSE = null;
        public static final Utf8Validation STRICT = null;

        public abstract Object readString(CodedInputStream r100) throws IOException;

        static {
            final String r100 = "LOOSE";
            final int r101 = 0;
            Utf8Validation r102 = new AnonymousClass1(r100, r101);
            LOOSE = r102;
            final String r103 = "STRICT";
            final int r104 = 1;
            Utf8Validation r105 = new AnonymousClass2(r103, r104);
            STRICT = r105;
            final String r106 = "LAZY";
            final int r107 = 2;
            Utf8Validation r108 = new AnonymousClass3(r106, r107);
            LAZY = r108;
            $VALUES = new Utf8Validation[]{r102, r105, r108};
        }

        public static Utf8Validation[] values() {
            return (Utf8Validation[]) $VALUES.clone();
        }

        public static Utf8Validation valueOf(String r100) {
            return (Utf8Validation) a.a(Utf8Validation.class, r100);
        }

        private Utf8Validation(String r100, int r101) {
            super(r100, r101);
        }

        public /* synthetic */ Utf8Validation(String r100, int r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }

    private WireFormat() {
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

    public static Object readPrimitiveField(CodedInputStream r100, FieldType r101, Utf8Validation r102) throws IOException {
        switch(AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[r101.ordinal()]) {
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return r102.readString(r100);
    L15:
        return Long.valueOf(r100.readSInt64());
    L17:
        return Integer.valueOf(r100.readSInt32());
    L19:
        return Long.valueOf(r100.readSFixed64());
    L21:
        return Integer.valueOf(r100.readSFixed32());
    L23:
        return Integer.valueOf(r100.readUInt32());
    L25:
        return r100.readBytes();
    L27:
        return Boolean.valueOf(r100.readBool());
    L29:
        return Integer.valueOf(r100.readFixed32());
    L31:
        return Long.valueOf(r100.readFixed64());
    L33:
        return Integer.valueOf(r100.readInt32());
    L35:
        return Long.valueOf(r100.readUInt64());
    L37:
        return Long.valueOf(r100.readInt64());
    L39:
        return Float.valueOf(r100.readFloat());
    L41:
        return Double.valueOf(r100.readDouble());
    }
}
