package com.bytedance.caijing.sdk.infra.base.api.container;

import android.webkit.WebResourceResponse;
import cd4.d;
import cd4.g;
import cd4.h;
import cd4.l;
import cd4.r;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\u001e\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u000fH&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u000bH&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/container/IJsbService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Lcd4/h;", "getH5JSBridgeHelper", "Lcd4/l;", "getJsBridgeEventHelper", "Lcd4/d;", "getBdMediaFileSystem", "Lcd4/r;", "getXBridgeHelper", "", "", "Ljava/lang/Class;", "", "getExtXBridgeMethods", "Lcd4/g;", "getEventHelper", "sourceUrl", "Landroid/webkit/WebResourceResponse;", "getXPayPrefetchResWebResourceResponse", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface IJsbService extends ICJService {
    d getBdMediaFileSystem();

    g getEventHelper();

    Map<String, Class<? extends Object>> getExtXBridgeMethods();

    h getH5JSBridgeHelper();

    l getJsBridgeEventHelper();

    r getXBridgeHelper();

    WebResourceResponse getXPayPrefetchResWebResourceResponse(String r100);
}
