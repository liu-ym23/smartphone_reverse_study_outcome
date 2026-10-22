package xx8;

import androidx.camera.video.AudioStats;
import com.larus.camera.impl.utils.capture.CameraZoomRatioType;
import com.larus.camera.impl.utils.k;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f565340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f565341b;

    public static final class a {
    }

    static {
    }

    @Override // xx8.c
    public final float f(float r100) {
        return r100;
    }

    public b() {
        this.f565340a = true;
        this.f565341b = 1.0f;
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
        return this.f565340a;
    }

    @Override // xx8.c
    public final Pair<Float, Boolean> a(float r100) {
        Lazy r101 = k.f322785a;
        boolean r102 = true;
        if (((oq9.d) r101.getValue()).a() != CameraZoomRatioType.SINGLE_ZOOM_RATIO.getType()) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        this.f565340a = false;
        float r104 = r100;
    L16:
        this.f565341b = r104;
        FLogger.f375446a.i("Camera2ZoomManager", "checkMaxZoomSupport srcMaxZoomValue=" + r100 + " resMaxZoomValue=" + r104 + " settings:" + r103);
        return new Pair(Float.valueOf(r104), Boolean.valueOf(this.f565340a));
    L11:
        if (r100 >= 3.0f) goto L14;
        r102 = false;
    L14:
        this.f565340a = r102;
        r104 = (float) Math.floor(r100);
        goto L16
    L5:
        if (((oq9.d) r101.getValue()).a() == CameraZoomRatioType.MULTI_ZOOM_RATIO.getType()) goto L8;
        r103 = false;
        goto L9
    }

    @Override // xx8.c
    public final float c(float r100) {
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        Float r102 = StringsKt.toFloatOrNull(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r100)}, 1)));
        FLogger.f375446a.i("Camera2ZoomManager", "calculateZoomRatio zoomValue: " + r100 + ", after:" + r102);
        if (r102 != null) goto L5;
        return r100;
    L5:
        return r102.floatValue();
    }

    @Override // xx8.c
    public final double e(float r110, double r111) {
        FLogger.f375446a.i("Camera2ZoomManager", "adjustMoveTotalLength ratio:" + r110 + ", max:" + r111);
        if (r110 > 1.0f) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return RangesKt.coerceIn((((double) r110) - 1.0d) / (((double) this.f565341b) - 1.0d), AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d) * r111;
    }
}
