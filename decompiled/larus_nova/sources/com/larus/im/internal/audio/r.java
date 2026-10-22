package com.larus.im.internal.audio;

import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r {
    public static final z0 c(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L6;
        return r100;
    L6:
        if ((r100 instanceof q) == false) goto L9;
        return r100;
    L9:
        return new q(r100);
    }

    public static final void a(z0 r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "event");
        if ((r100 instanceof a1) == false) goto L6;
        ((a1) r100).q(r101, r102);
        return;
    }

    public static final void b(ue9.d r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "event");
        if ((r100 instanceof ue9.e) == false) goto L6;
        ((ue9.e) r100).d(r101, r102);
        return;
    }
}
