package com.bytedance.ee.bear.list.homepage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import cd5.e;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.c;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.facade.common.lazy.LazyFragment;
import com.bytedance.ee.bear.list.drive.HomeDriveFragment;
import com.bytedance.ee.bear.list.homepage.banner.f;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.list.homepage.title.MainTabTitleBar;
import com.bytedance.ee.bear.list.homepage.title.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import dd5.s1;
import java.lang.ref.WeakReference;
import wc5.d;
import wc5.g;
import wc5.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseHomeFragment extends LazyFragment implements d {
    public e n;
    public wa5.a o;
    public CollapsingToolbarLayout p;
    public wc5.e q;
    public b r;
    public boolean s;
    public int t;
    public final a u;

    public static class a extends c {
        public final WeakReference<BaseHomeFragment> b;
        public String c;

        public a(BaseHomeFragment r2) {
            this.b = new WeakReference(r2);
        }

        public final void b(AccountService.Account r4) {
            tt5.a.h("BaseHomeFragment", "CustomAccountChangeUICallback...onChangeInUi()  account = " + r4);
            if (r4 != null) goto L5;
        L16:
            tt5.a.h("BaseHomeFragment", "CustomAccountChangeUICallback...onChangeInUi()...account is null or the same");
            return;
        L5:
            if (TextUtils.equals(this.c, r4.token) == true) goto L16;
            if (this.b.get() != null) goto L11;
            tt5.a.d("BaseHomeFragment", "CustomAccountChangeUICallback.onChangeInUi, mBaseHomeFragmentRef.get() is null. " + this.b.get());
            return;
        L11:
            BaseHomeFragment r0 = this.b.get();
            r0.Cu();
            wc5.e r1 = r0.q;
            if (r1 == null) goto L14;
            r1.d2(null);
        L14:
            this.c = r4.token;
        }
    }

    public abstract e ba0(LazyBaseFragment r1, Context r2, AppBarLayout r3);

    public void ca0(SmartRefreshLayout r1) {
    }

    public abstract int da0();

    @Override // wc5.d
    public final void Cu() {
        e r0 = this.n;
        if (r0 == null) goto L8;
        com.bytedance.ee.bear.list.homepage.banner.a r1 = r0.e;
        if (r1 == null) goto L9;
        ((f) r1.getModel()).m5();
        return;
    L9:
        return;
    }

    public void W90() {
        tt5.a.h("BaseHomeFragment", "onDestroyViewLazy()...");
    }

    public final void onDestroy() {
        tt5.a.h("BaseHomeFragment", "onDestroy()...");
        e r0 = this.n;
        if (r0 == null) goto L12;
        com.bytedance.ee.bear.list.homepage.banner.a r1 = r0.e;
        if (r1 == null) goto L7;
        r1.destroy();
    L7:
        yc5.b r2 = r0.g;
        if (r2 == null) goto L10;
        r2.b();
    L10:
        s1.a.a.h(r0);
    L12:
        if (km4.a.a == false) goto L14;
        ((h0) org.koin.java.a.a(h0.class)).qc(this.u);
    L14:
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDestroy();
    }

    public BaseHomeFragment() {
        this.u = new a(this);
    }

    public final void Y90() {
        super.Y90();
        tt5.a.h("BaseHomeFragment", "onResumeLazy()...");
        e r0 = this.n;
        if (r0 == null) goto L7;
        com.bytedance.ee.bear.list.homepage.banner.a r1 = r0.e;
        if (r1 == null) goto L7;
        ((f) r1.getModel()).m5();
    L7:
        this.s = true;
    }

    public final boolean ea0() {
        if (qc5.a.c() == true) goto L5;
    L9:
        return false;
    L5:
        if (getParentFragment() == null) goto L9;
        if ((getParentFragment() instanceof HomeDriveFragment) == false) goto L9;
        return true;
    }

    public final void onDetach() {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onDetach();
        tt5.a.h("BaseHomeFragment", "onDetach()...");
    }

    public void V90(Bundle r5) {
        tt5.a.h("BaseHomeFragment", "onCreateViewLazy()...");
        Z90(da0());
        if ((getParentFragment() instanceof g) == false) goto L6;
        this.r = getParentFragment().getTitleBar();
    L6:
        if ((getActivity() instanceof g) == false) goto L8;
        this.r = getActivity().getTitleBar();
    L8:
        AppBarLayout r6 = (AppBarLayout) findViewById(2131378183);
        SmartRefreshLayout r0 = (SmartRefreshLayout) findViewById(2131378171);
        this.p = findViewById(2131378079);
        wc5.e r1 = getChildFragmentManager().findFragmentById(2131378122);
        this.q = r1;
        if (r1 == null) goto L11;
        r1.Co(r0);
    L11:
        ca0(r0);
        if (ea0() == true) goto L19;
        wa5.a r2 = findViewById(2131378060);
        if (r2 == null) goto L16;
        r2.setVisibility(0);
    L16:
        this.o = r2;
        wa5.a r3 = r0.getRefreshHeader();
        if ((r3 instanceof wa5.a) == false) goto L19;
        this.o.setCustomText(getString(2131887957));
        r3.setAssociatedHeader(this.o);
    L19:
        this.n = ba0(this, getContext(), r6);
        r6.addOnOffsetChangedListener(new wc5.a(this));
        if (this.p == null) goto L51;
        ViewGroup r7 = this.o;
        if (r7 == null) goto L51;
        if ((r7 instanceof ViewGroup) == false) goto L51;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7.getLayoutParams();
        b r4 = this.r;
        if (r4 == null) goto L35;
        if ((r4 instanceof com.bytedance.ee.bear.list.homepage.title.c) == false) goto L31;
    L47:
        r8.topMargin = 0;
    L48:
        this.o.setLayoutParams(r8);
        b r9 = this.r;
        if (r9 == null) goto L51;
        this.p.setMinimumHeight(r9.getTitleBarHeight());
        goto L51
    L31:
        if ((r4 instanceof MainTabTitleBar) == true) goto L47;
        if (r4.getTitleType() == HomeMainTitleBar.TitleType.SPACE_ROUTE.ordinal()) goto L47;
    L35:
        if (ForsetiHelper.n() == true) goto L37;
    L41:
        boolean r10 = false;
    L42:
        if (r10 == true) goto L47;
        if (ForsetiHelper.s(this) == true) goto L47;
        r8.topMargin = getResources().getDimensionPixelSize(2131167715);
        goto L48
    L37:
        if (getParentFragment() == null) goto L41;
        if ((getParentFragment() instanceof h) == false) goto L41;
        r10 = true;
    L51:
        ((LazyFragment) this).k = true;
    }

    public void onAttach(Context r2) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        tt5.a.h("BaseHomeFragment", "onAttach()...");
    }

    public final void onCreate(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onCreate(r2);
        if (km4.a.a == false) goto L6;
        ((h0) org.koin.java.a.a(h0.class)).Pe(this.u);
        return;
    }

    public final void onSaveInstanceState(Bundle r2) {
        super/*com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment*/.onSaveInstanceState(r2);
        tt5.a.h("BaseHomeFragment", "onSaveInstanceState()...");
    }

    public void setUserVisibleHint(boolean r3) {
        super.setUserVisibleHint(r3);
        tt5.a.h("BaseHomeFragment", "setUserVisibleHint()...isVisibleToUser = " + r3 + ", this = " + this);
        this.s = r3;
        if (r3 == true) goto L5;
    L7:
        wc5.e r0 = this.q;
        if (r0 == null) goto L11;
        r0.setUserVisibleHint(r3);
        return;
    L11:
        return;
    L5:
        if (((LazyFragment) this).k == false) goto L7;
        Cu();
        goto L7
    }

    @Override // wc5.d
    public final void t(int r2, int r3) {
        if (ea0() == false) goto L5;
        return;
    L5:
        b r4 = this.r;
        if (r4 != null) goto L8;
        return;
    L8:
        if (this.s == false) goto L12;
        r4.a(r3);
        return;
    }
}
