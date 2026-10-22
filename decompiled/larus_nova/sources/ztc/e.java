package ztc;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes41.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f573655a = null;

    public e() {
    }

    static {
        f573655a = e.class.getSimpleName();
    }

    public static void delete(ViewGroup r100) {
        View r101 = r100.findViewWithTag(f573655a);
        if (r101 == null) goto L6;
        r100.removeView(r101);
        return;
    }
}
