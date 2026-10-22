package com.ss.android.lark.featuregatingv2.interfaces;

import dagger.internal.Factory;
import jdb.h;

/* JADX INFO: loaded from: classes35.dex */
public final class NoopGlobalFeatureGatingService_Factory implements Factory<h> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopGlobalFeatureGatingService_Factory f420734a = null;

        static {
            f420734a = new NoopGlobalFeatureGatingService_Factory();
        }
    }

    public NoopGlobalFeatureGatingService_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static NoopGlobalFeatureGatingService_Factory create() {
        return a.f420734a;
    }

    @Override // javax.inject.Provider
    public h get() {
        return newInstance();
    }
}
