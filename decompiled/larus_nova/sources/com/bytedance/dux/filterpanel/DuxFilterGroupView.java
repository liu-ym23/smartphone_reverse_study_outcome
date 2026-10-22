package com.bytedance.dux.filterpanel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.sdk.m.x.d;
import com.bytedance.dux.filter.DuxFilter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import sl4.a;
import sl4.b;
import sl4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/bytedance/dux/filterpanel/DuxFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", d.f25925o, "Landroid/widget/TextView;", "getTitle", "", "count", "setMaxSelectCount", "getMaxSelectCount", "", "getSelectedIndexes", "Lcom/bytedance/dux/filter/DuxFilter;", "getSelectedFilters", "", "enableClickWhenSelected", "setEnableClickWhenSelected", "Landroid/widget/GridLayout;", "d", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "gridLayout", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxFilterGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f205064n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f205066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f205067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GridLayout f205068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f205069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f205070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f205071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<CharSequence> f205072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<CharSequence> f205073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<? extends CharSequence> f205074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<DuxFilter> f205075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f205076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f205077m;

    public DuxFilterGroupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxFilterGroupView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final List<DuxFilter> getSelectedFilters() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f205075k.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        DuxFilter r102 = (DuxFilter) r101.next();
        if (r102.isSelected() == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public final List<Integer> getSelectedIndexes() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f205075k.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((DuxFilter) r103).isSelected() == false) goto L11;
        r100.add(Integer.valueOf(r102));
    L11:
        r102 = r104;
        goto L4
    L12:
        return r100;
    }

    public final GridLayout getGridLayout() {
        return this.f205068d;
    }

    public final int getMaxSelectCount() {
        return this.f205069e;
    }

    public final TextView getTitle() {
        return this.f205066b;
    }

    public static DisplayMetrics R5(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final void setEnableClickWhenSelected(boolean r100) {
        this.f205077m = r100;
    }

    public final void setMaxSelectCount(int r100) {
        this.f205069e = r100;
    }

    public final void setTitle(CharSequence r100) {
        this.f205066b.setText(r100);
    }

    public DuxFilterGroupView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f205065a = false;
        this.f205069e = 1;
        this.f205070f = 3;
        this.f205072h = new ArrayList();
        this.f205073i = new ArrayList();
        this.f205075k = new ArrayList();
        this.f205076l = true;
        this.f205077m = true;
        ViewGroup.inflate(r100, R.layout.dux_layout_filter_group_view, this);
        float r103 = 16;
        setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r103, R5(Resources.getSystem()))), 0, MathKt.roundToInt(TypedValue.applyDimension(1, r103, R5(Resources.getSystem()))), 0);
        this.f205066b = (TextView) findViewById(R.id.tv_title);
        TextView r104 = (TextView) findViewById(R.id.tv_show_more);
        this.f205067c = r104;
        this.f205068d = (GridLayout) findViewById(R.id.grid_layout);
        r104.setOnClickListener(new a(this, r100));
    }

    public static final void S5(DuxFilterGroupView r110, List r111, int r112) {
        ((ArrayList) r110.f205075k).clear();
        r110.f205074j = r111;
        Iterator r100 = r111.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L15;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CharSequence r104 = (CharSequence) r102;
        GridLayout.LayoutParams r105 = new GridLayout.LayoutParams();
        r105.height = -2;
        r105.width = 0;
        r105.setGravity(17);
        int r106 = r101 % r112;
        int r107 = r101 / r112;
        if (r106 == 0) goto L12;
        r105.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, 8, R5(Resources.getSystem()))));
    L12:
        if (r107 == 0) goto L14;
        r105.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 12, R5(Resources.getSystem())));
    L14:
        r105.columnSpec = GridLayout.spec(r106, 1.0f);
        r105.rowSpec = GridLayout.spec(r107, 1.0f);
        DuxFilter r108 = new DuxFilter(r110.getContext(), null, 0, r110.f205076l, r110.f205065a, 22);
        int r109 = MathKt.roundToInt(TypedValue.applyDimension(1, 5, R5(Resources.getSystem())));
        r108.f205053b = MathKt.roundToInt(TypedValue.applyDimension(1, 12, R5(Resources.getSystem())));
        r108.f205054c = r109;
        r108.setText(r104);
        boolean r113 = r110.f205076l;
        r108.f205057f = 0;
        r108.f205060i = r113;
        r108.b();
        r108.setSelectChangeListener(new b(r110));
        r108.setOnClickListener(new c(r110, r108));
        ((ArrayList) r110.f205075k).add(r108);
        r110.f205068d.addView(r108, r105);
        r101 = r103;
        goto L4
    }
}
