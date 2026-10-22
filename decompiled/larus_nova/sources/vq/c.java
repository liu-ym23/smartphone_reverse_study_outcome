package vq;

import android.graphics.Point;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556751a = 0;

    static {
    }

    public static Point a(int r100, int r101, int r102, Point r110) {
        int r103 = r110.x;
        int r111 = r110.y;
        int r104 = r101 * r101;
        int r105 = r100 * r100;
        double r106 = r104 + r105;
        return new Point(MathKt.roundToInt((((r104 * r103) - ((r100 * r101) * r111)) - (r100 * r102)) / r106), MathKt.roundToInt(((double) (((((-r100) * r101) * r103) + (r105 * r111)) - (r101 * r102))) / r106));
    }
}
