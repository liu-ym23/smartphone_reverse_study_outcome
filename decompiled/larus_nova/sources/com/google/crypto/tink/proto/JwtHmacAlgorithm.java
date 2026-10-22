package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum JwtHmacAlgorithm extends Enum<JwtHmacAlgorithm> implements e.a {
    public static final JwtHmacAlgorithm HS256 = null;
    public static final int HS256_VALUE = 1;
    public static final JwtHmacAlgorithm HS384 = null;
    public static final int HS384_VALUE = 2;
    public static final JwtHmacAlgorithm HS512 = null;
    public static final int HS512_VALUE = 3;
    public static final JwtHmacAlgorithm HS_UNKNOWN = null;
    public static final int HS_UNKNOWN_VALUE = 0;
    public static final JwtHmacAlgorithm UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ JwtHmacAlgorithm[] f275782b = null;
    private final int value;

    public class a implements e.b<JwtHmacAlgorithm> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275783a = null;

        public b() {
        }

        static {
            f275783a = new b();
        }
    }

    static {
        JwtHmacAlgorithm r100 = new JwtHmacAlgorithm("HS_UNKNOWN", 0, 0);
        HS_UNKNOWN = r100;
        JwtHmacAlgorithm r101 = new JwtHmacAlgorithm("HS256", 1, 1);
        HS256 = r101;
        JwtHmacAlgorithm r102 = new JwtHmacAlgorithm("HS384", 2, 2);
        HS384 = r102;
        JwtHmacAlgorithm r103 = new JwtHmacAlgorithm("HS512", 3, 3);
        HS512 = r103;
        JwtHmacAlgorithm r104 = new JwtHmacAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275782b = new JwtHmacAlgorithm[]{r100, r101, r102, r103, r104};
        f275781a = new a();
    }

    public static JwtHmacAlgorithm[] values() {
        return (JwtHmacAlgorithm[]) f275782b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<JwtHmacAlgorithm> internalGetValueMap() {
        return f275781a;
    }

    public static e.c internalGetVerifier() {
        return b.f275783a;
    }

    public static JwtHmacAlgorithm forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return HS512;
    L14:
        return HS384;
    L16:
        return HS256;
    L18:
        return HS_UNKNOWN;
    }

    public static JwtHmacAlgorithm valueOf(String r100) {
        return (JwtHmacAlgorithm) r27.a.a(JwtHmacAlgorithm.class, r100);
    }

    public static JwtHmacAlgorithm valueOf(int r100) {
        return forNumber(r100);
    }

    public JwtHmacAlgorithm(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
