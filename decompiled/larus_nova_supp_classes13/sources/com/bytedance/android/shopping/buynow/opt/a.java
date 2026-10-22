package com.bytedance.android.shopping.buynow.opt;

import android.content.Context;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (BuyNowPerformanceOpt.q() == false) goto L6;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).a().c(2131559218, 1, "步进器").c(2131559219, 2, "跑马灯").c(2131559217, 1, "倒计时").commit();
        return;
    }
}
