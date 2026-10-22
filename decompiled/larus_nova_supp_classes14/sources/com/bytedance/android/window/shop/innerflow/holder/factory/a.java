package com.bytedance.android.window.shop.innerflow.holder.factory;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static View a(Context r2, int r3) {
        ShoppingAsyncInflater.e.getClass();
        View r4 = c.a(ShoppingAsyncInflater.a.a(r2), r3, null, 6);
        a.getClass();
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return r4;
    }
}
