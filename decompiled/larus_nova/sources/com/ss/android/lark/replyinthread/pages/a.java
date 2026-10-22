package com.ss.android.lark.replyinthread.pages;

import com.ss.android.lark.chat.entity.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f439502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f439503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f439504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Message f439505f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f439502c, r101.f439502c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f439503d, r101.f439503d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f439504e, r101.f439504e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f439505f, r101.f439505f) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f439502c.hashCode() * 31) + this.f439503d.hashCode()) * 31;
        Message r101 = this.f439504e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Message r105 = this.f439505f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardVisitorThreadPageInfo(threadId=" + this.f439502c + ", originMergeForwardMessageId=" + this.f439503d + ", mergeForwardMessage=" + this.f439504e + ", translateMessage=" + this.f439505f + ')';
    }

    @Override // com.ss.android.lark.replyinthread.pages.f
    public final String a() {
        return this.f439502c;
    }

    public a(String r100, String r101, Message r102, Message r103) {
        Intrinsics.checkNotNullParameter(r100, "threadId");
        Intrinsics.checkNotNullParameter(r101, "originMergeForwardMessageId");
        super(1, r100);
        this.f439502c = r100;
        this.f439503d = r101;
        this.f439504e = r102;
        this.f439505f = r103;
    }
}
