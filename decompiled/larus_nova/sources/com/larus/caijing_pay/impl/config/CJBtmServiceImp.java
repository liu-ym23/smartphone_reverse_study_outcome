package com.larus.caijing_pay.impl.config;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService;
import com.bytedance.caijing.sdk.infra.base.api.btm.CJPageFinder;
import com.larus.btm.api.IBTMService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lv8.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001f\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\rH\u0016J\"\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020#2\u0006\u0010\"\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rH\u0016J&\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00112\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fH\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0011H\u0002¨\u00061"}, d2 = {"Lcom/larus/caijing_pay/impl/config/CJBtmServiceImp;", "Lcom/bytedance/caijing/sdk/infra/base/api/btm/CJBtmService;", "<init>", "()V", "btmViewHide", "", "view", "Landroid/view/View;", "forward", "", "btmViewShow", "createFullyReportParams", "", "", "", "btm", "pageFinder", "Lcom/bytedance/caijing/sdk/infra/base/api/btm/CJPageFinder;", "createJumpSourceBtmToken", "bcm", "Lorg/json/JSONObject;", "createReportParams", "dismissBtmDialog", "dialog", "Landroid/app/Dialog;", "(Landroid/app/Dialog;Ljava/lang/Boolean;)V", "hideBtmDialog", "initBtmSdk", "registerBtmDialog", "registerBtmPage", "sourceBtmToken", "registerBtmPageOnCreate", "page", "Landroid/app/Activity;", "pageBtm", "Landroidx/fragment/app/Fragment;", "registerBtmView", "setBcmPageEventParams", "finder", "params", "setInitInActivity", "activity", "showBtmDialog", "unregisterBtmDialog", "btmService", "Lcom/larus/btm/api/IBTMService;", "createPageFinder", "Lcom/larus/btm/api/BtmPageFinder;", "cjPageFinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJBtmServiceImp implements CJBtmService {
    public CJBtmServiceImp() {
    }

    private final IBTMService btmService() {
        return (IBTMService) ServiceManager.get().getService(IBTMService.class);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void initBtmSdk() {
        IBTMService r100 = btmService();
        if (r100 == null) goto L6;
        r100.initBtmSdk();
        return;
    }

    private final a createPageFinder(CJPageFinder r100) {
        return new a(r100.f202206a, r100.f202207b, r100.f202208c, r100.f202209d);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void btmViewHide(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IBTMService r101 = btmService();
        if (r101 == null) goto L6;
        r101.btmViewHide(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void btmViewShow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IBTMService r101 = btmService();
        if (r101 == null) goto L6;
        r101.btmViewShow(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void setInitInActivity(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        IBTMService r101 = btmService();
        if (r101 == null) goto L6;
        r101.setInitInActivity(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void showBtmDialog(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        IBTMService r101 = btmService();
        if (r101 == null) goto L6;
        r101.showBtmDialog(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void unregisterBtmDialog(Dialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        IBTMService r101 = btmService();
        if (r101 == null) goto L6;
        r101.unregisterBtmDialog(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void btmViewHide(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        IBTMService r102 = btmService();
        if (r102 == null) goto L6;
        r102.btmViewHide(r100, r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public Map<String, Object> createFullyReportParams(String r100, CJPageFinder r101) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        IBTMService r102 = btmService();
        if (r102 == null) goto L5;
        Map<String, Object> r103 = r102.g(r100, createPageFinder(r101));
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        return MapsKt.emptyMap();
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public Map<String, Object> createReportParams(String r100, CJPageFinder r101) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        IBTMService r102 = btmService();
        if (r102 == null) goto L5;
        Map<String, Object> r103 = r102.b(r100, createPageFinder(r101));
    L6:
        if (r103 == null) goto L8;
        return r103;
    L8:
        return MapsKt.emptyMap();
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void dismissBtmDialog(Dialog r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        IBTMService r102 = btmService();
        if (r102 == null) goto L6;
        r102.dismissBtmDialog(r100, r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void hideBtmDialog(Dialog r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        IBTMService r102 = btmService();
        if (r102 == null) goto L6;
        r102.hideBtmDialog(r100, r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void registerBtmDialog(Dialog r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r101, "btm");
        IBTMService r102 = btmService();
        if (r102 == null) goto L6;
        r102.registerBtmDialog(r100, r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void registerBtmView(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        IBTMService r102 = btmService();
        if (r102 == null) goto L6;
        r102.registerBtmView(r100, r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void setBcmPageEventParams(CJPageFinder r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "finder");
        Intrinsics.checkNotNullParameter(r101, "params");
        IBTMService r102 = btmService();
        if (r102 == null) goto L6;
        r102.l(createPageFinder(r100), r101);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public String createJumpSourceBtmToken(String r100, CJPageFinder r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "btm");
        Intrinsics.checkNotNullParameter(r101, "pageFinder");
        IBTMService r103 = btmService();
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.e(r100, createPageFinder(r101), r102);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public boolean registerBtmPage(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "btm");
        IBTMService r103 = btmService();
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.registerBtmPage(r100, r101, r102);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void registerBtmPageOnCreate(Activity r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "pageBtm");
        IBTMService r103 = btmService();
        if (r103 == null) goto L6;
        r103.registerBtmPageOnCreate(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.btm.CJBtmService
    public void registerBtmPageOnCreate(Fragment r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "pageBtm");
        IBTMService r103 = btmService();
        if (r103 == null) goto L6;
        r103.registerBtmPageOnCreate(r100, r101, r102);
        return;
    }
}
