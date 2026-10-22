package com.ss.android.ugc.aweme.search.common.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterContainerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"trade-search-impl_release"}, k = 2, mv = {1, 4, 3})
public final class ViewExtKt {
    public static final List<View> a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof ViewGroup) == false) goto L10;
        ViewGroup r101 = (ViewGroup) r100;
        IntRange r102 = RangesKt.until(0, r101.getChildCount());
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<Integer> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L12;
        r103.add(r101.getChildAt(((IntIterator) r104).nextInt()));
        goto L6
    L12:
        return CollectionsKt.toList(r103);
    L10:
        return CollectionsKt.emptyList();
    }

    public static final int b(View r100) {
        ViewGroup.MarginLayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r101 = (ViewGroup.MarginLayoutParams) r102;
    L9:
        if (r101 != null) goto L13;
        return 0;
    L13:
        return r101.leftMargin;
    L5:
        r102 = null;
        goto L7
    }

    public static final int[] c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        return r101;
    }

    public static final int d(View r100) {
        ViewGroup.MarginLayoutParams r101 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L7:
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r101 = (ViewGroup.MarginLayoutParams) r102;
    L9:
        if (r101 != null) goto L13;
        return 0;
    L13:
        return r101.rightMargin;
    L5:
        r102 = null;
        goto L7
    }

    public static final void e(View r100) {
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    public static final void q(View r100) {
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    public static final void f(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L7;
        return;
    L7:
        r102.height = r101;
        r100.setLayoutParams(r102);
    }

    public static final void g(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L6;
        ((FrameLayout.LayoutParams) r102).gravity = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void h(ECSearchFilterContainerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.height = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void i(ECSearchFilterContainerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public static final void j(View r100, int r101) {
        ViewGroup.MarginLayoutParams r102 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
    L7:
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r102 = (ViewGroup.MarginLayoutParams) r103;
    L9:
        if (r102 == null) goto L13;
        r102.leftMargin = r101;
        return;
    L13:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static final void m(View r100, int r101) {
        ViewGroup.MarginLayoutParams r102 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
    L7:
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r102 = (ViewGroup.MarginLayoutParams) r103;
    L9:
        if (r102 == null) goto L13;
        r102.setMarginStart(r101);
        return;
    L13:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static final void n(View r100, int r101) {
        ViewGroup.MarginLayoutParams r102 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
    L7:
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        r102 = (ViewGroup.MarginLayoutParams) r103;
    L9:
        if (r102 == null) goto L13;
        r102.rightMargin = r101;
        return;
    L13:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static void o(View r100, final int r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        final boolean r101 = true;
    L7:
        if ((r111 & 8) == 0) goto L9;
        final boolean r102 = true;
    L11:
        if ((r111 & 16) == 0) goto L13;
        final boolean r103 = true;
    L15:
        if ((r111 & 32) == 0) goto L17;
        final boolean r104 = true;
    L18:
        Intrinsics.checkNotNullParameter(r100, "itemView");
        r100.setOutlineProvider(new ViewExtKt$setRoundCorner$1(r110, r101, r104, r102, r103));
        r100.setClipToOutline(true);
        return;
    L17:
        r104 = false;
        goto L18
    L13:
        r103 = false;
        goto L15
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L7
    }

    public static final void p(View r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r101 == (-3)) goto L7;
        r103.width = r101;
    L7:
        if (r102 == (-3)) goto L9;
        r103.height = r102;
    L9:
        r100.setLayoutParams(r103);
    }

    public static final void k(View r100, int r101, int r102, int r103, int r104) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L8:
        if (r106 != null) goto L10;
        return;
    L10:
        if (r101 < 0) goto L12;
        r106.leftMargin = r101;
        r106.setMarginStart(r101);
    L12:
        if (r102 < 0) goto L14;
        r106.topMargin = r102;
    L14:
        if (r103 < 0) goto L16;
        r106.rightMargin = r103;
        r106.setMarginEnd(r103);
    L16:
        if (r104 < 0) goto L18;
        r106.bottomMargin = r104;
    L18:
        r100.setLayoutParams(r106);
        return;
    L7:
        r106 = null;
        goto L8
    }

    public static /* synthetic */ void l(View r100, int r101, int r102, int r103, int r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = -1;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = -1;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = -1;
    L14:
        k(r100, r101, r102, r103, r104);
    }
}
