package com.ss.android.lark.todo.impl.features.detail.sections;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskContainer f443414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskSection f443415b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o1) == true) goto L8;
        return false;
    L8:
        o1 r101 = (o1) r100;
        if (Intrinsics.areEqual(this.f443414a, r101.f443414a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443415b, r101.f443415b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f443414a.hashCode() * 31;
        TaskSection r101 = this.f443415b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TaskListSectionItem(container=" + this.f443414a + ", section=" + this.f443415b + ')';
    }

    public o1(TaskContainer r100, TaskSection r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f443414a = r100;
        this.f443415b = r101;
    }
}
