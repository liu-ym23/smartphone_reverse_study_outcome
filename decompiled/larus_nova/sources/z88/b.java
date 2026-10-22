package z88;

import com.larus.avlink.business.api.DoraAvlinkSessionMode;
import com.larus.avlink.business.api.DoraAvlinkSessionState;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<z88.a> f570952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<y88.d> f570953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile f f570954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f570955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile DoraAvlinkSessionMode f570956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f570957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f570958g;

    public static final class a {
    }

    static {
    }

    public final void a() {
        if (this.f570955d == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f570952a.iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((z88.a) r100.next()).b(this.f570958g);
        goto L7
    L9:
        this.f570955d = true;
    }

    public final void b(y88.e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f570954c.f570962b != DoraAvlinkSessionState.STOPPED) goto L6;
        this.f570958g.log("ignore session event after session ended: " + r100);
        return;
    L6:
        boolean r101 = r100 instanceof y88.e.f;
        if (r101 == false) goto L13;
        y88.e.f r102 = (y88.e.f) r100;
        if (r102.f566926a != this.f570954c.f570962b) goto L13;
        this.f570958g.log("ignore duplicated session state: " + r102.f566926a);
        return;
    L13:
        if (r101 == false) goto L16;
        this.f570954c = f.a(this.f570954c, ((y88.e.f) r100).f566926a, null, 13);
    L16:
        if ((r100 instanceof y88.e.d) == false) goto L25;
        this.f570957f = ((y88.e.d) r100).f566924a;
        f r103 = this.f570954c;
        if (this.f570957f == false) goto L20;
        DoraAvlinkSessionMode r104 = DoraAvlinkSessionMode.LIVE_AI;
    L24:
        this.f570954c = f.a(r103, null, r104, 11);
        goto L25
    L20:
        DoraAvlinkSessionMode r105 = this.f570956e;
        DoraAvlinkSessionMode r106 = DoraAvlinkSessionMode.LIVE_AI;
        if (r105 != r106) goto L23;
        r104 = r106;
        goto L24
    L23:
        r104 = this.f570956e;
    L25:
        f r107 = this.f570954c;
        Iterator<T> r108 = this.f570952a.iterator();
    L27:
        if (r108.hasNext() == false) goto L29;
        ((z88.a) r108.next()).a(r100, r107);
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "capabilities");
        Intrinsics.checkNotNullParameter(r101, "platformDelegateProvider");
        this.f570952a = r100;
        this.f570953b = r101;
        String r102 = "";
        Object[] r103 = 0 == true ? 1 : 0;
        this.f570954c = new f(r102, null, r103, 14);
        this.f570956e = DoraAvlinkSessionMode.NORMAL;
        this.f570958g = new c(this);
        a();
    }
}
