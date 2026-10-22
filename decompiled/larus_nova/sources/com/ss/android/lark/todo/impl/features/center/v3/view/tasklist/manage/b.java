package com.ss.android.lark.todo.impl.features.center.v3.view.tasklist.manage;

import com.larksuite.arch.jack.j;
import com.ss.android.lark.todo.impl.adapterhelper.loadmodule.PageLoadingStatus;
import com.ss.android.lark.todo.impl.features.center.v3.viewmodel.TaskListDisplayData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskListDisplayData f442115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PageLoadingStatus f442116b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f442115a, r101.f442115a) == true) goto L12;
        return false;
    L12:
        if (this.f442116b == r101.f442116b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f442115a.hashCode() * 31) + this.f442116b.hashCode();
    }

    public final String toString() {
        return "TaskListManageState(taskListDisplayData=" + this.f442115a + ", loadMoreStatus=" + this.f442116b + ')';
    }

    public b(TaskListDisplayData r100, PageLoadingStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "taskListDisplayData");
        Intrinsics.checkNotNullParameter(r101, "loadMoreStatus");
        this.f442115a = r100;
        this.f442116b = r101;
    }
}
