package com.bytedance.android.shopping.deepfeed;

import android.content.Context;
import androidx.lifecycle.Observer;
import he3.m2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ DeepFeedProductFragment a;

    public d(DeepFeedProductFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        m2 r4 = (m2) r3;
        Context r0 = this.a.getContext();
        if (r0 == null) goto L17;
        if (r4 == null) goto L18;
        String r5 = r4.a();
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L20;
        int r2 = ed3.d.a;
        Intrinsics.checkNotNullParameter(r0, "ctx");
        Intrinsics.checkNotNullParameter(r5, "line1");
        return;
    L20:
        return;
    L10:
        r1 = false;
        goto L11
    L18:
        return;
    }
}
