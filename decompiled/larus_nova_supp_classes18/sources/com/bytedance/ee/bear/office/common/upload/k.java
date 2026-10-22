package com.bytedance.ee.bear.office.common.upload;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public static final k a = null;
    public static final ExecutorService b = null;
    public static final Handler c = null;
    public static String d;
    public static long e;
    public static final a f = null;

    public static final class a {
        public a() {
        }

        public final String a() {
            Application r0 = eu5.b.a;
            return xo5.a.c(r0, 2131887242, "operation_failed", r0.getString(2131887243));
        }

        public final String b() {
            k.a.getClass();
            Application r0 = eu5.b.a;
            int r1 = r0.getResources().getIdentifier("larus_drive_tooltip_uploadNA_fullStorage", "string", r0.getPackageName());
            if (r1 == 0) goto L5;
            String r2 = r0.getString(r1);
            Intrinsics.checkNotNull(r2);
            return r2;
        L5:
            String r3 = r0.getString(2131889455);
            Intrinsics.checkNotNull(r3);
            return r3;
        }

        public final String c() {
            return eu5.b.a.getString(2131889455);
        }

        public final String d() {
            return eu5.b.a.getString(2131892996);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long r0 = System.currentTimeMillis();     // Catch: Throwable -> L9
            if (Intrinsics.areEqual(this.a, k.d) == true) goto L5;
        L7:
            String r2 = this.a;     // Catch: Throwable -> L9
            k.d = r2;     // Catch: Throwable -> L9
            k.e = r0;     // Catch: Throwable -> L9
            Toast.showFailureText(eu5.b.a, r2);     // Catch: Throwable -> L9
            return;
        L5:
            if ((r0 - k.e) >= 1000) goto L7;
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements ThreadFactory {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            return new PthreadThreadV2(r3, "office-upload-executor");
        }
    }

    public k() {
    }

    static {
        a = new k();
        b = PThreadExecutorsUtils.newSingleThreadExecutor(c.a);
        c = new Handler(Looper.getMainLooper());
        f = new a();
    }

    public static com.bytedance.ee.bear.drive.sdk.service.g a() {
        return ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
    }

    public static void b(String r2) {
        c.post(new b(r2));
    }

    public static String c(g0 r2) {
        if (Intrinsics.areEqual(r2, g0.b.a) == false) goto L6;
        return "root_mine";
    L6:
        if ((r2 instanceof g0.a) == false) goto L10;
        return "folder_hash=" + ((g0.a) r2).a.hashCode();
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static String d(int r2, String r3) {
        int r0 = j.a;
        a r1 = f;
        Intrinsics.checkNotNullParameter(r1, "stringProvider");
        switch(r2) {
            case 11001: goto L9;
            case 13001: goto L9;
            case 90001043: goto L13;
            case 90001061: goto L12;
            case 90003043: goto L13;
            case 90003061: goto L12;
            case 90003083: goto L9;
            case 90005083: goto L9;
            case 900011002: goto L12;
            default: goto L4;
        };
    L4:
        if (r3 == null) goto L11;
        return r3;
    L11:
        return r1.d();
    L12:
        return r1.b();
    L13:
        return r1.a();
    L9:
        return r1.c();
    }
}
