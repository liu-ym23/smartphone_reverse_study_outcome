package com.bytedance.locallife.live.goodsshelves.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/PriorityWholeChildLayout;", "Landroid/view/ViewGroup;", "", "orientation", "", "setOrientation", "getOrientation", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "setOverflowStrategy", "getOverflowStrategy", "maxCount", "setMaxCount", "getMaxCount", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PWCLayoutParams", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PriorityWholeChildLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f260272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f260273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f260274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f260275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f260276e;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/view/PriorityWholeChildLayout$PWCLayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class PWCLayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f260277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f260278b;

        public PWCLayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            if ((r100 instanceof PWCLayoutParams) == false) goto L6;
            PWCLayoutParams r101 = (PWCLayoutParams) r100;
            this.f260277a = r101.f260277a;
            this.f260278b = r101.f260278b;
            return;
        }

        public PWCLayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101);
            if (r101 == null) goto L6;
            com.bytedance.locallife.live.util.a.b(r100, r101, new int[]{R.attr.layout_baseline_anchor, R.attr.layout_priority}, new PriorityWholeChildLayout$PWCLayoutParams$1$1(this));
            return;
        }

        public PWCLayoutParams(int r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PriorityWholeChildLayout f260279a;

        public b(PriorityWholeChildLayout r100) {
            this.f260279a = r100;
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            View r102 = this.f260279a.getChildAt(((Integer) r100).intValue());
            View r103 = this.f260279a.getChildAt(((Integer) r101).intValue());
            ViewGroup.LayoutParams r104 = r102.getLayoutParams();
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.view.PriorityWholeChildLayout.PWCLayoutParams");
            ViewGroup.LayoutParams r105 = r103.getLayoutParams();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.view.PriorityWholeChildLayout.PWCLayoutParams");
            return Intrinsics.compare(((PWCLayoutParams) r104).f260277a, ((PWCLayoutParams) r105).f260277a);
        }
    }

    static {
    }

    public PriorityWholeChildLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PriorityWholeChildLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new PWCLayoutParams(-2, -2);
    }

    public final ArrayList<Integer> a() {
        int r100 = getChildCount();
        ArrayList<Integer> r101 = new ArrayList(r100);
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L8;
        if (getChildAt(r102).getVisibility() == 8) goto L7;
        r101.add(Integer.valueOf(r102));
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        Collections.sort(r101, new b(this));
        return r101;
    }

    public final int getMaxCount() {
        return this.f260273b;
    }

    public final int getOrientation() {
        return this.f260272a;
    }

    public final int getOverflowStrategy() {
        return this.f260274c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof PWCLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new PWCLayoutParams(getContext(), r100);
    }

    public final void setMaxCount(int r100) {
        if (this.f260273b == r100) goto L6;
        this.f260273b = r100;
        requestLayout();
        return;
    }

    public final void setOrientation(int r100) {
        if (this.f260272a == r100) goto L6;
        this.f260272a = r100;
        requestLayout();
        return;
    }

    public final void setOverflowStrategy(int r100) {
        if (this.f260274c == r100) goto L6;
        this.f260274c = r100;
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new PWCLayoutParams(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        int r110 = 0;
        if (this.f260272a != 0) goto L43;
        this.f260275d.clear();
        int r100 = getPaddingLeft() + getPaddingRight();
        int r111 = View.MeasureSpec.getSize(r210);
        int r112 = View.MeasureSpec.getSize(r211);
        int r101 = getChildCount();
        ArrayList<Integer> r102 = a();
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L7;
        this.f260275d.put(r103, false);
        r103 = r103 + 1;
        goto L5
    L7:
        Iterator<Integer> r113 = r102.iterator();
        int r114 = r100;
        int r104 = -1;
        int r115 = 0;
        int r116 = 0;
    L9:
        if (r113.hasNext() == false) goto L40;
        Integer r117 = r113.next();
        View r212 = getChildAt(r117.intValue());
        int r105 = View.MeasureSpec.makeMeasureSpec(r110, r110);
        int r118 = r104;
        measureChildWithMargins(r212, r105, 0, r211, 0);
        ViewGroup.LayoutParams r106 = r212.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.view.PriorityWholeChildLayout.PWCLayoutParams");
        PWCLayoutParams r107 = (PWCLayoutParams) r106;
        int r108 = (r212.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r107).leftMargin) + ((ViewGroup.MarginLayoutParams) r107).rightMargin;
        int r109 = (r212.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r107).topMargin) + ((ViewGroup.MarginLayoutParams) r107).bottomMargin;
        if (this.f260272a != 0) goto L16;
        if (r108 <= r111) goto L14;
    L20:
        boolean r119 = false;
    L21:
        if (r119 == false) goto L29;
        this.f260275d.put(r117.intValue(), true);
        if (r107.f260278b != 1) goto L26;
        if (r118 != (-1)) goto L26;
        r104 = r117.intValue();
    L27:
        r115 = r115 + 1;
        r114 = r114 + r108;
        r116 = (int) Math.max(getHeight(), r109);
    L32:
        int r120 = r115;
        int r121 = this.f260273b;
        if (1 > r121) goto L36;
        if (r121 > r120) goto L36;
        boolean r122 = true;
    L37:
        if (r122 == true) goto L42;
        r115 = r120;
        r110 = 0;
    L42:
        this.f260276e = r104;
        setMeasuredDimension(ViewGroup.resolveSize(r114, r210), ViewGroup.resolveSize(r116, r211));
        return;
    L36:
        r122 = false;
    L26:
        r104 = r118;
        goto L27
    L29:
        if (this.f260274c == 1) goto L41;
        r104 = r118;
    L41:
        r104 = r118;
        goto L42
    L14:
        if ((r114 + r108) > r111) goto L20;
    L19:
        r119 = true;
        goto L21
    L16:
        if (r109 > r112) goto L20;
        if ((r114 + r109) > r112) goto L20;
    L40:
        r118 = r104;
        goto L41
    L43:
        this.f260275d.clear();
        int r123 = getPaddingTop() + getPaddingBottom();
        int r124 = View.MeasureSpec.getSize(r210);
        int r125 = View.MeasureSpec.getSize(r211);
        int r126 = getChildCount();
        ArrayList<Integer> r127 = a();
        int r128 = 0;
    L44:
        if (r128 >= r126) goto L46;
        this.f260275d.put(r128, false);
        r128 = r128 + 1;
        goto L44
    L46:
        Iterator<Integer> r129 = r127.iterator();
        int r130 = r123;
        int r131 = 0;
        int r132 = 0;
    L48:
        if (r129.hasNext() == false) goto L71;
        Integer r133 = r129.next();
        View r134 = getChildAt(r133.intValue());
        measureChildWithMargins(r134, r210, 0, View.MeasureSpec.makeMeasureSpec(0, 0), 0);
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.view.PriorityWholeChildLayout.PWCLayoutParams");
        PWCLayoutParams r136 = (PWCLayoutParams) r135;
        int r137 = (r134.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r136).leftMargin) + ((ViewGroup.MarginLayoutParams) r136).rightMargin;
        int r138 = (r134.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r136).topMargin) + ((ViewGroup.MarginLayoutParams) r136).bottomMargin;
        if (this.f260272a != 0) goto L55;
        if (r137 <= r124) goto L53;
    L59:
        boolean r139 = false;
    L60:
        if (r139 == false) goto L63;
        this.f260275d.put(r133.intValue(), true);
        r131 = r131 + 1;
        r130 = r130 + r138;
        r132 = (int) Math.max(getWidth(), r137);
    L65:
        int r140 = this.f260273b;
        if (1 > r140) goto L69;
        if (r140 > r131) goto L69;
        boolean r141 = true;
    L70:
        if (r141 == false) goto L48;
    L69:
        r141 = false;
        goto L70
    L63:
        if (this.f260274c != 1) goto L65;
    L53:
        if ((r130 + r137) > r124) goto L59;
    L58:
        r139 = true;
        goto L60
    L55:
        if (r138 > r125) goto L59;
        if ((r130 + r138) > r125) goto L59;
    L71:
        setMeasuredDimension(ViewGroup.resolveSize(r132, r210), ViewGroup.resolveSize(r130, r211));
    }

    public PriorityWholeChildLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f260273b = -1;
        this.f260275d = new SparseBooleanArray();
        this.f260276e = -1;
        if (r101 == null) goto L6;
        com.bytedance.locallife.live.util.a.b(r100, r101, new int[]{R.attr.layout_orientation, R.attr.maxCount, R.attr.overflowStrategy}, new PriorityWholeChildLayout$1$1(this));
        return;
    }

    public /* synthetic */ PriorityWholeChildLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r210, int r211, int r212, int r213, int r214) {
        PriorityWholeChildLayout r100 = this;
        int r101 = getChildCount();
        int r102 = getPaddingLeft();
        int r103 = getPaddingTop();
        int r104 = (r213 - r211) - getPaddingRight();
        int r105 = (r214 - r212) - getPaddingBottom();
        if (r100.f260272a != 0) goto L9;
        int r106 = r100.f260276e;
        if (r106 == (-1)) goto L9;
        View r107 = r100.getChildAt(r106);
        if (r107 == null) goto L9;
        Integer r108 = Integer.valueOf(r107.getBaseline());
    L10:
        int r110 = r102;
        int r111 = r103;
        int r109 = 0;
    L11:
        if (r109 >= r101) goto L42;
        View r112 = r100.getChildAt(r109);
        boolean r113 = !r100.f260275d.get(r109);
        Intrinsics.checkNotNullParameter(r112, "<this>");
        if (r112.getVisibility() != 8) goto L15;
        boolean r114 = true;
    L16:
        if (r114 == true) goto L38;
        if (r113 == true) goto L38;
        ViewGroup.LayoutParams r115 = r112.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.bytedance.locallife.live.goodsshelves.view.PriorityWholeChildLayout.PWCLayoutParams");
        PWCLayoutParams r116 = (PWCLayoutParams) r115;
        int r117 = r112.getMeasuredWidth();
        int r118 = r112.getMeasuredHeight();
        if (r100.f260272a != 0) goto L36;
        int r119 = r110 + r116.getMarginStart();
        int r120 = (r119 + r117) + r116.getMarginEnd();
        int r121 = r112.getBaseline();
        if (r108 == null) goto L27;
        int r122 = r101;
        if (r108.intValue() == (-1)) goto L28;
        if (r121 == (-1)) goto L28;
        boolean r123 = true;
    L29:
        if (r123 == false) goto L31;
        int r124 = ((ViewGroup.MarginLayoutParams) r116).topMargin + r103;
        Intrinsics.checkNotNull(r108);
        int r125 = (r124 + r108.intValue()) - r121;
    L35:
        r116.getMarginStart();
        r116.getMarginEnd();
    L37:
        r112.layout(r119, r125, r117 + r119, r118 + r125);
        r110 = r120;
    L41:
        r109 = r109 + 1;
        r100 = this;
        r101 = r122;
        goto L11
    L31:
        int r126 = r105 - r103;
        if (r126 <= 0) goto L34;
        r125 = (((r126 - r118) - ((ViewGroup.MarginLayoutParams) r116).topMargin) - ((ViewGroup.MarginLayoutParams) r116).bottomMargin) / 2;
        goto L35
    L34:
        r125 = 0;
    L28:
        r123 = false;
        goto L29
    L27:
        r122 = r101;
        goto L28
    L36:
        r122 = r101;
        r125 = ((ViewGroup.MarginLayoutParams) r116).topMargin + r111;
        int r127 = (r125 + r118) + ((ViewGroup.MarginLayoutParams) r116).bottomMargin;
        r111 = r127;
        int r128 = r110;
        r119 = (r116.getMarginStart() + r102) + (((((r104 - r102) - r117) - r116.getMarginStart()) - r116.getMarginEnd()) / 2);
        r120 = r128;
    L38:
        r122 = r101;
        if (r113 == false) goto L41;
        r112.layout(0, 0, 0, 0);
        goto L41
    L15:
        r114 = false;
        goto L16
    L42:
        return;
    L9:
        r108 = null;
        goto L10
    }
}
