package com.bytedance.ee.bear.basesdk.apisupport;

import android.app.Application;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes15.dex */
final class AppSpacekitModuleImpl implements l, NonProguard {
    private final jmb.a appSpacekitModule;

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public Application application() {
        return this.appSpacekitModule.f499714a;
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public p dependency() {
        this.appSpacekitModule.getClass();
        return new jmb.f();
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public on4.a docBaseConfig() {
        this.appSpacekitModule.getClass();
        return new jmb.c();
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public DocDynamicConfig docDynamicConfig() {
        this.appSpacekitModule.getClass();
        return jmb.d.a();
    }

    public AppSpacekitModuleImpl() {
        this.appSpacekitModule = new jmb.a();
    }
}
