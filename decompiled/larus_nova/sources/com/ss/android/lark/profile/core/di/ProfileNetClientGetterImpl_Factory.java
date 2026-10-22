package com.ss.android.lark.profile.core.di;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class ProfileNetClientGetterImpl_Factory implements Factory<ProfileNetClientGetterImpl> {
    private final Provider<l> rustClientProvider;
    private final Provider<b38.b> scopedRucketProvider;

    @Override // javax.inject.Provider
    public ProfileNetClientGetterImpl get() {
        return newInstance(this.rustClientProvider.get(), this.scopedRucketProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ProfileNetClientGetterImpl_Factory(Provider<l> r100, Provider<b38.b> r101) {
        this.rustClientProvider = r100;
        this.scopedRucketProvider = r101;
    }

    public static ProfileNetClientGetterImpl_Factory create(Provider<l> r100, Provider<b38.b> r101) {
        return new ProfileNetClientGetterImpl_Factory(r100, r101);
    }

    public static ProfileNetClientGetterImpl newInstance(l r100, b38.b r101) {
        return new ProfileNetClientGetterImpl(r100, r101);
    }
}
