package p95;

import android.graphics.Bitmap;
import android.widget.ImageView;
import q95.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements c<ImageView, Bitmap> {
    public final ImageView a;
    public final e b;

    public a(ImageView r2) {
        if (r2 == null) goto L7;
        this.a = r2;
        this.b = new e(r2);
        return;
    L7:
        throw new NullPointerException("View must not be null!");
    }
}
