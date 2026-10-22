package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends LinearLayout {
    public static final int d = 0;
    public static final float e = 0.0f;
    public static final float f = 0.0f;
    public final ImageView a;
    public final ImageView b;
    public boolean c;

    public static final class a {
    }

    static {
        d = com.bytedance.android.shopping.extensions.b.b(2);
        e = com.bytedance.android.ec.core.utils.q.a(7);
        f = com.bytedance.android.ec.core.utils.q.a(5);
    }

    public final boolean getAscending() {
        return this.c;
    }

    public final ImageView a(boolean r5) {
        ImageView r0 = new ImageView(getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams((int) e, (int) f));
        r0.setAdjustViewBounds(true);
        r0.setImageResource(2131234706);
        if (r5 == true) goto L5;
        r0.setScaleY(-1.0f);
    L5:
        return r0;
    }

    public k(boolean r2, Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null);
        this.c = r2;
        setOrientation(1);
        ImageView r4 = a(true);
        this.a = r4;
        addView(r4);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L7;
        int r0 = d;
        ((ViewGroup.MarginLayoutParams) r5).bottomMargin = r0;
        ImageView r6 = a(false);
        this.b = r6;
        addView(r6);
        b(this.c, true);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void b(boolean r5, boolean r6) {
        this.c = r5;
        if (r6 == false) goto L7;
        int r7 = (int) 4289769652L;
        this.a.setColorFilter(r7);
        this.b.setColorFilter(r7);
        return;
    L7:
        if (r5 == false) goto L9;
        this.a.setColorFilter((int) 4294909001L);
        this.b.setColorFilter((int) 4289769652L);
        return;
    L9:
        this.a.setColorFilter((int) 4289769652L);
        this.b.setColorFilter((int) 4294909001L);
    }
}
