package ecc;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import mcc.p;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements mcc.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f472179a;

    public f(b r100) {
        this.f472179a = r100;
    }

    @Override // mcc.g
    public final void j(View r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageClickInfo");
        mcc.g r102 = this.f472179a.f472172g;
        if (r102 == null) goto L6;
        r102.j(r100, r101);
        return;
    }
}
