package com.ss.android.lark.officesdk.provider;

import dagger.internal.Factory;
import nwb.i;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateDeviceIdTaskPlaceHolder_Factory implements Factory<i> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UpdateDeviceIdTaskPlaceHolder_Factory f437153a = null;

        static {
            f437153a = new UpdateDeviceIdTaskPlaceHolder_Factory();
        }
    }

    public UpdateDeviceIdTaskPlaceHolder_Factory() {
    }

    public static i newInstance() {
        return new i();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static UpdateDeviceIdTaskPlaceHolder_Factory create() {
        return a.f437153a;
    }

    @Override // javax.inject.Provider
    public i get() {
        return newInstance();
    }
}
