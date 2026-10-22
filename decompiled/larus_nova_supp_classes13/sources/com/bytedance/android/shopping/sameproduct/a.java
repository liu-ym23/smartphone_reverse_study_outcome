package com.bytedance.android.shopping.sameproduct;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import com.bytedance.android.shopping.feed.adapter.QuickDividerItemDecoration;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements QuickDividerItemDecoration.a {
    public final int a;
    public final int b;

    public a() {
        Resources r1 = Resources.getSystem();
        this.a = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        Resources r2 = Resources.getSystem();
        this.b = MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
    }

    @Override // com.bytedance.android.shopping.feed.adapter.QuickDividerItemDecoration.a
    public final void a(Rect r3, QuickDividerItemDecoration.b r4) {
        Intrinsics.checkNotNullParameter(r3, "outRect");
        if (r4 != null) goto L5;
        return;
    L5:
        int r5 = r4.c;
        if (r5 != 0) goto L8;
        int r6 = this.a;
        r3.set(r6, 0, r6, 0);
        return;
    L8:
        if (r5 == 1) goto L10;
        int r7 = this.a;
        r3.set(r7, 0, r7, this.b);
        return;
    L10:
        int r8 = this.a;
        r3.set(r8, 0, r8, r8);
    }
}
