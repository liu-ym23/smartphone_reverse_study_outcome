package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.b;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatTypingTranslateCoordinatorMock_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatTypingTranslateCoordinatorMock_Factory f433313a = null;

        static {
            f433313a = new ChatTypingTranslateCoordinatorMock_Factory();
        }
    }

    public ChatTypingTranslateCoordinatorMock_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChatTypingTranslateCoordinatorMock_Factory create() {
        return a.f433313a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
