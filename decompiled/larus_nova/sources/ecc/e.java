package ecc;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements mcc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f472178a;

    public e(b r100) {
        this.f472178a = r100;
    }

    @Override // mcc.b
    public final boolean c(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        mcc.b r103 = this.f472178a.f472171f;
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.c(r100, r101, r102);
    }

    @Override // mcc.b
    public final void d(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "userId");
        mcc.b r103 = this.f472178a.f472171f;
        if (r103 == null) goto L6;
        r103.d(r100, r101, r102);
        return;
    }
}
