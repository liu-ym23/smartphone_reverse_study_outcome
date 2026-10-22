package com.bytedance.ee.android.file.picker.lib.v2.icon.impl;

import dagger.internal.Factory;
import wm4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class VideoThumbIconLoader_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final VideoThumbIconLoader_Factory f206047a = null;

        static {
            f206047a = new VideoThumbIconLoader_Factory();
        }
    }

    public VideoThumbIconLoader_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static VideoThumbIconLoader_Factory create() {
        return a.f206047a;
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }
}
