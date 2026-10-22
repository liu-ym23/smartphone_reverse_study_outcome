package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.e;
import org.bouncycastle.asn1.ASN1Encoding;

/* JADX INFO: loaded from: classes23.dex */
public final enum EcdsaSignatureEncoding extends Enum<EcdsaSignatureEncoding> implements e.a {
    public static final EcdsaSignatureEncoding DER = null;
    public static final int DER_VALUE = 2;
    public static final EcdsaSignatureEncoding IEEE_P1363 = null;
    public static final int IEEE_P1363_VALUE = 1;
    public static final EcdsaSignatureEncoding UNKNOWN_ENCODING = null;
    public static final int UNKNOWN_ENCODING_VALUE = 0;
    public static final EcdsaSignatureEncoding UNRECOGNIZED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f275760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EcdsaSignatureEncoding[] f275761b = null;
    private final int value;

    public class a implements e.b<EcdsaSignatureEncoding> {
        public a() {
        }
    }

    public static final class b implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275762a = null;

        public b() {
        }

        static {
            f275762a = new b();
        }
    }

    static {
        EcdsaSignatureEncoding r100 = new EcdsaSignatureEncoding("UNKNOWN_ENCODING", 0, 0);
        UNKNOWN_ENCODING = r100;
        EcdsaSignatureEncoding r101 = new EcdsaSignatureEncoding("IEEE_P1363", 1, 1);
        IEEE_P1363 = r101;
        EcdsaSignatureEncoding r102 = new EcdsaSignatureEncoding(ASN1Encoding.DER, 2, 2);
        DER = r102;
        EcdsaSignatureEncoding r103 = new EcdsaSignatureEncoding("UNRECOGNIZED", 3, -1);
        UNRECOGNIZED = r103;
        f275761b = new EcdsaSignatureEncoding[]{r100, r101, r102, r103};
        f275760a = new a();
    }

    public static EcdsaSignatureEncoding[] values() {
        return (EcdsaSignatureEncoding[]) f275761b.clone();
    }

    public final int getNumber() {
        if (this == UNRECOGNIZED) goto L7;
        return this.value;
    L7:
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static e.b<EcdsaSignatureEncoding> internalGetValueMap() {
        return f275760a;
    }

    public static e.c internalGetVerifier() {
        return b.f275762a;
    }

    public static EcdsaSignatureEncoding forNumber(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return DER;
    L12:
        return IEEE_P1363;
    L14:
        return UNKNOWN_ENCODING;
    }

    public static EcdsaSignatureEncoding valueOf(String r100) {
        return (EcdsaSignatureEncoding) r27.a.a(EcdsaSignatureEncoding.class, r100);
    }

    public static EcdsaSignatureEncoding valueOf(int r100) {
        return forNumber(r100);
    }

    public EcdsaSignatureEncoding(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
