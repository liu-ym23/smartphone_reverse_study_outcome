package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class q6 extends RxAttributedElementImpl {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f405235x;

    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean U() {
        return false;
    }

    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean V() {
        return true;
    }

    @Override // com.relax.relaxframework.RxElementImpl
    public final boolean W() {
        return false;
    }

    public q6() {
        int r100 = l5.f405179a;
        RelaxInstance.Companion.getClass();
        RelaxInstance r101 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r101);
        if (r101.rtsPipelineEnabled() == false) goto L5;
        Long r102 = null;
    L6:
        super("raw-text", r102);
        this.f405235x = "";
        return;
    L5:
        r102 = Long.valueOf(RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().F());
        goto L6
    }

    public final void w0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        if (Intrinsics.areEqual(r100, this.f405235x) == false) goto L5;
        return;
    L5:
        if (this.f404932u.getShadowNodeProxy() == null) goto L7;
        ElementAttribute.Text.getValue();
        throw null;
    L7:
        if (this.f404932u.rtsPipelineEnabled() == true) goto L9;
        qpa.d.e(E(), ElementAttribute.Text.getValue(), r100);
    L9:
        markDirty();
        this.f405235x = r100;
    }
}
