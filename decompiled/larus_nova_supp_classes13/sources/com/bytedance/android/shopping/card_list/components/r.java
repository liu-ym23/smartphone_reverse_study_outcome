package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import com.bytedance.android.shopping.card_list.components.c;
import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r<VIEW_TYPE extends View, STATE extends c, ACTION extends q> extends SimpleScene<VIEW_TYPE, STATE, ACTION> {
    public r() {
    }

    public final void a(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        ACTION r3 = (ACTION) r2.invoke();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.c = r3;
    }

    public final void b(final Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        Function0<Unit> r0 = new SimpleSceneDsl$onCreate$1(this, r2);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.d = r0;
    }

    public final void c(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        STATE r3 = (STATE) r2.invoke();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.b = r3;
    }

    public final void d(Function2 r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        STATE r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        ACTION r1 = this.c;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L8:
        this.a = (VIEW_TYPE) r4.invoke(r0, r1);
    }
}
