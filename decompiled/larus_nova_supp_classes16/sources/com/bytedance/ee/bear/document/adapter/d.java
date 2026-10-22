package com.bytedance.ee.bear.document.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.browser.plugin.u;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements t {
    public final t a;
    public final DocumentPluginHost b;

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void a() {
        this.a.a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View b(com.bytedance.ee.bear.browser.plugin.f r2, int r3) {
        return this.a.b(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final ViewGroup c(com.bytedance.ee.bear.browser.plugin.f r2) {
        return this.a.c(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void d(com.bytedance.ee.bear.browser.plugin.f r2) {
        this.a.d(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void disablePluginsFitSystemWindow() {
        this.a.disablePluginsFitSystemWindow();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final boolean f(com.bytedance.ee.bear.browser.plugin.f r2) {
        return this.a.f(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View findView(int r2) {
        return this.a.findView(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View findView(Object r2) {
        return this.a.findView(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void g(TitleBar r2) {
        this.a.g(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View getContentView() {
        return this.a.getContentView();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final FragmentManager getFragmentManager() {
        return this.a.getFragmentManager();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final t.a getLayoutStrategy() {
        return this.a.getLayoutStrategy();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final TitleBar getTitleBar() {
        return this.a.getTitleBar();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void h(com.bytedance.ee.bear.browser.plugin.f r2, View r3) {
        this.a.h(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void hideStatusBar() {
        this.a.hideStatusBar();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void j(u r2) {
        this.a.j(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void k(com.bytedance.ee.bear.browser.plugin.c r2) {
        this.a.k(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final Fragment l(com.bytedance.ee.bear.browser.plugin.f r2) {
        return this.a.l(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void m(com.bytedance.ee.bear.browser.plugin.f r2, View r3) {
        this.a.m(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final u saveUIState() {
        return this.a.saveUIState();
    }

    public final void n(Fragment r3) {
        Bundle r0 = r3.getArguments();
        if (r0 != null) goto L5;
        r0 = new Bundle();
        r3.setArguments(r0);
    L5:
        PluginHost.writePluginHostToBundle(r0, this.b);
        tt5.a.h("LegacyChameleonPluginAdapter", "rewrite chameleon fragment host, fragment=".concat(r3.getClass().getSimpleName()));
    }

    public d(t r2, DocumentPluginHost r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "documentHost");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void i(com.bytedance.ee.bear.browser.plugin.f<?> r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        n(r3);
        this.a.i(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void e(com.bytedance.ee.bear.browser.plugin.f<?> r2, Fragment r3, s r4) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        n(r3);
        this.a.e(r2, r3, r4);
    }
}
