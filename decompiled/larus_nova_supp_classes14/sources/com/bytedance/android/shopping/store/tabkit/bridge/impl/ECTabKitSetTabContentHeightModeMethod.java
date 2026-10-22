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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitSetTabContentHeightModeMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitSetTabContentHeightModeMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitSetTabContentHeightMode";
    }

    public ECTabKitSetTabContentHeightModeMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r6, ECBaseBridgeMethod.a r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "iReturn");
        b r1 = this.f.d;
        if (r1 != null) goto L18;
        r7.onFailed(0, "proxy is null");
        return;
    L18:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        int r8 = r6.optInt("height_mode", -1);     // Catch: Throwable -> L12
        if (r8 != (-1)) goto L10;
        r7.onFailed(0, "invalid mode! mode=" + r8);     // Catch: Throwable -> L12
        return;
    L10:
        r1.k(r8);     // Catch: Throwable -> L12
        r7.a(new JSONObject());     // Catch: Throwable -> L12
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L19;
        r7.onFailed(0, r10.getMessage());
        return;
    L19:
        return;
    L12:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
