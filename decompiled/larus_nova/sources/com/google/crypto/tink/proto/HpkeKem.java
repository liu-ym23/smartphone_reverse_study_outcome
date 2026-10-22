package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum HpkeKem extends Enum<HpkeKem> implements e.a {
    public static final HpkeKem DHKEM_P256_HKDF_SHA256 = null;
    public static final int DHKEM_P256_HKDF_SHA256_VALUE = 2;
    public static final HpkeKem DHKEM_P384_HKDF_SHA384 = null;
    public static final int DHKEM_P384_HKDF_SHA384_VALUE = 3;
    public static final HpkeKem DHKEM_P521_HKDF_SHA512 = null;
    public static final int DHKEM_P521_HKDF_SHA512_VALUE = 4;
    public static final HpkeKem DHKEM_X25519_HKDF_SHA256 = null;
    public static final int DHKEM_X25519_HKDF_SHA256_VALUE = 1;
    public static final HpkeKem KEM_UNKNOWN = null;
    public static final int KEM_UNKNOWN_VALUE = 0;
    public static final HpkeKem UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ HpkeKem[] f275776b = null;
    private final int value;

    public class a implements e.b<HpkeKem> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275777a = null;

        public b() {
        }

        static {
            f275777a = new b();
        }
    }

    static {
        HpkeKem r100 = new HpkeKem("KEM_UNKNOWN", 0, 0);
        KEM_UNKNOWN = r100;
        HpkeKem r101 = new HpkeKem("DHKEM_X25519_HKDF_SHA256", 1, 1);
        DHKEM_X25519_HKDF_SHA256 = r101;
        HpkeKem r102 = new HpkeKem("DHKEM_P256_HKDF_SHA256", 2, 2);
        DHKEM_P256_HKDF_SHA256 = r102;
        HpkeKem r103 = new HpkeKem("DHKEM_P384_HKDF_SHA384", 3, 3);
        DHKEM_P384_HKDF_SHA384 = r103;
        HpkeKem r104 = new HpkeKem("DHKEM_P521_HKDF_SHA512", 4, 4);
        DHKEM_P521_HKDF_SHA512 = r104;
        HpkeKem r105 = new HpkeKem("UNRECOGNIZED", 5, -1);
        UNRECOGNIZED = r105;
        f275776b = new HpkeKem[]{r100, r101, r102, r103, r104, r105};
        f275775a = new a();
    }

    public static HpkeKem[] values() {
        return (HpkeKem[]) f275776b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<HpkeKem> internalGetValueMap() {
        return f275775a;
    }

    public static e.c internalGetVerifier() {
        return b.f275777a;
    }

    public static HpkeKem forNumber(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return DHKEM_P521_HKDF_SHA512;
    L16:
        return DHKEM_P384_HKDF_SHA384;
    L18:
        return DHKEM_P256_HKDF_SHA256;
    L20:
        return DHKEM_X25519_HKDF_SHA256;
    L22:
        return KEM_UNKNOWN;
    }

    public static HpkeKem valueOf(String r100) {
        return (HpkeKem) r27.a.a(HpkeKem.class, r100);
    }

    public static HpkeKem valueOf(int r100) {
        return forNumber(r100);
    }

    public HpkeKem(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
