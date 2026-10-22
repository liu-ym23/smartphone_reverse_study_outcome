package com.bytedance.ee.bear.sheet.filter;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\u001bH\u0002J \u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/sheet/filter/OfficeSubFilterColorFragment;", "Lcom/bytedance/ee/bear/sheet/filter/OfficeBaseSubFilterFragment;", "<init>", "()V", "noneOptionContainer", "Landroid/widget/LinearLayout;", "noneOption", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "noneOptionText", "Landroid/widget/TextView;", "backgroundColorView", "Lcom/bytedance/ee/bear/sheet/filter/FilterPanelColorView;", "foregroundColorView", "tipsView", "Landroid/view/View;", "optionList", "", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterOptionItem;", "layoutResId", "", "getLayoutResId", "()I", "panelName", "", "getPanelName", "()Ljava/lang/String;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "initView", "updatePanelData", "filterSheetItem", "Lcom/bytedance/ee/bear/sheet/filter/FilterData$FilterSheetItem;", "hideView", "onKeyboardHeightChanged", "khp", "Lcom/ss/android/lark/edit/keyboard/provider/KeyboardHeightProvider;", "keyboardHeight", "orientation", "Companion", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSubFilterColorFragment extends OfficeBaseSubFilterFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f237742o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public UDCheckBox f237743p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f237744q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FilterPanelColorView f237745r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FilterPanelColorView f237746s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f237747t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<FilterData.FilterOptionItem> f237748u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f237749v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f237750w;

    public static final class a {
    }

    static {
    }

    @Override // ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "khp");
    }

    public OfficeSubFilterColorFragment() {
        this.f237748u = new ArrayList();
        this.f237749v = R.layout.sheet_filter_color_fragment;
        this.f237750w = FilterData.FilterSheetItem.Id.FILTER_COLOR;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final int X90() {
        return this.f237749v;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final String Y90() {
        return this.f237750w;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment
    public final void ba0(FilterData.FilterSheetItem r100) {
        Intrinsics.checkNotNullParameter(r100, "filterSheetItem");
        this.f237748u.clear();
        FilterData.FilterOptionItem[] r101 = r100.getList();
        boolean r102 = true;
        if (r101 == null) goto L12;
        if (r101.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L12;
        r102 = false;
        goto L12
    L7:
        r103 = false;
    L12:
        if (r102 == true) goto L18;
        FilterData.FilterOptionItem[] r104 = r100.getList();
        if (r104 == null) goto L16;
        List r105 = ArraysKt.toMutableList(r104);
    L17:
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.sheet.filter.FilterData.FilterOptionItem>");
        this.f237748u = (ArrayList) r105;
        goto L18
    L16:
        r105 = null;
    L18:
        LinearLayout r106 = this.f237742o;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionContainer");
        r106 = null;
    L21:
        int r107 = 8;
        r106.setVisibility(8);
        FilterPanelColorView r108 = this.f237745r;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r108 = null;
    L24:
        r108.setVisibility(8);
        FilterPanelColorView r109 = this.f237746s;
        if (r109 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
        r109 = null;
    L27:
        r109.setVisibility(8);
        View r110 = this.f237747t;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("tipsView");
        r110 = null;
    L31:
        if (this.f237748u.isEmpty() == false) goto L33;
        r107 = 0;
    L33:
        r110.setVisibility(r107);
        Iterator<FilterData.FilterOptionItem> r111 = this.f237748u.iterator();
    L35:
        if (r111.hasNext() == false) goto L56;
        FilterData.FilterOptionItem r112 = r111.next();
        View r113 = getView();
        if (r113 == null) goto L39;
        View r114 = r113.findViewWithTag(r112.getId());
    L40:
        if (r114 == null) goto L35;
        r114.setVisibility(0);
        if (Intrinsics.areEqual(r112.getId(), "noColor") == false) goto L54;
        LinearLayout r115 = this.f237742o;
        if (r115 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionContainer");
        r115 = null;
    L46:
        r115.setVisibility(0);
        TextView r116 = this.f237744q;
        if (r116 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionText");
        r116 = null;
    L49:
        r116.setText(r112.getTitle());
        UDCheckBox r117 = this.f237743p;
        if (r117 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r117 = null;
    L52:
        r117.setChecked(r112.isSelect());
    L54:
        if ((r114 instanceof FilterPanelColorView) == false) goto L35;
        ((FilterPanelColorView) r114).b(r112);
        goto L35
    L39:
        r114 = null;
        goto L40
    }

    @Override // com.bytedance.ee.bear.sheet.filter.OfficeBaseSubFilterFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f237742o = (LinearLayout) r100.findViewWithTag("noColorContainer");
        this.f237743p = (UDCheckBox) r100.findViewWithTag("noColor");
        this.f237744q = (TextView) r100.findViewWithTag("noColorText");
        this.f237745r = (FilterPanelColorView) r100.findViewWithTag("backgroundColor");
        this.f237746s = (FilterPanelColorView) r100.findViewWithTag("foregroundColor");
        this.f237747t = r100.findViewById(R.id.tips);
        FilterPanelColorView r102 = this.f237745r;
        FilterPanelColorView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r102 = null;
    L5:
        r102.setColorUpdateListener(new w(this));
        FilterPanelColorView r104 = this.f237746s;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
        r104 = null;
    L8:
        r104.setColorUpdateListener(new x(this));
        LinearLayout r105 = this.f237742o;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("noneOptionContainer");
        r105 = null;
    L11:
        r105.setOnClickListener(new vm5.b(this));
        UDCheckBox r106 = this.f237743p;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("noneOption");
        r106 = null;
    L14:
        r106.setOnClickListener(new vm5.c(this));
        FilterPanelColorView r107 = this.f237745r;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("backgroundColorView");
        r107 = null;
    L17:
        r107.setOnCheckedChangeListener(new y(this));
        FilterPanelColorView r108 = this.f237746s;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("foregroundColorView");
    L21:
        r103.setOnCheckedChangeListener(new z(this));
        return;
    L20:
        r103 = r108;
        goto L21
    }
}
