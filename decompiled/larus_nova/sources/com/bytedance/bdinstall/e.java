package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static void a(Context r100, o0 r101, StringBuilder r102) {
        if (r101.f199748u == true) goto L15;
        d.b(r102, "build_serial", i84.q.c(r100, r101));
        if (r101.D == false) goto L15;
        String[] r103 = i84.q.d(r100, r101);
        if (r103 == null) goto L15;
        if (r103.length <= 0) goto L15;
        String r104 = r103[0];
        int r105 = 1;
    L12:
        if (r105 >= r103.length) goto L14;
        r104 = r104 + "," + r103[r105];
        r105 = r105 + 1;
        goto L12
    L14:
        d.b(r102, "sim_serial_number", r104);
    L15:
        e84.k.e(r100).c();
    }
}
