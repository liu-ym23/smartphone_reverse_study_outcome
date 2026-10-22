package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.bytedance.lark.pb.todo.v1.TodoOrigin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TodoOrigin f443890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f443891b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f443890a, r101.f443890a) == true) goto L12;
        return false;
    L12:
        if (this.f443891b == r101.f443891b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f443890a.hashCode() * 31;
        if (this.f443891b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OriginInfo(todoOrigin=" + this.f443890a + ", originVisible=" + this.f443891b + ')';
    }

    public q(TodoOrigin r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "todoOrigin");
        this.f443890a = r100;
        this.f443891b = r101;
    }
}
