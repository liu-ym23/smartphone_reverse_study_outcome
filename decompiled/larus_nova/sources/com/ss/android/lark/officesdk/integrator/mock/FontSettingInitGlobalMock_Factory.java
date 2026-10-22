package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.l;

/* JADX INFO: loaded from: classes37.dex */
public final class FontSettingInitGlobalMock_Factory implements Factory<l> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FontSettingInitGlobalMock_Factory f433315a = null;

        static {
            f433315a = new FontSettingInitGlobalMock_Factory();
        }
    }

    public FontSettingInitGlobalMock_Factory() {
    }

    public static l newInstance() {
        return new l();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static FontSettingInitGlobalMock_Factory create() {
        return a.f433315a;
    }

    @Override // javax.inject.Provider
    public l get() {
        return newInstance();
    }
}
