package com.bytedance.ies.bullet.core;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class z implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f246574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f246575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f246576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f246577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Uri f246578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h16.e f246579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f246580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t36.j f246581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f246582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f246583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f246584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f246585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f246586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Throwable f246587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f246588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Throwable f246589p;

    public static abstract class a extends u26.b.a {
        public abstract void o(ConcurrentLinkedQueue<q> r100);

        public a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f246590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.ies.bullet.service.base.o f246591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f246592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f246593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f246594e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f246595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f246596g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f246597h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f246598i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f246599j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f246600k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public u26.e f246601l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f246602m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public JSONObject f246603n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f246604o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public JSONObject f246605p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f246606q;

        @Override // u26.b.a, u26.b
        public final void a(com.bytedance.ies.bullet.service.base.o r100, Context r101, String r102, String r103, float r104, float r105, Transformer r106, Function2<Object, ? super Throwable, Unit> r107) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r107, "handler");
        }

        @Override // u26.b.a, u26.b
        public final String shouldRedirectImageUrl(String r100) {
            return null;
        }

        public b() {
        }

        @Override // u26.b.a, u26.b
        public final void b(com.bytedance.ies.bullet.service.base.o r100) {
            this.f246594e = true;
        }

        @Override // u26.b.a, u26.b
        public final void c(com.bytedance.ies.bullet.service.base.o r100) {
            this.f246595f = true;
        }

        @Override // u26.b.a, u26.b
        public final void d(com.bytedance.ies.bullet.service.base.o r100) {
            this.f246593d = true;
        }

        @Override // u26.b.a, u26.b
        public final void h(com.bytedance.ies.bullet.service.base.o r100) {
            this.f246606q = true;
        }

        @Override // com.bytedance.ies.bullet.core.z.a
        public final void o(ConcurrentLinkedQueue<q> r100) {
            Intrinsics.checkNotNullParameter(r100, "lifeCycles");
            if (this.f246590a == false) goto L15;
            Iterator<T> r101 = r100.iterator();
        L6:
            if (r101.hasNext() == false) goto L15;
            q r102 = (q) r101.next();
            if ((r102 instanceof z) == false) goto L10;
            r102 = null;
        L10:
            if (r102 == null) goto L6;
            u26.b r103 = r102.getLynxClient();
            if (r103 == null) goto L6;
            r103.f(this.f246591b, this.f246592c);
        L15:
            if (this.f246593d == false) goto L27;
            Iterator<T> r104 = r100.iterator();
        L18:
            if (r104.hasNext() == false) goto L27;
            q r105 = (q) r104.next();
            if ((r105 instanceof z) == false) goto L22;
            r105 = null;
        L22:
            if (r105 == null) goto L18;
            u26.b r106 = r105.getLynxClient();
            if (r106 == null) goto L18;
            r106.d(this.f246591b);
        L27:
            if (this.f246594e == false) goto L39;
            Iterator<T> r107 = r100.iterator();
        L30:
            if (r107.hasNext() == false) goto L39;
            q r108 = (q) r107.next();
            if ((r108 instanceof z) == false) goto L34;
            r108 = null;
        L34:
            if (r108 == null) goto L30;
            u26.b r109 = r108.getLynxClient();
            if (r109 == null) goto L30;
            r109.b(this.f246591b);
        L39:
            if (this.f246595f == false) goto L51;
            Iterator<T> r110 = r100.iterator();
        L42:
            if (r110.hasNext() == false) goto L51;
            q r111 = (q) r110.next();
            if ((r111 instanceof z) == false) goto L46;
            r111 = null;
        L46:
            if (r111 == null) goto L42;
            u26.b r112 = r111.getLynxClient();
            if (r112 == null) goto L42;
            r112.c(this.f246591b);
        L51:
            if (this.f246596g == false) goto L64;
            Iterator<T> r113 = r100.iterator();
        L54:
            if (r113.hasNext() == false) goto L62;
            q r114 = (q) r113.next();
            if ((r114 instanceof z) == false) goto L58;
            r114 = null;
        L58:
            if (r114 == null) goto L54;
            u26.b r115 = r114.getLynxClient();
            if (r115 == null) goto L54;
            r115.g(this.f246591b, this.f246597h);
            goto L54
        L62:
            this.f246597h = null;
        L64:
            if (this.f246598i == false) goto L77;
            Iterator<T> r116 = r100.iterator();
        L67:
            if (r116.hasNext() == false) goto L75;
            q r117 = (q) r116.next();
            if ((r117 instanceof z) == false) goto L71;
            r117 = null;
        L71:
            if (r117 == null) goto L67;
            u26.b r118 = r117.getLynxClient();
            if (r118 == null) goto L67;
            r118.n(this.f246591b, this.f246599j);
            goto L67
        L75:
            this.f246599j = null;
        L77:
            if (this.f246600k == false) goto L90;
            Iterator<T> r119 = r100.iterator();
        L80:
            if (r119.hasNext() == false) goto L88;
            q r120 = (q) r119.next();
            if ((r120 instanceof z) == false) goto L84;
            r120 = null;
        L84:
            if (r120 == null) goto L80;
            u26.b r121 = r120.getLynxClient();
            if (r121 == null) goto L80;
            r121.l(this.f246591b, this.f246601l);
            goto L80
        L88:
            this.f246601l = null;
        L90:
            if (this.f246602m == false) goto L103;
            Iterator<T> r122 = r100.iterator();
        L93:
            if (r122.hasNext() == false) goto L101;
            q r123 = (q) r122.next();
            if ((r123 instanceof z) == false) goto L97;
            r123 = null;
        L97:
            if (r123 == null) goto L93;
            u26.b r124 = r123.getLynxClient();
            if (r124 == null) goto L93;
            r124.e(this.f246591b, this.f246603n);
            goto L93
        L101:
            this.f246603n = null;
        L103:
            if (this.f246604o == false) goto L116;
            Iterator<T> r125 = r100.iterator();
        L106:
            if (r125.hasNext() == false) goto L114;
            q r126 = (q) r125.next();
            if ((r126 instanceof z) == false) goto L110;
            r126 = null;
        L110:
            if (r126 == null) goto L106;
            u26.b r127 = r126.getLynxClient();
            if (r127 == null) goto L106;
            r127.i(this.f246591b, this.f246605p);
            goto L106
        L114:
            this.f246605p = null;
        L116:
            if (this.f246606q == false) goto L127;
            Iterator<T> r128 = r100.iterator();
        L119:
            if (r128.hasNext() == false) goto L127;
            q r129 = (q) r128.next();
            if ((r129 instanceof z) == false) goto L123;
            r129 = null;
        L123:
            if (r129 == null) goto L119;
            u26.b r130 = r129.getLynxClient();
            if (r130 == null) goto L119;
            r130.h(this.f246591b);
        L127:
            this.f246591b = null;
            this.f246592c = null;
        }

        @Override // u26.b.a, u26.b
        public final void e(com.bytedance.ies.bullet.service.base.o r100, JSONObject r101) {
            this.f246602m = true;
            this.f246603n = r101;
        }

        @Override // u26.b.a, u26.b
        public final void f(com.bytedance.ies.bullet.service.base.o r100, String r101) {
            this.f246590a = true;
            this.f246591b = r100;
            this.f246592c = r101;
        }

        @Override // u26.b.a, u26.b
        public final void g(com.bytedance.ies.bullet.service.base.o r100, String r101) {
            this.f246596g = true;
            this.f246597h = r101;
        }

        @Override // u26.b.a, u26.b
        public final void i(com.bytedance.ies.bullet.service.base.o r100, JSONObject r101) {
            this.f246604o = true;
            this.f246605p = r101;
        }

        @Override // u26.b.a, u26.b
        public final void l(com.bytedance.ies.bullet.service.base.o r100, u26.e r101) {
            this.f246600k = true;
            this.f246601l = r101;
        }

        @Override // u26.b.a, u26.b
        public final void n(com.bytedance.ies.bullet.service.base.o r100, String r101) {
            this.f246598i = true;
            this.f246599j = r101;
        }
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void LG(Uri r100, com.bytedance.ies.bullet.service.base.o r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void lX() {
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void onClose() {
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void onOpen() {
        this.f246583j = true;
    }

    @Override // com.bytedance.ies.bullet.core.q
    public final void rS() {
        this.f246576c = true;
    }

    public z() {
        this.f246574a = new AtomicBoolean(false);
        this.f246575b = new b();
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final u26.b getLynxClient() {
        return this.f246575b;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void HP(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246584k = true;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public void Ox(Uri r100, h16.e r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246577d = true;
        this.f246578e = r100;
        this.f246579f = r101;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void TH(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f246588o = true;
        this.f246589p = r101;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void gQ(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246582i = true;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public void go(Uri r100, com.bytedance.ies.bullet.service.base.o r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f246585l = true;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public void onLoadFail(Uri r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "e");
        this.f246586m = true;
        this.f246587n = r101;
    }

    @Override // com.bytedance.ies.bullet.core.s
    public final void bK(Uri r100, com.bytedance.ies.bullet.service.base.o r101, t36.j r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r102, "schemaModelUnion");
        this.f246580g = true;
        this.f246581h = r102;
    }
}
