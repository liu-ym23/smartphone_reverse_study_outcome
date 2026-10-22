package com.bytedance.caijing.sdk.infra.base.api.plugin;

import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\bH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/plugin/PlugInWXPayService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "currentMiniAppSession", "", "currentSession", "getCurrentSessionApi", "getWxSession", "prepayId", "", "isFromCJPay", "", "isMiniAppFromCJ", "isWXMiniAppPaySession", "paySession", "isWXPaySession", "notifyResult", "", "errCode", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PlugInWXPayService extends ICJService {
    Object currentMiniAppSession();

    Object currentSession();

    Object getCurrentSessionApi();

    Object getWxSession(String r100);

    boolean isFromCJPay();

    boolean isMiniAppFromCJ();

    boolean isWXMiniAppPaySession(Object r100);

    boolean isWXPaySession(Object r100);

    void notifyResult(Object r100, String r101);
}
