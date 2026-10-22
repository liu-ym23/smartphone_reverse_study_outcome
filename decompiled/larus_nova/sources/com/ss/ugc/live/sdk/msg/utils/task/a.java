package com.ss.ugc.live.sdk.msg.utils.task;

import com.ss.ugc.live.sdk.msg.utils.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a<INPUT, OUTPUT> extends b<INPUT, OUTPUT> {
    public abstract void c(INPUT r100);

    public a(mmc.c r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        super(r100);
    }

    @Override // mmc.a
    public final void a(INPUT r100) {
        c(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        int r101 = g.f458477a;
        b(g.a.a(th));
    }
}
