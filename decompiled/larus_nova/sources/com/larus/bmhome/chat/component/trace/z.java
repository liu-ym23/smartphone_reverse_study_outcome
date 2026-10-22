package com.larus.bmhome.chat.component.trace;

import android.view.View;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface z extends t1a.a {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void a(z r110, String r111, String r112, String r113, String r114, boolean r115, boolean r116, int r117) {
            if ((r117 & 2) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r117 & 8) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r117 & 16) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r117 & 32) == 0) goto L17;
            boolean r103 = false;
        L19:
            if ((r117 & 64) == 0) goto L21;
            boolean r104 = false;
        L22:
            r110.yX(r111, r100, null, r101, r102, r103, r104);
            return;
        L21:
            r104 = r116;
            goto L22
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    void DF(String r100, String r101);

    void Ky();

    String L1();

    long O();

    Set<String> OM();

    Set<String> RY();

    boolean W();

    long fK();

    String getChatType();

    long getChatUniqueKey();

    String k();

    void mo();

    void qH();

    void rp(View r100);

    void yX(String r100, String r101, String r102, String r103, String r104, boolean r105, boolean r106);
}
