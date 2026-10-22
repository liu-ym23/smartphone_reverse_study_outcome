package com.bytedance.ee.bear.bitable.filter.view.ddui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.fastjson.JSON;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.bitable.ddui.DDUIModel;
import com.bytedance.ee.bear.bitable.ddui.model.AddConditionModel;
import com.bytedance.ee.bear.bitable.ddui.model.ConditionItemModel;
import com.bytedance.ee.bear.bitable.ddui.model.FilterInfoModel;
import com.bytedance.ee.bear.bitable.ddui.model.ImageWidgetModel;
import com.bytedance.ee.bear.bitable.ddui.model.TextWidgetModel;
import com.bytedance.ee.bear.bitable.ddui.model.TitleWidgetModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020\u0017H\u0002J\u0012\u0010,\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010/\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00100\u001a\u00020.H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/view/ddui/BitableFilterVisibilityPanelFragment;", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/BaseBitableFilterPanelFragment;", "<init>", "()V", "addNewRuleBtnFromXml", "Landroid/widget/LinearLayout;", "getAddNewRuleBtnFromXml", "()Landroid/widget/LinearLayout;", "setAddNewRuleBtnFromXml", "(Landroid/widget/LinearLayout;)V", "addBtnIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getAddBtnIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setAddBtnIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "addBtnTextFromXml", "Landroid/widget/TextView;", "getAddBtnTextFromXml", "()Landroid/widget/TextView;", "setAddBtnTextFromXml", "(Landroid/widget/TextView;)V", "clearFromXmlViewCache", "", "onDestroyView", "mFilterInfoView", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/FilterInfoViewV2;", "mFilterInfo", "Lcom/bytedance/ee/bear/bitable/ddui/model/FilterInfoModel;", "onCreateContentView", "Landroid/view/View;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "initPanelStyle", "initView", RootDescription.ROOT_ELEMENT, "updateData", "updateTitleBar", "updateEmptyState", "updateAddCondition", "initWidgetData", "data", "", "updateWidgetData", "getComponentType", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFilterVisibilityPanelFragment extends BaseBitableFilterPanelFragment {
    public LinearLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public AppCompatImageView f212083J;
    public TextView K;
    public FilterInfoViewV2 L;
    public FilterInfoModel M;

    public static final class a {
    }

    static {
    }

    @Override // bs4.c
    public final String getComponentType() {
        return DDUIModel.ComponentType.FILTER_LARK_FORM_FIELD_VISIBILITY_PANEL.getValue();
    }

    public final void ya0() {
        FilterInfoModel r100 = this.M;
        boolean r101 = true;
        View r102 = null;
        if (r100 == null) goto L19;
        final TitleWidgetModel r103 = r100.getTitleBar();
        if (r103 == null) goto L19;
        TextWidgetModel r104 = r103.getLeftText();
        if (r104 == null) goto L9;
        String r105 = r104.getText();
    L10:
        sa0(1, new Pair(null, r105), Integer.valueOf(R.color.primary_pri_500), new BitableFilterVisibilityPanelFragment$updateTitleBar$1$1(this, r103));
        TextWidgetModel r106 = r103.getRightText();
        if (r106 == null) goto L13;
        String r107 = r106.getText();
    L14:
        ua0(new Pair(null, r107), Integer.valueOf(R.color.primary_pri_500), new BitableFilterVisibilityPanelFragment$updateTitleBar$1$2(this, r103));
        TextWidgetModel r108 = r103.getCenterText();
        if (r108 == null) goto L17;
        String r109 = r108.getText();
    L18:
        va0(r109);
        goto L19
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
    L19:
        FilterInfoModel r110 = this.M;
        int r111 = 0;
        if (r110 == null) goto L24;
        ArrayList<ConditionItemModel> r112 = r110.getConditions();
        if (r112 == null) goto L24;
        int r113 = r112.size();
    L25:
        if (r113 > 0) goto L28;
        r101 = false;
    L28:
        FilterInfoViewV2 r114 = this.L;
        if (r114 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterInfoView");
        r114 = null;
    L31:
        if (r101 == false) goto L33;
        int r115 = 0;
    L34:
        r114.setVisibility(r115);
        View r116 = this.I;
        if (r116 != null) goto L41;
        View r117 = getView();
        if (r117 == null) goto L39;
        r116 = r117.findViewById(R.id.addNewRuleBtn);
    L40:
        this.I = (LinearLayout) r116;
        goto L41
    L39:
        r116 = null;
    L41:
        ViewGroup.LayoutParams r118 = ((LinearLayout) r116).getLayoutParams();
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r119 = (LinearLayout.LayoutParams) r118;
        if (r101 == true) goto L45;
        r111 = y9c.d.a(16);
    L45:
        r119.topMargin = r111;
        FilterInfoModel r120 = this.M;
        if (r120 == null) goto L78;
        AddConditionModel r121 = r120.getAddCondition();
        if (r121 == null) goto L79;
        Context r122 = getContext();
        if (r122 == null) goto L54;
        ImageWidgetModel r123 = r121.getLeftIcon();
        if (r123 == null) goto L54;
        Integer r124 = r123.getIconRes(r122);
    L55:
        if (r124 == null) goto L64;
        int r125 = r124.intValue();
        View r126 = this.f212083J;
        if (r126 != null) goto L63;
        View r127 = getView();
        if (r127 == null) goto L61;
        r126 = r127.findViewById(R.id.addBtnIcon);
    L62:
        this.f212083J = (AppCompatImageView) r126;
        goto L63
    L61:
        r126 = null;
    L63:
        ((AppCompatImageView) r126).setImageResource(r125);
    L64:
        View r128 = this.K;
        if (r128 != null) goto L70;
        View r129 = getView();
        if (r129 == null) goto L69;
        r102 = r129.findViewById(R.id.addBtnText);
    L69:
        this.K = (TextView) r102;
        r128 = r102;
    L70:
        TextView r130 = (TextView) r128;
        TextWidgetModel r131 = r121.getContent();
        if (r131 == null) goto L75;
        String r132 = r131.getText();
        if (r132 == null) goto L75;
    L76:
        r130.setText(r132);
        return;
    L75:
        r132 = "";
    L54:
        r124 = null;
        goto L55
    L79:
        return;
    L78:
        return;
    L33:
        r115 = 8;
    L24:
        r113 = 0;
        goto L25
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.I = null;
        this.f212083J = null;
        this.K = null;
    }

    public BitableFilterVisibilityPanelFragment() {
    }

    @Override // bs4.c
    public final void ML(String r100) {
        if (r100 == null) goto L10;
        this.M = (FilterInfoModel) JSON.parseObject(r100, FilterInfoModel.class);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("BitableFilterVisibilityPanelFragment", "initData failed", e, false);
        return;
    }

    @Override // bs4.c
    public final void OE(String r100) {
        if (r100 == null) goto L13;
        FilterInfoModel r101 = (FilterInfoModel) JSON.parseObject(r100, FilterInfoModel.class);     // Catch: Exception -> L8
        this.M = r101;     // Catch: Exception -> L8
        FilterInfoViewV2 r102 = this.L;     // Catch: Exception -> L8
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterInfoView");     // Catch: Exception -> L8
        r102 = null;
    L6:
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L8
        r102.e(r101);     // Catch: Exception -> L8
        ya0();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        tt5.a.e("BitableFilterVisibilityPanelFragment", "setData failed", e, false);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return LayoutInflater.from(requireContext()).inflate(R.layout.bitable_filter_field_visibility_panel, r100, false);
    }

    @Override // com.bytedance.ee.bear.bitable.filter.view.ddui.BaseBitableFilterPanelFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f209815p = 0;
        FilterInfoViewV2 r102 = null;
        com.bytedance.ee.bear.bitable.common.fragment.b.c(this, Float.valueOf(0.9f), null, null, 6);
        qa0(true);
        pa0(R.color.bg_float_base);
        FilterInfoViewV2 r103 = (FilterInfoViewV2) r100.findViewById(R.id.filter_info_view);
        r103.setOnItemClickListener(new BitableFilterVisibilityPanelFragment$initView$1$1(this));
        this.L = r103;
        View r104 = this.I;
        if (r104 != null) goto L9;
        View r105 = getView();
        if (r105 == null) goto L7;
        r104 = r105.findViewById(R.id.addNewRuleBtn);
    L8:
        this.I = (LinearLayout) r104;
        goto L9
    L7:
        r104 = null;
    L9:
        ((LinearLayout) r104).setOnClickListener(new c(this));
        FilterInfoModel r106 = this.M;
        if (r106 == null) goto L16;
        FilterInfoViewV2 r107 = this.L;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterInfoView");
    L15:
        r102.e(r106);
        goto L16
    L14:
        r102 = r107;
    L16:
        ya0();
    }
}
