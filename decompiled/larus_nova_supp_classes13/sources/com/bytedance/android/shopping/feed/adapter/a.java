package com.bytedance.android.shopping.feed.adapter;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ld3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements QuickDividerItemDecoration.a {
    public final int a;
    public final int b;
    public final boolean c;
    public final ProductFeedAdapter d;
    public final ProductFeedViewModel e;

    public a(ProductFeedAdapter r3, ProductFeedViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "productViewModel");
        this.d = r3;
        this.e = r4;
        Resources r5 = Resources.getSystem();
        this.a = MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
        Resources r6 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        Resources r7 = Resources.getSystem();
        this.b = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 4.5d, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())));
        this.c = d.e(d.b());
    }

    @Override // com.bytedance.android.shopping.feed.adapter.QuickDividerItemDecoration.a
    public final void a(Rect r7, QuickDividerItemDecoration.b r8) {
        Intrinsics.checkNotNullParameter(r7, "outRect");
        if (r8 != null) goto L5;
        return;
    L5:
        int r0 = this.e.getHeaderList().size();
        int r1 = this.e.getFirstLoadGuessULikeResourceCardList().size();
        int r2 = r0 + r1;
        int r3 = r8.c;
        if (r3 != r2) goto L9;
        int r9 = this.a;
        r7.set(r9, 0, r9, 0);
        return;
    L9:
        if (r3 == (r0 - 1)) goto L11;
        if (r1 <= 0) goto L22;
        if (r3 < r0) goto L22;
        if (r3 >= r2) goto L22;
        if (this.c == false) goto L20;
        r7.set(0, this.a, 0, 0);
        return;
    L20:
        int r10 = this.a;
        r7.set(r10, r10, r10, 0);
        return;
    L22:
        if (this.e.getTopicCardShowPosition() <= 0) goto L27;
        if (r8.c != (this.e.getTopicCardShowPosition() + 1)) goto L27;
        int r11 = this.a;
        r7.set(r11, 0, 0, r11);
        return;
    L27:
        if (this.d.y != 2) goto L33;
        if ((r8.c % 2) != 0) goto L31;
        int r12 = this.a;
        r7.set(r12, 0, this.b, r12);
        return;
    L31:
        int r13 = this.b;
        int r4 = this.a;
        r7.set(r13, 0, r4, r4);
        return;
    L33:
        if (this.c == false) goto L35;
        r7.set(0, 0, 0, this.a);
        return;
    L35:
        int r14 = this.a;
        r7.set(r14, 0, r14, r14);
        return;
    L11:
        if (this.c == false) goto L13;
        r7.set(0, 0, 0, 0);
        return;
    L13:
        int r15 = this.a;
        r7.set(r15, 0, r15, 0);
    }
}
