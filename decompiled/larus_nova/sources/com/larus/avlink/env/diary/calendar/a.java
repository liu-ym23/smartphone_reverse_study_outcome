package com.larus.avlink.env.diary.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.calendar.a$a, reason: collision with other inner class name */
    public static final class C3989a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f291932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f291933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f291934c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f291935d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f291936e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f291937f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f291938g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f291939h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3989a) == true) goto L8;
            return false;
        L8:
            C3989a r101 = (C3989a) r100;
            if (this.f291932a == r101.f291932a) goto L12;
            return false;
        L12:
            if (this.f291933b == r101.f291933b) goto L15;
            return false;
        L15:
            if (this.f291934c == r101.f291934c) goto L18;
            return false;
        L18:
            if (this.f291935d == r101.f291935d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f291936e, r101.f291936e) == true) goto L24;
            return false;
        L24:
            if (this.f291937f == r101.f291937f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f291938g, r101.f291938g) == true) goto L30;
            return false;
        L30:
            if (this.f291939h == r101.f291939h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f291932a * 31) + this.f291933b) * 31) + this.f291934c) * 31;
            int r101 = 1231;
            if (this.f291935d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            String r104 = this.f291936e;
            int r105 = 0;
            if (r104 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r103 + r106) * 31;
            if (this.f291937f == false) goto L13;
            int r108 = 1231;
        L14:
            int r109 = (r107 + r108) * 31;
            String r110 = this.f291938g;
            if (r110 == null) goto L18;
            r105 = r110.hashCode();
        L18:
            int r111 = (r109 + r105) * 31;
            if (this.f291939h == true) goto L23;
            r101 = 1237;
        L23:
            return r111 + r101;
        L13:
            r108 = 1237;
            goto L14
        L9:
            r106 = r104.hashCode();
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "DayItem(year=" + this.f291932a + ", month=" + this.f291933b + ", day=" + this.f291934c + ", hasDiary=" + this.f291935d + ", emojiUrl=" + this.f291936e + ", isToday=" + this.f291937f + ", diaryId=" + this.f291938g + ", isSelected=" + this.f291939h + ')';
        }

        public static C3989a a(C3989a r100, boolean r110) {
            int r101 = r100.f291932a;
            int r102 = r100.f291933b;
            int r103 = r100.f291934c;
            boolean r104 = r100.f291935d;
            String r105 = r100.f291936e;
            boolean r106 = r100.f291937f;
            String r107 = r100.f291938g;
            r100.getClass();
            return new C3989a(r101, r102, r103, r104, r105, r106, r107, r110);
        }

        public /* synthetic */ C3989a(int r110, int r111, int r112, boolean r113, String r114, boolean r115, String r116) {
            this(r110, r111, r112, r113, r114, r115, r116, false);
        }

        public C3989a(int r100, int r101, int r102, boolean r103, String r104, boolean r105, String r106, boolean r107) {
            this.f291932a = r100;
            this.f291933b = r101;
            this.f291934c = r102;
            this.f291935d = r103;
            this.f291936e = r104;
            this.f291937f = r105;
            this.f291938g = r106;
            this.f291939h = r107;
        }
    }

    public a() {
    }
}
