package x4a;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class f {
    public static void a(g r100, MotionEvent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getAction() != 0) goto L8;
        r100.getPlayer().h(r101.getX(), r101.getY());
        return;
    }
}
