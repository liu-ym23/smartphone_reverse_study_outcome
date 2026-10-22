package com.bytedance.ee.bear.tts.operation;

import android.os.Looper;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
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

/* JADX INFO: loaded from: classes18.dex */
public final class TtsOperationQueue {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f239730d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f239731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f239732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Status f239733c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/tts/operation/TtsOperationQueue$Status;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "IDLE", "WORKING", "DESTROYED", "docs-document-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status DESTROYED = null;
        public static final Status IDLE = null;
        public static final Status INIT = null;
        public static final Status WORKING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f239734a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f239735b = null;

        public static EnumEntries<Status> getEntries() {
            return f239735b;
        }

        static {
            Status r100 = new Status(ErrorCode.INIT, 0);
            INIT = r100;
            Status r101 = new Status("IDLE", 1);
            IDLE = r101;
            Status r102 = new Status("WORKING", 2);
            WORKING = r102;
            Status r103 = new Status("DESTROYED", 3);
            DESTROYED = r103;
            Status[] r104 = {r100, r101, r102, r103};
            f239734a = r104;
            f239735b = EnumEntriesKt.enumEntries(r104);
        }

        public static Status[] values() {
            return (Status[]) f239734a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f239736a = null;

        static {
            int[] r100 = new int[Status.values().length];
            r100[Status.INIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Status.IDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Status.WORKING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Status.DESTROYED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f239736a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TtsOperationQueue f239737a;

        public c(TtsOperationQueue r100) {
            this.f239737a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TtsOperationQueue.a(this.f239737a);     // Catch: Throwable -> L4
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
        Iterator<com.bytedance.ee.bear.tts.operation.a> r100 = i().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        com.bytedance.ee.bear.tts.operation.a r101 = r100.next();
        r101.c();
        r101.f239740c = null;
        r101.f239739b = null;
        r100.remove();
        goto L4
    L6:
        Iterator<com.bytedance.ee.bear.tts.operation.a> r102 = h().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        com.bytedance.ee.bear.tts.operation.a r103 = r102.next();
        r103.c();
        r103.f239740c = null;
        r103.f239739b = null;
        r102.remove();
        goto L8
    }

    public final Queue<com.bytedance.ee.bear.tts.operation.a> h() {
        return (Queue) this.f239732b.getValue();
    }

    public final Set<com.bytedance.ee.bear.tts.operation.a> i() {
        return (Set) this.f239731a.getValue();
    }

    public final void j() {
        tt5.a.h("TtsOperationQueue", "onQueueDestroy, queue: " + this);
        Status r100 = this.f239733c;
        Status r101 = Status.DESTROYED;
        if (r100 != r101) goto L5;
        return;
    L5:
        g("destroyQueue", r101);
        d();
    }

    public final String toString() {
        return "TtsOperationQueue@" + hashCode() + "{status: " + this.f239733c + ", workingSet: " + i() + ", pendingQueue: " + h() + ", maxWorking: 1}";
    }

    public TtsOperationQueue() {
        this.f239731a = LazyKt.lazy(TtsOperationQueue$workingSet$2.INSTANCE);
        this.f239732b = LazyKt.lazy(TtsOperationQueue$pendingQueue$2.INSTANCE);
        this.f239733c = Status.INIT;
    }

    public final void c() {
        d();
        g("destroyQueue", Status.IDLE);
    }

    public static final void a(TtsOperationQueue r100) {
        r100.getClass();
        tt5.a.h("TtsOperationQueue", "queueNext, queue: " + r100);
        if (r100.f239733c == Status.DESTROYED) goto L17;
        f("queueNext");
        if (r100.h().isEmpty() == false) goto L9;
        return;
    L9:
        if (r100.g("queueNext", Status.WORKING) == false) goto L19;
        com.bytedance.ee.bear.tts.operation.a r101 = r100.h().poll();
        if (r101 != null) goto L14;
        r100.e(null);
        return;
    L14:
        r100.i().add(r101);
        r101.d();
        return;
    L19:
        return;
    }

    public static void f(String r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        return;
    L6:
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L10;
        tt5.a.d("TtsOperationQueue", r100 + " must be called in main thread.");
        return;
    L10:
        throw new IllegalStateException(r100 + " must be called in main thread.");
    }

    public final void b(com.bytedance.ee.bear.tts.operation.a r100) {
        Intrinsics.checkNotNullParameter(r100, "newOperation");
        tt5.a.h("TtsOperationQueue", "add, queue: " + this);
        Status r101 = this.f239733c;
        Status r102 = Status.DESTROYED;
        if (r101 != r102) goto L5;
        return;
    L5:
        tt5.a.h("TtsOperationQueue", "enqueue, operation: " + r100 + ", queue: " + this);
        if (this.f239733c != r102) goto L9;
        return;
    L9:
        if (i().contains(r100) == false) goto L11;
    L17:
        tt5.a.d("TtsOperationQueue", "enqueue, operation existed!");
        return;
    L11:
        if (h().contains(r100) == true) goto L17;
        if (h().offer(r100) == false) goto L16;
        r100.f239740c = new com.bytedance.ee.bear.tts.operation.b(r100, this);
        r100.b();
    L16:
        j.c(new com.bytedance.ee.bear.tts.operation.c(this));
    }

    public final void e(com.bytedance.ee.bear.tts.operation.a r100) {
        tt5.a.h("TtsOperationQueue", "dequeue, operation: " + r100 + ", queue: " + this);
        if (r100 != null) goto L5;
    L16:
        g("dequeue", Status.IDLE);
        j.c(new c(this));
        return;
    L5:
        if (i().contains(r100) == false) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L14;
        r100 = null;
    L14:
        if (r100 == null) goto L16;
        i().remove(r100);
        h().remove(r100);
        r100.c();
        goto L16
    L7:
        if (h().contains(r100) == true) goto L10;
        r101 = false;
        goto L11
    }

    public final boolean g(String r100, Status r101) {
        f("flowToStatus(" + r100 + ')');
        Status r102 = this.f239733c;
        Status r103 = Status.INIT;
        if (r102 == r103) goto L5;
    L7:
        int r104 = b.f239736a[r101.ordinal()];
        boolean r105 = false;
        if (r104 != 1) goto L10;
    L34:
        boolean r106 = false;
    L36:
        if (r106 == true) goto L39;
        tt5.a.h("TtsOperationQueue", "flowToStatus, cannot flow to targetStatus: " + r101 + ", queue: " + this);
        return false;
    L39:
        Status r107 = this.f239733c;
        if (r107 == r101) goto L42;
        r105 = true;
    L42:
        if (r105 == true) goto L45;
        r107 = null;
    L45:
        if (r107 == null) goto L47;
        tt5.a.h("TtsOperationQueue", "flowToStatus, targetStatus: " + r101 + ", queue: " + this);
        this.f239733c = r101;
        tt5.a.h("TtsOperationQueue", "onQueueStatusChanged, fromStatus: " + r107 + ", toStatus: " + r101 + ", queue: " + this);
    L48:
        return true;
    L47:
        tt5.a.h("TtsOperationQueue", "flowToStatus, already at targetStatus: " + r101 + ", queue: " + this);
        goto L48
    L10:
        if (r104 != 2) goto L12;
        Status r108 = this.f239733c;
        if (r108 == r103) goto L32;
        if (r108 == Status.IDLE) goto L32;
        if (r108 != Status.WORKING) goto L34;
    L32:
        if (i().isEmpty() == false) goto L34;
    L33:
        r106 = true;
        goto L36
    L12:
        if (r104 != 3) goto L14;
        Status r109 = this.f239733c;
        if (r109 == Status.IDLE) goto L23;
        if (r109 != Status.WORKING) goto L34;
    L23:
        if (i().size() >= 1) goto L34;
    L14:
        if (r104 == 4) goto L33;
        throw new NoWhenBranchMatchedException();
    L5:
        if (r101 != Status.WORKING) goto L7;
        g("flowToStatus", Status.IDLE);
        goto L7
    }
}
