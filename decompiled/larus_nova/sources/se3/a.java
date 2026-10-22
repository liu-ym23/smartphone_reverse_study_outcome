package se3;

import android.view.View;
import android.widget.TextView;
import g33.b;
import kotlin.jvm.internal.Intrinsics;
import ld3.c;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f541559a = 0.0f;

    static {
        float r100 = b.f479797b.getFontScale();
        f541559a = r100;
        if (r100 <= 1.15f) goto L6;
        f541559a = 1.15f;
        return;
    }

    public static float a(float r100) {
        if (c.h() == true) goto L5;
        return r100;
    L5:
        return Math.round(f541559a * r100);
    }

    public static void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (c.h() == false) goto L9;
        int r101 = r100.getLayoutParams().height;
        if (r101 != 0) goto L7;
        return;
    L7:
        float r102 = r101;
        float r103 = Math.round(f541559a * r102) / r102;
        r100.getLayoutParams().height = (int) (r100.getLayoutParams().height * r103);
        r100.getLayoutParams().width = (int) (r100.getLayoutParams().width * r103);
        return;
    }

    public static void c(TextView r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (c.h() == true) goto L5;
        r100.setTextSize(r101, r102);
        return;
    L5:
        if (r101 != 2) goto L7;
        r100.setTextSize(1, Math.round(r102 * f541559a));
        return;
    L7:
        r100.setTextSize(r101, Math.round(r102 * f541559a));
    }
}
