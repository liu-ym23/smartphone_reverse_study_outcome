package ji3;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k {
    public static final i a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getPdpCountdownTimer");
        Object r0 = r3.getTag(2131382092);
        if ((r0 instanceof i) == true) goto L5;
        r0 = null;
    L5:
        i r1 = (i) r0;
        if (r1 == null) goto L8;
        return r1;
    L8:
        Object r4 = r3.getParent();
        if ((r4 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        return a((View) r4);
    }
}
