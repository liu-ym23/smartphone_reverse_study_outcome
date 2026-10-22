package com.bytedance.android.livesdk.livecommerce.room.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbsECLiveRoomController$isFunctionHandlerAttached$1 extends PropertyReference0Impl {
    public AbsECLiveRoomController$isFunctionHandlerAttached$1(a r7) {
        super(r7, a.class, "functionHandler", "getFunctionHandler()Lcom/bytedance/android/livesdk/livecommerce/room/api/IECMergeLiveRoomFunctionHandler;", 0);
    }

    public Object get() {
        com.bytedance.android.livesdk.livecommerce.room.api.c r0 = ((a) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("functionHandler");
    L5:
        return r0;
    }
}
