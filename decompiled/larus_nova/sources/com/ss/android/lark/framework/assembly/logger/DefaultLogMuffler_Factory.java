package com.ss.android.lark.framework.assembly.logger;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class DefaultLogMuffler_Factory implements Factory<com.ss.android.lark.framework.assembly.logger.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultLogMuffler_Factory f425655a = null;

        static {
            f425655a = new DefaultLogMuffler_Factory();
        }
    }

    public DefaultLogMuffler_Factory() {
    }

    public static com.ss.android.lark.framework.assembly.logger.a newInstance() {
        return new com.ss.android.lark.framework.assembly.logger.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.framework.assembly.logger.a get() {
        return newInstance();
    }

    public static DefaultLogMuffler_Factory create() {
        return a.f425655a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
