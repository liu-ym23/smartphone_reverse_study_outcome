package com.ivy.ivykit.plugin.impl.render;

import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class f implements oz2.a {
    public f() {
    }

    @Override // oz2.a
    public final void b(LynxView r100, String r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "type");
        nz2.b.a("Bullet", "onDetectResult() called with: view = [" + r100 + "], effectivePercentage = [" + r102 + ']');
    }

    @Override // oz2.a
    public final void a(LynxView r100, String r101, long r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "type");
        nz2.b.a("Bullet", "onDetectCost() called with: view = [" + r100 + "], collectDuration = [" + r102 + "], calculateDuration = [" + r103 + ']');
    }
}
