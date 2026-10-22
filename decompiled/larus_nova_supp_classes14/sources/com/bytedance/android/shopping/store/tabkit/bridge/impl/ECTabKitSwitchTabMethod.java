package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.bridge.b;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitSwitchTabMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitSwitchTabMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitSwitchTab";
    }

    public ECTabKitSwitchTabMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r4, ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        b r0 = this.f.d;
        if (r0 != null) goto L14;
        r5.onFailed(0, "proxy is null");
        return;
    L14:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        int r6 = r4.optInt("target_tab_id", 0);     // Catch: Throwable -> L8
        r5.a(com.bytedance.commerce.base.json.b.a(new Gson().toJson(r0.f0(r6))));     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L16;
        r5.onFailed(0, r8.getMessage());
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
