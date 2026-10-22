package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/a;", "invoke", "()Lcom/bytedance/android/livesdk/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class KtvRoomViewManager$guestSeatDegradeStrategy$2 extends Lambda implements Function0<com.bytedance.android.livesdk.a> {
    final /* synthetic */ KtvRoomViewManager this$0;

    public KtvRoomViewManager$guestSeatDegradeStrategy$2(KtvRoomViewManager r1) {
        this.this$0 = r1;
        super(0);
    }

    public final com.bytedance.android.livesdk.a invoke() {
        com.bytedance.android.livesdk.a.h.getClass();
        com.bytedance.android.livesdk.a r0 = com.bytedance.android.livesdk.a.a.b("talking_animation");
        if (r0 == null) goto L5;
        Function2<Integer, Boolean, Unit> r1 = new KtvRoomViewManager$guestSeatDegradeStrategy$2$$special$$inlined$apply$lambda$1(this);
        Intrinsics.checkNotNullParameter(r1, "cb");
        r0.a = r1;
        return r0;
    L5:
        return null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m343invoke() {
        return invoke();
    }
}
