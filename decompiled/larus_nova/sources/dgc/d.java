package dgc;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f468557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f468558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f468559c;

    public d(Path r100, float r101, float r102) {
        this.f468559c = r100;
        RectF r103 = new RectF();
        r100.computeBounds(r103, true);
        if (r101 <= 0.0f) goto L5;
    L7:
        this.f468557a = r101;
        this.f468558b = r102;
        return;
    L5:
        if (r102 > 0.0f) goto L7;
        r101 = (float) Math.ceil(r103.width());
        r102 = (float) Math.ceil(r103.height());
        r100.offset(((float) Math.floor(r103.left)) * (-1.0f), Math.round(r103.top) * (-1.0f));
        goto L7
    }
}
