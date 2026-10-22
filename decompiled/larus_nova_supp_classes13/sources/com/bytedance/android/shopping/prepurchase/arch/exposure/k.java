package com.bytedance.android.shopping.prepurchase.arch.exposure;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements h {
    public final WeakReference<View> a;
    public boolean b;
    public Function0<Unit> c;
    public final a d;
    public final String e;
    public final Function1<String, View> f;
    public final Function1<View, c> g;

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.b = true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.b = false;
        }
    }

    public final void b() {
        View r0 = this.a.get();
        if (r0 == null) goto L5;
        r0.removeOnAttachStateChangeListener(this.d);
    L5:
        Function0<Unit> r1 = this.c;
        if (r1 == null) goto L9;
        Unit r2 = (Unit) r1.invoke();
        return;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.h
    public final c a(l r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        View r0 = this.a.get();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (this.b == true) goto L9;
        return null;
    L9:
        if (r4.b.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r0 = (View) this.f.invoke(r4.b);
    L14:
        if (r0 != null) goto L17;
        return null;
    L17:
        return (c) this.g.invoke(r0);
    L11:
        r2 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(View r2, String r3, Function1<? super String, ? extends View> r4, Function1<? super View, c> r5) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "viewId");
        Intrinsics.checkNotNullParameter(r4, "childViewFinder");
        Intrinsics.checkNotNullParameter(r5, "algorithm");
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new WeakReference(r2);
        a r6 = new a(this);
        this.d = r6;
        r2.addOnAttachStateChangeListener(r6);
        this.b = ViewCompat.isAttachedToWindow(r2);
    }
}
