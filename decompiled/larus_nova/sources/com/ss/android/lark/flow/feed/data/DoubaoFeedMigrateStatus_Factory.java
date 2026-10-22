package com.ss.android.lark.flow.feed.data;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class DoubaoFeedMigrateStatus_Factory implements Factory<DoubaoFeedMigrateStatus> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<m> passportProvider;
    private final Provider<l> userRustClientProvider;

    @Override // javax.inject.Provider
    public DoubaoFeedMigrateStatus get() {
        return newInstance(this.currentUserIdProvider.get(), this.userRustClientProvider.get(), this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DoubaoFeedMigrateStatus_Factory(Provider<String> r100, Provider<l> r101, Provider<m> r102) {
        this.currentUserIdProvider = r100;
        this.userRustClientProvider = r101;
        this.passportProvider = r102;
    }

    public static DoubaoFeedMigrateStatus_Factory create(Provider<String> r100, Provider<l> r101, Provider<m> r102) {
        return new DoubaoFeedMigrateStatus_Factory(r100, r101, r102);
    }

    public static DoubaoFeedMigrateStatus newInstance(String r100, l r101, m r102) {
        return new DoubaoFeedMigrateStatus(r100, r101, r102);
    }
}
