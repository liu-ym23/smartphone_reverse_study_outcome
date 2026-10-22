package bw3;

import com.bytedance.applet.audio.inner.InnerAudioPlaybackState;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h0 {
    public final String a;
    public String b;
    public boolean c;
    public boolean d;
    public boolean e;
    public double f;
    public double g;
    public double h;
    public boolean i;
    public double j;
    public double k;
    public double l;
    public InnerAudioPlaybackState m;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r9 = (h0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Double.compare(this.f, r9.f) == 0) goto L27;
        return false;
    L27:
        if (Double.compare(this.g, r9.g) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.h, r9.h) == 0) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Double.compare(this.j, r9.j) == 0) goto L39;
        return false;
    L39:
        if (Double.compare(this.k, r9.k) == 0) goto L42;
        return false;
    L42:
        if (Double.compare(this.l, r9.l) == 0) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        int r4 = 1231;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.d == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.e == false) goto L17;
        int r9 = 1231;
    L18:
        long r10 = Double.doubleToLongBits(this.f);
        int r11 = (((r8 + r9) * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = Double.doubleToLongBits(this.g);
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        long r14 = Double.doubleToLongBits(this.h);
        int r15 = (r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31;
        if (this.i == true) goto L22;
        r4 = 1237;
    L22:
        int r16 = (r15 + r4) * 31;
        long r17 = Double.doubleToLongBits(this.j);
        int r18 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        long r19 = Double.doubleToLongBits(this.k);
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        long r21 = Double.doubleToLongBits(this.l);
        return ((r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31) + this.m.hashCode();
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "InnerAudioState(audioId=" + this.a + ", src=" + this.b + ", autoplay=" + this.c + ", loop=" + this.d + ", obeyMuteSwitch=" + this.e + ", startTime=" + this.f + ", currentTime=" + this.g + ", duration=" + this.h + ", paused=" + this.i + ", buffered=" + this.j + ", volume=" + this.k + ", playbackRate=" + this.l + ", playbackState=" + this.m + ')';
    }

    public final String b() {
        String[] r0 = new String[10];
        boolean r2 = false;
        r0[0] = "audioId: " + this.a;
        StringBuilder r1 = new StringBuilder("hasSrc: ");
        String r3 = this.b;
        if (r3 != null) goto L5;
    L7:
        r1.append(r2);
        r0[1] = r1.toString();
        r0[2] = "state: " + this.m.getValue();
        r0[3] = "paused: " + this.i;
        r0[4] = "startTime: " + i0.a(this.f);
        r0[5] = "currentTime: " + i0.a(this.g);
        r0[6] = "duration: " + i0.a(this.h);
        r0[7] = "buffered: " + i0.a(this.j);
        r0[8] = "volume: " + i0.a(this.k);
        r0[9] = "playbackRate: " + i0.a(this.l);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r0), ", ", null, null, 0, null, null, 62, null);
    L5:
        if ((!StringsKt.isBlank(r3)) != true) goto L7;
        r2 = true;
        goto L7
    }

    public static h0 a(h0 r23) {
        String r1 = r23.a;
        String r2 = r23.b;
        boolean r3 = r23.c;
        boolean r4 = r23.d;
        boolean r5 = r23.e;
        double r6 = r23.f;
        double r8 = r23.g;
        double r10 = r23.h;
        boolean r12 = r23.i;
        double r13 = r23.j;
        double r14 = r23.k;
        double r15 = r23.l;
        InnerAudioPlaybackState r16 = r23.m;
        r23.getClass();
        Intrinsics.checkNotNullParameter(r1, "audioId");
        Intrinsics.checkNotNullParameter(r16, "playbackState");
        return new h0(r1, r2, r3, r4, r5, r6, r8, r10, r12, r13, r14, r15, r16);
    }

    public final void d(InnerAudioPlaybackState r2) {
        Intrinsics.checkNotNullParameter(r2, "nextPlaybackState");
        this.m = r2;
        if (r2 == InnerAudioPlaybackState.PLAYING) goto L5;
        boolean r3 = true;
    L6:
        this.i = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static void c(h0 r0, double r1, double r3) {
        r0.getClass();
        r0.g = i0.b(r1);
        r0.h = i0.b(r3);
        r0.j = i0.b(r3);
    }

    public h0(String r6, String r7, boolean r8, boolean r9, boolean r10, double r11, double r13, double r15, boolean r17, double r18, double r20, double r22, InnerAudioPlaybackState r24) {
        Intrinsics.checkNotNullParameter(r6, "audioId");
        Intrinsics.checkNotNullParameter(r24, "playbackState");
        this.a = r6;
        this.b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r13;
        this.h = r15;
        this.i = r17;
        this.j = r18;
        this.k = r20;
        this.l = r22;
        this.m = r24;
    }
}
