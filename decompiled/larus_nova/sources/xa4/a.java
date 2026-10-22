package xa4;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.bytedance.bdp.bdpbase.util.j;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f563062a;

    public static c a() {
        if (f563062a != null) goto L21;
        c r100 = new c();
        r100.f563063a = b.a();
        r100.f563064b = b.a();
        String r101 = r100.f563063a + "#" + r100.f563064b;
        int r102 = 2;
    L5:
        if (r102 < 0) goto L20;
        if (j.f201343a != null) goto L9;
        j.f201343a = KeyFactory.getInstance(d.f25615a).generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEwerqo7Lxy2YAAxSh6MW9/hykusVgDsPB8ggNMUEf6yIJ6rFZAkXlfulor5siILeYkgv8E/XiKFUmwYOAjeqVjIfBNPCkvsWoGLpHLBYAerUousjh/6A8b2GNP6Z2KXpW3bjbtOPzlscPmv/bKsAupE811J7mlwtbufAtvCHBtQIDAQAB", 2)));     // Catch: Exception -> L11
    L9:
        PublicKey r103 = j.f201343a;     // Catch: Exception -> L11
        byte[] r104 = r101.getBytes();     // Catch: Exception -> L11
        Cipher r105 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Exception -> L11
        r105.init(1, r103);     // Catch: Exception -> L11
        byte[] r106 = r105.doFinal(r104);     // Catch: Exception -> L11
    L12:
        if (r106 == null) goto L17;
        if (r106.length <= 0) goto L17;
        r100.f563065c = Base64.encodeToString(r106, 2);
    L17:
        if (TextUtils.isEmpty(r100.f563065c) == false) goto L20;
        r102 = r102 - 1;
    L11:
        r106 = null;
    L20:
        f563062a = r100;
    L21:
        c r107 = f563062a;
        if (r107 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        return r107;
    }

    static {
    }
}
