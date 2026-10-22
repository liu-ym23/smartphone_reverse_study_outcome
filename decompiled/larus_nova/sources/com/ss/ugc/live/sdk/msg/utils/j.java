package com.ss.ugc.live.sdk.msg.utils;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<d> f458482a;

    public j(d r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f458482a = new WeakReference(r100);
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.d
    public final void b(k r100) {
        Intrinsics.checkNotNullParameter(r100, "whatResult");
        d r101 = this.f458482a.get();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
