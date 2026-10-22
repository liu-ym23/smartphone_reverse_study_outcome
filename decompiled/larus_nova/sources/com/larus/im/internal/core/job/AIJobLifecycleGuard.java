package com.larus.im.internal.core.job;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AIJobLifecycleGuard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final buc.d f347641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f347642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<Function0<Unit>> f347643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f347644d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/internal/core/job/AIJobLifecycleGuard$Decision;", "", "<init>", "(Ljava/lang/String;I)V", "SUPERSEDED", "REFRESH", "PROCEED", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Decision extends Enum<Decision> {
        public static final Decision PROCEED = null;
        public static final Decision REFRESH = null;
        public static final Decision SUPERSEDED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Decision[] f347645a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f347646b = null;

        public static EnumEntries<Decision> getEntries() {
            return f347646b;
        }

        static {
            Decision r100 = new Decision("SUPERSEDED", 0);
            SUPERSEDED = r100;
            Decision r101 = new Decision("REFRESH", 1);
            REFRESH = r101;
            Decision r102 = new Decision("PROCEED", 2);
            PROCEED = r102;
            Decision[] r103 = {r100, r101, r102};
            f347645a = r103;
            f347646b = EnumEntriesKt.enumEntries(r103);
        }

        public static Decision[] values() {
            return (Decision[]) f347645a.clone();
        }

        public static Decision valueOf(String r100) {
            return (Decision) r27.a.a(Decision.class, r100);
        }

        public Decision(String r100, int r101) {
            super(r100, r101);
        }
    }

    public AIJobLifecycleGuard() {
        this.f347641a = buc.b.c(0);
        this.f347642b = new ReentrantLock();
        this.f347643c = new ArrayDeque();
    }

    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ReentrantLock r101 = this.f347642b;
        r101.lock();
        this.f347643c.addLast(r100);     // Catch: Throwable -> L29
        if (this.f347644d == false) goto L6;
        boolean r102 = false;
    L7:
        r101.unlock();
        if (r102 == true) goto L10;
        return;
    L10:
        Throwable r103 = null;
    L11:
        ReentrantLock r104 = this.f347642b;
        r104.lock();
        if (this.f347643c.isEmpty() == false) goto L15;
        this.f347644d = false;     // Catch: Throwable -> L26
        Function0<Unit> r105 = null;
    L16:
        r104.unlock();
        if (r105 == null) goto L18;
        r105.invoke();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        if (r103 != null) goto L11;
        r103 = th;
        goto L11
    L18:
        if (r103 != null) goto L20;
        return;
    L20:
        throw r103;
    L15:
        r105 = this.f347643c.removeFirst();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r104.unlock();
        throw th;
    L6:
        r102 = true;
        this.f347644d = true;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final Decision a(long r100, boolean r101, boolean r102) {
        if (r100 != this.f347641a.c()) goto L5;
        if (r101 != r102) goto L9;
        return Decision.PROCEED;
    L9:
        return Decision.REFRESH;
    L5:
        return Decision.SUPERSEDED;
    }
}
