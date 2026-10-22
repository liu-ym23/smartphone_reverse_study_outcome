package com.bytedance.android.shopping.searchsimilar.utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.searchsimilar.model.SortRuleInfo;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements TabLayout.OnTabSelectedListener {
    public final /* synthetic */ h a;

    public final void onTabUnselected(TabLayout.Tab r1) {
    }

    public i(h r1) {
        this.a = r1;
    }

    public final void onTabReselected(TabLayout.Tab r10) {
        h r0 = this.a;
        r0.getClass();
        if (r10 == null) goto L46;
        int r1 = r10.getPosition();
        List<Integer> r2 = r0.a(r1);
        if (r2 == null) goto L47;
        r0.f++;
        View r11 = r10.getCustomView();
        if (r11 == null) goto L9;
        ImageView r12 = (ImageView) r11.findViewById(2131388023);
    L10:
        int r6 = 0;
        if ((r0.f % 2) != 0) goto L13;
        int r3 = 1;
    L14:
        Integer r7 = (Integer) CollectionsKt.getOrNull(r2, r3);
        if (r7 != null) goto L18;
    L21:
        if (r7 != null) goto L24;
        return;
    L24:
        if (r7.intValue() != 2) goto L48;
        if (r12 == null) goto L27;
        r12.setImageResource(2131233553);
    L27:
        StringBuilder r13 = new StringBuilder();
        SortRuleInfo r4 = (SortRuleInfo) CollectionsKt.getOrNull(r0.b, r1);
        if (r4 == null) goto L32;
        Integer r5 = r4.getSortType();
        if (r5 == null) goto L32;
        int r8 = r5.intValue();
    L33:
        r13.append(r8);
        r13.append("_");
        Integer r9 = (Integer) CollectionsKt.getOrNull(r2, r3);
        if (r9 == null) goto L36;
        r6 = r9.intValue();
    L36:
        r13.append(r6);
        SimilarProductVM r14 = r0.d;
        if (r14 == null) goto L39;
        r14.resetRequestParams(r13.toString());
    L39:
        SimilarProductVM r15 = r0.d;
        if (r15 == null) goto L42;
        r15.clearSimilarProduct();
    L42:
        SimilarProductVM r16 = r0.d;
        if (r16 == null) goto L49;
        r16.loadSimilarProduct();
        Unit r17 = Unit.INSTANCE;
        return;
    L49:
        return;
    L32:
        r8 = 0;
        goto L33
    L48:
        return;
    L18:
        if (r7.intValue() != 1) goto L21;
        if (r12 == null) goto L27;
        r12.setImageResource(2131233552);
        goto L27
    L13:
        r3 = 0;
        goto L14
    L9:
        r12 = null;
        goto L10
    L47:
        return;
    }

    public final void onTabSelected(TabLayout.Tab r11) {
        h r0 = this.a;
        r0.getClass();
        if (r11 == null) goto L65;
        int r1 = r11.getPosition();
        View r12 = r11.getCustomView();
        int r2 = 0;
        if (r12 == null) goto L21;
        TextView r7 = (TextView) r12.findViewById(2131388058);
        int r8 = g1.a;
        r7.setTextColor(g1.a.a(r7.getContext(), 2131105908));
        r7.setTypeface(null, 1);
        ImageView r13 = (ImageView) r12.findViewById(2131388023);
        List<Integer> r9 = r0.a(r1);
        if (r9 == null) goto L9;
        Integer r10 = (Integer) CollectionsKt.firstOrNull(r9);
    L10:
        if (r10 != null) goto L13;
    L15:
        if (r10 != null) goto L18;
    L20:
        r13.setVisibility(8);
        goto L21
    L18:
        if (r10.intValue() != 2) goto L20;
        r13.setVisibility(0);
        r13.setImageResource(2131233553);
        goto L21
    L13:
        if (r10.intValue() != 1) goto L15;
        r13.setVisibility(0);
        r13.setImageResource(2131233552);
        goto L21
    L9:
        r10 = null;
    L21:
        TabLayout r14 = r0.c;
        if (r14 != null) goto L24;
    L25:
        TabLayout r15 = r0.c;
        if (r15 == null) goto L40;
        Intrinsics.checkNotNull(r15);
        int r16 = r15.getTabCount();
        int r17 = r0.e;
        if (r17 < 0) goto L40;
        if (r16 <= r17) goto L40;
        TabLayout r18 = r0.c;
        if (r18 == null) goto L40;
        TabLayout.Tab r19 = r18.getTabAt(r17);
        if (r19 == null) goto L40;
        View r110 = r19.getCustomView();
        if (r110 == null) goto L40;
        TextView r4 = (TextView) r110.findViewById(2131388058);
        int r20 = g1.a;
        r4.setTextColor(g1.a.a(r4.getContext(), 2131105982));
        r4.setTypeface(null, 0);
        ImageView r111 = (ImageView) r110.findViewById(2131388023);
        if (r111.getVisibility() != 0) goto L40;
        r111.setImageResource(2131233551);
    L40:
        r0.e = r1;
        if (r0.a == false) goto L43;
        r0.a = false;
    L63:
        r0.f = 1;
        return;
    L43:
        StringBuilder r112 = new StringBuilder();
        SortRuleInfo r3 = (SortRuleInfo) CollectionsKt.getOrNull(r0.b, r1);
        if (r3 == null) goto L48;
        Integer r5 = r3.getSortType();
        if (r5 == null) goto L48;
        int r6 = r5.intValue();
    L49:
        r112.append(r6);
        r112.append("_");
        List<Integer> r21 = r0.a(r1);
        if (r21 == null) goto L54;
        Integer r22 = (Integer) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L54;
        r2 = r22.intValue();
    L54:
        r112.append(r2);
        SimilarProductVM r23 = r0.d;
        if (r23 == null) goto L57;
        r23.resetRequestParams(r112.toString());
    L57:
        SimilarProductVM r113 = r0.d;
        if (r113 == null) goto L60;
        r113.clearSimilarProduct();
    L60:
        SimilarProductVM r114 = r0.d;
        if (r114 == null) goto L63;
        r114.loadSimilarProduct();
    L48:
        r6 = 0;
        goto L49
    L24:
        if (r14.getTabCount() == 0) goto L40;
    }
}
