package com.bytedance.ee.bear.integrator.wiki;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.bytedance.ee.bear.lark.tab.SpaceBaseTabFragment;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.wikiv2.home.DemoWikiTitleBar;
import com.bytedance.ee.bear.wikiv2.home2.WikiHomeFragment2;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import f0c.h;
import kotlin.jvm.internal.Intrinsics;
import wc5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WikiMainTabFragment extends SpaceBaseTabFragment implements g, d0c.c {
    public ViewGroup g;
    public ViewGroup h;
    public WikiHomeFragment2 i;
    public com.bytedance.ee.bear.contract.route.parcelable.c j;
    public com.bytedance.ee.bear.list.homepage.title.b k;
    public com.ss.android.lark.maintab.export.d l;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onMenuCreateClick(View r1) {
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public WikiMainTabFragment() {
        this.f = new c(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    L5:
        return new ce5.a().b;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).p("wiki_list", null);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("WikiMainTabFragment", th, false);
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).k("wiki_list");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.f("WikiMainTabFragment", th, false);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m418provideComponent() {
        return provideComponent();
    }

    public final com.bytedance.ee.bear.list.homepage.title.b getTitleBar() {
        return this.k;
    }

    public final void onDestroyView() {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroyView();
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onViewCreated(r2, r3);
        View r4 = getView();
        if (r4 == null) goto L6;
        r4.getViewTreeObserver().addOnPreDrawListener(new a(r4));
        return;
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        tt5.a.h("WikiMainTabFragment", "onCreateView");
        this.h = r7;
        int r0 = bq5.a.a.a;
        this.g = null;
        this.g = (ViewGroup) r6.inflate(2131568245, r7, false);
        Bundle r9 = getArguments();
        if (r9 != null) goto L5;
        r9 = new Bundle();
    L5:
        setArguments(r9);
        PassportcConvention.h(r9, e9());
        ViewGroup r10 = this.g;
        if (getActivity() != null) goto L8;
        tt5.a.d("WikiMainTabFragment", "activity return null. ");
    L22:
        return this.g;
    L8:
        com.ss.android.lark.maintab.export.d r11 = this.l;
        com.bytedance.ee.bear.contract.route.parcelable.c r1 = this.j;
        FragmentActivity r3 = getActivity();
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r10, "root");
        if (r11 == null) goto L11;
        yp5.b r12 = new yp5.b(r3, r11, r1);
    L16:
        this.k = r12;
        WikiHomeFragment2 r13 = new WikiHomeFragment2();
        this.i = r13;
        boolean r14 = this.e;
        tt5.a.h("WikiHomeFragment2", "setNewTab, isNewTab: " + r14);
        r13.n = r14;
        WikiHomeFragment2 r16 = this.i;
        b r17 = new b();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "listener");
        tt5.a.h("WikiHomeFragment2", "setMileStoneListener.");
        r16.o = r17;
        Bundle r18 = new Bundle();
        PassportcConvention.h(r18, e9());
        this.i.setArguments(r18);
        FragmentTransaction r19 = getChildFragmentManager().beginTransaction();
        WikiHomeFragment2 r20 = this.i;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r19, r20, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131393232) == true) goto L20;
        r19.replace(2131393232, r20);
    L20:
        r19.commitAllowingStateLoss();
        goto L22
    L11:
        yp5.b r21 = LayoutInflater.from(r3).inflate(2131568246, r7, false);
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type com.bytedance.ee.bear.wikiv2.home.DemoWikiTitleBar");
        yp5.b r22 = (DemoWikiTitleBar) r21;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r10, "root");
        ((HomeMainTitleBar) r22).j = HomeMainTitleBar.TitleType.WIKI_HOME.ordinal();
        SpaceTagTitleView r23 = new SpaceTagTitleView(r22.getContext());
        ((HomeMainTitleBar) r22).d = r23;
        r23.setTitleSize(18.0f);
        ((HomeMainTitleBar) r22).d.setGravity(17);
        ((HomeMainTitleBar) r22).c.setCustomTitleView(((HomeMainTitleBar) r22).d);
        r22.setTitle(r22.getContext().getString(2131888328));
        Context r24 = r22.getContext();
        View.OnClickListener r2 = new yp5.a();
        ImageView r4 = new ImageView(r24);
        Resources r5 = r24.getResources();
        int r26 = r24.getResources().getColor(2131102418);
        VectorDrawableCompat r27 = VectorDrawableCompat.create(r5, 2131255617, null);
        if (r27 == null) goto L14;
        r27.setTint(r26);
        r4.setImageDrawable(r27);
    L15:
        r4.setOnClickListener(r2);
        r22.d(r4);
        r10.addView(r22, r10.getChildCount());
        r12 = r22;
        goto L16
    L14:
        tt5.a.d("VectorDrawableUtils", "initSearchIcon VectorDrawableCompat is null !!");
        goto L15
    }
}
