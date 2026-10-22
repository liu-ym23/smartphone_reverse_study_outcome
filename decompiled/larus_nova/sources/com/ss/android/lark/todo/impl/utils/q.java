package com.ss.android.lark.todo.impl.utils;

import android.os.Vibrator;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;

/* JADX INFO: loaded from: classes38.dex */
public final class q {
    static {
    }

    public static void a() {
        Object r100 = TodoDependencyHolder.a().settingDependency().getContext().getSystemService("vibrator");     // Catch: Exception -> L9
        if ((r100 instanceof Vibrator) == false) goto L5;
        Vibrator r101 = (Vibrator) r100;     // Catch: Exception -> L9
    L6:
        if (r101 == null) goto L14;
        r101.vibrate(80);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L5:
        r101 = null;
    L9:
        e = move-exception;
        Log.e(e.getMessage());
    }
}
