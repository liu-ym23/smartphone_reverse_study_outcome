package com.bytedance.android.shopping.new_cart.container;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.ies.uikit.base.AbsActivity;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartObjectContainer {
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.new_cart.components.a>, com.bytedance.android.shopping.new_cart.components.a> a;
    public final ConcurrentHashMap<KClass<? extends com.bytedance.android.shopping.new_cart.components.a>, Function0<com.bytedance.android.shopping.new_cart.components.a>> b;
    public final NewCartActivity c;
    public final CartViewModel d;
    public final b e;
    public final Fragment f;
    public final w g;

    public final Context getContext() {
        AbsActivity r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.f;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getContext();
    }

    public final NewCartActivity getActivity() {
        return this.c;
    }

    public final <T extends com.bytedance.android.shopping.new_cart.components.a> T a(KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r4) {
        Intrinsics.checkNotNullParameter(r4, "clazz");
        com.bytedance.android.shopping.new_cart.components.a r1 = null;
        if (this.a.containsKey(r4) == false) goto L9;
        com.bytedance.android.shopping.new_cart.components.a r5 = this.a.get(r4);
        if ((r5 instanceof com.bytedance.android.shopping.new_cart.components.a) == false) goto L20;
        r1 = r5;
    L20:
        return (T) r1;
    L9:
        Function0<com.bytedance.android.shopping.new_cart.components.a> r0 = this.b.get(r4);
        if (r0 == null) goto L12;
        com.bytedance.android.shopping.new_cart.components.a r2 = (com.bytedance.android.shopping.new_cart.components.a) r0.invoke();
    L13:
        if (r2 == null) goto L16;
        this.a.put(r4, r2);
        b(r2);
    L16:
        if ((r2 instanceof com.bytedance.android.shopping.new_cart.components.a) == true) goto L19;
        return null;
    L19:
        return (T) r2;
    L12:
        r2 = null;
        goto L13
    }

    public final void b(com.bytedance.android.shopping.new_cart.components.a r3) {
        NewCartActivity r0 = this.c;
        if (r0 == null) goto L6;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L6;
    L10:
        if (r1 == null) goto L25;
        Lifecycle.State r2 = r1.getCurrentState();
        int r4 = r.a[r2.ordinal()];
        if (r4 != 2) goto L14;
        r3.h();
        return;
    L14:
        if (r4 != 3) goto L16;
        r3.h();
        r3.l();
        return;
    L16:
        if (r4 != 4) goto L18;
        r3.h();
        r3.l();
        r3.k();
        return;
    L18:
        if (r4 != 5) goto L29;
        r3.h();
        r3.l();
        r3.k();
        r3.j();
        r3.m();
        r3.i();
        return;
    L29:
        return;
    L25:
        return;
    L6:
        Fragment r5 = this.f;
        if (r5 == null) goto L9;
        r1 = r5.getLifecycle();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    public final <T extends com.bytedance.android.shopping.new_cart.components.a> void c(KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r2, Boolean r3, Function0<? extends T> r4) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r4, "func");
        this.b.put(r2, r4);
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L11;
        Function0<com.bytedance.android.shopping.new_cart.components.a> r5 = this.b.get(r2);
        if (r5 == null) goto L7;
        com.bytedance.android.shopping.new_cart.components.a r6 = (com.bytedance.android.shopping.new_cart.components.a) r5.invoke();
    L8:
        if (r6 == null) goto L12;
        this.a.put(r2, r6);
        b(r6);
        return;
    L12:
        return;
    L7:
        r6 = null;
        goto L8
    }

    public CartObjectContainer(CartViewModel r2, NewCartActivity r3, b r4, Fragment r5, w r6) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r6, "screenSizeService");
        this.d = r2;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = r3;
        if (r3 == null) goto L6;
        Lifecycle r7 = r3.getLifecycle();
        if (r7 == null) goto L6;
    L9:
        if (r7 == null) goto L12;
        r7.addObserver(new AnonymousClass1(this));
        return;
    L12:
        return;
    L6:
        if (r5 == null) goto L8;
        r7 = r5.getLifecycle();
        goto L9
    L8:
        r7 = null;
        goto L9
    }
}
