package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class UserFieldsService_Factory implements Factory<UserFieldsService> {
    private final Provider<g> fgServiceProvider;
    private final Provider<a> repositoryProvider;

    @Override // javax.inject.Provider
    public UserFieldsService get() {
        return newInstance(this.repositoryProvider.get(), this.fgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserFieldsService_Factory(Provider<a> r100, Provider<g> r101) {
        this.repositoryProvider = r100;
        this.fgServiceProvider = r101;
    }

    public static UserFieldsService_Factory create(Provider<a> r100, Provider<g> r101) {
        return new UserFieldsService_Factory(r100, r101);
    }

    public static UserFieldsService newInstance(a r100, g r101) {
        return new UserFieldsService(r100, r101);
    }
}
