package hy6;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes21.dex */
public interface e {

    public static final class a {
        public static /* synthetic */ void a(e r100, int r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(-1, -1);
        L9:
            r100.n(r101, r103);
            return;
        L8:
            r103 = null;
            goto L9
        }
    }

    void n(int r100, ViewGroup.LayoutParams r101);
}
