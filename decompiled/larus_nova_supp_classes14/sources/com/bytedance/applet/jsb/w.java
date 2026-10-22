package com.bytedance.applet.jsb;

import android.media.AudioManager;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w extends bx7.c {
    public final String getName() {
        return "applet.getSystemVolumeInfo";
    }

    public w() {
    }

    public final void a(dx7.b r5, ux7.d.d r6, IvyBridgePlatformType r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(r7, "type");
        Object r8 = AppHost.a.getApplication().getSystemService("audio");
        if ((r8 instanceof AudioManager) == false) goto L5;
        AudioManager r9 = (AudioManager) r8;
    L6:
        Pair[] r10 = new Pair[2];
        if (r9 == null) goto L9;
        int r2 = r9.getStreamVolume(3);
    L10:
        r10[0] = TuplesKt.to("volume", Integer.valueOf(r2));
        if (r9 == null) goto L13;
        int r11 = r9.getStreamMaxVolume(3);
    L14:
        r10[1] = TuplesKt.to("max_volume", Integer.valueOf(r11));
        bx7.c.d(this, r6, MapsKt.mutableMapOf(r10));
        return;
    L13:
        r11 = 15;
        goto L14
    L9:
        r2 = 0;
        goto L10
    L5:
        r9 = null;
        goto L6
    }
}
