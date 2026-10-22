package com.bytedance.android.shopping.buynow.yata;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.buynow.yata.abilities.BuyNowYataPageCallbackImpl;
import com.bytedance.android.shopping.buynow.yata.abilities.BuyNowYataToastImpl;
import com.bytedance.android.shopping.buynow.yata.abilities.e;
import com.bytedance.android.shopping.buynow.yata.abilities.g;
import com.bytedance.android.shopping.buynow.yata.abilities.m;
import com.bytedance.android.shopping.yata.ability.YataConfirmAbility;
import com.bytedance.android.shopping.yata.ability.YataNetworkAbility;
import com.bytedance.kmp.ec.yata.common.biz.callback.c;
import com.bytedance.kmp.ec.yata.common.biz.callback.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.b;
import v96.d;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.kmp.ec.yata.a {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Activity k;
    public final BuyNowFragment l;
    public final BuyNowViewModel m;

    public final b a() {
        return (YataConfirmAbility) this.j.getValue();
    }

    public final d b() {
        return (YataNetworkAbility) this.e.getValue();
    }

    public final f c() {
        return (BuyNowYataPageCallbackImpl) this.c.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.d d() {
        return (BuyNowYataPageCallbackImpl) this.c.getValue();
    }

    public final c e() {
        return (BuyNowYataPageCallbackImpl) this.c.getValue();
    }

    public final v96.f.a f() {
        return (BuyNowYataPageCallbackImpl) this.c.getValue();
    }

    public final h g() {
        return (g) this.d.getValue();
    }

    public final v96.c getErrorHandler() {
        return (com.bytedance.android.shopping.buynow.yata.abilities.f) this.b.getValue();
    }

    public final v96.g h() {
        if (this.m.getStaticState().c() == false) goto L6;
        return (m) this.i.getValue();
    L6:
        return (BuyNowYataToastImpl) this.h.getValue();
    }

    public final v96.a i() {
        return (e) this.f.getValue();
    }

    public final v96.e j() {
        return (com.bytedance.android.shopping.buynow.yata.abilities.c) this.g.getValue();
    }

    public final Activity getActivity() {
        return this.k;
    }

    public a(FragmentActivity r2, BuyNowFragment r3, BuyNowViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        super(r2);
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.b = LazyKt.lazy(new BuyNowAbilityProvider$errorHandler$2(this));
        this.c = LazyKt.lazy(new BuyNowAbilityProvider$processCallback$2(this));
        this.d = LazyKt.lazy(new BuyNowAbilityProvider$trackerAbility$2(this));
        this.e = LazyKt.lazy(BuyNowAbilityProvider$netAbility$2.INSTANCE);
        this.f = LazyKt.lazy(new BuyNowAbilityProvider$apiProtocol$2(this));
        this.g = LazyKt.lazy(new BuyNowAbilityProvider$schemaAbility$2(this));
        this.h = LazyKt.lazy(new BuyNowAbilityProvider$toastAbility$2(this));
        this.i = LazyKt.lazy(new BuyNowAbilityProvider$ultimateBuyToastAbility$2(this));
        this.j = LazyKt.lazy(new BuyNowAbilityProvider$confirmAbility$2(this));
    }
}
