package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends d {
    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final int b() {
        return this.e.getHeight() - ((int) this.e.getTranslationY());
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final int c() {
        return b();
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final void l(float r3) {
        if (r3 >= 0.0f) goto L5;
        return;
    L5:
        float r0 = RangesKt.coerceAtLeast(this.e.getHeight() - r3, 0.0f);
        if (r0 != this.e.getTranslationY()) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        this.e.setTranslationY(r0);
        d((int) r3);
        return;
    L8:
        r1 = false;
        goto L9
    }

    public e(Context r8, View r9, float r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "contentView");
        super(r8, r9, 0.0f, r10, r10);
    }
}
