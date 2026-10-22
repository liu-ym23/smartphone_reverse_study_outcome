package r96;

import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements p96.b {
    public e() {
    }

    @Override // p96.b
    public final g a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "publicKeyBytes");
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(r100);
        return new f(KeyFactory.getInstance(com.alipay.sdk.m.n.d.f25615a).generatePublic(r101));
    }
}
