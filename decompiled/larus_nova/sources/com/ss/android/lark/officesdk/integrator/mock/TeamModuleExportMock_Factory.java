package com.ss.android.lark.officesdk.integrator.mock;

import dagger.internal.Factory;
import ytb.v;

/* JADX INFO: loaded from: classes37.dex */
public final class TeamModuleExportMock_Factory implements Factory<v> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TeamModuleExportMock_Factory f433322a = null;

        static {
            f433322a = new TeamModuleExportMock_Factory();
        }
    }

    public TeamModuleExportMock_Factory() {
    }

    public static v newInstance() {
        return new v();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static TeamModuleExportMock_Factory create() {
        return a.f433322a;
    }

    @Override // javax.inject.Provider
    public v get() {
        return newInstance();
    }
}
