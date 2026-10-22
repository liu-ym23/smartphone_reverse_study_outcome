package com.suite.lark.platform.component.widget_biz_billingtips;

import android.content.Context;
import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
public final class a implements IBillingTipsDependency {
    @Override // com.suite.lark.platform.component.widget_biz_billingtips.IBillingTipsDependency
    public final String adaptHelpCenterUrl(String r100) {
        return r100;
    }

    @Inject
    public a() {
    }

    @Override // com.suite.lark.platform.component.widget_biz_billingtips.IBillingTipsDependency
    public final void openUrl(Context r100, String r101) {
        Log.i("IBillingTipsDependency", "openUrl ignored, url=" + r101);
    }
}
