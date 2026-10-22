package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatBundleTransform_Factory implements Factory<ChatBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    @Override // javax.inject.Provider
    public ChatBundleTransform get() {
        return newInstance(this.chatLaunchServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatBundleTransform_Factory(Provider<b> r100) {
        this.chatLaunchServiceProvider = r100;
    }

    public static ChatBundleTransform_Factory create(Provider<b> r100) {
        return new ChatBundleTransform_Factory(r100);
    }

    public static ChatBundleTransform newInstance(b r100) {
        return new ChatBundleTransform(r100);
    }
}
