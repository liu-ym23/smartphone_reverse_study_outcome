package com.obric.oui.sheet.v2;

/* JADX INFO: loaded from: classes34.dex */
public interface k {

    public static final class a {
        public static /* synthetic */ void a(k r100, float r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = 0.0f;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = false;
        L8:
            r100.n(0.0f, r101, r102);
        }
    }

    void n(float r100, float r101, boolean r102);

    void p(float r100);
}
