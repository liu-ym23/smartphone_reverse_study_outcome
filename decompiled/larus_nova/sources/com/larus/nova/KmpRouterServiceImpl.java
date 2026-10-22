package com.larus.nova;

import android.app.Activity;
import com.bytedance.kmp.router.IRouterService;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/larus/nova/KmpRouterServiceImpl;", "Lcom/bytedance/kmp/router/IRouterService;", "<init>", "()V", "back", "", "getParams", "", "", "openRoute", "url", "openRouteWithParam", "param", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpRouterServiceImpl implements IRouterService {
    public KmpRouterServiceImpl() {
    }

    @Override // com.bytedance.kmp.router.IRouterService
    public final void Y0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Activity r101 = AppHost.f326268a.a().getCurrentActivity();
        if (r101 == null) goto L6;
        SmartRouter.buildRoute(r101, r100).d();
        return;
    }
}
