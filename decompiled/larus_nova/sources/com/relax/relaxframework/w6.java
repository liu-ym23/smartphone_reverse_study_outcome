package com.relax.relaxframework;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.relax.runtime.gen.NativeLayoutProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class w6 extends m5 {
    public w6() {
        int r100 = l5.f405179a;
        RelaxInstance.a r101 = RelaxInstance.Companion;
        r101.getClass();
        RelaxInstance r102 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r102);
        if (r102.rtsPipelineEnabled() == false) goto L5;
        Long r103 = null;
    L6:
        super(SlcFlexDirection.FLEX_ROW, r103);
        return;
    L5:
        r101.getClass();
        r103 = Long.valueOf(RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().K());
        goto L6
    }

    @Override // com.relax.relaxframework.m5, com.relax.relaxframework.RxElementImpl
    public final void x(int r100) {
        NativeLayoutProxy r101 = this.f404932u.getLayoutProxy();
        if (r101 == null) goto L6;
        r101.g(r100);
        return;
    }
}
