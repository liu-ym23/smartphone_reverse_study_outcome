package com.larus.home.impl.main.side_bar.view.group.assembly;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$4 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public SideBarGroupMenuCallbacksKt$createGroupMenuCallbacks$4(Object r100) {
        super(1, r100, n.class, "onSocialIndependentChanged", "onSocialIndependentChanged(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r100) {
        ((n) this.receiver).e(r100);
    }
}
