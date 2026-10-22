package com.bytedance.caijing.sdk.biz.googleiap.api;

import android.app.Activity;
import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import sc4.a;
import sc4.b;
import sc4.c;
import sc4.d;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u000eH&J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0013H&J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/googleiap/api/CJIAPService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Lsc4/a;", "cjContext", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Ltc4/a;", "listener", "", "initIAP", "Lsc4/d;", "params", "queryPurchases", "Lsc4/c;", "Ltc4/c;", "queryProductDetails", "Landroid/app/Activity;", "activity", "Lsc4/b;", "Ltc4/b;", "pay", "", "feature", "", "isFeatureSupported", "cj_google_iap_api_release"}, k = 1, mv = {1, 7, 1})
public interface CJIAPService extends ICJService {
    void initIAP(a r100, Context r101, tc4.a r102);

    boolean isFeatureSupported(a r100, String r101);

    void pay(a r100, Activity r101, b r102, tc4.b r103);

    void queryProductDetails(a r100, c r101, tc4.c r102);

    void queryPurchases(a r100, d r101);
}
