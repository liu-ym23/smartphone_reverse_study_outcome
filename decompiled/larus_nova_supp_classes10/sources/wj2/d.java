package wj2;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final float[] a(View r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$centerLocationInScreen");
        int[] r1 = new int[2];
        r6.getLocationOnScreen(r1);
        return new float[]{r1[0] + (r6.getWidth() / 2.0f), r1[1] + (r6.getHeight() / 2.0f)};
    }
}
