package com.bytedance.android.shopping.card_list.yata;

import android.content.Context;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.yata.abilities.CardListYataRouterAbility;
import com.bytedance.android.shopping.card_list.yata.abilities.YataApiProtocol;
import com.bytedance.android.shopping.card_list.yata.abilities.YataPageCallbackImpl;
import com.bytedance.android.shopping.card_list.yata.abilities.YataToastImpl;
import com.bytedance.android.shopping.card_list.yata.abilities.YataTrackerAbility;
import com.bytedance.android.shopping.yata.ability.YataConfirmAbility;
import com.bytedance.android.shopping.yata.ability.YataNetworkAbility;
import com.bytedance.kmp.ec.yata.a;
import com.bytedance.kmp.ec.yata.common.biz.callback.c;
import com.bytedance.kmp.ec.yata.common.biz.callback.f;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v96.b;
import v96.d;
import v96.e;
import v96.g;
import v96.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListYataAbilityProvider extends a {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final CardListObjectContainer j;
    public final Map<String, Object> k;

    public final b a() {
        return (YataConfirmAbility) this.i.getValue();
    }

    public final d b() {
        return (YataNetworkAbility) this.e.getValue();
    }

    public final f c() {
        return (YataPageCallbackImpl) this.b.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.biz.callback.d d() {
        return (YataPageCallbackImpl) this.b.getValue();
    }

    public final c e() {
        return (YataPageCallbackImpl) this.b.getValue();
    }

    public final v96.f.a f() {
        return (YataPageCallbackImpl) this.b.getValue();
    }

    public final h g() {
        return (YataTrackerAbility) this.d.getValue();
    }

    public final v96.c getErrorHandler() {
        return new com.bytedance.android.shopping.card_list.yata.abilities.a();
    }

    public final g h() {
        return (YataToastImpl) this.h.getValue();
    }

    public final v96.a i() {
        return (YataApiProtocol) this.f.getValue();
    }

    public final e j() {
        return (CardListYataRouterAbility) this.g.getValue();
    }

    public CardListYataAbilityProvider(CardListObjectContainer r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        Context r0 = r2.getContext();
        Intrinsics.checkNotNull(r0);
        super(r0);
        this.j = r2;
        this.k = r3;
        this.b = LazyKt.lazy(new CardListYataAbilityProvider$processCallback$2(this));
        this.c = LazyKt.lazy(new CardListYataAbilityProvider$trackerComponent$2(this));
        this.d = LazyKt.lazy(new CardListYataAbilityProvider$trackerAbility$2(this));
        this.e = LazyKt.lazy(new CardListYataAbilityProvider$netAbility$2(this));
        this.f = LazyKt.lazy(new CardListYataAbilityProvider$apiProtocol$2(this));
        this.g = LazyKt.lazy(new CardListYataAbilityProvider$schemaAbility$2(this));
        this.h = LazyKt.lazy(new CardListYataAbilityProvider$toastAbility$2(this));
        this.i = LazyKt.lazy(new CardListYataAbilityProvider$confirmAbility$2(this));
    }
}
