package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum JwtRsaSsaPkcs1Algorithm extends Enum<JwtRsaSsaPkcs1Algorithm> implements e.a {
    public static final JwtRsaSsaPkcs1Algorithm RS256 = null;
    public static final int RS256_VALUE = 1;
    public static final JwtRsaSsaPkcs1Algorithm RS384 = null;
    public static final int RS384_VALUE = 2;
    public static final JwtRsaSsaPkcs1Algorithm RS512 = null;
    public static final int RS512_VALUE = 3;
    public static final JwtRsaSsaPkcs1Algorithm RS_UNKNOWN = null;
    public static final int RS_UNKNOWN_VALUE = 0;
    public static final JwtRsaSsaPkcs1Algorithm UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ JwtRsaSsaPkcs1Algorithm[] f275785b = null;
    private final int value;

    public class a implements e.b<JwtRsaSsaPkcs1Algorithm> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275786a = null;

        public b() {
        }

        static {
            f275786a = new b();
        }
    }

    static {
        JwtRsaSsaPkcs1Algorithm r100 = new JwtRsaSsaPkcs1Algorithm("RS_UNKNOWN", 0, 0);
        RS_UNKNOWN = r100;
        JwtRsaSsaPkcs1Algorithm r101 = new JwtRsaSsaPkcs1Algorithm("RS256", 1, 1);
        RS256 = r101;
        JwtRsaSsaPkcs1Algorithm r102 = new JwtRsaSsaPkcs1Algorithm("RS384", 2, 2);
        RS384 = r102;
        JwtRsaSsaPkcs1Algorithm r103 = new JwtRsaSsaPkcs1Algorithm("RS512", 3, 3);
        RS512 = r103;
        JwtRsaSsaPkcs1Algorithm r104 = new JwtRsaSsaPkcs1Algorithm("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275785b = new JwtRsaSsaPkcs1Algorithm[]{r100, r101, r102, r103, r104};
        f275784a = new a();
    }

    public static JwtRsaSsaPkcs1Algorithm[] values() {
        return (JwtRsaSsaPkcs1Algorithm[]) f275785b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<JwtRsaSsaPkcs1Algorithm> internalGetValueMap() {
        return f275784a;
    }

    public static e.c internalGetVerifier() {
        return b.f275786a;
    }

    public static JwtRsaSsaPkcs1Algorithm forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return RS512;
    L14:
        return RS384;
    L16:
        return RS256;
    L18:
        return RS_UNKNOWN;
    }

    public static JwtRsaSsaPkcs1Algorithm valueOf(String r100) {
        return (JwtRsaSsaPkcs1Algorithm) r27.a.a(JwtRsaSsaPkcs1Algorithm.class, r100);
    }

    public static JwtRsaSsaPkcs1Algorithm valueOf(int r100) {
        return forNumber(r100);
    }

    public JwtRsaSsaPkcs1Algorithm(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
