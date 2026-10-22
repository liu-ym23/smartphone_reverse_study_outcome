package com.bytedance.bdp.bdpbase.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
public final class ToastUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f201329a = null;

    static {
        f201329a = LazyKt.lazy(ToastUtils$uiHandler$2.INSTANCE);
    }

    public static void a(Context r100, String r101) {
        Ref.IntRef r102 = new Ref.IntRef();
        boolean r103 = true;
        r102.element = 1;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        r103 = false;
    L6:
        Context r104 = r100.getApplicationContext();
        if (r103 == true) goto L9;
        ((Handler) f201329a.getValue()).post(new n(r104, r101, r102));
        return;
    L9:
        Toast.makeText(r104, r101, r102.element).show();
    }
}
