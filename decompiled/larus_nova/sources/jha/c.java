package jha;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskFlowDispatchStrategy f499124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f499125b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f499124a == r101.f499124a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f499125b, r101.f499125b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f499124a.hashCode() * 31) + this.f499125b.hashCode();
    }

    public final String toString() {
        return "TaskFlowDispatchPolicy(strategy=" + this.f499124a + ", orderingDomain=" + this.f499125b + ')';
    }

    public c(TaskFlowDispatchStrategy r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "orderingDomain");
        this.f499124a = r100;
        this.f499125b = r101;
    }
}
