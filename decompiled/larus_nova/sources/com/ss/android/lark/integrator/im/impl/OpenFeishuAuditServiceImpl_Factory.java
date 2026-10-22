package com.ss.android.lark.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OpenFeishuAuditServiceImpl_Factory implements Factory<h> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenFeishuAuditServiceImpl_Factory f427969a = null;

        static {
            f427969a = new OpenFeishuAuditServiceImpl_Factory();
        }
    }

    public OpenFeishuAuditServiceImpl_Factory() {
    }

    public static h newInstance() {
        return new h();
    }

    @Override // javax.inject.Provider
    public h get() {
        return newInstance();
    }

    public static OpenFeishuAuditServiceImpl_Factory create() {
        return a.f427969a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
