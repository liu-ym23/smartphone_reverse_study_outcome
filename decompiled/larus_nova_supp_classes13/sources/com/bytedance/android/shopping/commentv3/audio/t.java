package com.bytedance.android.shopping.commentv3.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t {
    public final String a;
    public final String b;
    public final e c;
    public final ExternalAudioInterruptReason d;
    public final ExternalAudioTargetScope e;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof t) == false) goto L16;
        t r4 = (t) r3;
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
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

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
        e r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ExternalAudioInterruptReason r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        ExternalAudioTargetScope r13 = this.e;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "ExternalAudioRequest(ownerPage=" + this.a + ", sliceId=" + this.b + ", audioInfo=" + this.c + ", reason=" + this.d + ", targetScope=" + this.e + ")";
    }

    public t(String r3, e r4, ExternalAudioInterruptReason r5, ExternalAudioTargetScope r6) {
        Intrinsics.checkNotNullParameter("CommentFragment", "ownerPage");
        Intrinsics.checkNotNullParameter(r3, "sliceId");
        Intrinsics.checkNotNullParameter(r4, "audioInfo");
        Intrinsics.checkNotNullParameter(r5, "reason");
        Intrinsics.checkNotNullParameter(r6, "targetScope");
        this.a = "CommentFragment";
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
