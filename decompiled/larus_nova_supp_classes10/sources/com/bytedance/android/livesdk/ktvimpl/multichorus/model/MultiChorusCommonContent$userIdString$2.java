package com.bytedance.android.livesdk.ktvimpl.multichorus.model;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiChorusCommonContent$userIdString$2 extends MutablePropertyReference0Impl {
    public MultiChorusCommonContent$userIdString$2(e r7) {
        super(r7, e.class, "userOpenId", "getUserOpenId()Ljava/lang/String;", 0);
    }

    public Object get() {
        return ((e) ((CallableReference) this).receiver).userOpenId;
    }

    public void set(Object r3) {
        e r0 = (e) ((CallableReference) this).receiver;
        String r4 = (String) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.userOpenId = r4;
    }
}
