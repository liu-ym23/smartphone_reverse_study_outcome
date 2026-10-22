package com.ss.android.lark.conditional.access.utils;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f418483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ScheduledExecutorService f418484b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f418485c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f418486d = false;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f418487a;

        public a(String r100) {
            this.f418487a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.f418483a.add(Calendar.getInstance().getTime() + ": " + this.f418487a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c() {
    }

    static {
        f418483a = new ArrayList();
        f418484b = CoreThreadPool.getDefault().getSingleScheduledThreadPool("FilePolicyLog");
        f418485c = DevEnvUtil.isDebugMode(LarkContext.getApplication());
        f418486d = DevEnvUtil.isDevelopPackage(LarkContext.getApplication());
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (f418485c == false) goto L5;
    L6:
        f418484b.execute(new a(r100));
        return;
    L5:
        if (f418486d == true) goto L6;
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter("PolicyEngine.checkPointcutIsControlledByFactors return result, but validateUid != mUserId", "msg");
        ScsLogger.e(r100, "PolicyEngine.checkPointcutIsControlledByFactors return result, but validateUid != mUserId");
    }

    public static void a(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ScsLogger.a(r100, r101);
        if (r102 == false) goto L6;
        c(r101);
        return;
    }

    public static void b(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ScsLogger.d(r100, r101);
        if (r102 == false) goto L6;
        c(r101);
        return;
    }
}
