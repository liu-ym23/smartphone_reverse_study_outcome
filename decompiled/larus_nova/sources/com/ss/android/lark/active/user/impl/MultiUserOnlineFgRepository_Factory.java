package com.ss.android.lark.active.user.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class MultiUserOnlineFgRepository_Factory implements Factory<MultiUserOnlineFgRepository> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MultiUserOnlineFgRepository_Factory f408620a = null;

        static {
            f408620a = new MultiUserOnlineFgRepository_Factory();
        }
    }

    public MultiUserOnlineFgRepository_Factory() {
    }

    public static MultiUserOnlineFgRepository newInstance() {
        return new MultiUserOnlineFgRepository();
    }

    @Override // javax.inject.Provider
    public MultiUserOnlineFgRepository get() {
        return newInstance();
    }

    public static MultiUserOnlineFgRepository_Factory create() {
        return a.f408620a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
