package com.chad.library.adapter.base.util;

/* JADX INFO: loaded from: classes22.dex */
public class TouchEventUtil {
    public TouchEventUtil() {
    }

    public static String getTouchAction(int r100) {
        String r101 = "Unknow:id=" + r100;
        if (r100 != 0) goto L5;
        return "ACTION_DOWN";
    L5:
        if (r100 != 1) goto L7;
        return "ACTION_UP";
    L7:
        if (r100 != 2) goto L9;
        return "ACTION_MOVE";
    L9:
        if (r100 != 3) goto L11;
        return "ACTION_CANCEL";
    L11:
        if (r100 != 4) goto L23;
        return "ACTION_OUTSIDE";
    L23:
        return r101;
    }
}
