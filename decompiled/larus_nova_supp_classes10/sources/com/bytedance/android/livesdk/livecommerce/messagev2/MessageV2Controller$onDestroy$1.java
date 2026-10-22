package com.bytedance.android.livesdk.livecommerce.messagev2;

import com.bytedance.android.livesdk.livecommerce.room.api.d;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MessageV2Controller$onDestroy$1 extends MutablePropertyReference0Impl {
    public MessageV2Controller$onDestroy$1(a r7) {
        super(r7, a.class, "messageHandler", "getMessageHandler()Lcom/bytedance/android/livesdk/livecommerce/room/api/IECMergeLiveRoomMessageHandler;", 0);
    }

    public Object get() {
        d r0 = ((a) ((CallableReference) this).receiver).c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageHandler");
    L5:
        return r0;
    }

    public void set(Object r2) {
        d r3 = (d) r2;
        ((a) ((CallableReference) this).receiver).c = r3;
    }
}
