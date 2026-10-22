package com.bytedance.android.shopping.card_list.router;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardKitService_ProvideFactory implements Factory<sc3.d> {
    private final a module;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public sc3.d m517get() {
        return provideInstance(this.module);
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m517get();
    }

    public CardKitService_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static CardKitService_ProvideFactory create(a r1) {
        return new CardKitService_ProvideFactory(r1);
    }

    public static sc3.d provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static sc3.d proxyProvide(a r1) {
        r1.getClass();
        return (sc3.d) Preconditions.checkNotNull(new b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
