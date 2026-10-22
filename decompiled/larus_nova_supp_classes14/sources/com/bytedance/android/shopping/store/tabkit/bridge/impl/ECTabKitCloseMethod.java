package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitCloseMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitCloseMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitClose";
    }

    public ECTabKitCloseMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r7, ECBaseBridgeMethod.a r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "iReturn");
        b r0 = this.f.d;
        if (r0 != null) goto L18;
        r8.onFailed(0, "proxy is null");
        return;
    L18:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        boolean r3 = r7.optBoolean("intercept", false);     // Catch: Throwable -> L12
        long r4 = r7.optLong("action", 2);     // Catch: Throwable -> L12
        if (r3 == false) goto L9;
        r0.W(r4);     // Catch: Throwable -> L12
    L10:
        r8.a(new JSONObject());     // Catch: Throwable -> L12
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L20;
        r8.onFailed(0, r10.getMessage());
        return;
    L20:
        return;
    L9:
        r0.W(-1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
