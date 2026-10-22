package com.bytedance.android.shopping.mall.homepage.pagecard.bridge;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.event.f;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.mall.homepage.pagecard.b;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LynxSubscribeEventListBridge implements IDLXBridgeMethod, h {
    public final String a;
    public final IDLXBridgeMethod.Access b;
    public final IDLXBridgeMethod.Compatibility c;
    public final com.bytedance.android.ec.hybrid.card.event.a d;
    public final String e;
    public final String f;
    public final Function1<List<String>, Unit> g;

    public static final class a {
    }

    static {
    }

    public final void release() {
        ECEventCenter.a(new AnonymousClass1(this));
    }

    public final boolean canRunInBackground() {
        IHybridHostService r0 = com.bytedance.android.ec.hybrid.a.h();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.enableJsbAsync() != true) goto L7;
        return true;
    }

    public final IDLXBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.c;
    }

    public final String getName() {
        return this.a;
    }

    public final void realHandle(IBDXBridgeContext r11, Map<String, ? extends Object> r12, IDLXBridgeMethod.a r13) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Object r14 = r12.get("eventList");
        if (r14 != null) goto L5;
    L23:
        r13.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
        return;
    L5:
        if ((r14 instanceof List) == true) goto L7;
        r14 = null;
    L7:
        List r15 = (List) r14;
        if (r15 == null) goto L23;
        Iterator r0 = r15.iterator();
    L11:
        if (r0.hasNext() == false) goto L20;
        String r2 = (String) r0.next();
        String r4 = this.e;
        String r5 = this.f;
        Object r3 = r12.get("timestamp");
        if (r3 == null) goto L19;
        f r9 = new f(r4, r5, ((Number) r3).longValue(), this.d);
        Object r6 = r12.get("clearExistEvent");
        if ((r6 instanceof Boolean) == true) goto L17;
        r6 = null;
    L17:
        ECEventCenter.d().e(r9, r2, Intrinsics.areEqual((Boolean) r6, Boolean.TRUE));
        goto L11
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
    L20:
        Function1<List<String>, Unit> r16 = this.g;
        if (r16 == null) goto L23;
        Unit r17 = (Unit) r16.invoke(r15);
        goto L23
    }

    public LynxSubscribeEventListBridge(b r2, String r3, String r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r2, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(r3, "sceneID");
        Intrinsics.checkNotNullParameter(r4, "containerID");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = "ec.subscribeEventList";
        this.b = IDLXBridgeMethod.Access.PUBLIC;
        this.c = IDLXBridgeMethod.Compatibility.Compatible;
    }
}
