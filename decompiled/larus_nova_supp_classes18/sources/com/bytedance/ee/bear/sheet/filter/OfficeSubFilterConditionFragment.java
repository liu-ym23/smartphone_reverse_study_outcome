package com.bytedance.ee.bear.sheet.filter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0014J \u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u001fH\u0002J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\b\u0010-\u001a\u00020\u001fH\u0002J%\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u00010\u001b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001b01H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u001fH\u0016J\u0010\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u0013H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0013X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/OfficeSubFilterConditionFragment;", "Lcom/bytedance/ee/bear/sheet/filter/OfficeBaseSubFilterFragment;", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter$OnFilterActionListener;", "<init>", "()V", "scrollView", "Landroid/view/View;", "placeHolder", "recyclerView", "Lcom/bytedance/ee/bear/widgets/BaseRecyclerView;", "filterConditionAdapter", "Lcom/bytedance/ee/bear/sheet/filter/FilterConditionAdapter;", "valueList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "isMaxHeight", "", "isKeyboardingShowing", "keyboardHeight", "", "isColRangeChanged", "changedCol", "lastCurrentCol", "layoutResId", "getLayoutResId", "()I", "panelName", "", "getPanelName", "()Ljava/lang/String;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "orientation", "scrollPanel", "onChangeToMidPosition", "onChangeToMaxPosition", "notifyAdapterKeyboardClosed", "onFilterConditionListener", ResourceData.KEY_ID, "value", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "onEditorActionListener", "notifyColRangeChanged", "index", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSubFilterConditionFragment extends OfficeBaseSubFilterFragment implements FilterConditionAdapter.b {
    public final String A;
    public View o;
    public View p;
    public BaseRecyclerView q;
    public FilterConditionAdapter r;
    public final List<FilterData.FilterOptionItem> s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public final int z;

    public static final class a implements Runnable {
        public final /* synthetic */ OfficeSubFilterConditionFragment a;
        public final /* synthetic */ int b;

        public a(OfficeSubFilterConditionFragment r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.o;     // Catch: Throwable -> L7
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");     // Catch: Throwable -> L7
            r0 = null;
        L5:
            r0.scrollBy(0, this.a.v - this.b);     // Catch: Throwable -> L7
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
        int[] r0 = new int[2];
        View r1 = getView();
        View r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.findFocus();
    L6:
        if (r3 == null) goto L24;
        r3.getLocationOnScreen(r0);
        int r4 = ((com.bytedance.ee.util.ui.n.t() - r0[1]) - r3.getHeight()) - com.bytedance.ee.util.ui.n.d(20);
        if (r4 >= this.v) goto L25;
        View r5 = this.p;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r5 = null;
    L12:
        r5.setVisibility(0);
        View r6 = this.p;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r6 = null;
    L15:
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        r7.height = this.v;
        View r8 = this.p;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r8 = null;
    L18:
        r8.setLayoutParams(r7);
        View r9 = this.p;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
    L22:
        r2.post(new a(this, r4));
        return;
    L21:
        r2 = r9;
        goto L22
    L25:
        return;
    L24:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void Q5() {
        if (this.u == false) goto L5;
        da0();
    L5:
        this.t = true;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment, com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void W6() {
        if (this.u == true) goto L5;
    L7:
        this.t = false;
        return;
    L5:
        if (this.t == false) goto L7;
        rcb.c.c(getContext());
        goto L7
    }

    public final void ca0() {
        FilterConditionAdapter r0 = this.r;
        if (r0 == null) goto L5;
        int r1 = r0.c;
    L6:
        CommonRecyclerView r2 = this.q;
        RecyclerView r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r2 = null;
    L9:
        View r4 = r2.getChildAt(r1);
        if (r4 == null) goto L19;
        RecyclerView r5 = this.q;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L15:
        RecyclerView.ViewHolder r6 = r3.getChildViewHolder(r4);
        FilterConditionAdapter r7 = this.r;
        if (r7 == null) goto L20;
        Intrinsics.checkNotNull(r6);
        r7.y2(r1, r6);
        return;
    L20:
        return;
    L14:
        r3 = r5;
        goto L15
    L19:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public OfficeSubFilterConditionFragment() {
        this.s = new ArrayList();
        this.y = -1;
        this.z = 2131564554;
        this.A = FilterData.FilterSheetItem.Id.FILTER_CONDITION;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterConditionAdapter.b
    public final void c60() {
        SheetDragView r0 = W90();
        r0.x.a();
        r0.C = false;
        rcb.c.c(getContext());
        ca0();
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final int X90() {
        return this.z;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final String Y90() {
        return this.A;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final void aa0(int r2) {
        if (this.u == false) goto L5;
        this.w = true;
        this.x = r2;
        rcb.c.c(getContext());
        return;
    L5:
        super.aa0(r2);
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final void ba0(FilterData.FilterSheetItem r5) {
        Intrinsics.checkNotNullParameter(r5, "filterSheetItem");
        ((ArrayList) this.s).clear();
        FilterData.FilterOptionItem[] r0 = r5.getList();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L11:
        View r2 = null;
        if (r1 == true) goto L18;
        List<FilterData.FilterOptionItem> r3 = this.s;
        FilterData.FilterOptionItem[] r6 = r5.getList();
        if (r6 == null) goto L16;
        List r7 = ArraysKt.toMutableList(r6);
    L17:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
        ((ArrayList) r3).addAll((ArrayList) r7);
        goto L18
    L16:
        r7 = null;
    L18:
        Context r4 = getContext();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.content.Context");
        FilterConditionAdapter r8 = new FilterConditionAdapter(r4, this.s);
        this.r = r8;
        r8.d = this;
        RecyclerView r9 = this.q;
        if (r9 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r9 = null;
    L21:
        r9.setAdapter(this.r);
        if (this.w == false) goto L24;
        aa0(this.x);
        this.w = false;
    L24:
        int r10 = this.y;
        int r11 = this.l;
        if (r10 == r11) goto L32;
        this.y = r11;
        View r12 = this.o;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
    L30:
        r2.setScrollY(0);
        return;
    L29:
        r2 = r12;
        goto L30
    L32:
        return;
    L5:
        if (r0.length != 0) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == true) goto L11;
        r1 = false;
        goto L11
    L7:
        r13 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        this.o = r6.findViewById(2131385238);
        com.bytedance.ee.bear.facade.common.widget.d r8 = W90().x;
        if (r8.b() < ((int) r8.c[2])) goto L5;
        boolean r9 = true;
    L6:
        this.t = r9;
        this.p = r6.findViewById(2131382393);
        BaseRecyclerView r10 = (BaseRecyclerView) r6.findViewById(2131392193);
        this.q = r10;
        RecyclerView r11 = null;
        if (r10 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r10 = null;
    L9:
        r10.setSceneTag("subFilterConditionFragment_rv");
        RecyclerView r12 = this.q;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r12 = null;
    L12:
        r12.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView r13 = this.q;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r13 = null;
    L15:
        r13.setHasFixedSize(true);
        RecyclerView r14 = this.q;
        if (r14 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L19:
        r11.setNestedScrollingEnabled(false);
        return;
    L18:
        r11 = r14;
        goto L19
    L5:
        r9 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterConditionAdapter.b
    public final void sK(String r7, String[] r8) {
        Intrinsics.checkNotNullParameter(r8, "value");
        int r0 = r8.length;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L15;
        String r4 = r8[r2];
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L13;
        r2 = r2 + 1;
        goto L3
    L13:
        boolean r1 = false;
    L16:
        int r6 = r8.length;
        int r9 = 0;
    L17:
        if (r9 >= r6) goto L28;
        String r10 = r8[r9];
        if (r10 != null) goto L21;
    L24:
        boolean r11 = true;
    L25:
        if (r11 == true) goto L29;
        r9 = r9 + 1;
    L29:
        if (r7 == null) goto L34;
        if (r3 == false) goto L32;
        if (r1 == false) goto L34;
    L32:
        U90(r7, r8);
        return;
    L34:
        if (this.w == false) goto L42;
        aa0(this.x);
        this.w = false;
        return;
    L42:
        return;
    L21:
        if (r10.length() == 0) goto L24;
        r11 = false;
        goto L25
    L28:
        r3 = false;
        goto L29
    L8:
        if (r4.length() == 0) goto L11;
        r5 = false;
        goto L12
    L15:
        r1 = true;
        goto L16
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "khp");
        if (r2 <= 0) goto L8;
        this.v = r2;
        this.u = true;
        if (this.t == false) goto L7;
        da0();
        return;
    L7:
        W90().n();
        return;
    L8:
        this.u = false;
        View r4 = this.p;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("placeHolder");
        r4 = null;
    L11:
        r4.setVisibility(8);
        ca0();
    }
}
