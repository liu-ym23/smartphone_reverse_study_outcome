package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvStageWidget$initView$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public KtvStageWidget$initView$1(KtvStageWidget r8) {
        super(1, r8, KtvStageWidget.class, "onKtvRoomContextInited", "onKtvRoomContextInited(Z)V", 0);
    }

    public final void invoke(boolean r3) {
        KtvStageWidget r0 = (KtvStageWidget) ((CallableReference) this).receiver;
        int r1 = KtvStageWidget.A;
        if (r3 == false) goto L5;
        r0.Fq();
        KtvLoggerHelper.f0();
        KtvLoggerHelper.c0();
        return;
    L5:
        r0.getClass();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
