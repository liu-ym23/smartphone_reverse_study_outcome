package com.ss.android.lark.chat.api.service.impl.secret;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class SecretChatDataCorruptPush_Factory implements Factory<SecretChatDataCorruptPush> {
    private final Provider<String> currentUserIdProvider;
    private final Provider<l> userClientProvider;

    @Override // javax.inject.Provider
    public SecretChatDataCorruptPush get() {
        return newInstance(this.currentUserIdProvider.get(), this.userClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SecretChatDataCorruptPush_Factory(Provider<String> r100, Provider<l> r101) {
        this.currentUserIdProvider = r100;
        this.userClientProvider = r101;
    }

    public static SecretChatDataCorruptPush_Factory create(Provider<String> r100, Provider<l> r101) {
        return new SecretChatDataCorruptPush_Factory(r100, r101);
    }

    public static SecretChatDataCorruptPush newInstance(String r100, l r101) {
        return new SecretChatDataCorruptPush(r100, r101);
    }
}
