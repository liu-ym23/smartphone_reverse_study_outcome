package com.bytedance.lark.sdk.refactor;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes20.dex */
public final class DefaultRustSDKDefinition_Factory implements Factory<DefaultRustSDKDefinition> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultRustSDKDefinition_Factory f254205a = null;

        static {
            f254205a = new DefaultRustSDKDefinition_Factory();
        }
    }

    public DefaultRustSDKDefinition_Factory() {
    }

    public static DefaultRustSDKDefinition newInstance() {
        return new DefaultRustSDKDefinition();
    }

    @Override // javax.inject.Provider
    public DefaultRustSDKDefinition get() {
        return newInstance();
    }

    public static DefaultRustSDKDefinition_Factory create() {
        return a.f254205a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
