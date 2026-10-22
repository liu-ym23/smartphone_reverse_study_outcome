package wk2;

import com.bytedance.android.livesdk.livecommerce.event.u0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends u0 {
    public f(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        super(r2);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        f("product_id", r3);
    }
}
