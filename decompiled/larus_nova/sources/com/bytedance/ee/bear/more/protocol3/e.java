package com.bytedance.ee.bear.more.protocol3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f234795a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f234795a, ((a) r100).f234795a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f234795a.hashCode();
        }

        public final String toString() {
            return "GridGroup(gridItems=" + this.f234795a + ')';
        }

        public a(i r100) {
            Intrinsics.checkNotNullParameter(r100, "gridItems");
            this.f234795a = r100;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f234796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f234797b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f234798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f234799d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f234800e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f234796a == r101.f234796a) goto L12;
            return false;
        L12:
            if (this.f234797b == r101.f234797b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f234798c, r101.f234798c) == true) goto L18;
            return false;
        L18:
            if (this.f234799d == r101.f234799d) goto L21;
            return false;
        L21:
            if (this.f234800e == r101.f234800e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f234796a * 31;
            int r101 = 1231;
            if (this.f234797b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (((r100 + r102) * 31) + this.f234798c.hashCode()) * 31;
            if (this.f234799d == true) goto L11;
            r101 = 1237;
        L11:
            return ((r103 + r101) * 31) + this.f234800e;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "Indicator(stateIconTint=" + this.f234796a + ", showNewTips=" + this.f234797b + ", label=" + this.f234798c + ", showState=" + this.f234799d + ", stateIcon=" + this.f234800e + ')';
        }

        public b(int r100, String r101, boolean r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "label");
            this.f234796a = r100;
            this.f234797b = true;
            this.f234798c = r101;
            this.f234799d = r102;
            this.f234800e = r103;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f234801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f234802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f234803c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f234801a == r101.f234801a) goto L12;
            return false;
        L12:
            if (this.f234802b == r101.f234802b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f234803c, r101.f234803c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f234801a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f234802b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f234803c.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Label(showBadge=" + this.f234801a + ", showNewTips=" + this.f234802b + ", label=" + this.f234803c + ')';
        }

        public c() {
            Intrinsics.checkNotNullParameter("", "label");
            this.f234801a = false;
            this.f234802b = true;
            this.f234803c = "";
        }
    }

    public static final class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f234804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f234805b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f234804a, r101.f234804a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f234805b, r101.f234805b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f234804a.hashCode() * 31;
            String r101 = this.f234805b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "LinearGroup(listItems=" + this.f234804a + ", title=" + this.f234805b + ')';
        }

        public d(i r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "listItems");
            this.f234804a = r100;
            this.f234805b = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.e$e, reason: collision with other inner class name */
    public static final class C3365e extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f234806a;

        public C3365e() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3365e) == true) goto L9;
            return false;
        L9:
            if (this.f234806a == ((C3365e) r100).f234806a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f234806a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "NextPage(showNewTips=" + this.f234806a + ')';
        }

        public C3365e(boolean r100) {
            this.f234806a = r100;
        }
    }

    public static final class f extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f234807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f234808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f234809c;

        public f() {
            this(false, false, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (this.f234807a == r101.f234807a) goto L12;
            return false;
        L12:
            if (this.f234808b == r101.f234808b) goto L15;
            return false;
        L15:
            if (this.f234809c == r101.f234809c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f234807a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f234808b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f234809c == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Normal(showBadge=" + this.f234807a + ", showNewTips=" + this.f234808b + ", showFreeTrialTips=" + this.f234809c + ')';
        }

        public f(boolean r100, boolean r101, boolean r102) {
            this.f234807a = r100;
            this.f234808b = r101;
            this.f234809c = r102;
        }
    }

    public static final class g extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f234810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f234811b;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f234810a == r101.f234810a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f234811b, r101.f234811b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f234810a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f234811b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "RightButton(hideRightButton=" + this.f234810a + ", rightBtnText=" + this.f234811b + ')';
        }

        public g(boolean r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "rightBtnText");
            this.f234810a = r100;
            this.f234811b = r101;
        }
    }

    public static final class h extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f234812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f234813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f234814c;

        public h() {
            this(false, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f234812a == r101.f234812a) goto L12;
            return false;
        L12:
            if (this.f234813b == r101.f234813b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f234814c, r101.f234814c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f234812a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f234813b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f234814c.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Switch(isCheck=" + this.f234812a + ", showFreeTrialTips=" + this.f234813b + ", freeTrialTipsText=" + this.f234814c + ')';
        }

        public /* synthetic */ h(boolean r100, int r101) {
            if ((r101 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r101 & 4) == 0) goto L8;
            String r102 = "";
        L9:
            this(r100, false, r102);
            return;
        L8:
            r102 = null;
            goto L9
        }

        public h(boolean r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "freeTrialTipsText");
            this.f234812a = r100;
            this.f234813b = r101;
            this.f234814c = r102;
        }
    }

    public e() {
    }
}
