package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvRoomEmojiDialogBuilder$check$2 extends MutablePropertyReference0Impl {
    public KtvRoomEmojiDialogBuilder$check$2(a r7) {
        super(r7, a.class, "dataCenter", "getDataCenter()Lcom/bytedance/ies/sdk/widgets/DataCenter;", 0);
    }

    public Object get() {
        DataCenter r0 = ((a) ((CallableReference) this).receiver).b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L5:
        return r0;
    }

    public void set(Object r2) {
        DataCenter r3 = (DataCenter) r2;
        ((a) ((CallableReference) this).receiver).b = r3;
    }
}
