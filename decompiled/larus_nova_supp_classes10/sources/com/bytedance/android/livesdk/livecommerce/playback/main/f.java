package com.bytedance.android.livesdk.livecommerce.playback.main;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import dj2.i;
import dj2.j;
import dj2.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements com.bytedance.android.ec.core.arch.state.b {
    public final boolean a;
    public final boolean b;
    public k c;
    public final dj2.h d;
    public final ECUrlModel e;
    public final String f;
    public final ECRitTag g;
    public final j h;
    public final dj2.b i;
    public final dj2.a j;
    public final i k;
    public final dj2.c l;
    public final ReplayCards m;
    public final k n;
    public final dj2.g o;
    public final List<com.bytedance.android.ec.model.live.b> p;

    public f() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L38;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
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
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r4.k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.l, r4.l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.m, r4.m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.n, r4.n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.o, r4.o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.p, r4.p) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v55 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.b;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        k r6 = this.c;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        dj2.h r10 = this.d;
        if (r10 == null) goto L16;
        int r11 = r10.hashCode();
    L17:
        int r12 = (r9 + r11) * 31;
        ECUrlModel r13 = this.e;
        if (r13 == null) goto L20;
        int r14 = r13.hashCode();
    L21:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L24;
        int r17 = r16.hashCode();
    L25:
        int r18 = (r15 + r17) * 31;
        ECRitTag r19 = this.g;
        if (r19 == null) goto L28;
        int r20 = r19.hashCode();
    L29:
        int r21 = (r18 + r20) * 31;
        j r22 = this.h;
        if (r22 == null) goto L32;
        int r23 = r22.hashCode();
    L33:
        int r24 = (r21 + r23) * 31;
        dj2.b r25 = this.i;
        if (r25 == null) goto L36;
        int r26 = r25.hashCode();
    L37:
        int r27 = (r24 + r26) * 31;
        dj2.a r28 = this.j;
        if (r28 == null) goto L40;
        int r29 = r28.hashCode();
    L41:
        int r30 = (r27 + r29) * 31;
        i r31 = this.k;
        if (r31 == null) goto L44;
        int r32 = r31.hashCode();
    L45:
        int r33 = (r30 + r32) * 31;
        dj2.c r34 = this.l;
        if (r34 == null) goto L48;
        int r35 = r34.hashCode();
    L49:
        int r36 = (r33 + r35) * 31;
        ReplayCards r37 = this.m;
        if (r37 == null) goto L52;
        int r38 = r37.hashCode();
    L53:
        int r39 = (r36 + r38) * 31;
        k r40 = this.n;
        if (r40 == null) goto L56;
        int r41 = r40.hashCode();
    L57:
        int r42 = (r39 + r41) * 31;
        dj2.g r43 = this.o;
        if (r43 == null) goto L60;
        int r44 = r43.hashCode();
    L61:
        int r45 = (r42 + r44) * 31;
        List<com.bytedance.android.ec.model.live.b> r46 = this.p;
        if (r46 == null) goto L65;
        r7 = r46.hashCode();
    L65:
        return r45 + r7;
    L60:
        r44 = 0;
        goto L61
    L56:
        r41 = 0;
        goto L57
    L52:
        r38 = 0;
        goto L53
    L48:
        r35 = 0;
        goto L49
    L44:
        r32 = 0;
        goto L45
    L40:
        r29 = 0;
        goto L41
    L36:
        r26 = 0;
        goto L37
    L32:
        r23 = 0;
        goto L33
    L28:
        r20 = 0;
        goto L29
    L24:
        r17 = 0;
        goto L25
    L20:
        r14 = 0;
        goto L21
    L16:
        r11 = 0;
        goto L17
    L12:
        r8 = 0;
        goto L13
    }

    public final String toString() {
        return "ExplainPlaybackState(isLoading=" + this.a + ", showBackToLive=" + this.b + ", videoInfoEntity=" + this.c + ", promotionInfo=" + this.d + ", backgroundPic=" + this.e + ", headerTitle=" + this.f + ", commentaryTag=" + this.g + ", topRightButtonEntity=" + this.h + ", bottomEnterLiveEntity=" + this.i + ", authorInfoEntity=" + this.j + ", replayViewCntEntity=" + this.k + ", bottomLivingButtonEntity=" + this.l + ", replayCards=" + this.m + ", videoInfoEntityV2=" + this.n + ", interactionEntity=" + this.o + ", topBanner=" + this.p + ")";
    }

    public /* synthetic */ f(int r18) {
        this(true, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public f(boolean r3, boolean r4, k r5, dj2.h r6, ECUrlModel r7, String r8, ECRitTag r9, j r10, dj2.b r11, dj2.a r12, i r13, dj2.c r14, ReplayCards r15, k r16, dj2.g r17, List<com.bytedance.android.ec.model.live.b> r18) {
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
        this.m = r15;
        this.n = r16;
        this.o = r17;
        this.p = r18;
    }

    public static f a(f r17, boolean r18, boolean r19, k r20, dj2.h r21, ECUrlModel r22, String r23, ECRitTag r24, j r25, dj2.b r26, dj2.a r27, i r28, dj2.c r29, ReplayCards r30, k r31, dj2.g r32, List r33, int r34) {
        if ((r34 & 1) == 0) goto L5;
        boolean r2 = r17.a;
    L7:
        if ((r34 & 2) == 0) goto L9;
        boolean r3 = r17.b;
    L11:
        if ((r34 & 4) == 0) goto L13;
        k r4 = r17.c;
    L15:
        if ((r34 & 8) == 0) goto L17;
        dj2.h r5 = r17.d;
    L19:
        if ((r34 & 16) == 0) goto L21;
        ECUrlModel r6 = r17.e;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r7 = r17.f;
    L27:
        if ((r34 & 64) == 0) goto L29;
        ECRitTag r8 = r17.g;
    L31:
        if ((r34 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        j r9 = r17.h;
    L35:
        if ((r34 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L37;
        dj2.b r10 = r17.i;
    L39:
        if ((r34 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L41;
        dj2.a r11 = r17.j;
    L43:
        if ((r34 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L45;
        i r12 = r17.k;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        dj2.c r13 = r17.l;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        ReplayCards r14 = r17.m;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        k r15 = r17.n;
    L58:
        k r35 = r15;
        if ((r34 & 16384) == 0) goto L61;
        dj2.g r16 = r17.o;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        List r1 = r17.p;
    L66:
        r17.getClass();
        return new f(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r35, r16, r1);
    L65:
        r1 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
