package com.relax.relaxframework;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class t5 extends RxElementImpl {
    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean U() {
        return false;
    }

    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean W() {
        return false;
    }

    public t5() {
        int r100 = l5.f405179a;
        RelaxInstance.Companion.getClass();
        RelaxInstance r101 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r101);
        if (r101.rtsPipelineEnabled() == false) goto L5;
        Long r102 = null;
    L6:
        super(WidgetService.PARAM_FRAGMENT, r102);
        return;
    L5:
        r102 = Long.valueOf(qpa.d.c());
        goto L6
    }
}
