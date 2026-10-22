package com.bytedance.minigame.merge.bdpplatform.service.router;

import android.app.Activity;
import android.content.Context;
import com.byted.mgl.merge.service.api.router.BdpRouterService;
import com.bytedance.bdp.serviceapi.hostimpl.router.listener.BdpScanCodeCallback;
import mb4.a;
import mb4.b;

/* JADX INFO: loaded from: classes3.dex */
public class BdpRouterServiceImpl implements BdpRouterService {
    public BdpRouterServiceImpl() {
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final void jumpToWebView(Context r100, String r101, String r102, boolean r103) {
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final void openChooseAddress(Activity r100, String r101, a r102) {
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final void openChooseAddress(Activity r100, a r101) {
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final boolean openCustomerService(Context r100, String r101) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final boolean openProfile(Activity r100, String r101, String r102, String r103) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final boolean openSchema(Activity r100, String r101, String r102) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final boolean openSchema(Context r100, String r101) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final boolean openVideoView(Activity r100, String r101) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final boolean openWebBrowser(Context r100, String r101, boolean r102) {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final boolean supportCustomerService() {
        return false;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final void openScanCode(Activity r100, BdpScanCodeCallback r101) {
        if (r101 == null) goto L5;
        r101.isSupport(false);
        return;
    }

    @Override // com.byted.mgl.merge.service.api.router.BdpRouterService
    public final void openMarket(Context r100, String r101, b r102) {
        r102.onFail();
    }
}
