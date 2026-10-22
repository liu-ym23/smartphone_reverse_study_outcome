package q96;

import com.bytedance.kmp.crypto.algorithms.SignatureModeEcdsa;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements n {
    public e() {
        r96.b r100 = new r96.b();
        SignatureModeEcdsa r101 = SignatureModeEcdsa.SHA256withECDSA;
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        Intrinsics.checkNotNullParameter(r101, "modeCurrent");
    }
}
