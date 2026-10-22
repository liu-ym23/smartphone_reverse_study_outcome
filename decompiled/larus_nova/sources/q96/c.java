package q96;

import com.bytedance.kmp.crypto.PaddingModeAes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements a {
    public c() {
        r96.a r100 = new r96.a();
        p96.a r101 = new p96.a();
        PaddingModeAes r102 = PaddingModeAes.PKCS5Padding;
        Intrinsics.checkNotNullParameter(r100, "keyGenerator");
        Intrinsics.checkNotNullParameter(r101, "ivGenerator");
        Intrinsics.checkNotNullParameter(r102, "paddingModeCurrent");
    }
}
