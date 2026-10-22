package r96;

import com.bytedance.crypto.utils.CryptoConst;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements p96.b {
    public b() {
    }

    @Override // p96.b
    public final g a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "publicKeyBytes");
        X509EncodedKeySpec r101 = new X509EncodedKeySpec(r100);
        return new c(KeyFactory.getInstance(CryptoConst.ALGORITHM_EC).generatePublic(r101));
    }
}
