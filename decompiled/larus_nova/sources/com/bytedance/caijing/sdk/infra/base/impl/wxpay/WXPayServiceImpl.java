package com.bytedance.caijing.sdk.infra.base.impl.wxpay;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.caijing.sdk.infra.base.api.plugin.PlugInWXPayService;
import com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0011\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u001c\u0010\u0014\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u0015\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016JV\u0010\u0018\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/wxpay/WXPayServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/wxpay/WXPayService;", "()V", "getWXAppSupportAPI", "", "api", "", "getWxApi", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "wxAppId", "", "independentAppSign", "", "preEntrustWebId", "isWXAppInstalled", "", "isWXUnInstalled", "receiveMiniAppResp", "resp", "registerApp", "sendMiniAppReq", "userName", "path", "sendReq", "appId", "partnerId", "prepayId", "nonceStr", "timestamp", "packageValue", "sign", "cj-host-service-impl-wxpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WXPayServiceImpl implements WXPayService {
    public WXPayServiceImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public int getWXAppSupportAPI(Object r100) {
        if ((r100 instanceof IWXAPI) == false) goto L5;
        IWXAPI r101 = (IWXAPI) r100;
    L6:
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.getWXAppSupportAPI();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public boolean isWXAppInstalled(Object r100) {
        if ((r100 instanceof IWXAPI) == false) goto L5;
        IWXAPI r101 = (IWXAPI) r100;
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.isWXAppInstalled();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public void receiveMiniAppResp(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "resp");
        a.f554342a.getClass();
        PlugInWXPayService r101 = (PlugInWXPayService) a.a(PlugInWXPayService.class);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isMiniAppFromCJ() == true) goto L8;
        return;
    L8:
        if ((r100 instanceof WXLaunchMiniProgram.Resp) == false) goto L15;
        WXLaunchMiniProgram.Resp r102 = (WXLaunchMiniProgram.Resp) r100;
        if (r102.getType() != 19) goto L17;
        r101.notifyResult(r101.currentMiniAppSession(), String.valueOf(r102.errCode));
        return;
    L17:
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public Object getWxApi(Context r100, String r101) {
        Context r102 = null;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        if (r100 == null) goto L7;
        r102 = r100.getApplicationContext();
    L7:
        return WXAPIFactory.createWXAPI(r102, r101, true);
    L8:
        return null;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public boolean isWXUnInstalled(Context r100, String r101) {
        if (r100 == null) goto L4;
        Context r102 = r100.getApplicationContext();
    L5:
        IWXAPI r103 = WXAPIFactory.createWXAPI(r102, r101, true);
        if (r103 != null) goto L8;
        return true;
    L8:
        if (r103.isWXAppInstalled() == false) goto L13;
        return false;
    L13:
        return true;
    L4:
        r102 = null;
        goto L5
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public boolean registerApp(Object r100, String r101) {
        if ((r100 instanceof IWXAPI) == false) goto L5;
        IWXAPI r102 = (IWXAPI) r100;
    L6:
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.registerApp(r101);
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public void independentAppSign(Context r100, String r101, String r102) {
        WXOpenBusinessWebview.Req r103 = new WXOpenBusinessWebview.Req();
        r103.businessType = 12;
        HashMap<String, String> r104 = new HashMap();
        Intrinsics.checkNotNull(r101);
        r104.put(DyPayConstant.K_PAY_INFO_PARAM_PRE_ENTRUSTWEB_ID, r101);
        r103.queryInfo = r104;
        Object r105 = getWxApi(r100, r102);
        if ((r105 instanceof IWXAPI) == false) goto L5;
        IWXAPI r106 = (IWXAPI) r105;
    L6:
        if (r106 == null) goto L9;
        r106.sendReq(r103);
        return;
    L9:
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public boolean sendMiniAppReq(Object r100, String r101, String r102) {
        WXLaunchMiniProgram.Req r103 = new WXLaunchMiniProgram.Req();
        r103.userName = r101;
        r103.path = r102;
        r103.miniprogramType = 0;
        if ((r100 instanceof IWXAPI) == false) goto L5;
        IWXAPI r104 = (IWXAPI) r100;
    L6:
        if (r104 != null) goto L8;
        return false;
    L8:
        return r104.sendReq(r103);
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.wxpay.WXPayService
    public boolean sendReq(Object r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r105, "timestamp");
        PayReq r108 = new PayReq();
        r108.appId = r101;
        r108.partnerId = r102;
        r108.prepayId = r103;
        r108.nonceStr = r104;
        r108.timeStamp = r105;
        r108.packageValue = r106;
        r108.sign = r107;
        if ((r100 instanceof IWXAPI) == false) goto L5;
        IWXAPI r109 = (IWXAPI) r100;
    L6:
        if (r109 != null) goto L10;
        return false;
    L10:
        return r109.sendReq(r108);
    L5:
        r109 = null;
        goto L6
    }
}
