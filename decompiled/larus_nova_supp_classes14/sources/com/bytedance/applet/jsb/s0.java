package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.platform.api.c5;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class s0 implements c5 {
    public final /* synthetic */ t0 a;
    public final /* synthetic */ IvyBridgeMethod.a b;

    public s0(t0 r1, ux7.d.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(boolean r2, Integer r3, String r4, String r5) {
        t0 r6 = this.a;
        IvyBridgeMethod.a r7 = this.b;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("is_authorized", Boolean.valueOf(r2));
        Unit r9 = Unit.INSTANCE;
        bx7.c.d(r6, r7, r8);
    }
}
