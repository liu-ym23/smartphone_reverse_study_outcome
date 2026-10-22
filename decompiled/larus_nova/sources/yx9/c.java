package yx9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class c implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f569437c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f569438b;

    static {
        f569437c = new c();
    }

    @Override // yx9.a
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter("TRACE_SPAN", "tag");
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f569438b.d(r100);
    }

    @Override // yx9.a
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter("TRACE_SPAN", "tag");
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f569438b.e(r100);
    }

    @Override // yx9.a
    public final void w(String r100) {
        Intrinsics.checkNotNullParameter("TRACE_SPAN", "tag");
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f569438b.w(r100);
    }

    public c() {
        vx9.b.f557496a.getClass();
        this.f569438b = vx9.b.f557499d;
    }
}
