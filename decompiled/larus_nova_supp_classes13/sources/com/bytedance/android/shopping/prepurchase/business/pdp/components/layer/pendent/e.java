package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.anchorv4.widgets.PdpLynxToastLayout;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m {
    public final String m;
    public final Map<String, Object> n;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        String r0 = this.m;
        Map<String, Object> r1 = this.n;
        Uri.Builder r2 = UriProtector.parse(r0).buildUpon();
        Iterator<Map.Entry<String, Object>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry<String, Object> r4 = r3.next();
        r2.appendQueryParameter(r4.getKey(), String.valueOf(r4.getValue()));
        goto L4
    L6:
        String r5 = r2.build().toString();
        com.bytedance.android.shopping.prepurchase.arch.container.ability.o r6 = new com.bytedance.android.shopping.prepurchase.arch.container.ability.o(e2().getContext(), r5, null, null, false, null, 60);
        ti.l r7 = O1().e().D0().p(r6);
        if (r7 == null) goto L15;
        View r8 = r7.getHybridView();
        if (r8 == null) goto L17;
        View r9 = e2();
        if (r9 == null) goto L14;
        ((ViewGroup) r9).addView(r8);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L17:
        return;
    }

    public e(String r2, Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "queryParams");
        this.m = r2;
        this.n = r3;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "container");
        return new PdpLynxToastLayout(r4.getContext(), null, 6, 0);
    }
}
