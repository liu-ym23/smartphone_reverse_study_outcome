package com.bytedance.ee.bear.drive.core.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.ImageViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsLazyLoadFragment extends BaseFragment implements PluginHost.a, sa5.a {
    public final String e;
    public com.bytedance.ee.drive.render.j f;
    public DrivePluginHost g;
    public com.bytedance.ee.bear.browser.plugin.p h;
    public com.bytedance.ee.bear.browser.plugin.r i;
    public la5.i j;
    public ViewGroup k;
    public boolean l;
    public boolean m;
    public boolean n;
    public String o;

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final /* synthetic */ ViewGroup getContainer(int r1) {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final Fragment getHostFragment() {
        return this;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public void W90() {
        if (this.k == null) goto L22;
        la5.i r0 = this.j;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.d.getParent() != null) goto L24;
        View r1 = this.j.d;
        if (i.a(this.g, Y90()) == false) goto L20;
        BaseOpenEntity r2 = this.g.c.getOpenEntity();
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L18;
        int r4 = -16777216;
    L19:
        U90(r1, r4);
        tt5.a.h("DRIVE_CACHE_FLOW", "media titlebar preStyle applied");
        goto L20
    L18:
        r4 = -1;
        goto L19
    L13:
        if (r2.isTintWhiteBgInDarkMode() == false) goto L15;
        r3 = true;
    L20:
        this.k.addView(r1, 0);
        return;
    L24:
        return;
    }

    public void X90() {
        ViewGroup r0 = this.k;
        if (r0 == null) goto L8;
        la5.i r1 = this.j;
        if (r1 == null) goto L9;
        r0.removeView(r1.d);
        return;
    L9:
        return;
    }

    public final com.bytedance.ee.drive.render.j Y90() {
        if (this.f != null) goto L14;
        Bundle r0 = getArguments();
        if (r0 == null) goto L7;
        ConcurrentHashMap<String, com.bytedance.ee.drive.render.j> r1 = x75.a.a;
        String r2 = r0.getString("drive_open_strategy_key");
    L8:
        com.bytedance.ee.drive.render.j r3 = x75.a.a(r2);
        if (r3 == null) goto L12;
        this.f = r3;
        return r3;
    L12:
        this.f = ((com.bytedance.ee.drive.preview.f) org.koin.java.a.a(com.bytedance.ee.drive.preview.f.class)).U4(LarkContext.getApplication());
        goto L14
    L7:
        r2 = null;
    L14:
        return this.f;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public vo5.a ej() {
        return new com.bytedance.ee.bear.browser.plugin.h(this);
    }

    public AbsLazyLoadFragment() {
        this.e = getClass().getSimpleName();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final com.bytedance.ee.bear.browser.plugin.o getPluginListProvider() {
        return Y90().a();
    }

    public final boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    L4:
        e = move-exception;
        tt5.a.f(this.e, e, false);
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        if (super.onBackPressed() == false) goto L5;
        return true;
    L5:
        DrivePluginHost r0 = this.g;
        if (r0 != null) goto L8;
    L10:
        return false;
    L8:
        if (r0.onDispatchBackPressed() == false) goto L10;
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        this.h.b(this);
        this.m = false;
        V90(new String[]{"onDestroy"});
    }

    public void onDestroyView() {
        super.onDestroyView();
        V90(new String[]{"onDestroyView"});
        com.bytedance.ee.bear.browser.plugin.p r0 = this.h;
        r0.a.get(this).onDispatchUIDetach(this.i);
        if (this.n == false) goto L5;
        V90(new String[]{"### onDetachData in onDestroyView", String.valueOf(getUserVisibleHint())});
        X90();
    L5:
        la5.i r1 = this.j;
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.a == null) goto L10;
        r1.d.getViewTreeObserver().removeOnPreDrawListener(r1.a);
    L10:
        r1.a = null;
        ((CopyOnWriteArrayList) r1.f).clear();
        r1.f = null;
    }

    public void onPause() {
        super.onPause();
        V90(new String[]{"onPause"});
        this.h.a.get(this).onDispatchOnPause();
    }

    public void onResume() {
        super.onResume();
        V90(new String[]{"onResume"});
        this.h.a.get(this).onDispatchOnResume();
    }

    public final void onStart() {
        super.onStart();
        V90(new String[]{"onStart"});
        this.h.a.get(this).onDispatchOnStart();
    }

    public final void onStop() {
        super.onStop();
        V90(new String[]{"onStop"});
        this.h.a.get(this).onDispatchOnStop();
    }

    public final void V90(String... r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        String r3 = r6[r2];
        r0.append(" ");
        r0.append(r3);
        r2 = r2 + 1;
        goto L3
    L6:
        if (TextUtils.isEmpty(this.o) == false) goto L8;
        this.o = "";
    L8:
        tt5.a.h(this.e, hashCode() + "-" + this.o.concat(r0.toString()));
    }

    public final void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        V90(new String[]{"onActivityCreated"});
    }

    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        PluginHost r0 = this.h.a.get(this);
        if (r0 == null) goto L6;
        r0.onDispatchConfigurationChanged(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        V90(new String[]{"onCreate"});
        this.h = com.bytedance.ee.bear.browser.plugin.p.d();
        this.g = (DrivePluginHost) this.h.a(new a(this), this);
    }

    public final void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        V90(new String[]{"onSaveInstanceState"});
    }

    public final void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        V90(new String[]{"onViewStateRestored"});
    }

    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        com.bytedance.ee.bear.browser.plugin.p r0 = this.h;
        if (r0 == null) goto L8;
        PluginHost r1 = r0.a.get(this);
        if (r1 == null) goto L8;
        r1.onDispatchUserVisibleHint(r5);
    L8:
        if (getUserVisibleHint() == false) goto L14;
        this.l = true;
        if (this.m == true) goto L12;
        return;
    L12:
        if (this.n == true) goto L21;
        this.n = true;
        V90(new String[]{"### onAttachData", String.valueOf(r5)});
        W90();
        return;
    L21:
        return;
    L14:
        this.l = false;
        if (this.m == true) goto L17;
        return;
    L17:
        if (this.n == false) goto L24;
        this.n = false;
        V90(new String[]{"### onDetachData", String.valueOf(getUserVisibleHint())});
        X90();
        return;
    }

    public static void U90(View r3, int r4) {
        int r0 = 0;
        r3.setBackgroundColor(0);
        if ((r3 instanceof TextView) == false) goto L6;
        ((TextView) r3).setTextColor(r4);
    L6:
        if ((r3 instanceof ImageView) == false) goto L9;
        ImageViewCompat.setImageTintList((ImageView) r3, ColorStateList.valueOf(r4));
    L9:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r5 = (ViewGroup) r3;
    L12:
        if (r0 >= r5.getChildCount()) goto L16;
        U90(r5.getChildAt(r0), r4);
        r0 = r0 + 1;
        goto L12
    L16:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        super.onViewCreated(r7, r8);
        V90(new String[]{"onViewCreated"});
        int r9 = i75.j.a;
        this.k = (ViewGroup) i75.j.a.a(2131370319, this);
        Context r0 = requireContext();
        FragmentManager r1 = getChildFragmentManager();
        if (this.j != null) goto L5;
        BaseTitleBar r2 = new BaseTitleBar(requireContext());
        r2.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131166316)));
        this.j = new la5.i(new b(this, r2));
    L5:
        com.bytedance.ee.bear.browser.plugin.r r10 = new com.bytedance.ee.bear.browser.plugin.r(r0, r7, r1, this.j);
        this.i = r10;
        this.h.c(this, r10);
        this.m = true;
        if (this.n == false) goto L8;
        return;
    L8:
        if (this.l == false) goto L12;
        this.n = true;
        V90(new String[]{"### onViewCreated onAttachData", String.valueOf(getUserVisibleHint())});
        W90();
        return;
    }

    @Override // sa5.a
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.g.onDispatchActivityResult(r2, r3, r4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131560214, r3, false);
    }
}
