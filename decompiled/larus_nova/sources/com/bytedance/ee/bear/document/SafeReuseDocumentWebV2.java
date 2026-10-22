package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.LifecycleObserver;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.Message;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class SafeReuseDocumentWebV2 extends h6 implements at5.k, LifecycleObserver, z4 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f218620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f218621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, tb5.i> f218622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vv4.d f218623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final vv4.c f218624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<WebViewClient, Integer> f218625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<WebChromeClient, Integer> f218626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public z4.a f218627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final wv4.a f218628m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DocBridgeWebViewV2 f218629n;

    @Override // com.bytedance.ee.bear.document.z4
    public final boolean G() {
        return this.f218629n.f218522n3;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final int computeVerticalScrollRange() {
        return this.f218629n.computeVerticalScrollRange();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final ConcurrentHashMap<String, String> e() {
        return this.f218629n.getResPath();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final boolean f() {
        return this.f218629n.f218521m3;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final WebViewClient getWebViewClient() {
        return this.f218629n.getWebViewClient();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void onDestroy() {
        tt5.a.h(this.f219947c, "onOwnerDestroy");
        WebView r100 = this.f557392a;
        if (((DocBridgeWebViewV2) r100) != null) goto L5;
        return;
    L5:
        at5.a r101 = ((DocBridgeWebViewV2) r100).getBridge();
        r101.getClass();
        Intrinsics.checkNotNullParameter(this, "interceptor");
        r101.f16234d.remove(this);
        ((DocBridgeWebViewV2) this.f557392a).T(this.f218623h);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final int r() {
        return this.f218629n.getLastVerticalScrollRange();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void v() {
        this.f218629n.f218508e3++;
    }

    @Override // vv4.j, vv4.k
    public final tb5.n getBridge() {
        return this.f218628m;
    }

    public final String toString() {
        return this.f219947c;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void C(v2 r100) {
        this.f218627l = r100;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void D(com.bytedance.ee.bear.document.ssrrender.a.b r100) {
        com.bytedance.ee.bear.document.ssrrender.a r101 = this.f218629n.f218512g3;
        if (Intrinsics.areEqual(r101.f221906a, r100) == false) goto L6;
        r101.f221906a = null;
        return;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void F(zv4.f r100) {
        DocBridgeWebViewV2 r101 = this.f218629n;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        List<DocBridgeWebViewV2.l<zv4.f>> r102 = r101.J2;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r102;
        r103.remove(new DocBridgeWebViewV2.l(r100));
    }

    @Override // vv4.j, vv4.k
    public final void addWebChromeClientDelegate(WebChromeClient r100) {
        tt5.a.h(this.f219947c, "addWebChromeClientDelegate:" + (r100 instanceof a2));
        addWebChromeClientDelegate(r100, 0);
    }

    @Override // vv4.j, vv4.k
    public final void addWebViewClientDelegate(WebViewClient r100) {
        addWebViewClientDelegate(r100, 0);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void d(zv4.f r100) {
        DocBridgeWebViewV2 r101 = this.f218629n;
        r101.getClass();
        if (r100 == null) goto L10;
        DocBridgeWebViewV2.l r102 = new DocBridgeWebViewV2.l(r100);
        if (((CopyOnWriteArrayList) r101.J2).contains(r102) == true) goto L9;
        ((CopyOnWriteArrayList) r101.J2).add(r102);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.document.h6, com.bytedance.ee.bear.document.c4
    public final void g(p35.f r100) {
        this.f218629n.getClass();
        if (r100 == null) goto L7;
        ((CopyOnWriteArrayList) DocBridgeWebViewV2.f218499v3).remove(r100);
        return;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void m(com.bytedance.ee.bear.contract.m0 r100) {
        this.f218629n.S(r100);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void q(com.bytedance.ee.bear.document.ssrrender.a.b r100) {
        this.f218629n.setGetSSRScrollPosListner(r100);
    }

    @Override // vv4.j, vv4.k
    public final void removeWebChromeClientDelegate(WebChromeClient r100) {
        ((CopyOnWriteArrayList) this.f218624i.f557385d).remove(r100);
    }

    @Override // vv4.j, vv4.k
    public final void removeWebViewClientDelegate(WebViewClient r100) {
        ((CopyOnWriteArrayList) this.f218623h.f557386e).remove(r100);
        ((HashMap) this.f218625j).remove(r100);
    }

    @Override // vv4.j, vv4.k
    public final void unbindJSHandler(String r100) {
        ((HashMap) this.f218622g).remove(r100);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void x(com.bytedance.ee.bear.contract.m0 r100) {
        this.f218629n.C(r100);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void y(SendEventData r100) {
        this.f218629n.f218526p3.a(r100);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void z(boolean r100) {
        this.f218629n.setEnableOverScrollBy(r100);
    }

    public SafeReuseDocumentWebV2(String r100, DocBridgeWebViewV2 r101) {
        super(r101);
        this.f218620e = eu5.c.c();
        this.f219947c = "SafeReuseDocumentWebV2#" + r100;
        this.f218629n = r101;
        this.f218622g = new HashMap();
        f6 r102 = new f6(this);
        this.f218623h = new vv4.d(r102);
        this.f218624i = new vv4.c(r102);
        this.f218625j = new HashMap();
        this.f218626k = new HashMap();
        at5.a r103 = r101.getBridge();
        r103.getClass();
        Intrinsics.checkNotNullParameter(this, "interceptor");
        if (r103.f16234d.contains(this) == true) goto L5;
        r103.f16234d.add(this);
    L5:
        wv4.a r104 = new wv4.a(this);
        this.f218628m = r104;
        r104.f561592b = new e6(this);
    }

    public boolean E(Message r100, tb5.m r101) {
        String r102 = r100.f227154e;
        tb5.i r103 = (tb5.i) ((HashMap) this.f218622g).get(r102);
        if (r103 == null) goto L13;
        z4.a r104 = this.f218627l;
        if (r104 == null) goto L7;
        ((v2) r104).f222449a.j(r102);
    L7:
        String r105 = r100.f227153d;
        if (this.f218620e == true) goto L10;
        tb5.f.c(r105, r103, r101);
        return true;
    L10:
        tb5.f.c(r105, r103, r101);
        return true;
    L13:
        return false;
    }

    public boolean J(final Message r100, final vv4.i r110) {
        if (this.f218621f == true) goto L5;
        return false;
    L5:
        final String r101 = r100.f227154e;
        final tb5.i r102 = (tb5.i) ((HashMap) this.f218622g).get(r101);
        if (r102 != null) goto L8;
        return false;
    L8:
        if ((r102 instanceof tb5.q) == false) goto L16;
        z4.a r103 = this.f218627l;
        if (r103 == null) goto L12;
        ((v2) r103).f222449a.j(r101);
    L12:
        String r104 = r100.f227153d;
        if (this.f218620e == true) goto L15;
        tb5.f.c(r104, r102, r110);
        return true;
    L15:
        tb5.f.c(r104, r102, r110);
        return true;
    L16:
        com.bytedance.ee.util.ui.j.c(new c6(this, r101, r102, r100, r110));
        return true;
    }

    @Override // vv4.j, vv4.k
    public final void addWebChromeClientDelegate(WebChromeClient r100, int r101) {
        Map<WebChromeClient, Integer> r102 = this.f218626k;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, Integer.valueOf(r101));
        vv4.c r104 = this.f218624i;
        if (((CopyOnWriteArrayList) r104.f557385d).contains(r100) == true) goto L5;
        ((CopyOnWriteArrayList) r104.f557385d).add(r100);
    L5:
        vv4.c r105 = this.f218624i;
        Comparator r106 = new b6(this);
        r105.getClass();
        ArrayList r107 = new ArrayList(r105.f557385d);
        Collections.sort(r107, r106);
        ((CopyOnWriteArrayList) r105.f557385d).clear();
        ((CopyOnWriteArrayList) r105.f557385d).addAll(r107);
    }

    @Override // vv4.j, vv4.k
    public final void addWebViewClientDelegate(WebViewClient r100, int r101) {
        Map<WebViewClient, Integer> r102 = this.f218625j;
        HashMap r103 = (HashMap) r102;
        r103.put(r100, Integer.valueOf(r101));
        this.f218623h.a(r100);
        vv4.d r104 = this.f218623h;
        Comparator r105 = new d6(this);
        r104.getClass();
        ArrayList r106 = new ArrayList(r104.f557386e);
        Collections.sort(r106, r105);
        ((CopyOnWriteArrayList) r104.f557386e).clear();
        ((CopyOnWriteArrayList) r104.f557386e).addAll(r106);
    }

    @Override // vv4.j, vv4.k
    public final void h(String r100, tb5.i r101) {
        ((HashMap) this.f218622g).put(r100, r101);
    }

    @Override // at5.k
    public final boolean p(com.bytedance.ee.larkwebview.bridge.Message r100, at5.d r101) {
        Message r102 = new Message();
        r102.f227153d = r100.getData();
        r102.f227150a = r100.getCallbackID();
        r102.f227154e = r100.getApiName();
        return J(r102, new vv4.i(r101));
    }

    public void s(boolean r100, Integer r101) {
        tt5.a.h(this.f219947c, "setWebViewActive:" + r100);
        this.f218621f = r100;
        if (r100 == false) goto L11;
        DocBridgeWebViewV2 r102 = (DocBridgeWebViewV2) this.f557392a;
        vv4.d r103 = this.f218623h;
        vv4.d r104 = r102.W2;
        if (((CopyOnWriteArrayList) r104.f557386e).contains(r103) == true) goto L7;
        ListProtector.add(r104.f557386e, 0, r103);
    L7:
        DocBridgeWebViewV2 r105 = (DocBridgeWebViewV2) this.f557392a;
        vv4.c r106 = this.f218624i;
        vv4.c r107 = r105.X2;
        if (((CopyOnWriteArrayList) r107.f557385d).contains(r106) == true) goto L10;
        ListProtector.add(r107.f557385d, 0, r106);
    L10:
        DocBridgeWebViewV2 r108 = (DocBridgeWebViewV2) this.f557392a;
        int r109 = c.f219176a;
        r108.T(c.a.f219177a);
        ((DocBridgeWebViewV2) this.f557392a).getWebViewActiveMap().put(r101, Boolean.TRUE);
    L13:
        if (((DocBridgeWebViewV2) this.f557392a).getWebViewActiveMap().size() != 0) goto L19;
        DocBridgeWebViewV2 r110 = (DocBridgeWebViewV2) this.f557392a;
        int r111 = c.f219176a;
        c r112 = c.a.f219177a;
        vv4.d r113 = r110.W2;
        if (((CopyOnWriteArrayList) r113.f557386e).contains(r112) == true) goto L17;
        ListProtector.add(r113.f557386e, 0, r112);
    L17:
        tt5.a.h(this.f219947c, "setWebViewActive: add BackgroundWebViewClient");
        return;
    L19:
        return;
    L11:
        ((DocBridgeWebViewV2) this.f557392a).T(this.f218623h);
        DocBridgeWebViewV2 r114 = (DocBridgeWebViewV2) this.f557392a;
        ((CopyOnWriteArrayList) r114.X2.f557385d).remove(this.f218624i);
        ((DocBridgeWebViewV2) this.f557392a).getWebViewActiveMap().remove(r101);
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void t(BearUrl r100, String r101) {
        DocBridgeWebViewV2 r102 = this.f218629n;
        r102.f218533v2 = r101;
        r102.f218535x2 = r100;
    }

    @Override // com.bytedance.ee.bear.document.h6, vv4.j, vv4.k
    public void a(String r100, JSONObject r101, ValueCallback<String> r102) {
        vv4.k.b r103 = this.f219948d;
        if (r103 != null) goto L5;
    L21:
        super.a(r100, r101, r102);
        return;
    L5:
        if (r103.enableAddJsonExtraParam() == false) goto L21;
        if (this.f219948d.getInterceptJSONObject() == null) goto L21;
        JSONObject r104 = this.f219948d.getInterceptJSONObject();
        String r105 = this.f219948d.getInterceptFuncName();
        if (r101 == null) goto L21;
        if (TextUtils.isEmpty(r105) == true) goto L21;
        if (r100 == null) goto L21;
        if (r100.contains(r105) == false) goto L21;
        Iterator<String> r106 = r104.keySet().iterator();
    L17:
        if (r106.hasNext() == false) goto L21;
        String r107 = r106.next();
        if (r101.containsKey(r107) == true) goto L17;
        r101.put2(r107, r104.get(r107));
        goto L17
    }

    @Override // com.bytedance.ee.bear.document.h6, vv4.j, vv4.k
    public void k(String r100, NonProguard r101, ValueCallback<String> r102) {
        super.k(r100, r101, r102);
    }

    @Override // com.bytedance.ee.bear.document.h6, vv4.j, vv4.k
    public void l(String r100, org.json.JSONObject r101, ValueCallback<String> r102) {
        super.l(r100, r101, r102);
    }
}
