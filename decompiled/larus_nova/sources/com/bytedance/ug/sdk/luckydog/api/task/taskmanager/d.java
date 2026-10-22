package com.bytedance.ug.sdk.luckydog.api.task.taskmanager;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static final String a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder("func: ");
        r102.append(r100);
        r102.append(", exception caught: ");
        if (r101 != null) goto L6;
        r101 = "nil";
    L6:
        r102.append(r101);
        return r102.toString();
    }

    public static final void b(boolean r100, Function1 r101) {
        if (r100 == true) goto L5;
        r101.invoke(Boolean.valueOf(r100));
        return;
    }

    public static final void c(boolean r100, Function1 r101) {
        if (r100 == false) goto L5;
        r101.invoke(Boolean.valueOf(r100));
        return;
    }
}
