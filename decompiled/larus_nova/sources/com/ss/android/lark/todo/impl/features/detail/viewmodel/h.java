package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAssigneeData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<TodoAssigneeData> f443881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskMode f443882b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f443881a, r101.f443881a) == true) goto L12;
        return false;
    L12:
        if (this.f443882b == r101.f443882b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f443881a.hashCode() * 31) + this.f443882b.hashCode();
    }

    public final String toString() {
        return "EditSubTaskInfo(assigneeData=" + this.f443881a + ", mode=" + this.f443882b + ')';
    }

    public h(List<TodoAssigneeData> r100, TaskMode r101) {
        Intrinsics.checkNotNullParameter(r100, "assigneeData");
        Intrinsics.checkNotNullParameter(r101, "mode");
        this.f443881a = r100;
        this.f443882b = r101;
    }
}
