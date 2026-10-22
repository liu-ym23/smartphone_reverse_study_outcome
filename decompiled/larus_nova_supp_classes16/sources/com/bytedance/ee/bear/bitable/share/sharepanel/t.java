package com.bytedance.ee.bear.bitable.share.sharepanel;

import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ FormsShareFragmentDelegate a;

    public t(FormsShareFragmentDelegate r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        BitableSharePermission r6 = (BitableSharePermission) r5;
        FormsShareFragmentDelegate r0 = this.a;
        String r2 = r0.o().getToken();
        int r3 = this.a.o().getType();
        Intrinsics.checkNotNull(r6);
        r0.l = new mu4.c(r2, r3, r6);
        this.a.z(r6);
    }
}
