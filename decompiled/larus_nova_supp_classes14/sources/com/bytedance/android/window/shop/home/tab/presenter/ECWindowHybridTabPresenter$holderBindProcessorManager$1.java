package com.bytedance.android.window.shop.home.tab.presenter;

import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowHybridTabPresenter$holderBindProcessorManager$1 implements com.bytedance.android.ec.hybrid.list.ability.p {
    public com.bytedance.android.window.shop.widget.holderprocessor.d a;
    public final com.bytedance.android.ec.hybrid.list.ability.r b;
    public final com.bytedance.android.ec.hybrid.list.ability.r c;

    public final void release() {
    }

    public final com.bytedance.android.ec.hybrid.list.ability.r IE() {
        return this.c;
    }

    public final com.bytedance.android.ec.hybrid.list.ability.r j70() {
        return this.b;
    }

    public ECWindowHybridTabPresenter$holderBindProcessorManager$1(ECWindowHybridTabPresenter r7) {
        this.a = new com.bytedance.android.window.shop.widget.holderprocessor.d();
        com.bytedance.android.ec.hybrid.list.ability.r r0 = new com.bytedance.android.ec.hybrid.list.ability.r();
        r0.a(new com.bytedance.android.ec.hybrid.list.ability.q[]{new ECWindowHybridTabPresenter.a(r7, ECWindowHybridTabPresenter$holderBindProcessorManager$1$postProcessorMgr$1$1.INSTANCE)});
        r0.a(new com.bytedance.android.ec.hybrid.list.ability.q[]{this.a.f});
        Unit r2 = Unit.INSTANCE;
        this.b = r0;
        com.bytedance.android.ec.hybrid.list.ability.r r1 = new com.bytedance.android.ec.hybrid.list.ability.r();
        r1.a(new com.bytedance.android.ec.hybrid.list.ability.q[]{new ECWindowHybridTabPresenter.a(r7, ECWindowHybridTabPresenter$holderBindProcessorManager$1$preProcessorMgr$1$1.INSTANCE)});
        r1.a(new com.bytedance.android.ec.hybrid.list.ability.q[]{this.a.e});
        this.c = r1;
    }
}
