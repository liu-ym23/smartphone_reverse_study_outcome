package tg4;

import kotlin.jvm.internal.Intrinsics;
import ng4.l;
import ng4.m;
import ug4.b;

/* JADX INFO: loaded from: classes15.dex */
public class a implements m {
    public a() {
    }

    public void b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        b.a(new Object[]{"onParseSuccess", r100});
    }

    @Override // ng4.f
    public final void c(l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        b.a(new Object[]{"onDownloadSuccess", r100});
    }

    @Override // ng4.f
    public final void d(l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        b.a(new Object[]{"onDownloadCancel", r100});
    }

    public void e(l r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        b.a(new Object[]{"onLyricTransform", r100});
    }

    @Override // ng4.f
    public final void f(int r100) {
        b.a(new Object[]{"onDownloadProgress", Integer.valueOf(r100)});
    }

    @Override // ng4.j
    public final void a(l r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        b.a(new Object[]{"onParseFail", r100, r101});
    }

    @Override // ng4.f
    public final void g(l r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r102, "errorMsg");
        b.a(new Object[]{"onDownloadFailed", r100, Integer.valueOf(r101), r102});
    }
}
