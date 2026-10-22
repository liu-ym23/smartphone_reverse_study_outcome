package com.larus.audio;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface s0 {

    /* JADX INFO: loaded from: classes24.dex */
    public static final class a {
        public static /* synthetic */ void a(s0 r100, String r110, String r111, String r112, p68.e r113, String r114, String r115, int r116) {
            if ((r116 & 8) == 0) goto L5;
            p68.e r101 = null;
        L7:
            if ((r116 & 16) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r116 & 32) == 0) goto L13;
            String r103 = null;
        L14:
            r100.l(r110, r111, r112, r101, r102, r103);
            return;
        L13:
            r103 = r115;
            goto L14
        L9:
            r102 = r114;
            goto L11
        L5:
            r101 = r113;
            goto L7
        }
    }

    void h();

    void i();

    void j(ArrayList<p68.b> r100);

    void k(String r100, String r101, String r102, float r103, float r104, String r105, p68.e r106);

    void l(String r100, String r101, String r102, p68.e r103, String r104, String r105);

    void stopAudio();
}
