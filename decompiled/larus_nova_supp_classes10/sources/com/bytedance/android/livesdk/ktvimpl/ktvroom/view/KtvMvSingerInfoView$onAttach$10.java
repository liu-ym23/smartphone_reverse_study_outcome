package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/Pair;", "", "Lcom/bytedance/android/live/ktv/common/model/bean/a;", "p1", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class KtvMvSingerInfoView$onAttach$10 extends FunctionReferenceImpl implements Function1<Pair<? extends Boolean, ? extends com.bytedance.android.live.ktv.common.model.bean.a>, Unit> {
    public KtvMvSingerInfoView$onAttach$10(KtvMvSingerInfoView r8) {
        super(1, r8, KtvMvSingerInfoView.class, "handleCountdownEvent", "handleCountdownEvent(Lkotlin/Pair;)V", 0);
    }

    public final void invoke(Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a> r4) {
        KtvMvSingerInfoView r0 = (KtvMvSingerInfoView) ((CallableReference) this).receiver;
        int r1 = KtvMvSingerInfoView.m;
        r0.getClass();
        if (r4 == null) goto L7;
        r0.U5(((com.bytedance.android.live.ktv.common.model.bean.a) r4.getSecond()).b);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Pair) r1);
        return Unit.INSTANCE;
    }
}
