package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class VideoConferenceDependencyImpl_Factory implements Factory<u> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final VideoConferenceDependencyImpl_Factory f433294a = null;

        static {
            f433294a = new VideoConferenceDependencyImpl_Factory();
        }
    }

    public VideoConferenceDependencyImpl_Factory() {
    }

    public static u newInstance() {
        return new u();
    }

    @Override // javax.inject.Provider
    public u get() {
        return newInstance();
    }

    public static VideoConferenceDependencyImpl_Factory create() {
        return a.f433294a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
