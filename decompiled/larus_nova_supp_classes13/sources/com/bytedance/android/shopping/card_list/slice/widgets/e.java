package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends SlcRoundFrameLayout {
    public ti.l c;
    public final boolean d;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        ti.l r0 = this.c;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.c = null;
    }

    public final boolean getEnableLargeTextMode() {
        return this.d;
    }

    public final void b(Map<String, ? extends Object> r3) {
        if (r3 == null) goto L4;
        String r4 = com.bytedance.android.ec.hybrid.list.util.k.d(r3);
    L6:
        if (a2.b(r4) == false) goto L11;
        ti.l r0 = this.c;
        if (r0 == null) goto L12;
        r0.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("pass_param", r4)));
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r4 = null;
        goto L6
    }

    public e(Context r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.d = r4;
    }
}
