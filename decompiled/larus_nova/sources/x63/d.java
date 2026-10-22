package x63;

import com.byted.cast.common.TeaEventTrack;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f562604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f562605b;

    public d() {
    }

    public final void a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        b r101 = new b(r100);
        Intrinsics.checkNotNullParameter(r101, "action");
        if (this.f562604a != null) goto L5;
        this.f562604a = r101;
    L8:
        this.f562605b = r101;
        return;
    L5:
        a r102 = this.f562605b;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
        r102.f562600a = r101;
        goto L8
    }

    public final void b(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        c r101 = new c(r100);
        Intrinsics.checkNotNullParameter(r101, "action");
        if (this.f562604a != null) goto L5;
        this.f562604a = r101;
    L8:
        this.f562605b = r101;
        return;
    L5:
        a r102 = this.f562605b;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
        r102.f562600a = r101;
        goto L8
    }
}
