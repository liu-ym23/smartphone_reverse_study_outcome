package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatStarterMock_Factory implements Factory<ytb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatStarterMock_Factory f433312a = null;

        static {
            f433312a = new ChatStarterMock_Factory();
        }
    }

    public ChatStarterMock_Factory() {
    }

    public static ytb.a newInstance() {
        return new ytb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChatStarterMock_Factory create() {
        return a.f433312a;
    }

    @Override // javax.inject.Provider
    public ytb.a get() {
        return newInstance();
    }
}
