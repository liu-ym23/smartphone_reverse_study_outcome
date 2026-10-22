package com.ss.android.lark.officesdk.integrator.im.impl.dependency;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatFileDetailDependency_Factory implements Factory<xtb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ChatFileDetailDependency_Factory f433296a = null;

        static {
            f433296a = new ChatFileDetailDependency_Factory();
        }
    }

    public ChatFileDetailDependency_Factory() {
    }

    public static xtb.a newInstance() {
        return new xtb.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static ChatFileDetailDependency_Factory create() {
        return a.f433296a;
    }

    @Override // javax.inject.Provider
    public xtb.a get() {
        return newInstance();
    }
}
