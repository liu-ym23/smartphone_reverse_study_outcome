package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends qf3.e {
    public final String d;

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public o(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.getCachedApiResponse";
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r9, Map<String, ? extends Object> r10, IDLXBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("code", 0);
        r12.put("result", "");
        Object r2 = r10.get("apiKey");
        if (r2 == null) goto L54;
        String r3 = r2.toString();
        Object r4 = r10.get("majorKey");
        JsonElement r5 = null;
        if ((r4 instanceof String) == true) goto L7;
        r4 = null;
    L7:
        String r6 = (String) r4;
        Object r7 = r10.get("subKey");
        if ((r7 instanceof String) == true) goto L10;
        r7 = null;
    L10:
        String r8 = (String) r7;
        Object r13 = r10.get("subSubKey");
        if ((r13 instanceof String) == true) goto L13;
        r13 = null;
    L13:
        String r14 = (String) r13;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L46
        ECHybridListEngine r16 = this.c.b.J;     // Catch: Throwable -> L46
        if (r16 == null) goto L41;
        com.bytedance.android.ec.hybrid.list.ability.t r17 = (com.bytedance.android.ec.hybrid.list.ability.t) r16.getAbility(com.bytedance.android.ec.hybrid.list.ability.t.class);     // Catch: Throwable -> L46
        if (r17 == null) goto L41;
        JsonElement r18 = r17.TS(r3);     // Catch: Throwable -> L46
        if (r18 == null) goto L41;
        JsonObject r19 = (JsonObject) ECHybridGsonUtil.a().fromJson(r18, JsonObject.class);     // Catch: Throwable -> L44
        if (r19 == null) goto L42;
        JsonElement r20 = r19.get(r6);     // Catch: Throwable -> L44
        if (r20 == null) goto L42;
        if (r8 != null) goto L26;
        JsonElement r110 = r20.toString();     // Catch: Throwable -> L44
    L38:
        r5 = r110;
    L39:
        r18 = r5;
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L46
        goto L42
    L26:
        if (r20.isJsonObject() == false) goto L36;
        JsonObject r21 = r20.getAsJsonObject();     // Catch: Throwable -> L44
        if (r21 == null) goto L36;
        JsonElement r22 = r21.get(r8);     // Catch: Throwable -> L44
        if (r22 == null) goto L36;
        if (r14 != null) goto L33;
        r110 = r22.toString();     // Catch: Throwable -> L44
        goto L38
    L33:
        if (r22.isJsonObject() == false) goto L36;
        r110 = r22.getAsJsonObject().get(r14);     // Catch: Throwable -> L44
    L36:
        r5 = r18;
    L42:
        Object r111 = Result.constructor-impl(r5);     // Catch: Throwable -> L44
    L49:
        Throwable r112 = Result.exceptionOrNull-impl(r111);
        if (r112 == null) goto L52;
        EnsureManager.ensureNotReachHere(r112, "ECHybridList: getCachedApiResponse");
    L52:
        if (r18 == null) goto L54;
        r12.put("code", 1);
        r12.put("result", r18);
    L44:
        th = th;
    L48:
        Result.Companion r23 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
    L41:
        r18 = null;
    L46:
        th = th;
        r18 = r5;
    L54:
        r11.invoke(r12);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return qf3.e.f(this);
    }
}
