package com.larus.bmhome.chat.manager;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Message f306711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f306712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f306713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f306714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f306715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f306716f;

    public d0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d0) == true) goto L8;
        return false;
    L8:
        d0 r101 = (d0) r100;
        if (Intrinsics.areEqual(this.f306711a, r101.f306711a) == true) goto L12;
        return false;
    L12:
        if (this.f306712b == r101.f306712b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f306713c, r101.f306713c) == true) goto L18;
        return false;
    L18:
        if (this.f306714d == r101.f306714d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f306715e, r101.f306715e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f306716f, r101.f306716f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f306711a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f306712b) * 31;
        String r104 = this.f306713c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f306714d) * 31;
        String r107 = this.f306715e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f306716f;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatPositionData(pendingUnreadMsg=" + this.f306711a + ", pendingUnreadVisibleHeight=" + this.f306712b + ", currentSessionLatestUserMsgId=" + this.f306713c + ", pendingUnreadContentHeight=" + this.f306714d + ", consumedPendingUnreadMsgId=" + this.f306715e + ", consumedPendingUnreadLocalMessageId=" + this.f306716f + ')';
    }

    public d0(int r100) {
        this.f306711a = null;
        this.f306712b = 0;
        this.f306713c = null;
        this.f306714d = -1;
        this.f306715e = null;
        this.f306716f = null;
    }
}
