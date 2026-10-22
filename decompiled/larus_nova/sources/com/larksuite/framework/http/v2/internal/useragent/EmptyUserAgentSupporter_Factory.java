package com.larksuite.framework.http.v2.internal.useragent;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes24.dex */
public final class EmptyUserAgentSupporter_Factory implements Factory<e28.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EmptyUserAgentSupporter_Factory f285667a = null;

        static {
            f285667a = new EmptyUserAgentSupporter_Factory();
        }
    }

    public EmptyUserAgentSupporter_Factory() {
    }

    public static e28.a newInstance() {
        return new e28.a();
    }

    @Override // javax.inject.Provider
    public e28.a get() {
        return newInstance();
    }

    public static EmptyUserAgentSupporter_Factory create() {
        return a.f285667a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
