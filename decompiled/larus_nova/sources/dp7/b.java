package dp7;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends cp7.c.e<ImageView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f469608a = null;

    static {
        f469608a = new b();
    }

    public b() {
    }

    @Override // cp7.c.e
    public final View b(View r100) {
        if ((r100 instanceof ImageView) == true) goto L6;
        r100 = null;
    L6:
        return (ImageView) r100;
    }

    @Override // cp7.c.e
    public final int c(View r100) {
        return cp7.c.a.C5565a.b(((ImageView) r100).getDrawable());
    }
}
