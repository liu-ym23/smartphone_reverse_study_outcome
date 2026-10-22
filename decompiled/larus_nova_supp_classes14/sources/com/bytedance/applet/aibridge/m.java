package com.bytedance.applet.aibridge;

import com.larus.platform.api.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m implements l0 {
    public final /* synthetic */ f3.h<AbsSetMusicPlaybackTimeMethodIDL.b> a;

    public m(f3.h<AbsSetMusicPlaybackTimeMethodIDL.b> r1) {
        this.a = r1;
    }

    public final void onCompletion(boolean r3) {
        f3.h<AbsSetMusicPlaybackTimeMethodIDL.b> r4 = this.a;
        Intrinsics.checkNotNullParameter(AbsSetMusicPlaybackTimeMethodIDL.b.class, "<this>");
        f3.h.a.b(r4, k3.c.a(AbsSetMusicPlaybackTimeMethodIDL.b.class));
    }
}
