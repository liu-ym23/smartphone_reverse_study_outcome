package com.larus.voicecall.impl.component.bottom.more_btn;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class BottomMoreAction$ctx$1$transTo$1 extends FunctionReferenceImpl implements Function1<c, Unit> {
    public BottomMoreAction$ctx$1$transTo$1(Object r100) {
        super(1, r100, b.class, "transTo", "transTo(Lcom/larus/voicecall/impl/component/bottom/more_btn/IBaseMoreBtnState;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        b r101 = (b) this.receiver;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "state");
        FLogger.f375446a.i("BottomMoreAction", "transTo old_state=[" + r101.f377239g.b() + "] new_state=[" + r100.b() + ']');
        r101.f377239g.f();
        r101.f377239g = r100;
        r100.e();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
