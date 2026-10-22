package com.bytedance.caijing.sdk.biz.pay;

import com.android.ttcjpaysdk.base.paymentbasis.CJPaySession;
import com.android.ttcjpaysdk.base.paymentbasis.constants.WXPayType;
import com.android.ttcjpaysdk.base.wxpay.CJWXPayManager;
import com.android.ttcjpaysdk.base.wxpay.CJWXPaySession;
import com.android.ttcjpaysdk.base.wxpay.miniapp.CJWXMiniAppPayManager;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/caijing/sdk/biz/pay/PlugInWXPayServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInWXPayService;", "()V", "currentMiniAppSession", "", "currentSession", "getCurrentSessionApi", "getWxSession", "prepayId", "", "isFromCJPay", "", "isMiniAppFromCJ", "isWXMiniAppPaySession", "paySession", "isWXPaySession", "notifyResult", "", "errCode", "cjpay-se-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PlugInWXPayServiceImpl implements PlugInWXPayService {
    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public Object currentMiniAppSession() {
        return CJWXMiniAppPayManager.Companion.inst().currentSession();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public boolean isMiniAppFromCJ() {
        if (CJWXMiniAppPayManager.Companion.inst().currentSession() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public Object currentSession() {
        return CJWXPayManager.inst().currentSession();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public Object getCurrentSessionApi() {
        CJPaySession r100 = CJWXPayManager.inst().currentSession();
        if ((r100 instanceof CJWXPaySession) == true) goto L5;
        return null;
    L5:
        return ((CJWXPaySession) r100).getApi();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public boolean isFromCJPay() {
        if (CJWXPayManager.inst().currentSession() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public PlugInWXPayServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public Object getWxSession(String r100) {
        return CJWXPayManager.inst().getWxSession(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public boolean isWXMiniAppPaySession(Object r100) {
        if ((r100 instanceof CJWXPaySession) == true) goto L5;
        return false;
    L5:
        return ((CJWXPaySession) r100).getSessionType().equals(WXPayType.MINIAPP.getValue());
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
    public boolean isWXPaySession(Object r100) {
        if ((r100 instanceof CJWXPaySession) == true) goto L5;
        return false;
    L5:
        return ((CJWXPaySession) r100).getSessionType().equals(WXPayType.APP.getValue());
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService
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
}
