package com.ss.android.lark.todo.impl.features.detail.comment;

import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoComment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j0 implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f442949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f442950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TodoComment f442951c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f442949a, r101.f442949a) == true) goto L12;
        return false;
    L12:
        if (this.f442950b == r101.f442950b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442951c, r101.f442951c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f442949a.hashCode() * 31) + this.f442950b) * 31) + this.f442951c.hashCode();
    }

    public final String toString() {
        return "CommentPanelInfo(itemView=" + this.f442949a + ", position=" + this.f442950b + ", todoComment=" + this.f442951c + ')';
    }

    public j0(View r100, int r101, TodoComment r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r102, "todoComment");
        this.f442949a = r100;
        this.f442950b = r101;
        this.f442951c = r102;
    }
}
