package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public final enum Field$Cardinality extends Enum<Field$Cardinality> implements e.a {
    public static final Field$Cardinality CARDINALITY_OPTIONAL = null;
    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    public static final Field$Cardinality CARDINALITY_REPEATED = null;
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    public static final Field$Cardinality CARDINALITY_REQUIRED = null;
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    public static final Field$Cardinality CARDINALITY_UNKNOWN = null;
    public static final int CARDINALITY_UNKNOWN_VALUE = 0;
    public static final Field$Cardinality UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ Field$Cardinality[] f275814b = null;
    private final int value;

    public class a implements e.b<Field$Cardinality> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275815a = null;

        public b() {
        }

        static {
            f275815a = new b();
        }
    }

    static {
        Field$Cardinality r100 = new Field$Cardinality("CARDINALITY_UNKNOWN", 0, 0);
        CARDINALITY_UNKNOWN = r100;
        Field$Cardinality r101 = new Field$Cardinality("CARDINALITY_OPTIONAL", 1, 1);
        CARDINALITY_OPTIONAL = r101;
        Field$Cardinality r102 = new Field$Cardinality("CARDINALITY_REQUIRED", 2, 2);
        CARDINALITY_REQUIRED = r102;
        Field$Cardinality r103 = new Field$Cardinality("CARDINALITY_REPEATED", 3, 3);
        CARDINALITY_REPEATED = r103;
        Field$Cardinality r104 = new Field$Cardinality("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275814b = new Field$Cardinality[]{r100, r101, r102, r103, r104};
        f275813a = new a();
    }

    public static Field$Cardinality[] values() {
        return (Field$Cardinality[]) f275814b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<Field$Cardinality> internalGetValueMap() {
        return f275813a;
    }

    public static e.c internalGetVerifier() {
        return b.f275815a;
    }

    public static Field$Cardinality forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return CARDINALITY_REPEATED;
    L14:
        return CARDINALITY_REQUIRED;
    L16:
        return CARDINALITY_OPTIONAL;
    L18:
        return CARDINALITY_UNKNOWN;
    }

    public static Field$Cardinality valueOf(String r100) {
        return (Field$Cardinality) r27.a.a(Field$Cardinality.class, r100);
    }

    public static Field$Cardinality valueOf(int r100) {
        return forNumber(r100);
    }

    public Field$Cardinality(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
