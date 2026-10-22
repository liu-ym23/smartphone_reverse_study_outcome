package com.bytedance.ee.bear.fileselector;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public static FragmentActivity a(Context r1) {
        if ((r1 instanceof FragmentActivity) == false) goto L6;
        return (FragmentActivity) r1;
    L6:
        if ((r1 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return a(((ContextWrapper) r1).getBaseContext());
    }

    public static void b(FileSelectConfig r1) {
        za5.a r0 = r1.fileSelectListener;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        bb5.h r2 = r1.onDismissListener;
        if (r2 == null) goto L9;
        r2.onDismiss();
        return;
    }
}
