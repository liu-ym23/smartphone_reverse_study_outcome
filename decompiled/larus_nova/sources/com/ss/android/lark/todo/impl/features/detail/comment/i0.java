package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i0 implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f442942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f442943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RichText f442944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<TodoAttachment> f442945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<TodoAttachment> f442946e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (this.f442942a == r101.f442942a) goto L12;
        return false;
    L12:
        if (this.f442943b == r101.f442943b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442944c, r101.f442944c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f442945d, r101.f442945d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f442946e, r101.f442946e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f442942a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f442943b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        RichText r104 = this.f442944c;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return ((((r103 + r105) * 31) + this.f442945d.hashCode()) * 31) + this.f442946e.hashCode();
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommentKeyboardStateInfo(isShow=" + this.f442942a + ", hasDraft=" + this.f442943b + ", richText=" + this.f442944c + ", imageAttachments=" + this.f442945d + ", fileAttachments=" + this.f442946e + ')';
    }

    public i0(boolean r100, boolean r101, RichText r102, List<TodoAttachment> r103, List<TodoAttachment> r104) {
        Intrinsics.checkNotNullParameter(r103, "imageAttachments");
        Intrinsics.checkNotNullParameter(r104, "fileAttachments");
        this.f442942a = r100;
        this.f442943b = r101;
        this.f442944c = r102;
        this.f442945d = r103;
        this.f442946e = r104;
    }
}
