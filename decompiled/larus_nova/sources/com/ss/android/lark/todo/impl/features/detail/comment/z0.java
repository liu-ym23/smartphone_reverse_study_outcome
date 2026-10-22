package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.todo.v1.TodoComment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TodoComment f443017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f443018b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f443017a, r101.f443017a) == true) goto L12;
        return false;
    L12:
        if (this.f443018b == r101.f443018b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f443017a.hashCode() * 31;
        if (this.f443018b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TodoCommentData(todoComment=" + this.f443017a + ", isExpand=" + this.f443018b + ')';
    }

    public z0(TodoComment r100) {
        Intrinsics.checkNotNullParameter(r100, "todoComment");
        this.f443017a = r100;
        this.f443018b = false;
    }
}
