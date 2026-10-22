package t6b;

import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.s0;
import com.ss.android.lark.biz.im.api.w0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class n extends m {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1 f544836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s0 f544837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w0 f544838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f544839h;

    @Override // t6b.m
    public final s0 c() {
        return this.f544837f;
    }

    @Override // t6b.m
    public final w0 d() {
        return this.f544838g;
    }

    @Override // t6b.m
    public final a1 e() {
        return this.f544836e;
    }

    @Override // t6b.m
    public final boolean f() {
        return this.f544839h;
    }

    public n(m r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(0);
        this.f544836e = r100.e();
        this.f544837f = r100.c();
        this.f544838g = r100.d();
        this.f544839h = r100.f();
    }
}
