package com.bytedance.ee.bear.lark;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ BaseHeaderFragment a;

    public a(BaseHeaderFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        tt5.a.h(this.a.getLogTag(), "secondNodeWidth: " + r6);
        boolean r2 = true;
        boolean r3 = false;
        if (r6.intValue() >= this.a.j) goto L8;
        r2 = false;
        if (r6.intValue() >= this.a.k) goto L8;
        r3 = true;
    L8:
        BaseHeaderFragment r7 = this.a;
        if (r2 == r7.l) goto L11;
    L13:
        r7.l = r2;
        r7.m = r3;
        if (r7.getView() == null) goto L17;
        BaseHeaderFragment r8 = this.a;
        View r0 = r8.getView();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        r8.Z90((ViewGroup) r0);
        return;
    L17:
        return;
    L11:
        if (r3 != r7.m) goto L13;
    }
}
