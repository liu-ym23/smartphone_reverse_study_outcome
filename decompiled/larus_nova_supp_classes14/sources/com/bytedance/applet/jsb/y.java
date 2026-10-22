package com.bytedance.applet.jsb;

import android.content.Context;
import android.content.ContextWrapper;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y extends bx7.c {
    public final String getName() {
        return "applet.isFromPush";
    }

    public y() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        Context r6 = (Context) e(Context.class);
        if (r6 == null) goto L11;
    L4:
        if (r6 == null) goto L11;
        if ((r6 instanceof FlowCommonAppCompatActivity) == true) goto L7;
        if ((r6 instanceof ContextWrapper) == false) goto L11;
        r6 = ((ContextWrapper) r6).getBaseContext();
        goto L4
    L7:
        FlowCommonAppCompatActivity r7 = (FlowCommonAppCompatActivity) r6;
    L13:
        if (r7 == null) goto L15;
        boolean r8 = r7.a;
    L16:
        bx7.c.d(this, r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("value", Boolean.valueOf(r8))}));
        return;
    L15:
        r8 = false;
    L11:
        r7 = null;
        goto L13
    }
}
