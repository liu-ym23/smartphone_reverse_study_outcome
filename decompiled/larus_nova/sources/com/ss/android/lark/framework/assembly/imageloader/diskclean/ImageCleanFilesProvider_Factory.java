package com.ss.android.lark.framework.assembly.imageloader.diskclean;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class ImageCleanFilesProvider_Factory implements Factory<gjb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ImageCleanFilesProvider_Factory f425651a = null;

        static {
            f425651a = new ImageCleanFilesProvider_Factory();
        }
    }

    public ImageCleanFilesProvider_Factory() {
    }

    public static gjb.a newInstance() {
        return new gjb.a();
    }

    @Override // javax.inject.Provider
    public gjb.a get() {
        return newInstance();
    }

    public static ImageCleanFilesProvider_Factory create() {
        return a.f425651a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
