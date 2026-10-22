package com.bytedance.applet.aibridge;

import com.larus.common_ui.dialog.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r implements p0 {
    public final /* synthetic */ f3.h<AbsOpenDialogMethodIDL.b> a;

    public final void confirm() {
        f3.h<AbsOpenDialogMethodIDL.b> r0 = this.a;
        Intrinsics.checkNotNullParameter(AbsOpenDialogMethodIDL.b.class, "<this>");
        AbsOpenDialogMethodIDL.b r1 = k3.c.a(AbsOpenDialogMethodIDL.b.class);
        r1.setConfirm(true);
        f3.h.a.b(r0, r1);
    }

    public r(f3.h<AbsOpenDialogMethodIDL.b> r1) {
        this.a = r1;
    }
}
