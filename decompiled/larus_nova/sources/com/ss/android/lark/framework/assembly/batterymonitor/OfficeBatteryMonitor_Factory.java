package com.ss.android.lark.framework.assembly.batterymonitor;

import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import dagger.internal.Factory;
import djb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeBatteryMonitor_Factory implements Factory<a> {
    private final Provider<IAppStateSyncService> appStateSyncServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.appStateSyncServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeBatteryMonitor_Factory(Provider<IAppStateSyncService> r100) {
        this.appStateSyncServiceProvider = r100;
    }

    public static OfficeBatteryMonitor_Factory create(Provider<IAppStateSyncService> r100) {
        return new OfficeBatteryMonitor_Factory(r100);
    }

    public static a newInstance(IAppStateSyncService r100) {
        return new a(r100);
    }
}
