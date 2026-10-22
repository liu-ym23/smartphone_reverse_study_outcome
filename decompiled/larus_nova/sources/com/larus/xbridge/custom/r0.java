package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class r0 extends bx7.c {

    public static final class a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "app.azerothEncrypt";
    }

    public r0() {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, final ux7.d.C7943d r101, IvyBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        final String r103 = r100.getString("content");
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        bx7.c.c(this, r101, -3, null, 12);
        return;
    L9:
        com.larus.utils.t0.a(new q0(r103, this, r101));
        return;
    L5:
        r104 = false;
        goto L6
    }
}
