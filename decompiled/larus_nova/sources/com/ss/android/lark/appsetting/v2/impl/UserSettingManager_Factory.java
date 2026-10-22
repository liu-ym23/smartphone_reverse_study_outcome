package com.ss.android.lark.appsetting.v2.impl;

import awa.b;
import bwa.r;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class UserSettingManager_Factory implements Factory<r> {
    private final Provider<b> globalSettingDispatcherProvider;
    private final Provider<b> mGlobalSettingDispatcherProvider;
    private final Provider<String> mUidProvider;

    @Override // javax.inject.Provider
    public r get() {
        r r100 = newInstance(this.globalSettingDispatcherProvider.get());
        r100.f21268a = this.mUidProvider.get();
        r100.f21269b = this.mGlobalSettingDispatcherProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static r newInstance(b r100) {
        return new r(r100);
    }

    public UserSettingManager_Factory(Provider<b> r100, Provider<String> r101, Provider<b> r102) {
        this.globalSettingDispatcherProvider = r100;
        this.mUidProvider = r101;
        this.mGlobalSettingDispatcherProvider = r102;
    }

    public static UserSettingManager_Factory create(Provider<b> r100, Provider<String> r101, Provider<b> r102) {
        return new UserSettingManager_Factory(r100, r101, r102);
    }
}
