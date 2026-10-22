package com.bytedance.ee.bear.share.newshare;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a0 {

    public static final class a extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f237182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f237183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f237184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f237185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f237186e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f237182a, r101.f237182a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f237183b, r101.f237183b) == true) goto L15;
            return false;
        L15:
            if (this.f237184c == r101.f237184c) goto L18;
            return false;
        L18:
            if (this.f237185d == r101.f237185d) goto L21;
            return false;
        L21:
            if (this.f237186e == r101.f237186e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f237182a.hashCode() * 31;
            String r101 = this.f237183b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            int r104 = 1231;
            if (this.f237184c == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r103 + r105) * 31;
            if (this.f237185d == false) goto L13;
            int r107 = 1231;
        L14:
            int r108 = (r106 + r107) * 31;
            if (this.f237186e == true) goto L19;
            r104 = 1237;
        L19:
            return r108 + r104;
        L13:
            r107 = 1237;
            goto L14
        L9:
            r105 = 1237;
            goto L10
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "LinearGroup(listItems=" + this.f237182a + ", title=" + this.f237183b + ", useBackgroundColor=" + this.f237184c + ", usePadding=" + this.f237185d + ", useMarginTop=" + this.f237186e + ')';
        }

        public a(d0 r100, boolean r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "listItems");
            this.f237182a = r100;
            this.f237183b = null;
            this.f237184c = r101;
            this.f237185d = r102;
            this.f237186e = r103;
        }
    }

    public static final class b extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f237187a;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f237187a, ((b) r100).f237187a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f237187a.hashCode();
        }

        public final String toString() {
            return "Normal(id=" + this.f237187a + ')';
        }

        public b(int r100) {
            Intrinsics.checkNotNullParameter("", "id");
            this.f237187a = "";
        }
    }

    public a0() {
    }
}
