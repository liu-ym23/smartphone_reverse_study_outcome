package com.bytedance.android.shopping.mall.homepage.pagecard.bridge;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.event.f;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements IDLXBridgeMethod, h {
    public final String a;
    public final IDLXBridgeMethod.Access b;
    public final IDLXBridgeMethod.Compatibility c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.pagecard.bridge.a$a, reason: collision with other inner class name */
    public static final class C0107a {
    }

    static {
    }

    public final void release() {
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

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneID");
        Intrinsics.checkNotNullParameter(r3, "containerID");
        this.d = r2;
        this.e = r3;
        this.a = "ec.unsubscribeEventList";
        this.b = IDLXBridgeMethod.Access.PUBLIC;
        this.c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    public final void realHandle(IBDXBridgeContext r8, Map<String, ? extends Object> r9, IDLXBridgeMethod.a r10) {
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        Object r11 = r9.get("eventList");
        if (r11 != null) goto L5;
    L13:
        r10.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
        return;
    L5:
        if ((r11 instanceof List) == true) goto L7;
        r11 = null;
    L7:
        List r12 = (List) r11;
        if (r12 == null) goto L13;
        Iterator r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L13;
        String r14 = (String) r13.next();
        ECEventCenter.d().f(new f(this.d, this.e, System.currentTimeMillis(), null), r14);
        goto L11
    }
}
