package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.platform.api.d5;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements d5 {
    public final /* synthetic */ c a;
    public final /* synthetic */ IvyBridgeMethod.a b;

    public b(c r1, ux7.d.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(boolean r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "clientKey");
        Intrinsics.checkNotNullParameter(r4, "scope");
        Intrinsics.checkNotNullParameter(r5, "state");
        c r6 = this.a;
        IvyBridgeMethod.a r7 = this.b;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("is_authorized", Boolean.valueOf(r2));
        Unit r9 = Unit.INSTANCE;
        bx7.c.d(r6, r7, r8);
    }
}
