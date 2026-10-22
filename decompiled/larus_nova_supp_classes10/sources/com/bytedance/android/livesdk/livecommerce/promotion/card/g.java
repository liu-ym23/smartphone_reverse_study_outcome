package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class g {
    public final a a;
    public final ILivePromotionCardContainerHandler b;
    public final jf.c c;
    public final e d;
    public final il.a e;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final String l;
        public final String m;
        public final boolean n;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L34;
            a r4 = (a) r3;
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
            if (this.n == r4.n) goto L52;
            return false;
        L52:
            return true;
        L34:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v28, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
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
            String r22 = this.h;
            if (r22 == null) goto L33;
            int r23 = r22.hashCode();
        L34:
            int r24 = (r21 + r23) * 31;
            String r25 = this.i;
            if (r25 == null) goto L37;
            int r26 = r25.hashCode();
        L38:
            int r27 = (r24 + r26) * 31;
            String r28 = this.j;
            if (r28 == null) goto L41;
            int r29 = r28.hashCode();
        L42:
            int r30 = (r27 + r29) * 31;
            String r31 = this.k;
            if (r31 == null) goto L45;
            int r32 = r31.hashCode();
        L46:
            int r33 = (r30 + r32) * 31;
            String r34 = this.l;
            if (r34 == null) goto L49;
            int r35 = r34.hashCode();
        L50:
            int r36 = (r33 + r35) * 31;
            String r37 = this.m;
            if (r37 == null) goto L53;
            r1 = r37.hashCode();
        L53:
            int r38 = (r36 + r1) * 31;
            boolean r39 = this.n;
            ?? r40 = r39;
            if (r39 == false) goto L57;
            r40 = 1;
        L57:
            return r38 + r40;
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
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
            return "BtmInfo(itemBtm=" + this.a + ", addCartBtm=" + this.b + ", stepperBtm=" + this.c + ", buttonBtm=" + this.d + ", matchingBtm=" + this.e + ", simpleSkuBtm=" + this.f + ", givenProductBtm=" + this.g + ", playbackBtm=" + this.h + ", aiTryonBtm=" + this.i + ", floatIconBtm=" + this.j + ", guideModuleBtm=" + this.k + ", hotAtmosphereBtm=" + this.l + ", salePointBtm=" + this.m + ", inList=" + this.n + ")";
        }

        public final String a(KProperty1<a, String> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "prop");
            if (this.n == false) goto L6;
            return ((String) r2.get(this)) + "_i" + r3;
        L6:
            return (String) r2.get(this);
        }

        public a(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, boolean r28, int r29) {
            if ((r29 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L5;
            String r12 = "c9204.d31984";
        L6:
            String r14 = null;
            if ((r29 & 2048) == 0) goto L9;
            String r13 = "c9204.d4334";
        L11:
            if ((r29 & 4096) == 0) goto L14;
            r14 = "c9204.d39378";
        L14:
            if ((r29 & 8192) == 0) goto L16;
            boolean r11 = false;
        L17:
            Intrinsics.checkNotNullParameter(r17, "itemBtm");
            Intrinsics.checkNotNullParameter(r18, "addCartBtm");
            Intrinsics.checkNotNullParameter(r19, "stepperBtm");
            Intrinsics.checkNotNullParameter(r20, "buttonBtm");
            Intrinsics.checkNotNullParameter(r21, "matchingBtm");
            Intrinsics.checkNotNullParameter(r22, "simpleSkuBtm");
            Intrinsics.checkNotNullParameter(r23, "givenProductBtm");
            Intrinsics.checkNotNullParameter(r24, "playbackBtm");
            Intrinsics.checkNotNullParameter(r25, "aiTryonBtm");
            Intrinsics.checkNotNullParameter(r26, "floatIconBtm");
            Intrinsics.checkNotNullParameter(r12, "guideModuleBtm");
            Intrinsics.checkNotNullParameter(r13, "hotAtmosphereBtm");
            Intrinsics.checkNotNullParameter(r14, "salePointBtm");
            this.a = r17;
            this.b = r18;
            this.c = r19;
            this.d = r20;
            this.e = r21;
            this.f = r22;
            this.g = r23;
            this.h = r24;
            this.i = r25;
            this.j = r26;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r11;
            return;
        L16:
            r11 = r28;
            goto L17
        L9:
            r13 = null;
            goto L11
        L5:
            r12 = r27;
            goto L6
        }
    }

    public g(a r2, ILivePromotionCardContainerHandler r3, jf.c r4, e r5, il.a r6) {
        Intrinsics.checkNotNullParameter(r3, "containerHandler");
        Intrinsics.checkNotNullParameter(r6, "historyMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
