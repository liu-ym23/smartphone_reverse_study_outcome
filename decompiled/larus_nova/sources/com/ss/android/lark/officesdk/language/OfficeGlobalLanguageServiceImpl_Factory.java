package com.ss.android.lark.officesdk.language;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeGlobalLanguageServiceImpl_Factory implements Factory<OfficeGlobalLanguageServiceImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeGlobalLanguageServiceImpl_Factory f433399a = null;

        static {
            f433399a = new OfficeGlobalLanguageServiceImpl_Factory();
        }
    }

    public OfficeGlobalLanguageServiceImpl_Factory() {
    }

    public static OfficeGlobalLanguageServiceImpl newInstance() {
        return new OfficeGlobalLanguageServiceImpl();
    }

    @Override // javax.inject.Provider
    public OfficeGlobalLanguageServiceImpl get() {
        return newInstance();
    }

    public static OfficeGlobalLanguageServiceImpl_Factory create() {
        return a.f433399a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
