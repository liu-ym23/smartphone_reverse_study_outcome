package com.gyf.barlibrary;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public class ImmersionBarAutoFixMemoryLeak {
    private static String TAG = "ImmersionBarAutoFixMemoryLeak";

    public ImmersionBarAutoFixMemoryLeak() {
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static void init(Context r100, Boolean r101) {
        if ((r100 instanceof Application) == true) goto L5;
        return;
    L5:
        if (r101.booleanValue() == false) goto L9;
        ((Application) r100).registerActivityLifecycleCallbacks(new AnonymousClass1());
        return;
    }
}
