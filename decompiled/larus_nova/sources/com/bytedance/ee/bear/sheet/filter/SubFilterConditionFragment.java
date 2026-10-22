package com.bytedance.ee.bear.sheet.filter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0014J \u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\b\u0010-\u001a\u00020\u001fH\u0002J%\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b01H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u001fH\u0016J\u0010\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u0013H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0013X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/SubFilterConditionFragment;", "Lcom/bytedance/ee/bear/sheet/filter/BaseSubFilterFragment;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;", "<init>", "()V", "scrollView", "Landroid/view/View;", "placeHolder", "recyclerView", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "filterConditionAdapter", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "valueList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "isMaxHeight", "", "isKeyboardingShowing", "keyboardHeight", "", "isColRangeChanged", "changedCol", "lastCurrentCol", "layoutResId", "getLayoutResId", "()I", "panelName", "", "getPanelName", "()Ljava/lang/String;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "orientation", "scrollPanel", "onChangeToMidPosition", "onChangeToMaxPosition", "notifyAdapterKeyboardClosed", "onFilterConditionListener", "id", "value", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "onEditorActionListener", "notifyColRangeChanged", "index", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubFilterConditionFragment extends BaseSubFilterFragment implements FilterConditionAdapter.b {
    public final String A;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f237797o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f237798p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public BaseRecyclerView f237799q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FilterConditionAdapter f237800r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<FilterData.FilterOptionItem> f237801s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f237802t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f237803u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f237804v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f237805w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f237806x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f237807y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f237808z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubFilterConditionFragment f237809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f237810b;

        public a(SubFilterConditionFragment r100, int r101) {
            this.f237809a = r100;
            this.f237810b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f237809a.f237797o;     // Catch: Throwable -> L7
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");     // Catch: Throwable -> L7
            r100 = null;
        L5:
            r100.scrollBy(0, this.f237809a.f237804v - this.f237810b);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public final void da0() {
        int[] r100 = new int[2];
        View r101 = getView();
        View r102 = null;
        if (r101 == null) goto L5;
        View r103 = r101.findFocus();
    L6:
        if (r103 == null) goto L24;
        r103.getLocationOnScreen(r100);
        int r104 = ((com.bytedance.ee.util.ui.n.t() - r100[1]) - r103.getHeight()) - com.bytedance.ee.util.ui.n.d(20);
        if (r104 >= this.f237804v) goto L25;
        View r105 = this.f237798p;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r105 = null;
    L12:
        r105.setVisibility(0);
        View r106 = this.f237798p;
        if (r106 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r106 = null;
    L15:
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.height = this.f237804v;
        View r108 = this.f237798p;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r108 = null;
    L18:
        r108.setLayoutParams(r107);
        View r109 = this.f237798p;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
    L22:
        r102.post(new a(this, r104));
        return;
    L21:
        r102 = r109;
        goto L22
    L25:
        return;
    L24:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void Q5() {
        if (this.f237803u == false) goto L5;
        da0();
    L5:
        this.f237802t = true;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void W6() {
        if (this.f237803u == true) goto L5;
    L7:
        this.f237802t = false;
        return;
    L5:
        if (this.f237802t == false) goto L7;
        rcb.c.c(getContext());
        goto L7
    }

    public final void ca0() {
        FilterConditionAdapter r100 = this.f237800r;
        if (r100 == null) goto L5;
        int r101 = r100.f237673c;
    L6:
        BaseRecyclerView r102 = this.f237799q;
        BaseRecyclerView r103 = null;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r102 = null;
    L9:
        View r104 = r102.getChildAt(r101);
        if (r104 == null) goto L19;
        BaseRecyclerView r105 = this.f237799q;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L15:
        RecyclerView.ViewHolder r106 = r103.getChildViewHolder(r104);
        FilterConditionAdapter r107 = this.f237800r;
        if (r107 == null) goto L20;
        Intrinsics.checkNotNull(r106);
        r107.y2(r101, r106);
        return;
    L20:
        return;
    L14:
        r103 = r105;
        goto L15
    L19:
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public SubFilterConditionFragment() {
        this.f237801s = new ArrayList();
        this.f237807y = -1;
        this.f237808z = R.layout.sheet_filter_condition_fragment;
        this.A = FilterData.FilterSheetItem.Id.FILTER_CONDITION;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterConditionAdapter.b
    public final void c60() {
        SheetDragView r100 = W90();
        r100.f237475x.a();
        r100.C = false;
        rcb.c.c(getContext());
        ca0();
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final int X90() {
        return this.f237808z;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final String Y90() {
        return this.A;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final void aa0(int r100) {
        if (this.f237803u == false) goto L5;
        this.f237805w = true;
        this.f237806x = r100;
        rcb.c.c(getContext());
        return;
    L5:
        super.aa0(r100);
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final void ba0(FilterData.FilterSheetItem r100) {
        Intrinsics.checkNotNullParameter(r100, "filterSheetItem");
        ((ArrayList) this.f237801s).clear();
        FilterData.FilterOptionItem[] r101 = r100.getList();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L11:
        View r103 = null;
        if (r102 == true) goto L18;
        List<FilterData.FilterOptionItem> r104 = this.f237801s;
        FilterData.FilterOptionItem[] r105 = r100.getList();
        if (r105 == null) goto L16;
        List r106 = ArraysKt.toMutableList(r105);
    L17:
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
        ((ArrayList) r104).addAll((ArrayList) r106);
        goto L18
    L16:
        r106 = null;
    L18:
        Context r107 = getContext();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.content.Context");
        FilterConditionAdapter r108 = new FilterConditionAdapter(r107, this.f237801s);
        this.f237800r = r108;
        r108.f237674d = this;
        BaseRecyclerView r109 = this.f237799q;
        if (r109 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r109 = null;
    L21:
        r109.setAdapter(this.f237800r);
        if (this.f237805w == false) goto L24;
        aa0(this.f237806x);
        this.f237805w = false;
    L24:
        int r110 = this.f237807y;
        int r111 = this.f237666l;
        if (r110 == r111) goto L32;
        this.f237807y = r111;
        View r112 = this.f237797o;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
    L30:
        r103.setScrollY(0);
        return;
    L29:
        r103 = r112;
        goto L30
    L32:
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == true) goto L11;
        r102 = false;
        goto L11
    L7:
        r113 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f237797o = r100.findViewById(R.id.scroll_view);
        com.bytedance.ee.bear.facade.common.widget.d r102 = W90().f237475x;
        if (r102.b() < ((int) r102.f226588c[2])) goto L5;
        boolean r103 = true;
    L6:
        this.f237802t = r103;
        this.f237798p = r100.findViewById(R.id.placeholder);
        BaseRecyclerView r104 = (BaseRecyclerView) r100.findViewById(R.id.value_list_recycler_view);
        this.f237799q = r104;
        BaseRecyclerView r105 = null;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r104 = null;
    L9:
        r104.setSceneTag("subFilterConditionFragment_rv");
        BaseRecyclerView r106 = this.f237799q;
        if (r106 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r106 = null;
    L12:
        r106.setLayoutManager(new LinearLayoutManager(getContext()));
        BaseRecyclerView r107 = this.f237799q;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r107 = null;
    L15:
        r107.setHasFixedSize(true);
        BaseRecyclerView r108 = this.f237799q;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L19:
        r105.setNestedScrollingEnabled(false);
        return;
    L18:
        r105 = r108;
        goto L19
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterConditionAdapter.b
    public final void sK(String r100, String[] r101) {
        Intrinsics.checkNotNullParameter(r101, "value");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        boolean r104 = true;
        if (r103 >= r102) goto L15;
        String r105 = r101[r103];
        if (r105 != null) goto L8;
    L11:
        boolean r106 = true;
    L12:
        if (r106 == false) goto L13;
        r103 = r103 + 1;
        goto L3
    L13:
        boolean r107 = false;
    L16:
        int r108 = r101.length;
        int r109 = 0;
    L17:
        if (r109 >= r108) goto L28;
        String r110 = r101[r109];
        if (r110 != null) goto L21;
    L24:
        boolean r111 = true;
    L25:
        if (r111 == true) goto L29;
        r109 = r109 + 1;
    L29:
        if (r100 == null) goto L34;
        if (r104 == false) goto L32;
        if (r107 == false) goto L34;
    L32:
        U90(r100, r101);
        return;
    L34:
        if (this.f237805w == false) goto L42;
        aa0(this.f237806x);
        this.f237805w = false;
        return;
    L42:
        return;
    L21:
        if (r110.length() == 0) goto L24;
        r111 = false;
        goto L25
    L28:
        r104 = false;
        goto L29
    L8:
        if (r105.length() == 0) goto L11;
        r106 = false;
        goto L12
    L15:
        r107 = true;
        goto L16
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
        if (r101 <= 0) goto L8;
        this.f237804v = r101;
        this.f237803u = true;
        if (this.f237802t == false) goto L7;
        da0();
        return;
    L7:
        W90().n();
        return;
    L8:
        this.f237803u = false;
        View r103 = this.f237798p;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r103 = null;
    L11:
        r103.setVisibility(8);
        ca0();
    }
}
