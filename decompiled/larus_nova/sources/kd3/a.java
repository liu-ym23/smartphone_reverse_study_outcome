package kd3;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final boolean a(View r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.getVisibility() != 0) goto L6;
        return true;
    }
}
