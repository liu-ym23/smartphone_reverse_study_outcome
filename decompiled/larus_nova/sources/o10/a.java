package o10;

import android.util.Base64;
import com.alipay.sdk.m.n.d;
import com.baidu.mapauto.auth.util.RSAUtil;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f521690a = 0;

    static {
    }

    public static boolean a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "senderPublicKey");
        Intrinsics.checkNotNullParameter(r102, "sign");
        byte[] r103 = Base64.decode(r101, 0);     // Catch: Throwable -> L16
        KeyFactory r104 = KeyFactory.getInstance(d.f25615a);     // Catch: Throwable -> L16
        if (r104 == null) goto L11;
        PublicKey r105 = r104.generatePublic(new X509EncodedKeySpec(r103));     // Catch: Throwable -> L16
        if (r105 == null) goto L10;
        RSAPublicKey r106 = (RSAPublicKey) r105;     // Catch: Throwable -> L16
    L12:
        if (r106 != null) goto L14;
        return false;
    L14:
        Signature r107 = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);
        r107.initVerify(r106);
        r107.update(r100.getBytes(Charsets.UTF_8));
        return r107.verify(Base64.decode(r102, 0));
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");     // Catch: Throwable -> L16
    L11:
        r106 = null;
        goto L12
    }
}
