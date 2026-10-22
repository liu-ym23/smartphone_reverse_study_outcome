package tec;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import mcc.p;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements mcc.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f545676a;

    public e(a r100) {
        this.f545676a = r100;
    }

    @Override // mcc.g
    public final void j(View r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageClickInfo");
        mcc.g r102 = this.f545676a.f545667k;
        if (r102 == null) goto L6;
        r102.j(r100, r101);
        return;
    }
}
