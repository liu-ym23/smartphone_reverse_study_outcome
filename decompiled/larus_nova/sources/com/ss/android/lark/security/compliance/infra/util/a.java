package com.ss.android.lark.security.compliance.infra.util;

import android.content.pm.ApplicationInfo;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C5288a f440477a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.security.compliance.infra.util.a$a, reason: collision with other inner class name */
    public static final class C5288a {
        public C5288a() {
        }

        @JvmStatic
        public final synchronized String a(FragmentActivity r100) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L17
            ApplicationInfo r101 = r100.getPackageManager().getPackageInfo(r100.getPackageName(), 0).applicationInfo;     // Catch: Exception -> L13 Throwable -> L17
            if (r101 == null) goto L11;
            String r102 = r100.getResources().getString(r101.labelRes);     // Catch: Exception -> L13 Throwable -> L17
            monitor-exit(this);
            return r102;
        L11:
            monitor-exit(this);
            return null;
        L13:
            e = move-exception;
            int r103 = ScsLogger.f440428a;     // Catch: Throwable -> L17
            ScsLogger.c("AppUtils", "AppUtils exception:" + e.getMessage());     // Catch: Throwable -> L17
            return null;
        L17:
            th = move-exception;
            throw th;
        }
    }

    static {
        f440477a = new C5288a();
    }
}
