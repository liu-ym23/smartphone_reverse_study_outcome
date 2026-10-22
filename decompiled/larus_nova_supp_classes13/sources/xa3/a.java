package xa3;

import com.bytedance.android.shopping.buynow.controller.w;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mq.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.kmp.ec.yata.store.core.a {
    public final w a;

    public a(w r1) {
        this.a = r1;
    }

    public final void b(com.bytedance.kmp.ec.yata.store.core.a.a r5) {
        Intrinsics.checkNotNullParameter(r5, "modifier");
        w r1 = this.a;
        if (r1 == null) goto L20;
        Intrinsics.checkNotNullParameter(r5, "modifier");
        AndroidYaTaInstance r0 = r1.b;
        Object r2 = null;
        if (r0 == null) goto L9;
        Map r3 = r0.j();
        if (r3 == null) goto L9;
        Object r4 = r3.get("header_ceiling");
    L11:
        if ((r4 instanceof Map) == false) goto L15;
        r2 = r4;
    L15:
        if (((Map) r2) != null) goto L17;
        return;
    L17:
        if (b.c(r5.d(), "is_ceiling_node", false) == false) goto L22;
        r5.e("is_ceiling_opt", Boolean.TRUE);
        r5.e("is_ceiling", Boolean.valueOf(r1.a));
        return;
    L22:
        return;
    L9:
        r4 = null;
        goto L11
    }
}
