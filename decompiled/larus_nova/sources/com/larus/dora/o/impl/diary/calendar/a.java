package com.larus.dora.o.impl.diary.calendar;

import com.larus.dora.o.impl.diary.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f338495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f338496b = null;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.calendar.a$a, reason: collision with other inner class name */
    public static final class C4281a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f338497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f338498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f338499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f338500d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final i f338501e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4281a) == true) goto L8;
            return false;
        L8:
            C4281a r101 = (C4281a) r100;
            if (Intrinsics.areEqual(this.f338497a, r101.f338497a) == true) goto L12;
            return false;
        L12:
            if (this.f338498b == r101.f338498b) goto L15;
            return false;
        L15:
            if (this.f338499c == r101.f338499c) goto L18;
            return false;
        L18:
            if (this.f338500d == r101.f338500d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f338501e, r101.f338501e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f338497a.hashCode() * 31) + this.f338498b) * 31;
            int r101 = 1231;
            if (this.f338499c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f338500d == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            i r105 = this.f338501e;
            if (r105 != null) goto L13;
            int r106 = 0;
        L15:
            return r104 + r106;
        L13:
            r106 = r105.hashCode();
            goto L15
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "DayCell(date=" + this.f338497a + ", dayOfMonth=" + this.f338498b + ", isToday=" + this.f338499c + ", isFuture=" + this.f338500d + ", brief=" + this.f338501e + ')';
        }

        public C4281a(String r100, int r101, boolean r102, boolean r103, i r104) {
            Intrinsics.checkNotNullParameter(r100, "date");
            this.f338497a = r100;
            this.f338498b = r101;
            this.f338499c = r102;
            this.f338500d = r103;
            this.f338501e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f338502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f338503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<C4281a> f338504c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f338502a == r101.f338502a) goto L12;
            return false;
        L12:
            if (this.f338503b == r101.f338503b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f338504c, r101.f338504c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f338502a * 31) + this.f338503b) * 31) + this.f338504c.hashCode();
        }

        public final String toString() {
            return "MonthData(year=" + this.f338502a + ", month=" + this.f338503b + ", cells=" + this.f338504c + ')';
        }

        public b(int r100, int r101, List<C4281a> r102) {
            Intrinsics.checkNotNullParameter(r102, "cells");
            this.f338502a = r100;
            this.f338503b = r101;
            this.f338504c = r102;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C4281a> f338505a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f338505a, ((c) r100).f338505a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f338505a.hashCode();
        }

        public final String toString() {
            return "WeekData(days=" + this.f338505a + ')';
        }

        public c(List<C4281a> r100) {
            Intrinsics.checkNotNullParameter(r100, "days");
            this.f338505a = r100;
        }
    }

    static {
        f338495a = CollectionsKt.listOf(new String[]{"一", "二", "三", "四", "五", "六", "日"});
        f338496b = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public static List b(List r110) {
        Intrinsics.checkNotNullParameter(r110, "briefItems");
        String r100 = f338496b.format(new Date());
        ArrayList r101 = new ArrayList();
        Iterator r111 = r110.iterator();
    L3:
        Pair r102 = null;
        if (r111.hasNext() == false) goto L10;
        i r103 = (i) r111.next();
        String r104 = r103.b();
        if (r104 == null) goto L8;
        r102 = TuplesKt.to(r104, r103);
    L8:
        if (r102 == null) goto L3;
        r101.add(r102);
        goto L3
    L10:
        Map r112 = MapsKt.toMap(r101);
        String r105 = (String) CollectionsKt.minOrNull(r112.keySet());
        if (r105 != null) goto L13;
        r105 = r100;
    L13:
        Calendar r106 = c(r105);
        if (r106 == null) goto L16;
        r106.set(5, 1);
        Calendar r107 = c(r100);
        if (r107 == null) goto L20;
        r107.set(5, 1);
        ArrayList r108 = new ArrayList();
    L23:
        if (r106.getTimeInMillis() > r107.getTimeInMillis()) goto L31;
        int r109 = r106.get(1);
        int r113 = r106.get(2) + 1;
        ArrayList r114 = new ArrayList();
        int r115 = ((r106.get(7) - 2) + 7) % 7;
        int r116 = 0;
        int r117 = 0;
    L25:
        if (r117 >= r115) goto L27;
        r114.add(null);
        r117 = r117 + 1;
        goto L25
    L27:
        int r118 = r106.getActualMaximum(5);
    L28:
        if (r116 >= r118) goto L30;
        r114.add(a(r106, r100, r112));
        r106.add(5, 1);
        r116 = r116 + 1;
        goto L28
    L30:
        r108.add(new b(r109, r113, r114));
        goto L23
    L31:
        return r108;
    L20:
        return CollectionsKt.emptyList();
    L16:
        return CollectionsKt.emptyList();
    }

    public static Calendar c(String r100) {
        Calendar r101 = Calendar.getInstance();     // Catch: Exception -> L9
        r101.setFirstDayOfWeek(2);     // Catch: Exception -> L9
        Date r102 = f338496b.parse(r100);     // Catch: Exception -> L9
        if (r102 != null) goto L6;
        return null;
    L6:
        r101.setTime(r102);     // Catch: Exception -> L9
        return r101;
    L12:
        return null;
    }

    public static int d(List r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "weeks");
        if (r101 != null) goto L5;
        return -1;
    L5:
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L29;
        List<C4281a> r104 = ((c) r102.next()).f338505a;
        if ((r104 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((C4281a) r105.next()).f338497a, r101) == false) goto L15;
        boolean r106 = true;
    L20:
        if (r106 == true) goto L23;
        r103 = r103 + 1;
        goto L7
    L23:
        return r103;
    L19:
        r106 = false;
        goto L20
    L11:
        if (r104.isEmpty() == false) goto L13;
    L29:
        return -1;
    }

    public static C4281a a(Calendar r100, String r101, Map r110) {
        String r102 = f338496b.format(r100.getTime());
        int r103 = r100.get(5);
        boolean r104 = Intrinsics.areEqual(r102, r101);
        if (r102.compareTo(r101) <= 0) goto L5;
        boolean r105 = true;
    L7:
        return new C4281a(r102, r103, r104, r105, (i) r110.get(r102));
    L5:
        r105 = false;
        goto L7
    }
}
