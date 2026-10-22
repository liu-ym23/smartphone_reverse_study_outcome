package dp7;

import android.view.View;
import android.view.ViewStub;

/* JADX INFO: loaded from: classes22.dex */
public final class g extends cp7.c.e<ViewStub> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f469613a = null;

    static {
        f469613a = new g();
    }

    public g() {
    }

    @Override // cp7.c.e
    public final View b(View r100) {
        if ((r100 instanceof ViewStub) == true) goto L6;
        r100 = null;
    L6:
        return (ViewStub) r100;
    }

    @Override // cp7.c.e
    public final /* bridge */ /* synthetic */ int c(View r100) {
        ViewStub r101 = (ViewStub) r100;
        return 0;
    }
}
