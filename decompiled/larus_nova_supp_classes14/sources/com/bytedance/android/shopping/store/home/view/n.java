package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.k1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n extends LinearLayout implements com.bytedance.android.ec.store.common.bubble.d {
    public final ImageView a;
    public final int b;
    public final int c;
    public final int d;
    public final LifecycleOwner e;
    public final View f;
    public final ViewGroup g;
    public final long h;
    public final Function0<Unit> i;

    public static final class a {
    }

    static {
    }

    public final void b() {
        int r0 = this.f.getWidth();
        int r1 = this.f.getHeight();
        int[] r3 = new int[2];
        this.f.getLocationInWindow(r3);
        int r2 = RangesKt.coerceAtLeast((((k1.m(getContext()) - r3[0]) - (r0 / 2)) - this.c) - (this.b / 2), 0);
        d2.e(this.a, r2);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.rightMargin = this.c;
        r4.topMargin = (r3[1] + r1) + this.d;
        r4.gravity = 8388661;
        ViewParent r5 = getParent();
        if ((r5 instanceof ViewGroup) == true) goto L5;
        r5 = null;
    L5:
        ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L8;
        r6.removeView(this);
    L8:
        ViewGroup r7 = this.g;
        if (r7 == null) goto L11;
        r7.addView(this, r4);
    L11:
        new Handler(Looper.getMainLooper()).postDelayed(new o(this), this.h);
        this.i.invoke();
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.e;
    }

    public n(Context r3, LifecycleOwner r4, View r5, ViewGroup r6, String r7, long r8, Function0 r10) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "anchorView");
        Intrinsics.checkNotNullParameter(r7, "contentString");
        Intrinsics.checkNotNullParameter(r10, "showAction");
        super(r3, null, 0);
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r8;
        this.i = r10;
        this.b = com.bytedance.android.shopping.extensions.b.b(20);
        this.c = com.bytedance.android.shopping.extensions.b.b(4);
        this.d = com.bytedance.android.shopping.extensions.b.b(2);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560958, this, true);
        setOrientation(1);
        this.a = (ImageView) findViewById(2131371132);
        TextView r9 = (TextView) findViewById(2131371104);
        ((ImageView) findViewById(2131371103)).setOnClickListener(new m(this));
        Unit r11 = Unit.INSTANCE;
        r9.setText(r7);
    }
}
