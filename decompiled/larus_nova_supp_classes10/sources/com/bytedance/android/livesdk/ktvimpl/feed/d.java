package com.bytedance.android.livesdk.ktvimpl.feed;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ Function2 d;

    public d(View r1, View r2, Function0 r3, Function2 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        int r0 = s1.w();
        int r1 = this.a.getHeight();
        int r2 = this.a.getWidth();
        float r3 = r0;
        int r4 = (int) (0.5625f * r3);
        a1.p(this.b, r4);
        a1.k(this.b, r0);
        Function0 r5 = this.c;
        if (r5 == null) goto L5;
        Unit r6 = (Unit) r5.invoke();
    L5:
        float r7 = r1 / r3;
        this.b.setPivotX(0.0f);
        this.b.setPivotY(0.0f);
        this.b.setScaleX(r7);
        this.b.setScaleY(r7);
        float r8 = (r2 - (r4 * r7)) / 2;
        if ((this.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.LayoutParams r9 = this.b.getLayoutParams();
        if (r9 == null) goto L11;
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        r10.leftMargin = (int) r8;
        this.b.setLayoutParams(r10);
        this.b.requestLayout();
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L12:
        Function2 r11 = this.d;
        if (r11 == null) goto L16;
        Unit r12 = (Unit) r11.invoke(Float.valueOf(r7), Float.valueOf(r7));
        return;
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
