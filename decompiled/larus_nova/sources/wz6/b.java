package wz6;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static Activity getActivity(Context r100) {
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L7:
        if ((r100 instanceof ContextWrapper) == false) goto L12;
        r100 = ((ContextWrapper) r100).getBaseContext();
        if ((r100 instanceof Activity) == false) goto L7;
        return (Activity) r100;
    L12:
        return null;
    }

    public static Activity getActivity(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return getActivity(r100.getContext());
    }
}
