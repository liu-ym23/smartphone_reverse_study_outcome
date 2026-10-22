package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvRoomEmojiDialogBuilder$check$3 extends MutablePropertyReference0Impl {
    public KtvRoomEmojiDialogBuilder$check$3(a r7) {
        super(r7, a.class, "requestPage", "getRequestPage()Ljava/lang/String;", 0);
    }

    public Object get() {
        String r0 = ((a) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L5:
        return r0;
    }

    public void set(Object r2) {
        String r3 = (String) r2;
        ((a) ((CallableReference) this).receiver).d = r3;
    }
}
