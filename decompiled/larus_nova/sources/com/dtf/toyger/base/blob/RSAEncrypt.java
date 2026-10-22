package com.dtf.toyger.base.blob;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes22.dex */
public class RSAEncrypt {
    private static final char[] HEX_CHAR = null;
    public static final String privateKeyName = "privateKey.keystore";
    public static final String publickKeyName = "publicKey.keystore";

    static {
        HEX_CHAR = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public RSAEncrypt() {
    }

    public static RSAPublicKey loadPublicKeyByStr(String r100) {
        StringBuilder r101 = new StringBuilder();
        String[] r102 = r100.split("\n");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L17;
        String r105 = r102[r104];
        if (r105.charAt(0) == '-') goto L8;
        r101.append(r105);
        r101.append('\r');
    L8:
        r104 = r104 + 1;
        goto L3
    L17:
        byte[] r106 = Base64.decode(r101.toString(), 0);     // Catch: NullPointerException -> L11 InvalidKeySpecException -> L13 NoSuchAlgorithmException -> L15
        return (RSAPublicKey) KeyFactory.getInstance(d.f25615a).generatePublic(new X509EncodedKeySpec(r106));
    L12:
        throw new Exception("公钥数据为空");
    L16:
        throw new Exception("无此算法");
    L14:
        throw new Exception("公钥非法");
    }

    public static byte[] encrypt(RSAPublicKey r100, byte[] r101) {
        if (r100 == null) goto L16;
        Cipher r102 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: BadPaddingException -> L5 IllegalBlockSizeException -> L7 InvalidKeyException -> L9 NoSuchPaddingException -> L11 NoSuchAlgorithmException -> L13
        r102.init(1, r100);     // Catch: BadPaddingException -> L5 IllegalBlockSizeException -> L7 InvalidKeyException -> L9 NoSuchPaddingException -> L11 NoSuchAlgorithmException -> L13
        return r102.doFinal(r101);
    L11:
        return null;
    L10:
        throw new Exception("加密公钥非法,请检查");
    L14:
        throw new Exception("无此加密算法");
    L6:
        throw new Exception("明文数据已损坏");
    L8:
        throw new Exception("明文长度非法");
    L16:
        throw new Exception("加密公钥为空, 请设置");
    }
}
