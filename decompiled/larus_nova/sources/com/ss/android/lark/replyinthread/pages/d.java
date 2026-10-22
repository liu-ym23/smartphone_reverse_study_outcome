package com.ss.android.lark.replyinthread.pages;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f439519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageInfo f439520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f439521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f439522f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f439519c, r101.f439519c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f439520d, r101.f439520d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f439521e, r101.f439521e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f439522f, r101.f439522f) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f439519c.hashCode() * 31) + this.f439520d.hashCode()) * 31;
        String r101 = this.f439521e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f439522f;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PreviewVisitorThreadPageInfo(threadId=" + this.f439519c + ", previewMessage=" + this.f439520d + ", previewId=" + this.f439521e + ", msgLinkToken=" + this.f439522f + ')';
    }

    @Override // com.ss.android.lark.replyinthread.pages.f
    public final String a() {
        return this.f439519c;
    }

    public d(String r100, MessageInfo r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "threadId");
        Intrinsics.checkNotNullParameter(r101, "previewMessage");
        super(3, r100);
        this.f439519c = r100;
        this.f439520d = r101;
        this.f439521e = r102;
        this.f439522f = r103;
    }
}
