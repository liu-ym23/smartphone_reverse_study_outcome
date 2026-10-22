package com.bytedance.android.shopping.store.tabkit;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ FrameLayout.LayoutParams c;
    public final /* synthetic */ Ref.IntRef d;
    public final /* synthetic */ View e;

    public c(View r1, Ref.IntRef r2, FrameLayout.LayoutParams r3, Ref.IntRef r4, View r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        View r0 = this.a;
        if (r0 != null) goto L5;
    L14:
        FrameLayout.LayoutParams r1 = this.c;
        r1.gravity = 3;
        r1.setMargins(this.b.element, r1.topMargin, this.d.element, r1.bottomMargin);
        this.e.requestLayout();
        return;
    L5:
        if (e.a(r0) != true) goto L14;
        Ref.IntRef r2 = this.b;
        int r3 = this.a.getWidth();
        ViewGroup.LayoutParams r4 = this.a.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r4 = null;
    L9:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L12;
        int r6 = r5.leftMargin;
    L13:
        r2.element = r3 + r6;
        goto L14
    L12:
        r6 = 0;
        goto L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
