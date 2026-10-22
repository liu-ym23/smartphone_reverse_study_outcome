package com.bytedance.applet.jsb;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a1 extends bx7.c {
    public final String getName() {
        return "applet.updateMusicFavoriteStatus";
    }

    public a1() {
    }

    public final void a(dx7.b r4, ux7.d.d r5, IvyBridgePlatformType r6) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "type");
        String r7 = cx7.a.d(r4, "music_id", "");
        if (StringsKt.isBlank(r7) == false) goto L6;
        bx7.c.c(this, r5, -3, null, 12);
        return;
    L6:
        boolean r8 = cx7.a.b(r4, "status", false);
        MusicPlayManagerDelegate.b.m(r8, r7, null);
        bx7.c.d(this, r5, new LinkedHashMap());
    }
}
