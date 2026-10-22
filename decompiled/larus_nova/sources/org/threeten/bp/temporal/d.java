package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f526466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f526467b;

        @Override // org.threeten.bp.temporal.c
        public final org.threeten.bp.temporal.a adjustInto(org.threeten.bp.temporal.a r100) {
            int r101 = r100.get(ChronoField.DAY_OF_WEEK);
            int r102 = this.f526466a;
            if (r102 >= 2) goto L8;
            if (r101 != this.f526467b) goto L8;
            return r100;
        L8:
            if ((r102 & 1) != 0) goto L15;
            int r103 = r101 - this.f526467b;
            if (r103 < 0) goto L12;
            int r104 = 7 - r103;
        L14:
            return r100.plus(r104, ChronoUnit.DAYS);
        L12:
            r104 = -r103;
            goto L14
        L15:
            int r105 = this.f526467b - r101;
            if (r105 < 0) goto L18;
            int r106 = 7 - r105;
        L20:
            return r100.minus(r106, ChronoUnit.DAYS);
        L18:
            r106 = -r105;
            goto L20
        }

        public a(int r100, DayOfWeek r101) {
            zwc.d.d(r101, "dayOfWeek");
            this.f526466a = r100;
            this.f526467b = r101.getValue();
        }
    }

    public static a a(DayOfWeek r100) {
        return new a(0, r100);
    }
}
