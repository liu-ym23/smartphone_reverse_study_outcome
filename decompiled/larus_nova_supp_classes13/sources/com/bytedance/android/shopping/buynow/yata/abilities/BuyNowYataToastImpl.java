package com.bytedance.android.shopping.buynow.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowYataToastImpl implements v96.g {
    public final Context a;

    public static final class a {
    }

    static {
    }

    public BuyNowYataToastImpl(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.buynow.utils.i.a r0 = com.bytedance.android.shopping.buynow.utils.i.a;
        com.bytedance.android.shopping.buynow.utils.i.a(new BuyNowYataToastImpl$toast$1(this, r2));
    }
}
