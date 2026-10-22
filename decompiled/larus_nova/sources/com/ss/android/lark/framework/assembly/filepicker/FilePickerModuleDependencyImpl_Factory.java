package com.ss.android.lark.framework.assembly.filepicker;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class FilePickerModuleDependencyImpl_Factory implements Factory<fjb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FilePickerModuleDependencyImpl_Factory f425647a = null;

        static {
            f425647a = new FilePickerModuleDependencyImpl_Factory();
        }
    }

    public FilePickerModuleDependencyImpl_Factory() {
    }

    public static fjb.a newInstance() {
        return new fjb.a();
    }

    @Override // javax.inject.Provider
    public fjb.a get() {
        return newInstance();
    }

    public static FilePickerModuleDependencyImpl_Factory create() {
        return a.f425647a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
