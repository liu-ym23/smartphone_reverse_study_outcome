package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public final int a;
    public final String b;
    public final int c;
    public final boolean d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L14;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        int r3 = (((r0 + r2) * 31) + this.c) * 31;
        boolean r4 = this.d;
        ?? r5 = r4;
        if (r4 == false) goto L10;
        r5 = 1;
    L10:
        return r3 + r5;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvChallengeSettingData(challengeType=" + this.a + ", content=" + this.b + ", settingType=" + this.c + ", isCustom=" + this.d + ")";
    }

    public a(int r2, String r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
