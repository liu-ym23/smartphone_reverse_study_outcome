package my8;

import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes26.dex */
public final class q implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f516409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f516410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f516411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f516412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f516413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f516414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f516415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f516416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f516417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f516418j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f516419k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f516420l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f516421m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f516422n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f516423o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f516424p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f516425q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f516426r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f516427s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f516428t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f516429u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f516430v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f516431w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f516432x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f516433y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f516434z;

    public static final class a {
    }

    static {
    }

    public q() {
        this(null);
    }

    public final String a() {
        return (String) this.f516423o.getValue();
    }

    public final String b() {
        return (String) this.f516421m.getValue();
    }

    public final String c() {
        return (String) this.f516424p.getValue();
    }

    public final String d() {
        return (String) this.f516429u.getValue();
    }

    public q(Bundle r100) {
        this.f516409a = r100;
        this.f516410b = LazyKt.lazy(new my8.a(this));
        this.f516411c = LazyKt.lazy(new n(this));
        this.f516412d = LazyKt.lazy(new o(this));
        this.f516413e = LazyKt.lazy(new p(this));
        this.f516414f = LazyKt.lazy(new b(this));
        this.f516415g = LazyKt.lazy(new c(this));
        this.f516416h = LazyKt.lazy(new d(this));
        this.f516417i = LazyKt.lazy(new e());
        this.f516418j = LazyKt.lazy(new f(this));
        this.f516419k = LazyKt.lazy(new g(this));
        this.f516420l = LazyKt.lazy(new h(this));
        this.f516421m = LazyKt.lazy(new i(this));
        this.f516422n = "coco_instruction";
        this.f516423o = LazyKt.lazy(new j(this));
        this.f516424p = LazyKt.lazy(new k(this));
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString("enter_method");
    L6:
        this.f516425q = r102;
        if (r100 == null) goto L9;
        String r103 = r100.getString("pic_source_message_id");
    L10:
        this.f516426r = r103;
        if (r100 == null) goto L13;
        r101 = r100.getString("source_creation_task_id");
    L13:
        this.f516427s = r101;
        this.f516428t = "image_generate_canvas";
        this.f516429u = LazyKt.lazy(new l(this));
        this.f516430v = "image_generate_page";
        this.f516431w = "pure";
        this.f516432x = System.currentTimeMillis();
        Lazy r104 = LazyKt.lazy(new m(this));
        this.f516433y = r104;
        this.f516434z = (String) r104.getValue();
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
