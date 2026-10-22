package sh2;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final /* synthetic */ int k = 0;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final b i;
    public final IntroCardScene j;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L26;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r4.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v32 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.h;
        ?? r23 = r22;
        if (r22 == false) goto L33;
        r23 = 1;
    L33:
        int r24 = (r21 + r23) * 31;
        b r25 = this.i;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        IntroCardScene r28 = this.j;
        if (r28 == null) goto L41;
        r1 = r28.hashCode();
    L41:
        return r27 + r1;
    L36:
        r26 = 0;
        goto L37
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveIntroRequest(forcePath=" + this.a + ", roomId=" + this.b + ", roomUniqueKey=" + this.c + ", groupId=" + this.d + ", authorId=" + this.e + ", secAuthorId=" + this.f + ", entranceInfo=" + this.g + ", isRetry=" + this.h + ", productInfo=" + this.i + ", cardScene=" + this.j + ")";
    }

    public d(String r2, String r3, String r4, String r5, String r6, String r7, String r8, boolean r9, b r10, IntroCardScene r11) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "roomUniqueKey");
        Intrinsics.checkNotNullParameter(r6, "authorId");
        Intrinsics.checkNotNullParameter(r7, "secAuthorId");
        Intrinsics.checkNotNullParameter(r8, "entranceInfo");
        Intrinsics.checkNotNullParameter(r11, "cardScene");
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
}
