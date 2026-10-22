package com.bytedance.ies.xbridge.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f249557a = null;

    static {
        f249557a = new f();
    }

    public f() {
    }

    public final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L12;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L11:
        r100.toString();
        goto L12
    L7:
        return (Activity) r100;
    L12:
        return null;
    }
}
