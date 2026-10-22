package com.larus.platform.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes31.dex */
public interface d0 {

    public static final class a {
        public static /* synthetic */ void a(Context r100, String r101, by7.e r110, String r111, String r112, String r113, int r114) {
            com.larus.platform.service.u r102 = com.larus.platform.service.u.f365809a;
            if ((r114 & 8) == 0) goto L5;
            String r103 = null;
        L7:
            if ((r114 & 16) == 0) goto L9;
            String r104 = null;
        L11:
            if ((r114 & 32) == 0) goto L13;
            String r105 = null;
        L14:
            r102.b(r100, r101, r110, r103, r104, r105, null);
            return;
        L13:
            r105 = r113;
            goto L14
        L9:
            r104 = r112;
            goto L11
        L5:
            r103 = r111;
            goto L7
        }
    }

    void b(Context r100, String r101, by7.e r102, String r103, String r104, String r105, String r106);

    void c(Fragment r100, View r101, String r102, by7.e r103);

    void d();
}
