package com.bytedance.caijing.sdk.biz.pay;

import android.content.Context;
import com.android.ttcjpaysdk.base.cloudunionpay.CJCloudUnionPayManager;
import com.android.ttcjpaysdk.base.cloudunionpay.CJCloudUnionPayUtils;
import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInCloudUnionPayService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/PlugInCloudUnionPayServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInCloudUnionPayService;", "()V", "currentSession", "", "isInstalled", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "notifyResult", "", "paySession", "result", "", "reportEvent", "eventName", "eventParams", "cjpay-se-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlugInCloudUnionPayServiceImpl implements PlugInCloudUnionPayService {
    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInCloudUnionPayService
    public Object currentSession() {
        return CJCloudUnionPayManager.INSTANCE.currentSession();
    }

    public PlugInCloudUnionPayServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInCloudUnionPayService
    public boolean isInstalled(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return CJCloudUnionPayUtils.INSTANCE.isInstalled(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInCloudUnionPayService
    public void notifyResult(Object r100, String r101) {
        if ((r100 instanceof CJPaySession) == false) goto L5;
        CJPaySession r102 = (CJPaySession) r100;
    L6:
        if (r102 == null) goto L9;
        r102.notifyResult(r101);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInCloudUnionPayService
    public void reportEvent(Object r100, String r101, String r102) {
        if ((r100 instanceof CJPaySession) == false) goto L5;
        CJPaySession r103 = (CJPaySession) r100;
    L6:
        if (r103 == null) goto L9;
        r103.reportEvent(r101, r102);
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
