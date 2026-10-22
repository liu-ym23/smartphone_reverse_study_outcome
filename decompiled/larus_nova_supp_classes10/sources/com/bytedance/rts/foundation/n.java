package com.bytedance.rts.foundation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n {
    public final Queue<s> a;
    public final Handler b;
    public final Queue<s> c;

    public static final class a implements Runnable {
        public final /* synthetic */ s a;

        public a(s r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.a(this.a.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public n() {
        this.a = new LinkedList();
        this.b = new Handler(Looper.getMainLooper());
        this.c = new LinkedList();
    }

    public static final void a(n r11) {
    L3:
        if (r11.c.isEmpty() == true) goto L7;
        s r0 = (s) ((LinkedList) r11.c).poll();
        if (r0 == null) goto L3;
        r0.a.invoke();
        goto L3
    L7:
        LinkedList r1 = new LinkedList(r11.a);
        long r3 = Long.MAX_VALUE;
    L9:
        if (r1.isEmpty() == true) goto L33;
        s r5 = (s) r1.poll();
        if (r5 == null) goto L9;
        if (r5.b < SystemClock.uptimeMillis()) goto L14;
        long r6 = r5.b;
        if (r3 <= r6) goto L9;
        r3 = r6;
        goto L9
    L14:
        long r7 = SystemClock.uptimeMillis();
        r5.a.invoke();
    L16:
        if (r11.c.isEmpty() == true) goto L21;
        s r8 = (s) ((LinkedList) r11.c).poll();
        if (r8 == null) goto L16;
        r8.a.invoke();
        goto L16
    L21:
        if (r5.d == false) goto L28;
        if (((LinkedList) r11.a).contains(r5) == false) goto L28;
        long r9 = r7 + r5.c;
        r5.b = r9;
        if (r3 <= r9) goto L27;
        r3 = r9;
    L27:
        ((LinkedList) r11.a).remove(r5);
        ((LinkedList) r11.a).add(r5);
    L28:
        ((LinkedList) r11.a).remove(r5);
        goto L9
    L33:
        if (r3 == Long.MAX_VALUE) goto L60;
        r11.b.postAtTime(new p(r11), r3);
        return;
    }

    public final s b(Function0<Unit> r8, long r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r8, "action");
        s r0 = new s(r8, this, r9, r11);
        ((LinkedList) this.a).add(r0);
        this.b.postDelayed(new a(r0), r9);
        return r0;
    }
}
