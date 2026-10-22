package com.bytedance.locallife.biz.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class ToastUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f256981a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f256982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f256983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f256984c;

        public a(Context r100, String r101, int r102) {
            this.f256982a = r100;
            this.f256983b = r101;
            this.f256984c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Toast.makeText(this.f256982a, this.f256983b, this.f256984c).show();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ToastUtils() {
    }

    static {
        f256981a = LazyKt.lazy(ToastUtils$uiHandler$2.INSTANCE);
    }

    public static void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("不支持当前页面跳转，请前往抖音查看", "string");
        a(r100, "不支持当前页面跳转，请前往抖音查看", 0);
    }

    public static void a(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "string");
        boolean r103 = false;
        if (r102 != 1) goto L5;
        int r104 = 1;
    L7:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        r103 = true;
    L9:
        Context r105 = r100.getApplicationContext();
        if (r103 == true) goto L12;
        ((Handler) f256981a.getValue()).post(new a(r105, r101, r104));
        return;
    L12:
        Toast.makeText(r105, r101, r104).show();
        return;
    L5:
        r104 = 0;
        goto L7
    }
}
