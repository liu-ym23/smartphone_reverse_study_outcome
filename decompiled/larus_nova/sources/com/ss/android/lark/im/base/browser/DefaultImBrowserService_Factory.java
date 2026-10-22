package com.ss.android.lark.im.base.browser;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class DefaultImBrowserService_Factory implements Factory<com.ss.android.lark.im.base.browser.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DefaultImBrowserService_Factory f425881a = null;

        static {
            f425881a = new DefaultImBrowserService_Factory();
        }
    }

    public DefaultImBrowserService_Factory() {
    }

    public static com.ss.android.lark.im.base.browser.a newInstance() {
        return new com.ss.android.lark.im.base.browser.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.im.base.browser.a get() {
        return newInstance();
    }

    public static DefaultImBrowserService_Factory create() {
        return a.f425881a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
