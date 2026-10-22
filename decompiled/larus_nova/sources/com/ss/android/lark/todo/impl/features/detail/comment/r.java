package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichText f442978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TodoAttachment> f442979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TodoAttachment> f442980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f442981d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f442978a, r101.f442978a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f442979b, r101.f442979b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442980c, r101.f442980c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f442981d, r101.f442981d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        RichText r100 = this.f442978a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f442979b.hashCode()) * 31) + this.f442980c.hashCode()) * 31;
        String r104 = this.f442981d;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentDraftInfo(richText=" + this.f442978a + ", imageAttachments=" + this.f442979b + ", fileAttachments=" + this.f442980c + ", replyParentId=" + this.f442981d + ')';
    }

    public r(RichText r100, List<TodoAttachment> r101, List<TodoAttachment> r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "imageAttachments");
        Intrinsics.checkNotNullParameter(r102, "fileAttachments");
        this.f442978a = r100;
        this.f442979b = r101;
        this.f442980c = r102;
        this.f442981d = r103;
    }
}
