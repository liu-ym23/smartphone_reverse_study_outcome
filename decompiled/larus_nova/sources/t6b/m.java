package t6b;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class m implements s6b.b<m, n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f544832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f544833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w0 f544834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f544835d;

    public m() {
        this(0);
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new n(this);
    }

    public s0 c() {
        return this.f544833b;
    }

    public w0 d() {
        return this.f544834c;
    }

    public a1 e() {
        return this.f544832a;
    }

    public boolean f() {
        return this.f544835d;
    }

    public /* synthetic */ m(int r100) {
        this(null, null, null, false);
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r100) {
        m r101 = (m) r100;
        Intrinsics.checkNotNullParameter(r101, "patch");
        return new m(r101.e(), r101.c(), r101.d(), r101.f());
    }

    public m(a1 r100, s0 r101, w0 r102, boolean r103) {
        this.f544832a = r100;
        this.f544833b = r101;
        this.f544834c = r102;
        this.f544835d = r103;
    }
}
