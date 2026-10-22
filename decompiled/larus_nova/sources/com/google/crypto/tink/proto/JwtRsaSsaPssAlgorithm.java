package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum JwtRsaSsaPssAlgorithm extends Enum<JwtRsaSsaPssAlgorithm> implements e.a {
    public static final JwtRsaSsaPssAlgorithm PS256 = null;
    public static final int PS256_VALUE = 1;
    public static final JwtRsaSsaPssAlgorithm PS384 = null;
    public static final int PS384_VALUE = 2;
    public static final JwtRsaSsaPssAlgorithm PS512 = null;
    public static final int PS512_VALUE = 3;
    public static final JwtRsaSsaPssAlgorithm PS_UNKNOWN = null;
    public static final int PS_UNKNOWN_VALUE = 0;
    public static final JwtRsaSsaPssAlgorithm UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ JwtRsaSsaPssAlgorithm[] f275788b = null;
    private final int value;

    public class a implements e.b<JwtRsaSsaPssAlgorithm> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275789a = null;

        public b() {
        }

        static {
            f275789a = new b();
        }
    }

    static {
        JwtRsaSsaPssAlgorithm r100 = new JwtRsaSsaPssAlgorithm("PS_UNKNOWN", 0, 0);
        PS_UNKNOWN = r100;
        JwtRsaSsaPssAlgorithm r101 = new JwtRsaSsaPssAlgorithm("PS256", 1, 1);
        PS256 = r101;
        JwtRsaSsaPssAlgorithm r102 = new JwtRsaSsaPssAlgorithm("PS384", 2, 2);
        PS384 = r102;
        JwtRsaSsaPssAlgorithm r103 = new JwtRsaSsaPssAlgorithm("PS512", 3, 3);
        PS512 = r103;
        JwtRsaSsaPssAlgorithm r104 = new JwtRsaSsaPssAlgorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275788b = new JwtRsaSsaPssAlgorithm[]{r100, r101, r102, r103, r104};
        f275787a = new a();
    }

    public static JwtRsaSsaPssAlgorithm[] values() {
        return (JwtRsaSsaPssAlgorithm[]) f275788b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<JwtRsaSsaPssAlgorithm> internalGetValueMap() {
        return f275787a;
    }

    public static e.c internalGetVerifier() {
        return b.f275789a;
    }

    public static JwtRsaSsaPssAlgorithm forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return PS512;
    L14:
        return PS384;
    L16:
        return PS256;
    L18:
        return PS_UNKNOWN;
    }

    public static JwtRsaSsaPssAlgorithm valueOf(String r100) {
        return (JwtRsaSsaPssAlgorithm) r27.a.a(JwtRsaSsaPssAlgorithm.class, r100);
    }

    public static JwtRsaSsaPssAlgorithm valueOf(int r100) {
        return forNumber(r100);
    }

    public JwtRsaSsaPssAlgorithm(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
