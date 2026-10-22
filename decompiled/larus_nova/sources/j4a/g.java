package j4a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f497386a = null;

    static {
        f497386a = new g();
    }

    public g() {
    }

    public final Activity getActivity(WeakReference<Context> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Context r101 = r100.get();
    L6:
        if (r101 == null) goto L14;
        if ((r101 instanceof Activity) == true) goto L10;
        if ((r101 instanceof ContextWrapper) == false) goto L14;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L6
    L10:
        return (Activity) r101;
    L14:
        return null;
    }

    public final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L11;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L11:
        return null;
    }
}
