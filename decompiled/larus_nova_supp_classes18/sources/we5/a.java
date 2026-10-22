package we5;

import android.view.View;
import android.widget.LinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(LinearLayout r3, View r4, View r5) {
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "voiceContainer");
        Intrinsics.checkNotNullParameter(r5, "imageView");
        int r0 = r3.indexOfChild(r4);
        int r1 = r3.indexOfChild(r5);
        if (r0 == (-1)) goto L9;
        if (r1 == (-1)) goto L10;
        if (r0 > r1) goto L11;
        r3.removeView(r4);
        r3.addView(r4, r3.indexOfChild(r5) + 1);
        return;
    L11:
        return;
    L10:
        return;
    }
}
