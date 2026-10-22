package com.bytedance.ee.bear.lark.notification.docfeed;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class DocFeedOnlineNotificationWrapperImpl_Factory implements Factory<yb5.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DocFeedOnlineNotificationWrapperImpl_Factory f227434a = null;

        static {
            f227434a = new DocFeedOnlineNotificationWrapperImpl_Factory();
        }
    }

    public DocFeedOnlineNotificationWrapperImpl_Factory() {
    }

    public static yb5.a newInstance() {
        return new yb5.a();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static DocFeedOnlineNotificationWrapperImpl_Factory create() {
        return a.f227434a;
    }

    @Override // javax.inject.Provider
    public yb5.a get() {
        return newInstance();
    }
}
