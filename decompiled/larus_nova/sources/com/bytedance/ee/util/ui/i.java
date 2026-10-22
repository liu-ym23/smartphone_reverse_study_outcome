package com.bytedance.ee.util.ui;

import androidx.fragment.app.FragmentManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes19.dex */
public final class i {
    public static void a(FragmentManager r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isStateSaved() == false) goto L14;
        tt5.a.k("FragmentUtils", "popBackStack(), state save is true");
        Method r101 = r100.getClass().getSuperclass().getDeclaredMethod("noteStateNotSaved", new Class[0]);     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        r101.invoke(r100, new Object[0]);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        tt5.a.d("FragmentUtils", "noteStattSave(),error:" + e);
        iu5.d.a("FragmentUtils", e);
        return;
    }
}
