package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.alibaba.fastjson.JSONArray;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bitable.cardview.GridViewLayoutType;
import com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.FieldItemTouchCallback;
import com.bytedance.ee.bear.bitable.databinding.BitableCardViewSettingFragmentBinding;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.bytedance.ee.bear.bitable.panel.BitablePanelModel;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import com.bytedance.ee.bear.bitable.uikit.setting.card.CardLayout;
import com.bytedance.ee.bear.bitable.uikit.setting.card.CardType;
import com.bytedance.ee.bear.bitable.uikit.setting.card.GridType;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002JC\u0010-\u001a\u00020\u001d2\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u0002000/j\b\u0012\u0004\u0012\u000200`12!\u00102\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001d03H\u0002J\u0010\u00108\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020!H\u0002J\b\u0010:\u001a\u00020\u001dH\u0016J\b\u0010;\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006="}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/CardViewSettingFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mobileSettingLayout", "Landroid/widget/LinearLayout;", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCardViewSettingFragmentBinding;", "isFgOn", "", "isPad", "rootViewWidth", "", "mAnimators", "", "Landroid/animation/AnimatorSet;", "mForceNestedScrollEnable", "viewSettingModel", "Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/ViewSettingModel;", "getViewSettingModel", "()Lcom/bytedance/ee/bear/bitable/cardview/viewsetting/ViewSettingModel;", "viewSettingModel$delegate", "Lkotlin/Lazy;", "onBoardingManager", "Lcom/bytedance/ee/bear/onboarding/export/IOnBoardingManager;", "getOnBoardingManager", "()Lcom/bytedance/ee/bear/onboarding/export/IOnBoardingManager;", "onBoardingManager$delegate", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViewSelectViewV2", "initRowSelectViewV2", "clearSkeletonViewAnimation", "initCoverFieldSelectViewV2", "initTitleFieldSelectView", "openSelectFieldPanel", "panelItemList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;", "Lkotlin/collections/ArrayList;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "initSelectFieldList", "initUnselectFieldList", LiveCommonConstants.REASON_ON_DEDTROY, "isCoverFeatureEnable", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardViewSettingFragment extends BaseFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f209207n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f209208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BitableCardViewSettingFragmentBinding f209209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f209210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f209211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f209212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<AnimatorSet> f209213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f209214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f209215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f209216m;

    public static final class a {
    }

    static {
    }

    public final ViewSettingModel V90() {
        return (ViewSettingModel) this.f209215l.getValue();
    }

    public CardViewSettingFragment() {
        this.f209210g = com.bytedance.ee.bear.bitable.c.h();
        this.f209211h = DeviceUtils.isPad();
        this.f209213j = new ArrayList();
        this.f209215l = LazyKt.lazy(new CardViewSettingFragment$viewSettingModel$2(this));
        this.f209216m = LazyKt.lazy(CardViewSettingFragment$onBoardingManager$2.INSTANCE);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        BitableToolboxAnalytic r100 = V90().getBitableToolboxAnalytic();
        if (r100 == null) goto L34;
        GridViewLayoutType r101 = V90().getOriginViewType();
        String r102 = "";
        if (r101 == null) goto L8;
        String r103 = r101.getTag();
        if (r103 == null) goto L8;
    L9:
        GridViewLayoutType r104 = V90().getViewType().getValue();
        if (r104 == null) goto L13;
        String r105 = r104.getTag();
        if (r105 == null) goto L13;
    L14:
        Integer r106 = V90().getColumnCount().getValue();
        if (r106 == null) goto L17;
        int r107 = r106.intValue();
    L18:
        String r108 = V90().getReportTitleFieldtype();
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        String r109 = V90().getReportSubTitleFieldtype();
        if (r109 == null) goto L25;
        r102 = r109;
    L25:
        int r110 = V90().getConfigFieldsSize();
        List<FilterFieldOption> r111 = V90().getUnConfigFieldsOption().getValue();
        if (r111 == null) goto L28;
        int r112 = r111.size();
    L29:
        JSONArray r113 = V90().getReportFiledSituation();
        FilterFieldOption r114 = V90().getCoverField().getValue();
        if (r114 == null) goto L32;
        String r115 = r114.getId();
    L33:
        int r116 = !TextUtils.isEmpty(r115) ? 1 : 0;
        Intrinsics.checkNotNullParameter(r103, "fromType");
        Intrinsics.checkNotNullParameter(r105, "toType");
        Intrinsics.checkNotNullParameter(r108, "titleFieldType");
        Intrinsics.checkNotNullParameter(r102, "summaryFieldType");
        Intrinsics.checkNotNullParameter(r113, "visibleSituation");
        HashMap r117 = new HashMap();
        r117.put("click", SVGRenderEngine.SAVE);
        r117.put("from_mobile_grid_type", r103);
        r117.put("to_mobile_grid_type", r105);
        r117.put("column_num", Integer.valueOf(r107));
        r117.put("title_field_type", r108);
        r117.put("summary_field_type", r102);
        r117.put("visible_field_num", Integer.valueOf(r110));
        r117.put("invisible_field_num", Integer.valueOf(r112));
        r117.put("field_visble_situation", r113);
        r117.put("is_cover_open", Integer.valueOf(r116));
        r117.put("building_type", r100.f209805a.d());
        Unit r118 = Unit.INSTANCE;
        r100.t(BitableToolboxAnalytic.ToolboxEvent.BITABLE_MOBILE_GRID_FORMAT_CLICK, r117);
        goto L34
    L32:
        r115 = null;
        goto L33
    L28:
        r112 = 0;
        goto L29
    L17:
        r107 = 3;
    L13:
        r105 = "";
    L8:
        r103 = "";
    L34:
        Iterator r119 = ((ArrayList) this.f209213j).iterator();
    L36:
        if (r119.hasNext() == false) goto L38;
        ((AnimatorSet) r119.next()).cancel();
        goto L36
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        boolean r102 = r101.getBoolean("force_nested_scroll");
    L6:
        this.f209214k = r102;
        if (this.f209210g == false) goto L14;
        Bundle r103 = getArguments();
        if (r103 == null) goto L11;
        int r104 = r103.getInt("root_view_width");
    L12:
        this.f209212i = r104;
        return;
    L11:
        r104 = com.bytedance.ee.util.ui.n.v();
        goto L12
    L14:
        return;
    L5:
        r102 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, com.bytedance.ee.bear.bitable.cardview.viewsetting.CardViewSettingFragment$initRowSelectViewV2$updateColSelect$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.bytedance.ee.bear.bitable.cardview.viewsetting.CardViewSettingFragment$initSelectFieldList$settingFieldListAdapter$1, com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.ViewSettingSelectFieldListAdapter] */
    /* JADX WARN: Type inference failed for: r3v5, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.bytedance.ee.bear.bitable.cardview.viewsetting.CardViewSettingFragment$initUnselectFieldList$2, com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.ViewSettingSelectFieldListAdapter] */
    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(final View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f209208e = (LinearLayout) r100.findViewById(R.id.mobileViewSettingLayout);
        CardType r102 = (CardType) r100.findViewById(R.id.card_type);
        GridType r103 = (GridType) r100.findViewById(R.id.grid_type);
        if (V90().getViewType().getValue() != GridViewLayoutType.CardViewLayout) goto L5;
        boolean r104 = true;
    L7:
        if (V90().getViewType().getValue() != GridViewLayoutType.GridViewLayout) goto L9;
        boolean r105 = true;
    L10:
        Boolean r106 = Boolean.valueOf(r104);
        if (r106 == null) goto L13;
        r102.getClass();
        boolean r107 = r106.booleanValue();
    L14:
        r102.setSelected(r107);
        r102.setOnClickListener(new m(this));
        Boolean r108 = Boolean.valueOf(r105);
        if (r108 == null) goto L17;
        r103.getClass();
        boolean r109 = r108.booleanValue();
    L18:
        r103.setSelected(r109);
        r103.setOnClickListener(new n(this));
        V90().getViewType().observe(getViewLifecycleOwner(), new o(r102, r103));
        V90().getViewSettingLayoutVisible().observe(getViewLifecycleOwner(), new p(this));
        final List r110 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.id.colSelect1), Integer.valueOf(R.id.colSelect2), Integer.valueOf(R.id.colSelect3)});
        if (this.f209210g == true) goto L21;
    L23:
        final MutableLiveData<Integer> r111 = V90().getColumnCount();
    L24:
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = new CardViewSettingFragment$initRowSelectViewV2$updateColSelect$1(r110, this, r111, r100);
        r111.observe(getViewLifecycleOwner(), new b(r112));
        V90().getCoverField().observe(getViewLifecycleOwner(), new c(r112));
        final UDSwitch r113 = (UDSwitch) r100.findViewById(R.id.cover_switcher);
        final View r114 = r100.findViewById(R.id.cover_switcher_wrapper);
        V90().getCoverField().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.bitable.cardview.viewsetting.a(new CardViewSettingFragment$initCoverFieldSelectViewV2$updateCover$1(this, r113, r114)));
        V90().getTitleField().observe(getViewLifecycleOwner(), new g(r100, this));
        V90().getSubTitleField().observe(getViewLifecycleOwner(), new h(r100, this));
        r100.findViewById(R.id.titleLayout).setOnClickListener(new CardViewSettingFragment$initTitleFieldSelectView$3$1(this));
        r100.findViewById(R.id.summaryLayout).setOnClickListener(new CardViewSettingFragment$initTitleFieldSelectView$4$1(this));
        RecyclerView r115 = (RecyclerView) r100.findViewById(R.id.selectFieldList);
        TextView r116 = (TextView) r100.findViewById(R.id.emptySelectTv);
        TextView r117 = (TextView) r100.findViewById(R.id.selectLimitTipsTv);
        r117.setText(xo5.a.c(requireContext(), R.string.Bitable_Mobile_CardMode_ShowUpToNumFields_Description, "num", Constants.VIA_SHARE_TYPE_MINI_PROGRAM));
        final Context r118 = requireContext();
        r115.setLayoutManager(new CardViewSettingFragment$initSelectFieldList$1(this, r118));
        r115.setNestedScrollingEnabled(this.f209214k);
        final Context r119 = requireContext();
        ?? r120 = new CardViewSettingFragment$initSelectFieldList$settingFieldListAdapter$1(r119);
        V90().getConfigFieldsOption().observe(getViewLifecycleOwner(), new e(r120, r116, r115, r117));
        f r121 = new f(this);
        Intrinsics.checkNotNullParameter(r121, "onIconClickListerner");
        r120.f209245c = r121;
        FieldItemTouchCallback r122 = new FieldItemTouchCallback(requireContext());
        r122.f209234b = new d(r120, this);
        new ItemTouchHelper(r122).attachToRecyclerView(r115);
        r115.setAdapter(r120);
        r115.removeItemDecorationAt(0);
        RecyclerView r123 = (RecyclerView) r100.findViewById(R.id.unSelectFieldList);
        View r124 = r100.findViewById(R.id.emptyUnSelectTv);
        TextView r125 = (TextView) r100.findViewById(R.id.hiddenFieldTv);
        final Context r126 = requireContext();
        r123.setLayoutManager(new CardViewSettingFragment$initUnselectFieldList$1(this, r126));
        r123.setNestedScrollingEnabled(this.f209214k);
        final Context r127 = requireContext();
        ?? r128 = new CardViewSettingFragment$initUnselectFieldList$2(this, r127);
        V90().getUnConfigFieldsOption().observe(getViewLifecycleOwner(), new j(r128, r124, r123));
        V90().getUnConfigHiddenField().observe(getViewLifecycleOwner(), new k(r125, this));
        l r129 = new l(this);
        Intrinsics.checkNotNullParameter(r129, "onIconClickListerner");
        r128.f209245c = r129;
        r123.setAdapter(r128);
        BitableToolboxAnalytic r130 = V90().getBitableToolboxAnalytic();
        if (r130 == null) goto L31;
        HashMap r131 = new HashMap();
        String r132 = r130.f209805a.b();
        if (r132 == null) goto L29;
        r131.put("mobile_grid_type", r132);
        r131.put("building_type", r130.f209805a.d());
    L29:
        Unit r133 = Unit.INSTANCE;
        r130.t("ccm_bitable_mobile_grid_format_view", r131);
        return;
    L31:
        return;
    L21:
        if (this.f209211h == false) goto L23;
        r111 = V90().getPadColumnCount();
        goto L24
    L17:
        r109 = false;
        goto L18
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    public static final void U90(CardViewSettingFragment r100, ArrayList r101, Function1 r102) {
        r100.getClass();
        if (com.bytedance.ee.bear.bitable.c.j() == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        Context r104 = r100.getContext();
        FragmentManager r105 = r100.getChildFragmentManager();
        BitablePanelModel r106 = new BitablePanelModel();
        r106.setTitle(r100.getString(R.string.Bitable_Relation_SelectField_Mobile));
        r106.setData(r101);
        r106.setDraggable(Boolean.TRUE);
        Unit r107 = Unit.INSTANCE;
        q r108 = new q(r102);
        if (r103 == true) goto L12;
        r100 = null;
    L12:
        com.bytedance.ee.bear.bitable.panel.e.m(r104, r105, r106, r108, r100, 16);
        return;
    L5:
        if (ForsetiHelper.r(r100) == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.bitable_card_view_setting_fragment, r101, false);
        int r104 = R.id.card_type;
        if (((CardType) ViewBindings.findChildViewById(r103, R.id.card_type)) == null) goto L55;
        r104 = R.id.colSelect1;
        if (((CardLayout) ViewBindings.findChildViewById(r103, R.id.colSelect1)) == null) goto L55;
        r104 = R.id.colSelect2;
        if (((CardLayout) ViewBindings.findChildViewById(r103, R.id.colSelect2)) == null) goto L55;
        r104 = R.id.colSelect3;
        if (((CardLayout) ViewBindings.findChildViewById(r103, R.id.colSelect3)) == null) goto L55;
        r104 = R.id.configTitle;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.configTitle)) == null) goto L55;
        r104 = R.id.coverFieldName;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r103, R.id.coverFieldName);
        if (r105 == null) goto L55;
        r104 = R.id.cover_switcher;
        if (((UDSwitch) ViewBindings.findChildViewById(r103, R.id.cover_switcher)) == null) goto L55;
        r104 = R.id.cover_switcher_wrapper;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.cover_switcher_wrapper);
        if (r106 == null) goto L55;
        r104 = R.id.coverTitle;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.coverTitle)) == null) goto L55;
        r104 = R.id.emptySelectTv;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.emptySelectTv)) == null) goto L55;
        r104 = R.id.emptyUnSelectTv;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.emptyUnSelectTv)) == null) goto L55;
        r104 = R.id.grid_type;
        if (((GridType) ViewBindings.findChildViewById(r103, R.id.grid_type)) == null) goto L55;
        r104 = R.id.hiddenFieldTv;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.hiddenFieldTv)) == null) goto L55;
        r104 = R.id.mobileViewSettingLayout;
        if (((LinearLayout) ViewBindings.findChildViewById(r103, R.id.mobileViewSettingLayout)) == null) goto L55;
        r104 = R.id.selectCoverFieldLayout;
        LinearLayout r107 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.selectCoverFieldLayout);
        if (r107 == null) goto L55;
        r104 = R.id.selectFieldContainer;
        if (((LKUIRoundableLayout) ViewBindings.findChildViewById(r103, R.id.selectFieldContainer)) == null) goto L55;
        r104 = R.id.selectFieldList;
        if (((RecyclerView) ViewBindings.findChildViewById(r103, R.id.selectFieldList)) == null) goto L55;
        r104 = R.id.selectLimitTipsTv;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.selectLimitTipsTv)) == null) goto L55;
        r104 = R.id.subTiltleContainer;
        if (((SpaceSettingGroupLayout) ViewBindings.findChildViewById(r103, R.id.subTiltleContainer)) == null) goto L55;
        r104 = R.id.summaryFieldName;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.summaryFieldName)) == null) goto L55;
        r104 = R.id.summaryLayout;
        if (((LinearLayout) ViewBindings.findChildViewById(r103, R.id.summaryLayout)) == null) goto L55;
        r104 = R.id.titleFieldName;
        if (((TextView) ViewBindings.findChildViewById(r103, R.id.titleFieldName)) == null) goto L55;
        r104 = R.id.titleLayout;
        if (((LinearLayout) ViewBindings.findChildViewById(r103, R.id.titleLayout)) == null) goto L55;
        r104 = R.id.unSelectFieldContainer;
        if (((LKUIRoundableLayout) ViewBindings.findChildViewById(r103, R.id.unSelectFieldContainer)) == null) goto L55;
        r104 = R.id.unSelectFieldList;
        if (((RecyclerView) ViewBindings.findChildViewById(r103, R.id.unSelectFieldList)) == null) goto L55;
        NestedScrollView r108 = (NestedScrollView) r103;
        this.f209209f = new BitableCardViewSettingFragmentBinding(r108, r105, r106, r107);
        return r108;
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
