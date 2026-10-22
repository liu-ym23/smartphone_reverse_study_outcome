package com.suite.lark.component.navroute.api;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f460256a;

    @Override // com.suite.lark.component.navroute.api.d
    public final b<?> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return this.f460256a.a(r100);
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final List<b<?>> b() {
        return this.f460256a.b();
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getRoute() {
        return this.f460256a.getRoute();
    }

    @Override // com.suite.lark.component.navroute.api.d
    public final String getStart() {
        return this.f460256a.getStart();
    }

    public e() {
        this.f460256a = pnc.d.f530007a;
    }
}
