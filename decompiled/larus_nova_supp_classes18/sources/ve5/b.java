package ve5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final long a;
    public final boolean b;
    public final String c;
    public final String d;
    public final Long e;
    public final String f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final long j;

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
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        int r3 = 1231;
        if (this.b == false) goto L5;
        int r2 = 1231;
    L6:
        int r4 = (r1 + r2) * 31;
        String r5 = this.c;
        int r6 = 0;
        if (r5 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r4 + r7) * 31;
        String r9 = this.d;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r8 + r10) * 31;
        Long r12 = this.e;
        if (r12 != null) goto L17;
        int r13 = 0;
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.f;
        if (r15 == null) goto L22;
        r6 = r15.hashCode();
    L22:
        int r16 = (r14 + r6) * 31;
        if (this.g == false) goto L25;
        int r17 = 1231;
    L26:
        int r18 = (r16 + r17) * 31;
        if (this.h == false) goto L29;
        int r19 = 1231;
    L30:
        int r20 = (r18 + r19) * 31;
        if (this.i == true) goto L34;
        r3 = 1237;
    L34:
        int r21 = (r20 + r3) * 31;
        long r22 = this.j;
        return r21 + ((int) (r22 ^ (r22 >>> 32)));
    L29:
        r19 = 1237;
        goto L30
    L25:
        r17 = 1237;
        goto L26
    L17:
        r13 = r12.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r5.hashCode();
        goto L10
    L5:
        r2 = 1237;
        goto L6
    }

    public final String toString() {
        return "BotConfigCacheEntry(botId=" + this.a + ", finishedConfig=" + this.b + ", authUrl=" + this.c + ", deviceCode=" + this.d + ", deviceCodeExpireTime=" + this.e + ", helpDocUrl=" + this.f + ", isStoreApp=" + this.g + ", isAppManager=" + this.h + ", hasAppVisibility=" + this.i + ", fetchedAt=" + this.j + ')';
    }

    public b(long r1, boolean r3, String r4, String r5, Long r6, String r7, boolean r8, boolean r9, boolean r10, long r11) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
