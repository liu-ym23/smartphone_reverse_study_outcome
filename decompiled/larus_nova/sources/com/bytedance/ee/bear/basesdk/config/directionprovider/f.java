package com.bytedance.ee.bear.basesdk.config.directionprovider;

import android.os.Bundle;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.route.RouteBean;
import onc.w;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements a.InterfaceC2978a {
    public f() {
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final boolean c() {
        return ((Boolean) ForsetiHelper.f216442d.getValue()).booleanValue();
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final com.suite.lark.component.navroute.api.c<Bundle> a(RouteBean r100) {
        Bundle r101 = r100.f236649n;
        if (r101 != null) goto L6;
        r101 = new Bundle();
    L6:
        return new w(r101);
    }

    @Override // com.bytedance.ee.bear.basesdk.config.directionprovider.a.InterfaceC2978a
    public final boolean b(RouteBean r100) {
        return ((Boolean) ForsetiHelper.f216442d.getValue()).booleanValue();
    }
}
