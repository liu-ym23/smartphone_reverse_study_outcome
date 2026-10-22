package com.bytedance.android.shopping.mall.feed;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.feed.holder.ECMallFeedTitleViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;

    public final BaseViewHolder n(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        boolean r1 = this.b.a.A1.isDarkMode();
        int r2 = ECMallFeedTitleViewHolder.o;
        com.bytedance.android.shopping.api.mall.feed.i r3 = this.b.a.B1.A;
        Intrinsics.checkNotNullParameter(r6, "parent");
        TextView r0 = new TextView(r6.getContext());
        r0.setIncludeFontPadding(false);
        if (r1 == false) goto L5;
        long r4 = 4294967295L;
    L6:
        int r5 = (int) r4;
        if (r3 == null) goto L11;
        Integer r7 = r3.a;
        if (r7 == null) goto L11;
        r5 = r7.intValue();
    L11:
        r0.setTextColor(r5);
        if (r3 == null) goto L16;
        Float r8 = r3.b;
        if (r8 == null) goto L16;
        float r9 = r8.floatValue();
    L17:
        r0.setTextSize(1, r9);
        if (r3 == null) goto L20;
        List<Integer> r10 = r3.c;
    L21:
        if (r10 == null) goto L31;
        List<Integer> r11 = r3.c;
        if (r11 == null) goto L25;
        int r12 = r11.size();
    L27:
        if (r12 < 4) goto L31;
        List<Integer> r13 = r3.c;
        if (r13 == null) goto L33;
        r0.setPadding(com.bytedance.android.shopping.api.mall.common.tools.b0.c((Number) ListProtector.get(r13, 0)), com.bytedance.android.shopping.api.mall.common.tools.b0.c((Number) ListProtector.get(r13, 1)), com.bytedance.android.shopping.api.mall.common.tools.b0.c((Number) ListProtector.get(r13, 2)), com.bytedance.android.shopping.api.mall.common.tools.b0.c((Number) ListProtector.get(r13, 3)));
    L33:
        return new ECMallFeedTitleViewHolder(r0);
    L25:
        r12 = 0;
    L31:
        r0.setPadding(com.bytedance.android.shopping.api.mall.common.tools.b0.c(12), com.bytedance.android.shopping.api.mall.common.tools.b0.c(20), com.bytedance.android.shopping.api.mall.common.tools.b0.c(12), com.bytedance.android.shopping.api.mall.common.tools.b0.c(12));
        goto L33
    L20:
        r10 = null;
    L16:
        r9 = 16.0f;
        goto L17
    L5:
        r4 = 4279638051L;
        goto L6
    }

    public t(ECMallFeed.n r1, Class r2) {
        this.b = r1;
        super(r2);
    }
}
