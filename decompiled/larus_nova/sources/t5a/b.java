package t5a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes32.dex */
public final class b {
    public static Activity getActivity(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L9;
        if ((r100 instanceof Activity) == true) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L9:
        return null;
    }
}
