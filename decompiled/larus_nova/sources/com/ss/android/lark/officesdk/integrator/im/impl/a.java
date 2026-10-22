package com.ss.android.lark.officesdk.integrator.im.impl;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_billingtips.IBillingTipsDependency;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a implements IBillingTipsDependency {
    @Inject
    public a() {
    }

    @Override // com.suite.lark.platform.component.widget_biz_billingtips.IBillingTipsDependency
    public final String adaptHelpCenterUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return r100;
    }

    @Override // com.suite.lark.platform.component.widget_biz_billingtips.IBillingTipsDependency
    public final void openUrl(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Log.i("OfficeSdkBillingTipsDependency", "openUrl ignored, url=" + r101);
        com.ss.android.lark.router.c.b(r100, r101);
    }
}
