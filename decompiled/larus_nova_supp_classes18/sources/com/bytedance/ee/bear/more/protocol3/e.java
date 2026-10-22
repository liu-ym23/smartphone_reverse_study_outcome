package com.bytedance.ee.bear.more.protocol3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class e {

    public static final class a extends e {
        public final i a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "GridGroup(gridItems=" + this.a + ')';
        }

        public a(i r2) {
            Intrinsics.checkNotNullParameter(r2, "gridItems");
            this.a = r2;
        }
    }

    public static final class b extends e {
        public final int a;
        public final boolean b;
        public final String c;
        public final boolean d;
        public final int e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
            if (this.d == true) goto L11;
            r2 = 1237;
        L11:
            return ((r3 + r2) * 31) + this.e;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Indicator(stateIconTint=" + this.a + ", showNewTips=" + this.b + ", label=" + this.c + ", showState=" + this.d + ", stateIcon=" + this.e + ')';
        }

        public b(int r2, String r3, boolean r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "label");
            this.a = r2;
            this.b = true;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class c extends e {
        public final boolean a;
        public final boolean b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return ((r2 + r1) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Label(showBadge=" + this.a + ", showNewTips=" + this.b + ", label=" + this.c + ')';
        }

        public c() {
            Intrinsics.checkNotNullParameter("", "label");
            this.a = false;
            this.b = true;
            this.c = "";
        }
    }

    public static final class d extends e {
        public final i a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "LinearGroup(listItems=" + this.a + ", title=" + this.b + ')';
        }

        public d(i r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "listItems");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.e$e, reason: collision with other inner class name */
    public static final class C0118e extends e {
        public final boolean a;

        public C0118e() {
            this(false);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0118e) == true) goto L9;
            return false;
        L9:
            if (this.a == ((C0118e) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "NextPage(showNewTips=" + this.a + ')';
        }

        public C0118e(boolean r1) {
            this.a = r1;
        }
    }

    public static final class f extends e {
        public final boolean a;
        public final boolean b;
        public final boolean c;

        public f() {
            this(false, false, false);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == false) goto L9;
            int r3 = 1231;
        L10:
            int r4 = (r2 + r3) * 31;
            if (this.c == true) goto L15;
            r1 = 1237;
        L15:
            return r4 + r1;
        L9:
            r3 = 1237;
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Normal(showBadge=" + this.a + ", showNewTips=" + this.b + ", showFreeTrialTips=" + this.c + ')';
        }

        public f(boolean r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class g extends e {
        public final boolean a;
        public final String b;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (r0 * 31) + this.b.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "RightButton(hideRightButton=" + this.a + ", rightBtnText=" + this.b + ')';
        }

        public g(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "rightBtnText");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class h extends e {
        public final boolean a;
        public final boolean b;
        public final String c;

        public h() {
            this(false, 7);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return ((r2 + r1) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "Switch(isCheck=" + this.a + ", showFreeTrialTips=" + this.b + ", freeTrialTipsText=" + this.c + ')';
        }

        public /* synthetic */ h(boolean r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r4 & 4) == 0) goto L8;
            String r5 = "";
        L9:
            this(r3, false, r5);
            return;
        L8:
            r5 = null;
            goto L9
        }

        public h(boolean r2, boolean r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "freeTrialTipsText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public e() {
    }
}
