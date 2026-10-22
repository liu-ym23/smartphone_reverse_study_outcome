package hm4;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f485918c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f485919d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f485920e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f485921f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f485922g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f485923h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f485924i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f485925j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f485926k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f485927l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f485929b;

    public static final class a {
    }

    static {
        float r100 = 11;
        float r101 = 12;
        f485918c = new b(0, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem())))));
        f485919d = new b(320, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r100, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem())))));
        f485920e = new b(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem())))));
        float r102 = 16;
        f485921f = new b(480, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r102, a(Resources.getSystem())))));
        f485922g = new b(600, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r102, a(Resources.getSystem())))));
        float r103 = 24;
        f485923h = new b(704, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, a(Resources.getSystem())))));
        f485924i = new b(800, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, a(Resources.getSystem())))));
        f485925j = new b(960, new e(12, MathKt.roundToInt(TypedValue.applyDimension(1, r101, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r103, a(Resources.getSystem())))));
        float r104 = 32;
        f485926k = new b(1024, new e(20, MathKt.roundToInt(TypedValue.applyDimension(1, r102, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r104, a(Resources.getSystem())))));
        f485927l = new b(1366, new e(24, MathKt.roundToInt(TypedValue.applyDimension(1, r102, a(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r104, a(Resources.getSystem())))));
    }

    public final int hashCode() {
        return ((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f485928a) * 31) + this.f485929b.hashCode();
    }

    public final String toString() {
        return "BreakPointClass(dpSize=" + this.f485928a + ",baseGridConfig=" + this.f485929b + ')';
    }

    public b(int r100) {
        e r101 = e.f485938d;
        this(r100, e.f485938d);
    }

    public static DisplayMetrics a(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == false) goto L9;
        b r101 = (b) r100;
        if (r101.f485928a != this.f485928a) goto L9;
        if (Intrinsics.areEqual(r101.f485929b, this.f485929b) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public b(int r100, e r101) {
        Intrinsics.checkNotNullParameter(r101, "baseGridConfig");
        this.f485928a = r100;
        this.f485929b = r101;
    }
}
