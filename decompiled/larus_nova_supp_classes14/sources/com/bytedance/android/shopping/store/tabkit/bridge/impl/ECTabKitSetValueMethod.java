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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitSetValueMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitSetValueMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitSetValue";
    }

    public ECTabKitSetValueMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r7, ECBaseBridgeMethod.a r8) {
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r8, "iReturn");
        b r1 = this.f.d;
        if (r1 != null) goto L30;
        r8.onFailed(0, "proxy is null");
        return;
    L30:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L24
        String r4 = r7.optString("key");     // Catch: Throwable -> L24
        String r9 = r7.optString("value");     // Catch: Throwable -> L24
        boolean r5 = true;
        if (r4 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L22;
        if (r9 != null) goto L16;
    L19:
        if (r5 == true) goto L22;
        r1.q(r4, r9);     // Catch: Throwable -> L24
        r8.a(new JSONObject());     // Catch: Throwable -> L24
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L31;
        r8.onFailed(0, r11.getMessage());
        return;
    L31:
        return;
    L16:
        if (StringsKt.isBlank(r9) == true) goto L19;
        r5 = false;
    L22:
        r8.onFailed(0, "invalid key or value! key=" + r4 + " value=" + r9);     // Catch: Throwable -> L24
        return;
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r6 = false;
    L24:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
