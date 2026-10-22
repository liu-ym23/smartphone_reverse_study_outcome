package com.lynx.clay.util;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    public static final class a {
        private a() {
        }

        public static boolean a(View r100) {
            return r100.isAttachedToWindow();
        }
    }

    public interface b {
        boolean a(View r100);
    }

    public static boolean a(View r100) {
        return a.a(r100);
    }

    public static boolean b(View r100, b r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r101.a(r100) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof ViewGroup) == false) goto L17;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = 0;
    L12:
        if (r103 >= r102.getChildCount()) goto L17;
        if (b(r102.getChildAt(r103), r101) == true) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }
}
