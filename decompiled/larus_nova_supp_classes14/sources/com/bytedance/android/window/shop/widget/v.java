package com.bytedance.android.window.shop.widget;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ uq3.e b;
    public final /* synthetic */ Function2 c;

    public v(Function1 r1, uq3.e r2, Function2 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Function1 r4 = this.a;
        if (r4 == null) goto L5;
        Unit r5 = (Unit) r4.invoke(this.b.e);
    L5:
        Function2 r6 = this.c;
        if (r6 == null) goto L13;
        Integer r0 = this.b.f;
        if (r0 == null) goto L10;
        String r1 = String.valueOf(r0.intValue());
    L11:
        Unit r7 = (Unit) r6.invoke("bubble_click", r1);
        return;
    L10:
        r1 = null;
        goto L11
    }
}
