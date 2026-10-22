package com.bytedance.ies.bullet.kit.web;

import android.os.Handler;
import android.view.ActionMode;
import android.view.MenuItem;
import android.webkit.ValueCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SSWebView f246963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SSWebView.a f246964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActionMode f246965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h16.b.a f246966d;

    public static final class a<T> implements ValueCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SSWebView.a f246967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMode f246968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h16.b.a f246969c;

        public a(SSWebView.a r100, ActionMode r101, h16.b.a r102) {
            this.f246967a = r100;
            this.f246968b = r101;
            this.f246969c = r102;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r100) {
            Handler r101 = this.f246967a.f246901b;
            ActionMode r102 = this.f246968b;
            h16.b.a r103 = this.f246969c;
            r101.post(new h(r102, r103, (String) r100));
        }
    }

    public i(SSWebView r100, SSWebView.a r101, ActionMode r102, h16.b.a r103) {
        this.f246963a = r100;
        this.f246964b = r101;
        this.f246965c = r102;
        this.f246966d = r103;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f246963a.evaluateJavascript("javascript:(function getSelectedText() {return window.getSelection().toString();})()", new a(this.f246964b, this.f246965c, this.f246966d));
        return true;
    }
}
