package tj7;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.view.View;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f546426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f546427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f546428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f546429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Xfermode f546430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f546431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f546432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f546433h;

    public a() {
        this.f546432g = -1.0f;
    }

    public final void a(float r110, String r111) {
        this.f546432g = r110;
        r111.getClass();
        if (r111.equals("bottom") == false) goto L5;
        float[] r112 = this.f546431f;
        r112[1] = r110;
        r112[0] = r110;
        r112[3] = r110;
        r112[2] = r110;
        r112[5] = 0.0f;
        r112[4] = 0.0f;
        r112[7] = 0.0f;
        r112[6] = 0.0f;
    L9:
        View r113 = this.f546433h;
        if (r113 == null) goto L13;
        r113.invalidate();
        return;
    L13:
        return;
    L5:
        if (r111.equals("right") == true) goto L7;
        Arrays.fill(this.f546431f, r110);
        goto L9
    L7:
        float[] r114 = this.f546431f;
        r114[1] = r110;
        r114[0] = r110;
        r114[3] = 0.0f;
        r114[2] = 0.0f;
        r114[5] = 0.0f;
        r114[4] = 0.0f;
        r114[7] = r110;
        r114[6] = r110;
        goto L9
    }
}
