package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.lego.init.tasks.IdleTaskProxy;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class h {
    public static IdleTaskConfig a;
    public static final ArrayList<bf6.e> b = null;
    public static final ArrayList<bf6.e> c = null;
    public static volatile AtomicInteger d;
    public static int e;
    public static final Handler f = null;
    public static volatile boolean g;
    public static final a h = null;

    public static final class a implements MessageQueue.IdleHandler {
        public a() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            IdleTaskConfig r0 = h.a;
            if (h.g == true) goto L5;
            return true;
        L5:
            int r1 = Math.min(h.b.size(), h.a.getUiThreadTaskNum());
            int r3 = 0;
            boolean r4 = false;
        L6:
            if (r3 >= r1) goto L8;
            bf6.e r5 = (bf6.e) ListProtector.remove(h.b, 0);
            new IdleTaskProxy(r5.d, r5.a, true, IdleTaskDispatcher.peekUITaskExecute.1.INSTANCE).run();
            r3 = r3 + 1;
            r4 = true;
            goto L6
        L8:
            if (r4 == true) goto L12;
            int r2 = Math.min(h.c.size(), h.a.getNonUIThreadTaskNum());
            int r6 = 0;
        L10:
            if (r6 >= r2) goto L12;
            j.a(new IdleTaskDispatcher.peekNonUITaskExecute.1((bf6.e) ListProtector.remove(h.c, 0)));
            r6 = r6 + 1;
        L12:
            IdleTaskConfig r7 = h.a;
            if ((!h.c.isEmpty()) == false) goto L15;
            return true;
        L15:
            if ((!h.b.isEmpty()) == true) goto L22;
            return false;
        L22:
            return true;
        }
    }

    public h() {
    }

    static {
        IdleTaskConfig.Companion.getClass();
        a = IdleTaskConfig.access$getDEFAULT_IDLETASK_CONFIG$cp();
        b = new ArrayList();
        c = new ArrayList();
        d = new AtomicInteger(0);
        f = new Handler(Looper.getMainLooper());
        h = new a();
    }

    public static void a() {
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == true) goto L6;
        return;
    L6:
        if (g == false) goto L8;
        return;
    L8:
        g = true;
        ArrayList<bf6.e> r0 = b;
        List<bf6.e> r1 = o.i;
        if (r1.isEmpty() == true) goto L11;
    L13:
        List<bf6.e> r2 = o.h;
        r0.addAll(r2);
        ArrayList<bf6.e> r3 = c;
        if (r1.isEmpty() == true) goto L16;
    L18:
        r3.addAll(r1);
        int r4 = r0.size() + r3.size();
        e = r4;
        if (r4 != 0) goto L21;
        return;
    L21:
        Looper.myQueue().addIdleHandler(h);
        return;
    L16:
        if (r2.isEmpty() == false) goto L18;
        o.a();
        goto L18
    L11:
        if (o.h.isEmpty() == false) goto L13;
        o.a();
        goto L13
    }
}
