package com.ss.android.lark.replyinthread.pages;

import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f439508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f439509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f439510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MergeForwardContent f439511f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f439508c, r101.f439508c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f439509d, r101.f439509d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f439510e, r101.f439510e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f439511f, r101.f439511f) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f439508c.hashCode() * 31) + this.f439509d.hashCode()) * 31) + this.f439510e.hashCode()) * 31) + this.f439511f.hashCode();
    }

    public final String toString() {
        return "MergeForwardVisitorThreadPageInfo(threadId=" + this.f439508c + ", rootMessageId=" + this.f439509d + ", originMergeForwardMessageId=" + this.f439510e + ", parentMessageContent=" + this.f439511f + ')';
    }

    @Override // com.ss.android.lark.replyinthread.pages.f
    public final String a() {
        return this.f439508c;
    }

    public c(String r100, String r101, String r102, MergeForwardContent r103) {
        Intrinsics.checkNotNullParameter(r100, "threadId");
        Intrinsics.checkNotNullParameter(r101, "rootMessageId");
        Intrinsics.checkNotNullParameter(r102, "originMergeForwardMessageId");
        Intrinsics.checkNotNullParameter(r103, "parentMessageContent");
        super(2, r100);
        this.f439508c = r100;
        this.f439509d = r101;
        this.f439510e = r102;
        this.f439511f = r103;
    }
}
