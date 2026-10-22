package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class e extends d {
    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final int b() {
        return this.f226590e.getHeight() - ((int) this.f226590e.getTranslationY());
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final int c() {
        return b();
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.d
    public final void l(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        float r101 = RangesKt.coerceAtLeast(this.f226590e.getHeight() - r100, 0.0f);
        if (r101 != this.f226590e.getTranslationY()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        this.f226590e.setTranslationY(r101);
        d((int) r100);
        return;
    L8:
        r102 = false;
        goto L9
    }

    public e(Context r100, View r101, float r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "contentView");
        super(r100, r101, 0.0f, r110, r110);
    }
}
