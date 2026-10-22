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
import com.bytedance.ee.larkwebview.base.g;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ExternalLinkFragment extends WebFragment {
    public SafeReuseDocumentWebV2 j;
    public String k;
    public String l;
    public boolean m;
    public View n;
    public LoadingLayout o;
    public DocBridgeWebViewV2 p;
    public f q;
    public final List<d> r;
    public a s;
    public c t;
    public n u;

    public class a implements LoadingLayout.c {
        public final /* synthetic */ ExternalLinkFragment a;

        public a(ExternalLinkFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.loading.LoadingLayout.c
        public final void onFailedRetry(int r2) {
            ExternalLinkFragment r3 = this.a;
            r3.p.loadUrl(r3.k);
        }
    }

    public class b implements a7.c {
        public final /* synthetic */ ExternalLinkFragment a;

        @Override // com.bytedance.ee.bear.document.a7.c
        public final a7.b getActionProvider() {
            return null;
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public FragmentActivity getActivity() {
            return this.a.getActivity();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final View getRootView() {
            return this.a.getView();
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final AppBarLayout getTitleBarLayout() {
            return this.a.getView().findViewById(2131369266);
        }

        static {
        }

        @Override // com.bytedance.ee.bear.document.a7.c
        public final LifecycleOwner getTitleBarLifecycleOwner() {
            return this.a;
        }

        public b(ExternalLinkFragment r1) {
            this.a = r1;
        }
    }

    public static class c {
        public final String a;

        public c(int r1, String r2) {
            this.a = r2;
        }
    }

    public interface d {
        boolean a(String r1);

        void b(String r1);

        void onLoadFail();

        void onLoadStart();

        void onLoadSuccess();
    }

    public class e extends WebChromeClient {
        public final /* synthetic */ ExternalLinkFragment a;

        public e(ExternalLinkFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r3, String r4) {
            super.onReceivedTitle(r3, r4);
            ExternalLinkFragment r5 = this.a;
            r5.getClass();
            tt5.a.h("ExternalLinkFragment", "dispatchLoadTitle: " + du5.b.g(r4));
            Iterator r6 = ((ArrayList) r5.r).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            ((d) r6.next()).b(r4);
            goto L4
        }
    }

    public class f extends WebViewClient {
        public final /* synthetic */ ExternalLinkFragment a;

        public f(ExternalLinkFragment r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r4, String r5) {
            super.onPageFinished(r4, r5);
            ExternalLinkFragment r6 = this.a;
            c r7 = r6.t;
            if (r7 == null) goto L9;
            tt5.a.d("ExternalLinkFragment", "dispatchLoadFail:" + r7.a);
            Iterator r8 = ((ArrayList) r6.r).iterator();
        L6:
            if (r8.hasNext() == false) goto L8;
            ((d) r8.next()).onLoadFail();
            goto L6
        L8:
            ExternalLinkFragment r9 = this.a;
            String r10 = r9.t.a;
            r9.aa0();
            r9.o.a(-3, r10);
            r9.o.setVisibility(0);
            return;
        L9:
            tt5.a.h("ExternalLinkFragment", "dispatchLoadSuccess");
            Iterator r11 = ((ArrayList) r6.r).iterator();
        L11:
            if (r11.hasNext() == false) goto L14;
            ((d) r11.next()).onLoadSuccess();
            goto L11
        L14:
            if (TextUtils.isEmpty(this.a.l) == true) goto L16;
            ExternalLinkFragment r12 = this.a;
            r12.Z90(r12.l);
            this.a.l = null;
        L16:
            ExternalLinkFragment r13 = this.a;
            r13.aa0();
            r13.o.hide();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r3, String r4) {
            ExternalLinkFragment r5 = this.a;
            r5.getClass();
            tt5.a.h("ExternalLinkFragment", "dispatchLoadUrl: " + du5.b.g(r4));
            Iterator r6 = ((ArrayList) r5.r).iterator();
        L4:
            if (r6.hasNext() == false) goto L8;
            if (((d) r6.next()).a(r4) == false) goto L4;
            return true;
        L8:
            return false;
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
            return shouldOverrideUrlLoading(r1, r2.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r1, String r2, Bitmap r3) {
            super.onPageStarted(r1, r2, r3);
            ExternalLinkFragment r4 = this.a;
            r4.getClass();
            tt5.a.h("ExternalLinkFragment", "dispatchLoadStart");
            Iterator r5 = ((ArrayList) r4.r).iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ((d) r5.next()).onLoadStart();
            goto L4
        L6:
            ExternalLinkFragment r6 = this.a;
            r6.aa0();
            r6.o.e();
            r6.o.setVisibility(0);
            this.a.t = null;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r2, int r3, String r4, String r5) {
            super.onReceivedError(r2, r3, r4, r5);
            tt5.a.h("ExternalLinkFragment", "onReceivedError()... url = " + du5.b.g(r5));
            this.a.t = new c(r3, r4);
        }
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final WebPluginHost W90() {
        g r0 = new DocBridgeWebViewV2(getContext(), "VC_External");
        this.p = r0;
        WebSettings r1 = r0.getSettings();
        r1.setJavaScriptEnabled(true);
        r1.setDomStorageEnabled(true);
        r1.setSupportMultipleWindows(false);
        r1.setJavaScriptCanOpenWindowsAutomatically(true);
        r1.setCacheMode(-1);
        r1.setAllowFileAccess(true);
        r1.setDatabaseEnabled(true);
        f r2 = new f(this);
        this.q = r2;
        r0.W2.a(r2);
        r0.setWebChromeClient(new e(this));
        getLifecycle();
        SafeReuseDocumentWebV2 r3 = new SafeReuseDocumentWebV2("VC_External", this.p);
        this.j = r3;
        r3.s(true, Integer.valueOf(hashCode()));
        this.u = new n();
        com.bytedance.ee.bear.basesdk.config.f r4 = com.bytedance.ee.bear.externallink.a.a;
        if (r4 == null) goto L7;
        List<m> r5 = r4.getWebServices();
        this.u.b(new h6(this.p), r5);
        ExternalLinkPluginHost r6 = new ExternalLinkPluginHost(this.j);
        r6.e = this;
        r6.a = (DocViewModel) q.c(r6, DocViewModel.class, DocViewModel.newFactory(getArguments()));
        return r6;
    L7:
        throw new IllegalStateException("ExternalLinkBrowserConfigs impl not injected yet , see ExternalLinkBrowserConfigs.setup");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final TitleBar X90() {
        return new a7(new b(this), ((ExternalLinkPluginHost) this.e).a);
    }

    public final void aa0() {
        View r0 = this.n.findViewById(2131378977);
        if ((r0 instanceof ViewStub) == false) goto L5;
        this.o = (LoadingLayout) ((ViewStub) r0).inflate();
    L7:
        if (this.s != null) goto L10;
        a r1 = new a(this);
        this.s = r1;
        this.o.setOnRetryListener(r1);
        return;
    L10:
        return;
    L5:
        this.o = (LoadingLayout) r0;
        goto L7
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        com.bytedance.ee.bear.externallink.a r0 = com.bytedance.ee.bear.externallink.a.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("ExternalLinkBrowserConfigs impl not injected yet , see ExternalLinkBrowserConfigs.setup");
    }

    public ExternalLinkFragment() {
        this.r = new ArrayList();
        this.u = new n();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onDestroy() {
        super.onDestroy();
        SafeReuseDocumentWebV2 r0 = this.j;
        if (r0 == null) goto L5;
        r0.s(false, Integer.valueOf(hashCode()));
    L5:
        n r1 = this.u;
        if (r1 == null) goto L9;
        r1.c();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.p.T(this.q);
        this.p.destroy();
        LoadingLayout r0 = this.o;
        if (r0 == null) goto L5;
        r0.setOnRetryListener(null);
    L5:
        n r1 = this.u;
        if (r1 == null) goto L9;
        r1.d();
        return;
    }

    public final void Z90(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L5;
        this.p.p(String.format("try{window.vcData = {token: '%s'};}catch(e){};%s", new Object[]{this.k, r5}), true);
        tt5.a.h("ExternalLinkFragment", "Js injected.");
        return;
    L5:
        tt5.a.d("ExternalLinkFragment", "Js empty ,not injected!");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public final void onCreate(Bundle r4) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        this.k = r0.getString("url");
        this.l = r0.getString("injected_js");
        this.m = r0.getBoolean("enable_dynamic_inject_js", true);
    L5:
        tt5.a.h("ExternalLinkFragment", "URL :" + du5.b.g(this.k));
        super.onCreate(r4);
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.n = r2;
        ((ViewGroup) r2.findViewById(2131367799)).addView(this.p, -1, -1);
        this.p.loadUrl(this.k);
        this.u.e();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131561084, r3, false);
    }
}
