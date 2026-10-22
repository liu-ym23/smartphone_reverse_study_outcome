package wg2;

import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements a {
    public c() {
    }

    @Override // wg2.a
    public final vg2.a a(vg2.a r100) {
        String r101 = r100.f554677b + '_' + r100.f554679d + '_' + r100.f554680e;     // Catch: Exception -> L6
        if (EComABUtils.getArsEventMapList().contains(r101) == false) goto L8;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Exception -> L6
        r100.f554677b = r101;     // Catch: Exception -> L6
        return r100;
    L8:
        return r100;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
