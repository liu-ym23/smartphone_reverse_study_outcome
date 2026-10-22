package com.ss.android.lark.applink;

import dagger.internal.Factory;
import ova.m;

/* JADX INFO: loaded from: classes34.dex */
public final class DefaultAppLinkDependency_Factory implements Factory<m> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultAppLinkDependency_Factory f408918a = null;

        static {
            f408918a = new DefaultAppLinkDependency_Factory();
        }
    }

    public DefaultAppLinkDependency_Factory() {
    }

    public static m newInstance() {
        return new m();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DefaultAppLinkDependency_Factory create() {
        return a.f408918a;
    }

    @Override // javax.inject.Provider
    public m get() {
        return newInstance();
    }
}
