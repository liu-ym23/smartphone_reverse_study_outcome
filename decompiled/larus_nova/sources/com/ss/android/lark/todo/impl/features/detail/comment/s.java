package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.todo.v1.TodoComment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TodoComment f442986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TodoComment f442987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f442988c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f442986a, r101.f442986a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f442987b, r101.f442987b) == true) goto L15;
        return false;
    L15:
        if (this.f442988c == r101.f442988c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        TodoComment r100 = this.f442986a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f442987b.hashCode()) * 31) + this.f442988c;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "CommentEditInfo(editComment=" + this.f442986a + ", itemComment=" + this.f442987b + ", position=" + this.f442988c + ')';
    }

    public s(TodoComment r100, TodoComment r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "itemComment");
        this.f442986a = r100;
        this.f442987b = r101;
        this.f442988c = r102;
    }
}
