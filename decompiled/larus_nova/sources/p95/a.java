package p95;

import android.graphics.Bitmap;
import android.widget.ImageView;
import q95.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements c<ImageView, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f528303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f528304b;

    public a(ImageView r100) {
        if (r100 == null) goto L7;
        this.f528303a = r100;
        this.f528304b = new e(r100);
        return;
    L7:
        throw new NullPointerException("View must not be null!");
    }
}
