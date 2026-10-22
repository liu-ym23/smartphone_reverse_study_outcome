package com.ss.android.lark.image.utils;

import android.content.Context;
import com.bumptech.glide.load.engine.GlideException;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f426448a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f426449a;

        public a(Context r100) {
            this.f426449a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.f426449a, R.string.Lark_Legacy_NetworkFailed);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @JvmStatic
    public static final boolean a(Context r100, ErrorResult r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L5;
        int r102 = r101.getErrorCode();
    L7:
        if (NetworkUtils.d(r100) == false) goto L9;
    L14:
        return true;
    L9:
        if (f426448a == true) goto L12;
        f426448a = true;
        UICallbackExecutor.execute(new a(r100));
    L12:
        if (GlideException.isGlideException(r102) == false) goto L14;
        Log.e("ImageCommonUtils", "load image failed:" + r101 + ", but net is not available");
        return false;
    L5:
        r102 = 0;
        goto L7
    }
}
