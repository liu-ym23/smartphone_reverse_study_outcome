package com.bytedance.android.shopping.buynow.yata.abilities;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.platform.o;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l {
    public final AndroidYaTaInstance a;

    public l(AndroidYaTaInstance r2) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        this.a = r2;
    }

    public final Map<String, Object> a(com.bytedance.kmp.ec.yata.event.common.e r2) {
        Intrinsics.checkNotNullParameter(r2, "eventInput");
        Intrinsics.checkNotNullParameter(r2, "eventInput");
        return r2.q();
    }

    public final Map b(com.bytedance.kmp.ec.yata.event.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "eventInput");
        com.bytedance.kmp.ec.yata.store.node.c r3 = r2.j();
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.s();
    }

    public final String c(com.bytedance.kmp.ec.yata.event.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "eventInput");
        com.bytedance.kmp.ec.yata.store.node.c r3 = r2.j();
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getKey();
    }

    public final List<com.bytedance.kmp.ec.yata.store.node.c> d(Function1<? super com.bytedance.kmp.ec.yata.store.node.c, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "predicate");
        return this.a.q(r2);
    }

    public final RecyclerView e(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        AndroidYaTaInstance r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "popupCode");
        com.bytedance.kmp.ec.yata.view.c r2 = r1.s;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "popupCode");
        ga6.e r5 = ((com.bytedance.kmp.ec.yata.view.render.tree.b) r2.n.getValue()).b(r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.a;
    }

    public final View f(com.bytedance.kmp.ec.yata.event.core.a r2) {
        Intrinsics.checkNotNullParameter(r2, "eventInput");
        o r3 = r2.d.b;
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a;
    }

    public final View g(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return this.a.K(r2);
    }

    public final void h(String r9, String r10, Map r11) {
        this.a.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.a, new o(null), r9, r10, r11, "triggerEvent"));
    }
}
