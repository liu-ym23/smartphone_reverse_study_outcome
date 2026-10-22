package fjc;

import android.view.Window;

/* JADX INFO: loaded from: classes40.dex */
public final class e {
    public static boolean a(Window r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.getAttributes() == null) goto L8;
        if ((r100.getAttributes().flags & 1024) != 1024) goto L8;
        return true;
    }
}
