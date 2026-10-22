package com.bytedance.android.shopping.collect.yata.ability;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.yata.ability.YataConfirmAbility;
import com.bytedance.android.shopping.yata.ability.YataNetworkAbility;
import com.bytedance.kmp.ec.yata.common.biz.callback.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.g;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectYataAbilityProvider extends com.bytedance.kmp.ec.yata.a {
    public final Lazy b;
    public final String c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final CollectYataFragment l;
    public final com.bytedance.kmp.ec.yata.view.render.delegate.v2.a m;

    public final v96.b a() {
        return (YataConfirmAbility) this.d.getValue();
    }

    public final v96.d b() {
        return (YataNetworkAbility) this.e.getValue();
    }

    public final f c() {
        return (c) this.k.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.d d() {
        return (c) this.k.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.c e() {
        return (c) this.k.getValue();
    }

    public final v96.f.a f() {
        return (c) this.k.getValue();
    }

    public final h g() {
        return (e) this.i.getValue();
    }

    public final v96.c getErrorHandler() {
        return (b) this.j.getValue();
    }

    public final g h() {
        return (d) this.g.getValue();
    }

    public final v96.a i() {
        return (a) this.h.getValue();
    }

    public final v96.e j() {
        return (com.bytedance.android.shopping.yata.ability.b) this.f.getValue();
    }

    public CollectYataAbilityProvider(final Context r2, CollectYataFragment r3, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "sliceRenderInfo");
        super(r2);
        this.l = r3;
        this.m = r4;
        this.b = LazyKt.lazy(new CollectYataAbilityProvider$innerApplication$2(r2));
        if (ECAppInfoService.e.isNightMode() == false) goto L5;
        String r5 = "dark";
    L6:
        this.c = r5;
        this.d = LazyKt.lazy(new CollectYataAbilityProvider$confirmAbility$2(r2));
        this.e = LazyKt.lazy(CollectYataAbilityProvider$netAbility$2.INSTANCE);
        this.f = LazyKt.lazy(new CollectYataAbilityProvider$schemaAbility$2(this, r2));
        this.g = LazyKt.lazy(new CollectYataAbilityProvider$toastAbility$2(this, r2));
        this.h = LazyKt.lazy(new CollectYataAbilityProvider$apiProtocol$2(this));
        this.i = LazyKt.lazy(new CollectYataAbilityProvider$trackerAbility$2(this));
        this.j = LazyKt.lazy(CollectYataAbilityProvider$errorHandler$2.INSTANCE);
        this.k = LazyKt.lazy(new CollectYataAbilityProvider$processCallback$2(this));
        return;
    L5:
        r5 = "light";
        goto L6
    }
}
