package cy9;

import android.R;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f465951a = 0;

    static {
    }

    public static int a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        View r102 = r100.getRootView().findViewById(R.id.content);
        if (r102 == null) goto L5;
        int r103 = r102.getPaddingBottom();
    L7:
        return RangesKt.coerceAtLeast(r101 - r103, 0);
    L5:
        r103 = 0;
        goto L7
    }
}
