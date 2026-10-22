package com.larus.extension.aggregate_search_ui.impl.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0014J.\u0010*\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\r2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0002J8\u00100\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\r2\b\u00101\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0002J\u001e\u00102\u001a\u00020\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\r2\u0006\u0010-\u001a\u00020\tH\u0002J&\u00103\u001a\u00020\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\r2\u0006\u0010-\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0002J0\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0014J\u0012\u0010;\u001a\u00020\u00112\b\u00101\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010<\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R=\u0010\u000b\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\t0\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R$\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010!\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/view/SearchWrapLayout;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "horizontalSpacing", "", "verticalSpacing", "onRenderedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visibleIndices", "", "getOnRenderedListener", "()Lkotlin/jvm/functions/Function1;", "setOnRenderedListener", "(Lkotlin/jvm/functions/Function1;)V", "value", "maxLines", "getMaxLines", "()I", "setMaxLines", "(I)V", "toggleViewId", "getToggleViewId", "setToggleViewId", "", "isOverflow", "()Z", "alwaysShowToggle", "getAlwaysShowToggle", "setAlwaysShowToggle", "(Z)V", "toggleInsertIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "layoutSimple", "children", "Landroid/view/View;", "widthSize", "widthSpec", "heightSpec", "layoutSimpleWithToggle", "toggleView", "countLines", "findCutIndex", "toggleWidth", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "notifyRenderedChildren", "dp", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchWrapLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f342769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super List<Integer>, Unit> f342770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f342771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f342772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f342773f;

    public final boolean getAlwaysShowToggle() {
        return this.f342773f;
    }

    public final int getMaxLines() {
        return this.f342771d;
    }

    public final Function1<List<Integer>, Unit> getOnRenderedListener() {
        return this.f342770c;
    }

    public final int getToggleViewId() {
        return this.f342772e;
    }

    public SearchWrapLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setAlwaysShowToggle(boolean r100) {
        if (this.f342773f == r100) goto L6;
        this.f342773f = r100;
        requestLayout();
        return;
    }

    public final void setMaxLines(int r100) {
        if (this.f342771d == r100) goto L6;
        this.f342771d = r100;
        requestLayout();
        return;
    }

    public final void setOnRenderedListener(Function1<? super List<Integer>, Unit> r100) {
        this.f342770c = r100;
    }

    public final void setToggleViewId(int r100) {
        if (this.f342772e == r100) goto L6;
        this.f342772e = r100;
        requestLayout();
        return;
    }

    public SearchWrapLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        float r102 = 8;
        Resources r103 = getResources();
        this.f342768a = (int) (WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density * r102);
        Resources r104 = getResources();
        this.f342769b = (int) (r102 * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density);
        this.f342772e = -1;
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r210) {
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.makeMeasureSpec(r100, Integer.MIN_VALUE);
        int r102 = this.f342772e;
        if (r102 == (-1)) goto L5;
        View r103 = findViewById(r102);
    L6:
        if (r103 == null) goto L9;
        measureChild(r103, r101, r210);
    L9:
        if (r103 == null) goto L11;
        int r104 = r103.getMeasuredWidth();
    L12:
        if (r103 == null) goto L14;
        int r105 = r103.getMeasuredHeight();
    L15:
        ArrayList r106 = new ArrayList();
        int r111 = getChildCount();
        int r112 = 0;
    L17:
        if (r112 >= r111) goto L25;
        View r113 = getChildAt(r112);
        if (Intrinsics.areEqual(r113, r103) == true) goto L24;
        if (r113.getVisibility() == 8) goto L24;
        Intrinsics.checkNotNull(r113);
        r106.add(r113);
    L24:
        r112 = r112 + 1;
        goto L17
    L25:
        Iterator r114 = r106.iterator();
    L27:
        if (r114.hasNext() == false) goto L29;
        measureChild((View) r114.next(), r101, r210);
        goto L27
    L29:
        int r107 = getPaddingLeft();
        Iterator r115 = r106.iterator();
        int r116 = 1;
    L31:
        if (r115.hasNext() == false) goto L39;
        int r117 = ((View) r115.next()).getMeasuredWidth();
        if (r107 == getPaddingLeft()) goto L36;
        r107 = r107 + this.f342768a;
    L36:
        r107 = r107 + r117;
        if (r107 <= (r100 - getPaddingRight())) goto L31;
        r116 = r116 + 1;
        r107 = getPaddingLeft() + r117;
        goto L31
    L39:
        int r108 = this.f342771d;
        if (r108 <= 0) goto L43;
        if (r116 <= r108) goto L43;
        boolean r109 = true;
    L44:
        if (r109 == false) goto L46;
    L64:
        if (r109 == false) goto L66;
    L99:
        if (r103 == null) goto L101;
        r103.setVisibility(0);
    L101:
        int r118 = getPaddingLeft();
        List r119 = CollectionsKt.mutableListOf(new Integer[]{0});
        int r120 = r106.size();
        int r121 = 0;
    L102:
        if (r121 >= r120) goto L111;
        int r122 = ((View) ListProtector.get(r106, r121)).getMeasuredWidth();
        if (r118 == getPaddingLeft()) goto L107;
        r118 = r118 + this.f342768a;
    L107:
        r118 = r118 + r122;
        if (r118 <= (r100 - getPaddingRight())) goto L110;
        r119.add(Integer.valueOf(r121));
        r118 = getPaddingLeft() + r122;
    L110:
        r121 = r121 + 1;
        goto L102
    L111:
        int r123 = r119.size();
        int r124 = this.f342771d;
        if (r123 < r124) goto L114;
        int r125 = ((Number) ListProtector.get(r119, r124 - 1)).intValue();
    L115:
        int r126 = getPaddingLeft();
        int r127 = r106.size();
        int r128 = r125;
    L116:
        if (r128 >= r127) goto L125;
        int r129 = ((View) ListProtector.get(r106, r128)).getMeasuredWidth();
        int r130 = this.f342768a + r104;
        if (r126 == getPaddingLeft()) goto L121;
        r126 = r126 + this.f342768a;
    L121:
        r126 = r126 + r129;
        if ((r130 + r126) > (r100 - getPaddingRight())) goto L125;
        r128 = r128 + 1;
    L125:
        int r131 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r128, r125), r106.size());
        int r132 = getPaddingLeft();
        int r133 = getPaddingTop() + getPaddingBottom();
        int r134 = 0;
        int r135 = 0;
        int r136 = 0;
    L126:
        if (r134 >= r131) goto L136;
        View r137 = (View) ListProtector.get(r106, r134);
        int r138 = r137.getMeasuredWidth();
        int r139 = r137.getMeasuredHeight();
        int r140 = r131;
        if (r132 != getPaddingLeft()) goto L130;
        int r141 = r132 + r138;
    L132:
        if (r141 <= (r100 - getPaddingRight())) goto L134;
        r133 = r133 + (r135 + this.f342769b);
        r136 = Math.max(r136, r132);
        r132 = getPaddingLeft() + r138;
        r135 = r139;
    L135:
        r137.setVisibility(0);
        r134 = r134 + 1;
        r131 = r140;
        goto L126
    L134:
        r135 = Math.max(r135, r139);
        r132 = r141;
        goto L135
    L130:
        r141 = (this.f342768a + r132) + r138;
        goto L132
    L136:
        int r142 = r131;
        if (r132 != getPaddingLeft()) goto L139;
        int r143 = r132 + r104;
    L141:
        if (r143 <= (r100 - getPaddingRight())) goto L143;
        r133 = r133 + (r135 + this.f342769b);
    L144:
        int r144 = r106.size();
        int r145 = r142;
    L145:
        if (r145 >= r144) goto L147;
        ((View) ListProtector.get(r106, r145)).setVisibility(4);
        r145 = r145 + 1;
        goto L145
    L147:
        if (r105 <= 0) goto L149;
        r133 = r133 + r105;
        r136 = Math.max(r136, (r132 + this.f342768a) + r104);
    L149:
        setMeasuredDimension(ViewGroup.resolveSize(r136 + getPaddingRight(), r110), ViewGroup.resolveSize(r133, r210));
        return;
    L143:
        r105 = Math.max(r135, r105);
        goto L144
    L139:
        r143 = (this.f342768a + r132) + r104;
        goto L141
    L114:
        r125 = ((Number) CollectionsKt.last(r119)).intValue();
        goto L115
    L66:
        if (this.f342773f == false) goto L99;
        if (r103 == null) goto L69;
        r103.setVisibility(0);
    L69:
        r106.size();
        if (r103 == null) goto L72;
        int r146 = r103.getMeasuredWidth();
    L73:
        if (r103 == null) goto L75;
        int r147 = r103.getMeasuredHeight();
    L76:
        int r148 = getPaddingLeft();
        int r149 = getPaddingTop() + getPaddingBottom();
        Iterator r150 = r106.iterator();
        int r151 = 0;
        int r152 = 0;
    L78:
        if (r150.hasNext() == false) goto L88;
        View r153 = (View) r150.next();
        r153.setVisibility(0);
        int r154 = r153.getMeasuredWidth();
        int r155 = r153.getMeasuredHeight();
        if (r148 != getPaddingLeft()) goto L82;
        int r156 = r148 + r154;
    L84:
        if (r156 > (r100 - getPaddingRight())) goto L85;
        r151 = Math.max(r151, r155);
        r148 = r156;
        goto L78
    L85:
        r149 = r149 + (r151 + this.f342769b);
        r152 = Math.max(r152, r148);
        r148 = getPaddingLeft() + r154;
        r151 = r155;
        goto L78
    L82:
        r156 = (this.f342768a + r148) + r154;
        goto L84
    L88:
        if (r148 != getPaddingLeft()) goto L90;
        int r157 = r146 + r148;
    L92:
        if (r157 <= (r100 - getPaddingRight())) goto L94;
        r149 = r149 + (r151 + this.f342769b);
        r152 = Math.max(r152, r148);
    L95:
        if (r147 <= 0) goto L97;
        r149 = r149 + r147;
        r152 = Math.max(r152, r157);
    L97:
        setMeasuredDimension(ViewGroup.resolveSize(r152 + getPaddingRight(), r110), ViewGroup.resolveSize(r149, r210));
        return;
    L94:
        r147 = Math.max(r151, r147);
        goto L95
    L90:
        r157 = r146 + (this.f342768a + r148);
        goto L92
    L75:
        r147 = 0;
        goto L76
    L72:
        r146 = 0;
        goto L73
    L46:
        if (this.f342773f == true) goto L64;
        if (r103 == null) goto L49;
        r103.setVisibility(8);
    L49:
        int r158 = getPaddingLeft();
        int r159 = getPaddingTop() + getPaddingBottom();
        Iterator r160 = r106.iterator();
        int r161 = 0;
        int r162 = 0;
    L51:
        if (r160.hasNext() == false) goto L60;
        View r163 = (View) r160.next();
        r163.setVisibility(0);
        int r164 = r163.getMeasuredWidth();
        int r165 = r163.getMeasuredHeight();
        if (r158 != getPaddingLeft()) goto L55;
        int r166 = r158 + r164;
    L57:
        if (r166 > (r100 - getPaddingRight())) goto L58;
        r161 = Math.max(r161, r165);
        r158 = r166;
        goto L51
    L58:
        r159 = r159 + (r161 + this.f342769b);
        r162 = Math.max(r162, r158);
        r158 = getPaddingLeft() + r164;
        r161 = r165;
        goto L51
    L55:
        r166 = (this.f342768a + r158) + r164;
        goto L57
    L60:
        if (r161 <= 0) goto L62;
        r159 = r159 + r161;
        r162 = Math.max(r162, r158);
    L62:
        setMeasuredDimension(ViewGroup.resolveSize(r162 + getPaddingRight(), r110), ViewGroup.resolveSize(r159, r210));
        return;
    L43:
        r109 = false;
        goto L44
    L14:
        r105 = 0;
        goto L15
    L11:
        r104 = 0;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        int r115 = r113 - r111;
        int r116 = this.f342772e;
        if (r116 == (-1)) goto L5;
        View r117 = findViewById(r116);
    L6:
        ArrayList r118 = new ArrayList();
        int r119 = getChildCount();
        int r120 = 0;
        int r100 = 0;
    L7:
        if (r100 >= r119) goto L17;
        View r101 = getChildAt(r100);
        if (Intrinsics.areEqual(r101, r117) == true) goto L16;
        if (r101.getVisibility() == 8) goto L16;
        if (r101.getVisibility() == 4) goto L16;
        Intrinsics.checkNotNull(r101);
        r118.add(r101);
    L16:
        r100 = r100 + 1;
        goto L7
    L17:
        if (r117 != null) goto L19;
    L21:
        boolean r121 = false;
    L22:
        if (r121 == false) goto L24;
        r118.add(r117);
    L24:
        int r122 = getPaddingTop();
        int r102 = 0;
    L26:
        if (r102 >= r118.size()) goto L47;
        int r103 = getPaddingLeft();
        int r104 = r102;
        int r105 = 0;
    L29:
        if (r104 >= r118.size()) goto L40;
        View r106 = (View) ListProtector.get(r118, r104);
        if (r103 != getPaddingLeft()) goto L33;
        int r107 = r106.getMeasuredWidth();
    L34:
        r103 = r103 + r107;
        if (r104 <= r102) goto L39;
        if (r103 > (r115 - getPaddingRight())) goto L40;
    L39:
        r105 = Math.max(r105, r106.getMeasuredHeight());
        r104 = r104 + 1;
        goto L29
    L33:
        r103 = r103 + this.f342768a;
        r107 = r106.getMeasuredWidth();
    L40:
        int r108 = getPaddingLeft();
        int r109 = r102;
    L41:
        if (r109 >= r104) goto L46;
        View r123 = (View) ListProtector.get(r118, r109);
        if (r109 <= r102) goto L45;
        r108 = r108 + this.f342768a;
    L45:
        int r124 = ((r105 - r123.getMeasuredHeight()) / 2) + r122;
        r123.layout(r108, r124, r123.getMeasuredWidth() + r108, r123.getMeasuredHeight() + r124);
        r108 = r108 + r123.getMeasuredWidth();
        r109 = r109 + 1;
        goto L41
    L46:
        r122 = r122 + (r105 + this.f342769b);
        r102 = r104;
        goto L26
    L47:
        Function1<? super List<Integer>, Unit> r125 = this.f342770c;
        if (r125 == null) goto L77;
        ArrayList r126 = new ArrayList();
        int r127 = getChildCount();
        int r128 = 0;
    L51:
        if (r120 >= r127) goto L59;
        View r129 = getChildAt(r120);
        if (Intrinsics.areEqual(r129, r117) == true) goto L58;
        if (r129.getVisibility() != 0) goto L57;
        r126.add(Integer.valueOf(r128));
    L57:
        r128 = r128 + 1;
    L58:
        r120 = r120 + 1;
        goto L51
    L59:
        r125.invoke(r126);
        return;
    L77:
        return;
    L19:
        if (r117.getVisibility() != 0) goto L21;
        r121 = true;
        goto L22
    L5:
        r117 = null;
        goto L6
    }
}
