package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum HpkeKdf extends Enum<HpkeKdf> implements e.a {
    public static final HpkeKdf HKDF_SHA256 = null;
    public static final int HKDF_SHA256_VALUE = 1;
    public static final HpkeKdf HKDF_SHA384 = null;
    public static final int HKDF_SHA384_VALUE = 2;
    public static final HpkeKdf HKDF_SHA512 = null;
    public static final int HKDF_SHA512_VALUE = 3;
    public static final HpkeKdf KDF_UNKNOWN = null;
    public static final int KDF_UNKNOWN_VALUE = 0;
    public static final HpkeKdf UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275772a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ HpkeKdf[] f275773b = null;
    private final int value;

    public class a implements e.b<HpkeKdf> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275774a = null;

        public b() {
        }

        static {
            f275774a = new b();
        }
    }

    static {
        HpkeKdf r100 = new HpkeKdf("KDF_UNKNOWN", 0, 0);
        KDF_UNKNOWN = r100;
        HpkeKdf r101 = new HpkeKdf("HKDF_SHA256", 1, 1);
        HKDF_SHA256 = r101;
        HpkeKdf r102 = new HpkeKdf("HKDF_SHA384", 2, 2);
        HKDF_SHA384 = r102;
        HpkeKdf r103 = new HpkeKdf("HKDF_SHA512", 3, 3);
        HKDF_SHA512 = r103;
        HpkeKdf r104 = new HpkeKdf("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275773b = new HpkeKdf[]{r100, r101, r102, r103, r104};
        f275772a = new a();
    }

    public static HpkeKdf[] values() {
        return (HpkeKdf[]) f275773b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<HpkeKdf> internalGetValueMap() {
        return f275772a;
    }

    public static e.c internalGetVerifier() {
        return b.f275774a;
    }

    public static HpkeKdf forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return HKDF_SHA512;
    L14:
        return HKDF_SHA384;
    L16:
        return HKDF_SHA256;
    L18:
        return KDF_UNKNOWN;
    }

    public static HpkeKdf valueOf(String r100) {
        return (HpkeKdf) r27.a.a(HpkeKdf.class, r100);
    }

    public static HpkeKdf valueOf(int r100) {
        return forNumber(r100);
    }

    public HpkeKdf(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
