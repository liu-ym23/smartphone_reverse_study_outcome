package com.larus.office.card.urlpreview;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f361861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f361862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<s> f361863c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (Intrinsics.areEqual(this.f361861a, r101.f361861a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f361862b, r101.f361862b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f361863c, r101.f361863c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f361861a.hashCode() * 31) + this.f361862b.hashCode()) * 31) + this.f361863c.hashCode();
    }

    public final String toString() {
        return "OfficeUrlPreviewMessageSnapshot(messageIdentity=" + this.f361861a + ", message=" + this.f361862b + ", blocks=" + this.f361863c + ')';
    }

    public b1(String r100, Message r101, List<s> r102) {
        Intrinsics.checkNotNullParameter(r100, "messageIdentity");
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "blocks");
        this.f361861a = r100;
        this.f361862b = r101;
        this.f361863c = r102;
    }
}
