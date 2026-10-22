package y21;

import com.bytedance.android.live.revlink.impl.pk.feedview.machine.t;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.w;
import d41.d;
import d41.f;
import d41.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements d, g, d41.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d41.c f565696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d41.c f565697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d41.a f565698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f565699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f565700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w f565701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t f565702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f565703h;

    /* JADX INFO: renamed from: y21.a$a, reason: collision with other inner class name */
    public static final class C8297a {
    }

    static {
    }

    @Override // d41.g
    public final void b() {
        b r100 = this.f565700e;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    @Override // d41.g
    public final boolean c() {
        b r100 = this.f565700e;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.c();
    }

    public a() {
        this.f565696a = new d41.c("pk_left_timer", this);
        this.f565697b = new d41.c("penal_left_timer", this);
        this.f565698c = new d41.a("", this);
        this.f565699d = new f(this);
    }

    @Override // d41.b
    public final void e(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        c r102 = this.f565703h;
        if (r102 == null) goto L6;
        r102.d(r101);
        return;
    }

    @Override // d41.d
    public final void g(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (Intrinsics.areEqual(r100, "pk_left_timer") == false) goto L10;
        if (r101 != 0) goto L6;
        this.f565699d.b();
    L6:
        w r102 = this.f565701f;
        if (r102 == null) goto L10;
        r102.h(r101);
    L10:
        if (Intrinsics.areEqual(r100, "penal_left_timer") == false) goto L19;
        if (r101 != 0) goto L15;
        b r103 = this.f565700e;
        if (r103 == null) goto L15;
        r103.a();
    L15:
        t r104 = this.f565702g;
        if (r104 == null) goto L20;
        r104.g(r101);
        return;
    L20:
        return;
    }
}
