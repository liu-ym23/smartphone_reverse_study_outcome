package lja;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f509521b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f509522a;

    public static final class a {
        public static void a(Path r100, e r110, float r111, float r112, float r113) {
            Intrinsics.checkNotNullParameter(r100, "$this$arcTo");
            Intrinsics.checkNotNullParameter(r110, "arcCenter");
            float r101 = r110.f509523a;
            float r114 = r110.f509524b;
            r100.arcTo(r101 - r111, r114 - r111, r101 + r111, r114 + r111, r112, r113 - r112, false);
        }
    }

    static {
    }

    public abstract Path a(float r100, float r101, float r102, float r103, float r104);

    public boolean c(float r100, float r101) {
        return true;
    }

    public abstract String getType();

    public d() {
        this.f509522a = new RectF();
    }

    public static Path b(float r100, float r110, float r111, float r112, float r113) {
        Path r101 = new Path();
        r101.addRoundRect(r100, r110, r111, r112, r113, r113, Path.Direction.CW);
        r101.close();
        return r101;
    }

    public void d(Canvas r100, Paint r101, float r102, float r110, float r111, float r112, float r113) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "paint");
        r100.drawPath(a(r102, r110, r111, r112, r113), r101);
    }
}
