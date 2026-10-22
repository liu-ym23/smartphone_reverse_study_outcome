package wk2;

import com.bytedance.android.livesdk.livecommerce.event.u0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends u0 {
    public e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        f("product_id", r101);
    }
}
