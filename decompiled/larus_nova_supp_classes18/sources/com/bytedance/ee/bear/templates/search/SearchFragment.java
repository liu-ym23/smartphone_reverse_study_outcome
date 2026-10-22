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
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseCCMForsetiFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiViewModelProvider;
import com.bytedance.ee.bear.templates.TemplateReport;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.center.Tab2;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.search.recommend.RecommendView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\"\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/templates/search/SearchFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/forseticompat/BaseCCMForsetiFragment;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "lastTab", "", "lastClickRecommend", "dispose", "Lio/reactivex/disposables/Disposable;", "recommendView", "Lcom/bytedance/ee/bear/templates/search/recommend/RecommendView;", "recommendViewDisposable", "templateCenViewModel", "Lcom/bytedance/ee/bear/templates/center/TemplateCenterViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initNetObserve", "finish", "onDestroyView", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", WikiFolderPushPlugin.DATA, "Landroid/content/Intent;", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchFragment extends BaseCCMForsetiFragment implements sa5.a {
    public static final /* synthetic */ int l = 0;
    public String f;
    public String g;
    public Disposable h;
    public RecommendView i;
    public Disposable j;
    public TemplateCenterViewModel k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SearchFragment a;

        public b(SearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            SearchFragment.W90(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SearchFragment a;

        public c(SearchFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            SearchFragment.W90(this.a);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SpaceEditText a;

        public d(SpaceEditText r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h("TemplateSearchFragment", "clear input");
            TemplateReportV2 r4 = TemplateReportV2.a;
            JSONObject r5 = new JSONObject();
            r5.put("click_type", "clear_keywords");
            r5.put("target", "none");
            TemplateReportV2.a().n("ccm_template_search_result_view_click", r5);
            this.a.setText("");
        }
    }

    public static final class e implements View.OnTouchListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            if (r2.getAction() != 1) goto L7;
            TemplateReport.d("click_searchplace", null);
            return false;
        L7:
            return false;
        }
    }

    public static final class f implements TextView.OnEditorActionListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
            if (r2 != 3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ SearchFragment a;
        public final /* synthetic */ Group b;
        public final /* synthetic */ ImageView c;

        public g(SearchFragment r1, Group r2, ImageView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            CharSequence r6 = (CharSequence) r5;
            String r0 = TemplateReport.a;
            String r1 = String.valueOf(r6);
            JSONObject r2 = new JSONObject();
            r2.put("action", "Input_searchwords");
            r2.put("searchwords_name", r1);
            TemplateReport.a().v("template_search", r2);
            if (TextUtils.isEmpty(this.a.g) == false) goto L5;
        L7:
            TemplateCenterViewModel r3 = this.a.k;
            RecommendView r4 = null;
            if (r3 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("templateCenViewModel");
            r3 = null;
        L10:
            r3.getSearchContent().setValue(String.valueOf(r6));
            if (String.valueOf(r6).length() != 0) goto L13;
            boolean r7 = true;
        L15:
            if (r7 == false) goto L21;
            RecommendView r8 = this.a.i;
            if (r8 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        L20:
            r4.setVisibility(0);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            return;
        L19:
            r4 = r8;
            goto L20
        L21:
            RecommendView r9 = this.a.i;
            if (r9 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        L25:
            r4.setVisibility(8);
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            return;
        L24:
            r4 = r9;
            goto L25
        L13:
            r7 = false;
            goto L15
        L5:
            if (Intrinsics.areEqual(this.a.g, String.valueOf(r6)) == true) goto L7;
            TemplateReportV2.e = false;
            goto L7
        }
    }

    public static final class h<T> implements Consumer {
        public static final h<T> a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final void accept(Object r3) {
            tt5.a.f("TemplateSearchFragment", (Throwable) r3, false);
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ SpaceEditText a;

        public i(SpaceEditText r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rcb.c.h(this.a, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements com.bytedance.ee.bear.templates.center.b.InterfaceC0184b {
        public final /* synthetic */ ViewPager a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[Tab2.values().length];
                r0[Tab2.BUSNISS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[Tab2.CUSTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public j(ViewPager r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.templates.center.b.InterfaceC0184b
        public final void h0(int r2, Tab2 r3) {
            this.a.setCurrentItem(r2);
            if (r3 != null) goto L5;
            int r4 = -1;
        L7:
            if (r4 != 1) goto L9;
            TemplateReportV2 r5 = TemplateReportV2.a;
            TemplateReportV2.j("enterprise_template_click", "ccm_template_enterprisecenter_view");
            return;
        L9:
            if (r4 == 2) goto L11;
            TemplateReportV2 r6 = TemplateReportV2.a;
            TemplateReportV2.j("system_template_click", "ccm_template_systemcenter_view");
            return;
        L11:
            TemplateReportV2 r7 = TemplateReportV2.a;
            TemplateReportV2.j("user_template_click", "ccm_template_usercenter_view");
            return;
        L5:
            r4 = a.a[r3.ordinal()];
            goto L7
        }
    }

    static {
    }

    public final void onDestroy() {
        TemplateReportV2 r0 = TemplateReportV2.a;
        String r1 = this.f;
        if (r1 != null) goto L5;
        r1 = "ccm_template_systemcenter_view_click";
    L5:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        TemplateReportV2.b = r1;
        super.onDestroy();
    }

    public final void onDestroyView() {
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.j;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public SearchFragment() {
    }

    public static final void W90(SearchFragment r1) {
        rcb.c.c(r1.getContext());
        if (ForsetiHelper.s(r1) == false) goto L5;
        r1.goBack();
        return;
    L5:
        FragmentActivity r2 = r1.getActivity();
        if (r2 == null) goto L12;
        FragmentManager r3 = r2.getSupportFragmentManager();
        if (r3 == null) goto L13;
        r3.popBackStack();
        return;
    L13:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        ViewModelProvider.NewInstanceFactory r3 = ForsetiViewModelProvider.c;
        this.k = (TemplateCenterViewModel) ForsetiViewModelProvider.a.a(requireActivity()).get(TemplateCenterViewModel.class);
    }

    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        if (205 != r2) goto L9;
        if (r3 == null) goto L10;
        String r4 = r3.getStringExtra(ResourceData.KEY_TOKEN);
        if (r4 == null) goto L11;
        ViewModelProvider.NewInstanceFactory r5 = ForsetiViewModelProvider.c;
        ((TemplateCenterViewModel) ForsetiViewModelProvider.a.a(requireActivity()).get(TemplateCenterViewModel.class)).getDeleteToken().setValue(r4);
        return;
    L11:
        return;
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.widget.EditText, android.widget.TextView, com.bytedance.ee.bear.widgets.universedesign.SpaceEditText] */
    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        TemplateReportV2 r0 = TemplateReportV2.a;
        this.f = TemplateReportV2.b;
        Intrinsics.checkNotNullParameter("ccm_template_search_result_view_click", "<set-?>");
        TemplateReportV2.b = "ccm_template_search_result_view_click";
        View r16 = r13.inflate(2131564965, r14, false);
        ArrayList r17 = new ArrayList();
        r17.add(Tab2.SYSTEM);
        r17.add(Tab2.CUSTOM);
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_optimization_v4_business", false) == false) goto L5;
        r17.add(Tab2.BUSNISS);
    L5:
        MagicIndicator r18 = r16.findViewById(2131388342);
        ViewPager r1 = r16.findViewById(2131388345);
        final ?? r2 = (SpaceEditText) r16.findViewById(2131388340);
        ImageView r3 = (ImageView) r16.findViewById(2131385349);
        Group r4 = r16.findViewById(2131388341);
        r16.findViewById(2131388338).setOnClickListener(new b(this));
        r16.findViewById(2131388339).setOnClickListener(new c(this));
        RecommendView r5 = (RecommendView) r16.findViewById(2131388343);
        this.i = r5;
        RecommendView r6 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
        r5 = null;
    L8:
        this.j = r5.a();
        com.bytedance.ee.bear.contract.j.a.a.a().observe(getViewLifecycleOwner(), new com.bytedance.ee.bear.templates.search.a(this));
        r3.setOnClickListener(new d(r2));
        r2.setOnTouchListener(e.a);
        r2.setOnEditorActionListener(f.a);
        this.h = vu5.b.a(r2).debounce(300, TimeUnit.MILLISECONDS, fo5.d.a()).observeOn(fo5.d.d()).subscribe(new g(this, r4, r3), h.a);
        RecommendView r7 = this.i;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recommendView");
    L12:
        r6.setClickItemListener(new AnonymousClass8(this, r2));
        r16.post(new i(r2));
        r1.setAdapter(new TemplateSearchVPAdapter(this, r17));
        com.bytedance.ee.bear.templates.center.b r8 = new com.bytedance.ee.bear.templates.center.b(getActivity(), r18, r17, new j(r1));
        wuc.a r19 = new wuc.a(getActivity());
        r19.setAdapter(r8);
        r19.setAdjustMode(true);
        r18.setNavigator(r19);
        TemplateReportV2.l(r0, "ccm_template_search_result_view", null, null, null, 14);
        return r16;
    L11:
        r6 = r7;
        goto L12
    }
}
