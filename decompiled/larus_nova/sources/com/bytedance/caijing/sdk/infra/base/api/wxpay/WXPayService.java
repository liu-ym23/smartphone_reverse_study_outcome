package com.bytedance.caijing.sdk.infra.base.api.wxpay;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J&\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0005H&J\u001c\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J&\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\nH&JV\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\nH&¨\u0006\u001f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/wxpay/WXPayService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "getWXAppSupportAPI", "", "api", "", "getWxApi", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "wxAppId", "", "independentAppSign", "", "preEntrustWebId", "isWXAppInstalled", "", "isWXUnInstalled", "receiveMiniAppResp", "resp", "registerApp", "sendMiniAppReq", "userName", "path", "sendReq", "appId", "partnerId", "prepayId", "nonceStr", "timestamp", "packageValue", "sign", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WXPayService extends ICJService {
    int getWXAppSupportAPI(Object r100);

    Object getWxApi(Context r100, String r101);

    void independentAppSign(Context r100, String r101, String r102);

    boolean isWXAppInstalled(Object r100);

    boolean isWXUnInstalled(Context r100, String r101);

    void receiveMiniAppResp(Object r100);

    boolean registerApp(Object r100, String r101);

    boolean sendMiniAppReq(Object r100, String r101, String r102);

    boolean sendReq(Object r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107);
}
