package gk2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$detachSelfIfNeed");
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        r1.removeView(r2);
    }
}
