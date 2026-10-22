package com.ss.android.lark.framework.assembly.imageloader.diskclean;

import dagger.internal.Factory;
import gjb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageManuDiskCleanTrigger_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImageManuDiskCleanTrigger_Factory f425652a = null;

        static {
            f425652a = new ImageManuDiskCleanTrigger_Factory();
        }
    }

    public ImageManuDiskCleanTrigger_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static ImageManuDiskCleanTrigger_Factory create() {
        return a.f425652a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
