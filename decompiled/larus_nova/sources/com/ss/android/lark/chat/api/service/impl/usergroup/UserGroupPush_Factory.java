package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.o;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class UserGroupPush_Factory implements Factory<UserGroupPush> {
    private final Provider<b> pushRepoProvider;
    private final Provider<o> userGroupServiceProvider;

    @Override // javax.inject.Provider
    public UserGroupPush get() {
        return newInstance(this.pushRepoProvider.get(), this.userGroupServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserGroupPush_Factory(Provider<b> r100, Provider<o> r101) {
        this.pushRepoProvider = r100;
        this.userGroupServiceProvider = r101;
    }

    public static UserGroupPush_Factory create(Provider<b> r100, Provider<o> r101) {
        return new UserGroupPush_Factory(r100, r101);
    }

    public static UserGroupPush newInstance(b r100, o r101) {
        return new UserGroupPush(r100, r101);
    }
}
