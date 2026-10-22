package dj4;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f468910a;

    public d(e r100) {
        this.f468910a = r100;
    }

    @Override // dj4.i.b
    public final void a(View r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "detector");
        f r102 = this.f468910a.f468911a;
        if (r102 == null) goto L6;
        r102.d(r101);
        return;
    }

    @Override // dj4.i.b
    public final boolean b(View r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "detector");
        f r102 = this.f468910a.f468911a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.c(r101);
    }

    @Override // dj4.i.b
    public final boolean c(View r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "detector");
        f r102 = this.f468910a.f468911a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.b(r101);
    }
}
