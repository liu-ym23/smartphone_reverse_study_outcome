package com.bytedance.ee.bear.sheet.filter;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\u001bH\u0002J \u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/SubFilterColorFragment;", "Lcom/bytedance/ee/bear/sheet/filter/BaseSubFilterFragment;", "<init>", "()V", "noneOptionContainer", "Landroid/widget/LinearLayout;", "noneOption", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "noneOptionText", "Landroid/widget/TextView;", "backgroundColorView", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView;", "foregroundColorView", "tipsView", "Landroid/view/View;", "optionList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "layoutResId", "", "getLayoutResId", "()I", "panelName", "", "getPanelName", "()Ljava/lang/String;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "initView", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "hideView", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SubFilterColorFragment extends BaseSubFilterFragment {
    public LinearLayout o;
    public UDCheckBox p;
    public TextView q;
    public FilterPanelColorView r;
    public FilterPanelColorView s;
    public View t;
    public List<FilterData.FilterOptionItem> u;
    public final int v;
    public final String w;

    public static final class a {
    }

    static {
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "khp");
    }

    public SubFilterColorFragment() {
        this.u = new ArrayList();
        this.v = 2131564553;
        this.w = FilterData.FilterSheetItem.Id.FILTER_COLOR;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final int X90() {
        return this.v;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final String Y90() {
        return this.w;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final void ba0(FilterData.FilterSheetItem r8) {
        Intrinsics.checkNotNullParameter(r8, "filterSheetItem");
        this.u.clear();
        FilterData.FilterOptionItem[] r0 = r8.getList();
        boolean r1 = true;
        if (r0 == null) goto L12;
        if (r0.length != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        r1 = false;
        goto L12
    L7:
        r2 = false;
    L12:
        if (r1 == true) goto L18;
        FilterData.FilterOptionItem[] r9 = r8.getList();
        if (r9 == null) goto L16;
        List r10 = ArraysKt.toMutableList(r9);
    L17:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
        this.u = (ArrayList) r10;
        goto L18
    L16:
        r10 = null;
    L18:
        LinearLayout r11 = this.o;
        if (r11 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionContainer");
        r11 = null;
    L21:
        int r3 = 8;
        r11.setVisibility(8);
        FilterPanelColorView r12 = this.r;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r12 = null;
    L24:
        r12.setVisibility(8);
        FilterPanelColorView r13 = this.s;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
        r13 = null;
    L27:
        r13.setVisibility(8);
        View r14 = this.t;
        if (r14 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("tipsView");
        r14 = null;
    L31:
        if (this.u.isEmpty() == false) goto L33;
        r3 = 0;
    L33:
        r14.setVisibility(r3);
        Iterator<FilterData.FilterOptionItem> r15 = this.u.iterator();
    L35:
        if (r15.hasNext() == false) goto L56;
        FilterData.FilterOptionItem r4 = r15.next();
        View r5 = getView();
        if (r5 == null) goto L39;
        View r6 = r5.findViewWithTag(r4.getId());
    L40:
        if (r6 == null) goto L35;
        r6.setVisibility(0);
        if (Intrinsics.areEqual(r4.getId(), "noColor") == false) goto L54;
        LinearLayout r7 = this.o;
        if (r7 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionContainer");
        r7 = null;
    L46:
        r7.setVisibility(0);
        TextView r16 = this.q;
        if (r16 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionText");
        r16 = null;
    L49:
        r16.setText(r4.getTitle());
        UDCheckBox r17 = this.p;
        if (r17 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r17 = null;
    L52:
        r17.setChecked(r4.isSelect());
    L54:
        if ((r6 instanceof FilterPanelColorView) == false) goto L35;
        ((FilterPanelColorView) r6).b(r4);
        goto L35
    L39:
        r6 = null;
        goto L40
    }

    @Override // com.bytedance.ee.bear.sheet.filter.BaseSubFilterFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        this.o = (LinearLayout) r4.findViewWithTag("noColorContainer");
        this.p = r4.findViewWithTag("noColor");
        this.q = (TextView) r4.findViewWithTag("noColorText");
        this.r = (FilterPanelColorView) r4.findViewWithTag("backgroundColor");
        this.s = (FilterPanelColorView) r4.findViewWithTag("foregroundColor");
        this.t = r4.findViewById(2131388741);
        FilterPanelColorView r6 = this.r;
        FilterPanelColorView r0 = null;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r6 = null;
    L5:
        r6.setColorUpdateListener(new b0(this));
        FilterPanelColorView r7 = this.s;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
        r7 = null;
    L8:
        r7.setColorUpdateListener(new c0(this));
        LinearLayout r8 = this.o;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionContainer");
        r8 = null;
    L11:
        r8.setOnClickListener(new vm5.d(this));
        View r9 = this.p;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r9 = null;
    L14:
        r9.setOnClickListener(new vm5.e(this));
        FilterPanelColorView r10 = this.r;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r10 = null;
    L17:
        r10.setOnCheckedChangeListener(new d0(this));
        FilterPanelColorView r11 = this.s;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
    L21:
        r0.setOnCheckedChangeListener(new e0(this));
        return;
    L20:
        r0 = r11;
        goto L21
    }
}
