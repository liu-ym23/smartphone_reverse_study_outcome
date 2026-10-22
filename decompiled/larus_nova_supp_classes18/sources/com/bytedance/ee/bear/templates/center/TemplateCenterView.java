package com.bytedance.ee.bear.templates.center;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.list.homepage.widget.CompatDrawableTextView;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TemplateCenterView implements IView, b.InterfaceC0184b {
    public final FragmentActivity a;
    public final FragmentManager b;
    public final View c;
    public final TemplateCenterFragment d;
    public c e;
    public CompatDrawableTextView f;
    public final Lazy g;
    public final Lazy h;
    public final ArrayList<Tab2> i;
    public b j;

    public static final class a {
    }

    static {
    }

    public final void destroy() {
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.ee.bear.list.homepage.widget.CompatDrawableTextView] */
    public final void create() {
        HashMap r0 = new HashMap();
        r0.put("module", ThumbGlideUrl.SOURCE_TEMPLATE);
        ((BaseTitleBar) this.c.findViewById(2131388775)).setTag(2131388811, r0);
        Drawable r1 = l.a(this.c.getContext(), 2131255617, 2131101926);
        ((BaseTitleBar) this.c.findViewById(2131388775)).a(new k(r1, this), true);
        if (ForsetiHelper.b(this.d) == false) goto L7;
        ((BaseTitleBar) this.c.findViewById(2131388775)).setLeftExtraClickListener(new g(this));
    L7:
        if (h().filterEnable() == false) goto L14;
        int r2 = n.d(8);
        int r6 = n.d(16);
        int r7 = n.d(22);
        ?? r8 = new CompatDrawableTextView(this.a);
        r8.setTextSize(12.0f);
        r8.setBackgroundDrawable(AppCompatResources.getDrawable(this.a, 2131254759));
        r8.setPadding(r2, 0, r2, 0);
        r8.setTextColor(this.a.getResources().getColor(2131105548));
        r8.setGravity(16);
        r8.setOnClickListener(new h(this));
        this.f = r8;
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(r7, r7);
        r5.leftMargin = r2;
        r5.rightMargin = r6;
        BaseTitleBar r3 = (BaseTitleBar) this.c.findViewById(2131388775);
        AppCompatTextView r4 = this.f;
        r3.f.addView(r4, -1, r5);
        if (DowngradeSettingUtil.a("downgradeSortFilterViewModel") == true) goto L12;
        ViewModelProvider.NewInstanceFactory r9 = ForsetiViewModelProvider.c;
        SortAndFilterViewModel r10 = (SortAndFilterViewModel) ForsetiViewModelProvider.a.a(this.a).get("templates", SortAndFilterViewModel.class);
    L13:
        r10.getSortStrategyLiveData().observe(this.a, new i(this));
        h().getCurrentTabFilterStatus().observe(this.a, new j(this));
        goto L14
    L12:
        r10 = (SortAndFilterViewModel) ViewModelProviders.of(this.a).get(SortAndFilterViewModel.class);
    L14:
        wuc.a r11 = new wuc.a(this.a);
        this.i.add(Tab2.SYSTEM);
        if (h().isOnlyNewLarkForm() == false) goto L17;
        ((FrameLayout) this.c.findViewById(2131373907)).setVisibility(8);
    L20:
        b r12 = new b(this.a, this.c.findViewById(2131373906), this.i, this);
        this.j = r12;
        r11.setAdapter(r12);
        r11.setAdjustMode(true);
        this.c.findViewById(2131373906).setNavigator(r11);
        this.c.findViewById(2131392444).setCanScroll(false);
        this.c.findViewById(2131392444).setAdapter(new TabAdapter(this.a, this.b, this.i));
        this.c.findViewById(2131392444).setOffscreenPageLimit(this.i.size());
        b r13 = this.j;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("tabIndicatorAdapter");
        r13 = null;
    L23:
        TemplateCenterViewModel.Companion.getClass();
        r13.d(TemplateCenterViewModel.access$getLAST_INDEX$cp());
        TemplateReportV2 r14 = TemplateReportV2.a;
        int r15 = TemplateCenterViewModel.access$getLAST_INDEX$cp();
        String r16 = h().getEnterSource();
        if (r15 != 1) goto L26;
        String r17 = "ccm_template_usercenter_view";
    L30:
        TemplateReportV2.l(r14, r17, r16, null, null, 12);
        return;
    L26:
        if (r15 == 2) goto L28;
        r17 = "ccm_template_systemcenter_view";
        goto L30
    L28:
        r17 = "ccm_template_enterprisecenter_view";
        goto L30
    L17:
        this.i.add(Tab2.CUSTOM);
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_optimization_v4_business", false) == false) goto L20;
        this.i.add(Tab2.BUSNISS);
        goto L20
    }

    public final TemplateCenterViewModel h() {
        return (TemplateCenterViewModel) this.h.getValue();
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
    public final void k(sbb.e r6) {
        h().saveCurrentTabFilter(r6);
        if (Intrinsics.areEqual(r6, sbb.e.e) == false) goto L7;
        AppCompatTextView r7 = this.f;
        if (r7 == null) goto L11;
        int r0 = n.d(22);
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r3;
        r4.height = r0;
        r4.width = r0;
        r7.setLayoutParams(r4);
        r7.setBackgroundDrawable(AppCompatResources.getDrawable(this.a, 2131254759));
        l.b(r7, 2131101926);
        r7.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null);
        r7.setText("");
        return;
    L11:
        return;
    L7:
        CharSequence r8 = t0.p(this.a, r6.b);
        AppCompatTextView r1 = this.f;
        if (r1 == null) goto L13;
        ViewGroup.LayoutParams r5 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r9 = (LinearLayout.LayoutParams) r5;
        r9.height = n.d(24);
        r9.width = -2;
        r1.setLayoutParams(r9);
        r1.setBackgroundResource(2131243707);
        l.b(r1, 2131105553);
        r1.setCompoundDrawablePadding(n.d(3));
        r1.setCompoundDrawablesRelativeWithIntrinsicBounds(l.a(this.a, 2131243706, 2131105548), null, null, null);
        r1.setText(r8);
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (c) r1;
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
    @Override // com.bytedance.ee.bear.templates.center.b.InterfaceC0184b
    public final void h0(int r2, Tab2 r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        h().setCurrentTab(r3);
        c r0 = this.e;
        if (r0 == null) goto L5;
        r0.h0(r2, r3);
    L5:
        this.c.findViewById(2131392444).setCurrentItem(r2);
        boolean r4 = h().getCurrentTabFilterStatusValue();
        AppCompatTextView r1 = this.f;
        if (r1 == null) goto L11;
        if (r4 == false) goto L9;
        int r5 = 0;
    L10:
        r1.setVisibility(r5);
        goto L11
    L9:
        r5 = 8;
    L11:
        k(h().getCurrentTabFilter());
        TemplateCenterViewModel.Companion.getClass();
        TemplateCenterViewModel.access$setLAST_INDEX$cp(r2);
    }

    public TemplateCenterView(FragmentActivity r2, FragmentManager r3, View r4, TemplateCenterFragment r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        Intrinsics.checkNotNullParameter(r4, "rootView");
        Intrinsics.checkNotNullParameter(r5, "fragment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.g = LazyKt.lazy(TemplateCenterView$connectServiceContext$2.INSTANCE);
        this.h = LazyKt.lazy(new TemplateCenterView$templateCenViewModel$2(this));
        this.i = new ArrayList();
    }
}
