package com.bytedance.android.shopping.new_cart.yata;

import android.content.Context;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.yata.abilities.CartYataPageCallbackImpl;
import com.bytedance.android.shopping.new_cart.yata.abilities.CartYataRouterAbility;
import com.bytedance.android.shopping.yata.ability.YataConfirmAbility;
import com.bytedance.android.shopping.yata.ability.YataNetworkAbility;
import com.bytedance.kmp.ec.yata.a;
import com.bytedance.kmp.ec.yata.common.biz.callback.c;
import com.bytedance.kmp.ec.yata.common.biz.callback.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.b;
import v96.d;
import v96.e;
import v96.g;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CartYataAbilityProvider extends a {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final CartObjectContainer k;

    public final b a() {
        return (YataConfirmAbility) this.j.getValue();
    }

    public final d b() {
        return (YataNetworkAbility) this.f.getValue();
    }

    public final f c() {
        return (CartYataPageCallbackImpl) this.d.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.d d() {
        return (CartYataPageCallbackImpl) this.d.getValue();
    }

    public final c e() {
        return (CartYataPageCallbackImpl) this.d.getValue();
    }

    public final v96.f.a f() {
        return (CartYataPageCallbackImpl) this.d.getValue();
    }

    public final h g() {
        return (com.bytedance.android.shopping.new_cart.yata.abilities.d) this.e.getValue();
    }

    public final v96.c getErrorHandler() {
        return (com.bytedance.android.shopping.new_cart.yata.abilities.b) this.c.getValue();
    }

    public final g h() {
        return (com.bytedance.android.shopping.new_cart.yata.abilities.c) this.i.getValue();
    }

    public final v96.a i() {
        return (com.bytedance.android.shopping.new_cart.yata.abilities.a) this.g.getValue();
    }

    public final e j() {
        return (CartYataRouterAbility) this.h.getValue();
    }

    public CartYataAbilityProvider(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Context r0 = r2.getContext();
        Intrinsics.checkNotNull(r0);
        super(r0);
        this.k = r2;
        this.b = LazyKt.lazy(new CartYataAbilityProvider$cartVM$2(this));
        this.c = LazyKt.lazy(new CartYataAbilityProvider$errorHandler$2(this));
        this.d = LazyKt.lazy(new CartYataAbilityProvider$processCallback$2(this));
        this.e = LazyKt.lazy(new CartYataAbilityProvider$trackerAbility$2(this));
        this.f = LazyKt.lazy(CartYataAbilityProvider$netAbility$2.INSTANCE);
        this.g = LazyKt.lazy(new CartYataAbilityProvider$apiProtocol$2(this));
        this.h = LazyKt.lazy(new CartYataAbilityProvider$schemaAbility$2(this));
        this.i = LazyKt.lazy(new CartYataAbilityProvider$toastAbility$2(this));
        this.j = LazyKt.lazy(new CartYataAbilityProvider$confirmAbility$2(this));
    }
}
