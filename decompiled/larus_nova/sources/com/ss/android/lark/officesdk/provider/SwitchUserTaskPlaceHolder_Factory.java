package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.h;

/* JADX INFO: loaded from: classes37.dex */
public final class SwitchUserTaskPlaceHolder_Factory implements Factory<h> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SwitchUserTaskPlaceHolder_Factory f437152a = null;

        static {
            f437152a = new SwitchUserTaskPlaceHolder_Factory();
        }
    }

    public SwitchUserTaskPlaceHolder_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static SwitchUserTaskPlaceHolder_Factory create() {
        return a.f437152a;
    }

    @Override // javax.inject.Provider
    public h get() {
        return newInstance();
    }
}
