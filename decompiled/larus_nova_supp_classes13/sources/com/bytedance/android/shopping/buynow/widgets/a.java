package com.bytedance.android.shopping.buynow.widgets;

import android.view.View;
import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.android.shopping.extensions.k;
import la3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BuyNowErrorView a;
    public final /* synthetic */ d b;

    public a(BuyNowErrorView r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        BuyNowErrorView r10 = this.a;
        String r0 = this.b.a();
        Integer r1 = this.b.c();
        int r2 = BuyNowErrorView.d;
        r10.getClass();
        if (r0 == null) goto L43;
        int r3 = r0.hashCode();
        if (r3 == (-934396624)) goto L30;
        if (r3 == 1085444827) goto L11;
        return;
    L11:
        if (r0.equals(ErrorPageButtonAction.REFRESH) == true) goto L13;
        return;
    L13:
        if (k.h(r10.c) > 0) goto L16;
        r10.c = Long.valueOf(System.currentTimeMillis());
    L16:
        if (k.f(r1) > 0) goto L18;
        BuyNowErrorView.a r11 = r10.b;
        if (r11 == null) goto L39;
        r11.a();
        return;
    L39:
        return;
    L18:
        if (k.h(Long.valueOf(System.currentTimeMillis() - k.h(r10.c))) > k.f(r1)) goto L22;
        BuyNowErrorView.a r12 = r10.b;
        if (r12 == null) goto L36;
        r12.b();
        return;
    L36:
        return;
    L22:
        BuyNowErrorView.a r4 = r10.b;
        if (r4 == null) goto L25;
        r4.a();
    L25:
        r10.c = 0L;
        return;
    L30:
        if (r0.equals(ErrorPageButtonAction.RETURN) == false) goto L41;
        BuyNowErrorView.a r13 = r10.b;
        if (r13 == null) goto L42;
        r13.onQuit();
        return;
    L42:
        return;
    L41:
        return;
    }
}
