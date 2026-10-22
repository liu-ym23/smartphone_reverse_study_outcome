package com.bytedance.android.window.shop.home.module;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface k {

    public static final class a {
        public static View a(k r2, int r3) {
            com.bytedance.android.window.shop.home.module.a r4 = (com.bytedance.android.window.shop.home.module.a) r2;
            r4.getClass();
            ShoppingAsyncInflater.a r0 = ShoppingAsyncInflater.e;
            Context r5 = r4.a().b;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("context");
        L5:
            Context r6 = th.a.e(r5, true);
            r0.getClass();
            return ShoppingAsyncInflater.a.a(r6).aU(r3, null, false);
        }
    }
}
