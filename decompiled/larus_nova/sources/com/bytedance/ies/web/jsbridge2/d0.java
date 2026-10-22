package com.bytedance.ies.web.jsbridge2;

import android.webkit.WebView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class d0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f249336g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f249337h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f249338i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final List<TimeLineEvent> f249339j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d f249340k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.web.jsbridge2.b f249341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WebView f249342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f249343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<w> f249344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f249345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f249346f;

    public static class a extends g0<t> {
        @Override // com.bytedance.ies.web.jsbridge2.g0
        public final t b() {
            IJsBridge2Config r100 = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getGlobalCallListener();
        }

        public a() {
        }
    }

    public static class b extends g0<k0> {
        @Override // com.bytedance.ies.web.jsbridge2.g0
        public final k0 b() {
            IJsBridge2Config r100 = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
            if (r100 == null) goto L7;
            r100.getConfigurator();
            return null;
        L7:
            return null;
        }

        public b() {
        }
    }

    public static class c extends g0<s> {
        @Override // com.bytedance.ies.web.jsbridge2.g0
        public final s b() {
            IJsBridge2Config r100 = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getGlobalBridgeInterceptor();
        }

        public c() {
        }
    }

    public static class d extends g0<e> {
        @Override // com.bytedance.ies.web.jsbridge2.g0
        public final e b() {
            IJsBridge2Config r100 = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getSwitchConfig();
        }

        public d() {
        }
    }

    public interface e {
        boolean f();
    }

    static {
        f249336g = new a();
        f249337h = new b();
        f249338i = new c();
        f249339j = new CopyOnWriteArrayList();
        f249340k = new d();
    }

    public final void a() {
        if (this.f249346f == false) goto L8;
        IllegalStateException r100 = new IllegalStateException("JsBridge2 is already released!!!");
        if (m.f249390a == false) goto L9;
        throw r100;
    L9:
        return;
    }

    public final void e() {
        if (this.f249346f == false) goto L5;
        return;
    L5:
        this.f249341a.p();
        this.f249346f = true;
        Iterator r100 = ((ArrayList) this.f249344d).iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        w r101 = (w) r100.next();
        if (r101 == null) goto L7;
        r101.a();
        goto L7
    }

    public d0(o r100) {
        ArrayList r101 = new ArrayList();
        this.f249344d = r101;
        boolean r102 = false;
        this.f249346f = false;
        this.f249343c = r100;
        TimeLineEvent.b r103 = new TimeLineEvent.b();
        r103.b("enable_permission_check", Boolean.valueOf(r100.f249404i));
        b r104 = f249337h;
        if (r104.a() == null) goto L5;
        r102 = true;
    L5:
        r103.b("permission_config_repository", Boolean.valueOf(r102));
        r103.a("label_create_jsb_instance", r100.f249411p);
        if (r100.f249404i == false) goto L13;
        if (r104.a() == null) goto L13;
        r104.a().getClass();
        throw null;
    L13:
        if (r100.f249396a == null) goto L15;
        this.f249341a = new q0();
    L16:
        com.bytedance.ies.web.jsbridge2.b r105 = this.f249341a;
        r105.f249297a = r105.getContext(r100);
        r105.f249299c = r100.f249400e;
        r105.f249298b = r100.f249405j;
        r105.f249305i = new k(r100, r105, null);
        r105.f249301e = r100.f249406k;
        r105.f249308l = r100.f249411p;
        WebView r106 = r100.f249396a;
        if (r106 == null) goto L19;
        com.bytedance.ies.web.jsbridge2.a r107 = new com.bytedance.ies.web.jsbridge2.a.C3554a(r106);
    L20:
        r105.f249303g = r107;
        r105.f249304h = r100.b();
        r105.j(r100);
        this.f249342b = r100.f249396a;
        r101.add(null);
        m.f249390a = r100.f249402g;
        n0.f249395a = r100.f249403h;
        return;
    L19:
        r107 = r100.f249397b;
        goto L20
    L15:
        this.f249341a = r100.f249398c;
        goto L16
    }

    public final void b(d0 r100) {
        com.bytedance.ies.web.jsbridge2.b r101 = this.f249341a;
        k r102 = r100.f249341a.f249305i;
        ((HashMap) r101.f249307k).put("host", r102);
        y r103 = this.f249345e;
        if (r103 == null) goto L7;
        y r104 = r100.f249345e;
        if (r104 == null) goto L7;
        r103.a(r104);
    L7:
        List<w> r105 = this.f249344d;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new e0(r100));
    }

    public final void g(String r100) {
        a();
        k r101 = this.f249341a.f249305i;
        ((ConcurrentHashMap) r101.f249374c).remove(r100);
        ((ConcurrentHashMap) r101.f249375d).remove(r100);
        y r102 = this.f249345e;
        if (r102 == null) goto L6;
        r102.b(r100);
        return;
    }

    public d0(o r100, Boolean r101) {
        this.f249344d = new ArrayList();
        this.f249346f = false;
        this.f249343c = r100;
        r100.f249409n = r101.booleanValue();
        this.f249342b = null;
        this.f249341a = r100.f249398c;
    }

    public final void c(String r100, f.b r101) {
        a();
        ((ConcurrentHashMap) this.f249341a.f249305i.f249375d).put(r100, r101);
        y r102 = this.f249345e;
        if (r102 == null) goto L6;
        r102.c(r100);
        return;
    }

    public final void d(String r100, g r101) {
        a();
        k r102 = this.f249341a.f249305i;
        r102.getClass();
        r101.setName(r100);
        ((ConcurrentHashMap) r102.f249374c).put(r100, r101);
        y r103 = this.f249345e;
        if (r103 == null) goto L6;
        r103.c(r100);
        return;
    }

    public final <T> void f(String r100, T r101) {
        a();
        this.f249341a.q(r100, r101);
    }
}
