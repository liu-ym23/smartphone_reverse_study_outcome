package com.bytedance.android.window.shop.home.tab;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final CopyOnWriteArrayList<WindowTabFragmentBase> a = null;

    static {
        a = new CopyOnWriteArrayList();
    }

    public static WindowTabFragmentBase a(String r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, "categoryId");
        Intrinsics.checkNotNullParameter(r8, "categoryName");
        CopyOnWriteArrayList<WindowTabFragmentBase> r2 = a;
        if ((!r2.isEmpty()) == false) goto L6;
        dm.a.a("window_first_frame_opt").i("window_tab_fragment_pre_create");
        WindowTabFragmentBase r10 = r2.remove(0);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, "categoryId");
        Intrinsics.checkNotNullParameter(r8, "categoryName");
        r10.f.b(r10, new g(r7, r8));
        return r10;
    L6:
        int r0 = WindowTabFragmentBase.g;
        return WindowTabFragmentBase.a.a(r7, r8, r9, false, 100);
    }
}
