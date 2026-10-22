package com.bytedance.ee.bear.doc.cover.selectcover;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import xuc.d;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0002J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/SelectCoverFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mCoverViewModel", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "mSubSelectCoverPanels", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/SubSelectCoverPanel;", "[Lcom/bytedance/ee/bear/doc/cover/selectcover/SubSelectCoverPanel;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "initDeleteView", "initRandomView", "initPager", "onBackPressed", "", "closeSelectCoverPanel", "onCreateAnimation", "Landroid/view/animation/Animation;", AppletNaviType.TRANSIT, "", "enter", "nextAnim", "Companion", "TabNavigatorAdapter", "TabFragmentAdapter", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectCoverFragment extends BaseFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f217801h = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CoverViewModel f217802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f217803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SubSelectCoverPanel[] f217804g;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/SelectCoverFragment$TabFragmentAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Lcom/bytedance/ee/bear/doc/cover/selectcover/SelectCoverFragment;Landroidx/fragment/app/FragmentManager;)V", "getItem", "Landroidx/fragment/app/Fragment;", "position", "", "getCount", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TabFragmentAdapter extends FragmentPagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectCoverFragment f217805a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f217805a.f217804g.length;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public final Fragment getItem(int r100) {
            Bundle r101 = new Bundle();
            PluginHost.writePluginHostToBundle(this.f217805a, r101);
            Context r102 = this.f217805a.getContext();
            Intrinsics.checkNotNull(r102);
            return Fragment.instantiate(r102, this.f217805a.f217804g[r100].fragment, r101);
        }

        public TabFragmentAdapter(SelectCoverFragment r100, FragmentManager r101) {
            Intrinsics.checkNotNullParameter(r101, "fm");
            this.f217805a = r100;
            super(r101);
        }
    }

    public static final class a {
    }

    public final class b extends xuc.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SelectCoverFragment f217806b;

        public static final class a extends t {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ SelectCoverFragment f217807c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f217808d;

            @Override // com.bytedance.ee.bear.widgets.t
            public final void a(View r100) {
                Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
                ViewPager r101 = this.f217807c.f217803f;
                if (r101 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                r101 = null;
            L5:
                r101.setCurrentItem(this.f217808d);
            }

            public a(SelectCoverFragment r100, int r101) {
                this.f217807c = r100;
                this.f217808d = r101;
            }
        }

        @Override // xuc.a
        public final int a() {
            return this.f217806b.f217804g.length;
        }

        public b(SelectCoverFragment r100) {
            this.f217806b = r100;
        }

        @Override // xuc.a
        public final xuc.c b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            yuc.a r101 = new yuc.a(r100);
            r101.setMode(1);
            r101.setColors(new Integer[]{Integer.valueOf(r100.getResources().getColor(R.color.primary_fill_default))});
            r101.setLineHeight(r100.getResources().getDimensionPixelSize(R.dimen.space_kit_len_2));
            r101.setXOffset(-n.d(4));
            r101.setStartInterpolator(new AccelerateInterpolator());
            r101.setEndInterpolator(new DecelerateInterpolator(10.0f));
            return r101;
        }

        @Override // xuc.a
        public final d c(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            bvc.a r102 = new bvc.a(r100);
            avc.c r103 = new avc.c(r100);
            SelectCoverFragment r104 = this.f217806b;
            r103.setNormalColor(r100.getResources().getColor(R.color.text_caption));
            r103.setSelectedColor(r100.getResources().getColor(R.color.primary_fill_default));
            r103.setText(r104.f217804g[r101].titleResId);
            r103.setTextSize(14.0f);
            r102.setInnerPagerTitleView(r103);
            r102.setPadding(n.d(5), 0, n.d(5), 0);
            r102.setOnClickListener(new a(this.f217806b, r101));
            return r102;
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectCoverFragment f217809a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public c(SelectCoverFragment r100) {
            this.f217809a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            CoverViewModel r101 = this.f217809a.f217802e;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
            r101 = null;
        L5:
            r101.isEnterAnimationShowing().setValue(Boolean.FALSE);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            CoverViewModel r101 = this.f217809a.f217802e;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
            r101 = null;
        L5:
            r101.isEnterAnimationShowing().setValue(Boolean.TRUE);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        CoverViewModel r100 = this.f217802e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r100 = null;
    L5:
        r100.getSelectCoverActive().setValue(Boolean.FALSE);
        return true;
    }

    public SelectCoverFragment() {
        this.f217804g = new SubSelectCoverPanel[]{SubSelectCoverPanel.Official, SubSelectCoverPanel.Local};
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f217802e = (CoverViewModel) q.a(this, CoverViewModel.class);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.findViewById(R.id.close_icon).setOnClickListener(new ky4.c(this));
        final MagicIndicator r102 = (MagicIndicator) r100.findViewById(R.id.tab_indicator);
        wuc.a r103 = new wuc.a(getContext());
        r103.setAdapter(new b(this));
        r103.setAdjustMode(false);
        r102.setNavigator(r103);
        ViewPager r104 = (ViewPager) r100.findViewById(R.id.viewpager);
        this.f217803f = r104;
        CoverViewModel r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r104 = null;
    L5:
        r104.setAdapter(new TabFragmentAdapter(this, getChildFragmentManager()));
        ViewPager r106 = this.f217803f;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r106 = null;
    L8:
        r106.addOnPageChangeListener(new SelectCoverFragment$initPager$1(r102));
        final View r107 = r100.findViewById(R.id.random_view);
        r107.setOnClickListener(new ky4.b(this));
        CoverViewModel r108 = this.f217802e;
        if (r108 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r108 = null;
    L11:
        r108.getCoverSeriesList().observe(this, new SelectCoverFragment$initRandomView$2(r107));
        final View r109 = r100.findViewById(R.id.delete_tv);
        r109.setOnClickListener(new ky4.a(this));
        CoverViewModel r110 = this.f217802e;
        if (r110 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
    L15:
        r105.getCurrentCoverData().observe(this, new SelectCoverFragment$initDeleteView$2(r109));
        return;
    L14:
        r105 = r110;
        goto L15
    }

    @Override // androidx.fragment.app.Fragment
    public final Animation onCreateAnimation(int r100, boolean r101, int r102) {
        if (r101 == false) goto L4;
        Animation r103 = AnimationUtils.loadAnimation(getContext(), R.anim.dialog_in_from_bottom);
        r103.setAnimationListener(new c(this));
        Intrinsics.checkNotNull(r103);
        return r103;
    L4:
        Animation r104 = AnimationUtils.loadAnimation(getContext(), R.anim.dialog_out_to_bottom);
        Intrinsics.checkNotNull(r104);
        return r104;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.doc_cover_selection_fragment, r101, false);
    }
}
