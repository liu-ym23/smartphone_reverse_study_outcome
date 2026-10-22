package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.anchor;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zg1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/j;", "p1", "", "invoke", "(Lzg1/j;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class AnchorKtvComponentStrategy$onWidgetCreate$12 extends FunctionReferenceImpl implements Function1<j, Unit> {
    public AnchorKtvComponentStrategy$onWidgetCreate$12(AnchorKtvComponentStrategy r8) {
        super(1, r8, AnchorKtvComponentStrategy.class, "onAudienceInteractChangedEvent", "onAudienceInteractChangedEvent(Lcom/bytedance/android/livesdk/chatroom/event/AudienceInteractChangedEvent;)V", 0);
    }

    public final void invoke(j r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        AnchorKtvComponentStrategy r0 = (AnchorKtvComponentStrategy) ((CallableReference) this).receiver;
        int r1 = AnchorKtvComponentStrategy.n;
        r0.getClass();
        if (r6.a != 1) goto L5;
        Integer r7 = 0;
        Integer r2 = 4;
    L6:
        int r3 = r2.intValue();
        r7.intValue();
        int r4 = k.n(IInteractService.class).getCurrentUiLayout();
        r0.n(r7, Integer.valueOf(r4));
        r0.m(r2, Integer.valueOf(r4));
        r0.h = Integer.valueOf(r3);
        r0.i = Integer.valueOf(r4);
        return;
    L5:
        r7 = 4;
        r2 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((j) r1);
        return Unit.INSTANCE;
    }
}
