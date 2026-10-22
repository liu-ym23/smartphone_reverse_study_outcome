package n82;

import android.graphics.drawable.GradientDrawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f518246a = 0;

    static {
    }

    public static void b(GradientDrawable r100, float r101) {
        r100.setCornerRadii(new float[]{0.0f, 0.0f, r101, r101, 0.0f, 0.0f, 0.0f, 0.0f});
    }

    public static GradientDrawable a(int r100, int r101, GradientDrawable.Orientation r102) {
        Intrinsics.checkNotNullParameter(r102, "orientation");
        int[] r103 = {r100, r101};
        GradientDrawable r104 = new GradientDrawable();
        r104.setColors(r103);
        r104.setOrientation(r102);
        return r104;
    }
}
