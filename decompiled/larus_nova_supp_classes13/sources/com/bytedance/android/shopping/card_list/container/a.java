package com.bytedance.android.shopping.card_list.container;

import android.R;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ Window a;
    public final /* synthetic */ Ref.ObjectRef b;

    public a(Window r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        Ref.ObjectRef r0 = this.b;
        if (((View) r0.element) != null) goto L10;
        View r1 = this.a.getDecorView();
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == c.a) goto L9;
        c.a(r2, "getDecorView");
    L9:
        r0.element = r1.findViewById(R.id.statusBarBackground);
    L10:
        View r3 = (View) this.b.element;
        Drawable r4 = null;
        if (r3 == null) goto L13;
        Drawable r5 = r3.getBackground();
    L15:
        if ((r5 instanceof ColorDrawable) == true) goto L19;
        View r6 = (View) this.b.element;
        if (r6 == null) goto L19;
        r6.setBackground(new ColorDrawable(0));
    L19:
        View r7 = (View) this.b.element;
        if (r7 == null) goto L22;
        r4 = r7.getBackground();
    L22:
        ColorDrawable r8 = (ColorDrawable) r4;
        if (r8 == null) goto L27;
        r8.setColor(0);
        return true;
    L27:
        return true;
    L13:
        r5 = null;
        goto L15
    }
}
