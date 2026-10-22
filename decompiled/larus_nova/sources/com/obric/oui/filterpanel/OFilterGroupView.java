package com.obric.oui.filterpanel;

import ama.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.obric.oui.filter.OFilter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010R\u0017\u0010\u0018\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "title", "", d.f25925o, "Landroid/widget/TextView;", "getTitle", "", "count", "setMaxSelectCount", "getMaxSelectCount", "", "getSelectedIndexes", "Lcom/obric/oui/filter/OFilter;", "getSelectedFilters", "", "enableClickWhenSelected", "setEnableClickWhenSelected", "Landroid/widget/GridLayout;", "c", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "gridLayout", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OFilterGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f400831l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f400832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f400833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GridLayout f400834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f400835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f400836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f400837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<CharSequence> f400838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<CharSequence> f400839h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends CharSequence> f400840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<OFilter> f400841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f400842k;

    public static final class a implements OFilter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFilterGroupView f400843a;

        public a(OFilterGroupView r100) {
            this.f400843a = r100;
        }

        @Override // com.obric.oui.filter.OFilter.b
        public final void a(OFilter r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "filter");
            if (r101 == false) goto L5;
            OFilterGroupView r102 = this.f400843a;
            int r103 = OFilterGroupView.f400831l;
            r102.getClass();
            return;
        L5:
            OFilterGroupView r104 = this.f400843a;
            int r105 = OFilterGroupView.f400831l;
            r104.getClass();
        }
    }

    public final List<OFilter> getSelectedFilters() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f400841j.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        OFilter r102 = (OFilter) r101.next();
        if (r102.isSelected() == false) goto L4;
        r100.add(r102);
        goto L4
    L8:
        return r100;
    }

    public final List<Integer> getSelectedIndexes() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.f400841j.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OFilter) r103).isSelected() == false) goto L11;
        r100.add(Integer.valueOf(r102));
    L11:
        r102 = r104;
        goto L4
    L12:
        return r100;
    }

    public final GridLayout getGridLayout() {
        return this.f400834c;
    }

    public final int getMaxSelectCount() {
        return this.f400835d;
    }

    public final TextView getTitle() {
        return this.f400832a;
    }

    public OFilterGroupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setEnableClickWhenSelected(boolean r100) {
        this.f400842k = r100;
    }

    public final void setMaxSelectCount(int r100) {
        this.f400835d = r100;
    }

    public final void setTitle(CharSequence r100) {
        this.f400832a.setText(r100);
    }

    public OFilterGroupView(final Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f400835d = 1;
        this.f400836e = 3;
        this.f400838g = new ArrayList();
        this.f400839h = new ArrayList();
        this.f400841j = new ArrayList();
        this.f400842k = true;
        ViewGroup.inflate(r100, R.layout.o_layout_filter_group_view, this);
        setPadding(pla.d.n(this, 16), 0, pla.d.n(this, 16), pla.d.n(this, 16));
        this.f400832a = (TextView) findViewById(R.id.tv_title);
        TextView r102 = (TextView) findViewById(R.id.tv_show_more);
        this.f400833b = r102;
        this.f400834c = (GridLayout) findViewById(R.id.grid_layout);
        r102.setOnClickListener(new ama.a(this, r100));
    }

    public final void R5(List<? extends CharSequence> r110, int r111) {
        ((ArrayList) this.f400841j).clear();
        this.f400840i = r110;
        Iterator<T> r112 = r110.iterator();
        int r100 = 0;
    L4:
        if (r112.hasNext() == false) goto L9;
        Object r101 = r112.next();
        int r102 = r100 + 1;
        if (r100 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        GridLayout.LayoutParams r103 = new GridLayout.LayoutParams();
        r103.height = -2;
        r103.width = 0;
        r103.rightMargin = pla.d.n(this, 8);
        r103.topMargin = pla.d.n(this, 5);
        r103.setGravity(17);
        int r104 = r100 % r111;
        r103.columnSpec = GridLayout.spec(r104, 1.0f);
        r103.rowSpec = GridLayout.spec(r100 / r111, 1.0f);
        final OFilter r105 = new OFilter(getContext(), null, 0, true, 6);
        r105.setText((CharSequence) r101);
        r105.f400818e = 0;
        r105.f400821h = true;
        r105.a();
        r105.setSelectChangeListener(new a(this));
        r105.setOnClickListener(new b(this, r105));
        ((ArrayList) this.f400841j).add(r105);
        getGridLayout().addView(r105, r103);
        r100 = r102;
        goto L4
    }
}
