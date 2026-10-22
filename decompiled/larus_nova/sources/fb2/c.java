package fb2;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static float f476253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static float f476254b;

    public static float a(float r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        if (f476254b != 0.0f) goto L6;
        f476254b = (int) ((23.0f * s1.u()) + 0.5f);
    L6:
        float r102 = f476254b;
        if (f476253a != 0.0f) goto L10;
        f476253a = (int) ((16.0f * s1.u()) + 0.5f);
    L10:
        return r102 + (r100 - f476253a);
    }

    public static float b(float r100, Drawable r101, boolean r102) {
        return (r101.getIntrinsicWidth() / (r101.getIntrinsicHeight() + 0.0f)) * a(r100, r102);
    }
}
