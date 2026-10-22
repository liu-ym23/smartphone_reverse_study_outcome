package com.larus.platform.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes31.dex */
public interface b3 {

    public static final class a {
        public static /* synthetic */ void a(View r100, int r101, String r102, String r103, String r110, int r111) {
            com.larus.platform.service.z1 r104 = com.larus.platform.service.z1.f365863a;
            if ((r111 & 4) == 0) goto L5;
            String r105 = null;
        L7:
            if ((r111 & 8) == 0) goto L9;
            String r106 = null;
        L11:
            if ((r111 & 16) == 0) goto L13;
            String r107 = null;
        L14:
            r104.g(r100, r101, r105, r106, r107);
            return;
        L13:
            r107 = r110;
            goto L14
        L9:
            r106 = r103;
            goto L11
        L5:
            r105 = r102;
            goto L7
        }

        public static /* synthetic */ void b(Fragment r110, String r111, String r112, String r113, String r114, String r115, boolean r116, String r117, int r118) {
            com.larus.platform.service.z1 r100 = com.larus.platform.service.z1.f365863a;
            if ((r118 & 4) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r118 & 8) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r118 & 16) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r118 & 32) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r118 & 64) == 0) goto L21;
            boolean r105 = false;
        L23:
            if ((r118 & 128) == 0) goto L25;
            String r106 = null;
        L26:
            r100.h(r110, r111, r101, r102, r103, r104, r105, r106);
            return;
        L25:
            r106 = r117;
            goto L26
        L21:
            r105 = r116;
            goto L23
        L17:
            r104 = r115;
            goto L19
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }

    boolean a(Bundle r100, Bundle r101, int r102);

    void b(Fragment r100, String r101);

    void c(Activity r100);

    boolean d();

    boolean e(Fragment r100, boolean r101);

    boolean f(Context r100, Bundle r101);

    void g(View r100, int r101, String r102, String r103, String r104);

    void h(Fragment r100, String r101, String r102, String r103, String r104, String r105, boolean r106, String r107);
}
