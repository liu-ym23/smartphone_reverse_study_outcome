package nw7;

import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.utils.CryptoConst;
import exc.e;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static SecretKey a(String r100) {
        SecretKey r101 = null;
        KeyStore r102 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L10 RuntimeException -> L11
        r102.load(null);     // Catch: Exception -> L10 RuntimeException -> L11
        Key r103 = r102.getKey(r100, null);     // Catch: Exception -> L10 RuntimeException -> L11
        if (r103 != null) goto L6;
    L8:
        KeyGenerator r104 = KeyGenerator.getInstance(CryptoConst.ALGORITHM_AES, "AndroidKeyStore");     // Catch: Exception -> L10 RuntimeException -> L11
        r104.init(new KeyGenParameterSpec.Builder(r100, 3).setBlockModes(new String[]{"CBC"}).setEncryptionPaddings(new String[]{"PKCS7Padding"}).setKeySize(256).build());     // Catch: Exception -> L10 RuntimeException -> L11
        r101 = r104.generateKey();     // Catch: Exception -> L10 RuntimeException -> L11
    L13:
    L12:
        return r101;
    L6:
        if ((r103 instanceof SecretKey) == false) goto L8;
        r101 = (SecretKey) r103;     // Catch: Exception -> L10 RuntimeException -> L11
    L11:
        e.c("KeyStoreEncryptAndDecrypt", "RuntimeException");
    L10:
        e.b("KeyStoreEncryptAndDecrypt", "Generate key exception ");
        goto L12
    }
}
