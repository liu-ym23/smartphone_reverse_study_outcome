package com.bytedance.ee.bear.document.print;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public static final Handler a = null;
    public static final ConcurrentHashMap<String, a> b = null;

    public static final class a {
        public final com.bytedance.ee.bear.document.print.c a;
        public final AtomicBoolean b;
        public volatile Function1<? super Boolean, Unit> c;
        public volatile Runnable d;

        public final void a(boolean r4) {
            if (this.b.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            Function1<? super Boolean, Unit> r0 = this.c;
            this.c = null;
            if (r0 == null) goto L14;
            r0.invoke(Boolean.valueOf(r4));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            tt5.a.d("SystemPrintService", "dispatch print result failed: ".concat(th.getClass().getSimpleName()));
            return;
        }

        public a(com.bytedance.ee.bear.document.print.c r2, Function1<? super Boolean, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "artifact");
            Intrinsics.checkNotNullParameter(r3, "onResult");
            this.a = r2;
            this.b = new AtomicBoolean(false);
            this.c = r3;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ com.bytedance.ee.bear.document.print.c b;
        public final /* synthetic */ Function1<Boolean, Unit> c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(FragmentActivity r1, com.bytedance.ee.bear.document.print.c r2, Function1<? super Boolean, Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Handler r0 = r.a;     // Catch: Throwable -> L4
            r.a(this.a, this.b, this.c);     // Catch: Throwable -> L4
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
        public final /* synthetic */ String a;

        public c(String r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = r.b.remove(this.a);     // Catch: Throwable -> L7
            if (r0 == null) goto L10;
            r0.d = null;     // Catch: Throwable -> L7
            tt5.a.k("SystemPrintService", "print host activity session timed out");     // Catch: Throwable -> L7
            r0.a.a();     // Catch: Throwable -> L7
            r0.a(false);     // Catch: Throwable -> L7
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
        a = new Handler(Looper.getMainLooper());
        b = new ConcurrentHashMap();
    }

    public static void a(FragmentActivity r3, com.bytedance.ee.bear.document.print.c r4, Function1 r5) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "artifact");
        Intrinsics.checkNotNullParameter(r5, "onResult");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        r3.runOnUiThread(new b(r3, r4, r5));
        return;
    L7:
        if (r3.isFinishing() == false) goto L9;
    L25:
        r4.a();
        r5.invoke(Boolean.FALSE);
        return;
    L9:
        if (r3.isDestroyed() == true) goto L25;
        String r0 = UUID.randomUUID().toString();
        a r1 = new a(r4, r5);
        c r6 = new c(r0);
        r1.d = r6;
        b.put(r0, r1);
        a.postDelayed(r6, 15000);
        int r7 = PrintHostActivity.c;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r3, "context");     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r0, "sessionId");     // Catch: Throwable -> L14
        r3.startActivity(new Intent(r3, PrintHostActivity.class).putExtra("print_session_id", r0).addFlags(65536));     // Catch: Throwable -> L14
        r3.overridePendingTransition(0, 0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        tt5.a.d("SystemPrintService", "start print host activity failed: ".concat(th.getClass().getSimpleName()));
        a r8 = b.remove(r0);
        if (r8 != null) goto L18;
        r8 = null;
    L22:
        if (r8 == null) goto L29;
        r8.a.a();
        r8.a(false);
        return;
    L29:
        return;
    L18:
        Runnable r2 = r8.d;
        if (r2 == null) goto L21;
        a.removeCallbacks(r2);
    L21:
        r8.d = null;
        goto L22
    }
}
