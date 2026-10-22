package com.bytedance.android.window.shop.home.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a extends QUIModule implements k {
    public View l;

    public a() {
        this(null);
    }

    public abstract View k(ViewGroup r1);

    public final View l() {
        View r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r0;
    }

    public a(Object r2) {
        super(-1, null);
    }

    public a(int r2) {
        super(r2, null);
    }

    public final View f(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.l == null) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
        this.l = k(r3);
    L8:
        View r5 = this.l;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        return r5;
    L5:
        r4 = false;
        goto L6
    }
}
