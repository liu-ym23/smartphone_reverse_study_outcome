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
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.cover.CoverViewModel;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.MagicIndicator;
import xuc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0002J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/SelectCoverFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "<init>", "()V", "mCoverViewModel", "Lcom/bytedance/ee/bear/doc/cover/CoverViewModel;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "mSubSelectCoverPanels", "", "Lcom/bytedance/ee/bear/doc/cover/selectcover/SubSelectCoverPanel;", "[Lcom/bytedance/ee/bear/doc/cover/selectcover/SubSelectCoverPanel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "rootView", "initDeleteView", "initRandomView", "initPager", "onBackPressed", "", "closeSelectCoverPanel", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "Companion", "TabNavigatorAdapter", "TabFragmentAdapter", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectCoverFragment extends BaseFragment {
    public static final /* synthetic */ int h = 0;
    public CoverViewModel e;
    public ViewPager f;
    public final SubSelectCoverPanel[] g;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/selectcover/SelectCoverFragment$TabFragmentAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "<init>", "(Lcom/bytedance/ee/bear/doc/cover/selectcover/SelectCoverFragment;Landroidx/fragment/app/FragmentManager;)V", "getItem", "Landroidx/fragment/app/Fragment;", "position", "", "getCount", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class TabFragmentAdapter extends FragmentPagerAdapter {
        public final /* synthetic */ SelectCoverFragment a;

        public final int getCount() {
            return this.a.g.length;
        }

        public final Fragment getItem(int r4) {
            Bundle r0 = new Bundle();
            PluginHost.writePluginHostToBundle(this.a, r0);
            Context r1 = this.a.getContext();
            Intrinsics.checkNotNull(r1);
            return Fragment.instantiate(r1, this.a.g[r4].fragment, r0);
        }

        public TabFragmentAdapter(SelectCoverFragment r2, FragmentManager r3) {
            Intrinsics.checkNotNullParameter(r3, "fm");
            this.a = r2;
            super(r3);
        }
    }

    public static final class a {
    }

    public final class b extends xuc.a {
        public final /* synthetic */ SelectCoverFragment b;

        public static final class a extends t {
            public final /* synthetic */ SelectCoverFragment c;
            public final /* synthetic */ int d;

            public final void a(View r2) {
                Intrinsics.checkNotNullParameter(r2, "v");
                ViewPager r3 = this.c.f;
                if (r3 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                r3 = null;
            L5:
                r3.setCurrentItem(this.d);
            }

            public a(SelectCoverFragment r1, int r2) {
                this.c = r1;
                this.d = r2;
            }
        }

        public final int a() {
            return this.b.g.length;
        }

        public b(SelectCoverFragment r1) {
            this.b = r1;
        }

        public final xuc.c b(Context r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            yuc.a r0 = new yuc.a(r5);
            r0.setMode(1);
            r0.setColors(new Integer[]{Integer.valueOf(r5.getResources().getColor(2131105548))});
            r0.setLineHeight(r5.getResources().getDimensionPixelSize(2131168326));
            r0.setXOffset(-n.d(4));
            r0.setStartInterpolator(new AccelerateInterpolator());
            r0.setEndInterpolator(new DecelerateInterpolator(10.0f));
            return r0;
        }

        public final d c(Context r6, int r7) {
            Intrinsics.checkNotNullParameter(r6, "context");
            bvc.a r0 = new bvc.a(r6);
            avc.c r1 = new avc.c(r6);
            SelectCoverFragment r2 = this.b;
            r1.setNormalColor(r6.getResources().getColor(2131106607));
            r1.setSelectedColor(r6.getResources().getColor(2131105548));
            r1.setText(r2.g[r7].titleResId);
            r1.setTextSize(14.0f);
            r0.setInnerPagerTitleView(r1);
            r0.setPadding(n.d(5), 0, n.d(5), 0);
            r0.setOnClickListener(new a(this.b, r7));
            return r0;
        }
    }

    public static final class c implements Animation.AnimationListener {
        public final /* synthetic */ SelectCoverFragment a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public c(SelectCoverFragment r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            CoverViewModel r3 = this.a.e;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
            r3 = null;
        L5:
            r3.isEnterAnimationShowing().setValue(Boolean.FALSE);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            CoverViewModel r3 = this.a.e;
            if (r3 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
            r3 = null;
        L5:
            r3.isEnterAnimationShowing().setValue(Boolean.TRUE);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        CoverViewModel r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r0 = null;
    L5:
        r0.getSelectCoverActive().setValue(Boolean.FALSE);
        return true;
    }

    public SelectCoverFragment() {
        this.g = new SubSelectCoverPanel[]{SubSelectCoverPanel.Official, SubSelectCoverPanel.Local};
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.e = (CoverViewModel) q.a(this, CoverViewModel.class);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        r6.findViewById(2131366997).setOnClickListener(new ky4.c(this));
        final MagicIndicator r8 = r6.findViewById(2131388025);
        wuc.a r0 = new wuc.a(getContext());
        r0.setAdapter(new b(this));
        r0.setAdjustMode(false);
        r8.setNavigator(r0);
        ViewPager r1 = r6.findViewById(2131392622);
        this.f = r1;
        CoverViewModel r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r1 = null;
    L5:
        r1.setAdapter(new TabFragmentAdapter(this, getChildFragmentManager()));
        ViewPager r3 = this.f;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        r3 = null;
    L8:
        r3.addOnPageChangeListener(new SelectCoverFragment$initPager$1(r8));
        final View r9 = r6.findViewById(2131383635);
        r9.setOnClickListener(new ky4.b(this));
        CoverViewModel r4 = this.e;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
        r4 = null;
    L11:
        r4.getCoverSeriesList().observe(this, new SelectCoverFragment$initRandomView$2(r9));
        final View r10 = r6.findViewById(2131368799);
        r10.setOnClickListener(new ky4.a(this));
        CoverViewModel r11 = this.e;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCoverViewModel");
    L15:
        r2.getCurrentCoverData().observe(this, new SelectCoverFragment$initDeleteView$2(r10));
        return;
    L14:
        r2 = r11;
        goto L15
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        if (r2 == false) goto L4;
        Animation r4 = AnimationUtils.loadAnimation(getContext(), 2130772201);
        r4.setAnimationListener(new c(this));
        Intrinsics.checkNotNull(r4);
        return r4;
    L4:
        Animation r5 = AnimationUtils.loadAnimation(getContext(), 2130772203);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560076, r3, false);
    }
}
