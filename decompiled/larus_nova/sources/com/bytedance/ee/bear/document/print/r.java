package com.bytedance.ee.bear.document.print;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f221214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f221215b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.document.print.c f221216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f221217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile Function1<? super Boolean, Unit> f221218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile Runnable f221219d;

        public final void a(boolean r100) {
            if (this.f221217b.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            Function1<? super Boolean, Unit> r101 = this.f221218c;
            this.f221218c = null;
            if (r101 == null) goto L14;
            r101.invoke(Boolean.valueOf(r100));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            tt5.a.d("SystemPrintService", "dispatch print result failed: ".concat(th.getClass().getSimpleName()));
            return;
        }

        public a(com.bytedance.ee.bear.document.print.c r100, Function1<? super Boolean, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "artifact");
            Intrinsics.checkNotNullParameter(r101, "onResult");
            this.f221216a = r100;
            this.f221217b = new AtomicBoolean(false);
            this.f221218c = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f221220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.document.print.c f221221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f221222c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(FragmentActivity r100, com.bytedance.ee.bear.document.print.c r101, Function1<? super Boolean, Unit> r102) {
            this.f221220a = r100;
            this.f221221b = r101;
            this.f221222c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler r100 = r.f221214a;     // Catch: Throwable -> L4
            r.a(this.f221220a, this.f221221b, this.f221222c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f221223a;

        public c(String r100) {
            this.f221223a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = r.f221215b.remove(this.f221223a);     // Catch: Throwable -> L7
            if (r100 == null) goto L10;
            r100.f221219d = null;     // Catch: Throwable -> L7
            tt5.a.k("SystemPrintService", "print host activity session timed out");     // Catch: Throwable -> L7
            r100.f221216a.a();     // Catch: Throwable -> L7
            r100.a(false);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }
    }

    static {
        f221214a = new Handler(Looper.getMainLooper());
        f221215b = new ConcurrentHashMap();
    }

    public static void a(FragmentActivity r100, com.bytedance.ee.bear.document.print.c r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "artifact");
        Intrinsics.checkNotNullParameter(r102, "onResult");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        r100.runOnUiThread(new b(r100, r101, r102));
        return;
    L7:
        if (r100.isFinishing() == false) goto L9;
    L25:
        r101.a();
        r102.invoke(Boolean.FALSE);
        return;
    L9:
        if (r100.isDestroyed() == true) goto L25;
        String r103 = UUID.randomUUID().toString();
        a r104 = new a(r101, r102);
        c r105 = new c(r103);
        r104.f221219d = r105;
        f221215b.put(r103, r104);
        f221214a.postDelayed(r105, 15000);
        int r106 = PrintHostActivity.f221123c;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r103, "sessionId");     // Catch: Throwable -> L14
        r100.startActivity(new Intent(r100, PrintHostActivity.class).putExtra("print_session_id", r103).addFlags(65536));     // Catch: Throwable -> L14
        r100.overridePendingTransition(0, 0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        tt5.a.d("SystemPrintService", "start print host activity failed: ".concat(th.getClass().getSimpleName()));
        a r107 = f221215b.remove(r103);
        if (r107 != null) goto L18;
        r107 = null;
    L22:
        if (r107 == null) goto L29;
        r107.f221216a.a();
        r107.a(false);
        return;
    L29:
        return;
    L18:
        Runnable r108 = r107.f221219d;
        if (r108 == null) goto L21;
        f221214a.removeCallbacks(r108);
    L21:
        r107.f221219d = null;
        goto L22
    }
}
