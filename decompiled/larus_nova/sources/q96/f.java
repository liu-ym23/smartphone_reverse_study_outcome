package q96;

import com.bytedance.kmp.crypto.algorithms.HashMode;
import faceverify.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements o {
    public f() {
        HashMode r100 = HashMode.HmacSHA256;
        r96.a r101 = new r96.a();
        Intrinsics.checkNotNullParameter(r100, w.BLOB_ELEM_IMAGE_HASHCODE);
        Intrinsics.checkNotNullParameter(r101, "keyGenerator");
    }
}
