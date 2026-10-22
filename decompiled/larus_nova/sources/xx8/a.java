package xx8;

import androidx.camera.video.AudioStats;
import com.larus.utils.logger.FLogger;
import kotlin.Pair;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f565338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f565339b;

    /* JADX INFO: renamed from: xx8.a$a, reason: collision with other inner class name */
    public static final class C8287a {
    }

    static {
    }

    public a() {
        this.f565338a = 10.0f;
        this.f565339b = true;
    }

    @Override // xx8.c
    public final boolean b() {
        return c.a.a(this);
    }

    @Override // xx8.c
    public final boolean d() {
        return c.a.c(this);
    }

    @Override // xx8.c
    public final boolean h() {
        return c.a.b(this);
    }

    @Override // xx8.c
    public final boolean g() {
        return this.f565339b;
    }

    @Override // xx8.c
    public final Pair<Float, Boolean> a(float r100) {
        if (c.a.a(this) == false) goto L11;
        float r101 = 41.0f;
        if (r100 < 41.0f) goto L7;
        this.f565339b = true;
        this.f565338a = 10.0f;
    L12:
        FLogger.f375446a.i("CameraZoomManager", "checkMaxZoomSupport srcMaxZoomValue=" + r100 + " resMaxZoomValue=" + r101 + " zoomRatioOffset=" + this.f565338a);
        return new Pair(Float.valueOf(r101), Boolean.valueOf(this.f565339b));
    L7:
        r101 = 21.0f;
        if (r100 < 21.0f) goto L10;
        this.f565339b = true;
        this.f565338a = 10.0f;
        goto L12
    L10:
        this.f565339b = false;
        this.f565338a = (r100 - 1.0f) / 4.0f;
    L11:
        r101 = r100;
        goto L12
    }

    @Override // xx8.c
    public final float c(float r100) {
        if (r100 != 1.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return 1.0f;
    L9:
        return ((r100 - 1.0f) / this.f565338a) + 1.0f;
    L5:
        r101 = false;
        goto L6
    }

    @Override // xx8.c
    public final float f(float r100) {
        if (r100 != 1.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return 1.0f;
    L9:
        return ((r100 - 1.0f) * this.f565338a) + 1.0f;
    L5:
        r101 = false;
        goto L6
    }

    @Override // xx8.c
    public final double e(float r100, double r101) {
        if (r100 != 1.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L10:
        return ((double) f(r100)) * (r101 / ((double) (this.f565338a * 4.0f)));
    L5:
        r102 = false;
        goto L6
    }
}
