package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ Function0 a;

    public b(Function0 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
        this.a.invoke();
        return;
    }
}
