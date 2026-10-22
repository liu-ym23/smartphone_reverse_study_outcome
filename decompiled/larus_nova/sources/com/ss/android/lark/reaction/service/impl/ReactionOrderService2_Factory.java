package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes37.dex */
public final class ReactionOrderService2_Factory implements Factory<ReactionOrderService2> {
    private final Provider<rsb.a> emojiMapManagerProvider;
    private final Provider<rsb.b> emojiServiceProvider;
    private final Provider<m> passportProvider;
    private final Provider<m2c.b> reactionServiceProvider;
    private final Provider<l> rustClientProvider;
    private final Provider<g> userFeatureGatingServiceProvider;

    @Override // javax.inject.Provider
    public ReactionOrderService2 get() {
        return newInstance(this.passportProvider.get(), this.rustClientProvider.get(), this.emojiServiceProvider.get(), this.emojiMapManagerProvider.get(), this.reactionServiceProvider.get(), this.userFeatureGatingServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ReactionOrderService2_Factory(Provider<m> r100, Provider<l> r101, Provider<rsb.b> r102, Provider<rsb.a> r103, Provider<m2c.b> r104, Provider<g> r105) {
        this.passportProvider = r100;
        this.rustClientProvider = r101;
        this.emojiServiceProvider = r102;
        this.emojiMapManagerProvider = r103;
        this.reactionServiceProvider = r104;
        this.userFeatureGatingServiceProvider = r105;
    }

    public static ReactionOrderService2_Factory create(Provider<m> r100, Provider<l> r101, Provider<rsb.b> r110, Provider<rsb.a> r111, Provider<m2c.b> r112, Provider<g> r113) {
        return new ReactionOrderService2_Factory(r100, r101, r110, r111, r112, r113);
    }

    public static ReactionOrderService2 newInstance(m r100, l r101, rsb.b r110, rsb.a r111, m2c.b r112, g r113) {
        return new ReactionOrderService2(r100, r101, r110, r111, r112, r113);
    }
}
