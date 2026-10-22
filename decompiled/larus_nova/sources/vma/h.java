package vma;

import android.graphics.Color;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f556353a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(float r100) {
        if (r100 < 1.2f) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final int a(int r100, float r101) {
        if (r101 != 1.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return r100;
    L8:
        float r103 = RangesKt.coerceIn(r101, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r100) * r103), Color.red(r100), Color.green(r100), Color.blue(r100));
    L5:
        r102 = false;
        goto L6
    }
}
