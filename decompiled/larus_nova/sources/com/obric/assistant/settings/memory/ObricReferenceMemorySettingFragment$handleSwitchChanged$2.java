package com.obric.assistant.settings.memory;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class ObricReferenceMemorySettingFragment$handleSwitchChanged$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public ObricReferenceMemorySettingFragment$handleSwitchChanged$2(Object r100) {
        super(1, r100, ObricReferenceMemorySettingFragment.class, "handleSwitchResult", "handleSwitchResult(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        ObricReferenceMemorySettingFragment.U90((ObricReferenceMemorySettingFragment) this.receiver, r100);
    }
}
