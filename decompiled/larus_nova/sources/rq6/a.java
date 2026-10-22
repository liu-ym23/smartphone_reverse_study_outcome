package rq6;

import com.bytedance.locallife.dito.Dito;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f538927a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f538928b = null;

    public a() {
    }

    static {
        f538927a = new a();
        Dito r100 = Dito.f257280a;
        f538928b = (c) Dito.a().a(c.class);
    }

    @Override // rq6.c
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        c r102 = f538928b;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    @Override // rq6.c
    public final void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        c r102 = f538928b;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // rq6.c
    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        c r102 = f538928b;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // rq6.c
    public final void d(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        c r102 = f538928b;
        if (r102 == null) goto L6;
        r102.d(r100, r101);
        return;
    }
}
