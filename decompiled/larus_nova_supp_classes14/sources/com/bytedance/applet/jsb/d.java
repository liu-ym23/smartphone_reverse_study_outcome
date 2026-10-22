package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends bx7.c {
    public final String getName() {
        return "applet.configMusicResolution";
    }

    public d() {
    }

    public final void a(dx7.b r3, ux7.d.d r4, IvyBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        String r6 = cx7.a.d(r3, "resolution", "");
        c0 r7 = c0.a;
        Intrinsics.checkNotNullParameter(r6, "mappedResolution");
        switch(r6.hashCode()) {
            case -1919475908: goto L18;
            case -1217394225: goto L14;
            case -1078030475: goto L10;
            case 915484836: goto L6;
            default: goto L21;
        };
    L21:
        String r8 = "Undefine";
    L22:
        String r9 = c0.b;
        if (r9 == null) goto L26;
        bx7.c.d(this, r4, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(MusicPlayManagerDelegate.b.p(r9, r8)))}));
        return;
    L26:
        bx7.c.c(this, r4, 0, null, 12);
        return;
    L6:
        if (r6.equals("highest") == false) goto L21;
        r8 = "SuperHigh";
        goto L22
    L10:
        if (r6.equals("medium") == false) goto L21;
        r8 = "Standard";
        goto L22
    L14:
        if (r6.equals("higher") == false) goto L21;
        r8 = "High";
        goto L22
    L18:
        if (r6.equals("lossless") == false) goto L21;
        r8 = "FourK";
        goto L22
    }
}
