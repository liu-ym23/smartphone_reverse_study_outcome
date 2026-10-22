package com.bytedance.ee.bear.tts.operation;

import android.os.Looper;
import com.bytedance.ee.util.ui.j;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsOperationQueue {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public Status c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/tts/operation/TtsOperationQueue$Status;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "IDLE", "WORKING", "DESTROYED", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status DESTROYED = null;
        public static final Status IDLE = null;
        public static final Status INIT = null;
        public static final Status WORKING = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("INIT", 0);
            INIT = r0;
            Status r1 = new Status("IDLE", 1);
            IDLE = r1;
            Status r3 = new Status("WORKING", 2);
            WORKING = r3;
            Status r5 = new Status("DESTROYED", 3);
            DESTROYED = r5;
            Status[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Status.values().length];
            r0[Status.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Status.IDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Status.WORKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Status.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ TtsOperationQueue a;

        public c(TtsOperationQueue r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TtsOperationQueue.a(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void d() {
        tt5.a.h("TtsOperationQueue", "clearQueue, queue: " + this);
        Iterator<com.bytedance.ee.bear.tts.operation.a> r0 = i().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.bytedance.ee.bear.tts.operation.a r1 = r0.next();
        r1.c();
        r1.c = null;
        r1.b = null;
        r0.remove();
        goto L4
    L6:
        Iterator<com.bytedance.ee.bear.tts.operation.a> r2 = h().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        com.bytedance.ee.bear.tts.operation.a r3 = r2.next();
        r3.c();
        r3.c = null;
        r3.b = null;
        r2.remove();
        goto L8
    }

    public final Queue<com.bytedance.ee.bear.tts.operation.a> h() {
        return (Queue) this.b.getValue();
    }

    public final Set<com.bytedance.ee.bear.tts.operation.a> i() {
        return (Set) this.a.getValue();
    }

    public final void j() {
        tt5.a.h("TtsOperationQueue", "onQueueDestroy, queue: " + this);
        Status r0 = this.c;
        Status r1 = Status.DESTROYED;
        if (r0 != r1) goto L5;
        return;
    L5:
        g("destroyQueue", r1);
        d();
    }

    public final String toString() {
        return "TtsOperationQueue@" + hashCode() + "{status: " + this.c + ", workingSet: " + i() + ", pendingQueue: " + h() + ", maxWorking: 1}";
    }

    public TtsOperationQueue() {
        this.a = LazyKt.lazy(TtsOperationQueue$workingSet$2.INSTANCE);
        this.b = LazyKt.lazy(TtsOperationQueue$pendingQueue$2.INSTANCE);
        this.c = Status.INIT;
    }

    public final void c() {
        d();
        g("destroyQueue", Status.IDLE);
    }

    public static final void a(TtsOperationQueue r2) {
        r2.getClass();
        tt5.a.h("TtsOperationQueue", "queueNext, queue: " + r2);
        if (r2.c == Status.DESTROYED) goto L17;
        f("queueNext");
        if (r2.h().isEmpty() == false) goto L9;
        return;
    L9:
        if (r2.g("queueNext", Status.WORKING) == false) goto L19;
        com.bytedance.ee.bear.tts.operation.a r0 = r2.h().poll();
        if (r0 != null) goto L14;
        r2.e(null);
        return;
    L14:
        r2.i().add(r0);
        r0.d();
        return;
    L19:
        return;
    }

    public static void f(String r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        return;
    L6:
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L10;
        tt5.a.d("TtsOperationQueue", r3 + " must be called in main thread.");
        return;
    L10:
        throw new IllegalStateException(r3 + " must be called in main thread.");
    }

    public final void b(com.bytedance.ee.bear.tts.operation.a r5) {
        Intrinsics.checkNotNullParameter(r5, "newOperation");
        tt5.a.h("TtsOperationQueue", "add, queue: " + this);
        Status r0 = this.c;
        Status r2 = Status.DESTROYED;
        if (r0 != r2) goto L5;
        return;
    L5:
        tt5.a.h("TtsOperationQueue", "enqueue, operation: " + r5 + ", queue: " + this);
        if (this.c != r2) goto L9;
        return;
    L9:
        if (i().contains(r5) == false) goto L11;
    L17:
        tt5.a.d("TtsOperationQueue", "enqueue, operation existed!");
        return;
    L11:
        if (h().contains(r5) == true) goto L17;
        if (h().offer(r5) == false) goto L16;
        r5.c = new com.bytedance.ee.bear.tts.operation.b(r5, this);
        r5.b();
    L16:
        j.c(new com.bytedance.ee.bear.tts.operation.c(this));
    }

    public final void e(com.bytedance.ee.bear.tts.operation.a r3) {
        tt5.a.h("TtsOperationQueue", "dequeue, operation: " + r3 + ", queue: " + this);
        if (r3 != null) goto L5;
    L16:
        g("dequeue", Status.IDLE);
        j.c(new c(this));
        return;
    L5:
        if (i().contains(r3) == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r3 = null;
    L14:
        if (r3 == null) goto L16;
        i().remove(r3);
        h().remove(r3);
        r3.c();
        goto L16
    L7:
        if (h().contains(r3) == true) goto L10;
        r0 = false;
        goto L11
    }

    public final boolean g(String r6, Status r7) {
        f("flowToStatus(" + r6 + ')');
        Status r8 = this.c;
        Status r0 = Status.INIT;
        if (r8 == r0) goto L5;
    L7:
        int r9 = b.a[r7.ordinal()];
        boolean r1 = false;
        if (r9 != 1) goto L10;
    L34:
        boolean r10 = false;
    L36:
        if (r10 == true) goto L39;
        tt5.a.h("TtsOperationQueue", "flowToStatus, cannot flow to targetStatus: " + r7 + ", queue: " + this);
        return false;
    L39:
        Status r11 = this.c;
        if (r11 == r7) goto L42;
        r1 = true;
    L42:
        if (r1 == true) goto L45;
        r11 = null;
    L45:
        if (r11 == null) goto L47;
        tt5.a.h("TtsOperationQueue", "flowToStatus, targetStatus: " + r7 + ", queue: " + this);
        this.c = r7;
        tt5.a.h("TtsOperationQueue", "onQueueStatusChanged, fromStatus: " + r11 + ", toStatus: " + r7 + ", queue: " + this);
    L48:
        return true;
    L47:
        tt5.a.h("TtsOperationQueue", "flowToStatus, already at targetStatus: " + r7 + ", queue: " + this);
        goto L48
    L10:
        if (r9 != 2) goto L12;
        Status r12 = this.c;
        if (r12 == r0) goto L32;
        if (r12 == Status.IDLE) goto L32;
        if (r12 != Status.WORKING) goto L34;
    L32:
        if (i().isEmpty() == false) goto L34;
    L33:
        r10 = true;
        goto L36
    L12:
        if (r9 != 3) goto L14;
        Status r13 = this.c;
        if (r13 == Status.IDLE) goto L23;
        if (r13 != Status.WORKING) goto L34;
    L23:
        if (i().size() >= 1) goto L34;
    L14:
        if (r9 == 4) goto L33;
        throw new NoWhenBranchMatchedException();
    L5:
        if (r7 != Status.WORKING) goto L7;
        g("flowToStatus", Status.IDLE);
        goto L7
    }
}
