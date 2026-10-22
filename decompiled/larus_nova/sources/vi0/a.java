package vi0;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends com.bytedance.android.live.liveinteract.videotalk.utils.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f555003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f555004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f555005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f555006e;

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path b(int r100, int r101, int r102) {
        return c(r100, 0.0f, 0.0f);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.utils.c
    public final Path c(int r100, float r101, float r102) {
        float r103 = this.f555005d + (r100 * this.f555003b);
        float r104 = this.f555006e;
        RectF r105 = new RectF(r103, r104, this.f555003b + r103, this.f555004c + r104);
        if (r100 != 0) goto L5;
        float[] r106 = {20.0f, 20.0f, 0.0f, 0.0f, 0.0f, 0.0f, 20.0f, 20.0f};
    L6:
        Path r107 = new Path();
        r107.addRoundRect(r105, r106, Path.Direction.CW);
        return r107;
    L5:
        r106 = new float[]{0.0f, 0.0f, 20.0f, 20.0f, 20.0f, 20.0f, 0.0f, 0.0f};
        goto L6
    }

    public a(float r100, float r101, float r102, float r103) {
        this.f555005d = r100;
        this.f555006e = r101;
        this.f555003b = r102 / 2.0f;
        this.f555004c = r103 / 1.0f;
    }
}
