package com.bytedance.ee.bear.office.common.upload;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f235392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f235393b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f235394c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f235395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f235396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f235397f = null;

    public static final class a {
        public a() {
        }

        public final String a() {
            Application r100 = eu5.b.f474075a;
            return xo5.a.c(r100, R.string.CreationMobile_Drive_Upload_No_MaxSizeReached, "operation_failed", r100.getString(R.string.CreationMobile_Drive_Upload_No_MaxSizeReached_var));
        }

        public final String b() {
            k.f235392a.getClass();
            Application r100 = eu5.b.f474075a;
            int r101 = r100.getResources().getIdentifier("larus_drive_tooltip_uploadNA_fullStorage", "string", r100.getPackageName());
            if (r101 == 0) goto L5;
            String r102 = r100.getString(r101);
            Intrinsics.checkNotNull(r102);
            return r102;
        L5:
            String r103 = r100.getString(R.string.LarkCCM_Doubao_Drive_StorageInsufficient_Toast);
            Intrinsics.checkNotNull(r103);
            return r103;
        }

        public final String c() {
            return eu5.b.f474075a.getString(R.string.LarkCCM_Doubao_Drive_StorageInsufficient_Toast);
        }

        public final String d() {
            return eu5.b.f474075a.getString(R.string.Settings_Language_UploadFailed);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f235398a;

        public b(String r100) {
            this.f235398a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long r100 = System.currentTimeMillis();     // Catch: Throwable -> L9
            if (Intrinsics.areEqual(this.f235398a, k.f235395d) == true) goto L5;
        L7:
            String r101 = this.f235398a;     // Catch: Throwable -> L9
            k.f235395d = r101;     // Catch: Throwable -> L9
            k.f235396e = r100;     // Catch: Throwable -> L9
            Toast.showFailureText(eu5.b.f474075a, r101);     // Catch: Throwable -> L9
            return;
        L5:
            if ((r100 - k.f235396e) >= 1000) goto L7;
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f235399a = null;

        static {
            f235399a = new c();
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "office-upload-executor");
        }
    }

    public k() {
    }

    static {
        f235392a = new k();
        f235393b = PThreadExecutorsUtils.newSingleThreadExecutor(c.f235399a);
        f235394c = new Handler(Looper.getMainLooper());
        f235397f = new a();
    }

    public static com.bytedance.ee.bear.drive.sdk.service.g a() {
        return ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
    }

    public static void b(String r100) {
        f235394c.post(new b(r100));
    }

    public static String c(g0 r100) {
        if (Intrinsics.areEqual(r100, g0.b.f235371a) == false) goto L6;
        return "root_mine";
    L6:
        if ((r100 instanceof g0.a) == false) goto L10;
        return "folder_hash=" + ((g0.a) r100).f235370a.hashCode();
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static String d(int r100, String r101) {
        int r102 = j.f235391a;
        a r103 = f235397f;
        Intrinsics.checkNotNullParameter(r103, "stringProvider");
        switch(r100) {
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
        if (r101 == null) goto L11;
        return r101;
    L11:
        return r103.d();
    L12:
        return r103.b();
    L13:
        return r103.a();
    L9:
        return r103.c();
    }
}
