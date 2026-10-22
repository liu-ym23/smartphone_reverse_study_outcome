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
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitReadValueMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitReadValueMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitReadValue";
    }

    public ECTabKitReadValueMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r5, ECBaseBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "iReturn");
        b r1 = this.f.d;
        if (r1 != null) goto L24;
        r6.onFailed(0, "proxy is null");
        return;
    L24:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        String r7 = r5.optString("key");     // Catch: Throwable -> L18
        if (r7 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        r6.onFailed(0, "invalid key! key=" + r7);     // Catch: Throwable -> L18
        return;
    L16:
        Object r8 = r1.p(r7);     // Catch: Throwable -> L18
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L18
        r0.put("value", r8);     // Catch: Throwable -> L18
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        r6.a(r0);     // Catch: Throwable -> L18
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L25;
        r6.onFailed(0, r11.getMessage());
        return;
    L25:
        return;
    L9:
        if (StringsKt.isBlank(r7) == true) goto L12;
        r4 = false;
    L18:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
