package dp7;

import android.view.View;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends cp7.c.e<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f469611a = null;

    @Override // cp7.c.e
    public final int c(View r100) {
        return 0;
    }

    static {
        f469611a = new e();
    }

    public e() {
    }

    @Override // cp7.c.e
    public final View b(View r100) {
        if (r100.getClass().isAssignableFrom(View.class) == true) goto L7;
        return null;
    L7:
        return r100;
    }
}
