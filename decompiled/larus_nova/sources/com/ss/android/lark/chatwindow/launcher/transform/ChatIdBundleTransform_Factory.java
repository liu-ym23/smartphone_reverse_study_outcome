package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatIdBundleTransform_Factory implements Factory<ChatIdBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    @Override // javax.inject.Provider
    public ChatIdBundleTransform get() {
        return newInstance(this.chatLaunchServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatIdBundleTransform_Factory(Provider<b> r100) {
        this.chatLaunchServiceProvider = r100;
    }

    public static ChatIdBundleTransform_Factory create(Provider<b> r100) {
        return new ChatIdBundleTransform_Factory(r100);
    }

    public static ChatIdBundleTransform newInstance(b r100) {
        return new ChatIdBundleTransform(r100);
    }
}
