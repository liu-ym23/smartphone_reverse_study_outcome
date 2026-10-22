package sz7;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f544021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f544022b;

    @Override // sz7.l
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        Drawable r101 = this.f544022b.f544030h;
        if (r101 == null) goto L5;
        k r102 = this.f544021a;
        Intrinsics.checkNotNull(r101);
        r102.setIcon(r101);
    L5:
        this.f544022b.getClass();
    }

    @Override // sz7.l
    public final void onSuccess(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f544021a.setIcon(r100);
        this.f544022b.getClass();
    }

    public r(o r100, s r101) {
        this.f544021a = r100;
        this.f544022b = r101;
    }
}
