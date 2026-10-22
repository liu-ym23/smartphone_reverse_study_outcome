package nd9;

import com.larus.im.internal.audio.w;
import com.larus.im.internal.utils.a0;
import com.larus.im.service.audio.k0;
import com.larus.im.service.audio.v;
import com.larus.im.service.audio.x0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0<jd9.c> f518814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x0 f518815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ue9.i> f518816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f518817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<v> f518818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f518819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f518820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f518821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final h f518822i;

    public static final class a {
    }

    static {
    }

    public final ue9.i b() {
        return (ue9.i) this.f518817d.getValue();
    }

    public final void a(ue9.c r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f518819f.set(false);
        b().m(r100);
        b().disconnect();
        c(jd9.b.a(r100));
    }

    public final void c(jd9.c r100) {
        JSONObject r101 = b().o();
        r101.remove("token");
        r100.f498753b = sf9.a.f(r101.toString());
        a0<jd9.c> r102 = this.f518814a;
        jd9.c r103 = r102.f350525b;
        if (r102.b(r100) == false) goto L19;
        fe9.c.f476624a.e("SessionConnectionManager", "The current session(" + this.f518815b.hashCode() + ") move session from " + r103 + " to " + r100 + " succeed.");
        if (this.f518818e.isEmpty() == true) goto L31;
        CopyOnWriteArraySet<v> r104 = this.f518818e;
        Iterator<v> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        v r106 = r105.next();
        if (w.a(r106) <= 0) goto L9;
        r106.O1(r103, r100);
        goto L9
    L13:
        Iterator<v> r107 = r104.iterator();
    L15:
        if (r107.hasNext() == false) goto L32;
        v r108 = r107.next();
        if (w.a(r108) > 0) goto L15;
        r108.O1(r103, r100);
        goto L15
    L32:
        return;
    L31:
        return;
    L19:
        fe9.c.f476624a.f("SessionConnectionManager", "move session from " + r103 + " to " + r100 + " failed.");
    }

    public g(a0 r100, x0 r101, k0 r102) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "channelProvider");
        this.f518814a = r100;
        this.f518815b = r101;
        this.f518816c = r102;
        this.f518817d = LazyKt.lazy(new f(this));
        this.f518818e = new CopyOnWriteArraySet();
        this.f518819f = new AtomicBoolean(false);
        this.f518820g = new AtomicBoolean(false);
        this.f518821h = new i(this);
        this.f518822i = new h(this);
    }
}
