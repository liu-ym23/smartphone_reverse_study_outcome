package com.larus.feedback.impl.manager;

import android.os.Handler;
import com.larus.utils.t0;
import q99.i;

/* JADX INFO: loaded from: classes27.dex */
public final class c implements o99.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f343099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f343100b;

    @Override // o99.c
    public final void e(final q99.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Handler r101 = t0.f375468a;
        final a r102 = this.f343099a;
        final i r103 = this.f343100b;
        r101.post(new b(r102, r103, r100));
    }

    public c(a r100, i r101) {
        this.f343099a = r100;
        this.f343100b = r101;
    }
}
