package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.bytedance.lark.pb.todo.v1.TaskContainerRef;
import com.bytedance.lark.pb.todo.v1.TaskSection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskContainer f443877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<TaskSection> f443878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TaskSection f443879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TaskContainerRef f443880d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f443877a, r101.f443877a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443878b, r101.f443878b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f443879c, r101.f443879c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f443880d, r101.f443880d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f443877a.hashCode() * 31) + this.f443878b.hashCode()) * 31;
        TaskSection r101 = this.f443879c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f443880d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DetailTaskListItem(taskContainer=" + this.f443877a + ", sections=" + this.f443878b + ", selectSection=" + this.f443879c + ", ref=" + this.f443880d + ')';
    }

    public g(TaskContainer r100, List<TaskSection> r101, TaskSection r102, TaskContainerRef r103) {
        Intrinsics.checkNotNullParameter(r100, "taskContainer");
        Intrinsics.checkNotNullParameter(r101, "sections");
        Intrinsics.checkNotNullParameter(r103, TemplateNodeType.REF);
        this.f443877a = r100;
        this.f443878b = r101;
        this.f443879c = r102;
        this.f443880d = r103;
    }
}
