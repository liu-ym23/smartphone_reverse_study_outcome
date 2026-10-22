package com.bytedance.android.window.shop.home.tab.presenter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.window.shop.holder.WindowLynxHolder;
import com.bytedance.android.window.shop.product.presenter.lynxCard.ECLynxCardPresenter;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.widget.ECShopRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c0 {
    public static final int[] a = null;

    static {
        a = new int[]{0, 0};
    }

    public static final Object c(ECHybridListItemVO r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getPreparedItemData");
        Object r2 = r1.d();
        if ((r2 instanceof mp3.c) == true) goto L5;
        return r2;
    L5:
        return ((mp3.c) r2).a();
    }

    public static final List<ECWindowLynxMonitorHolder> d(ECHybridRecyclerView r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$getVisibleHybridLynxHolders");
        VirtualLayoutManager r0 = r5.getLayoutManager();
        if (r0 == null) goto L5;
        int r1 = r0.findFirstVisibleItemPosition();
        int r2 = r0.findLastVisibleItemPosition();
        if (r1 < 0) goto L23;
        if (r2 < r1) goto L23;
        ArrayList r3 = new ArrayList();
        if (r1 > r2) goto L21;
    L12:
        RecyclerView.ViewHolder r4 = r5.findViewHolderForAdapterPosition(r1);
        if ((r4 instanceof ECWindowLynxMonitorHolder) == true) goto L15;
        r4 = null;
    L15:
        ECWindowLynxMonitorHolder r6 = (ECWindowLynxMonitorHolder) r4;
        if (r6 == null) goto L19;
        r3.add(r6);
    L19:
        if (r1 == r2) goto L21;
        r1 = r1 + 1;
    L21:
        return r3;
    L23:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public static final List<ECLynxCard> e(ECShopRecyclerView r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$getVisibleLynxCards");
        StaggeredGridLayoutManager r0 = r5.m965getLayoutManager();
        if (r0 == null) goto L5;
        int[] r1 = a;
        Integer r2 = ArraysKt.minOrNull(r0.findFirstVisibleItemPositions(r1));
        if (r2 == null) goto L33;
        int r3 = r2.intValue();
        Integer r4 = ArraysKt.maxOrNull(r0.findLastVisibleItemPositions(r1));
        if (r4 == null) goto L31;
        int r6 = r4.intValue();
        if (r3 < 0) goto L29;
        if (r6 < r3) goto L29;
        ArrayList r7 = new ArrayList();
        if (r3 > r6) goto L27;
    L16:
        RecyclerView.ViewHolder r8 = r5.findViewHolderForAdapterPosition(r3);
        if ((r8 instanceof WindowLynxHolder) == true) goto L19;
        r8 = null;
    L19:
        WindowLynxHolder r9 = (WindowLynxHolder) r8;
        if (r9 == null) goto L25;
        ECLynxCard r10 = ((ECLynxCardPresenter) r9.y.getValue()).G();
        if (r10 == null) goto L25;
        r7.add(r10);
    L25:
        if (r3 == r6) goto L27;
        r3 = r3 + 1;
    L27:
        return r7;
    L29:
        return CollectionsKt.emptyList();
    L31:
        return CollectionsKt.emptyList();
    L33:
        return CollectionsKt.emptyList();
    L5:
        return CollectionsKt.emptyList();
    }

    public static final boolean f(com.bytedance.android.ec.hybrid.list.entity.k r3) {
        if (r3 == null) goto L38;
        ArrayList r1 = r3.c;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L39;
        ArrayList r4 = r3.c;
        if (r4 != null) goto L15;
    L31:
        return false;
    L15:
        if (r4.isEmpty() == false) goto L17;
    L16:
        boolean r5 = true;
    L29:
        if (r5 != true) goto L31;
        return true;
    L17:
        Iterator r6 = r4.iterator();
    L19:
        if (r6.hasNext() == false) goto L16;
        ArrayList r7 = ((com.bytedance.android.ec.hybrid.list.entity.i) r6.next()).i;
        if (r7 != null) goto L23;
    L26:
        boolean r8 = true;
    L27:
        if (r8 == true) goto L19;
        r5 = false;
        goto L29
    L23:
        if (r7.isEmpty() == true) goto L26;
        r8 = false;
        goto L27
    L39:
        return true;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
        goto L11
    L38:
        return true;
    }

    public static final void a(com.bytedance.android.ec.hybrid.list.entity.k r7, final boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$ensureColumnsRightInWindow");
        ArrayList r0 = r7.c;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L45;
        com.bytedance.android.ec.hybrid.list.entity.i r2 = (com.bytedance.android.ec.hybrid.list.entity.i) r1.next();
        ArrayList r3 = r2.i;
        if (r3 == null) goto L7;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L7;
        ECHybridListItemVO r5 = (ECHybridListItemVO) r4.next();
        Integer r6 = r5.c;
        if (r6 == null) goto L12;
        int r9 = r6.intValue();
        IntRange r10 = com.bytedance.android.window.shop.repository.tab.datasource.mapping.g.a;
        ECHybridListItemType.Companion.getClass();
        if (ECHybridListItemType.a.a(r9) == true) goto L17;
        Set<Integer> r11 = com.bytedance.android.window.shop.holder.factory.d.a;
        Integer r12 = r5.c;
        if (r12 != null) goto L39;
        boolean r13 = false;
    L40:
        if (r13 == false) goto L12;
        if (r8 == false) goto L43;
        int r14 = r2.f;
    L44:
        r5.a = Integer.valueOf(RangesKt.coerceAtLeast(r14, 1));
        goto L12
    L43:
        r14 = r2.f / 2;
        goto L44
    L39:
        r13 = com.bytedance.android.window.shop.holder.factory.d.b.contains(r12);
        goto L40
    L17:
        HashMap r15 = r7.b;
        if (r15 == null) goto L12;
        com.bytedance.android.ec.hybrid.list.entity.k.a r16 = (com.bytedance.android.ec.hybrid.list.entity.k.a) r15.get(String.valueOf(r9));
        if (r16 == null) goto L12;
        com.bytedance.android.ec.hybrid.list.entity.f r17 = r16.a;
        if (r17 == null) goto L12;
        if (r17.c != true) goto L12;
        if (r8 == false) goto L28;
        int r18 = r2.f;
    L29:
        r5.a = Integer.valueOf(RangesKt.coerceAtLeast(r18, 1));
        Object r19 = r5.d();
        String r20 = null;
        if ((r19 instanceof String) == true) goto L32;
        r19 = null;
    L32:
        String r21 = (String) r19;
        if (r21 == null) goto L35;
        r20 = com.bytedance.android.shopping.extensions.k.a(r21, new WindowRecyclerViewExtKt$updateLynxLayout$newItemData$1(r8));
    L35:
        r5.o(r20);
        goto L12
    L28:
        r18 = r2.f / 2;
        goto L29
    }

    public static final void b(com.bytedance.android.ec.hybrid.list.entity.k r3, WindowLayoutType r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$ensureToolbarRight");
        Intrinsics.checkNotNullParameter(r4, "layoutType");
        ArrayList r5 = r3.c;
        if (r5 == null) goto L21;
        Iterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L33;
        ArrayList r0 = ((com.bytedance.android.ec.hybrid.list.entity.i) r6.next()).i;
        if (r0 == null) goto L6;
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L6;
        Object r2 = ((ECHybridListItemVO) r1.next()).d();
        if ((r2 instanceof com.bytedance.android.window.shop.repository.tab.entity.q) == true) goto L15;
        r2 = null;
    L15:
        com.bytedance.android.window.shop.repository.tab.entity.q r7 = (com.bytedance.android.window.shop.repository.tab.entity.q) r2;
        if (r7 == null) goto L11;
        e0 r8 = r7.j;
        if (r8 == null) goto L11;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r8.k = r4;
        goto L11
    L33:
        return;
    }

    public static final com.bytedance.android.ec.hybrid.list.entity.k g(com.bytedance.android.ec.hybrid.list.entity.k r2, List<com.bytedance.android.ec.hybrid.list.entity.i> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$makeHybridListVO");
        com.bytedance.android.ec.hybrid.list.entity.k r0 = new com.bytedance.android.ec.hybrid.list.entity.k();
        ArrayList r1 = new ArrayList();
        if (r3 == null) goto L5;
        r1.addAll(r3);
    L5:
        Unit r4 = Unit.INSTANCE;
        r0.c = r1;
        r0.b = r2.b;
        r0.a = r2.a;
        return r0;
    }

    public static final com.bytedance.android.ec.hybrid.list.entity.i i(String r5, Double r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (Intrinsics.areEqual(r6, 0.0d) == true) goto L10;
        ECHybridListItemVO r0 = new ECHybridListItemVO();
        r0.a = 1;
        r0.d = r5 + "_0";
        r0.c = Integer.valueOf(gr3.f.a(998));
        r0.o(new oq3.f(r6.doubleValue()));
        com.bytedance.android.ec.hybrid.list.entity.i r7 = new com.bytedance.android.ec.hybrid.list.entity.i();
        r7.i = CollectionsKt.arrayListOf(new ECHybridListItemVO[]{r0});
        r7.a = r5;
        r7.f = 1;
        return r7;
    L10:
        return null;
    }

    public static final void j(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$updateHorizontalMargin");
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L10;
        r1.leftMargin = r3;
        r1.rightMargin = r3;
        r1.setMarginStart(r3);
        r1.setMarginEnd(r3);
        r2.setLayoutParams(r1);
        return;
    }

    public static final ECHybridListItemVO h(String r2, Double r3, int r4) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (Intrinsics.areEqual(r3, 0.0d) == true) goto L10;
        ECHybridListItemVO r0 = new ECHybridListItemVO();
        r0.a = Integer.valueOf(r4);
        r0.d = r2;
        r0.c = Integer.valueOf(gr3.f.a(998));
        r0.o(new oq3.f(r3.doubleValue()));
        return r0;
    L10:
        return null;
    }

    public static final void k(com.bytedance.android.ec.hybrid.list.entity.k r5, WindowLayoutType r6, com.bytedance.android.window.shop.repository.tab.entity.q r7) {
        Intrinsics.checkNotNullParameter(r5, "$this$updateSectionStyle");
        Intrinsics.checkNotNullParameter(r6, "layoutType");
        if (r7 != null) goto L5;
        return;
    L5:
        Map<String, ? extends Map<WindowLayoutType, com.bytedance.android.ec.hybrid.list.entity.j>> r8 = r7.k;
        if (r8 != null) goto L8;
        return;
    L8:
        Iterator<Map.Entry<String, ? extends Map<WindowLayoutType, com.bytedance.android.ec.hybrid.list.entity.j>>> r9 = r8.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L26;
        Map.Entry<String, ? extends Map<WindowLayoutType, com.bytedance.android.ec.hybrid.list.entity.j>> r0 = r9.next();
        String r1 = r0.getKey();
        com.bytedance.android.ec.hybrid.list.entity.j r2 = r0.getValue().get(r6);
        if (r2 == null) goto L10;
        ArrayList r3 = r5.c;
        if (r3 == null) goto L10;
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L22;
        Object r10 = r4.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.hybrid.list.entity.i) r10).a, r1) == false) goto L18;
    L23:
        com.bytedance.android.ec.hybrid.list.entity.i r11 = (com.bytedance.android.ec.hybrid.list.entity.i) r10;
        if (r11 == null) goto L10;
        r11.h = r2;
        goto L10
    L22:
        r10 = null;
        goto L23
    }
}
