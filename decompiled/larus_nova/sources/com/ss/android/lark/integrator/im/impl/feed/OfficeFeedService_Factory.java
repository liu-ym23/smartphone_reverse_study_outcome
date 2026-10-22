package com.ss.android.lark.integrator.im.impl.feed;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeFeedService_Factory implements Factory<com.ss.android.lark.integrator.im.impl.feed.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeFeedService_Factory f427978a = null;

        static {
            f427978a = new OfficeFeedService_Factory();
        }
    }

    public OfficeFeedService_Factory() {
    }

    public static com.ss.android.lark.integrator.im.impl.feed.a newInstance() {
        return new com.ss.android.lark.integrator.im.impl.feed.a();
    }

    @Override // javax.inject.Provider
    public com.ss.android.lark.integrator.im.impl.feed.a get() {
        return newInstance();
    }

    public static OfficeFeedService_Factory create() {
        return a.f427978a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
