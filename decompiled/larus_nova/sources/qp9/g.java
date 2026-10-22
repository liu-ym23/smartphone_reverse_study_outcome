package qp9;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g implements j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f534391a;

    public g(h r100) {
        this.f534391a = r100;
    }

    @Override // qp9.j.b
    public final boolean a(View r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "detector");
        i r102 = this.f534391a.f534392a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.d(r101);
    }

    @Override // qp9.j.b
    public final boolean b(View r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "detector");
        i r102 = this.f534391a.f534392a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.c(r101);
    }

    @Override // qp9.j.b
    public final void c(View r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "detector");
        i r102 = this.f534391a.f534392a;
        if (r102 == null) goto L6;
        r102.b(r101);
        return;
    }
}
