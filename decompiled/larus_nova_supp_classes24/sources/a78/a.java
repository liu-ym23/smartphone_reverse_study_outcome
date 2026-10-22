package a78;

import com.larus.audio.call.plugins.RealtimeCallSubtitlePlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final String i;
    public final RealtimeCallSubtitlePlugin.b j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + this.e) * 31;
        int r13 = 1231;
        if (this.f == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.g == true) goto L26;
        r13 = 1237;
    L26:
        int r16 = (((((r15 + r13) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        RealtimeCallSubtitlePlugin.b r17 = this.j;
        if (r17 == null) goto L31;
        r1 = r17.hashCode();
    L31:
        return r16 + r1;
    L21:
        r14 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "TTSSubtitleData(sectionId=" + this.a + ", messageId=" + this.b + ", text=" + this.c + ", ttsTaskId=" + this.d + ", isFromHello=" + this.e + ", needReplace=" + this.f + ", useTextContent=" + this.g + ", queryRound=" + this.h + ", questionId=" + this.i + ", blockContent=" + this.j + ')';
    }

    public a(String r2, String r3, String r4, String r5, int r6, boolean r7, boolean r8, String r9, String r10, RealtimeCallSubtitlePlugin.b r11) {
        Intrinsics.checkNotNullParameter(r9, "queryRound");
        Intrinsics.checkNotNullParameter(r10, "questionId");
        this.a = r2;
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

    public /* synthetic */ a(String r15, String r16, String r17, String r19, int r110, boolean r20, boolean r21, String r22, String r23, RealtimeCallSubtitlePlugin.b r24, int r25) {
        if ((r25 & 16) == 0) goto L5;
        int r8 = 0;
    L7:
        if ((r25 & 32) == 0) goto L9;
        boolean r9 = false;
    L11:
        if ((r25 & 64) == 0) goto L13;
        boolean r10 = false;
    L15:
        if ((r25 & 128) == 0) goto L17;
        String r11 = "";
    L19:
        if ((r25 & 256) == 0) goto L21;
        String r12 = "";
    L22:
        this(r15, r16, r17, r19, r8, r9, r10, r11, r12, r24);
        return;
    L21:
        r12 = r23;
        goto L22
    L17:
        r11 = r22;
        goto L19
    L13:
        r10 = r21;
        goto L15
    L9:
        r9 = r20;
        goto L11
    L5:
        r8 = r110;
        goto L7
    }
}
