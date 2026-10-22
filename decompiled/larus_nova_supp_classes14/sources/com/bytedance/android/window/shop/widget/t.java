package com.bytedance.android.window.shop.widget;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ Function1 a;

    public t(Function1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1 r3 = this.a;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(null);
        return;
    }
}
