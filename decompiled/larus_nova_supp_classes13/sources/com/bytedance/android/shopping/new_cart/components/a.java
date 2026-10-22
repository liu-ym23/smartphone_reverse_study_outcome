package com.bytedance.android.shopping.new_cart.components;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a {
    public final CartObjectContainer a;

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public final NewCartActivity c() {
        return this.a.getActivity();
    }

    public final Context e() {
        return this.a.getContext();
    }

    public final LifecycleOwner f() {
        NewCartActivity r0 = c();
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.a.f;
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new Exception("访问了不存在了lifecycle");
    }

    public a(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final <T extends a> T g(KClass<? extends a> r2) {
        Intrinsics.checkNotNullParameter(r2, "className");
        return (T) this.a.a(r2);
    }
}
