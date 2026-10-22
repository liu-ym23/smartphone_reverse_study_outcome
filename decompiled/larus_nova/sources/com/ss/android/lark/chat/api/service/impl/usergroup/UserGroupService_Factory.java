package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class UserGroupService_Factory implements Factory<UserGroupService> {
    private final Provider<g> fgServiceProvider;
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public UserGroupService get() {
        return newInstance(this.rustClientProvider.get(), this.fgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserGroupService_Factory(Provider<l> r100, Provider<g> r101) {
        this.rustClientProvider = r100;
        this.fgServiceProvider = r101;
    }

    public static UserGroupService_Factory create(Provider<l> r100, Provider<g> r101) {
        return new UserGroupService_Factory(r100, r101);
    }

    public static UserGroupService newInstance(l r100, g r101) {
        return new UserGroupService(r100, r101);
    }
}
