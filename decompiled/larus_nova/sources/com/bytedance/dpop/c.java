package com.bytedance.dpop;

import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.utils.CryptoConst;
import com.google.gson.Gson;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f204775e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyStore f204776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f204777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f204778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ml4.a f204779d;

    public static final class a {
        public a() {
        }

        public static byte[] b(BigInteger r100) {
            byte[] r101 = r100.toByteArray();
            if (r101.length <= 32) goto L6;
            return ArraysKt.copyOfRange(r101, r101.length - 32, r101.length);
        L6:
            if (r101.length >= 32) goto L10;
            byte[] r102 = new byte[32];
            ArraysKt.copyInto$default(r101, r102, 32 - r101.length, 0, 0, 12, null);
            return r102;
        L10:
            return r101;
        }

        public static Object a(String r100, ml4.c r101) {
            int r102 = c.f204775e;
            Intrinsics.checkNotNullParameter(r100, "keyAlias");
            Intrinsics.checkNotNullParameter(r101, "ntpTimeProvider");
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L12
            KeyStore r104 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Throwable -> L12
            r104.load(null);     // Catch: Throwable -> L12
            if (r104.containsAlias(r100) == false) goto L9;
            PublicKey r105 = r104.getCertificate(r100).getPublicKey();     // Catch: Throwable -> L12
        L10:
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");     // Catch: Throwable -> L12
            ECPublicKey r106 = (ECPublicKey) r105;     // Catch: Throwable -> L12
            Gson r107 = j.f204794a;     // Catch: Throwable -> L12
            LinkedHashMap r108 = new LinkedHashMap();     // Catch: Throwable -> L12
            r108.put("typ", "dpop+jwt");     // Catch: Throwable -> L12
            r108.put("alg", "ES256");     // Catch: Throwable -> L12
            LinkedHashMap r109 = new LinkedHashMap();     // Catch: Throwable -> L12
            r109.put("kty", CryptoConst.ALGORITHM_EC);     // Catch: Throwable -> L12
            int r110 = com.bytedance.dpop.a.f204774a;     // Catch: Throwable -> L12
            r109.put("x", com.bytedance.dpop.a.a(b(r106.getW().getAffineX())));     // Catch: Throwable -> L12
            r109.put("y", com.bytedance.dpop.a.a(b(r106.getW().getAffineY())));     // Catch: Throwable -> L12
            r109.put("crv", "P-256");     // Catch: Throwable -> L12
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L12
            r108.put("jwk", r109);     // Catch: Throwable -> L12
            return Result.m9449constructorimpl(new c(r104, r100, com.bytedance.dpop.a.a(r107.toJson(r108).getBytes(Charsets.UTF_8)), r101));
        L9:
            KeyPairGenerator r112 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, "AndroidKeyStore");     // Catch: Throwable -> L12
            r112.initialize(new KeyGenParameterSpec.Builder(r100, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests(new String[]{"SHA-256"}).build());     // Catch: Throwable -> L12
            r105 = r112.genKeyPair().getPublic();     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            return Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    static {
        new a();
    }

    public final d a() {
        return new d(this, UUID.randomUUID().toString(), Long.valueOf(this.f204779d.getNtpTime() / ((long) 1000)));
    }

    public final String b(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = DERDecoder.f204767a;
        DERDecoder.DERInteger r102 = null;
        Key r103 = this.f204776a.getKey(this.f204777b, null);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.security.PrivateKey");
        Signature r104 = Signature.getInstance("SHA256withECDSA");
        r104.initSign((PrivateKey) r103);
        r104.update(r100);
        byte[] r105 = r104.sign();
        Intrinsics.checkNotNullParameter(r105, "ba");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L5
        Object r107 = Result.m9449constructorimpl(DERDecoder.a(ByteBuffer.wrap(r105).asReadOnlyBuffer()));     // Catch: Throwable -> L5
    L7:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L11;
        r108.printStackTrace();
    L11:
        if (Result.m9455isFailureimpl(r107) == false) goto L14;
        r107 = null;
    L14:
        if ((r107 instanceof DERDecoder.b) == false) goto L16;
        DERDecoder.b r109 = (DERDecoder.b) r107;
    L18:
        if (r109 == null) goto L20;
        DERDecoder.a r110 = (DERDecoder.a) CollectionsKt.getOrNull(r109, 0);
    L22:
        if ((r110 instanceof DERDecoder.DERInteger) == false) goto L24;
        DERDecoder.DERInteger r111 = (DERDecoder.DERInteger) r110;
    L25:
        if (r109 == null) goto L27;
        DERDecoder.a r112 = (DERDecoder.a) CollectionsKt.getOrNull(r109, 1);
    L29:
        if ((r112 instanceof DERDecoder.DERInteger) == false) goto L31;
        r102 = (DERDecoder.DERInteger) r112;
    L31:
        if (r111 == null) goto L36;
        if (r102 == null) goto L36;
        int r113 = com.bytedance.dpop.a.f204774a;
        byte[] r114 = a.b((BigInteger) r111.f204769b.getValue());
        byte[] r115 = a.b((BigInteger) r102.f204769b.getValue());
        Intrinsics.checkNotNullParameter(r114, "b1");
        Intrinsics.checkNotNullParameter(r115, "b2");
        int r116 = r114.length;
        int r117 = r115.length;
        byte[] r118 = new byte[r116 + r117];
        System.arraycopy(r114, 0, r118, 0, r116);
        System.arraycopy(r115, 0, r118, r116, r117);
        return com.bytedance.dpop.a.a(r118);
    L36:
        throw new DERParseError("invalid sign:" + b.a(r100));
    L27:
        r112 = null;
        goto L29
    L24:
        r111 = null;
        goto L25
    L20:
        r110 = null;
        goto L22
    L16:
        r109 = null;
    L5:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public c(KeyStore r100, String r101, String r102, ml4.a r103) {
        this.f204776a = r100;
        this.f204777b = r101;
        this.f204778c = r102;
        this.f204779d = r103;
    }
}
