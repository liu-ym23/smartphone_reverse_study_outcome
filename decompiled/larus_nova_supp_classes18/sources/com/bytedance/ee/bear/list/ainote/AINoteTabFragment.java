package com.bytedance.ee.bear.list.ainote;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.common.morepanel.ActionSheetDialogFragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.facade.common.lazy.LazyFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.DigitDanceHeader;
import com.bytedance.ee.bear.list.ainote.filter.AINoteFilterFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.MainTabTitleBar;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.homepage.title.SubMenuViewPad;
import com.bytedance.ee.bear.list.homepage.title.b;
import com.bytedance.ee.bear.list.homepage.title.c;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.util.ui.n;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.p1;
import dd5.s1;
import gc5.q;
import gc5.r;
import gc5.s;
import gc5.t;
import kotlin.jvm.internal.Intrinsics;
import lc5.p;
import wc5.d;
import wc5.e;
import wc5.f;
import wc5.g;
import wc5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AINoteTabFragment extends LazyFragment implements d, f.a, p1 {
    public static final /* synthetic */ int y = 0;
    public b n;
    public SubMenuView o;
    public SubMenuViewPad p;
    public wa5.a q;
    public yc5.b r;
    public View s;
    public ConnectionService.NetworkState t;
    public int u;
    public FolderSortStrategy v;
    public String w;
    public boolean x;

    public class a implements yc5.b.a {
        public final /* synthetic */ AINoteTabFragment a;

        @Override // yc5.b.a
        public final String m6() {
            return "none";
        }

        @Override // yc5.b.a
        public final String getModule() {
            return this.a.ca0();
        }

        public a(AINoteTabFragment r1) {
            this.a = r1;
        }
    }

    @Override // wc5.d
    public final void Cu() {
    }

    public final void ba0() {
        this.x = true;
        ConnectionService.NetworkState r0 = this.t;
        if (r0 != null) goto L5;
    L12:
        Context r1 = ((LazyBaseFragment) this).g;
        Toast.showFailureText(r1, r1.getString(2131887789), 0);
        return;
    L5:
        if (r0.a() == false) goto L12;
        Bundle r2 = getArguments();
        r2.putString("key_module", ca0());
        r2.putString("key_token", da0());
        r2.putParcelable("key_sort_strategy", this.v);
        r2.putBoolean("key_sort_filter_enable", false);
        if (ga0() == true) goto L9;
    L11:
        ActionSheetDialogFragment.ba0(getActivity(), AINoteFilterFragment.class, r2);
        return;
    L9:
        if (ForsetiHelper.s(this) == false) goto L11;
        ActionSheetDialogFragment.ca0(getActivity(), AINoteFilterFragment.class, r2, this.p.getIvFilterIcon());
    }

    public String ca0() {
        return "ai_notes";
    }

    public String da0() {
        return "owned_by_me";
    }

    public int getContentViewLayoutId() {
        return 2131563468;
    }

    public final void W90() {
        tt5.a.h("AINoteTabFragment", "onDestroyViewLazy()...");
    }

    public final void fa0() {
        SubMenuViewPad r0 = this.p;
        if (r0 == null) goto L17;
        r0.setViewDelegate(this);
        SubMenuViewPad r1 = this.p;
        if (r1.h != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
    L7:
        ImageView r2 = r1.h;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("ivSort");
        r2 = null;
    L10:
        r2.setVisibility(8);
        if (t.b() == false) goto L13;
    L15:
        s1.a.a.a(this);
        return;
    L13:
        if (t.c() == true) goto L15;
        this.p.c();
        goto L15
    }

    public AINoteTabFragment() {
        this.w = "other";
        this.x = false;
    }

    public void ea0() {
        if (ga0() == true) goto L5;
    L10:
        SubMenuView r0 = (SubMenuView) findViewById(2131374462);
        this.o = r0;
        r0.c();
        if (t.b() == false) goto L13;
    L22:
        this.o.setViewDelegate(this);
        Mj(t3.a);
        return;
    L13:
        if (t.c() == true) goto L22;
        if (this.o.getSortView() == null) goto L22;
        TextView r1 = this.o.a;
        if (r1 == null) goto L19;
        r1.setOnClickListener(null);
    L19:
        AppCompatImageView r2 = this.o.d;
        if (r2 == null) goto L22;
        r2.setVisibility(8);
        goto L22
    L5:
        if (getParentFragment() != null) goto L7;
    L9:
        fa0();
        goto L10
    L7:
        if (getParentFragment().getView() == null) goto L9;
        this.p = (SubMenuViewPad) getParentFragment().getView().findViewById(2131387539);
        goto L9
    }

    public final boolean ga0() {
        if (ForsetiHelper.n() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof h) == false) goto L9;
        return true;
    }

    public final boolean ha0() {
        if (getParentFragment() != null) goto L5;
    L7:
        return false;
    L5:
        if ((getParentFragment() instanceof AINoteFragment) == false) goto L7;
        return true;
    }

    public final void onDestroy() {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDestroy();
        tt5.a.h("AINoteTabFragment", "onDestroy()...");
        yc5.b r0 = this.r;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        s1.a.a.h(this);
    }

    @Override // wc5.f.a
    public final void Qi() {
        ba0();
    }

    @Override // wc5.f.a
    public void eF() {
        ba0();
    }

    @Override // dd5.p1
    public void Mj(boolean r2) {
        this.o.b(r2);
    }

    public final void V90(Bundle r10) {
        Z90(getContentViewLayoutId());
        if ((getActivity() instanceof g) == false) goto L6;
        this.n = getActivity().getTitleBar();
    L6:
        if (getArguments() == null) goto L8;
        this.w = getArguments().getString("extra_from", "other");
    L8:
        SmartRefreshLayout r11 = findViewById(2131378171);
        e r0 = getChildFragmentManager().findFragmentById(2131378122);
        if (r0 == null) goto L12;
        r0.Co(r11);
    L12:
        if (ha0() == true) goto L21;
        wa5.a r1 = findViewById(2131378060);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L17;
        r1.setVisibility(0);
        this.q = r1;
    L18:
        wa5.a r2 = r11.getRefreshHeader();
        if ((r2 instanceof wa5.a) == false) goto L21;
        this.q.setCustomText(getString(2131887957));
        r2.setAssociatedHeader(this.q);
        goto L21
    L17:
        wa5.a r6 = findViewById(2131378061);
        r6.setVisibility(0);
        r1.setVisibility(8);
        this.q = r6;
    L21:
        findViewById(2131378183).addOnOffsetChangedListener(new s(this));
        if (findViewById(2131378079) == null) goto L41;
        ViewGroup r7 = this.q;
        if (r7 == null) goto L41;
        if ((r7 instanceof ViewGroup) == false) goto L41;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7.getLayoutParams();
        b r9 = this.n;
        if (r9 == null) goto L37;
        if ((r9 instanceof c) == false) goto L33;
    L38:
        r8.topMargin = 0;
    L40:
        this.q.setLayoutParams(r8);
        goto L41
    L33:
        if ((r9 instanceof MainTabTitleBar) == true) goto L38;
        if (r9.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L38;
    L37:
        if (ga0() == true) goto L38;
        r8.topMargin = getResources().getDimensionPixelSize(2131167715);
    L41:
        ea0();
        if (ha0() == false) goto L44;
    L45:
        findViewById(2131378060).setVisibility(8);
        findViewById(2131378170).setVisibility(8);
        findViewById(2131378061).setVisibility(8);
        findViewById(2131378079).setMinimumHeight(0);
        if (((ww4.a) org.koin.java.a.a(ww4.a.class)).a().b().a == false) goto L48;
        DigitDanceHeader r3 = new DigitDanceHeader(getContext());
        r3.setCustomText(getString(2131887957));
    L49:
        r11.G(r3, n.d(65));
    L51:
        if (ga0() == false) goto L53;
        this.o.setVisibility(8);
    L53:
        this.r = new yc5.b(((LazyBaseFragment) this).g, r11, new a(this));
        this.s = findViewById(2131380933);
        j.a.a.a().observe(this, new r(this));
        if (getActivity() == null) goto L56;
        ((SortAndFilterViewModel) ViewModelProviders.of(getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this, new q(this));
    L56:
        s1.a.a.a(this);
        return;
    L48:
        r3 = new CircleRefreshHeader(getContext());
        goto L49
    L44:
        if (ga0() == false) goto L51;
        goto L45
    }

    @Override // wc5.f.a
    public void WU(boolean r15) {
        Mj(r15);
        s1.a.a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r15, ca0());
        lc5.r r16 = new lc5.r("ccm_space_ai_notes_click", ca0(), "none", "", sbb.e.e.b, false, false, false, 0, "");
        lc5.f.a.O(r16);
    }

    public final void ia0(FolderSortStrategy r20) {
        this.v = r20;
        if (r20 != null) goto L6;
        SubMenuView.FilterState r2 = SubMenuView.FilterState.DEFAULT;
    L9:
        if (r20 != null) goto L11;
        String r1 = "";
    L13:
        if (ga0() == false) goto L17;
        SubMenuViewPad r3 = this.p;
        if (r3 == null) goto L17;
        r3.setFilterState(r2);
    L18:
        tt5.a.h("AINoteTabFragment", "reportChooseFilter()...isClickFilter is " + this.x);
        if (this.x == false) goto L39;
        p r4 = new p("ccm_space_ai_notes_click", ca0(), "none", "filter", "", "", sbb.e.e.b, "", "", false, false, false, 0, null, "", null);
        FilterType r5 = t.a(this.v);
        if (r5 != FilterType.AI_NOTE_ALL) goto L25;
    L36:
        String r6 = "all";
    L37:
        lc5.f.a.l(r4, "filter_name", r6, this.w);
        return;
    L25:
        if (r5 != FilterType.AI_NOTE_MEETING_NOTE) goto L28;
        r6 = "meeting_notes";
        goto L37
    L28:
        if (r5 != FilterType.AI_NOTE_RECORD_NOTE) goto L31;
        r6 = "record_notes";
        goto L37
    L31:
        if (r5 != FilterType.AI_NOTE_WEEKLY_RECAP) goto L34;
        r6 = "weekly_notes";
        goto L37
    L34:
        if (r5 != FilterType.AI_NOTE_MONTHLY_SUMMARY) goto L36;
        r6 = "monthly_notes";
        goto L37
    L39:
        return;
    L17:
        this.o.setFilterState(r2);
        this.o.a(r1);
        goto L18
    L11:
        r1 = getString(FilterType.getAINoteFilterByType(r20.getType(), r20.c, r20.d).getResId());
        goto L13
    L6:
        if (FilterType.getAINoteFilterByType(r20.getType(), r20.c, r20.d) != FilterType.AI_NOTE_ALL) goto L8;
        r2 = SubMenuView.FilterState.DEFAULT;
        goto L9
    L8:
        r2 = SubMenuView.FilterState.CHECKED;
        goto L9
    }

    public final void onAttach(Context r2) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        tt5.a.h("AINoteTabFragment", "onAttach()...");
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onCreate(r2);
        tt5.a.h("AINoteTabFragment", "onCreate()...");
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (getActivity().getWindow() != null) goto L7;
        return;
    L7:
        if (ForsetiHelper.s(this) == true) goto L12;
        getActivity().getWindow().setSoftInputMode(32);
        return;
    }

    public final void onSaveInstanceState(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onSaveInstanceState(r2);
        tt5.a.h("AINoteTabFragment", "onSaveInstanceState()...");
    }

    public final void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        if (r1 == true) goto L5;
        return;
    L5:
        if (ga0() == true) goto L7;
        return;
    L7:
        if (this.p == null) goto L12;
        fa0();
        return;
    }

    @Override // wc5.d
    public final void t(int r1, int r2) {
        if (ha0() == false) goto L5;
        return;
    L5:
        b r3 = this.n;
        if (r3 == null) goto L9;
        r3.a(r2);
        return;
    }
}
