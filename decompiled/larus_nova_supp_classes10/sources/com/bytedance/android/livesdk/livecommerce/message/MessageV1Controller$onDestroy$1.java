package com.bytedance.android.livesdk.livecommerce.message;

import com.bytedance.android.livesdk.livecommerce.room.api.d;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class MessageV1Controller$onDestroy$1 extends MutablePropertyReference0Impl {
    public MessageV1Controller$onDestroy$1(b r7) {
        super(r7, b.class, "messageHandler", "getMessageHandler()Lcom/bytedance/android/livesdk/livecommerce/room/api/IECMergeLiveRoomMessageHandler;", 0);
    }

    public Object get() {
        d r0 = ((b) ((CallableReference) this).receiver).c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageHandler");
    L5:
        return r0;
    }

    public void set(Object r2) {
        d r3 = (d) r2;
        ((b) ((CallableReference) this).receiver).c = r3;
    }
}
