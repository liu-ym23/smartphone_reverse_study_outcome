package com.larus.uaigc.createpage.component.videogenerate;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements d {
    public a() {
    }

    @Override // com.larus.uaigc.createpage.component.videogenerate.d
    public final void a(Bitmap r100, ys8.a r101, c r102) {
        Intrinsics.checkNotNullParameter(r102, "ratioAutoSelectStrategy");
        if (r101 == null) goto L7;
        boolean r103 = true;
        if (r101.Wm() != true) goto L7;
    L8:
        if (r103 == true) goto L12;
        if (r101 == null) goto L13;
        r101.selectRatio(0);
        return;
    L13:
        return;
    L12:
        return;
    L7:
        r103 = false;
        goto L8
    }
}
