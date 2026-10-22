package com.bytedance.ies.web.jsbridge2;

import android.webkit.WebView;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes19.dex */
public final class f0 implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f249349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n56.a f249350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f249351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, e> f249352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f249353e;

    @Override // com.bytedance.ies.web.jsbridge2.y
    public final void a(y r100) {
        if ((r100 instanceof f0) == false) goto L6;
        f0 r101 = (f0) r100;
        Map<String, e> r102 = this.f249352d;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.putAll(r101.f249352d);
        Set<String> r104 = this.f249353e;
        CopyOnWriteArraySet r105 = (CopyOnWriteArraySet) r104;
        r105.addAll(r101.f249353e);
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.y
    public final void b(String r100) {
        ((CopyOnWriteArraySet) this.f249353e).add(r100);
        ((ConcurrentHashMap) this.f249352d).remove(r100);
    }

    @Override // com.bytedance.ies.web.jsbridge2.y
    public final void c(String r100) {
        ((CopyOnWriteArraySet) this.f249353e).remove(r100);
        h0 r101 = this.f249351c;
        if (r101 == null) goto L6;
        this.f249350b.e(r100, r101);
        return;
    }

    public f0(WebView r100, d0 r101) {
        this.f249352d = new ConcurrentHashMap();
        CopyOnWriteArraySet r102 = new CopyOnWriteArraySet();
        this.f249353e = r102;
        b r103 = r101.f249341a;
        this.f249349a = r103;
        n56.a r104 = new n56.a(r100);
        r104.f518023g = true;
        this.f249350b = r104;
        if ((r103 instanceof q0) == false) goto L5;
        this.f249351c = new h0((q0) r103, r102);
        return;
    L5:
        this.f249351c = null;
    }

    public final void d(String r100, n56.c r101) {
        h0 r102 = this.f249351c;
        if (r102 == null) goto L5;
        this.f249350b.e(r100, r102);
    L5:
        r r103 = new r(r101);
        this.f249349a.f249305i.g(r100, r103);
        ((ConcurrentHashMap) this.f249352d).put(r100, r103);
    }
}
