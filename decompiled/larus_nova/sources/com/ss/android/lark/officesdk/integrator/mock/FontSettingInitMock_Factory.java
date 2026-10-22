package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.m;

/* JADX INFO: loaded from: classes37.dex */
public final class FontSettingInitMock_Factory implements Factory<m> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FontSettingInitMock_Factory f433316a = null;

        static {
            f433316a = new FontSettingInitMock_Factory();
        }
    }

    public FontSettingInitMock_Factory() {
    }

    public static m newInstance() {
        return new m();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static FontSettingInitMock_Factory create() {
        return a.f433316a;
    }

    @Override // javax.inject.Provider
    public m get() {
        return newInstance();
    }
}
