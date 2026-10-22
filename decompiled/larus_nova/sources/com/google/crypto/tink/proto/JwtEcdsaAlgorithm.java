package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum JwtEcdsaAlgorithm extends Enum<JwtEcdsaAlgorithm> implements e.a {
    public static final JwtEcdsaAlgorithm ES256 = null;
    public static final int ES256_VALUE = 1;
    public static final JwtEcdsaAlgorithm ES384 = null;
    public static final int ES384_VALUE = 2;
    public static final JwtEcdsaAlgorithm ES512 = null;
    public static final int ES512_VALUE = 3;
    public static final JwtEcdsaAlgorithm ES_UNKNOWN = null;
    public static final int ES_UNKNOWN_VALUE = 0;
    public static final JwtEcdsaAlgorithm UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275778a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ JwtEcdsaAlgorithm[] f275779b = null;
    private final int value;

    public class a implements e.b<JwtEcdsaAlgorithm> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275780a = null;

        public b() {
        }

        static {
            f275780a = new b();
        }
    }

    static {
        JwtEcdsaAlgorithm r100 = new JwtEcdsaAlgorithm("ES_UNKNOWN", 0, 0);
        ES_UNKNOWN = r100;
        JwtEcdsaAlgorithm r101 = new JwtEcdsaAlgorithm("ES256", 1, 1);
        ES256 = r101;
        JwtEcdsaAlgorithm r102 = new JwtEcdsaAlgorithm("ES384", 2, 2);
        ES384 = r102;
        JwtEcdsaAlgorithm r103 = new JwtEcdsaAlgorithm("ES512", 3, 3);
        ES512 = r103;
        JwtEcdsaAlgorithm r104 = new JwtEcdsaAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275779b = new JwtEcdsaAlgorithm[]{r100, r101, r102, r103, r104};
        f275778a = new a();
    }

    public static JwtEcdsaAlgorithm[] values() {
        return (JwtEcdsaAlgorithm[]) f275779b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<JwtEcdsaAlgorithm> internalGetValueMap() {
        return f275778a;
    }

    public static e.c internalGetVerifier() {
        return b.f275780a;
    }

    public static JwtEcdsaAlgorithm forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return ES512;
    L14:
        return ES384;
    L16:
        return ES256;
    L18:
        return ES_UNKNOWN;
    }

    public static JwtEcdsaAlgorithm valueOf(String r100) {
        return (JwtEcdsaAlgorithm) r27.a.a(JwtEcdsaAlgorithm.class, r100);
    }

    public static JwtEcdsaAlgorithm valueOf(int r100) {
        return forNumber(r100);
    }

    public JwtEcdsaAlgorithm(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
