package com.larus.dora.o.impl.health.calendar;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class OHealthCalendarModels {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Pair<Integer, Integer>> f338704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f338705b = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarModels$LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_LOADED", "LOADING", "LOADED", "FAILED", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState FAILED = null;
        public static final LoadState LOADED = null;
        public static final LoadState LOADING = null;
        public static final LoadState NOT_LOADED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadState[] f338706a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f338707b = null;

        public static EnumEntries<LoadState> getEntries() {
            return f338707b;
        }

        static {
            LoadState r100 = new LoadState("NOT_LOADED", 0);
            NOT_LOADED = r100;
            LoadState r101 = new LoadState("LOADING", 1);
            LOADING = r101;
            LoadState r102 = new LoadState("LOADED", 2);
            LOADED = r102;
            LoadState r103 = new LoadState("FAILED", 3);
            FAILED = r103;
            LoadState[] r104 = {r100, r101, r102, r103};
            f338706a = r104;
            f338707b = EnumEntriesKt.enumEntries(r104);
        }

        public static LoadState[] values() {
            return (LoadState[]) f338706a.clone();
        }

        public static LoadState valueOf(String r100) {
            return (LoadState) r27.a.a(LoadState.class, r100);
        }

        public LoadState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f338708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f338709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f338710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f338711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f338712e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f338708a, r101.f338708a) == true) goto L12;
            return false;
        L12:
            if (this.f338709b == r101.f338709b) goto L15;
            return false;
        L15:
            if (this.f338710c == r101.f338710c) goto L18;
            return false;
        L18:
            if (this.f338711d == r101.f338711d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f338712e, r101.f338712e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f338708a.hashCode() * 31) + this.f338709b) * 31;
            int r101 = 1231;
            if (this.f338710c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f338711d == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            Integer r105 = this.f338712e;
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
            return "DayCell(date=" + this.f338708a + ", dayOfMonth=" + this.f338709b + ", isToday=" + this.f338710c + ", hasData=" + this.f338711d + ", score=" + this.f338712e + ')';
        }

        public a(String r100, int r101, boolean r102, boolean r103, Integer r104) {
            Intrinsics.checkNotNullParameter(r100, "date");
            this.f338708a = r100;
            this.f338709b = r101;
            this.f338710c = r102;
            this.f338711d = r103;
            this.f338712e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f338713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f338714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<a> f338715c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LoadState f338716d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f338713a == r101.f338713a) goto L12;
            return false;
        L12:
            if (this.f338714b == r101.f338714b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f338715c, r101.f338715c) == true) goto L18;
            return false;
        L18:
            if (this.f338716d == r101.f338716d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f338713a * 31) + this.f338714b) * 31) + this.f338715c.hashCode()) * 31) + this.f338716d.hashCode();
        }

        public final String toString() {
            return "MonthData(year=" + this.f338713a + ", month=" + this.f338714b + ", cells=" + this.f338715c + ", state=" + this.f338716d + ')';
        }

        public final String b() {
            StringCompanionObject r100 = StringCompanionObject.INSTANCE;
            return String.format(Locale.US, "%04d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f338713a), Integer.valueOf(this.f338714b)}, 2));
        }

        public static b a(b r100, LoadState r101) {
            int r102 = r100.f338713a;
            int r103 = r100.f338714b;
            List<a> r104 = r100.f338715c;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r104, "cells");
            Intrinsics.checkNotNullParameter(r101, "state");
            return new b(r102, r103, r104, r101);
        }

        public b(int r100, int r101, List<a> r102, LoadState r103) {
            Intrinsics.checkNotNullParameter(r102, "cells");
            Intrinsics.checkNotNullParameter(r103, "state");
            this.f338713a = r100;
            this.f338714b = r101;
            this.f338715c = r102;
            this.f338716d = r103;
        }
    }

    static {
        f338704a = CollectionsKt.listOf(new Pair[]{TuplesKt.to(95, Integer.valueOf(ColorProtector.parseColor("#2BD9D3"))), TuplesKt.to(80, Integer.valueOf(ColorProtector.parseColor("#00C743"))), TuplesKt.to(60, Integer.valueOf(ColorProtector.parseColor("#FF850D"))), TuplesKt.to(40, Integer.valueOf(ColorProtector.parseColor("#FF3333"))), TuplesKt.to(0, Integer.valueOf(ColorProtector.parseColor("#A60000")))});
        f338705b = ColorProtector.parseColor("#CCCCCC");
    }

    public static String d() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    public static Pair b(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        return null;
    L12:
        List r111 = StringsKt.split$default(r110, new String[]{"-"}, false, 0, 6, null);
        if (r111.size() >= 2) goto L15;
        return null;
    L15:
        Integer r102 = StringsKt.toIntOrNull((String) ListProtector.get(r111, 0));
        if (r102 == null) goto L28;
        int r103 = r102.intValue();
        Integer r112 = StringsKt.toIntOrNull((String) ListProtector.get(r111, 1));
        if (r112 == null) goto L28;
        int r113 = r112.intValue();
        if (1 <= r113) goto L22;
    L24:
        if (r100 == true) goto L27;
        return null;
    L27:
        return TuplesKt.to(Integer.valueOf(r103), Integer.valueOf(r113));
    L22:
        if (r113 >= 13) goto L24;
        r100 = true;
    L28:
        return null;
    L5:
        if (r110.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static Pair c(int r100, int r101, int r102) {
        Calendar r103 = Calendar.getInstance();
        r103.clear();
        r103.set(r100, r101 - 1, 1);
        r103.add(2, r102);
        return TuplesKt.to(Integer.valueOf(r103.get(1)), Integer.valueOf(r103.get(2) + 1));
    }

    public static b a(int r210, int r211, List r212, LoadState r213, String r214) {
        Intrinsics.checkNotNullParameter(r213, "state");
        Intrinsics.checkNotNullParameter(r214, "today");
        if (r212 != null) goto L5;
        List r100 = CollectionsKt.emptyList();
    L6:
        List r101 = CollectionsKt.filterNotNull(r100);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L7:
        Pair r104 = null;
        if (r103.hasNext() == false) goto L14;
        e r105 = (e) r103.next();
        String r106 = r105.a();
        if (r106 == null) goto L12;
        r104 = TuplesKt.to(r106, r105);
    L12:
        if (r104 == null) goto L7;
        r102.add(r104);
        goto L7
    L14:
        Map r107 = MapsKt.toMap(r102);
        Calendar r108 = Calendar.getInstance();
        r108.clear();
        r108.setFirstDayOfWeek(2);
        r108.set(r210, r211 - 1, 1);
        SimpleDateFormat r109 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        ArrayList r110 = new ArrayList();
        int r111 = ((r108.get(7) - 2) + 7) % 7;
        int r112 = 0;
    L15:
        if (r112 >= r111) goto L17;
        r110.add(null);
        r112 = r112 + 1;
        goto L15
    L17:
        int r113 = r108.getActualMaximum(5);
        int r114 = 0;
    L18:
        if (r114 >= r113) goto L28;
        String r115 = r109.format(r108.getTime());
        e r116 = (e) r107.get(r115);
        Intrinsics.checkNotNull(r115);
        int r117 = r108.get(5);
        boolean r118 = Intrinsics.areEqual(r115, r214);
        if (r116 == null) goto L22;
        boolean r119 = Intrinsics.areEqual(r116.b(), Boolean.TRUE);
    L23:
        if (r116 == null) goto L25;
        Integer r215 = r116.c();
    L26:
        r110.add(new a(r115, r117, r118, r119, r215));
        r108.add(5, 1);
        r114 = r114 + 1;
        goto L18
    L25:
        r215 = null;
        goto L26
    L22:
        r119 = false;
        goto L23
    L28:
        return new b(r210, r211, r110, r213);
    L5:
        r100 = r212;
        goto L6
    }
}
