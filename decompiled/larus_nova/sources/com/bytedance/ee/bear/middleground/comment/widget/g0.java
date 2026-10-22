package com.bytedance.ee.bear.middleground.comment.widget;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g0 extends db5.i<db5.a> {
    public g0(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        super(r100, null, null);
    }

    @Override // db5.i
    public final un5.h h(db5.a r110, db5.j r111) {
        Intrinsics.checkNotNullParameter(r110, "atContent");
        Intrinsics.checkNotNullParameter(r111, "link");
        return new un5.k(this.f467820a, "fake_token", 999, null, r111.f467829d, null, null, null, this.f467822c);
    }
}
