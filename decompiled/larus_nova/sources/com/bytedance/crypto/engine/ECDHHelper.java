package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes6.dex */
public class ECDHHelper {
    public ECDHHelper() {
    }

    public static PrivateKey bytesToECPrivateKey(byte[] r100) {
        PKCS8EncodedKeySpec r101 = new PKCS8EncodedKeySpec(r100);
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePrivate(r101);
    }

    private static PublicKey bytesToPublicKey(byte[] r100) {
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(r100);
        return KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(r101);
    }

    public static byte[] generateBDSharedSecret(Context r100, String r101, byte[] r102) {
        Bundle r103 = new Bundle();
        r103.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r103.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        FrameworkSecurityCompat.KmResult r104 = FrameworkSecurityCompat.keyAgreement(r100, r101, r102, r103);
        if (r104.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L7;
        return r104.getOutData();
    L7:
        throw new CloudTransException("bd keyAgreement failed, system errorCode: " + r104.getResultCode());
    }

    public static byte[] generateSharedSecret(PrivateKey r100, PublicKey r101) {
        KeyAgreement r102 = KeyAgreement.getInstance("ECDH");
        r102.init(r100);
        r102.doPhase(r101, true);
        return r102.generateSecret();
    }
}
