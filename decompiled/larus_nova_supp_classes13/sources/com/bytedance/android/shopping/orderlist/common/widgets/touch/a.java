package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.content.Context;
import android.view.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final int a;
    public float b;
    public float c;
    public float d;
    public float e;

    public final boolean a() {
        float r0 = Math.abs(this.d - this.b);
        float r1 = Math.abs(this.e - this.c);
        if (r0 > this.a) goto L5;
    L7:
        return false;
    L5:
        if (r0 <= r1) goto L7;
        return true;
    }

    public final boolean b() {
        float r0 = Math.abs(this.d - this.b);
        float r1 = Math.abs(this.e - this.c);
        if (r1 > this.a) goto L5;
    L7:
        return false;
    L5:
        if (r1 <= r0) goto L7;
        return true;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = ViewConfiguration.get(r2).getScaledTouchSlop();
    }
}
