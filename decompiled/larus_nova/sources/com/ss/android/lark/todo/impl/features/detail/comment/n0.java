package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n0 implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichText f442966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<TodoAttachment> f442967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TodoAttachment> f442968c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f442966a, r101.f442966a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f442967b, r101.f442967b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442968c, r101.f442968c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        RichText r100 = this.f442966a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f442967b.hashCode()) * 31) + this.f442968c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "CommentSaveDraftInfo(richText=" + this.f442966a + ", imageAttachments=" + this.f442967b + ", fileAttachments=" + this.f442968c + ')';
    }

    public n0(RichText r100, List<TodoAttachment> r101, List<TodoAttachment> r102) {
        Intrinsics.checkNotNullParameter(r101, "imageAttachments");
        Intrinsics.checkNotNullParameter(r102, "fileAttachments");
        this.f442966a = r100;
        this.f442967b = r101;
        this.f442968c = r102;
    }
}
