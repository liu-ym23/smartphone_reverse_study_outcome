package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final enum Field$Kind extends Enum<Field$Kind> implements e.a {
    public static final Field$Kind TYPE_BOOL = null;
    public static final int TYPE_BOOL_VALUE = 8;
    public static final Field$Kind TYPE_BYTES = null;
    public static final int TYPE_BYTES_VALUE = 12;
    public static final Field$Kind TYPE_DOUBLE = null;
    public static final int TYPE_DOUBLE_VALUE = 1;
    public static final Field$Kind TYPE_ENUM = null;
    public static final int TYPE_ENUM_VALUE = 14;
    public static final Field$Kind TYPE_FIXED32 = null;
    public static final int TYPE_FIXED32_VALUE = 7;
    public static final Field$Kind TYPE_FIXED64 = null;
    public static final int TYPE_FIXED64_VALUE = 6;
    public static final Field$Kind TYPE_FLOAT = null;
    public static final int TYPE_FLOAT_VALUE = 2;
    public static final Field$Kind TYPE_GROUP = null;
    public static final int TYPE_GROUP_VALUE = 10;
    public static final Field$Kind TYPE_INT32 = null;
    public static final int TYPE_INT32_VALUE = 5;
    public static final Field$Kind TYPE_INT64 = null;
    public static final int TYPE_INT64_VALUE = 3;
    public static final Field$Kind TYPE_MESSAGE = null;
    public static final int TYPE_MESSAGE_VALUE = 11;
    public static final Field$Kind TYPE_SFIXED32 = null;
    public static final int TYPE_SFIXED32_VALUE = 15;
    public static final Field$Kind TYPE_SFIXED64 = null;
    public static final int TYPE_SFIXED64_VALUE = 16;
    public static final Field$Kind TYPE_SINT32 = null;
    public static final int TYPE_SINT32_VALUE = 17;
    public static final Field$Kind TYPE_SINT64 = null;
    public static final int TYPE_SINT64_VALUE = 18;
    public static final Field$Kind TYPE_STRING = null;
    public static final int TYPE_STRING_VALUE = 9;
    public static final Field$Kind TYPE_UINT32 = null;
    public static final int TYPE_UINT32_VALUE = 13;
    public static final Field$Kind TYPE_UINT64 = null;
    public static final int TYPE_UINT64_VALUE = 4;
    public static final Field$Kind TYPE_UNKNOWN = null;
    public static final int TYPE_UNKNOWN_VALUE = 0;
    public static final Field$Kind UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Field$Kind[] f275817b = null;
    private final int value;

    public class a implements e.b<Field$Kind> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275818a = null;

        public b() {
        }

        static {
            f275818a = new b();
        }
    }

    static {
        Field$Kind r100 = new Field$Kind("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = r100;
        Field$Kind r101 = new Field$Kind("TYPE_DOUBLE", 1, 1);
        TYPE_DOUBLE = r101;
        Field$Kind r102 = new Field$Kind("TYPE_FLOAT", 2, 2);
        TYPE_FLOAT = r102;
        Field$Kind r103 = new Field$Kind("TYPE_INT64", 3, 3);
        TYPE_INT64 = r103;
        Field$Kind r104 = new Field$Kind("TYPE_UINT64", 4, 4);
        TYPE_UINT64 = r104;
        Field$Kind r105 = new Field$Kind("TYPE_INT32", 5, 5);
        TYPE_INT32 = r105;
        Field$Kind r110 = new Field$Kind("TYPE_FIXED64", 6, 6);
        TYPE_FIXED64 = r110;
        Field$Kind r111 = new Field$Kind("TYPE_FIXED32", 7, 7);
        TYPE_FIXED32 = r111;
        Field$Kind r112 = new Field$Kind("TYPE_BOOL", 8, 8);
        TYPE_BOOL = r112;
        Field$Kind r113 = new Field$Kind("TYPE_STRING", 9, 9);
        TYPE_STRING = r113;
        Field$Kind r114 = new Field$Kind("TYPE_GROUP", 10, 10);
        TYPE_GROUP = r114;
        Field$Kind r115 = new Field$Kind("TYPE_MESSAGE", 11, 11);
        TYPE_MESSAGE = r115;
        Field$Kind r106 = new Field$Kind("TYPE_BYTES", 12, 12);
        TYPE_BYTES = r106;
        Field$Kind r107 = new Field$Kind("TYPE_UINT32", 13, 13);
        TYPE_UINT32 = r107;
        Field$Kind r108 = new Field$Kind("TYPE_ENUM", 14, 14);
        TYPE_ENUM = r108;
        Field$Kind r109 = new Field$Kind("TYPE_SFIXED32", 15, 15);
        TYPE_SFIXED32 = r109;
        Field$Kind r116 = new Field$Kind("TYPE_SFIXED64", 16, 16);
        TYPE_SFIXED64 = r116;
        Field$Kind r117 = new Field$Kind("TYPE_SINT32", 17, 17);
        TYPE_SINT32 = r117;
        Field$Kind r118 = new Field$Kind("TYPE_SINT64", 18, 18);
        TYPE_SINT64 = r118;
        Field$Kind r119 = new Field$Kind("UNRECOGNIZED", 19, -1);
        UNRECOGNIZED = r119;
        f275817b = new Field$Kind[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        f275816a = new a();
    }

    public static Field$Kind[] values() {
        return (Field$Kind[]) f275817b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<Field$Kind> internalGetValueMap() {
        return f275816a;
    }

    public static e.c internalGetVerifier() {
        return b.f275818a;
    }

    public static Field$Kind forNumber(int r100) {
        switch(r100) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L36;
            case 4: goto L34;
            case 5: goto L32;
            case 6: goto L30;
            case 7: goto L28;
            case 8: goto L26;
            case 9: goto L24;
            case 10: goto L22;
            case 11: goto L20;
            case 12: goto L18;
            case 13: goto L16;
            case 14: goto L14;
            case 15: goto L12;
            case 16: goto L10;
            case 17: goto L8;
            case 18: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return TYPE_SINT64;
    L8:
        return TYPE_SINT32;
    L10:
        return TYPE_SFIXED64;
    L12:
        return TYPE_SFIXED32;
    L14:
        return TYPE_ENUM;
    L16:
        return TYPE_UINT32;
    L18:
        return TYPE_BYTES;
    L20:
        return TYPE_MESSAGE;
    L22:
        return TYPE_GROUP;
    L24:
        return TYPE_STRING;
    L26:
        return TYPE_BOOL;
    L28:
        return TYPE_FIXED32;
    L30:
        return TYPE_FIXED64;
    L32:
        return TYPE_INT32;
    L34:
        return TYPE_UINT64;
    L36:
        return TYPE_INT64;
    L38:
        return TYPE_FLOAT;
    L40:
        return TYPE_DOUBLE;
    L42:
        return TYPE_UNKNOWN;
    }

    public static Field$Kind valueOf(String r100) {
        return (Field$Kind) r27.a.a(Field$Kind.class, r100);
    }

    public static Field$Kind valueOf(int r100) {
        return forNumber(r100);
    }

    public Field$Kind(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
