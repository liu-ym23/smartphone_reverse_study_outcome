package com.larus.bmhome.bot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class d6 {

    public static final class a extends d6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f296532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f296533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f296534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f296535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f296536e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f296537f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f296532a, r101.f296532a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f296533b, r101.f296533b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f296534c, r101.f296534c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f296535d, r101.f296535d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f296536e, r101.f296536e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f296537f, r101.f296537f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f296532a.hashCode() * 31) + this.f296533b.hashCode()) * 31;
            String r101 = this.f296534c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f296535d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return ((((r104 + r102) * 31) + this.f296536e.hashCode()) * 31) + this.f296537f.hashCode();
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ToggleItem(id=" + this.f296532a + ", name=" + this.f296533b + ", supplierId=" + this.f296536e + ", subText=" + this.f296537f + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r104, "supplierId");
            Intrinsics.checkNotNullParameter(r105, com.bytedance.android.livesdk.gift.model.n.KEY_SUB_TEXT);
            this.f296532a = r100;
            this.f296533b = r101;
            this.f296534c = r102;
            this.f296535d = r103;
            this.f296536e = r104;
            this.f296537f = r105;
        }
    }

    public static final class b extends d6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f296538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f296539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f296540c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f296541d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f296542e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f296543f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f296538a, r101.f296538a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f296539b, r101.f296539b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f296540c, r101.f296540c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f296541d, r101.f296541d) == true) goto L21;
            return false;
        L21:
            if (this.f296542e == r101.f296542e) goto L24;
            return false;
        L24:
            if (this.f296543f == r101.f296543f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f296538a.hashCode() * 31) + this.f296539b.hashCode()) * 31;
            String r101 = this.f296540c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f296541d;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (((r104 + r102) * 31) + this.f296542e) * 31;
            if (this.f296543f == false) goto L13;
            int r107 = 1231;
        L15:
            return r106 + r107;
        L13:
            r107 = 1237;
            goto L15
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ToggleItem(id=" + this.f296538a + ", name=" + this.f296539b + ", tileType=" + this.f296542e + ", checked=" + this.f296543f + ')';
        }

        public b(String r100, String r101, String r102, String r103, int r104, boolean r105) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.f296538a = r100;
            this.f296539b = r101;
            this.f296540c = r102;
            this.f296541d = r103;
            this.f296542e = r104;
            this.f296543f = r105;
        }
    }

    public d6() {
    }
}
