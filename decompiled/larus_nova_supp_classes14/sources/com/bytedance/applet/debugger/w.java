package com.bytedance.applet.debugger;

import com.bytedance.ai.api.DebuggerMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w {
    public final String a;
    public final String b;
    public final DebuggerMode c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L8;
        return false;
    L8:
        w r6 = (w) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "DebuggerConversationCreateRequest(botId=" + this.a + ", sourceConversationId=" + this.b + ", mode=" + this.c + ", entryFrom=" + this.d + ')';
    }

    public w(String r2, String r3, DebuggerMode r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        Intrinsics.checkNotNullParameter(r3, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r4, "mode");
        Intrinsics.checkNotNullParameter(r5, "entryFrom");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
