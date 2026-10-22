package com.ss.android.lark.chatwindow.launcher.transform;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatLaunchParamDataBundleTransform_Factory implements Factory<ChatLaunchParamDataBundleTransform> {
    private final Provider<b> chatLaunchServiceProvider;

    @Override // javax.inject.Provider
    public ChatLaunchParamDataBundleTransform get() {
        return newInstance(this.chatLaunchServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ChatLaunchParamDataBundleTransform_Factory(Provider<b> r100) {
        this.chatLaunchServiceProvider = r100;
    }

    public static ChatLaunchParamDataBundleTransform_Factory create(Provider<b> r100) {
        return new ChatLaunchParamDataBundleTransform_Factory(r100);
    }

    public static ChatLaunchParamDataBundleTransform newInstance(b r100) {
        return new ChatLaunchParamDataBundleTransform(r100);
    }
}
