package oqb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final Activity a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof Activity) == false) goto L6;
        return (Activity) r100;
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        Context r101 = ((ContextWrapper) r100).getBaseContext();
        if (r101 == null) goto L11;
        return a(r101);
    L11:
        return null;
    }
}
