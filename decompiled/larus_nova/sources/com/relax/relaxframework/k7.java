package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k7 extends m5 {
    public k7() {
        int r100 = l5.f405179a;
        RelaxInstance.a r101 = RelaxInstance.Companion;
        r101.getClass();
        RelaxInstance r102 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r102);
        if (r102.rtsPipelineEnabled() == false) goto L5;
        Long r103 = null;
    L6:
        super("wrap", r103);
        l0(ElementAttribute.FlexWrap, new g2(FlexWrap.Wrap.getValue()));
        return;
    L5:
        r101.getClass();
        r103 = Long.valueOf(RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().Y());
        goto L6
    }
}
