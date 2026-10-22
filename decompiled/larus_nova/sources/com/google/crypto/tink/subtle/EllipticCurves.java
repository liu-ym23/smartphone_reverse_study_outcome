package com.google.crypto.tink.subtle;

import com.google.crypto.tink.internal.c;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import kotlin.UByte;
import org.bouncycastle.asn1.ASN1Encoding;

/* JADX INFO: loaded from: classes23.dex */
public final class EllipticCurves {

    public static final enum CurveType extends Enum<CurveType> {
        public static final CurveType NIST_P256 = null;
        public static final CurveType NIST_P384 = null;
        public static final CurveType NIST_P521 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CurveType[] f275905a = null;

        static {
            CurveType r100 = new CurveType("NIST_P256", 0);
            NIST_P256 = r100;
            CurveType r101 = new CurveType("NIST_P384", 1);
            NIST_P384 = r101;
            CurveType r102 = new CurveType("NIST_P521", 2);
            NIST_P521 = r102;
            f275905a = new CurveType[]{r100, r101, r102};
        }

        public static CurveType[] values() {
            return (CurveType[]) f275905a.clone();
        }

        public static CurveType valueOf(String r100) {
            return (CurveType) r27.a.a(CurveType.class, r100);
        }

        public CurveType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum EcdsaEncoding extends Enum<EcdsaEncoding> {
        public static final EcdsaEncoding DER = null;
        public static final EcdsaEncoding IEEE_P1363 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EcdsaEncoding[] f275906a = null;

        static {
            EcdsaEncoding r100 = new EcdsaEncoding("IEEE_P1363", 0);
            IEEE_P1363 = r100;
            EcdsaEncoding r101 = new EcdsaEncoding(ASN1Encoding.DER, 1);
            DER = r101;
            f275906a = new EcdsaEncoding[]{r100, r101};
        }

        public static EcdsaEncoding[] values() {
            return (EcdsaEncoding[]) f275906a.clone();
        }

        public static EcdsaEncoding valueOf(String r100) {
            return (EcdsaEncoding) r27.a.a(EcdsaEncoding.class, r100);
        }

        public EcdsaEncoding(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum PointFormatType extends Enum<PointFormatType> {
        public static final PointFormatType COMPRESSED = null;
        public static final PointFormatType DO_NOT_USE_CRUNCHY_UNCOMPRESSED = null;
        public static final PointFormatType UNCOMPRESSED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PointFormatType[] f275907a = null;

        static {
            PointFormatType r100 = new PointFormatType("UNCOMPRESSED", 0);
            UNCOMPRESSED = r100;
            PointFormatType r101 = new PointFormatType("COMPRESSED", 1);
            COMPRESSED = r101;
            PointFormatType r102 = new PointFormatType("DO_NOT_USE_CRUNCHY_UNCOMPRESSED", 2);
            DO_NOT_USE_CRUNCHY_UNCOMPRESSED = r102;
            f275907a = new PointFormatType[]{r100, r101, r102};
        }

        public static PointFormatType[] values() {
            return (PointFormatType[]) f275907a.clone();
        }

        public static PointFormatType valueOf(String r100) {
            return (PointFormatType) r27.a.a(PointFormatType.class, r100);
        }

        public PointFormatType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275908a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f275909b = null;

        static {
            int[] r100 = new int[CurveType.values().length];
            f275909b = r100;
            r100[CurveType.NIST_P256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            f275909b[CurveType.NIST_P384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            f275909b[CurveType.NIST_P521.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r101 = new int[PointFormatType.values().length];
            f275908a = r101;
            r101[PointFormatType.UNCOMPRESSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            f275908a[PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            f275908a[PointFormatType.COMPRESSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static byte[] a(byte[] r110) throws GeneralSecurityException {
        byte r100 = 0;
        int r101 = 2;
        if (r110.length >= 8) goto L6;
    L54:
        boolean r102 = false;
    L55:
        if (r102 == false) goto L69;
        byte[] r103 = new byte[64];
        if ((r110[1] & UByte.MAX_VALUE) < 128) goto L59;
        r101 = 3;
    L59:
        int r104 = r101 + 1;
        int r105 = r104 + 1;
        byte r106 = r110[r104];
        if (r110[r105] != 0) goto L62;
        byte r107 = 1;
    L63:
        System.arraycopy(r110, r105 + r107, r103, (32 - r106) + r107, r106 - r107);
        int r108 = r105 + (r106 + 1);
        int r109 = r108 + 1;
        byte r111 = r110[r108];
        if (r110[r109] != 0) goto L66;
        r100 = 1;
    L66:
        System.arraycopy(r110, r109 + r100, r103, (64 - r111) + r100, r111 - r100);
        return r103;
    L62:
        r107 = 0;
        goto L63
    L69:
        throw new GeneralSecurityException("Invalid DER encoding");
    L6:
        if (r110[0] != 48) goto L54;
        int r112 = r110[1] & UByte.MAX_VALUE;
        if (r112 != 129) goto L14;
        r112 = r110[2] & UByte.MAX_VALUE;
        if (r112 < 128) goto L54;
        int r113 = 2;
    L19:
        if (r112 != ((r110.length - 1) - r113)) goto L54;
        int r114 = r113 + 1;
        if (r110[r114] != 2) goto L54;
        int r115 = r114 + 1;
        int r116 = r110[r115] & UByte.MAX_VALUE;
        int r117 = ((r115 + 1) + r116) + 1;
        if (r117 >= r110.length) goto L54;
        if (r116 == 0) goto L54;
        int r118 = r113 + 3;
        byte r119 = r110[r118];
        if ((r119 & UByte.MAX_VALUE) >= 128) goto L54;
        if (r116 <= 1) goto L38;
        if (r119 != 0) goto L38;
        if ((r110[r113 + 4] & UByte.MAX_VALUE) < 128) goto L54;
    L38:
        if (r110[r118 + r116] != 2) goto L54;
        int r120 = r110[r117] & UByte.MAX_VALUE;
        if (((r117 + 1) + r120) != r110.length) goto L54;
        if (r120 == 0) goto L54;
        byte r121 = r110[(r113 + 5) + r116];
        if ((r121 & UByte.MAX_VALUE) >= 128) goto L54;
        if (r120 <= 1) goto L53;
        if (r121 != 0) goto L53;
        if ((r110[(r113 + 6) + r116] & UByte.MAX_VALUE) < 128) goto L54;
    L53:
        r102 = true;
        goto L55
    L14:
        if (r112 == 128) goto L54;
        if (r112 > 129) goto L54;
        r113 = 1;
        goto L19
    }

    public static int b(EllipticCurve r100) throws GeneralSecurityException {
        return c.b(r100).subtract(BigInteger.ONE).bitLength();
    }

    public static ECParameterSpec c(CurveType r100) throws NoSuchAlgorithmException {
        int r101 = a.f275909b[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L13;
        if (r101 != 3) goto L11;
        return c.f275751c;
    L11:
        throw new NoSuchAlgorithmException("curve not implemented:" + r100);
    L13:
        return c.f275750b;
    L15:
        return c.f275749a;
    }

    public static boolean e(ECParameterSpec r100) {
        if (c.d(r100, c.f275749a) == false) goto L5;
    L10:
        return true;
    L5:
        if (c.d(r100, c.f275750b) == true) goto L10;
        if (c.d(r100, c.f275751c) == true) goto L10;
        return false;
    }

    public static BigInteger d(BigInteger r110, boolean r111, EllipticCurve r112) throws GeneralSecurityException {
        BigInteger r100 = c.b(r112);
        BigInteger r101 = r112.getA();
        BigInteger r113 = r110.multiply(r110).add(r101).multiply(r110).add(r112.getB()).mod(r100);
        if (r100.signum() != 1) goto L53;
        BigInteger r114 = r113.mod(r100);
        BigInteger r115 = BigInteger.ZERO;
        if (r114.equals(r115) == true) goto L49;
        if (r100.testBit(0) == false) goto L13;
        if (r100.testBit(1) == false) goto L13;
        r115 = r114.modPow(r100.add(BigInteger.ONE).shiftRight(2), r100);
    L42:
        if (r115 == null) goto L49;
        if (r115.multiply(r115).mod(r100).compareTo(r114) == 0) goto L49;
        throw new GeneralSecurityException("Could not find a modular square root");
    L13:
        if (r100.testBit(0) == true) goto L15;
    L41:
        r115 = null;
        goto L42
    L15:
        if (r100.testBit(1) == true) goto L41;
        r115 = BigInteger.ONE;
        BigInteger r102 = r100.subtract(r115).shiftRight(1);
        int r103 = 0;
    L17:
        BigInteger r104 = r115.multiply(r115).subtract(r114).mod(r100);
        if (r104.equals(BigInteger.ZERO) == true) goto L49;
        BigInteger r105 = r104.modPow(r102, r100);
        BigInteger r106 = BigInteger.ONE;
        if (r105.add(r106).equals(r100) == true) goto L22;
        if (r105.equals(r106) == false) goto L40;
        r115 = r115.add(r106);
        r103 = r103 + 1;
        if (r103 != 128) goto L17;
        if (r100.isProbablePrime(80) == true) goto L17;
        throw new InvalidAlgorithmParameterException("p is not prime");
    L40:
        throw new InvalidAlgorithmParameterException("p is not prime");
    L22:
        BigInteger r107 = r100.add(r106).shiftRight(1);
        int r108 = r107.bitLength() - 2;
        BigInteger r109 = r115;
    L23:
        if (r108 < 0) goto L29;
        BigInteger r116 = r109.multiply(r106);
        r109 = r109.multiply(r109).add(r106.multiply(r106).mod(r100).multiply(r104)).mod(r100);
        BigInteger r117 = r116.add(r116).mod(r100);
        if (r107.testBit(r108) == false) goto L27;
        BigInteger r118 = r109.multiply(r115).add(r117.multiply(r104)).mod(r100);
        r106 = r115.multiply(r117).add(r109).mod(r100);
        r109 = r118;
    L28:
        r108 = r108 - 1;
        goto L23
    L27:
        r106 = r117;
        goto L28
    L29:
        r115 = r109;
    L49:
        if (r111 != r115.testBit(0)) goto L51;
        return r115;
    L51:
        return r100.subtract(r115).mod(r100);
    L53:
        throw new InvalidAlgorithmParameterException("p must be positive");
    }
}
