package com.bytedance.android.shopping.store.tabkit.bridge.impl;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.bridge.TabKitBridge;
import com.bytedance.android.shopping.store.tabkit.model.k;
import com.bytedance.android.shopping.store.tabkit.model.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/bridge/impl/ECTabKitGetTabsStatusMethod;", "Lcom/bytedance/android/shopping/store/tabkit/bridge/TabKitBridge$TabKitBaseBridgeMethod;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabKitGetTabsStatusMethod extends TabKitBridge.TabKitBaseBridgeMethod {
    public final TabKitBridge f;

    public final String getName() {
        return "ecTabKitGetTabsStatus";
    }

    public ECTabKitGetTabsStatusMethod(TabKitBridge r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabkitBridge");
        super(r3);
        this.f = r2;
    }

    public final void c(JSONObject r17, ECBaseBridgeMethod.a r18) {
        Intrinsics.checkNotNullParameter(r17, "params");
        Intrinsics.checkNotNullParameter(r18, "iReturn");
        TabKitBridge r3 = this.f;
        if (r3.d != null) goto L36;
        r18.onFailed(0, "proxy is null");
        return;
    L36:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L30
        TabKitViewModel r5 = r3.e;     // Catch: Throwable -> L30
        z r6 = (z) r5.getTabResponse().getValue();     // Catch: Throwable -> L30
        if (r6 == null) goto L27;
        List<k> r7 = r6.j();     // Catch: Throwable -> L30
        if (r7 == null) goto L27;
        List<k> r8 = r7;     // Catch: Throwable -> L30
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));     // Catch: Throwable -> L30
        Iterator<T> r10 = r8.iterator();     // Catch: Throwable -> L30
    L12:
        if (r10.hasNext() == false) goto L26;
        k r11 = (k) r10.next();     // Catch: Throwable -> L30
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L30
        r12.putOpt("tab_id", r11.n());     // Catch: Throwable -> L30
        if (r11.g() == false) goto L24;
        List<k> r13 = r11.m();     // Catch: Throwable -> L30
        if (r13 == null) goto L22;
        List<k> r14 = r13;     // Catch: Throwable -> L30
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Throwable -> L30
        Iterator<T> r16 = r14.iterator();     // Catch: Throwable -> L30
    L20:
        if (r16.hasNext() == false) goto L23;
        k r19 = (k) r16.next();     // Catch: Throwable -> L30
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L30
        r110.put("tab_id", r19.n());     // Catch: Throwable -> L30
        r110.put("has_show", r5.isTabAlreadyShow(r19.n()));     // Catch: Throwable -> L30
        r15.add(r110);     // Catch: Throwable -> L30
    L23:
        r12.putOpt("sub_tabs", new JSONArray(r15));     // Catch: Throwable -> L30
    L25:
        r9.add(r12);     // Catch: Throwable -> L30
        goto L12
    L22:
        r15 = null;
        goto L23
    L24:
        r12.putOpt("has_show", Boolean.valueOf(r5.isTabAlreadyShow(r11.n())));     // Catch: Throwable -> L30
        goto L25
    L26:
        ArrayList r20 = r9;
    L28:
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L30
        r0.putOpt("tabs", new JSONArray(r20));     // Catch: Throwable -> L30
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L30
        r18.a(r0);     // Catch: Throwable -> L30
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L42;
        r18.onFailed(0, r2.getMessage());
        return;
    L42:
        return;
    L27:
        r20 = null;
    L30:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }
}
