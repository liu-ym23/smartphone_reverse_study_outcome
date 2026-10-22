package n4a;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes32.dex */
public final class j {
    public static PublicKey a(String r100) throws Exception {
        byte[] r101 = f.c(r100);     // Catch: NullPointerException -> L4 InvalidKeySpecException -> L6 NoSuchAlgorithmException -> L8
        return KeyFactory.getInstance(f5.o("EUlNB")).generatePublic(new X509EncodedKeySpec(r101));
    L5:
        throw new Exception("公钥数据为空");
    L9:
        throw new Exception("无此算法");
    L7:
        throw new Exception("公钥非法");
    }
}
