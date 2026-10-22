package com.larus.bmhome.chat.markdown.code;

import android.os.Handler;
import java.lang.ref.SoftReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 implements rj8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f307006a;

    @Override // rj8.b
    public final void a() {
        SoftReference<Handler> r100 = com.larus.utils.y.f375498a;
        final q0 r101 = this.f307006a;
        Runnable r102 = new o0(r101);
        Intrinsics.checkNotNullParameter(r102, "action");
        com.larus.utils.y.c(r102);
    }

    public p0(q0 r100) {
        this.f307006a = r100;
    }
}
