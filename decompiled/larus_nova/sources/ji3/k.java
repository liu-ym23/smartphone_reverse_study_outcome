package ji3;

import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {
    public static final i a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPdpCountdownTimer");
        Object r101 = r100.getTag(R.id.pdp_count_down);
        if ((r101 instanceof i) == true) goto L5;
        r101 = null;
    L5:
        i r102 = (i) r101;
        if (r102 == null) goto L8;
        return r102;
    L8:
        Object r103 = r100.getParent();
        if ((r103 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        return a((View) r103);
    }
}
