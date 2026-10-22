package com.bytedance.android.livesdk.ktvimpl.base.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "invoke"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvCoreViewModel$initAnchorController$anchorController$1 extends FunctionReferenceImpl implements Function2<Integer, Long, Unit> {
    public KtvCoreViewModel$initAnchorController$anchorController$1(KtvCoreViewModel r8) {
        super(2, r8, KtvCoreViewModel.class, "updateSingerState", "updateSingerState(IJ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Number) r3).intValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int r2, long r3) {
        ((KtvCoreViewModel) ((CallableReference) this).receiver).updateSingerState(r2, r3);
    }
}
