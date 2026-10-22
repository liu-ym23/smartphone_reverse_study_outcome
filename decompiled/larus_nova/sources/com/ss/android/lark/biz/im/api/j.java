package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.export.entity.message.Content;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f410255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Content> f410256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f410257c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f410255a, r101.f410255a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410256b, r101.f410256b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410257c, r101.f410257c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f410255a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f410256b.hashCode()) * 31) + this.f410257c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoubaoMergeForwardVO(msg=" + this.f410255a + ", subContentList=" + this.f410256b + ", title=" + this.f410257c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Message r100, List<? extends Content> r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "subContentList");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f410255a = r100;
        this.f410256b = r101;
        this.f410257c = r102;
    }
}
