package com.bytedance.applet.provider.impl;

import com.bytedance.applet.impl.j1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletLaneInitializer {
    public static final AtomicReference<Phase> a = null;
    public static final AtomicBoolean b = null;
    public static final AtomicBoolean c = null;
    public static final AtomicBoolean d = null;
    public static final AtomicBoolean e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applet/provider/impl/AppletLaneInitializer$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RUNNING", "DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase DONE = null;
        public static final Phase IDLE = null;
        public static final Phase RUNNING = null;
        public static final /* synthetic */ Phase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Phase> getEntries() {
            return b;
        }

        static {
            Phase r0 = new Phase("IDLE", 0);
            IDLE = r0;
            Phase r1 = new Phase("RUNNING", 1);
            RUNNING = r1;
            Phase r3 = new Phase("DONE", 2);
            DONE = r3;
            Phase[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Phase[] values() {
            return (Phase[]) a.clone();
        }

        public static Phase valueOf(String r1) {
            return (Phase) r27.a.a(Phase.class, r1);
        }

        public Phase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Phase.values().length];
            r0[Phase.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Phase.IDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Phase.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
        a = new AtomicReference(Phase.IDLE);
        b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
        e = new AtomicBoolean(false);
    }

    public static void a(j1 r5) {
        Intrinsics.checkNotNullParameter(r5, "block");
    L3:
        AtomicReference<Phase> r0 = a;
        Phase r1 = r0.get();
        if (r1 != null) goto L6;
        int r2 = -1;
    L7:
        boolean r3 = true;
        if (r2 == 1) goto L33;
        if (r2 != 2) goto L12;
        Phase r4 = Phase.IDLE;
        Phase r6 = Phase.RUNNING;
    L22:
        if (r0.compareAndSet(r4, r6) == true) goto L27;
        if (r0.get() == r4) goto L22;
        r3 = false;
    L27:
        if (r3 == false) goto L3;
        r5.invoke();     // Catch: Throwable -> L30
        a.set(Phase.DONE);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        a.set(Phase.IDLE);
        FLogger.a.e("AppletLaneInitializer", "applet init failed, reset to IDLE for retry: " + th.getMessage());
        throw th;
    L12:
        if (r2 != 3) goto L19;
        Thread.sleep(5);     // Catch: InterruptedException -> L16
    L16:
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L33:
        return;
    L6:
        r2 = a.a[r1.ordinal()];
        goto L7
    }
}
