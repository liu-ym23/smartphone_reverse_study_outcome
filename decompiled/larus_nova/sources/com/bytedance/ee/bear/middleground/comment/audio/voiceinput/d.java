package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f230393a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f230394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f230395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f230396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f230397d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f230394a == r101.f230394a) goto L12;
            return false;
        L12:
            if (this.f230395b == r101.f230395b) goto L15;
            return false;
        L15:
            if (this.f230396c == r101.f230396c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f230397d, r101.f230397d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f230394a * 31) + this.f230395b) * 31) + this.f230396c) * 31) + this.f230397d.hashCode();
        }

        public final String toString() {
            return "DocSpanInfo(type=" + this.f230394a + ", subType=" + this.f230395b + ", prefixIconRes=" + this.f230396c + ", iconInfo=" + this.f230397d + ')';
        }

        public final int getType() {
            return this.f230394a;
        }

        public a(int r100, int r101, int r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "iconInfo");
            this.f230394a = r100;
            this.f230395b = r101;
            this.f230396c = r102;
            this.f230397d = r103;
        }
    }

    static {
        f230393a = new int[]{1, 3, 8, 11, 12, 30, 22};
    }

    public static String a(String r100) {
        if (r100 == null) goto L4;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        int r102 = StringsKt.lastIndexOf$default(r101, '.', 0, false, 6, null);
        if (r102 >= 0) goto L11;
        return "";
    L11:
        if (r102 < (r101.length() - 1)) goto L13;
        return "";
    L13:
        return r101.substring(r102 + 1);
    L4:
        r101 = null;
        goto L6
    }
}
