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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitGetScreenStateMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitGetScreenStateMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitGetScreenState";
    }

    public ECTabKitGetScreenStateMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r4, ECBaseBridgeMethod.a r5) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "iReturn");
        b r6 = this.f.d;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        int r7 = r6.getScreenState();     // Catch: Throwable -> L9
    L7:
        r5.a(new JSONObject().putOpt("screen_state", Integer.valueOf(r7)));     // Catch: Throwable -> L9
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L17;
        r5.onFailed(0, r9.getMessage());
        return;
    L17:
        return;
    L6:
        r7 = 0;
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
