package gk2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$detachSelfIfNeed");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        r102.removeView(r100);
    }
}
