package com.ss.android.lark.appsetting.api.v2.interfaces;

import awa.e;
import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class NoopAppConfigExternalSource_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopAppConfigExternalSource_Factory f408957a = null;

        static {
            f408957a = new NoopAppConfigExternalSource_Factory();
        }
    }

    public NoopAppConfigExternalSource_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }

    public static NoopAppConfigExternalSource_Factory create() {
        return a.f408957a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
