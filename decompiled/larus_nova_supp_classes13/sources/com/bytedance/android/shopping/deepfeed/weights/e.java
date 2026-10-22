package com.bytedance.android.shopping.deepfeed.weights;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Function1 b;

    public e(int r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        Function1 r3 = this.b;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(Integer.valueOf(this.a));
        return;
    }
}
