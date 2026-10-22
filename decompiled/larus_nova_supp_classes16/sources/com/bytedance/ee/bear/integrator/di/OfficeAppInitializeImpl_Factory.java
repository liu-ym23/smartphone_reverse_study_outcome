package com.bytedance.ee.bear.integrator.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeAppInitializeImpl_Factory implements Factory<OfficeAppInitializeImpl> {

    public static final class a {
        public static final OfficeAppInitializeImpl_Factory a = null;

        static {
            a = new OfficeAppInitializeImpl_Factory();
        }
    }

    public OfficeAppInitializeImpl_Factory() {
    }

    public static OfficeAppInitializeImpl newInstance() {
        return new OfficeAppInitializeImpl();
    }

    public OfficeAppInitializeImpl get() {
        return newInstance();
    }

    public static OfficeAppInitializeImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m409get() {
        return get();
    }
}
