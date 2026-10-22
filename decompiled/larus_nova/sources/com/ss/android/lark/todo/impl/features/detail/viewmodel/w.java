package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.bytedance.lark.pb.todo.v1.TaskSection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskSection f443902a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f443902a, ((w) r100).f443902a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f443902a.hashCode();
    }

    public final String toString() {
        return "SectionItemCreateData(taskSection=" + this.f443902a + ')';
    }

    public w(TaskSection r100) {
        Intrinsics.checkNotNullParameter(r100, "taskSection");
        this.f443902a = r100;
    }
}
