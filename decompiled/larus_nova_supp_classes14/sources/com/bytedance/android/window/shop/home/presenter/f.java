package com.bytedance.android.window.shop.home.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.ec.model.ECUrlModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        uq3.a r7 = (uq3.a) r6;
        uq3.o r0 = r7.c;
        if (r0 == null) goto L5;
        ECUrlModel r1 = r0.g;
    L7:
        if (r1 != null) goto L18;
        if (this.a.F() == true) goto L18;
        uq3.o r8 = r7.c;
        if (r8 == null) goto L23;
        String r9 = r8.i;
        if (r9 == null) goto L24;
        Integer r10 = ArraysKt.lastOrNull(j2.a(r9));
        if (r10 == null) goto L25;
        int r11 = r10.intValue();
        this.a.w().b(2131370857).f().setBackgroundColor(0);
        View r2 = this.a.w().b(2131370848).f();
        r2.setBackgroundColor(r11);
        r2.setVisibility(0);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L18:
        if (this.a.F() == false) goto L27;
        int r12 = com.bytedance.android.ec.window.base.utils.c.c(this.a.u().c(), 2131105908);
        e r3 = this.a;
        View r4 = r3.w().b(2131370847).f();
        r4.setBackgroundColor(r12);
        r4.setVisibility(0);
        r3.w().b(2131370857).f().setBackgroundColor(r12);
        View r5 = r3.w().b(2131370968).f();
        r5.setBackgroundColor(r12);
        Drawable r13 = r5.getBackground();
        if (r13 == null) goto L28;
        r13.setAlpha(0);
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
