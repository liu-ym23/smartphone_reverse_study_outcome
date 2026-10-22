package com.larus.office.plugins.inputv2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AIChatPluginV2$bridgeRegistry$2$2 extends FunctionReferenceImpl implements Function2<String, Boolean, Unit> {
    public AIChatPluginV2$bridgeRegistry$2$2(Object r100) {
        super(2, r100, qo9.f.class, "setSourceVisible", "setSourceVisible(Ljava/lang/String;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Boolean r101) {
        invoke(r100, r101.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        ((qo9.f) this.receiver).b(r100, r101);
    }
}
