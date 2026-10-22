package com.relax.relaxframework;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class h5 extends RxAttributedElementImpl implements f5 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f405117x = 0;

    public final void y0() {
        if (this.f404932u.rtsPipelineEnabled() == true) goto L6;
        return;
    L6:
        if (this.f404932u.getUIProxy() == null) goto L8;
        throw null;
    L8:
        if (this.f404932u.getShadowNodeProxy() != null) goto L11;
        markDirty();
        return;
    L11:
        throw null;
    }

    public h5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        RelaxInstance.Companion.getClass();
        RelaxInstance r101 = RelaxInstance.access$getCurrentInstance$cp();
        Intrinsics.checkNotNull(r101);
        if (r101.rtsPipelineEnabled() == false) goto L5;
        Long r102 = null;
    L6:
        super(r100, r102);
        return;
    L5:
        r102 = Long.valueOf(RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().j(r100));
        goto L6
    }

    public final void z0(final Function0 r100) {
        final String r101 = "src";
        Intrinsics.checkNotNullParameter("src", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        RelaxFrameworkKt.K(new RxCustomElementImpl$setAttribute__M_S_PFS$1(this, r101, r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.relax.relaxframework.g5] */
    public static void w0(final h5 r100, final Function1 r101) {
        Intrinsics.checkNotNullParameter("RTSAnchorStatusHybridCard_onLoadSuccess", "eventName");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100.f404932u.rtsPipelineEnabled() == true) goto L5;
        long r102 = r100.E();
        ?? r103 = new g5(r101);
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().b(r102, r103, null);
    L5:
        RxAttributedElementImpl.d0(r100, "RTSAnchorStatusHybridCard_onLoadSuccess", new RxCustomElementImpl$addEventListener$2(r101), new RxCustomElementImpl$addEventListener$3(r100));
    }

    public final void x0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        long r102 = E();
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().C0(r102, r100, r101);
    L5:
        y0();
    }
}
