package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum HpkeAead extends Enum<HpkeAead> implements e.a {
    public static final HpkeAead AEAD_UNKNOWN = null;
    public static final int AEAD_UNKNOWN_VALUE = 0;
    public static final HpkeAead AES_128_GCM = null;
    public static final int AES_128_GCM_VALUE = 1;
    public static final HpkeAead AES_256_GCM = null;
    public static final int AES_256_GCM_VALUE = 2;
    public static final HpkeAead CHACHA20_POLY1305 = null;
    public static final int CHACHA20_POLY1305_VALUE = 3;
    public static final HpkeAead UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ HpkeAead[] f275770b = null;
    private final int value;

    public class a implements e.b<HpkeAead> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275771a = null;

        public b() {
        }

        static {
            f275771a = new b();
        }
    }

    static {
        HpkeAead r100 = new HpkeAead("AEAD_UNKNOWN", 0, 0);
        AEAD_UNKNOWN = r100;
        HpkeAead r101 = new HpkeAead("AES_128_GCM", 1, 1);
        AES_128_GCM = r101;
        HpkeAead r102 = new HpkeAead("AES_256_GCM", 2, 2);
        AES_256_GCM = r102;
        HpkeAead r103 = new HpkeAead("CHACHA20_POLY1305", 3, 3);
        CHACHA20_POLY1305 = r103;
        HpkeAead r104 = new HpkeAead("UNRECOGNIZED", 4, -1);
        UNRECOGNIZED = r104;
        f275770b = new HpkeAead[]{r100, r101, r102, r103, r104};
        f275769a = new a();
    }

    public static HpkeAead[] values() {
        return (HpkeAead[]) f275770b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<HpkeAead> internalGetValueMap() {
        return f275769a;
    }

    public static e.c internalGetVerifier() {
        return b.f275771a;
    }

    public static HpkeAead forNumber(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return CHACHA20_POLY1305;
    L14:
        return AES_256_GCM;
    L16:
        return AES_128_GCM;
    L18:
        return AEAD_UNKNOWN;
    }

    public static HpkeAead valueOf(String r100) {
        return (HpkeAead) r27.a.a(HpkeAead.class, r100);
    }

    public static HpkeAead valueOf(int r100) {
        return forNumber(r100);
    }

    public HpkeAead(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
