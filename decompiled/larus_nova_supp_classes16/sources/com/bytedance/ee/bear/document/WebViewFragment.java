package com.bytedance.ee.bear.document;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class WebViewFragment extends WebFragment {
    public static final /* synthetic */ int p = 0;
    public final String j;
    public b5 k;
    public s1 l;
    public com.bytedance.ee.bear.contract.d m;
    public Map<String, String> n;
    public String o;

    private void da0() {
        tt5.a.h(this.j, "load");
        com.bytedance.ee.bear.contract.b0 r0 = (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class);
        this.l = new s1(com.bytedance.ee.bear.contract.j.a.a, this.m, (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class), (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), r0.e());
        ((DocumentPluginHost) this.e).getDocumentLoader().load();
    }

    public final DocViewModel H0() {
        WebPluginHost r0 = this.e;
        if (((DocumentPluginHost) r0) != null) goto L6;
        return null;
    L6:
        return ((DocumentPluginHost) r0).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.webkit.WebView, com.bytedance.ee.bear.document.DocBridgeWebViewV2] */
    @Override // com.bytedance.ee.bear.browser.WebFragment
    public final WebPluginHost W90() {
        l7 r0 = y7.j;
        ?? r1 = y7.a.a.t(ba0());
        r1.setBackgroundColor(0);
        DocumentPluginHost r2 = aa0(ca0(r1));
        r2.setDelegate(this);
        r2.c = this;
        final DocViewModel r3 = (DocViewModel) com.bytedance.ee.bear.browser.plugin.q.c(r2, DocViewModel.class, DocViewModel.newFactory(getArguments()));
        r2.a = r3;
        r2.d = Z90(r2);
        r2.setPluginMounter(new w2(r2).a);
        r2.registerHostAbility(new com.bytedance.ee.bear.document.render.init.k(r3, this, r2));
        r2.registerHostAbility(new com.bytedance.ee.bear.document.render.init.m(r3, this, r2));
        w05.c r4 = new w05.c();
        r2.registerHostAbility(r4);
        w05.j r5 = r4.a;
        r2.a().setDocumentInfoProvider(r5);
        r5.e.observe(this, new j7(r3));
        return r2;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public boolean onBackPressed() {
        tt5.a.h(this.j, "onBackPressed()...");
        ((DocumentPluginHost) this.e).getDocumentLoader().bi(true);
        if (super.onBackPressed() == false) goto L5;
        return true;
    L5:
        com.bytedance.ee.larkwebview.base.g r0 = (DocBridgeWebViewV2) this.k.getWebView();
        if (r0 == null) goto L9;
        u1 r2 = r0.getDocStateTracker();
        r2.getClass();
        r2.a = DocLoadingState.SUCCESS;
    L9:
        if (r0 != null) goto L12;
    L10:
        boolean r3 = false;
    L39:
        tt5.a.h(this.j, "canGoBack by normal web stack ?" + r3);
        if (r3 == false) goto L43;
        r0.goBack();
        return true;
    L43:
        return false;
    L12:
        if (r0.canGoBack() == false) goto L10;
        WebBackForwardList r4 = r0.copyBackForwardList();
        if (r4 == null) goto L10;
        int r5 = r4.getCurrentIndex();
        String r6 = r4.getCurrentItem().getOriginalUrl();
        int r7 = r5 - 1;
    L18:
        if (r7 <= 0) goto L25;
        WebHistoryItem r8 = r4.getItemAtIndex(r7);
        if (r8 == null) goto L24;
        if (r6.equals(r8.getOriginalUrl()) == false) goto L25;
        r0.goBack();
        r5 = r5 - 1;
    L24:
        r7 = r7 - 1;
    L25:
        if (r5 <= 1) goto L10;
        WebHistoryItem r9 = r4.getItemAtIndex(r5 - 1);
        if (r9 == null) goto L10;
        String r10 = r9.getOriginalUrl();
        if (TextUtils.isEmpty(r10) == false) goto L33;
        tt5.a.k(this.j, "Pre url empty !");
        goto L10
    L33:
        CharSequence r11 = s45.p.a().U0();
        if (TextUtils.isEmpty(r11) == false) goto L36;
    L38:
        r3 = true;
        goto L39
    L36:
        if (r10.contains(r11) == false) goto L38;
        goto L38
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onDestroy() {
        tt5.a.h(this.j, "onDestroy");
        super.onDestroy();
        ((DocumentPluginHost) this.e).getDocumentLoader().onDestroy();
        if (a35.y.y == false) goto L6;
        String r0 = this.o;
        ((CopyOnWriteArrayList) d25.d.c).remove(r0);
        this.o = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public void onDestroyView() {
        tt5.a.h(this.j, "onDestroyView");
        DocBridgeWebViewV2 r0 = (DocBridgeWebViewV2) this.k.getWebView();
        if (r0 == null) goto L6;
        ea0(r0);
    L6:
        if ((((DocumentPluginHost) this.e).getDocumentLoader() instanceof d5) == false) goto L8;
        ((d5) ((DocumentPluginHost) this.e).getDocumentLoader()).C(this.k);
    L8:
        super.onDestroyView();
    }

    public WebViewFragment() {
        this.j = "WebViewFragment#" + Integer.toHexString(hashCode());
    }

    public String ba0() {
        return Integer.toHexString(hashCode());
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onDetach() {
        super.onDetach();
        tt5.a.h(this.j, "onDetach");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public void onPause() {
        super.onPause();
        ((DocumentPluginHost) this.e).getDocumentLoader().onPause();
        tt5.a.h(this.j, "onPause()...");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public void onResume() {
        super.onResume();
        this.k.onResume();
        boolean r0 = this.k.isAttached();
        tt5.a.h(this.j, "onResume webview attached?" + r0);
        if (r0 == true) goto L6;
        da0();
        return;
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public void onStart() {
        super.onStart();
        tt5.a.h(this.j, "onStart");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public void onStop() {
        super.onStop();
        tt5.a.h(this.j, "onStop");
    }

    static {
    }

    public x2 Z90(DocumentPluginHost r2) {
        return new x3(r2);
    }

    public DocumentPluginHost aa0(z4 r2) {
        return new DocumentPluginHost(r2);
    }

    public z4 ca0(DocBridgeWebViewV2 r3) {
        String r0 = this.j;
        getLifecycle();
        return new SafeReuseDocumentWebV2(r0, r3);
    }

    public void ea0(DocBridgeWebViewV2 r3) {
        ((ArrayList) ((LarkWebView) r3).n.a).clear();
        r3.v2 = null;
        r3.x2 = null;
        r3.O2 = null;
        r3.y2 = sbb.e.g.getType();
        tt5.a.h(r3.g1, "clearRenderParams");
        ((HashMap) r3.V2).clear();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final ViewGroup getContainer(int r4) {
        com.bytedance.ee.bear.browser.plugin.t r0 = V90();
        if (r0 != null) goto L7;
        tt5.a.h(this.j, "getContainer: view is null");
        return null;
    L7:
        if (r4 != ContainerType.Content.getValue()) goto L10;
        View r5 = r0.findView(2131367799);
    L20:
        if ((r5 instanceof ViewGroup) == true) goto L22;
        tt5.a.h(this.j, "getContainer: type is not supported");
        return null;
    L22:
        return (ViewGroup) r5;
    L10:
        if (r4 != ContainerType.Web.getValue()) goto L13;
        r5 = r0.findView(2131393115);
        goto L20
    L13:
        if (r4 != ContainerType.Title.getValue()) goto L15;
    L18:
        r5 = r0.findView(2131369266);
        goto L20
    L15:
        if (r4 == ContainerType.NestScrollTitle.getValue()) goto L18;
        r5 = null;
        goto L20
    }

    public final void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        tt5.a.h(this.j, "onActivityCreated");
    }

    public void onAttach(Context r2) {
        super.onAttach(r2);
        tt5.a.h(this.j, "onAttach");
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        tt5.a.h(this.j, "onCreate:".concat(getClass().getName()));
        FragmentActivity r6 = getActivity();
        this.m = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        H0().getDeleted().observe(this, new h7(this));
        boolean r1 = false;
        this.n = (Map) r6.getIntent().getSerializableExtra("extra_data_map");     // Catch: Throwable -> L5
    L8:
        if (this.n != null) goto L14;
        this.n = (Map) getArguments().getSerializable("extra_data_map");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        tt5.a.e(this.j, "parse route extra data from fragment error!", th, false);
    L14:
        if (this.n != null) goto L17;
        this.n = new HashMap();
    L17:
        if (getArguments() != null) goto L19;
    L21:
        this.n.put("enable_fetch_before_render", String.valueOf(r1));
        ((DocumentPluginHost) this.e).registerHostAbility(new i7(this));
        if (a35.y.y == true) goto L24;
        return;
    L24:
        if (H0() != null) goto L26;
        return;
    L26:
        if (H0().getBearUrl() == null) goto L28;
        this.o = H0().getBearUrl().b;
    L28:
        String r7 = this.o;
        ((CopyOnWriteArrayList) d25.d.c).add(r7);
        return;
    L19:
        if (getArguments().getBoolean("enable_fetch_before_render", false) == false) goto L21;
        r1 = true;
    L5:
        th = move-exception;
        tt5.a.e(this.j, "parse route extra data from activity error!", th, false);
        goto L8
    }

    public final void setArguments(Bundle r2) {
        Bundle r0 = getArguments();
        if (r2 == null) goto L6;
        if (r0 == null) goto L6;
        r0.putAll(r2);
        return;
    L6:
        super.setArguments(r2);
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public void onViewCreated(View r7, Bundle r8) {
        tt5.a.h(this.j, "onViewCreated");
        boolean r0 = s1.n;
        s1.w = System.currentTimeMillis();
        this.k = (b5) r7.findViewById(2131393115);
        if ((((DocumentPluginHost) this.e).getDocumentLoader() instanceof d5) == false) goto L5;
        ((d5) ((DocumentPluginHost) this.e).getDocumentLoader()).g(this.k);
    L5:
        da0();
        super.onViewCreated(r7, r8);
        d25.d.l(H0().getBearUrl());
        d25.d.l(H0().getOriginBearUrl());
        s1 r1 = this.l;
        r1.getClass();
        iu5.f.a(new t1(r1, System.currentTimeMillis(), s1.x));
        ((com.bytedance.ee.bear.middleground.feed.export.bean.h) org.koin.java.a.a(com.bytedance.ee.bear.middleground.feed.export.bean.h.class)).f();
    }

    @Override // com.bytedance.ee.bear.browser.WebFragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131560114, r3, false);
    }

    public final void onRequestPermissionsResult(int r3, String[] r4, int[] r5) {
        super.onRequestPermissionsResult(r3, r4, r5);
        List r0 = getChildFragmentManager().getFragments();
        if (r0 == null) goto L10;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        Fragment r2 = (Fragment) r1.next();
        if (r2 == null) goto L6;
        r2.onRequestPermissionsResult(r3, r4, r5);
        goto L6
    L16:
        return;
    }
}
