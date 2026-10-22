package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends bx7.c {
    public final String getName() {
        return "applet.getMusicResolutionInfo";
    }

    public t() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        ArrayList r6 = new ArrayList();
        String r7 = c0.b;
        if (r7 == null) goto L10;
        Iterator r8 = MusicPlayManagerDelegate.b.i(r7).iterator();
    L6:
        if (r8.hasNext() == false) goto L10;
        String r0 = c0.a.k((String) r8.next());
        if (r0 == null) goto L6;
        r6.add(r0);
    L10:
        String r9 = c0.a.k(MusicPlayManagerDelegate.b.n());
        if (r9 != null) goto L13;
        r9 = "undefine";
    L13:
        bx7.c.d(this, r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("resolution_list", r6), TuplesKt.to("current_resolution", r9)}));
    }
}
