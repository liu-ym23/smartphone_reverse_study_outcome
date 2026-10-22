package wg2;

import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements a {
    public c() {
    }

    @Override // wg2.a
    public final vg2.a a(vg2.a r4) {
        String r0 = r4.b + '_' + r4.d + '_' + r4.e;     // Catch: Exception -> L6
        if (EComABUtils.getArsEventMapList().contains(r0) == false) goto L8;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");     // Catch: Exception -> L6
        r4.b = r0;     // Catch: Exception -> L6
        return r4;
    L8:
        return r4;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
