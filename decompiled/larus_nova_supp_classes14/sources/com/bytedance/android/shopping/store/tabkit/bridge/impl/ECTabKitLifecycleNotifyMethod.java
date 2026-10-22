package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.store.api.ITabKitEventListener;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitLifecycle;
import com.bytedance.android.shopping.store.tabkit.events.TabKitEventCenter;
import com.bytedance.android.shopping.store.tabkit.model.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitLifecycleNotifyMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitLifecycleNotifyMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitLifecycleNotify";
    }

    public ECTabKitLifecycleNotifyMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r5, ECBaseBridgeMethod.a r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "iReturn");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        TabKitViewModel r3 = this.f.e;     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(r5.optString("type"), TabKitLifecycle.TTI_READY.getType()) == false) goto L19;
        String r7 = r3.getRouterParams().getLifecycleListenerId();     // Catch: Throwable -> L21
        if (r7 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L15;
        r6.onFailed(0, "invalid id! id=" + r7);     // Catch: Throwable -> L21
        return;
    L15:
        ITabKitEventListener r8 = TabKitEventCenter.a(r7);     // Catch: Throwable -> L21
        if (r8 == null) goto L18;
        r8.onLoadFinish();     // Catch: Throwable -> L21
    L18:
        r6.a(new JSONObject());     // Catch: Throwable -> L21
        goto L19
    L8:
        if (StringsKt.isBlank(r7) == true) goto L11;
        r4 = false;
    L19:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L28;
        r6.onFailed(0, r10.getMessage());
        return;
    L28:
        return;
    L21:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
