package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class SetDeviceCommandService_Factory implements Factory<k> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SetDeviceCommandService_Factory f437687a = null;

        static {
            f437687a = new SetDeviceCommandService_Factory();
        }
    }

    public SetDeviceCommandService_Factory() {
    }

    public static k newInstance() {
        return new k();
    }

    @Override // javax.inject.Provider
    public k get() {
        return newInstance();
    }

    public static SetDeviceCommandService_Factory create() {
        return a.f437687a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
