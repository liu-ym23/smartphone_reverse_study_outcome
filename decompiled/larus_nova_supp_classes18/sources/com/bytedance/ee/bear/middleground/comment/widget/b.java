package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final long a;
    public final String b;
    public final BotAtHintActionType c;
    public final String d;
    public final String e;
    public final Long f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r2 = this.d;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.e;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        Long r9 = this.f;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        return r8 + r3;
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotAtHintInfo(botId=" + this.a + ", botName=" + this.b + ", actionType=" + this.c + ", actionUrl=" + this.d + ", deviceCode=" + this.e + ", deviceCodeExpireTime=" + this.f + ')';
    }

    public b(long r2, String r4, BotAtHintActionType r5, String r6, String r7, Long r8) {
        Intrinsics.checkNotNullParameter(r4, "botName");
        Intrinsics.checkNotNullParameter(r5, "actionType");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
