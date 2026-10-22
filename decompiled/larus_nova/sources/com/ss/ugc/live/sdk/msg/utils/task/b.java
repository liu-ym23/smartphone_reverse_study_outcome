package com.ss.ugc.live.sdk.msg.utils.task;

import com.ss.ugc.live.sdk.msg.utils.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class b<INPUT, OUTPUT> implements mmc.a<INPUT, OUTPUT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskState<INPUT, OUTPUT, b<INPUT, OUTPUT>> f458504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mmc.c f458505b;

    public b(mmc.c r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f458505b = r100;
        this.f458504a = new TaskState();
    }

    public final void b(g<? extends OUTPUT, ? extends Throwable> r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        TaskState<INPUT, OUTPUT, b<INPUT, OUTPUT>> r101 = this.f458504a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "result");
        r101.f458488d.d(new TaskState.a.C5505a(r100));
    }
}
