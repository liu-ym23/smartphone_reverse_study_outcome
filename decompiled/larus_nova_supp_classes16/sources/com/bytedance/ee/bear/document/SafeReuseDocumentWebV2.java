package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SafeReuseDocumentWebV2 extends h6 implements at5.k, LifecycleObserver, z4 {
    public final boolean e;
    public boolean f;
    public final Map<String, tb5.i> g;
    public final vv4.d h;
    public final vv4.c i;
    public final Map<WebViewClient, Integer> j;
    public final Map<WebChromeClient, Integer> k;
    public z4.a l;
    public final wv4.a m;
    public final DocBridgeWebViewV2 n;

    @Override // com.bytedance.ee.bear.document.z4
    public final boolean G() {
        return this.n.n3;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final int computeVerticalScrollRange() {
        return this.n.computeVerticalScrollRange();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final ConcurrentHashMap<String, String> e() {
        return this.n.getResPath();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final boolean f() {
        return this.n.m3;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final WebViewClient getWebViewClient() {
        return this.n.getWebViewClient();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void onDestroy() {
        tt5.a.h(this.c, "onOwnerDestroy");
        Object r0 = this.a;
        if (((DocBridgeWebViewV2) r0) != null) goto L5;
        return;
    L5:
        at5.a r1 = ((DocBridgeWebViewV2) r0).getBridge();
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "interceptor");
        r1.d.remove(this);
        ((DocBridgeWebViewV2) this.a).T(this.h);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final int r() {
        return this.n.getLastVerticalScrollRange();
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void v() {
        this.n.e3++;
    }

    @Override // vv4.j, vv4.k
    public final tb5.n getBridge() {
        return this.m;
    }

    public final String toString() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void C(v2 r1) {
        this.l = r1;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void D(com.bytedance.ee.bear.document.ssrrender.a.b r3) {
        com.bytedance.ee.bear.document.ssrrender.a r0 = this.n.g3;
        if (Intrinsics.areEqual(r0.a, r3) == false) goto L6;
        r0.a = null;
        return;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void F(zv4.f r3) {
        DocBridgeWebViewV2 r0 = this.n;
        if (r3 != null) goto L5;
        r0.getClass();
        return;
    L5:
        List<DocBridgeWebViewV2.l<zv4.f>> r1 = r0.J2;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) r1;
        r2.remove(new DocBridgeWebViewV2.l(r3));
    }

    @Override // vv4.j, vv4.k
    public final void addWebChromeClientDelegate(WebChromeClient r4) {
        tt5.a.h(this.c, "addWebChromeClientDelegate:" + (r4 instanceof a2));
        addWebChromeClientDelegate(r4, 0);
    }

    @Override // vv4.j, vv4.k
    public final void addWebViewClientDelegate(WebViewClient r2) {
        addWebViewClientDelegate(r2, 0);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void d(zv4.f r3) {
        DocBridgeWebViewV2 r0 = this.n;
        r0.getClass();
        if (r3 == null) goto L10;
        DocBridgeWebViewV2.l r1 = new DocBridgeWebViewV2.l(r3);
        if (((CopyOnWriteArrayList) r0.J2).contains(r1) == true) goto L9;
        ((CopyOnWriteArrayList) r0.J2).add(r1);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.document.h6, com.bytedance.ee.bear.document.c4
    public final void g(p35.f r2) {
        this.n.getClass();
        if (r2 == null) goto L7;
        ((CopyOnWriteArrayList) DocBridgeWebViewV2.v3).remove(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void m(com.bytedance.ee.bear.contract.m0 r2) {
        this.n.S(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void q(com.bytedance.ee.bear.document.ssrrender.a.b r2) {
        this.n.setGetSSRScrollPosListner(r2);
    }

    @Override // vv4.j, vv4.k
    public final void removeWebChromeClientDelegate(WebChromeClient r2) {
        ((CopyOnWriteArrayList) this.i.d).remove(r2);
    }

    @Override // vv4.j, vv4.k
    public final void removeWebViewClientDelegate(WebViewClient r2) {
        ((CopyOnWriteArrayList) this.h.e).remove(r2);
        ((HashMap) this.j).remove(r2);
    }

    @Override // vv4.j, vv4.k
    public final void unbindJSHandler(String r2) {
        ((HashMap) this.g).remove(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void x(com.bytedance.ee.bear.contract.m0 r2) {
        this.n.C(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void y(SendEventData r2) {
        this.n.p3.a(r2);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void z(boolean r2) {
        this.n.setEnableOverScrollBy(r2);
    }

    public SafeReuseDocumentWebV2(String r3, DocBridgeWebViewV2 r4) {
        super(r4);
        this.e = eu5.c.c();
        this.c = "SafeReuseDocumentWebV2#" + r3;
        this.n = r4;
        this.g = new HashMap();
        f6 r5 = new f6(this);
        this.h = new vv4.d(r5);
        this.i = new vv4.c(r5);
        this.j = new HashMap();
        this.k = new HashMap();
        at5.a r6 = r4.getBridge();
        r6.getClass();
        Intrinsics.checkNotNullParameter(this, "interceptor");
        if (r6.d.contains(this) == true) goto L5;
        r6.d.add(this);
    L5:
        wv4.a r7 = new wv4.a(this);
        this.m = r7;
        r7.b = new e6(this);
    }

    @Override // com.bytedance.ee.bear.document.z4
    public boolean E(Message r4, tb5.m r5) {
        String r0 = r4.e;
        tb5.i r1 = (tb5.i) ((HashMap) this.g).get(r0);
        if (r1 == null) goto L13;
        z4.a r2 = this.l;
        if (r2 == null) goto L7;
        ((v2) r2).a.j(r0);
    L7:
        String r6 = r4.d;
        if (this.e == true) goto L10;
        tb5.f.c(r6, r1, r5);
        return true;
    L10:
        tb5.f.c(r6, r1, r5);
        return true;
    L13:
        return false;
    }

    public boolean J(final Message r9, final vv4.i r10) {
        if (this.f == true) goto L5;
        return false;
    L5:
        final String r4 = r9.e;
        final tb5.i r5 = (tb5.i) ((HashMap) this.g).get(r4);
        if (r5 != null) goto L8;
        return false;
    L8:
        if ((r5 instanceof tb5.q) == false) goto L16;
        z4.a r0 = this.l;
        if (r0 == null) goto L12;
        ((v2) r0).a.j(r4);
    L12:
        String r11 = r9.d;
        if (this.e == true) goto L15;
        tb5.f.c(r11, r5, r10);
        return true;
    L15:
        tb5.f.c(r11, r5, r10);
        return true;
    L16:
        com.bytedance.ee.util.ui.j.c(new c6(this, r4, r5, r9, r10));
        return true;
    }

    @Override // vv4.j, vv4.k
    public final void addWebChromeClientDelegate(WebChromeClient r3, int r4) {
        Map<WebChromeClient, Integer> r0 = this.k;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, Integer.valueOf(r4));
        vv4.c r5 = this.i;
        if (((CopyOnWriteArrayList) r5.d).contains(r3) == true) goto L5;
        ((CopyOnWriteArrayList) r5.d).add(r3);
    L5:
        vv4.c r6 = this.i;
        Comparator r7 = new b6(this);
        r6.getClass();
        ArrayList r2 = new ArrayList(r6.d);
        Collections.sort(r2, r7);
        ((CopyOnWriteArrayList) r6.d).clear();
        ((CopyOnWriteArrayList) r6.d).addAll(r2);
    }

    @Override // vv4.j, vv4.k
    public final void addWebViewClientDelegate(WebViewClient r3, int r4) {
        Map<WebViewClient, Integer> r0 = this.j;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, Integer.valueOf(r4));
        this.h.a(r3);
        vv4.d r5 = this.h;
        Comparator r6 = new d6(this);
        r5.getClass();
        ArrayList r2 = new ArrayList(r5.e);
        Collections.sort(r2, r6);
        ((CopyOnWriteArrayList) r5.e).clear();
        ((CopyOnWriteArrayList) r5.e).addAll(r2);
    }

    @Override // vv4.j, vv4.k
    public final void h(String r2, tb5.i r3) {
        ((HashMap) this.g).put(r2, r3);
    }

    public final boolean p(com.bytedance.ee.larkwebview.bridge.Message r3, at5.d r4) {
        Message r0 = new Message();
        r0.d = r3.getData();
        r0.a = r3.getCallbackID();
        r0.e = r3.getApiName();
        return J(r0, new vv4.i(r4));
    }

    @Override // com.bytedance.ee.bear.document.z4
    public void s(boolean r4, Integer r5) {
        tt5.a.h(this.c, "setWebViewActive:" + r4);
        this.f = r4;
        if (r4 == false) goto L11;
        DocBridgeWebViewV2 r6 = (DocBridgeWebViewV2) this.a;
        vv4.d r1 = this.h;
        vv4.d r7 = r6.W2;
        if (((CopyOnWriteArrayList) r7.e).contains(r1) == true) goto L7;
        ListProtector.add(r7.e, 0, r1);
    L7:
        DocBridgeWebViewV2 r8 = (DocBridgeWebViewV2) this.a;
        vv4.c r2 = this.i;
        vv4.c r9 = r8.X2;
        if (((CopyOnWriteArrayList) r9.d).contains(r2) == true) goto L10;
        ListProtector.add(r9.d, 0, r2);
    L10:
        DocBridgeWebViewV2 r10 = (DocBridgeWebViewV2) this.a;
        int r3 = c.a;
        r10.T(c.a.a);
        ((DocBridgeWebViewV2) this.a).getWebViewActiveMap().put(r5, Boolean.TRUE);
    L13:
        if (((DocBridgeWebViewV2) this.a).getWebViewActiveMap().size() != 0) goto L19;
        DocBridgeWebViewV2 r11 = (DocBridgeWebViewV2) this.a;
        int r12 = c.a;
        c r13 = c.a.a;
        vv4.d r14 = r11.W2;
        if (((CopyOnWriteArrayList) r14.e).contains(r13) == true) goto L17;
        ListProtector.add(r14.e, 0, r13);
    L17:
        tt5.a.h(this.c, "setWebViewActive: add BackgroundWebViewClient");
        return;
    L19:
        return;
    L11:
        ((DocBridgeWebViewV2) this.a).T(this.h);
        DocBridgeWebViewV2 r16 = (DocBridgeWebViewV2) this.a;
        ((CopyOnWriteArrayList) r16.X2.d).remove(this.i);
        ((DocBridgeWebViewV2) this.a).getWebViewActiveMap().remove(r5);
        goto L13
    }

    @Override // com.bytedance.ee.bear.document.z4
    public final void t(BearUrl r2, String r3) {
        DocBridgeWebViewV2 r0 = this.n;
        r0.v2 = r3;
        r0.x2 = r2;
    }

    @Override // com.bytedance.ee.bear.document.h6, vv4.j, vv4.k
    public void a(String r5, JSONObject r6, ValueCallback<String> r7) {
        vv4.k.b r0 = this.d;
        if (r0 != null) goto L5;
    L21:
        super.a(r5, r6, r7);
        return;
    L5:
        if (r0.enableAddJsonExtraParam() == false) goto L21;
        if (this.d.getInterceptJSONObject() == null) goto L21;
        JSONObject r1 = this.d.getInterceptJSONObject();
        String r2 = this.d.getInterceptFuncName();
        if (r6 == null) goto L21;
        if (TextUtils.isEmpty(r2) == true) goto L21;
        if (r5 == null) goto L21;
        if (r5.contains(r2) == false) goto L21;
        Iterator r3 = r1.keySet().iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        String r4 = (String) r3.next();
        if (r6.containsKey(r4) == true) goto L17;
        r6.put(r4, r1.get(r4));
        goto L17
    }

    @Override // com.bytedance.ee.bear.document.h6, vv4.j, vv4.k
    public void k(String r1, NonProguard r2, ValueCallback<String> r3) {
        super.k(r1, r2, r3);
    }

    @Override // com.bytedance.ee.bear.document.h6, vv4.j, vv4.k
    public void l(String r1, org.json.JSONObject r2, ValueCallback<String> r3) {
        super.l(r1, r2, r3);
    }
}
