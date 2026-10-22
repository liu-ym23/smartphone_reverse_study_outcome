package com.ss.android.lark.todo.impl.features.detail.sections;

import com.bytedance.lark.pb.todo.v1.TodoReferResource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TodoReferResource f443462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f443463b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r101 = (w0) r100;
        if (Intrinsics.areEqual(this.f443462a, r101.f443462a) == true) goto L12;
        return false;
    L12:
        if (this.f443463b == r101.f443463b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f443462a.hashCode() * 31;
        if (this.f443463b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MergeInfo(todoResource=" + this.f443462a + ", editable=" + this.f443463b + ')';
    }

    public w0(TodoReferResource r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "todoResource");
        this.f443462a = r100;
        this.f443463b = r101;
    }
}
