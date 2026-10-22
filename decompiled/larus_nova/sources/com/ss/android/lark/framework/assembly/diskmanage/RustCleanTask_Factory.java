package com.ss.android.lark.framework.assembly.diskmanage;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class RustCleanTask_Factory implements Factory<e> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RustCleanTask_Factory f425628a = null;

        static {
            f425628a = new RustCleanTask_Factory();
        }
    }

    public RustCleanTask_Factory() {
    }

    public static e newInstance() {
        return new e();
    }

    @Override // javax.inject.Provider
    public e get() {
        return newInstance();
    }

    public static RustCleanTask_Factory create() {
        return a.f425628a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
