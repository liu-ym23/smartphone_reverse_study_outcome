package com.ss.android.lark.applink;

import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import javax.inject.Provider;
import ova.s;

/* JADX INFO: loaded from: classes34.dex */
public final class UserScopeAppLinkDelegateImpl_Factory implements Factory<s> {
    private final Provider<UserSession> userSessionProvider;

    @Override // javax.inject.Provider
    public s get() {
        return newInstance(this.userSessionProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserScopeAppLinkDelegateImpl_Factory(Provider<UserSession> r100) {
        this.userSessionProvider = r100;
    }

    public static UserScopeAppLinkDelegateImpl_Factory create(Provider<UserSession> r100) {
        return new UserScopeAppLinkDelegateImpl_Factory(r100);
    }

    public static s newInstance(UserSession r100) {
        return new s(r100);
    }
}
