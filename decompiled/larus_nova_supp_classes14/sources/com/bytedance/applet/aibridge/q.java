package com.bytedance.applet.aibridge;

import com.larus.common_ui.dialog.u;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements u {
    public final /* synthetic */ f3.h<AbsOpenDialogMethodIDL.b> a;

    public final void cancel() {
        f3.h<AbsOpenDialogMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsOpenDialogMethodIDL.b.class, "<this>");
        AbsOpenDialogMethodIDL.b r1 = k3.c.a(AbsOpenDialogMethodIDL.b.class);
        r1.setConfirm(false);
        f3.h.a.b(r0, r1);
    }

    public q(f3.h<AbsOpenDialogMethodIDL.b> r1) {
        this.a = r1;
    }
}
