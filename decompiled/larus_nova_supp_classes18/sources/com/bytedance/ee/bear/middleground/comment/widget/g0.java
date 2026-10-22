package com.bytedance.ee.bear.middleground.comment.widget;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 extends db5.i<db5.a> {
    public g0(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        super(r2, null, null);
    }

    public final un5.h h(db5.a r11, db5.j r12) {
        Intrinsics.checkNotNullParameter(r11, "atContent");
        Intrinsics.checkNotNullParameter(r12, "link");
        return new un5.k(((db5.i) this).a, "fake_token", 999, null, r12.d, null, null, null, ((db5.i) this).c);
    }
}
