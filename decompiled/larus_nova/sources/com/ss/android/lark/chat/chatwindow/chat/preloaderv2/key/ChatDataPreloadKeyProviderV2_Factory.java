package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.key;

import dagger.internal.Factory;
import v3b.b;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatDataPreloadKeyProviderV2_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatDataPreloadKeyProviderV2_Factory f413493a = null;

        static {
            f413493a = new ChatDataPreloadKeyProviderV2_Factory();
        }
    }

    public ChatDataPreloadKeyProviderV2_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChatDataPreloadKeyProviderV2_Factory create() {
        return a.f413493a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
