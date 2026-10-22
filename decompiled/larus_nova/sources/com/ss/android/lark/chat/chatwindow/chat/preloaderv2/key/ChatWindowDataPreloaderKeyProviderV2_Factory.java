package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.key;

import dagger.internal.Factory;
import v3b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class ChatWindowDataPreloaderKeyProviderV2_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatWindowDataPreloaderKeyProviderV2_Factory f413494a = null;

        static {
            f413494a = new ChatWindowDataPreloaderKeyProviderV2_Factory();
        }
    }

    public ChatWindowDataPreloaderKeyProviderV2_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChatWindowDataPreloaderKeyProviderV2_Factory create() {
        return a.f413494a;
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }
}
