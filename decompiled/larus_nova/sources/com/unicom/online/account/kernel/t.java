package com.unicom.online.account.kernel;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes41.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f462097a = null;

    static {
        f462097a = "1234567812345678".getBytes();
        System.setProperty("org.bouncycastle.asn1.allow_unsafe_integer", "true");
    }

    public t() {
    }

    public static t a() {
        return new t();
    }

    public static byte[] a(byte[] r110, byte[] r111) {
        if (r110 == null) goto L36;
        if (r111 == null) goto L34;
        if (r111.length == 0) goto L32;
        if (r110.length != 65) goto L30;
        if (r110[0] != 4) goto L28;
        byte[] r100 = new byte[32];     // Catch: Exception -> L25
        byte[] r101 = new byte[32];     // Catch: Exception -> L25
        System.arraycopy(r110, 1, r100, 0, 32);     // Catch: Exception -> L25
        System.arraycopy(r110, 33, r101, 0, 32);     // Catch: Exception -> L25
        BigInteger r112 = new BigInteger(1, r100);     // Catch: Exception -> L25
        BigInteger r102 = new BigInteger(1, r101);     // Catch: Exception -> L25
        ECPoint r113 = ECNamedCurveTable.getParameterSpec("sm2p256v1").getCurve().createPoint(r112, r102);     // Catch: Exception -> L25
        ECNamedCurveParameterSpec r103 = ECNamedCurveTable.getParameterSpec("sm2p256v1");     // Catch: Exception -> L25
        ECPublicKeyParameters r104 = new ECPublicKeyParameters(r113, new ECDomainParameters(r103.getCurve(), r103.getG(), r103.getN(), r103.getH(), r103.getSeed()));     // Catch: Exception -> L25
        SM2Engine r114 = new SM2Engine();
        r114.init(true, new ParametersWithRandom(r104, new SecureRandom()));
        byte[] r115 = r114.processBlock(r111, 0, r111.length);     // Catch: InvalidCipherTextException -> L22
        if (r115 == null) goto L21;
        if (r115.length < 97) goto L21;
        byte[] r116 = new byte[r115.length];     // Catch: InvalidCipherTextException -> L22
        System.arraycopy(r115, 0, r116, 0, 65);     // Catch: InvalidCipherTextException -> L22
        System.arraycopy(r115, r115.length - 32, r116, 65, 32);     // Catch: InvalidCipherTextException -> L22
        System.arraycopy(r115, 65, r116, 97, r115.length - 97);     // Catch: InvalidCipherTextException -> L22
        return r116;
    L21:
        throw new w(q.f462081m);     // Catch: InvalidCipherTextException -> L22
    L22:
        e = move-exception;
        throw new w(q.f462072d, e);
    L26:
        throw new w(q.f462087s);
    L28:
        throw new w(q.f462079k);
    L30:
        throw new w(q.f462088t);
    L32:
        throw new w(q.f462086r);
    L34:
        throw new w(q.f462078j);
    L36:
        throw new w(q.f462078j);
    }
}
