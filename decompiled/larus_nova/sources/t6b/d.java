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
public final class d extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z0 f544778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f544779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<b1> f544780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f0 f544781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<u0> f544782n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Class<?> f544783o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f544784p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final y6b.e<y6b.c<?>> f544785q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f544786r;

    @Override // t6b.c
    public final v0 e() {
        return null;
    }

    @Override // t6b.c
    public final jya.b i() {
        return null;
    }

    @Override // t6b.c
    public final boolean c() {
        return this.f544786r;
    }

    @Override // t6b.c
    public final List<u0> d() {
        return this.f544782n;
    }

    @Override // t6b.c
    public final z0 f() {
        return this.f544778j;
    }

    @Override // t6b.c
    public final List<b1> g() {
        return this.f544780l;
    }

    @Override // t6b.c
    public final f0 h() {
        return this.f544781m;
    }

    @Override // t6b.c
    public final int j() {
        return this.f544779k;
    }

    @Override // t6b.c
    public final y6b.e<y6b.c<?>> k() {
        return this.f544785q;
    }

    @Override // t6b.c
    public final Boolean l() {
        return this.f544784p;
    }

    @Override // t6b.c
    public final Class<?> m() {
        return this.f544783o;
    }

    public d(c r110) {
        Intrinsics.checkNotNullParameter(r110, "base");
        super(null, 0, null, null, null, null, 2047);
        this.f544778j = r110.f();
        this.f544779k = r110.j();
        this.f544780l = CollectionsKt.toMutableList(r110.g());
        this.f544781m = r110.h();
        this.f544782n = CollectionsKt.toMutableList(r110.d());
        r110.e();
        this.f544783o = r110.m();
        this.f544784p = r110.l();
        this.f544785q = r110.k();
        this.f544786r = r110.c();
        r110.i();
    }
}
