package nv3;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Uri r2, String r3) {
        if (r2 == null) goto L4;
        String r0 = r2.getScheme();
    L6:
        if (Intrinsics.areEqual(r0, "doubao") == true) goto L8;
    L12:
        return false;
    L8:
        if (Intrinsics.areEqual(r2.getHost(), "flow") == false) goto L12;
        if (Intrinsics.areEqual(r2.getPath(), r3) == false) goto L12;
        return true;
    L4:
        r0 = null;
        goto L6
    }
}
