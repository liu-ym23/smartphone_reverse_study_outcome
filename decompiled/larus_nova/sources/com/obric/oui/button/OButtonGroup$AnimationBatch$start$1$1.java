package com.obric.oui.button;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
final /* synthetic */ class OButtonGroup$AnimationBatch$start$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public OButtonGroup$AnimationBatch$start$1$1(Object r100) {
        super(0, r100, OButtonGroup.a.class, "done", "done()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        OButtonGroup.a r100 = (OButtonGroup.a) this.receiver;
        if (r100.f399076d == false) goto L13;
        boolean r101 = r100.f399077e;
        if (r101 == true) goto L15;
        int r102 = r100.f399075c - 1;
        r100.f399075c = r102;
        if (r102 != 0) goto L14;
        if (r101 == true) goto L16;
        r100.f399077e = true;
        r100.f399073a.invoke();
        return;
    L16:
        return;
    L14:
        return;
    L15:
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
