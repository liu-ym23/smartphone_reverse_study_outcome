package com.bytedance.android.shopping.sku.inner.yata.abilities;

import android.content.Context;
import com.bytedance.android.shopping.yata.ability.YataConfirmAbility;
import com.bytedance.android.shopping.yata.ability.YataNetworkAbility;
import com.bytedance.kmp.ec.yata.common.biz.callback.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.g;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataAbilityProvider extends com.bytedance.kmp.ec.yata.a {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final com.bytedance.android.shopping.sku.inner.container.b j;

    public final v96.b a() {
        return (YataConfirmAbility) this.b.getValue();
    }

    public final v96.d b() {
        return (YataNetworkAbility) this.c.getValue();
    }

    public final f c() {
        return (SkuYataProgressCallback) this.i.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.d d() {
        return (SkuYataProgressCallback) this.i.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.c e() {
        return (SkuYataProgressCallback) this.i.getValue();
    }

    public final v96.f.a f() {
        return (SkuYataProgressCallback) this.i.getValue();
    }

    public final h g() {
        return (e) this.g.getValue();
    }

    public final v96.c getErrorHandler() {
        return (c) this.h.getValue();
    }

    public final g h() {
        return (d) this.e.getValue();
    }

    public final v96.a i() {
        return (b) this.f.getValue();
    }

    public final v96.e j() {
        return (SkuYataRouterAbility) this.d.getValue();
    }

    public SkuYataAbilityProvider(final Context r2, com.bytedance.android.shopping.sku.inner.container.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        super(r2);
        this.j = r3;
        this.b = LazyKt.lazy(new SkuYataAbilityProvider$confirmAbility$2(r2));
        this.c = LazyKt.lazy(SkuYataAbilityProvider$netAbility$2.INSTANCE);
        this.d = LazyKt.lazy(new SkuYataAbilityProvider$schemaAbility$2(this));
        this.e = LazyKt.lazy(new SkuYataAbilityProvider$toastAbility$2(this, r2));
        this.f = LazyKt.lazy(new SkuYataAbilityProvider$apiProtocol$2(this));
        this.g = LazyKt.lazy(new SkuYataAbilityProvider$trackerAbility$2(this));
        this.h = LazyKt.lazy(SkuYataAbilityProvider$errorHandler$2.INSTANCE);
        this.i = LazyKt.lazy(new SkuYataAbilityProvider$processCallback$2(this));
    }
}
