package com.ss.android.lark.dynamicconfig.service.impl;

import dagger.internal.Factory;
import jcb.b;

/* JADX INFO: loaded from: classes35.dex */
public final class DomainConfigService_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DomainConfigService_Factory f420578a = null;

        static {
            f420578a = new DomainConfigService_Factory();
        }
    }

    public DomainConfigService_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DomainConfigService_Factory create() {
        return a.f420578a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
