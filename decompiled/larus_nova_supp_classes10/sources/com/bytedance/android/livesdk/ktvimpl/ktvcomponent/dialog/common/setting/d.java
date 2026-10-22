package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public d() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L16;
        d r4 = (d) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (this.d == r4.d) goto L14;
        return false;
    L14:
        if (this.e == r4.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L11;
        r8 = 1;
    L11:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.d;
        ?? r11 = r10;
        if (r10 == false) goto L14;
        r11 = 1;
    L14:
        int r12 = (r9 + r11) * 31;
        boolean r13 = this.e;
        if (r13 == true) goto L19;
        r1 = r13;
    L19:
        return r12 + r1;
    }

    public final String toString() {
        return "KSongSettingKey(openAudienceAddSongSwitch=" + this.a + ", openAudienceMultiChorusSwitch=" + this.b + ", canAutoTurnOnSingChallenge=" + this.c + ", hideLyricsWhenSubtitleOpenSwitch=" + this.d + ", openRealtimeChorusSwitch=" + this.e + ")";
    }

    public /* synthetic */ d(int r7) {
        this(false, false, false, false, false);
    }

    public d(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public static d a(d r6, boolean r7, boolean r8, boolean r9, boolean r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        r7 = r6.a;
    L5:
        boolean r1 = r7;
        if ((r11 & 2) == 0) goto L8;
        r8 = r6.b;
    L8:
        boolean r2 = r8;
        if ((r11 & 4) == 0) goto L11;
        boolean r3 = r6.c;
    L13:
        if ((r11 & 8) == 0) goto L15;
        r9 = r6.d;
    L15:
        boolean r4 = r9;
        if ((r11 & 16) == 0) goto L18;
        r10 = r6.e;
    L18:
        r6.getClass();
        return new d(r1, r2, r3, r4, r10);
    L11:
        r3 = false;
        goto L13
    }
}
