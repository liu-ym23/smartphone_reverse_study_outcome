package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusCommonContent$userIdString$1 extends MutablePropertyReference0Impl {
    public MultiChorusCommonContent$userIdString$1(e r7) {
        super(r7, e.class, "userID", "getUserID()J", 0);
    }

    public Object get() {
        return Long.valueOf(((e) ((CallableReference) this).receiver).userID);
    }

    public void set(Object r4) {
        e r0 = (e) ((CallableReference) this).receiver;
        r0.userID = ((Number) r4).longValue();
    }
}
