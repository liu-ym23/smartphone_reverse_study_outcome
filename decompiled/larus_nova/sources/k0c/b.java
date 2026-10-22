package k0c;

import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passportc.task.TaskType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskType f501292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0c.c f501293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f501294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f501295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap<String, C6497b> f501296e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f501297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public StepTrace f501298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f501299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f501300d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f501301e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f501302f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f501303g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f501304h;

        public a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "task");
            this.f501297a = r100;
        }
    }

    /* JADX INFO: renamed from: k0c.b$b, reason: collision with other inner class name */
    public static final class C6497b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f501305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f501306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f501307c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f501308d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6497b) == true) goto L8;
            return false;
        L8:
            C6497b r101 = (C6497b) r100;
            if (this.f501305a == r101.f501305a) goto L12;
            return false;
        L12:
            if (this.f501306b == r101.f501306b) goto L15;
            return false;
        L15:
            if (this.f501307c == r101.f501307c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f501305a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f501306b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f501307c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        }

        public final String toString() {
            return "TaskCostPayload(executeCost=" + this.f501305a + ", runCost=" + this.f501306b + ", waitTime=" + this.f501307c + ')';
        }

        public C6497b(long r100, long r101, long r102) {
            this.f501305a = r100;
            this.f501306b = r101;
            this.f501307c = r102;
            this.f501308d = r100 + r101;
        }
    }

    public final void a(a r110) {
        Intrinsics.checkNotNullParameter(r110, "singleTaskTracker");
        d r100 = r110.f501297a;
        C6497b r101 = new C6497b(r110.f501302f, r110.f501304h, r110.f501300d);
        this.f501295d += r101.f501308d;
        this.f501296e.put(r100.getTask().F().f496844a, r101);
        if (this.f501292a != TaskType.OFFLINE) goto L5;
        String r111 = "rust_infra_offline_task";
    L6:
        l0c.c r102 = this.f501293b;
        if (r102 == null) goto L10;
        r102.c(r111 + '_' + r100.getTask().F(), r101.f501308d);
        return;
    L10:
        return;
    L5:
        r111 = "rust_infra_online_task";
        goto L6
    }

    public b(TaskType r100, l0c.c r101) {
        Intrinsics.checkNotNullParameter(r100, "taskType");
        this.f501292a = r100;
        this.f501293b = r101;
        this.f501296e = new ConcurrentHashMap();
    }
}
