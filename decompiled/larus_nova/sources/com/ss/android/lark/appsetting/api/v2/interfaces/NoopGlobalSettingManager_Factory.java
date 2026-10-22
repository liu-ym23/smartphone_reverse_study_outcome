package com.ss.android.lark.appsetting.api.v2.interfaces;

import awa.f;
import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class NoopGlobalSettingManager_Factory implements Factory<f> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopGlobalSettingManager_Factory f408958a = null;

        static {
            f408958a = new NoopGlobalSettingManager_Factory();
        }
    }

    public NoopGlobalSettingManager_Factory() {
    }

    public static f newInstance() {
        return new f();
    }

    @Override // javax.inject.Provider
    public f get() {
        return newInstance();
    }

    public static NoopGlobalSettingManager_Factory create() {
        return a.f408958a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
