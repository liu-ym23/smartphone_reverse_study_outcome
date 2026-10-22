package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TooltipCompat {
    private TooltipCompat() {
    }

    public static void setTooltipText(View r2, CharSequence r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r2.setTooltipText(r3);
        return;
    L5:
        TooltipCompatHandler.setTooltipText(r2, r3);
    }
}
