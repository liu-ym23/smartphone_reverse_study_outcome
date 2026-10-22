package ln0;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import pn0.d;
import pn0.g;
import rn0.c;
import rn0.e;
import sn0.l;
import sn0.m;
import sn0.n;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f509964c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rn0.b f509965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f509966b;

    /* JADX INFO: renamed from: ln0.a$a, reason: collision with other inner class name */
    public static final class C6713a {
    }

    static {
    }

    public final void b() {
        rn0.b r100 = this.f509965a;
        r100.getClass();
        String r101 = r100.f538652g.f509967a + "entrance.json";
        b r102 = r100.f538652g;
        if (r102.f509969c.f529894b == true) goto L6;
        return;
    L6:
        if (r102.f509970d.b(r101) == false) goto L8;
        r100.f538652g.f509971e.a("LayoutConfigResManager", "tryPreloadGeckoRes: already loaded.", false);
        return;
    L8:
        r100.f538652g.f509971e.a("LayoutConfigResManager", "tryPreloadGeckoRes: start load.", true);
        r100.f538652g.f509970d.a(r101, new e(r100));
    }

    public a(b r100) {
        this.f509966b = r100;
        this.f509965a = new rn0.b(r100);
    }

    public final void a(d r100, on0.a r110) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r110, "listener");
        rn0.b r101 = this.f509965a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r110, "listener");
        long r102 = System.currentTimeMillis();
        g r103 = r101.f538652g.f509970d.c().e(r100);
        r101.f538652g.f509971e.a("LayoutConfigResManager", "loadLayoutConfig: start load, request = " + r100 + ", modifiedRequestParams = " + r103, false);
        ArrayList r104 = new ArrayList();
        r104.add(new n.c(r101.f538648c, r101));
        r104.add(new n.a(r101.f538646a, r101));
        r104.add(new n.b(r101.f538647b, r101));
        int r105 = n.f542642a;
        Intrinsics.checkNotNullParameter(r104, "createConfigs");
        Iterator r106 = r104.iterator();
        l r107 = null;
    L4:
        if (r106.hasNext() == false) goto L6;
        r107 = ((m) r106.next()).a(r107);
        goto L4
    L6:
        if (r107 == null) goto L10;
        r107.a(r100, r103, new c(r101, r102, r110));
        return;
    }
}
