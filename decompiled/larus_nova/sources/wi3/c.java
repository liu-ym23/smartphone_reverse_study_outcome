package wi3;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes14.dex */
public final class c {
    public static final int a(int r100, Context r101) {
        if (r101 == null) goto L8;
        Context r102 = th.a.e(r101, true);
        if (r102 == null) goto L8;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L8;
        return r103.getDimensionPixelOffset(r100);
    L8:
        return 0;
    }
}
