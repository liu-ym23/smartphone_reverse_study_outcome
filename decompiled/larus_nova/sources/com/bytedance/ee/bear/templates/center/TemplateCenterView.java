package com.bytedance.ee.bear.templates.center;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.facade.common.widget.MainViewPager;
import com.bytedance.ee.bear.list.homepage.widget.CompatDrawableTextView;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes18.dex */
public final class TemplateCenterView implements IView, b.InterfaceC3431b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f238900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentManager f238901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f238902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TemplateCenterFragment f238903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f238904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CompatDrawableTextView f238905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f238906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f238907h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<Tab2> f238908i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f238909j;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        HashMap r100 = new HashMap();
        r100.put(EventConstant.Key.MODULE, ThumbGlideUrl.SOURCE_TEMPLATE);
        ((BaseTitleBar) this.f238902c.findViewById(R.id.titleBar)).setTag(R.id.title_bar_common_params, r100);
        Drawable r101 = l.a(this.f238902c.getContext(), R.drawable.ud_icon_search_outlined, R.color.facade_selector_icon_n1);
        ((BaseTitleBar) this.f238902c.findViewById(R.id.titleBar)).a(new k(r101, this), true);
        if (ForsetiHelper.b(this.f238903d) == false) goto L7;
        ((BaseTitleBar) this.f238902c.findViewById(R.id.titleBar)).setLeftExtraClickListener(new g(this));
    L7:
        if (h().filterEnable() == false) goto L14;
        int r102 = n.d(8);
        int r103 = n.d(16);
        int r104 = n.d(22);
        CompatDrawableTextView r105 = new CompatDrawableTextView(this.f238900a);
        r105.setTextSize(12.0f);
        r105.setBackgroundDrawable(AppCompatResources.getDrawable(this.f238900a, R.drawable.ud_icon_filter_outlined));
        r105.setPadding(r102, 0, r102, 0);
        r105.setTextColor(this.f238900a.getResources().getColor(R.color.primary_fill_default));
        r105.setGravity(16);
        r105.setOnClickListener(new h(this));
        this.f238905f = r105;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(r104, r104);
        r106.leftMargin = r102;
        r106.rightMargin = r103;
        BaseTitleBar r107 = (BaseTitleBar) this.f238902c.findViewById(R.id.titleBar);
        CompatDrawableTextView r108 = this.f238905f;
        r107.f240031f.addView(r108, -1, r106);
        if (DowngradeSettingUtil.a("downgradeSortFilterViewModel") == true) goto L12;
        ViewModelProvider.NewInstanceFactory r109 = ForsetiViewModelProvider.f216459c;
        SortAndFilterViewModel r110 = (SortAndFilterViewModel) ForsetiViewModelProvider.a.a(this.f238900a).get("templates", SortAndFilterViewModel.class);
    L13:
        r110.getSortStrategyLiveData().observe(this.f238900a, new i(this));
        h().getCurrentTabFilterStatus().observe(this.f238900a, new j(this));
        goto L14
    L12:
        r110 = (SortAndFilterViewModel) ViewModelProviders.of(this.f238900a).get(SortAndFilterViewModel.class);
    L14:
        wuc.a r111 = new wuc.a(this.f238900a);
        this.f238908i.add(Tab2.SYSTEM);
        if (h().isOnlyNewLarkForm() == false) goto L17;
        ((FrameLayout) this.f238902c.findViewById(R.id.groupIndicatorWrapper)).setVisibility(8);
    L20:
        b r112 = new b(this.f238900a, (MagicIndicator) this.f238902c.findViewById(R.id.groupIndicator), this.f238908i, this);
        this.f238909j = r112;
        r111.setAdapter(r112);
        r111.setAdjustMode(true);
        ((MagicIndicator) this.f238902c.findViewById(R.id.groupIndicator)).setNavigator(r111);
        ((MainViewPager) this.f238902c.findViewById(R.id.viewPager)).setCanScroll(false);
        ((MainViewPager) this.f238902c.findViewById(R.id.viewPager)).setAdapter(new TabAdapter(this.f238900a, this.f238901b, this.f238908i));
        ((MainViewPager) this.f238902c.findViewById(R.id.viewPager)).setOffscreenPageLimit(this.f238908i.size());
        b r113 = this.f238909j;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("tabIndicatorAdapter");
        r113 = null;
    L23:
        TemplateCenterViewModel.Companion.getClass();
        r113.d(TemplateCenterViewModel.access$getLAST_INDEX$cp());
        TemplateReportV2 r114 = TemplateReportV2.f238768a;
        int r115 = TemplateCenterViewModel.access$getLAST_INDEX$cp();
        String r116 = h().getEnterSource();
        if (r115 != 1) goto L26;
        String r117 = "ccm_template_usercenter_view";
    L30:
        TemplateReportV2.l(r114, r117, r116, null, null, 12);
        return;
    L26:
        if (r115 == 2) goto L28;
        r117 = "ccm_template_systemcenter_view";
        goto L30
    L28:
        r117 = "ccm_template_enterprisecenter_view";
        goto L30
    L17:
        this.f238908i.add(Tab2.CUSTOM);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.template_optimization_v4_business", false) == false) goto L20;
        this.f238908i.add(Tab2.BUSNISS);
        goto L20
    }

    public final TemplateCenterViewModel h() {
        return (TemplateCenterViewModel) this.f238907h.getValue();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k(sbb.e r100) {
        h().saveCurrentTabFilter(r100);
        if (Intrinsics.areEqual(r100, sbb.e.f541294e) == false) goto L7;
        CompatDrawableTextView r101 = this.f238905f;
        if (r101 == null) goto L11;
        int r102 = n.d(22);
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        r104.height = r102;
        r104.width = r102;
        r101.setLayoutParams(r104);
        r101.setBackgroundDrawable(AppCompatResources.getDrawable(this.f238900a, R.drawable.ud_icon_filter_outlined));
        l.b(r101, R.color.facade_selector_icon_n1);
        r101.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        r101.setText("");
        return;
    L11:
        return;
    L7:
        String r105 = t0.p(this.f238900a, r100.f541317b);
        CompatDrawableTextView r106 = this.f238905f;
        if (r106 == null) goto L13;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r107;
        r108.height = n.d(24);
        r108.width = -2;
        r106.setLayoutParams(r108);
        r106.setBackgroundResource(R.drawable.list_filter_menu_bg_blue);
        l.b(r106, R.color.primary_fill_solid_02);
        r106.setCompoundDrawablePadding(n.d(3));
        r106.setCompoundDrawablesRelativeWithIntrinsicBounds(l.a(this.f238900a, R.drawable.list_filter_icon_white, R.color.primary_fill_default), null, null, null);
        r106.setText(r105);
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f238904e = (c) r100;
    }

    @Override // com.bytedance.ee.bear.templates.center.b.InterfaceC3431b
    public final void h0(int r100, Tab2 r101) {
        Intrinsics.checkNotNullParameter(r101, "tab");
        h().setCurrentTab(r101);
        c r102 = this.f238904e;
        if (r102 == null) goto L5;
        r102.h0(r100, r101);
    L5:
        ((MainViewPager) this.f238902c.findViewById(R.id.viewPager)).setCurrentItem(r100);
        boolean r103 = h().getCurrentTabFilterStatusValue();
        CompatDrawableTextView r104 = this.f238905f;
        if (r104 == null) goto L11;
        if (r103 == false) goto L9;
        int r105 = 0;
    L10:
        r104.setVisibility(r105);
        goto L11
    L9:
        r105 = 8;
    L11:
        k(h().getCurrentTabFilter());
        TemplateCenterViewModel.Companion.getClass();
        TemplateCenterViewModel.access$setLAST_INDEX$cp(r100);
    }

    public TemplateCenterView(FragmentActivity r100, FragmentManager r101, View r102, TemplateCenterFragment r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        Intrinsics.checkNotNullParameter(r102, "rootView");
        Intrinsics.checkNotNullParameter(r103, WidgetService.PARAM_FRAGMENT);
        this.f238900a = r100;
        this.f238901b = r101;
        this.f238902c = r102;
        this.f238903d = r103;
        this.f238906g = LazyKt.lazy(TemplateCenterView$connectServiceContext$2.INSTANCE);
        this.f238907h = LazyKt.lazy(new TemplateCenterView$templateCenViewModel$2(this));
        this.f238908i = new ArrayList();
    }
}
