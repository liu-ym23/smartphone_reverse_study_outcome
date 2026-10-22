package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e extends FrameLayout {
    public final long a;
    public final TextView b;
    public final TextView c;
    public final TextView d;

    public final long getEndTime() {
        return this.a;
    }

    public e(Long r3, Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 0);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r4).aU(2131560555, this, true);
        this.b = (TextView) findViewById(2131390757);
        this.c = (TextView) findViewById(2131390956);
        this.d = (TextView) findViewById(2131391371);
        if (r3 == null) goto L5;
        long r5 = r3.longValue();
    L6:
        this.a = r5;
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
