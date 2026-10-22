package com.bytedance.ee.bear.templates.search;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.search.recommend.RecommendView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\"\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/SearchFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "lastTab", "", "lastClickRecommend", "dispose", "Lio/reactivex/disposables/Disposable;", "recommendView", "Lcom/bytedance/ee/bear/templates/search/recommend/RecommendView;", "recommendViewDisposable", "templateCenViewModel", "Lcom/bytedance/ee/bear/templates/center/TemplateCenterViewModel;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "initNetObserve", VideoEventOneOutSync.END_TYPE_FINISH, "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchFragment extends BaseCCMForsetiFragment implements sa5.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f239319l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f239320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f239321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f239322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecommendView f239323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f239324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TemplateCenterViewModel f239325k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchFragment f239326a;

        public b(SearchFragment r100) {
            this.f239326a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SearchFragment.W90(this.f239326a);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchFragment f239327a;

        public c(SearchFragment r100) {
            this.f239327a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SearchFragment.W90(this.f239327a);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpaceEditText f239328a;

        public d(SpaceEditText r100) {
            this.f239328a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            tt5.a.h("TemplateSearchFragment", "clear input");
            TemplateReportV2 r101 = TemplateReportV2.f238768a;
            JSONObject r102 = new JSONObject();
            r102.put2("click_type", "clear_keywords");
            r102.put2(PickerReporterConstants.KEY.TARGET, "none");
            TemplateReportV2.a().n("ccm_template_search_result_view_click", r102);
            this.f239328a.setText("");
        }
    }

    public static final class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f239329a = null;

        static {
            f239329a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            if (r101.getAction() != 1) goto L7;
            TemplateReport.d("click_searchplace", null);
            return false;
        L7:
            return false;
        }
    }

    public static final class f implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f239330a = null;

        static {
            f239330a = new f();
        }

        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchFragment f239331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Group f239332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImageView f239333c;

        public g(SearchFragment r100, Group r101, ImageView r102) {
            this.f239331a = r100;
            this.f239332b = r101;
            this.f239333c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CharSequence r101 = (CharSequence) r100;
            String r102 = TemplateReport.f238766a;
            String r103 = String.valueOf(r101);
            JSONObject r104 = new JSONObject();
            r104.put("action", "Input_searchwords");
            r104.put("searchwords_name", r103);
            TemplateReport.a().v("template_search", r104);
            if (TextUtils.isEmpty(this.f239331a.f239321g) == false) goto L5;
        L7:
            TemplateCenterViewModel r105 = this.f239331a.f239325k;
            RecommendView r106 = null;
            if (r105 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("templateCenViewModel");
            r105 = null;
        L10:
            r105.getSearchContent().setValue(String.valueOf(r101));
            if (String.valueOf(r101).length() != 0) goto L13;
            boolean r107 = true;
        L15:
            if (r107 == false) goto L21;
            RecommendView r108 = this.f239331a.f239323i;
            if (r108 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        L20:
            r106.setVisibility(0);
            this.f239332b.setVisibility(8);
            this.f239333c.setVisibility(8);
            return;
        L19:
            r106 = r108;
            goto L20
        L21:
            RecommendView r109 = this.f239331a.f239323i;
            if (r109 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        L25:
            r106.setVisibility(8);
            this.f239332b.setVisibility(0);
            this.f239333c.setVisibility(0);
            return;
        L24:
            r106 = r109;
            goto L25
        L13:
            r107 = false;
            goto L15
        L5:
            if (Intrinsics.areEqual(this.f239331a.f239321g, String.valueOf(r101)) == true) goto L7;
            TemplateReportV2.f238772e = false;
            goto L7
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T> f239334a = null;

        static {
            f239334a = new h();
        }

        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.f("TemplateSearchFragment", (Throwable) r100, false);
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpaceEditText f239335a;

        public i(SpaceEditText r100) {
            this.f239335a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rcb.c.h(this.f239335a, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements com.bytedance.ee.bear.templates.center.b.InterfaceC3431b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewPager f239336a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f239337a = null;

            static {
                int[] r100 = new int[Tab2.values().length];
                r100[Tab2.BUSNISS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[Tab2.CUSTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f239337a = r100;
            }
        }

        public j(ViewPager r100) {
            this.f239336a = r100;
        }

        @Override // com.bytedance.ee.bear.templates.center.b.InterfaceC3431b
        public final void h0(int r100, Tab2 r101) {
            this.f239336a.setCurrentItem(r100);
            if (r101 != null) goto L5;
            int r102 = -1;
        L7:
            if (r102 != 1) goto L9;
            TemplateReportV2 r103 = TemplateReportV2.f238768a;
            TemplateReportV2.j("enterprise_template_click", "ccm_template_enterprisecenter_view");
            return;
        L9:
            if (r102 == 2) goto L11;
            TemplateReportV2 r104 = TemplateReportV2.f238768a;
            TemplateReportV2.j("system_template_click", "ccm_template_systemcenter_view");
            return;
        L11:
            TemplateReportV2 r105 = TemplateReportV2.f238768a;
            TemplateReportV2.j("user_template_click", "ccm_template_usercenter_view");
            return;
        L5:
            r102 = a.f239337a[r101.ordinal()];
            goto L7
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        TemplateReportV2 r100 = TemplateReportV2.f238768a;
        String r101 = this.f239320f;
        if (r101 != null) goto L5;
        r101 = "ccm_template_systemcenter_view_click";
    L5:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        TemplateReportV2.f238769b = r101;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Disposable r100 = this.f239322h;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f239324j;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        super.onDestroyView();
    }

    public SearchFragment() {
    }

    public static final void W90(SearchFragment r100) {
        rcb.c.c(r100.getContext());
        if (ForsetiHelper.s(r100) == false) goto L5;
        r100.goBack();
        return;
    L5:
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L12;
        FragmentManager r102 = r101.getSupportFragmentManager();
        if (r102 == null) goto L13;
        r102.popBackStack();
        return;
    L13:
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ViewModelProvider.NewInstanceFactory r101 = ForsetiViewModelProvider.f216459c;
        this.f239325k = (TemplateCenterViewModel) ForsetiViewModelProvider.a.a(requireActivity()).get(TemplateCenterViewModel.class);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment, androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (205 != r101) goto L9;
        if (r102 == null) goto L10;
        String r103 = r102.getStringExtra("token");
        if (r103 == null) goto L11;
        ViewModelProvider.NewInstanceFactory r104 = ForsetiViewModelProvider.f216459c;
        ((TemplateCenterViewModel) ForsetiViewModelProvider.a.a(requireActivity()).get(TemplateCenterViewModel.class)).getDeleteToken().setValue(r103);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        TemplateReportV2 r100 = TemplateReportV2.f238768a;
        this.f239320f = TemplateReportV2.f238769b;
        Intrinsics.checkNotNullParameter("ccm_template_search_result_view_click", "<set-?>");
        TemplateReportV2.f238769b = "ccm_template_search_result_view_click";
        View r113 = r110.inflate(R.layout.template_search_fragment, r111, false);
        ArrayList r114 = new ArrayList();
        r114.add(Tab2.SYSTEM);
        r114.add(Tab2.CUSTOM);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.template_optimization_v4_business", false) == false) goto L5;
        r114.add(Tab2.BUSNISS);
    L5:
        MagicIndicator r115 = (MagicIndicator) r113.findViewById(R.id.template_search_ir);
        ViewPager r101 = (ViewPager) r113.findViewById(R.id.template_search_vp);
        final SpaceEditText r102 = (SpaceEditText) r113.findViewById(R.id.template_search_et);
        ImageView r103 = (ImageView) r113.findViewById(R.id.search_clear_icon);
        Group r104 = (Group) r113.findViewById(R.id.template_search_group);
        r113.findViewById(R.id.template_search_back).setOnClickListener(new b(this));
        r113.findViewById(R.id.template_search_cancel).setOnClickListener(new c(this));
        RecommendView r105 = (RecommendView) r113.findViewById(R.id.template_search_recommendView);
        this.f239323i = r105;
        RecommendView r106 = null;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        r105 = null;
    L8:
        this.f239324j = r105.a();
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.templates.search.a(this));
        r103.setOnClickListener(new d(r102));
        r102.setOnTouchListener(e.f239329a);
        r102.setOnEditorActionListener(f.f239330a);
        this.f239322h = vu5.b.a(r102).debounce(300, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new g(this, r104, r103), h.f239334a);
        RecommendView r107 = this.f239323i;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
    L12:
        r106.setClickItemListener(new AnonymousClass8(this, r102));
        r113.post(new i(r102));
        r101.setAdapter(new TemplateSearchVPAdapter(this, r114));
        com.bytedance.ee.bear.templates.center.b r108 = new com.bytedance.ee.bear.templates.center.b(getActivity(), r115, r114, new j(r101));
        wuc.a r116 = new wuc.a(getActivity());
        r116.setAdapter(r108);
        r116.setAdjustMode(true);
        r115.setNavigator(r116);
        TemplateReportV2.l(r100, "ccm_template_search_result_view", null, null, null, 14);
        return r113;
    L11:
        r106 = r107;
        goto L12
    }
}
