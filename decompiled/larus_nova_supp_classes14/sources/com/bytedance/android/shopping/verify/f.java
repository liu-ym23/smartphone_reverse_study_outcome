package com.bytedance.android.shopping.verify;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends c {
    public final Function0<Unit> c;

    @Override // com.bytedance.android.shopping.verify.c, android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.c.invoke();
        super.onClick(r2);
    }

    public f(String r2, int r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "mUrl");
        Intrinsics.checkNotNullParameter(r4, "spanClickListener");
        super(r2, r3);
        this.c = r4;
    }
}
