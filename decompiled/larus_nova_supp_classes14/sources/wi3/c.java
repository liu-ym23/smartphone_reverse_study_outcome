package wi3;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final int a(int r1, Context r2) {
        if (r2 == null) goto L8;
        Context r3 = th.a.e(r2, true);
        if (r3 == null) goto L8;
        Resources r4 = r3.getResources();
        if (r4 == null) goto L8;
        return r4.getDimensionPixelOffset(r1);
    L8:
        return 0;
    }
}
