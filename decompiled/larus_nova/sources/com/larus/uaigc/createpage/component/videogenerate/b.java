package com.larus.uaigc.createpage.component.videogenerate;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b implements d {
    public b() {
    }

    @Override // com.larus.uaigc.createpage.component.videogenerate.d
    public final void a(Bitmap r100, ys8.a r101, c r102) {
        Intrinsics.checkNotNullParameter(r102, "ratioAutoSelectStrategy");
        if (r100 != null) goto L5;
        return;
    L5:
        Long r103 = r102.b(((double) r100.getWidth()) / ((double) r100.getHeight()));
        if (r103 == null) goto L11;
        r103.longValue();
        if (r101 == null) goto L12;
        r101.selectRatio(r103.longValue());
        return;
    L12:
        return;
    }
}
