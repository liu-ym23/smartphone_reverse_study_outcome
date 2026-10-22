package com.ss.android.lark.todo.impl.features.detail.comment;

import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o0 implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f442970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RichText f442971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TodoAttachment> f442972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<TodoAttachment> f442973d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f442970a, r101.f442970a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f442971b, r101.f442971b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442972c, r101.f442972c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f442973d, r101.f442973d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f442970a.hashCode() * 31) + this.f442971b.hashCode()) * 31) + this.f442972c.hashCode()) * 31) + this.f442973d.hashCode();
    }

    public final String toString() {
        return "CommentSendInfo(content=" + this.f442970a + ", richText=" + this.f442971b + ", imageAttachments=" + this.f442972c + ", fileAttachments=" + this.f442973d + ')';
    }

    public o0(String r100, RichText r101, List<TodoAttachment> r102, List<TodoAttachment> r103) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "richText");
        Intrinsics.checkNotNullParameter(r102, "imageAttachments");
        Intrinsics.checkNotNullParameter(r103, "fileAttachments");
        this.f442970a = r100;
        this.f442971b = r101;
        this.f442972c = r102;
        this.f442973d = r103;
    }
}
