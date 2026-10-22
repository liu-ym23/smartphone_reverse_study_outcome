package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public interface d {

    public static final class a implements d {
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f234948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f234949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f234950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f234951d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f234948a, r101.f234948a) == true) goto L12;
            return false;
        L12:
            if (this.f234949b == r101.f234949b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f234950c, r101.f234950c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f234951d, r101.f234951d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f234948a.hashCode() * 31) + this.f234949b) * 31;
            Integer r101 = this.f234950c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Integer r105 = this.f234951d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Normal(title=" + this.f234948a + ", iconRes=" + this.f234949b + ", iconTint=" + this.f234950c + ", disableIconTint=" + this.f234951d + ')';
        }

        public b(String r100, int r101, Integer r102, int r103) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f234948a = r100;
            this.f234949b = r101;
            this.f234950c = r102;
            this.f234951d = null;
        }
    }

    public static final class c implements d {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r100).getClass();
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
    public static final class C3369d implements d {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3369d) == true) goto L8;
            return false;
        L8:
            ((C3369d) r100).getClass();
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
