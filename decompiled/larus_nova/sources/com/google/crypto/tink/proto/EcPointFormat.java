package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum EcPointFormat extends Enum<EcPointFormat> implements e.a {
    public static final EcPointFormat COMPRESSED = null;
    public static final int COMPRESSED_VALUE = 2;
    public static final EcPointFormat DO_NOT_USE_CRUNCHY_UNCOMPRESSED = null;
    public static final int DO_NOT_USE_CRUNCHY_UNCOMPRESSED_VALUE = 3;
    public static final EcPointFormat UNCOMPRESSED = null;
    public static final int UNCOMPRESSED_VALUE = 1;
    public static final EcPointFormat UNKNOWN_FORMAT = null;
    public static final int UNKNOWN_FORMAT_VALUE = 0;
    public static final EcPointFormat UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275757a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EcPointFormat[] f275758b = null;
    private final int value;

    public class a implements e.b<EcPointFormat> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275759a = null;

        public b() {
        }

        static {
            f275759a = new b();
        }
    }

    static {
        EcPointFormat r100 = new EcPointFormat("UNKNOWN_FORMAT", 0, 0);
        UNKNOWN_FORMAT = r100;
        EcPointFormat r101 = new EcPointFormat("UNCOMPRESSED", 1, 1);
        UNCOMPRESSED = r101;
        EcPointFormat r102 = new EcPointFormat("COMPRESSED", 2, 2);
        COMPRESSED = r102;
        EcPointFormat r103 = new EcPointFormat("DO_NOT_USE_CRUNCHY_UNCOMPRESSED", 3, 3);
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED = r103;
        EcPointFormat r104 = new EcPointFormat("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275758b = new EcPointFormat[]{r100, r101, r102, r103, r104};
        f275757a = new a();
    }

    public static EcPointFormat[] values() {
        return (EcPointFormat[]) f275758b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<EcPointFormat> internalGetValueMap() {
        return f275757a;
    }

    public static e.c internalGetVerifier() {
        return b.f275759a;
    }

    public static EcPointFormat forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
    L14:
        return COMPRESSED;
    L16:
        return UNCOMPRESSED;
    L18:
        return UNKNOWN_FORMAT;
    }

    public static EcPointFormat valueOf(String r100) {
        return (EcPointFormat) r27.a.a(EcPointFormat.class, r100);
    }

    public static EcPointFormat valueOf(int r100) {
        return forNumber(r100);
    }

    public EcPointFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
