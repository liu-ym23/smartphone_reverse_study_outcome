package com.bytedance.ee.bear.browser;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.h;
import com.bytedance.ee.bear.browser.plugin.p;
import com.bytedance.ee.bear.browser.plugin.r;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import sa5.a;
import vv4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class PluginFragment<Host extends PluginHost> extends BaseFragment implements PluginHost.a, a {
    public static final /* synthetic */ int i = 0;
    public Host e;
    public p f;
    public t g;
    public TitleBar h;

    public abstract Host U90();

    public abstract TitleBar V90();

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

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final vo5.a ej() {
        return new h(this);
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public boolean onBackPressed() {
        if (super.onBackPressed() == false) goto L7;
        return true;
    L7:
        return this.e.onDispatchBackPressed();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        this.f.b(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        p r0 = this.f;
        t r1 = this.g;
        r0.a.get(this).onDispatchUIDetach(r1);
    }

    public final void onPause() {
        super.onPause();
        this.f.a.get(this).onDispatchOnPause();
    }

    public final void onResume() {
        super.onResume();
        this.f.a.get(this).onDispatchOnResume();
    }

    public final void onStart() {
        super.onStart();
        this.f.a.get(this).onDispatchOnStart();
    }

    public final void onStop() {
        super.onStop();
        this.f.a.get(this).onDispatchOnStop();
    }

    static {
    }

    public PluginFragment() {
    }

    public t W90(View r5) {
        Context r0 = getContext();
        FragmentManager r2 = getChildFragmentManager();
        TitleBar r3 = this.h;
        if (r3 == null) goto L7;
        return new r(r0, r5, r2, r3);
    L7:
        throw new IllegalStateException("getTitleBar before onViewCreated");
    }

    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        PluginHost r0 = this.f.a.get(this);
        if (r0 == null) goto L6;
        r0.onDispatchConfigurationChanged(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.f = p.d();
        this.f.a(new f(this), this);
    }

    public final void setUserVisibleHint(boolean r2) {
        super.setUserVisibleHint(r2);
        p r0 = this.f;
        if (r0 == null) goto L8;
        PluginHost r1 = r0.a.get(this);
        if (r1 == null) goto L9;
        r1.onDispatchUserVisibleHint(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.h = V90();
        t r3 = W90(r1);
        this.g = r3;
        this.f.c(this, r3);
    }

    @Override // sa5.a
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.e.onDispatchActivityResult(r2, r3, r4);
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564221, r3, false);
    }
}
