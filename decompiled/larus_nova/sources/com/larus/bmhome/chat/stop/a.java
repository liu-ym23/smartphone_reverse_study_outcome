package com.larus.bmhome.chat.stop;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f309950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Message f309951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Message> f309952c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f309950a, r101.f309950a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309951b, r101.f309951b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309952c, r101.f309952c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f309950a.hashCode() * 31) + this.f309951b.hashCode()) * 31) + this.f309952c.hashCode();
    }

    public final String toString() {
        return "BreakTarget(activeReply=" + this.f309950a + ", senderQuery=" + this.f309951b + ", targetMessages=" + this.f309952c + ')';
    }

    public a(Message r100, Message r101, List<Message> r102) {
        Intrinsics.checkNotNullParameter(r100, "activeReply");
        Intrinsics.checkNotNullParameter(r101, "senderQuery");
        Intrinsics.checkNotNullParameter(r102, "targetMessages");
        this.f309950a = r100;
        this.f309951b = r101;
        this.f309952c = r102;
    }
}
