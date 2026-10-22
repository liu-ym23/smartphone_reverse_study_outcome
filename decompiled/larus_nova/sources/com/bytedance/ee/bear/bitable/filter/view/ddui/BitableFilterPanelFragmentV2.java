package com.bytedance.ee.bear.bitable.filter.view.ddui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.widget.NestedScrollView;
import com.alibaba.fastjson.JSON;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.ddui.DDUIModel;
import com.bytedance.ee.bear.bitable.ddui.model.ConditionItemModel;
import com.bytedance.ee.bear.bitable.ddui.model.FilterInfoModel;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u0012\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\u0012\u0010$\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/view/ddui/BitableFilterPanelFragmentV2;", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/BaseBitableFilterPanelFragment;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "<init>", "()V", "mNonePermissionTip", "Lcom/larksuite/component/universe_design/notice/UDNotice;", "mFilterPanel", "Landroidx/core/widget/NestedScrollView;", "mFilterInfoView", "Lcom/bytedance/ee/bear/bitable/filter/view/ddui/FilterInfoViewV2;", "mEmptyState", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "mFilterInfo", "Lcom/bytedance/ee/bear/bitable/ddui/model/FilterInfoModel;", "onCreateContentView", "Landroid/view/View;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "savedInstanceState", "Landroid/os/Bundle;", "initPanelStyle", "initView", RootDescription.ROOT_ELEMENT, "initWidgetData", "data", "", "initAddConditionView", "updateEmptyStateVisibility", "currentFilterInfo", WidgetCostModule.TYPE_ON_START, "onDraw", LiveCommonConstants.REASON_ON_DEDTROY, "updateWidgetData", "getComponentType", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFilterPanelFragmentV2 extends BaseBitableFilterPanelFragment implements ViewTreeObserver.OnDrawListener {
    public UDNotice I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public NestedScrollView f212082J;
    public FilterInfoViewV2 K;
    public SpaceEmptyState L;
    public FilterInfoModel M;

    public static final class a {
    }

    static {
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        int[] r100 = new int[2];
        NestedScrollView r101 = this.f212082J;
        SpaceEmptyState r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterPanel");
        r101 = null;
    L5:
        r101.getLocationInWindow(r100);
        int[] r103 = new int[2];
        ka0().getLocationInWindow(r103);
        int r104 = r103[1] - r100[1];
        View r105 = ka0();
        if (r104 <= 0) goto L8;
        int r106 = 0;
    L9:
        r105.setVisibility(r106);
        SpaceEmptyState r107 = this.L;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r107 = null;
    L13:
        if (r107.getVisibility() != 0) goto L25;
        SpaceEmptyState r108 = this.L;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r108 = null;
    L17:
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L26;
        r109.height = r104;
        SpaceEmptyState r110 = this.L;
        if (r110 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
    L23:
        r102.setLayoutParams(r109);
        return;
    L22:
        r102 = r110;
        goto L23
    L26:
        return;
    L25:
        return;
    L8:
        r106 = 8;
        goto L9
    }

    @Override // bs4.c
    public final String getComponentType() {
        return DDUIModel.ComponentType.FILTER_PANEL.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.view.ddui.BaseBitableFilterPanelFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        NestedScrollView r100 = this.f212082J;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterPanel");
        r100 = null;
    L5:
        r100.getViewTreeObserver().removeOnDrawListener(this);
        bs4.b r101 = this.H;
        if (r101 == null) goto L9;
        r101.handleOrientationState(false);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        ja0().setOnClickListener(new b(this));
        na0(true);
        NestedScrollView r100 = this.f212082J;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterPanel");
        r100 = null;
    L5:
        r100.getViewTreeObserver().addOnDrawListener(this);
    }

    public BitableFilterPanelFragmentV2() {
    }

    @Override // bs4.c
    public final void ML(String r100) {
        if (r100 == null) goto L10;
        this.M = (FilterInfoModel) JSON.parseObject(r100, FilterInfoModel.class);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("BitableFilterPanelFragmentV2", "initData failed", e, false);
        return;
    }

    @Override // bs4.c
    public final void OE(String r100) {
        if (r100 != null) goto L23;
        return;
    L23:
        FilterInfoModel r101 = (FilterInfoModel) JSON.parseObject(r100, FilterInfoModel.class);     // Catch: Exception -> L20
        this.M = r101;     // Catch: Exception -> L20
        FilterInfoViewV2 r102 = this.K;     // Catch: Exception -> L20
        UDNotice r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterInfoView");     // Catch: Exception -> L20
        r102 = null;
    L8:
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L20
        r102.e(r101);     // Catch: Exception -> L20
        ya0(r101);     // Catch: Exception -> L20
        FilterInfoViewV2 r104 = this.K;     // Catch: Exception -> L20
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterInfoView");     // Catch: Exception -> L20
        r104 = null;
    L11:
        boolean r105 = r104.f();     // Catch: Exception -> L20
        UDNotice r106 = this.I;     // Catch: Exception -> L20
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mNonePermissionTip");     // Catch: Exception -> L20
    L15:
        if (r105 == false) goto L17;
        int r107 = 0;
    L18:
        r103.setVisibility(r107);     // Catch: Exception -> L20
        return;
    L17:
        r107 = 8;
        goto L18
    L14:
        r103 = r106;
    L20:
        e = move-exception;
        tt5.a.e("BitableFilterPanelFragmentV2", "setData failed", e, false);
    }

    @Override // com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment
    public final View la0(CommonActionPanelLayout r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        return LayoutInflater.from(requireContext()).inflate(R.layout.bitable_filter_panel_fragment_v2, r100, false);
    }

    public final void ya0(FilterInfoModel r100) {
        int r101 = 0;
        if (r100 == null) goto L7;
        ArrayList<ConditionItemModel> r102 = r100.getConditions();
        if (r102 == null) goto L7;
        int r103 = r102.size();
    L8:
        if (r103 <= 0) goto L10;
        boolean r104 = true;
    L11:
        SpaceEmptyState r105 = this.L;
        FilterInfoViewV2 r106 = null;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r105 = null;
    L15:
        if (r104 == false) goto L17;
        int r107 = 8;
    L18:
        r105.setVisibility(r107);
        FilterInfoViewV2 r108 = this.K;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterInfoView");
    L22:
        if (r104 == true) goto L25;
        r101 = 8;
    L25:
        r106.setVisibility(r101);
        return;
    L21:
        r106 = r108;
        goto L22
    L17:
        r107 = 0;
        goto L18
    L10:
        r104 = false;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.bytedance.ee.bear.bitable.filter.view.ddui.BaseBitableFilterPanelFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        bs4.b r102 = this.H;
        if (r102 == null) goto L5;
        r102.handleOrientationState(true);
    L5:
        int r103 = 0;
        this.f209815p = 0;
        UDNotice r104 = null;
        com.bytedance.ee.bear.bitable.common.fragment.b.c(this, Float.valueOf(0.45f), null, null, 6);
        qa0(true);
        pa0(R.color.bg_float_base);
        va0(getString(R.string.Bitable_Record_SetFilterCondition));
        this.I = (UDNotice) r100.findViewById(R.id.none_permission_tip);
        this.L = (SpaceEmptyState) r100.findViewById(R.id.empty_state);
        this.f212082J = (NestedScrollView) r100.findViewById(R.id.filter_panel);
        FilterInfoViewV2 r105 = (FilterInfoViewV2) r100.findViewById(R.id.filter_info_view);
        r105.setOnFilterInfoChangedListener(new BitableFilterPanelFragmentV2$initView$1$1(this));
        r105.setOnItemClickListener(new BitableFilterPanelFragmentV2$initView$1$2(this));
        r105.setFragmentManager(getChildFragmentManager());
        this.K = r105;
        FilterInfoModel r106 = this.M;
        if (r106 == null) goto L8;
        r105.e(r106);
    L8:
        ya0(this.M);
        FilterInfoViewV2 r107 = this.K;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterInfoView");
        r107 = null;
    L11:
        boolean r108 = r107.f();
        UDNotice r109 = this.I;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mNonePermissionTip");
    L15:
        if (r108 == true) goto L18;
        r103 = 8;
    L18:
        r104.setVisibility(r103);
        return;
    L14:
        r104 = r109;
        goto L15
    }
}
