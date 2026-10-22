package se3;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import g33.b;
import kotlin.jvm.internal.Intrinsics;
import ld3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final float a = 0.0f;

    static {
        float r0 = b.b.getFontScale();
        a = r0;
        if (r0 <= 1.15f) goto L6;
        a = 1.15f;
        return;
    }

    public static float a(float r1) {
        if (c.h() == true) goto L5;
        return r1;
    L5:
        return Math.round(a * r1);
    }

    public static void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        if (c.h() == false) goto L9;
        int r0 = r3.getLayoutParams().height;
        if (r0 != 0) goto L7;
        return;
    L7:
        float r1 = r0;
        float r2 = Math.round(a * r1) / r1;
        r3.getLayoutParams().height = (int) (r3.getLayoutParams().height * r2);
        r3.getLayoutParams().width = (int) (r3.getLayoutParams().width * r2);
        return;
    }

    public static void c(TextView r1, int r2, float r3) {
        Intrinsics.checkNotNullParameter(r1, "textView");
        if (c.h() == true) goto L5;
        r1.setTextSize(r2, r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        r1.setTextSize(1, Math.round(r3 * a));
        return;
    L7:
        r1.setTextSize(r2, Math.round(r3 * a));
    }
}
