package com.bytedance.android.livesdk.livecommerce.room.controller;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbsECLiveRoomController$isContextAttached$1 extends PropertyReference0Impl {
    public AbsECLiveRoomController$isContextAttached$1(a r7) {
        super(r7, a.class, "context", "getContext()Landroid/content/Context;", 0);
    }

    public Object get() {
        return ((a) ((CallableReference) this).receiver).getContext();
    }
}
