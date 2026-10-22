package t6b;

import com.ss.android.lark.biz.im.api.b1;
import com.ss.android.lark.biz.im.api.f0;
import com.ss.android.lark.biz.im.api.u0;
import com.ss.android.lark.biz.im.api.v0;
import com.ss.android.lark.biz.im.api.z0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class c implements s6b.b<c, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f544769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b1> f544771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0 f544772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<u0> f544773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f544774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f544775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y6b.e<y6b.c<?>> f544776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f544777i;

    public c() {
        this(null, 0, null, null, null, null, 2047);
    }

    public v0 e() {
        return null;
    }

    public jya.b i() {
        return null;
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new d(this);
    }

    public boolean c() {
        return this.f544777i;
    }

    public List<u0> d() {
        return this.f544773e;
    }

    public z0 f() {
        return this.f544769a;
    }

    public List<b1> g() {
        return this.f544771c;
    }

    public f0 h() {
        return this.f544772d;
    }

    public int j() {
        return this.f544770b;
    }

    public y6b.e<y6b.c<?>> k() {
        return this.f544776h;
    }

    public Boolean l() {
        return this.f544775g;
    }

    public Class<?> m() {
        return this.f544774f;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r110) {
        c r111 = (c) r110;
        Intrinsics.checkNotNullParameter(r111, "patch");
        return new c(r111.f(), r111.j(), r111.g(), r111.h(), r111.d(), r111.e(), r111.i(), r111.m(), r111.l(), r111.k(), r111.c());
    }

    public /* synthetic */ c(z0 r110, int r111, List r112, List r113, Class r210, y6b.e r211, int r212) {
        if ((r212 & 1) == 0) goto L5;
        z0 r100 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r212 & 4) == 0) goto L13;
        List r102 = CollectionsKt.emptyList();
    L15:
        if ((r212 & 16) == 0) goto L17;
        List r103 = CollectionsKt.emptyList();
    L19:
        if ((r212 & 128) == 0) goto L21;
        Class r114 = null;
    L23:
        if ((r212 & 512) == 0) goto L25;
        y6b.e r115 = null;
    L27:
        if ((r212 & 1024) == 0) goto L29;
        boolean r116 = true;
    L30:
        this(r100, r101, r102, null, r103, null, null, r114, null, r115, r116);
        return;
    L29:
        r116 = false;
        goto L30
    L25:
        r115 = r211;
        goto L27
    L21:
        r114 = r210;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(z0 r100, int r101, List<? extends b1> r102, f0 r103, List<? extends u0> r104, v0 r105, jya.b r106, Class<?> r107, Boolean r108, y6b.e<y6b.c<?>> r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r102, "messagePushInterceptors");
        Intrinsics.checkNotNullParameter(r104, "messageListChangeInterceptors");
        this.f544769a = r100;
        this.f544770b = r101;
        this.f544771c = r102;
        this.f544772d = r103;
        this.f544773e = r104;
        this.f544774f = r107;
        this.f544775g = r108;
        this.f544776h = r110;
        this.f544777i = r111;
    }
}
