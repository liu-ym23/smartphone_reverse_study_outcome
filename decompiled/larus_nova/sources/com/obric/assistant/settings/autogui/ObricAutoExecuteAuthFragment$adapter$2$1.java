package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ObricAutoExecuteAuthFragment$adapter$2$1 extends FunctionReferenceImpl implements Function2<a, Boolean, Unit> {
    public ObricAutoExecuteAuthFragment$adapter$2$1(Object r100) {
        super(2, r100, ObricAutoExecuteAuthViewModel.class, "onAuthorizationCheckedChanged", "onAuthorizationCheckedChanged(Lcom/obric/assistant/settings/autogui/AuthorizationItem;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(a r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((ObricAutoExecuteAuthViewModel) this.receiver).onAuthorizationCheckedChanged(r100, r101);
    }
}
