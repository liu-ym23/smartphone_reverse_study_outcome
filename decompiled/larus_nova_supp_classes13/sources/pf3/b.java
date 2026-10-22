package pf3;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.event.d;
import com.bytedance.android.ec.hybrid.card.event.e;
import com.bytedance.android.shopping.api.mall.common.tools.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements e {
    public final WeakReference<Context> a;

    public static final class a {
    }

    static {
    }

    public b(WeakReference<Context> r1) {
        this.a = r1;
    }

    public final void a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "jsEvent");
        Map r5 = r4.b;
        if (r5 == null) goto L5;
        Object r6 = r5.get("skuSchema");
    L7:
        if ((r6 instanceof String) == true) goto L9;
        r6 = null;
    L9:
        String r7 = (String) r6;
        if (r7 != null) goto L12;
        return;
    L12:
        WeakReference<Context> r1 = this.a;
        if (r1 == null) goto L19;
        Context r2 = r1.get();
        if (r2 == null) goto L20;
        k.b.d(r2, r7, null);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
