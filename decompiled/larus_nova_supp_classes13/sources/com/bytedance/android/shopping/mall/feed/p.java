package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p extends com.bytedance.android.ec.hybrid.list.ability.p0 {
    public final /* synthetic */ ECMallFeed.n b;

    public final BaseViewHolder n(ViewGroup r17) {
        Intrinsics.checkNotNullParameter(r17, "parent");
        int r1 = HeaderCardViewHolder.t;
        Context r2 = r17.getContext();
        ECMallFeed r4 = this.b.a;
        int r5 = ECMallFeed.I1;
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r3 = new com.bytedance.android.shopping.mall.homepage.card.headercard.a(r2, r4, r4.B());
        Intrinsics.checkNotNullParameter(r17, "container");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        Context r6 = r17.getContext();
        kjc.c r7 = new kjc.c();
        if (5 != kjc.a.a()) goto L25;
        kjc.b r8 = r7.a;
        View r9 = LayoutInflater.from(r6).inflate(2131564677, r17, false);
        int r14 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r15 = com.bytedance.android.ec.hybrid.list.util.c.c(8, r6, true);
        ViewCompat.setPaddingRelative(r9, r15, com.bytedance.android.ec.hybrid.list.util.c.c(4, r6, true), r15, r15);
        View r16 = r9.findViewById(2131372870);
        if (r16 == null) goto L12;
        ViewGroup.LayoutParams r18 = r16.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r18 = null;
    L9:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L12;
        r19.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(5, r6, true);
    L12:
        com.bytedance.android.shopping.api.mall.common.tools.h r110 = com.bytedance.android.shopping.api.mall.common.tools.h.b;
        if (r110.getIHybridHostAppInfo().isLocalTest() == true) goto L17;
        if (r110.getIHybridHostAppInfo().isDebug() == true) goto L17;
    L23:
        r8.a = r9;
        r7.b = true;
    L17:
        if ((r9 instanceof ViewGroup) == true) goto L19;
        View r111 = null;
    L20:
        ViewGroup r112 = (ViewGroup) r111;
        if (r112 == null) goto L23;
        TextView r113 = new TextView(r6);     // Catch: Throwable -> L38
        r113.setText("NA_HEADER");     // Catch: Throwable -> L38
        r113.setTextColor(-1);     // Catch: Throwable -> L38
        r113.setBackgroundColor(Color.parseColor("#88FF3B52"));     // Catch: Throwable -> L38
        r112.addView(r113, new ViewGroup.LayoutParams(-2, -2));     // Catch: Throwable -> L38
        goto L23
    L19:
        r111 = r9;
    L25:
        if (r7.b == true) goto L37;
        kjc.b r10 = r7.a;
        View r0 = LayoutInflater.from(r6).inflate(2131564676, r17, false);
        int r11 = com.bytedance.android.ec.hybrid.list.util.c.a;
        int r12 = com.bytedance.android.ec.hybrid.list.util.c.c(8, r6, true);
        ViewCompat.setPaddingRelative(r0, r12, com.bytedance.android.ec.hybrid.list.util.c.c(4, r6, true), r12, r12);
        View r13 = r0.findViewById(2131372870);
        if (r13 == null) goto L35;
        ViewGroup.LayoutParams r20 = r13.getLayoutParams();
        if ((r20 instanceof ViewGroup.MarginLayoutParams) == true) goto L31;
        ViewGroup.LayoutParams r114 = null;
    L32:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        if (r115 == null) goto L35;
        r115.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(5, r6, true);
        goto L35
    L31:
        r114 = r20;
    L35:
        r10.a = r0;
    L37:
        return new HeaderCardViewHolder((View) r7.a.a, r3);
    }

    public p(ECMallFeed.n r1, Class r2) {
        this.b = r1;
        super(r2);
    }
}
