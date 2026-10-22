package com.bytedance.ee.bear.fileselector;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f226794a = null;

    static {
        f226794a = new g();
    }

    public g() {
    }

    public static FragmentActivity a(Context r100) {
        if ((r100 instanceof FragmentActivity) == false) goto L6;
        return (FragmentActivity) r100;
    L6:
        if ((r100 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return a(((ContextWrapper) r100).getBaseContext());
    }

    public static void b(FileSelectConfig r100) {
        za5.a r101 = r100.fileSelectListener;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        bb5.h r102 = r100.onDismissListener;
        if (r102 == null) goto L9;
        r102.onDismiss();
        return;
    }
}
