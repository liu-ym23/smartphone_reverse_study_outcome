package v07;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Movie f552320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f552321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Canvas f552322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Bitmap f552323d;

    public e(Movie r100) {
        this.f552320a = r100;
        this.f552321b = new g(r100.width(), r100.height());
        this.f552322c = new Canvas();
    }
}
