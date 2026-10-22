package cp9;

import com.larus.perfdegrade.api.model.PerfDegradeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PerfDegradeType f464726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464727b;

    /* JADX INFO: renamed from: cp9.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes29.dex */
    public static final class C5567a {
        public final int hashCode() {
            throw null;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f464726a == r101.f464726a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464727b, r101.f464727b) == true) goto L14;
        return false;
    L14:
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f464726a.hashCode() * 31) + this.f464727b.hashCode()) * 31) + 0;
    }

    public final String toString() {
        return "PerfDegradeRequest(type=" + this.f464726a + ", scene=" + this.f464727b + ", debugOptions=null)";
    }

    public final PerfDegradeType getType() {
        return this.f464726a;
    }

    public a(PerfDegradeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter("INIT_PERF_DEGRADE_TRIGGER_TASK", "scene");
        this.f464726a = r100;
        this.f464727b = "INIT_PERF_DEGRADE_TRIGGER_TASK";
    }
}
