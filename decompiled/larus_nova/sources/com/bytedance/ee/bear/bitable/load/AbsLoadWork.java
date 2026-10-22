package com.bytedance.ee.bear.bitable.load;

import com.bytedance.ee.bear.document.b5;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class AbsLoadWork {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f214440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f214441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f214442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WorkStatus f214443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b5 f214444e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/bitable/load/AbsLoadWork$WorkStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PENDDING", "WORKING", "DONE", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WorkStatus extends Enum<WorkStatus> {
        public static final WorkStatus DONE = null;
        public static final WorkStatus PENDDING = null;
        public static final WorkStatus WORKING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WorkStatus[] f214445a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f214446b = null;

        public static EnumEntries<WorkStatus> getEntries() {
            return f214446b;
        }

        static {
            WorkStatus r100 = new WorkStatus("PENDDING", 0);
            PENDDING = r100;
            WorkStatus r101 = new WorkStatus("WORKING", 1);
            WORKING = r101;
            WorkStatus r102 = new WorkStatus("DONE", 2);
            DONE = r102;
            WorkStatus[] r103 = {r100, r101, r102};
            f214445a = r103;
            f214446b = EnumEntriesKt.enumEntries(r103);
        }

        public static WorkStatus[] values() {
            return (WorkStatus[]) f214445a.clone();
        }

        public static WorkStatus valueOf(String r100) {
            return (WorkStatus) r27.a.a(WorkStatus.class, r100);
        }

        public WorkStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsLoadWork f214447a;

        public b(AbsLoadWork r100) {
            this.f214447a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f214447a.d();     // Catch: Throwable -> L4
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

    public void c(boolean r100) {
    }

    public abstract void d();

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public final boolean e() {
        if (this.f214443d != WorkStatus.WORKING) goto L5;
        return true;
    L5:
        return false;
    }

    public final void l() {
        if (this.f214443d == WorkStatus.PENDDING) goto L5;
        return;
    L5:
        this.f214443d = WorkStatus.WORKING;
        tt5.a.h("AbsLoadWork", ((String) this.f214442c.getValue()) + " [ start work ]");
        if (j.b() == false) goto L8;
        d();
        return;
    L8:
        j.f(new b(this));
    }

    public final void m() {
        this.f214443d = WorkStatus.DONE;
        tt5.a.h("AbsLoadWork", ((String) this.f214442c.getValue()) + " [[ work done ]]");
    }

    public AbsLoadWork(e r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "loadContext");
        Intrinsics.checkNotNullParameter(r101, "loadControl");
        this.f214440a = r100;
        this.f214441b = r101;
        this.f214442c = LazyKt.lazy(new AbsLoadWork$simpleName$2(this));
        this.f214443d = WorkStatus.PENDDING;
    }
}
