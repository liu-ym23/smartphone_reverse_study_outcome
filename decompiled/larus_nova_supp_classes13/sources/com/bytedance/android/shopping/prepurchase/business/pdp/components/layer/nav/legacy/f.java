package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import com.bytedance.android.shopping.prepurchase.business.pdp.view.BottomButtonElementView;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.BottomButtonView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
    public final /* synthetic */ BottomNavigationComponentV1 a;

    public f(BottomNavigationComponentV1 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r5) {
        final com.bytedance.android.shopping.anchorv4.bottom.b r6 = (com.bytedance.android.shopping.anchorv4.bottom.b) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        final BottomButtonComponent r0 = BottomNavigationComponentV1.h2(this.a);
        r0.getClass();
        if (r6 != null) goto L5;
    L9:
        if (r6 != null) goto L11;
        return;
    L11:
        if (r6.a() != true) goto L26;
        r0.d = r6;
        BottomButtonView r1 = r0.h;
        if (r1 == null) goto L27;
        final BottomButtonElementView r2 = r1.getFirstButtonElementView();
        if (r2 != null) goto L17;
        return;
    L17:
        if (r0.c != null) goto L19;
        r0.c = new com.bytedance.android.shopping.anchorv4.bottom.widget.b(r2);
    L19:
        final com.bytedance.android.shopping.anchorv4.bottom.widget.b r3 = r0.c;
        if (r3 == null) goto L29;
        r3.c(r2, r6, new BottomButtonComponent$showAddCartGuide$$inlined$let$lambda$1(r3, r2, r0, r6));
        r0.f.d(new BottomButtonComponent$showAddCartGuide$$inlined$let$lambda$2(r2, r0, r6));
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        if (r6.i != true) goto L9;
        com.bytedance.android.shopping.anchorv4.bottom.widget.b r7 = r0.c;
        if (r7 == null) goto L23;
        r7.a = false;
        r7.b();
        return;
    }
}
