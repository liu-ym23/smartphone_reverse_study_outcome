package com.larus.platform.model.chat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageModifyStyle f365575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f365576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f365577c;

    public f0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f365575a == r101.f365575a) goto L12;
        return false;
    L12:
        if (this.f365576b == r101.f365576b) goto L15;
        return false;
    L15:
        if (this.f365577c == r101.f365577c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365575a.hashCode() * 31;
        int r101 = 1231;
        if (this.f365576b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f365577c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageModifyConfig(style=" + this.f365575a + ", historyMsgEditable=" + this.f365576b + ", offlineMsgEditable=" + this.f365577c + ')';
    }

    public /* synthetic */ f0(int r100) {
        this(MessageModifyStyle.SMALL_BOX, false, false);
    }

    public f0(MessageModifyStyle r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f365575a = r100;
        this.f365576b = r101;
        this.f365577c = r102;
    }
}
