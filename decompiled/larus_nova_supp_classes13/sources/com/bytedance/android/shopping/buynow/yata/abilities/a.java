package com.bytedance.android.shopping.buynow.yata.abilities;

import android.app.Activity;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements kl3.a {
    public final Activity a;
    public final BuyNowFragment b;
    public final BuyNowViewModel c;
    public final AndroidYaTaInstance d;
    public final com.bytedance.android.ec.core.async.b e;

    public final d a() {
        return new d(this.c.getTracker());
    }

    public final BuyNowUIAbility b() {
        return new BuyNowUIAbility(this.a, this.b, this.c, this.d);
    }

    public final l c() {
        return new l(this.d);
    }

    public final kl3.b d() {
        return new kl3.b();
    }

    public final kl3.c e() {
        return new kl3.c(this.a);
    }

    public final kl3.e f() {
        return new kl3.e(this.e);
    }

    public final kl3.d r() {
        return new kl3.d(this.b.r);
    }

    public a(Activity r2, BuyNowFragment r3, BuyNowViewModel r4, AndroidYaTaInstance r5, BuyNowFragment r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "buyNowFragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "yataInstance");
        Intrinsics.checkNotNullParameter(r6, "disposableScope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
