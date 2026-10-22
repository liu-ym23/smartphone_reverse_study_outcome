package com.bytedance.android.shopping.buynow.controller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public boolean a;
    public String b;
    public final View c;
    public final View d;
    public final RecyclerView e;
    public final BuyNowViewModel f;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.buynow.controller.a$a, reason: collision with other inner class name */
    public static final class C0026a {
    }

    static {
    }

    public final void a() {
        int r0 = com.bytedance.android.shopping.buynow.utils.b.a;
        if (com.bytedance.android.shopping.buynow.utils.b.a(this.f) == true) goto L6;
        this.c.setVisibility(0);
        return;
    }

    public a(View r2, View r3, RecyclerView r4, BuyNowViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "titleContainer");
        Intrinsics.checkNotNullParameter(r3, "addressStickyContainer");
        Intrinsics.checkNotNullParameter(r4, "bodyContainer");
        Intrinsics.checkNotNullParameter(r5, "buyNowViewModel");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
