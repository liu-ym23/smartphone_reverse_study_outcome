package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.c;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatTypingTranslateProxyMock_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatTypingTranslateProxyMock_Factory f433314a = null;

        static {
            f433314a = new ChatTypingTranslateProxyMock_Factory();
        }
    }

    public ChatTypingTranslateProxyMock_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChatTypingTranslateProxyMock_Factory create() {
        return a.f433314a;
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }
}
