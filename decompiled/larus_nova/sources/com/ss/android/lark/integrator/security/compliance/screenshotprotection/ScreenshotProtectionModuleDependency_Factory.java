package com.ss.android.lark.integrator.security.compliance.screenshotprotection;

import dagger.internal.Factory;
import inb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class ScreenshotProtectionModuleDependency_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ScreenshotProtectionModuleDependency_Factory f428133a = null;

        static {
            f428133a = new ScreenshotProtectionModuleDependency_Factory();
        }
    }

    public ScreenshotProtectionModuleDependency_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static ScreenshotProtectionModuleDependency_Factory create() {
        return a.f428133a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
