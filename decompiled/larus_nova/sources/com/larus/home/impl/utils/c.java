package com.larus.home.impl.utils;

import android.os.Looper;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes29.dex */
@Skip({"com.bytedance.thanos+"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Thread f346341a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f346342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f346343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f346344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f346345e;

    public class a implements ICrashCallback {

        /* JADX INFO: renamed from: com.larus.home.impl.utils.c$a$a, reason: collision with other inner class name */
        public class C4332a implements AttachUserData {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Map f346346a;

            public C4332a(Map r100) {
                this.f346346a = r100;
            }

            @Override // com.bytedance.crash.AttachUserData
            public final Map<? extends String, ? extends String> getUserData(CrashType r100) {
                return this.f346346a;
            }
        }

        public a() {
        }

        @Override // com.bytedance.crash.ICrashCallback
        public final void onCrash(CrashType r100, String r101, Thread r102) {
            if (r101 == null) goto L13;
        L8:
            th = move-exception;
            FLogger.f375446a.e("DecorViewLancet", "", th);
            return;
        L5:
            if (r101.contains("Unable to start activity") == false) goto L14;
            String r103 = (System.currentTimeMillis() - c.f346342b) + " ms ago, " + c.f346344d;     // Catch: Throwable -> L8
            FLogger.f375446a.w("DecorViewLancet", r103);     // Catch: Throwable -> L8
            HashMap r104 = new HashMap();     // Catch: Throwable -> L8
            r104.put("DecorViewLancet", r103);     // Catch: Throwable -> L8
            C4332a r105 = new C4332a(r104);     // Catch: Throwable -> L8
            Npth.addAttachLongUserData(r105, CrashType.JAVA);     // Catch: Throwable -> L8
            Npth.addAttachLongUserData(r105, CrashType.LAUNCH);     // Catch: Throwable -> L8
            Npth.addTag("DecorViewLancet", "true");     // Catch: Throwable -> L8
            return;
        L14:
            return;
        }
    }

    public c() {
    }

    static {
        f346341a = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
        f346342b = 0;
        f346343c = false;
        f346344d = "";
        f346345e = false;
    }

    public static void a(Thread r100, String r101) {
        String r102 = "Thread " + r100.getId() + " invokes " + r101 + " in non main thread! Backtrace: " + Arrays.toString(r100.getStackTrace()).replace(',', '\n');
        FLogger r103 = FLogger.f375446a;
        r103.i("DecorViewLancet", "getDecorpossibleCrashReason: " + r102);
        if (f346343c == true) goto L14;
        r103.w("DecorViewLancet", r102);
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f346343c == true) goto L9;
        a r104 = new a();     // Catch: Throwable -> L11
        Npth.registerCrashCallback(r104, CrashType.JAVA);     // Catch: Throwable -> L11
        Npth.registerCrashCallback(r104, CrashType.LAUNCH);     // Catch: Throwable -> L11
        f346343c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L14:
        f346344d = r102;
        f346342b = System.currentTimeMillis();
    }
}
