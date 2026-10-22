package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {
    public final Lazy a;
    public final LivePromotionCardArgsV2 b;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "coupon_group_widget";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
    }

    public g(Context r3, LivePromotionCardArgsV2 r4, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "argument");
        super(r3, null, 0);
        this.b = r4;
        this.c = r5;
        this.a = LazyKt.lazy(ECLabelGroupWidget$isUseNewView$2.INSTANCE);
        int r6 = com.bytedance.android.ec.core.utils.a.a;
        Intrinsics.checkNotNullParameter(this, "view");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        setImportantForAccessibility(4);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = getChildCount() - 1;
    L3:
        if (r7 < 0) goto L13;
        View r8 = getChildAt(r7);
        if (r8 == null) goto L12;
        if (r8.getVisibility() == 8) goto L12;
        if ((r8.getLeft() + r8.getMeasuredWidth()) < getMeasuredWidth()) goto L19;
        r8.layout(r8.getLeft(), r8.getTop(), r8.getLeft(), r8.getBottom());
        goto L12
    L19:
        return;
    L12:
        r7 = r7 - 1;
        goto L3
    }
}
