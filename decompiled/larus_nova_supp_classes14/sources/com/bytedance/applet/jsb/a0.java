package com.bytedance.applet.jsb;

import com.bytedance.applet.utils.MessageUtils;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a0 extends bx7.c {
    public final String getName() {
        return "applet.isLastMessage";
    }

    public a0() {
    }

    public final void a(dx7.b r2, final ux7.d.d r3, IvyBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "type");
        MessageUtils r5 = MessageUtils.a;
        Function1 r6 = new z(this, r3);
        r5.getClass();
        MessageUtils.k(null, r6);
    }
}
