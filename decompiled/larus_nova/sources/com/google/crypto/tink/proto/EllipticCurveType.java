package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum EllipticCurveType extends Enum<EllipticCurveType> implements e.a {
    public static final EllipticCurveType CURVE25519 = null;
    public static final int CURVE25519_VALUE = 5;
    public static final EllipticCurveType NIST_P256 = null;
    public static final int NIST_P256_VALUE = 2;
    public static final EllipticCurveType NIST_P384 = null;
    public static final int NIST_P384_VALUE = 3;
    public static final EllipticCurveType NIST_P521 = null;
    public static final int NIST_P521_VALUE = 4;
    public static final EllipticCurveType UNKNOWN_CURVE = null;
    public static final int UNKNOWN_CURVE_VALUE = 0;
    public static final EllipticCurveType UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275763a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EllipticCurveType[] f275764b = null;
    private final int value;

    public class a implements e.b<EllipticCurveType> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275765a = null;

        public b() {
        }

        static {
            f275765a = new b();
        }
    }

    static {
        EllipticCurveType r100 = new EllipticCurveType("UNKNOWN_CURVE", 0, 0);
        UNKNOWN_CURVE = r100;
        EllipticCurveType r101 = new EllipticCurveType("NIST_P256", 1, 2);
        NIST_P256 = r101;
        EllipticCurveType r102 = new EllipticCurveType("NIST_P384", 2, 3);
        NIST_P384 = r102;
        EllipticCurveType r103 = new EllipticCurveType("NIST_P521", 3, 4);
        NIST_P521 = r103;
        EllipticCurveType r104 = new EllipticCurveType("CURVE25519", 4, 5);
        CURVE25519 = r104;
        EllipticCurveType r110 = new EllipticCurveType("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r110;
        f275764b = new EllipticCurveType[]{r100, r101, r102, r103, r104, r110};
        f275763a = new a();
    }

    public static EllipticCurveType[] values() {
        return (EllipticCurveType[]) f275764b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<EllipticCurveType> internalGetValueMap() {
        return f275763a;
    }

    public static e.c internalGetVerifier() {
        return b.f275765a;
    }

    public static EllipticCurveType forNumber(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 2) goto L20;
        if (r100 == 3) goto L18;
        if (r100 == 4) goto L16;
        if (r100 == 5) goto L14;
        return null;
    L14:
        return CURVE25519;
    L16:
        return NIST_P521;
    L18:
        return NIST_P384;
    L20:
        return NIST_P256;
    L22:
        return UNKNOWN_CURVE;
    }

    public static EllipticCurveType valueOf(String r100) {
        return (EllipticCurveType) r27.a.a(EllipticCurveType.class, r100);
    }

    public static EllipticCurveType valueOf(int r100) {
        return forNumber(r100);
    }

    public EllipticCurveType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
