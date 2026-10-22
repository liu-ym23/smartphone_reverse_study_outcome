package com.larksuite.framework.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0014J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J0\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014¨\u0006 "}, d2 = {"Lcom/larksuite/framework/ui/PriorityLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "handleMeasure", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getMeasureMode", "lp", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "Lcom/larksuite/framework/ui/PriorityLayout$LayoutParams;", "generateDefaultLayoutParams", "LayoutParams", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PriorityLayout extends FrameLayout {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000f¢\u0006\u0004\b\u0006\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/larksuite/framework/ui/PriorityLayout$LayoutParams;", "Landroid/widget/FrameLayout$LayoutParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/ViewGroup$MarginLayoutParams;", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Lcom/larksuite/framework/ui/PriorityLayout$LayoutParams;)V", "priority", "getPriority", "()I", "setPriority", "(I)V", "Companion", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f285827a;

        public static final class a {
        }

        static {
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
            this.f285827a = 1;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101);
            this.f285827a = 1;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.priority});
            this.f285827a = Math.max(1, Math.min(r102.getInt(0, 0), 10));
            r102.recycle();
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.f285827a = 1;
        }
    }

    public PriorityLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PriorityLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "lp");
        return new LayoutParams(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r210) {
        int r100 = r110;
        if (getChildCount() <= 0) goto L63;
        if (r100 == 0) goto L63;
        int r101 = View.MeasureSpec.getSize(r110);
        int r102 = getPaddingLeft() + getPaddingRight();
        int r103 = getPaddingTop() + getPaddingBottom();
        List[] r104 = new List[11];
        int r105 = 0;
    L7:
        if (r105 >= 11) goto L9;
        r104[r105] = new ArrayList();
        r105 = r105 + 1;
        goto L7
    L9:
        LinkedHashMap r106 = new LinkedHashMap();
        LinkedHashMap r107 = new LinkedHashMap();
        int r111 = getChildCount();
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
    L10:
        if (r112 >= r111) goto L16;
        View r115 = getChildAt(r112);
        if (r115.getVisibility() == 8) goto L15;
        measureChild(r115, r100, r210);
        ViewGroup.LayoutParams r108 = r115.getLayoutParams();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.larksuite.framework.ui.PriorityLayout.LayoutParams");
        LayoutParams r109 = (LayoutParams) r108;
        int r116 = ((FrameLayout.LayoutParams) r109).topMargin + ((FrameLayout.LayoutParams) r109).bottomMargin;
        int r117 = ((FrameLayout.LayoutParams) r109).leftMargin + ((FrameLayout.LayoutParams) r109).rightMargin;
        r114 = Math.max(r114, r115.getMeasuredHeight() + r116);
        List r118 = r104[r109.f285827a];
        Intrinsics.checkNotNull(r115);
        r118.add(r115);
        r106.put(r115, Integer.valueOf(r115.getMeasuredWidth()));
        r107.put(r115, Integer.valueOf(r117));
        r113 = r113 + (r115.getMeasuredWidth() + r117);
    L15:
        r112 = r112 + 1;
        r100 = r110;
        r111 = r111;
        goto L10
    L16:
        int r119 = r113;
        int r120 = 0;
    L18:
        if ((r119 + r102) < r101) goto L33;
        if (r120 >= 10) goto L33;
        r120 = r120 + 1;
        List r121 = r104[r120];
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator r123 = r121.iterator();
    L22:
        if (r123.hasNext() == false) goto L28;
        Integer r124 = (Integer) r106.get((View) r123.next());
        if (r124 == null) goto L26;
        int r125 = r124.intValue();
    L27:
        r122.add(Integer.valueOf(r125));
        goto L22
    L26:
        r125 = 0;
        goto L27
    L28:
        int r126 = CollectionsKt.sumOfInt(r122);
        List r127 = r104[r120];
        ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
        Iterator r129 = r127.iterator();
    L30:
        if (r129.hasNext() == false) goto L32;
        r128.add(Integer.valueOf(((View) r129.next()).getMinimumWidth()));
        goto L30
    L32:
        r119 = (r119 - r126) + CollectionsKt.sumOfInt(r128);
    L33:
        if (r120 <= 0) goto L59;
        int r130 = 0;
    L35:
        int r131 = -2;
        if (r130 >= r120) goto L46;
        Iterator r132 = r104[r130].iterator();
    L39:
        if (r132.hasNext() == false) goto L45;
        View r133 = (View) r132.next();
        if (r133.getLayoutParams().width != r131) goto L43;
        int r134 = Integer.MIN_VALUE;
    L44:
        r133.measure(View.MeasureSpec.makeMeasureSpec(r133.getMinimumWidth(), r134), r210);
        r131 = -2;
        goto L39
    L43:
        r134 = 1073741824;
        goto L44
    L45:
        r130 = r130 + 1;
        goto L35
    L46:
        int r135 = (r101 - r102) - r119;
        List r136 = r104[r120];
        ArrayList r137 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r136, 10));
        Iterator r138 = r136.iterator();
    L48:
        if (r138.hasNext() == false) goto L50;
        r137.add(Integer.valueOf(((View) r138.next()).getMeasuredWidth()));
        goto L48
    L50:
        float r139 = CollectionsKt.sumOfInt(r137);
        Iterator r140 = r104[r120].iterator();
    L52:
        if (r140.hasNext() == false) goto L59;
        View r141 = (View) r140.next();
        int r142 = (int) (r135 * (r141.getMeasuredWidth() / r139));
        if (r141.getLayoutParams().width != (-2)) goto L56;
        int r143 = Integer.MIN_VALUE;
    L57:
        r141.measure(View.MeasureSpec.makeMeasureSpec(r141.getMinimumWidth() + r142, r143), r210);
        goto L52
    L56:
        r143 = 1073741824;
    L59:
        if (View.MeasureSpec.getMode(r110) != Integer.MIN_VALUE) goto L61;
        r101 = Math.min(r113 + r102, r101);
    L61:
        setMeasuredDimension(r101, r114 + r103);
        return;
    L63:
        super.onMeasure(r110, r210);
    }

    public PriorityLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ PriorityLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        int r103 = getChildCount();
        int r104 = 0;
        int r112 = 0;
    L3:
        if (r104 >= r103) goto L20;
        View r105 = getChildAt(r104);
        if (r105.getVisibility() == 8) goto L19;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r107 = (FrameLayout.LayoutParams) r106;
        int r108 = (r107.leftMargin + r112) + getPaddingLeft();
        int r109 = r107.gravity & 112;
        if (r109 != 16) goto L9;
        int r113 = ((((((getPaddingTop() + r102) + r107.topMargin) + r111) - getPaddingBottom()) - r107.bottomMargin) - r105.getMeasuredHeight()) / 2;
    L17:
        int r114 = r113 - r102;
    L18:
        r105.layout(r108, r114, r105.getMeasuredWidth() + r108, r105.getMeasuredHeight() + r114);
        r112 = r112 + ((r105.getMeasuredWidth() + r107.leftMargin) + r107.rightMargin);
        goto L19
    L9:
        if (r109 != 48) goto L11;
        int r115 = r107.topMargin;
        int r116 = getPaddingTop();
    L15:
        r114 = r115 + r116;
        goto L18
    L11:
        if (r109 == 80) goto L13;
        r115 = r107.topMargin;
        r116 = getPaddingTop();
        goto L15
    L13:
        r113 = ((r111 - r107.bottomMargin) - getPaddingBottom()) - r105.getMeasuredHeight();
    L19:
        r104 = r104 + 1;
        goto L3
    }
}
