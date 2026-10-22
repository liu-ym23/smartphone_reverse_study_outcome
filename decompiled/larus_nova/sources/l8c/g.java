package l8c;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskContainer f508093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f508094b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f508093a, r101.f508093a) == true) goto L12;
        return false;
    L12:
        if (this.f508094b == r101.f508094b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f508093a.hashCode() * 31;
        if (this.f508094b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TaskListSelectItem(container=" + this.f508093a + ", isCreateItem=" + this.f508094b + ')';
    }

    public g(TaskContainer r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f508093a = r100;
        this.f508094b = r101;
    }
}
