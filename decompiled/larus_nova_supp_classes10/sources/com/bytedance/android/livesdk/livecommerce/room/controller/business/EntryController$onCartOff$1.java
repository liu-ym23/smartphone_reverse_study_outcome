package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class EntryController$onCartOff$1 extends MutablePropertyReference0Impl {
    public EntryController$onCartOff$1(EntryController r7) {
        super(r7, EntryController.class, "rankEntry", "getRankEntry()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/DummyEntry;", 0);
    }

    public Object get() {
        hk2.a r0 = ((EntryController) ((CallableReference) this).receiver).r;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rankEntry");
    L5:
        return r0;
    }

    public void set(Object r2) {
        hk2.a r3 = (hk2.a) r2;
        ((EntryController) ((CallableReference) this).receiver).r = r3;
    }
}
