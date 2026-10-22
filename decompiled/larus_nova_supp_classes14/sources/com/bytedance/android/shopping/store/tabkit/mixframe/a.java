package com.bytedance.android.shopping.store.tabkit.mixframe;

import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements IDLXBridgeMethod, h {
    public final Set<String> a;
    public final IDLXBridgeMethod.Access b;
    public final IDLXBridgeMethod.Compatibility c;
    public final Function1<String, Unit> d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.mixframe.a$a, reason: collision with other inner class name */
    public static final class C0021a {
    }

    static {
    }

    public final boolean canRunInBackground() {
        return false;
    }

    public final String getName() {
        return "ec.negfeedback_click";
    }

    public final void release() {
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.d = r2;
        this.a = new LinkedHashSet();
        this.b = IDLXBridgeMethod.Access.PUBLIC;
        this.c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    public final void realHandle(IBDXBridgeContext r11, Map<String, ? extends Object> r12, IDLXBridgeMethod.a r13) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        String r14 = "";
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Set<String> r2 = this.a;     // Catch: Throwable -> L5
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L5
        r3.append(r12.get("type"));     // Catch: Throwable -> L5
        r3.append('_');     // Catch: Throwable -> L5
        r3.append(r12.get("itemType"));     // Catch: Throwable -> L5
        r3.append('_');     // Catch: Throwable -> L5
        r3.append(r12.get("itemId"));     // Catch: Throwable -> L5
        r2.add(r3.toString());     // Catch: Throwable -> L5
        this.d.invoke(CollectionsKt.joinToString$default(this.a, ",", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L5
        Object r15 = Result.constructor-impl(TuplesKt.to(Boolean.TRUE, ""));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.exceptionOrNull-impl(r15);
        if (r4 == null) goto L10;
        String r5 = r4.toString();
    L12:
        if (Result.isFailure-impl(r15) == false) goto L14;
        r15 = null;
    L14:
        Pair r16 = (Pair) r15;
        if (r16 != null) goto L17;
        r16 = new Pair(Boolean.FALSE, "ECMallStatefulJsb Error: " + r5);
    L17:
        boolean r6 = ((Boolean) r16.component1()).booleanValue();
        String r17 = (String) r16.component2();
        Pair[] r7 = new Pair[3];
        r7[0] = TuplesKt.to("code", Integer.valueOf(r6 ? 1 : 0));
        if (r17 == null) goto L21;
        r14 = r17;
    L21:
        r7[1] = TuplesKt.to("msg", r14);
        r7[2] = TuplesKt.to("data", r0);
        r13.invoke(MapsKt.mapOf(r7));
        return;
    L10:
        r5 = null;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
