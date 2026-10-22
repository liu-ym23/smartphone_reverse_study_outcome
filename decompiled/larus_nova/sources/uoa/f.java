package uoa;

import com.bytedance.crypto.utils.CryptoConst;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyPair f550970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f550971b;

    public f() throws Exception {
        ECParameterSpec r100 = com.google.crypto.tink.internal.c.f275749a;
        KeyPairGenerator r101 = lv7.b.f510967c.a(CryptoConst.ALGORITHM_EC);
        r101.initialize(r100);
        KeyPair r102 = r101.generateKeyPair();
        this.f550970a = r102;
        ECPoint r103 = ((ECPublicKey) r102.getPublic()).getW();
        EllipticCurves.CurveType r104 = EllipticCurves.CurveType.NIST_P256;
        EllipticCurves.PointFormatType r105 = EllipticCurves.PointFormatType.UNCOMPRESSED;
        EllipticCurve r106 = EllipticCurves.c(r104).getCurve();
        com.google.crypto.tink.internal.c.a(r103, r106);
        int r107 = (EllipticCurves.b(r106) + 7) / 8;
        int r108 = EllipticCurves.a.f275908a[r105.ordinal()];
        if (r108 == 1) goto L21;
        int r109 = 2;
        if (r108 != 2) goto L7;
        int r110 = r107 * 2;
        byte[] r111 = new byte[r110];
        byte[] r112 = com.google.crypto.tink.internal.a.a(r103.getAffineX());
        if (r112.length <= r107) goto L17;
        r112 = Arrays.copyOfRange(r112, r112.length - r107, r112.length);
    L17:
        byte[] r113 = com.google.crypto.tink.internal.a.a(r103.getAffineY());
        if (r113.length <= r107) goto L20;
        r113 = Arrays.copyOfRange(r113, r113.length - r107, r113.length);
    L20:
        System.arraycopy(r113, 0, r111, r110 - r113.length, r113.length);
        System.arraycopy(r112, 0, r111, r107 - r112.length, r112.length);
    L22:
        byte[] r114 = r111;
    L23:
        this.f550971b = r114;
        return;
    L7:
        if (r108 != 3) goto L13;
        int r115 = r107 + 1;
        r114 = new byte[r115];
        byte[] r116 = com.google.crypto.tink.internal.a.a(r103.getAffineX());
        System.arraycopy(r116, 0, r114, r115 - r116.length, r116.length);
        if (r103.getAffineY().testBit(0) == false) goto L11;
        r109 = 3;
    L11:
        r114[0] = (byte) r109;
        goto L23
    L13:
        throw new GeneralSecurityException("invalid format:" + r105);
    L21:
        int r117 = (r107 * 2) + 1;
        r111 = new byte[r117];
        byte[] r118 = com.google.crypto.tink.internal.a.a(r103.getAffineX());
        byte[] r119 = com.google.crypto.tink.internal.a.a(r103.getAffineY());
        System.arraycopy(r119, 0, r111, r117 - r119.length, r119.length);
        System.arraycopy(r118, 0, r111, (r107 + 1) - r118.length, r118.length);
        r111[0] = 4;
        goto L22
    }

    @Override // uoa.e
    public final byte[] a() {
        return this.f550971b;
    }

    @Override // uoa.e
    public final EllipticCurveType c() {
        return EllipticCurveType.NIST_P256;
    }

    @Override // uoa.e
    public final byte[] b(byte[] r110) throws GeneralSecurityException {
        boolean r100 = false;
        if (r110.length == 0) goto L5;
        EllipticCurves.CurveType r101 = EllipticCurves.CurveType.NIST_P256;
        EllipticCurves.PointFormatType r102 = EllipticCurves.PointFormatType.UNCOMPRESSED;
        ECParameterSpec r103 = EllipticCurves.c(r101);
        EllipticCurve r104 = r103.getCurve();
        int r105 = (EllipticCurves.b(r104) + 7) / 8;
        int r106 = EllipticCurves.a.f275908a[r102.ordinal()];
        if (r106 == 1) goto L38;
        if (r106 == 2) goto L33;
        if (r106 != 3) goto L31;
        BigInteger r107 = com.google.crypto.tink.internal.c.b(r104);
        if (r110.length != (r105 + 1)) goto L29;
        byte r108 = r110[0];
        if (r108 == 2) goto L19;
        if (r108 != 3) goto L27;
        r100 = true;
        goto L19
    L27:
        throw new GeneralSecurityException("invalid format");
    L19:
        BigInteger r109 = new BigInteger(1, Arrays.copyOfRange(r110, 1, r110.length));
        if (r109.signum() == (-1)) goto L25;
        if (r109.compareTo(r107) >= 0) goto L25;
        ECPoint r111 = new ECPoint(r109, EllipticCurves.d(r109, r100, r104));
    L43:
        ECPublicKeySpec r112 = new ECPublicKeySpec(r111, r103);
        lv7.b<lv7.c.C6741c, KeyFactory> r113 = lv7.b.f510968d;
        ECPublicKey r114 = (ECPublicKey) r113.a(CryptoConst.ALGORITHM_EC).generatePublic(r112);
        ECPrivateKey r115 = (ECPrivateKey) this.f550970a.getPrivate();
    L60:
        e = move-exception;
        throw new GeneralSecurityException(e);
    L45:
        if (com.google.crypto.tink.internal.c.d(r114.getParams(), r115.getParams()) == false) goto L59;
        ECPoint r116 = r114.getW();
        com.google.crypto.tink.internal.c.a(r116, r115.getParams().getCurve());
        PublicKey r117 = r113.a(CryptoConst.ALGORITHM_EC).generatePublic(new ECPublicKeySpec(r116, r115.getParams()));
        KeyAgreement r118 = lv7.b.f510966b.a("ECDH");
        r118.init(r115);
        r118.doPhase(r117, true);     // Catch: IllegalStateException -> L55
        byte[] r119 = r118.generateSecret();     // Catch: IllegalStateException -> L55
        EllipticCurve r120 = r115.getParams().getCurve();     // Catch: IllegalStateException -> L55
        BigInteger r121 = new BigInteger(1, r119);     // Catch: IllegalStateException -> L55
        if (r121.signum() == (-1)) goto L54;
        if (r121.compareTo(com.google.crypto.tink.internal.c.b(r120)) >= 0) goto L54;
        EllipticCurves.d(r121, true, r120);     // Catch: IllegalStateException -> L55
        return r119;
    L54:
        throw new GeneralSecurityException("shared secret is out of range");     // Catch: IllegalStateException -> L55
    L55:
        e = move-exception;
        throw new GeneralSecurityException(e);
    L59:
        throw new GeneralSecurityException("invalid public key spec");     // Catch: Throwable -> L60 IllegalArgumentException -> L62
    L25:
        throw new GeneralSecurityException("x is out of range");
    L29:
        throw new GeneralSecurityException("compressed point has wrong length");
    L31:
        throw new GeneralSecurityException("invalid format:" + r102);
    L33:
        if (r110.length != (r105 * 2)) goto L36;
        ECPoint r122 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(r110, 0, r105)), new BigInteger(1, Arrays.copyOfRange(r110, r105, r110.length)));
        com.google.crypto.tink.internal.c.a(r122, r104);
    L42:
        r111 = r122;
        goto L43
    L36:
        throw new GeneralSecurityException("invalid point size");
    L38:
        if (r110.length != ((r105 * 2) + 1)) goto L68;
        if (r110[0] != 4) goto L66;
        int r123 = r105 + 1;
        r122 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(r110, 1, r123)), new BigInteger(1, Arrays.copyOfRange(r110, r123, r110.length)));
        com.google.crypto.tink.internal.c.a(r122, r104);
        goto L42
    L66:
        throw new GeneralSecurityException("invalid point format");
    L68:
        throw new GeneralSecurityException("invalid point size");
    L5:
        return new byte[0];
    }
}
