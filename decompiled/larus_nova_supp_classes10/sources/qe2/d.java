package qe2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final int a() {
        return k.n(IInteractService.class).getCurrentScene();
    }

    public static final void b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$removeSelf");
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L9;
        r1.removeView(r2);
        return;
    }
}
