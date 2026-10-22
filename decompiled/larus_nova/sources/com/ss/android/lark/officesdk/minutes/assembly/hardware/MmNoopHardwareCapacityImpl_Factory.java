package com.ss.android.lark.officesdk.minutes.assembly.hardware;

import dagger.internal.Factory;
import vub.b;

/* JADX INFO: loaded from: classes37.dex */
public final class MmNoopHardwareCapacityImpl_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MmNoopHardwareCapacityImpl_Factory f433584a = null;

        static {
            f433584a = new MmNoopHardwareCapacityImpl_Factory();
        }
    }

    public MmNoopHardwareCapacityImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static MmNoopHardwareCapacityImpl_Factory create() {
        return a.f433584a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
