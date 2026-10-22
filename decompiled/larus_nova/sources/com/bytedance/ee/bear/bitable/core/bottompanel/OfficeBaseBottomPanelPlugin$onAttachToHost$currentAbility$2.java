package com.bytedance.ee.bear.bitable.core.bottompanel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class OfficeBaseBottomPanelPlugin$onAttachToHost$currentAbility$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public OfficeBaseBottomPanelPlugin$onAttachToHost$currentAbility$2(Object r100) {
        super(1, r100, OfficeBaseBottomPanelPlugin.class, "applyBottomContainerBackgroundColor", "applyBottomContainerBackgroundColor(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r100) {
        OfficeBaseBottomPanelPlugin.access$applyBottomContainerBackgroundColor((OfficeBaseBottomPanelPlugin) this.receiver, r100);
    }
}
