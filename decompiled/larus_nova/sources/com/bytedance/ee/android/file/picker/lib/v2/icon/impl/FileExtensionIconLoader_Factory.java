package com.bytedance.ee.android.file.picker.lib.v2.icon.impl;

import dagger.internal.Factory;
import wm4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class FileExtensionIconLoader_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FileExtensionIconLoader_Factory f206046a = null;

        static {
            f206046a = new FileExtensionIconLoader_Factory();
        }
    }

    public FileExtensionIconLoader_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static FileExtensionIconLoader_Factory create() {
        return a.f206046a;
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }
}
