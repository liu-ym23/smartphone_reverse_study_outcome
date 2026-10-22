package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends com.bytedance.android.livesdk.ktvimpl.realtimechorus.a {
    public final ld2.a b;

    public a(ConcertTuner r2, com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r3) {
        Intrinsics.checkNotNullParameter(r2, "concertTuner");
        Intrinsics.checkNotNullParameter(r3, "chorusEventHandler");
        super(r3);
        this.b = r2;
    }

    public final void b(String r1, int r2, boolean r3, Context r4) {
        Intrinsics.checkNotNullParameter(r1, "source");
        this.b.b(r1, r2, r3);
    }
}
