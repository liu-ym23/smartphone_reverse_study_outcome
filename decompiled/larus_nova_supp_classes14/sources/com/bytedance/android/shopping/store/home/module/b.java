package com.bytedance.android.shopping.store.home.module;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.store.home.preload.resource.ECStoreResourcePreloadManager;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b extends QUIModule implements q {
    public final Fragment l;
    public View m;

    public b() {
        throw null;
    }

    public abstract View k(ViewGroup r1);

    public b(int r2, Fragment r3) {
        super(r2, null);
        this.l = r3;
    }

    public final View f(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (this.m == null) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
        this.m = k(r3);
    L8:
        View r5 = this.m;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        return r5;
    L5:
        r4 = false;
        goto L6
    }

    public final View l(int r4, ViewGroup r5) {
        Context r0 = a().b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("context");
    L5:
        Context r1 = th.a.e(r0, true);
        Intrinsics.checkNotNullParameter(r1, "context");
        View r2 = ((ECStoreResourcePreloadManager) ECStoreResourcePreloadManager.c.getValue()).a(r1, r4);
        if (r2 != null) goto L10;
        ContextThemeWrapper r3 = new ContextThemeWrapper(th.a.e(r1, true), 2131952363);
        ShoppingAsyncInflater.e.getClass();
        return ShoppingAsyncInflater.a.a(r3).aU(r4, r5, false);
    L10:
        return r2;
    }
}
