package com.bytedance.applet.event;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class EventDispatcher$a {
    public final String a;
    public volatile boolean b;
    public volatile boolean c;
    public volatile boolean d;
    public final List<Object> e;
    public String f;

    public EventDispatcher$a() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EventDispatcher$a) == true) goto L8;
        return false;
    L8:
        EventDispatcher$a r6 = (EventDispatcher$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.d == true) goto L14;
        r2 = 1237;
    L14:
        int r6 = (((r5 + r2) * 31) + this.e.hashCode()) * 31;
        String r7 = this.f;
        if (r7 != null) goto L17;
        int r8 = 0;
    L19:
        return r6 + r8;
    L17:
        r8 = r7.hashCode();
        goto L19
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "BotConfig(botId=" + this.a + ", sendOn=" + this.b + ", receiveOn=" + this.c + ", bridgeIndicationOn=" + this.d + ", listeners=" + this.e + ", currReplyId=" + this.f + ')';
    }

    public EventDispatcher$a(String r3) {
        ArrayList r0 = new ArrayList();
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r0, "listeners");
        this.a = r3;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = r0;
        this.f = null;
    }
}
