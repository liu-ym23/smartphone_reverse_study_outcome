package com.bytedance.caijing.sdk.infra.base.api.hybridkit;

import android.app.Activity;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.util.Map;
import kotlin.Metadata;
import xd4.b;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\t\u001a\u00020\bH&J.\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\t\u001a\u00020\bH&J.\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\t\u001a\u00020\bH&J.\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/hybridkit/HybridKitPluginService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/app/Activity;", "activity", "", "", "", "params", "Lxd4/b;", "callback", "", "onCloseCallNative", "onDeviceInfoCallNative", "onOpenCallNative", "onRequestCallNative", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface HybridKitPluginService extends ICJService {
    void onCloseCallNative(Activity r100, Map<String, ? extends Object> r101, b r102);

    void onDeviceInfoCallNative(Activity r100, Map<String, ? extends Object> r101, b r102);

    void onOpenCallNative(Activity r100, Map<String, ? extends Object> r101, b r102);

    void onRequestCallNative(Activity r100, Map<String, ? extends Object> r101, b r102);
}
