package aw3;

import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q0 {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public double g;
    public double h;
    public double i;
    public boolean j;
    public double k;
    public double l;
    public BackgroundAudioPlaybackState m;

    public q0() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r9 = (q0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
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
        if (Double.compare(this.g, r9.g) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.h, r9.h) == 0) goto L33;
        return false;
    L33:
        if (Double.compare(this.i, r9.i) == 0) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
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
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        int r17 = (r15 + r1) * 31;
        long r18 = Double.doubleToLongBits(this.g);
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        long r20 = Double.doubleToLongBits(this.h);
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        long r22 = Double.doubleToLongBits(this.i);
        int r23 = (r21 + ((int) (r22 ^ (r22 >>> 32)))) * 31;
        if (this.j == false) goto L29;
        int r24 = 1231;
    L30:
        int r25 = (r23 + r24) * 31;
        long r26 = Double.doubleToLongBits(this.k);
        int r27 = (r25 + ((int) (r26 ^ (r26 >>> 32)))) * 31;
        long r28 = Double.doubleToLongBits(this.l);
        return ((r27 + ((int) (r28 ^ (r28 >>> 32)))) * 31) + this.m.hashCode();
    L29:
        r24 = 1237;
        goto L30
    L21:
        r14 = r13.hashCode();
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
        return "BackgroundAudioState(src=" + this.a + ", title=" + this.b + ", epname=" + this.c + ", singer=" + this.d + ", coverImgUrl=" + this.e + ", webUrl=" + this.f + ", startTime=" + this.g + ", currentTime=" + this.h + ", duration=" + this.i + ", paused=" + this.j + ", buffered=" + this.k + ", playbackRate=" + this.l + ", playbackState=" + this.m + ')';
    }

    public final String b() {
        String[] r0 = new String[10];
        StringBuilder r1 = new StringBuilder("hasSrc: ");
        String r2 = this.a;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L10:
        boolean r4 = false;
    L11:
        r1.append(r4);
        r0[0] = r1.toString();
        StringBuilder r5 = new StringBuilder("hasTitle: ");
        String r6 = this.b;
        if (r6 != null) goto L14;
    L19:
        boolean r7 = false;
    L20:
        r5.append(r7);
        r0[1] = r5.toString();
        StringBuilder r8 = new StringBuilder("hasCover: ");
        String r9 = this.e;
        if (r9 != null) goto L23;
    L28:
        r3 = false;
    L29:
        r8.append(r3);
        r0[2] = r8.toString();
        r0[3] = "state: " + this.m.getValue();
        r0[4] = "paused: " + this.j;
        r0[5] = "startTime: " + r0.a(this.g);
        r0[6] = "currentTime: " + r0.a(this.h);
        r0[7] = "duration: " + r0.a(this.i);
        r0[8] = "buffered: " + r0.a(this.k);
        r0[9] = "playbackRate: " + r0.a(this.l);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r0), ", ", null, null, 0, null, null, 62, null);
    L23:
        if (r9.length() <= 0) goto L25;
        boolean r10 = true;
    L26:
        if (r10 != true) goto L28;
    L25:
        r10 = false;
        goto L26
    L14:
        if (r6.length() <= 0) goto L16;
        boolean r11 = true;
    L17:
        if (r11 != true) goto L19;
        r7 = true;
        goto L20
    L16:
        r11 = false;
        goto L17
    L5:
        if (r2.length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 != true) goto L10;
        r4 = true;
        goto L11
    L7:
        r12 = false;
        goto L8
    }

    public /* synthetic */ q0(int r20) {
        this(null, null, null, null, null, null, 0.0d, 0.0d, 0.0d, true, 0.0d, 1.0d, BackgroundAudioPlaybackState.STOPPED);
    }

    public static q0 a(q0 r22) {
        String r1 = r22.a;
        String r2 = r22.b;
        String r3 = r22.c;
        String r4 = r22.d;
        String r5 = r22.e;
        String r6 = r22.f;
        double r7 = r22.g;
        double r9 = r22.h;
        double r11 = r22.i;
        boolean r13 = r22.j;
        double r14 = r22.k;
        double r15 = r22.l;
        BackgroundAudioPlaybackState r16 = r22.m;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r16, "playbackState");
        return new q0(r1, r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15, r16);
    }

    public final void c(s0 r5) {
        Intrinsics.checkNotNullParameter(r5, "stateUpdate");
        String r0 = r5.a;
        if (r0 == null) goto L5;
        this.a = r0;
    L5:
        String r1 = r5.b;
        if (r1 == null) goto L8;
        this.b = r1;
    L8:
        String r2 = r5.c;
        if (r2 == null) goto L11;
        this.c = r2;
    L11:
        String r3 = r5.d;
        if (r3 == null) goto L14;
        this.d = r3;
    L14:
        String r4 = r5.e;
        if (r4 == null) goto L17;
        this.e = r4;
    L17:
        String r6 = r5.f;
        if (r6 == null) goto L20;
        this.f = r6;
    L20:
        Double r7 = r5.g;
        if (r7 == null) goto L23;
        this.g = RangesKt.coerceAtLeast(r7.doubleValue(), 0.0d);
    L23:
        Double r8 = r5.h;
        if (r8 == null) goto L27;
        this.l = r8.doubleValue();
        return;
    }

    public final void d(double r3) {
        this.h = RangesKt.coerceAtLeast(r3, 0.0d);
    }

    public final void e(BackgroundAudioPlaybackState r2) {
        Intrinsics.checkNotNullParameter(r2, "nextPlaybackState");
        this.m = r2;
        if (r2 == BackgroundAudioPlaybackState.PLAYING) goto L5;
        boolean r3 = true;
    L6:
        this.j = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public q0(String r5, String r6, String r7, String r8, String r9, String r10, double r11, double r13, double r15, boolean r17, double r18, double r20, BackgroundAudioPlaybackState r22) {
        Intrinsics.checkNotNullParameter(r22, "playbackState");
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r13;
        this.i = r15;
        this.j = r17;
        this.k = r18;
        this.l = r20;
        this.m = r22;
    }
}
