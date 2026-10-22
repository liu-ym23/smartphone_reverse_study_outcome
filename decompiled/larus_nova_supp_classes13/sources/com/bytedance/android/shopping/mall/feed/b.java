package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements com.bytedance.android.ec.hybrid.list.ability.e0 {
    public final /* synthetic */ ECMallFeed.a a;

    public b(ECMallFeed.a r1) {
        this.a = r1;
    }

    public final boolean b(final zj.a r11) {
        Intrinsics.checkNotNullParameter(r11, "scrollData");
        final ECMallFeed r0 = this.a.b;
        ECHybridListEngine r1 = r0.J;
        if (r1 == null) goto L100;
        com.bytedance.android.ec.hybrid.list.entity.k r3 = r1.c.g;
        if (r3 == null) goto L95;
        ArrayList r4 = r3.c;
        if (r4 == null) goto L96;
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r6).a, r11.a) == false) goto L11;
    L16:
        com.bytedance.android.ec.hybrid.list.entity.i r7 = (com.bytedance.android.ec.hybrid.list.entity.i) r6;
        if (r7 == null) goto L101;
        String r8 = r11.b;
        if (r8 == null) goto L22;
    L24:
        if (r8 != null) goto L32;
        ArrayList r9 = r7.i;
        if (r9 == null) goto L97;
        Integer r10 = r11.c;
        Intrinsics.checkNotNull(r10);
        ECHybridListItemVO r12 = (ECHybridListItemVO) CollectionsKt.getOrNull(r9, r10.intValue());
        if (r12 == null) goto L98;
        r8 = r12.d;
        if (r8 != null) goto L32;
        return false;
    L98:
        return false;
    L97:
        return false;
    L32:
        BaseViewHolder r13 = r1.f(r11.a, r8);
        final Ref.IntRef r14 = new Ref.IntRef();
        r14.element = r11.d;
        if (r13 == null) goto L37;
        ECHybridListItemVO r15 = r13.c;
        if (r15 == null) goto L37;
        String r16 = r15.r;
    L39:
        if (Intrinsics.areEqual(r16, "favorite_section") == false) goto L41;
        r14.element -= r0.k();
    L41:
        Logger.i("cailx", "scroll offset is " + r14.element);
        if (r13 == null) goto L44;
        Integer r17 = Integer.valueOf(r13.getLayoutPosition());
    L45:
        if (r17 == null) goto L99;
        int r18 = r17.intValue();
        final Context r19 = r0.e0();
        LinearSmoothScroller r20 = new ECMallFeed$scrollToItem$smoothScroller$1(r0, r11, r14, r19);
        r20.setTargetPosition(r18);
        r0.C0.setValue(Boolean.TRUE);
        if (r11.e == false) goto L52;
        VirtualLayoutManager r110 = r1.b.getLayoutManager();
        if (r110 == null) goto L87;
        r110.startSmoothScroll(r20);
    L87:
        return true;
    L52:
        if (r11.f == false) goto L84;
        if (r13 == null) goto L87;
        View r2 = ((RecyclerView.ViewHolder) r13).itemView;
        if (r2 == null) goto L87;
        float r21 = r2.getY();
        String r111 = r11.b;
        if (r111 == null) goto L87;
        int r22 = ((int) r21) + r14.element;
        ECHybridListEngine r23 = r0.J;
        if (r23 == null) goto L74;
        Intrinsics.checkNotNullParameter(r111, "itemId");
        List r24 = r23.c.j();
        if (r24 == null) goto L72;
        ArrayList r25 = (ArrayList) r24;
        Iterator r26 = r25.iterator();
    L64:
        if (r26.hasNext() == false) goto L68;
        Object r27 = r26.next();
        if (Intrinsics.areEqual(((ECHybridListItemVO) r27).d, r111) == false) goto L64;
    L69:
        ECHybridListItemVO r28 = (ECHybridListItemVO) r27;
        if (r28 == null) goto L72;
        int r112 = r25.size() - r25.indexOf(r28);
    L73:
        Integer r113 = Integer.valueOf(r112);
    L76:
        if (CollectionsKt.contains(new IntRange(0, 4), r113) == false) goto L78;
        r0.x1 = new x(r0, r22);
        goto L87
    L78:
        ECHybridListEngine r114 = r0.J;
        if (r114 == null) goto L83;
        ECHybridRecyclerView r115 = r114.b;
        if (r115 == null) goto L83;
        r115.scrollBy(0, r22);
    L83:
        r0.x1 = null;
        goto L87
    L68:
        r27 = null;
    L72:
        r112 = -1;
        goto L73
    L74:
        r113 = null;
        goto L76
    L84:
        VirtualLayoutManager r116 = r1.b.getLayoutManager();
        if (r116 == null) goto L87;
        r116.scrollToPositionWithOffset(r18, -r14.element);
        goto L87
    L99:
        return false;
    L44:
        r17 = r1.d(r11.a, r8);
    L37:
        r16 = null;
        goto L39
    L22:
        if (r11.c != null) goto L24;
        return false;
    L101:
        return false;
    L15:
        r6 = null;
        goto L16
    L96:
        return false;
    L95:
        return false;
    L100:
        return false;
    }

    public final boolean a(String r8, int r9, boolean r10, zj.b r11) {
        Intrinsics.checkNotNullParameter(r8, "sectionId");
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.l() == true) goto L5;
    L11:
        String r1 = r8;
        int r2 = r9;
    L13:
        return ECMallFeed.h0(this.a.b, r1, r2, r10, 0.0f, r11, 8);
    L5:
        if ((!this.a.b.V.f.isEmpty()) == false) goto L11;
        if (Intrinsics.areEqual(r8, "favorite_section") == false) goto L11;
        r8 = "category_tab_section";
        if (r9 != 0) goto L11;
        r1 = "category_tab_section";
        r2 = 10;
        goto L13
    }
}
