package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;

/* JADX INFO: loaded from: classes23.dex */
public final enum HashType extends Enum<HashType> implements e.a {
    public static final HashType SHA1 = null;
    public static final int SHA1_VALUE = 1;
    public static final HashType SHA224 = null;
    public static final int SHA224_VALUE = 5;
    public static final HashType SHA256 = null;
    public static final int SHA256_VALUE = 3;
    public static final HashType SHA384 = null;
    public static final int SHA384_VALUE = 2;
    public static final HashType SHA512 = null;
    public static final int SHA512_VALUE = 4;
    public static final HashType UNKNOWN_HASH = null;
    public static final int UNKNOWN_HASH_VALUE = 0;
    public static final HashType UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275766a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ HashType[] f275767b = null;
    private final int value;

    public class a implements e.b<HashType> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275768a = null;

        public b() {
        }

        static {
            f275768a = new b();
        }
    }

    static {
        HashType r100 = new HashType("UNKNOWN_HASH", 0, 0);
        UNKNOWN_HASH = r100;
        HashType r101 = new HashType("SHA1", 1, 1);
        SHA1 = r101;
        HashType r102 = new HashType("SHA384", 2, 2);
        SHA384 = r102;
        HashType r103 = new HashType("SHA256", 3, 3);
        SHA256 = r103;
        HashType r104 = new HashType("SHA512", 4, 4);
        SHA512 = r104;
        HashType r105 = new HashType("SHA224", 5, 5);
        SHA224 = r105;
        HashType r110 = new HashType("UNRECOGNIZED", 6, -1);
        UNRECOGNIZED = r110;
        f275767b = new HashType[]{r100, r101, r102, r103, r104, r105, r110};
        f275766a = new a();
    }

    public static HashType[] values() {
        return (HashType[]) f275767b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<HashType> internalGetValueMap() {
        return f275766a;
    }

    public static e.c internalGetVerifier() {
        return b.f275768a;
    }

    public static HashType forNumber(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return SHA224;
    L18:
        return SHA512;
    L20:
        return SHA256;
    L22:
        return SHA384;
    L24:
        return SHA1;
    L26:
        return UNKNOWN_HASH;
    }

    public static HashType valueOf(String r100) {
        return (HashType) r27.a.a(HashType.class, r100);
    }

    public static HashType valueOf(int r100) {
        return forNumber(r100);
    }

    public HashType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
