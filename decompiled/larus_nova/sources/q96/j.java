package q96;

import com.bytedance.kmp.crypto.algorithms.SignatureModeRsa;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements r {
    public j() {
        r96.e r100 = new r96.e();
        SignatureModeRsa r101 = SignatureModeRsa.SHA256withRSA;
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        Intrinsics.checkNotNullParameter(r101, "modeCurrent");
    }
}
