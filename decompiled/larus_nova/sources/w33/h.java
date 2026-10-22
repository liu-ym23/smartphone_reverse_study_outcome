package w33;

import kotlin.jvm.internal.Intrinsics;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class h<STATE extends g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f558142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final STATE f558143b;

    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "flowTimestamp");
        e<d> r101 = this.f558142a.f558127b;
        if ((r101 instanceof f) == true) goto L5;
        r101 = null;
    L5:
        f r102 = (f) r101;
        if (r102 == null) goto L9;
        r102.c(r100);
        return;
    }

    public h(STATE r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "initialBizState");
        Intrinsics.checkNotNullParameter(r101, "initialArchState");
        this.f558142a = r101;
        this.f558143b = r100;
    }
}
