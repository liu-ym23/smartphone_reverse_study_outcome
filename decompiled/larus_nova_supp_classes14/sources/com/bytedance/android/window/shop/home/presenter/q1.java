package com.bytedance.android.window.shop.home.presenter;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q1<T> implements Observer {
    public final /* synthetic */ ECWindowLinkageHeaderLivePresenter a;

    public q1(ECWindowLinkageHeaderLivePresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Pair r7 = (Pair) r6;
        ECWindowLinkageHeaderLivePresenter r8 = this.a;
        Function0<Integer> r0 = r8.s;
        if (r0 == null) goto L7;
        Integer r1 = (Integer) r0.invoke();
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        float r9 = r8.Y(r2);
        if ((!Intrinsics.areEqual(r9, this.a.o)) == true) goto L11;
        return;
    L11:
        if (r9 <= 0.75d) goto L13;
        this.a.y().post(new o1(this));
    L14:
        this.a.o = Float.valueOf(r9);
        return;
    L13:
        this.a.y().post(new p1(this));
    L7:
        r2 = com.bytedance.android.shopping.extensions.b.b(131);
        goto L8
    }
}
