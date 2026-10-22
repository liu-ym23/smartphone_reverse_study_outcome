package com.bytedance.ee.bear.basesdk.config.directionprovider;

import android.os.Bundle;
import com.bytedance.ee.bear.route.RouteBean;
import onc.m;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements a.InterfaceC2978a {
    public c() {
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final /* synthetic */ boolean b(RouteBean r100) {
        return false;
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final /* synthetic */ boolean c() {
        return true;
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final com.suite.lark.component.navroute.api.c<Bundle> a(RouteBean r100) {
        return new m(new Bundle());
    }
}
