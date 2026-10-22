package com.larus.platform.api;

import android.content.Context;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public interface u2 {

    public static final class a {
        public static /* synthetic */ e4 a(Context r100, String r101, String r102, int r103) {
            com.larus.platform.service.c1 r104 = com.larus.platform.service.c1.f365723a;
            if ((r103 & 4) == 0) goto L6;
            r102 = null;
        L6:
            return r104.g(r100, r101, r102, null);
        }
    }

    List<Object> a();

    String b(String r100, String r101, boolean r102);

    View c(Context r100, String r101, com.larus.bmhome.chat.layout.widget.handler.h r102);

    boolean d();

    void e(String r100, String r101, com.larus.bmhome.chat.layout.item.u4 r102);

    void f();

    e4 g(Context r100, String r101, String r102, f4 r103);
}
