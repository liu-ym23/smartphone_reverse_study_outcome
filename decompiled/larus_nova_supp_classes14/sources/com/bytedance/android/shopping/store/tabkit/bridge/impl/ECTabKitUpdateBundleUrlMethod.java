package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.bridge.b;
import com.bytedance.android.shopping.store.tabkit.model.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitUpdateBundleUrlMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitUpdateBundleUrlMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitUpdateBundleUrl";
    }

    public ECTabKitUpdateBundleUrlMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r8, ECBaseBridgeMethod.a r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "iReturn");
        TabKitBridge r0 = this.f;
        b r1 = r0.d;
        if (r1 != null) goto L23;
        r9.onFailed(0, "proxy is null");
        return;
    L23:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        TabKitViewModel r2 = r0.e;     // Catch: Throwable -> L17
        int r4 = -1;
        int r5 = r8.optInt("tab_id", -1);     // Catch: Throwable -> L17
        String r6 = r8.optString("bundle_url");     // Catch: Throwable -> L17
        JSONObject r10 = r8.optJSONObject("query");     // Catch: Throwable -> L17
        if (r2.getTabById(Integer.valueOf(r5)) != null) goto L10;
        r4 = -2;
    L15:
        r1.N(r5, r6, r10);     // Catch: Throwable -> L17
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L17
        r11.put("status_code", r4);     // Catch: Throwable -> L17
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r9.a(r11);     // Catch: Throwable -> L17
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L25;
        r9.onFailed(0, r13.getMessage());
        return;
    L25:
        return;
    L10:
        if (r2.isTabAlreadyShow(Integer.valueOf(r5)) == true) goto L15;
        if (r5 != (-1)) goto L14;
        r4 = -3;
        goto L15
    L14:
        r4 = 0;
    L17:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
