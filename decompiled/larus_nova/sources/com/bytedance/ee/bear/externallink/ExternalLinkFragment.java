package com.bytedance.ee.bear.externallink;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.o;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.SafeReuseDocumentWebV2;
import com.bytedance.ee.bear.document.a7;
import com.bytedance.ee.bear.document.h6;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: classes16.dex */
public class ExternalLinkFragment extends WebFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SafeReuseDocumentWebV2 f226368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f226369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f226370l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f226371m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f226372n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LoadingLayout f226373o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DocBridgeWebViewV2 f226374p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f f226375q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<d> f226376r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f226377s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f226378t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public n f226379u;

    public class a implements LoadingLayout.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalLinkFragment f226380a;

        public a(ExternalLinkFragment r100) {
            this.f226380a = r100;
        }

        @Override // com.bytedance.ee.bear.document.loading.LoadingLayout.c
        public final void onFailedRetry(int r100) {
            ExternalLinkFragment r101 = this.f226380a;
            r101.f226374p.loadUrl(r101.f226369k);
        }
    }

    public class b implements a7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalLinkFragment f226381a;

        @Override // com.bytedance.ee.bear.document.a7.c
        public final a7.b getActionProvider() {
            return null;
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public FragmentActivity getActivity() {
            return this.f226381a.getActivity();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final View getRootView() {
            return this.f226381a.getView();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final AppBarLayout getTitleBarLayout() {
            return (AppBarLayout) this.f226381a.getView().findViewById(R.id.doc_appbar_layout);
        }

        static {
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final LifecycleOwner getTitleBarLifecycleOwner() {
            return this.f226381a;
        }

        public b(ExternalLinkFragment r100) {
            this.f226381a = r100;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f226382a;

        public c(int r100, String r101) {
            this.f226382a = r101;
        }
    }

    public interface d {
        boolean a(String r100);

        void b(String r100);

        void onLoadFail();

        void onLoadStart();

        void onLoadSuccess();
    }

    public class e extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalLinkFragment f226383a;

        public e(ExternalLinkFragment r100) {
            this.f226383a = r100;
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r100, String r101) {
            super.onReceivedTitle(r100, r101);
            ExternalLinkFragment r102 = this.f226383a;
            r102.getClass();
            tt5.a.h("ExternalLinkFragment", "dispatchLoadTitle: " + du5.b.g(r101));
            Iterator r103 = ((ArrayList) r102.f226376r).iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((d) r103.next()).b(r101);
            goto L4
        }
    }

    public class f extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalLinkFragment f226384a;

        public f(ExternalLinkFragment r100) {
            this.f226384a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            super.onPageFinished(r100, r101);
            ExternalLinkFragment r102 = this.f226384a;
            c r103 = r102.f226378t;
            if (r103 == null) goto L9;
            tt5.a.d("ExternalLinkFragment", "dispatchLoadFail:" + r103.f226382a);
            Iterator r104 = ((ArrayList) r102.f226376r).iterator();
        L6:
            if (r104.hasNext() == false) goto L8;
            ((d) r104.next()).onLoadFail();
            goto L6
        L8:
            ExternalLinkFragment r105 = this.f226384a;
            String r106 = r105.f226378t.f226382a;
            r105.aa0();
            r105.f226373o.a(-3, r106);
            r105.f226373o.setVisibility(0);
            return;
        L9:
            tt5.a.h("ExternalLinkFragment", "dispatchLoadSuccess");
            Iterator r107 = ((ArrayList) r102.f226376r).iterator();
        L11:
            if (r107.hasNext() == false) goto L14;
            ((d) r107.next()).onLoadSuccess();
            goto L11
        L14:
            if (TextUtils.isEmpty(this.f226384a.f226370l) == true) goto L16;
            ExternalLinkFragment r108 = this.f226384a;
            r108.Z90(r108.f226370l);
            this.f226384a.f226370l = null;
        L16:
            ExternalLinkFragment r109 = this.f226384a;
            r109.aa0();
            r109.f226373o.hide();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            ExternalLinkFragment r102 = this.f226384a;
            r102.getClass();
            tt5.a.h("ExternalLinkFragment", "dispatchLoadUrl: " + du5.b.g(r101));
            Iterator r103 = ((ArrayList) r102.f226376r).iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            if (((d) r103.next()).a(r101) == false) goto L4;
            return true;
        L8:
            return false;
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
            return shouldOverrideUrlLoading(r100, r101.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            super.onPageStarted(r100, r101, r102);
            ExternalLinkFragment r103 = this.f226384a;
            r103.getClass();
            tt5.a.h("ExternalLinkFragment", "dispatchLoadStart");
            Iterator r104 = ((ArrayList) r103.f226376r).iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            ((d) r104.next()).onLoadStart();
            goto L4
        L6:
            ExternalLinkFragment r105 = this.f226384a;
            r105.aa0();
            r105.f226373o.e();
            r105.f226373o.setVisibility(0);
            this.f226384a.f226378t = null;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r100, int r101, String r102, String r103) {
            super.onReceivedError(r100, r101, r102, r103);
            tt5.a.h("ExternalLinkFragment", "onReceivedError()... url = " + du5.b.g(r103));
            this.f226384a.f226378t = new c(r101, r102);
        }
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final WebPluginHost W90() {
        DocBridgeWebViewV2 r100 = new DocBridgeWebViewV2(getContext(), "VC_External");
        this.f226374p = r100;
        WebSettings r101 = r100.getSettings();
        r101.setJavaScriptEnabled(true);
        r101.setDomStorageEnabled(true);
        r101.setSupportMultipleWindows(false);
        r101.setJavaScriptCanOpenWindowsAutomatically(true);
        r101.setCacheMode(-1);
        r101.setAllowFileAccess(true);
        r101.setDatabaseEnabled(true);
        f r102 = new f(this);
        this.f226375q = r102;
        r100.W2.a(r102);
        r100.setWebChromeClient(new e(this));
        getLifecycle();
        SafeReuseDocumentWebV2 r103 = new SafeReuseDocumentWebV2("VC_External", this.f226374p);
        this.f226368j = r103;
        r103.s(true, Integer.valueOf(hashCode()));
        this.f226379u = new n();
        com.bytedance.ee.bear.externallink.a r104 = com.bytedance.ee.bear.externallink.a.f226387a;
        if (r104 == null) goto L7;
        List<m> r105 = ((com.bytedance.ee.bear.basesdk.config.f) r104).getWebServices();
        this.f226379u.b(new h6(this.f226374p), r105);
        ExternalLinkPluginHost r106 = new ExternalLinkPluginHost(this.f226368j);
        r106.f226385e = this;
        r106.f218588a = (DocViewModel) q.c(r106, DocViewModel.class, DocViewModel.newFactory(getArguments()));
        return r106;
    L7:
        throw new IllegalStateException("ExternalLinkBrowserConfigs impl not injected yet , see ExternalLinkBrowserConfigs.setup");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final TitleBar X90() {
        return new a7(new b(this), ((ExternalLinkPluginHost) this.f216602e).f218588a);
    }

    public final void aa0() {
        View r100 = this.f226372n.findViewById(R.id.loading);
        if ((r100 instanceof ViewStub) == false) goto L5;
        this.f226373o = (LoadingLayout) ((ViewStub) r100).inflate();
    L7:
        if (this.f226377s != null) goto L10;
        a r101 = new a(this);
        this.f226377s = r101;
        this.f226373o.setOnRetryListener(r101);
        return;
    L10:
        return;
    L5:
        this.f226373o = (LoadingLayout) r100;
        goto L7
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        com.bytedance.ee.bear.externallink.a r100 = com.bytedance.ee.bear.externallink.a.f226387a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("ExternalLinkBrowserConfigs impl not injected yet , see ExternalLinkBrowserConfigs.setup");
    }

    public ExternalLinkFragment() {
        this.f226376r = new ArrayList();
        this.f226379u = new n();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        SafeReuseDocumentWebV2 r100 = this.f226368j;
        if (r100 == null) goto L5;
        r100.s(false, Integer.valueOf(hashCode()));
    L5:
        n r101 = this.f226379u;
        if (r101 == null) goto L9;
        r101.c();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f226374p.T(this.f226375q);
        this.f226374p.destroy();
        LoadingLayout r100 = this.f226373o;
        if (r100 == null) goto L5;
        r100.setOnRetryListener(null);
    L5:
        n r101 = this.f226379u;
        if (r101 == null) goto L9;
        r101.d();
        return;
    }

    public final void Z90(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.f226374p.p(String.format("try{window.vcData = {token: '%s'};}catch(e){};%s", new Object[]{this.f226369k, r100}), true);
        tt5.a.h("ExternalLinkFragment", "Js injected.");
        return;
    L5:
        tt5.a.d("ExternalLinkFragment", "Js empty ,not injected!");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        this.f226369k = r101.getString("url");
        this.f226370l = r101.getString("injected_js");
        this.f226371m = r101.getBoolean("enable_dynamic_inject_js", true);
    L5:
        tt5.a.h("ExternalLinkFragment", "URL :" + du5.b.g(this.f226369k));
        super.onCreate(r100);
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.f226372n = r100;
        ((ViewGroup) r100.findViewById(R.id.contentOuterContainer)).addView(this.f226374p, -1, -1);
        this.f226374p.loadUrl(this.f226369k);
        this.f226379u.e();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.externallinks_fragment, r101, false);
    }
}
