package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class UserFieldsRepositoryV2_Factory implements Factory<d> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserFieldsRepositoryV2_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static UserFieldsRepositoryV2_Factory create(Provider<l> r100) {
        return new UserFieldsRepositoryV2_Factory(r100);
    }

    public static d newInstance(l r100) {
        return new d(r100);
    }
}
