package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface d {

    public static final class a implements d {
    }

    public static final class b implements d {
        public final String a;
        public final int b;
        public final Integer c;
        public final Integer d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            Integer r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.d;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Normal(title=" + this.a + ", iconRes=" + this.b + ", iconTint=" + this.c + ", disableIconTint=" + this.d + ')';
        }

        public b(String r2, int r3, Integer r4, int r5) {
            if ((r5 & 4) == 0) goto L5;
            r4 = null;
        L5:
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = null;
        }
    }

    public static final class c implements d {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(null, null) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "RightButton(title=null, buttonText=null, iconRes=0, iconTint=null, disableIconTint=null)";
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.panel.d$d, reason: collision with other inner class name */
    public static final class C0122d implements d {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0122d) == true) goto L8;
            return false;
        L8:
            ((C0122d) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Switch(title=null, checked=false, iconRes=0, iconTint=null, disableIconTint=null)";
        }
    }
}
