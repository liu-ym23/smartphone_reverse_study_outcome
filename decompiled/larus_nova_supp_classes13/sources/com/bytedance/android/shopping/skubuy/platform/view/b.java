package com.bytedance.android.shopping.skubuy.platform.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ PlatformErrorView a;

    public b(PlatformErrorView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.b;
        if (r2 == null) goto L6;
        Unit r3 = (Unit) r2.invoke();
        return;
    }
}
