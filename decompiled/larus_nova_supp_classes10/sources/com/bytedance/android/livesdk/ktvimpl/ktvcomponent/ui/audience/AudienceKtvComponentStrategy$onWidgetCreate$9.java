package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.audience;

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
public final /* synthetic */ class AudienceKtvComponentStrategy$onWidgetCreate$9 extends FunctionReferenceImpl implements Function1<j, Unit> {
    public AudienceKtvComponentStrategy$onWidgetCreate$9(AudienceKtvComponentStrategy r8) {
        super(1, r8, AudienceKtvComponentStrategy.class, "onAudienceInteractChange", "onAudienceInteractChange(Lcom/bytedance/android/livesdk/chatroom/event/AudienceInteractChangedEvent;)V", 0);
    }

    public final void invoke(j r8) {
        Intrinsics.checkNotNullParameter(r8, "p1");
        AudienceKtvComponentStrategy r0 = (AudienceKtvComponentStrategy) ((CallableReference) this).receiver;
        int r1 = AudienceKtvComponentStrategy.w;
        r0.getClass();
        boolean r2 = true;
        if (r8.a != 1) goto L5;
        Integer r9 = 0;
        Integer r3 = 4;
    L6:
        int r4 = r3.intValue();
        r9.intValue();
        int r5 = k.n(IInteractService.class).getCurrentUiLayout();
        r0.o(r9, Integer.valueOf(r5));
        r0.n(r3, Integer.valueOf(r5));
        r0.p = Integer.valueOf(r4);
        r0.q = Integer.valueOf(r5);
        Integer r10 = r0.p;
        if (r10 != null) goto L10;
    L19:
        r2 = false;
    L20:
        r0.r = r2;
        return;
    L10:
        if (r10.intValue() != 8) goto L19;
        Integer r11 = r0.q;
        if (r11 == null) goto L19;
        if (r11.intValue() != 7) goto L19;
        if (k.n(IInteractService.class).dynamicFromAudience() == false) goto L19;
    L5:
        r9 = 4;
        r3 = 0;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((j) r1);
        return Unit.INSTANCE;
    }
}
