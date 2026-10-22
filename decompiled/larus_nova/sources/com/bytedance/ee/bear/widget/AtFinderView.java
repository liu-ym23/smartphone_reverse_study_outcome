package com.bytedance.ee.bear.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtCheckBoxViewModel;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.atfinder.AtFinderViewModel;
import com.bytedance.ee.bear.atfinder.AtMentionListAdapter;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes18.dex */
public class AtFinderView extends FrameLayout implements com.bytedance.ee.bear.atfinder.c.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map<String, Boolean> f239857n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f239858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.atfinder.c f239859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f239860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtMentionListAdapter f239861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtFinderViewModel f239862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<AtObject> f239863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f239864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f239865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.ee.bear.atfinder.f f239866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LifecycleOwner f239867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AtCheckBoxViewModel f239868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f239869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public bo4.c f239870m;

    public static final class a implements Observer<AtFinderResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<AtFinderView> f239871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AtFinderResult f239872b;

        public a(AtFinderView r100) {
            this.f239871a = new WeakReference(r100);
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(AtFinderResult r100) {
            AtFinderResult r101 = r100;
            StringBuilder r102 = new StringBuilder("onChanged: hasResult:");
            boolean r103 = true;
            if (r101 == null) goto L9;
            List<AtObject> r104 = r101.list;
            if (r104 == null) goto L9;
            if (r104.isEmpty() == true) goto L9;
            boolean r105 = true;
        L10:
            r102.append(r105);
            tt5.a.h("AtFinderResultObserver", r102.toString());
            if (this.f239872b == r101) goto L71;
            if (r101 == null) goto L71;
            this.f239872b = r101;
            AtFinderView r106 = this.f239871a.get();
            if (r106 == null) goto L73;
            tt5.a.b("AtFinderResultObserver", "mSearchResultList onChanged");
            ((ArrayList) r106.f239863f).clear();
            c r107 = r106.f239860c;
            tt5.a.h(r107.f239873a, "hideSearchLoading() called");
            Disposable r108 = r107.f239887o;
            if (r108 != null) goto L18;
        L20:
            Disposable r109 = r107.f239888p;
            if (r109 == null) goto L26;
            if (r109.isDisposed() == true) goto L26;
            r107.f239888p.dispose();
            tt5.a.b(r107.f239873a, "disposeHideLoading");
        L26:
            if (r107.f239881i.getVisibility() != 0) goto L28;
            boolean r110 = true;
        L29:
            if (r110 == false) goto L31;
            long r111 = System.currentTimeMillis() - r107.f239874b;
            tt5.a.b(r107.f239873a, "delay hideSearchLoading");
            r107.f239888p = Observable.timer(Math.max(0, 500 - r111), TimeUnit.MILLISECONDS).subscribeOn(fo5.d.d()).observeOn(fo5.d.d()).doOnComplete(new v(r107)).subscribe();
        L31:
            List<AtObject> r112 = r101.list;
            if (r112 != null) goto L34;
        L36:
            r103 = false;
        L37:
            tt5.a.h(r106.f239858a, "onRefreshSearchResult: hasResult=" + r103);
            if (r103 == false) goto L40;
            r106.f239860c.a();
            tt5.a.b(r106.f239858a, "AtFinderView.onRefreshSearchResult:147 ");
            ((ArrayList) r106.f239863f).addAll(r101.list);
        L49:
            tt5.a.b(r106.f239858a, "onRefreshSearchResult mSearchResultList = " + ((ArrayList) r106.f239863f).size());
            r106.f239861d.setNewData(r106.f239863f);
            RecyclerView.LayoutManager r113 = r106.f239860c.f239879g.getLayoutManager();
            if (r113 == null) goto L56;
            List<AtObject> r114 = r106.f239863f;
            if (r114 == null) goto L56;
            if (((ArrayList) r114).size() <= 0) goto L56;
            r113.scrollToPosition(0);
        L56:
            com.bytedance.ee.bear.atfinder.c r115 = r106.f239859b;
            if (r115 != null) goto L59;
        L68:
            b r116 = r106.f239869l;
            if (r116 == null) goto L74;
            r116.a();
            return;
        L74:
            return;
        L59:
            if (r103 == false) goto L64;
            String r117 = r101.keyword;
            r115.f206353f = r117;
            com.bytedance.ee.bear.atfinder.d r118 = r115.f206351d;
            if (r118 == null) goto L63;
            r118.c(r117);
            goto L68
        L63:
            tt5.a.h("AtFinderController", "sendExistResult: mAtFinderDataCallback is null");
            goto L68
        L64:
            String r119 = r101.keyword;
            r115.f206353f = r119;
            com.bytedance.ee.bear.atfinder.d r120 = r115.f206351d;
            if (r120 == null) goto L67;
            r120.d(r119);
            goto L68
        L67:
            tt5.a.h("AtFinderController", "sendEmptyResult: mAtFinderDataCallback is null");
            goto L68
        L40:
            c r121 = r106.f239860c;
            int r122 = r106.getHeight();
            if (r121.f239892t == false) goto L47;
            r121.f239877e.setVisibility(0);
            View r123 = r121.f239878f;
            if (r122 < r121.f239897y) goto L45;
            int r124 = 0;
        L46:
            r123.setVisibility(r124);
        L48:
            r121.f239880h.setVisibility(8);
            r121.f239893u.setVisibility(8);
            goto L49
        L45:
            r124 = 8;
            goto L46
        L47:
            r121.f239876d.setVisibility(0);
            goto L48
        L34:
            if (r112.isEmpty() == true) goto L36;
        L28:
            r110 = false;
            goto L29
        L18:
            if (r108.isDisposed() == true) goto L20;
            r107.f239887o.dispose();
            tt5.a.b(r107.f239873a, "disposeShowLoading");
            goto L20
        L73:
            return;
        L71:
            tt5.a.h("AtFinderResultObserver", "onChanged: result is null");
            return;
        L9:
            r105 = false;
            goto L10
        }
    }

    public interface b {
        void a();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f239873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f239874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f239875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f239876d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f239877e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f239878f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public RecyclerView f239879g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CommonActionPanelLayout f239880h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public View f239881i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public View f239882j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public BearLottieView f239883k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f239884l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public View f239885m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public View f239886n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Disposable f239887o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Disposable f239888p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public w f239889q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public ln4.j f239890r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f239891s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f239892t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public View f239893u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public UDCheckBox f239894v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public TextView f239895w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public a f239896x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f239897y;

        public interface a {
        }

        static {
            Map<String, Boolean> r100 = AtFinderView.f239857n;
            HashMap r101 = (HashMap) r100;
            r101.put("checkbox_selected_key_executor", Boolean.TRUE);
            HashMap r102 = (HashMap) r100;
            r102.put("checkbox_selected_key_notify_user", Boolean.FALSE);
        }

        public final void a() {
            if (this.f239892t == false) goto L5;
            this.f239877e.setVisibility(8);
            c();
            return;
        L5:
            this.f239876d.setVisibility(8);
            this.f239880h.setVisibility(0);
            b();
        }

        public final void b() {
            ViewGroup.MarginLayoutParams r100 = (ViewGroup.MarginLayoutParams) this.f239884l.getLayoutParams();
            if (this.f239890r == null) goto L6;
            this.f239893u.setVisibility(0);
            this.f239880h.setVisibility(8);
            this.f239885m.setVisibility(8);
            this.f239895w.setText(this.f239890r.f510012b);
            this.f239894v.setChecked(this.f239890r.f510013c);
            r100.topMargin = com.bytedance.ee.util.ui.n.d(4);
            r100.leftMargin = 0;
            r100.rightMargin = 0;
        L9:
            this.f239875c.requestLayout();
            return;
        L6:
            if (this.f239891s == false) goto L8;
            this.f239893u.setVisibility(8);
            this.f239880h.setVisibility(8);
            this.f239885m.setVisibility(0);
            r100.topMargin = com.bytedance.ee.util.ui.n.d(4);
            r100.leftMargin = com.bytedance.ee.util.ui.n.d(4);
            r100.rightMargin = com.bytedance.ee.util.ui.n.d(4);
            goto L9
        L8:
            this.f239893u.setVisibility(8);
            this.f239880h.setVisibility(0);
            this.f239885m.setVisibility(8);
            r100.topMargin = 0;
            r100.leftMargin = 0;
            r100.rightMargin = 0;
            goto L9
        }

        public final void c() {
            ViewGroup.MarginLayoutParams r100 = (ViewGroup.MarginLayoutParams) this.f239884l.getLayoutParams();
            if (this.f239890r == null) goto L20;
            this.f239893u.setVisibility(0);
            this.f239885m.setVisibility(8);
            this.f239895w.setText(this.f239890r.f510012b);
            Map<String, Boolean> r101 = AtFinderView.f239857n;
            if (r101 == null) goto L13;
            int r102 = this.f239890r.f510011a;
            if (r102 != 1) goto L9;
            boolean r103 = Boolean.TRUE.equals(((HashMap) r101).get("checkbox_selected_key_executor"));
        L14:
            this.f239894v.setChecked(r103);
            a r104 = this.f239896x;
            if (r104 == null) goto L19;
            AtCheckBoxViewModel r105 = ((r) r104).f239953a.f239868k;
            if (r105 == null) goto L19;
            r105.setCheckboxSelected(r103);
        L19:
            r100.topMargin = com.bytedance.ee.util.ui.n.d(0);
            r100.leftMargin = 0;
            r100.rightMargin = 0;
        L21:
            this.f239875c.requestLayout();
            return;
        L9:
            if (r102 != 2) goto L13;
            r103 = Boolean.TRUE.equals(((HashMap) r101).get("checkbox_selected_key_notify_user"));
        L13:
            r103 = false;
            goto L14
        L20:
            this.f239893u.setVisibility(8);
            this.f239880h.setVisibility(8);
            this.f239885m.setVisibility(8);
            r100.topMargin = 0;
            r100.leftMargin = 0;
            r100.rightMargin = 0;
            goto L21
        }

        public c(View r100) {
            this.f239873a = "ViewsHolder";
            this.f239874b = 0;
            this.f239891s = false;
            this.f239892t = false;
            this.f239897y = com.bytedance.ee.util.ui.n.d(120);
            this.f239875c = r100;
            this.f239884l = r100.findViewById(R.id.layout_shadow_container);
            this.f239885m = r100.findViewById(R.id.layout_comment_landscape);
            this.f239882j = r100.findViewById(R.id.search_result_container);
            this.f239876d = r100.findViewById(R.id.search_not_found);
            this.f239886n = r100.findViewById(R.id.finder_view_root);
            this.f239877e = r100.findViewById(R.id.search_not_found_for_middle_bar);
            this.f239878f = r100.findViewById(R.id.search_not_found_img);
            if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mention.optimizing_authorizaiton") == false) goto L5;
            View r101 = r100.findViewById(R.id.layout_checkbox_bottom);
            this.f239893u = r101;
            this.f239894v = (UDCheckBox) r101.findViewById(R.id.at_checkbox_bottom);
            this.f239895w = (TextView) this.f239893u.findViewById(R.id.at_checkbox_text_bottom);
        L6:
            this.f239879g = (RecyclerView) r100.findViewById(R.id.search_result_list);
            this.f239881i = r100.findViewById(R.id.search_loading_container);
            this.f239883k = (BearLottieView) r100.findViewById(R.id.search_loading);
            CommonActionPanelLayout r102 = (CommonActionPanelLayout) r100.findViewById(R.id.search_result_view);
            this.f239880h = r102;
            r102.setOnActionListener(new t(this));
            com.bytedance.ee.util.ui.l.b(this.f239883k, R.color.bg_body);
            com.bytedance.ee.util.ui.l.b(this.f239876d, R.color.bg_body);
            com.bytedance.ee.util.ui.l.b(this.f239877e, R.color.bg_body);
            this.f239894v.setOnCheckedChangeListener(new s(this));
            return;
        L5:
            View r103 = r100.findViewById(R.id.layout_checkbox_top);
            this.f239893u = r103;
            this.f239894v = (UDCheckBox) r103.findViewById(R.id.at_checkbox_top);
            this.f239895w = (TextView) this.f239893u.findViewById(R.id.at_checkbox_text_top);
            goto L6
        }
    }

    static {
        f239857n = new HashMap();
    }

    public final void a() {
        tt5.a.h(this.f239858a, "close() called");
        this.f239862e.getSearchResultList(this.f239864g).removeObserver(this.f239865h);
        if (ForsetiHelper.h() == false) goto L5;
        this.f239862e.getSearchResultList(this.f239864g).setValue(null);
    L5:
        this.f239860c.f239883k.cancelAnimation();
        setVisibility(8);
    }

    public final void c() {
        tt5.a.b(this.f239858a, "AtFinderView.initViews:82 ");
        c r100 = new c(LayoutInflater.from(getContext()).inflate(R.layout.at_atfinder_inner_fragment_main, this, true));
        this.f239860c = r100;
        r100.f239873a = this.f239858a;
        this.f239861d = new AtMentionListAdapter(this.f239863f);
        this.f239860c.f239879g.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f239860c.f239879g.setAdapter(this.f239861d);
        c r101 = this.f239860c;
        r101.f239896x = new r(this);
        setVisibility(8);
        setBackground(null);
        this.f239860c.f239876d.setBackgroundColor(-1);
        this.f239860c.f239876d.setElevation(30.0f);
        this.f239860c.f239877e.setBackgroundColor(-1);
        this.f239860c.f239877e.setElevation(30.0f);
    }

    public final void e() {
        tt5.a.h(this.f239858a, DyPayConstant.KEY_SHOW_LOADING);
        c r100 = this.f239860c;
        Disposable r101 = r100.f239887o;
        if (r101 != null) goto L5;
    L7:
        Disposable r102 = r100.f239888p;
        if (r102 == null) goto L13;
        if (r102.isDisposed() == true) goto L13;
        r100.f239888p.dispose();
        tt5.a.b(r100.f239873a, "disposeHideLoading");
    L13:
        if (r100.f239881i.getVisibility() != 0) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == true) goto L18;
        tt5.a.b(r100.f239873a, "showSearchLoading delay");
        r100.f239887o = Observable.timer(250, TimeUnit.MILLISECONDS).subscribeOn(fo5.d.a()).observeOn(fo5.d.d()).doOnComplete(new u(r100)).subscribe();
    L18:
        b r104 = this.f239869l;
        if (r104 == null) goto L22;
        r104.a();
        return;
    L22:
        return;
    L15:
        r103 = false;
        goto L16
    L5:
        if (r101.isDisposed() == true) goto L7;
        r100.f239887o.dispose();
        tt5.a.b(r100.f239873a, "disposeShowLoading");
        goto L7
    }

    public AtFinderView(Context r100) {
        super(r100);
        String r101 = "AtFinderView#" + Integer.toHexString(hashCode());
        this.f239858a = r101;
        this.f239863f = new ArrayList();
        tt5.a.b(r101, "AtFinderView.AtFinderView:64 ");
        c();
    }

    public void setAtCommonConfig(bo4.c r100) {
        this.f239870m = r100;
        if (r100 == null) goto L8;
        c r101 = this.f239860c;
        boolean r102 = r100.f19838c;
        r101.f239892t = r102;
        if (r102 == false) goto L9;
        ViewGroup.LayoutParams r103 = r101.f239884l.getLayoutParams();
        r103.height = -1;
        r101.f239884l.setLayoutParams(r103);
        ViewGroup.LayoutParams r104 = r101.f239886n.getLayoutParams();
        r104.height = -1;
        r101.f239886n.setLayoutParams(r104);
        return;
    L9:
        return;
    }

    public void setAtFinderViewDelegate(w r100) {
        this.f239860c.f239889q = r100;
    }

    public void setCheckBoxData(ln4.j r100) {
        c r101 = this.f239860c;
        if (r101 == null) goto L9;
        r101.f239890r = r100;
        if (r101.f239892t == false) goto L7;
        r101.c();
        return;
    L7:
        r101.b();
        return;
    }

    public void setCommentLandscape(boolean r100) {
        c r101 = this.f239860c;
        if (r101 == null) goto L9;
        r101.f239891s = r100;
        if (r101.f239892t == false) goto L7;
        r101.c();
        return;
    L7:
        r101.b();
        return;
    }

    public void setContentHeightChangeCallback(b r100) {
        this.f239869l = r100;
    }

    public void setSearchDelegate(com.bytedance.ee.bear.atfinder.f r100) {
        this.f239866i = r100;
    }

    public void setTitle(String r100) {
        this.f239860c.f239880h.setTitle(r100);
    }

    public AtFinderView(Context r100, AttributeSet r101) {
        super(r100, r101);
        String r102 = "AtFinderView#" + Integer.toHexString(hashCode());
        this.f239858a = r102;
        this.f239863f = new ArrayList();
        tt5.a.b(r102, "AtFinderView.AtFinderView:69 ");
        c();
    }

    public final void b(List<String> r100, bo4.d r101) {
        this.f239862e.setSearchDelegate(this.f239866i);
        this.f239865h = new a(this);
        com.bytedance.ee.bear.atfinder.c r102 = new com.bytedance.ee.bear.atfinder.c(this.f239862e, r101, this.f239870m, AtUtils.b(r100), this);
        this.f239859b = r102;
        this.f239864g = r102.f206352e;
        r102.f206361n = this.f239868k;
        this.f239861d.setOnItemClickListener(r102);
        int r103 = r101.f19840b;
        AtMentionListAdapter r104 = this.f239861d;
        if (r103 != 6) goto L5;
        boolean r105 = true;
    L6:
        r104.f206344a = r105;
        return;
    L5:
        r105 = false;
        goto L6
    }

    public AtFinderView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        String r103 = "AtFinderView#" + Integer.toHexString(hashCode());
        this.f239858a = r103;
        this.f239863f = new ArrayList();
        tt5.a.b(r103, "AtFinderView.AtFinderView:74 ");
        c();
    }

    public final com.bytedance.ee.bear.atfinder.c d(FragmentActivity r100, List<String> r101, bo4.d r102) {
        tt5.a.b(this.f239858a, "AtFinderView.makeAtFinderController:79token=" + du5.b.g(r102.f19839a) + " source=" + r102.f19840b);
        this.f239867j = r100;
        this.f239862e = (AtFinderViewModel) ViewModelProviders.of(r100).get(AtFinderViewModel.class);
        this.f239868k = (AtCheckBoxViewModel) ViewModelProviders.of(r100).get(AtCheckBoxViewModel.class);
        b(r101, r102);
        return this.f239859b;
    }
}
