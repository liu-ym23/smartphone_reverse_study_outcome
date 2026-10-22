package com.bytedance.android.shopping.new_cart.utils;

import android.app.Activity;
import com.bytedance.android.ec.sdk.helper.r;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Activity r7, String r8, final Function0 r9, final Function0 r10) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "enterFrom");
        Intrinsics.checkNotNullParameter("cart_router", "enterMethod");
        Intrinsics.checkNotNullParameter(r9, "successCallBack");
        Intrinsics.checkNotNullParameter(r10, "errorCallBack");
        r r0 = r.a;
        if (r0.isLogin() == false) goto L5;
        r9.invoke();
        return;
    L5:
        r0.d(r7, r8, "cart_router", "", new CartLoginUtil$checkLogin$1(r9), new CartLoginUtil$checkLogin$2(r10));
    }
}
