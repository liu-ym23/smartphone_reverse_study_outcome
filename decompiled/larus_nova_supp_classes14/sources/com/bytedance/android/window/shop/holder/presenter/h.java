package com.bytedance.android.window.shop.holder.presenter;

import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.utils.k0;
import com.bytedance.android.window.shop.home.tab.common.WindowConstDef;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements Runnable {
    public final /* synthetic */ WindowHeaderAuthorInfoItemPresenter a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ uq3.o c;

    public h(WindowHeaderAuthorInfoItemPresenter r1, TextView r2, uq3.o r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ViewGroup r0 = this.a.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("shopNameWrapper");
    L5:
        r0.setVisibility(0);
        ViewGroup r1 = this.a.j;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("shopNameWrapper");
    L8:
        TextView r2 = this.b;
        int r3 = RangesKt.coerceAtMost(r1.getMeasuredWidth(), r1.getWidth());
        Iterator r4 = com.bytedance.commerce.base.view.b.a(r1).iterator();
        int r5 = 0;
    L9:
        String r6 = null;
        ViewGroup.LayoutParams r7 = null;
        String r8 = null;
        if (r4.hasNext() == false) goto L35;
        View r9 = (View) r4.next();
        if (Intrinsics.areEqual(r2, r9) == true) goto L9;
        if (r9.getVisibility() == 8) goto L9;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r7 = r10;
    L21:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r7;
        if (r11 == null) goto L24;
        int r12 = r11.leftMargin;
    L25:
        if (r11 == null) goto L27;
        int r13 = r11.rightMargin;
    L28:
        if (r11 == null) goto L30;
        int r14 = r11.getMarginStart();
    L31:
        if (r11 == null) goto L33;
        int r15 = r11.getMarginEnd();
    L34:
        r5 = r5 + (r9.getWidth() + RangesKt.coerceAtLeast(r12 + r13, r14 + r15));
        goto L9
    L33:
        r15 = 0;
        goto L34
    L30:
        r14 = 0;
        goto L31
    L27:
        r13 = 0;
        goto L28
    L24:
        r12 = 0;
        goto L25
    L35:
        int r16 = r3 - r5;
        if (((Boolean) WindowConstDef.r.getValue()).booleanValue() == false) goto L54;
        int r17 = k0.a;
        TextView r18 = this.b;
        uq3.o r19 = this.c;
        if (r19 == null) goto L40;
        r8 = r19.k;
    L40:
        float r20 = r16;
        Intrinsics.checkNotNullParameter(r18, "textView");
        if (r8 == null) goto L74;
        TextPaint r21 = r18.getPaint();
        int r22 = g1.a;
        if (r18.getPaint().measureText(r8) > (r20 - r21.measureText(g1.a.c(r18.getContext(), 2131895741, new Object[]{""})))) goto L46;
        r18.setText(r8);
        return;
    L46:
        int r23 = r8.codePointCount(0, r8.length());
        String r24 = r8;
    L48:
        if (r18.getPaint().measureText(r8) <= r20) goto L53;
        if (a2.b(r24) == false) goto L53;
        if (r24 == null) goto L48;
        r23 = r23 - 1;
        r24 = r24.substring(0, r24.offsetByCodePoints(0, r23));
        int r25 = g1.a;
        r8 = g1.a.c(r18.getContext(), 2131895741, new Object[]{r24});
    L53:
        r18.setText(r8);
        return;
    L74:
        return;
    L54:
        int r26 = k0.a;
        TextView r27 = this.b;
        uq3.o r28 = this.c;
        if (r28 == null) goto L57;
        r6 = r28.k;
    L57:
        k0.d(r27, r6, r16);
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
