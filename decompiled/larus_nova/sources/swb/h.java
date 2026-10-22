package swb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h {
    public static final Activity a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        if ((r100 instanceof Activity) == true) goto L8;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L8:
        return (Activity) r100;
    L10:
        return null;
    }
}
