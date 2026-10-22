package com.bytedance.locallife.dito.performance;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.locallife.dito.core.d0;
import com.bytedance.locallife.dito.core.page.PageStage;
import com.bytedance.locallife.dito.core.viewmodel.DitoViewModel;
import com.bytedance.locallife.dito.data.t;
import com.bytedance.locallife.dito.data.v;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/dito/performance/DitoPagePerformancePlugin;", "Lcom/bytedance/locallife/dito/performance/AbsPerformancePlugin;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/locallife/dito/data/p;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-performance-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoPagePerformancePlugin extends AbsPerformancePlugin implements Observer<com.bytedance.locallife.dito.data.p> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f258524e = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f258525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uq6.g f258526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f258527d;

    public static final class a {
    }

    public static final class b<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPagePerformancePlugin f258528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DitoViewModel f258529b;

        public b(DitoPagePerformancePlugin r100, DitoViewModel r101) {
            this.f258528a = r100;
            this.f258529b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            t r101 = (t) r100;
            Bundle r102 = this.f258528a.e().getArguments();
            if (r102 == null) goto L5;
            long r103 = r102.getLong("dito_page_open_ts", this.f258528a.e().f257783e);
        L6:
            long r104 = o.c(this.f258529b.o().f257909b, 0, 3);
            if (r103 <= 0) goto L9;
            r103 = Math.min(r104, r103);
        L9:
            this.f258528a.f258526c.e(Long.valueOf(r103));
            Long r105 = this.f258528a.f258526c.b();
            if (r105 == null) goto L12;
            long r106 = r105.longValue();
        L13:
            this.f258528a.f258526c.m(Long.valueOf(r104));
            long r107 = o.c(this.f258529b.o().f257911d, 0, 3);
            if (r107 <= 0) goto L16;
            r106 = Math.min(r107, r106);
        L16:
            DitoPagePerformancePlugin r108 = this.f258528a;
            uq6.g r109 = r108.f258526c;
            Bundle r110 = r108.e().getArguments();
            if (r110 == null) goto L19;
            r106 = r110.getLong("dito_router_ts", r106);
        L19:
            r109.n(Long.valueOf(r106));
            this.f258528a.f258526c.f(Long.valueOf(System.currentTimeMillis()));
            return;
        L12:
            r106 = this.f258528a.e().f257783e;
            goto L13
        L5:
            r103 = this.f258528a.e().f257783e;
            goto L6
        }
    }

    public static final class c<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPagePerformancePlugin f258530a;

        public c(DitoPagePerformancePlugin r100) {
            this.f258530a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == false) goto L5;
            this.f258530a.f258526c.l(Long.valueOf(System.currentTimeMillis()));
            return;
        L5:
            this.f258530a.f258526c.j(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static final class d<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPagePerformancePlugin f258531a;

        public d(DitoPagePerformancePlugin r100) {
            this.f258531a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == false) goto L8;
            uq6.h r101 = this.f258531a.f258527d.a();
            if (r101 == null) goto L17;
            r101.f(new uq6.d(Long.valueOf(System.currentTimeMillis())));
            return;
        L17:
            return;
        L8:
            uq6.h r102 = this.f258531a.f258527d.a();
            if (r102 == null) goto L15;
            uq6.d r103 = r102.b();
            if (r103 == null) goto L16;
            r103.g(o.a(r103.d(), Long.valueOf(System.currentTimeMillis())));
            return;
        L16:
            return;
        }
    }

    public static final class e<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPagePerformancePlugin f258532a;

        public e(DitoPagePerformancePlugin r100) {
            this.f258532a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == false) goto L11;
            uq6.h r101 = this.f258532a.f258527d.a();
            if (r101 == null) goto L7;
            uq6.d r102 = r101.b();
        L8:
            if (r102 == null) goto L20;
            r102.f(Long.valueOf(System.currentTimeMillis()));
            return;
        L20:
            return;
        L7:
            r102 = null;
            goto L8
        L11:
            uq6.h r103 = this.f258532a.f258527d.a();
            if (r103 == null) goto L18;
            uq6.d r104 = r103.b();
            if (r104 == null) goto L19;
            r104.e(o.a(r104.a(), Long.valueOf(System.currentTimeMillis())));
            return;
        L19:
            return;
        }
    }

    public static final class f<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPagePerformancePlugin f258533a;

        public f(DitoPagePerformancePlugin r100) {
            this.f258533a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == false) goto L11;
            uq6.h r101 = this.f258533a.f258527d.a();
            if (r101 == null) goto L7;
            uq6.d r102 = r101.b();
        L8:
            if (r102 == null) goto L20;
            r102.j(Long.valueOf(System.currentTimeMillis()));
            return;
        L20:
            return;
        L7:
            r102 = null;
            goto L8
        L11:
            uq6.h r103 = this.f258533a.f258527d.a();
            if (r103 == null) goto L18;
            uq6.d r104 = r103.b();
            if (r104 == null) goto L19;
            r104.h(o.a(r104.c(), Long.valueOf(System.currentTimeMillis())));
            return;
        L19:
            return;
        }
    }

    public static final class g<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPagePerformancePlugin f258534a;

        public g(DitoPagePerformancePlugin r100) {
            this.f258534a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((v) r100).f258263a == false) goto L11;
            uq6.h r101 = this.f258534a.f258527d.a();
            if (r101 == null) goto L7;
            uq6.d r102 = r101.b();
        L8:
            if (r102 == null) goto L20;
            r102.i(Long.valueOf(System.currentTimeMillis()));
            return;
        L20:
            return;
        L7:
            r102 = null;
            goto L8
        L11:
            uq6.h r103 = this.f258534a.f258527d.a();
            if (r103 == null) goto L18;
            uq6.d r104 = r103.b();
            if (r104 == null) goto L19;
            r104.h(o.a(r104.b(), Long.valueOf(System.currentTimeMillis())));
            return;
        L19:
            return;
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoPagePerformancePlugin f258535a;

        public h(DitoPagePerformancePlugin r100) {
            this.f258535a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Long r101 = null;
            if (((v) r100).f258263a == false) goto L11;
            DitoPagePerformancePlugin r102 = this.f258535a;
            int r103 = DitoPagePerformancePlugin.f258524e;
            r102.h(null);
            uq6.h r104 = this.f258535a.f258527d.a();
            if (r104 == null) goto L27;
            uq6.e r105 = r104.c();
            if (r105 == null) goto L30;
            r105.c(Long.valueOf(System.currentTimeMillis()));
            return;
        L30:
            return;
        L27:
            return;
        L11:
            if (this.f258535a.f258526c.c() != null) goto L15;
            FrameLayout r106 = this.f258535a.e().Ga0();
            if (r106 == null) goto L15;
            r106.post(new i(this.f258535a));
        L15:
            j r107 = this.f258535a.f258527d;
            uq6.h r108 = r107.f258554a.poll();
            if (r108 == null) goto L18;
            r107.f258555b.add(r108);
        L18:
            if (r108 == null) goto L29;
            uq6.e r109 = r108.c();
            if (r109 == null) goto L31;
            uq6.e r110 = r108.c();
            if (r110 == null) goto L25;
            r101 = r110.a();
        L25:
            r109.b(o.a(r101, Long.valueOf(System.currentTimeMillis())));
            return;
        L31:
            return;
        }
    }

    static {
    }

    public DitoPagePerformancePlugin() {
        this.f258526c = new uq6.g(0);
        this.f258527d = new j();
    }

    @Override // com.bytedance.locallife.dito.performance.AbsPerformancePlugin
    public final void g(DitoViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "ditoViewMode");
        this.f258526c.k(Long.valueOf(e().f257783e));
        d().f0().observe(e(), new b(this, r100));
        d().J().observe(e(), new c(this));
        d().H().observeForever(new DitoPagePerformancePlugin$onPluginAttach$3(this));
        d().r0("http_request_info", 0).observeForever(new DitoPagePerformancePlugin$onPluginAttach$4(this));
        d().w().observe(e(), new d(this));
        d().D().observe(e(), new e(this));
        d().F().observe(e(), new f(this));
        d().E().observe(e(), new g(this));
        h r101 = new h(this);
        d().x().observe(e(), r101);
        d().y().observe(e(), r101);
        d().k0().observe(e(), this);
        d().h0().observeForever(new DitoPagePerformancePlugin$onPluginAttach$9(this));
    }

    public final void h(com.bytedance.locallife.dito.data.p r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        if (r110 == null) goto L19;
        uq6.g r102 = this.f258526c;
        String r103 = r110.getType().name();
        Locale r104 = Locale.getDefault();
        if (r103 == null) goto L18;
        r102.d(r103.toLowerCase(r104));
        long r105 = r110.f258230b;
        long r106 = System.currentTimeMillis();
        if (r105 <= 0) goto L16;
        r106 = o.c(r105, r106, 2);
    L16:
        this.f258526c.h(Long.valueOf(r106));
        DitoViewModel r107 = f();
        PageStage r108 = PageStage.STABLE;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.G = r108;
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        uq6.h r109 = (uq6.h) CollectionsKt.lastOrNull(this.f258527d.f258555b);
        String r111 = this.f258526c.a();
        if (r111 != null) goto L22;
    L25:
        boolean r112 = true;
    L26:
        if (r112 == true) goto L30;
        if (r110 != null) goto L30;
        boolean r113 = false;
    L31:
        if (r109 == null) goto L55;
        Map<String, uq6.c> r114 = r109.a();
        if (r114 != null) goto L35;
    L38:
        boolean r115 = true;
    L39:
        if (r115 == true) goto L42;
        if (r113 == true) goto L42;
        return;
    L42:
        if (this.f258510a == null) goto L44;
        r100 = true;
    L44:
        if (r100 == false) goto L57;
        com.bytedance.locallife.dito.core.manager.b r116 = f().f258046l;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        Map<String, d0> r117 = r116.f257964b;
        LinkedHashMap r118 = (LinkedHashMap) r117;
        Object r119 = r118.get(DitoComponentPerformancePlugin.class.getName());
        if ((r119 instanceof DitoComponentPerformancePlugin) == false) goto L48;
        DitoComponentPerformancePlugin r120 = (DitoComponentPerformancePlugin) r119;
    L49:
        if (r120 == null) goto L58;
        Map<String, uq6.c> r121 = r109.a();
        if (r121 == null) goto L53;
        r121.putAll(r120.f258518c);
    L53:
        r120.f258518c.clear();
        return;
    L58:
        return;
    L48:
        r120 = null;
        goto L49
    L57:
        return;
    L35:
        if (r114.isEmpty() == true) goto L38;
        r115 = false;
        goto L39
    L55:
        return;
    L30:
        r113 = true;
        goto L31
    L22:
        if (r111.length() == 0) goto L25;
        r112 = false;
        goto L26
    L5:
        if (r110.f258231c != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        h((com.bytedance.locallife.dito.data.p) r100);
    }
}
