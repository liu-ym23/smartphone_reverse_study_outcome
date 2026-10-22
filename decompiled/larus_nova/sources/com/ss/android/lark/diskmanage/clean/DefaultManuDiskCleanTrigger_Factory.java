package com.ss.android.lark.diskmanage.clean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes35.dex */
public final class DefaultManuDiskCleanTrigger_Factory implements Factory<ebb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultManuDiskCleanTrigger_Factory f420451a = null;

        static {
            f420451a = new DefaultManuDiskCleanTrigger_Factory();
        }
    }

    public DefaultManuDiskCleanTrigger_Factory() {
    }

    public static ebb.a newInstance() {
        return new ebb.a();
    }

    @Override // javax.inject.Provider
    public ebb.a get() {
        return newInstance();
    }

    public static DefaultManuDiskCleanTrigger_Factory create() {
        return a.f420451a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
