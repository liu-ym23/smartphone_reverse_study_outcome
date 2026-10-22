package com.bytedance.ee.bear.bitable.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeBitableUIContainer$immersiveTracker$1$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public OfficeBitableUIContainer$immersiveTracker$1$1(Object r100) {
        super(1, r100, OfficeBitableUIContainer.class, "notifyNativeOverlayActive", "notifyNativeOverlayActive(Z)V", 0);
    }

    public final void invoke(boolean r100) {
        Function0<c> r101 = ((OfficeBitableUIContainer) this.receiver).f210098l;
        if (r101 == null) goto L11;
        c r102 = r101.invoke();
        if (r102 != null) goto L8;
        tt5.a.d("OfficeBitableUIContainer", "Base App immersive overlay ability is missing, active:" + r100);
        return;
    L8:
        r102.ij(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
