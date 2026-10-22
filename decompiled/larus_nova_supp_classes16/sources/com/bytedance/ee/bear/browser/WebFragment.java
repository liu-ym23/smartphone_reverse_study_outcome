package com.bytedance.ee.bear.browser;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.h;
import com.bytedance.ee.bear.browser.plugin.p;
import com.bytedance.ee.bear.browser.plugin.r;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.ss.android.lark.log.Log;
import java.util.Objects;
import sa5.a;
import vv4.g;
import vv4.k;
import vv4.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class WebFragment extends BaseFragment implements PluginHost.a, a {
    public static final /* synthetic */ int i = 0;
    public WebPluginHost e;
    public p f;
    public t g;
    public TitleBar h;

    public abstract WebPluginHost W90();

    public abstract TitleBar X90();

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public /* synthetic */ ViewGroup getContainer(int r1) {
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

    public final TitleBar U90() {
        TitleBar r0 = this.h;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("getTitleBar before onViewCreated");
    }

    public final t V90() {
        if (this.g != null) goto L6;
        Log.e("WebFragment", "", new IllegalStateException("getUIContainer while not created yet !"));
    L6:
        return this.g;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public vo5.a ej() {
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
    public void onDestroy() {
        super.onDestroy();
        this.f.b(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        p r0 = this.f;
        t r1 = this.g;
        r0.a.get(this).onDispatchUIDetach(r1);
    }

    public void onPause() {
        super.onPause();
        this.f.a.get(this).onDispatchOnPause();
    }

    public void onResume() {
        super.onResume();
        k r0 = this.e.getWeb();
        if (r0 == null) goto L7;
        WebView r1 = r0.getWebView();
        if (r1 == null) goto L7;
        r1.resumeTimers();
    L7:
        this.f.a.get(this).onDispatchOnResume();
    }

    public void onStart() {
        super.onStart();
        this.f.a.get(this).onDispatchOnStart();
    }

    public void onStop() {
        super.onStop();
        this.f.a.get(this).onDispatchOnStop();
    }

    public WebFragment() {
    }

    public t Y90(View r5) {
        Context r1 = getContext();
        Objects.requireNonNull(r1);
        return new r(r1, r5, getChildFragmentManager(), U90());
    }

    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        PluginHost r0 = this.f.a.get(this);
        if (r0 == null) goto L6;
        r0.onDispatchConfigurationChanged(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        g.a = System.currentTimeMillis();
        this.f = p.d();
        this.f.a(new l(this), this);
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
        if (this.h != null) goto L6;
        this.h = X90();
    L6:
        if (this.g != null) goto L8;
        this.g = Y90(r1);
    L8:
        this.f.c(this, this.g);
    }

    @Override // sa5.a
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.e.onDispatchActivityResult(r2, r3, r4);
    }

    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564223, r3, false);
    }
}
