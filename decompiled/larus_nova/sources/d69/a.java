package d69;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setAlpha(0.0f);
        e1.x(r100);
        r100.animate().alpha(1.0f).setDuration(150).setInterpolator(new DecelerateInterpolator()).start();
    }

    public static final void b(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        a(r100);
        return;
    L5:
        e1.x(r100);
    }
}
