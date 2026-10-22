package com.bytedance.android.livesdk.ktvimpl.realtimechorus.midi;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class RealTimeChorusMidiWidget$initStageViewModel$6 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    public RealTimeChorusMidiWidget$initStageViewModel$6(RealTimeChorusMidiWidget r8) {
        super(1, r8, RealTimeChorusMidiWidget.class, "updateLyricProgress", "updateLyricProgress(Ljava/lang/Long;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Long) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Long r2) {
        ((RealTimeChorusMidiWidget) ((CallableReference) this).receiver).xq(r2);
    }
}
