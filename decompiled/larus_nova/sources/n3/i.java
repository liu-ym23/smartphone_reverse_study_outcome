package n3;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f516867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f516868b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f516869c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f516870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f516871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f516872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f516873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f516874e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f516875f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f516876g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f516877h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f516878i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f516879j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final List<c> f516880k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f516870a == r101.f516870a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f516871b, r101.f516871b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f516872c, r101.f516872c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f516873d, r101.f516873d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f516874e, r101.f516874e) == true) goto L24;
            return false;
        L24:
            if (this.f516875f == r101.f516875f) goto L27;
            return false;
        L27:
            if (this.f516876g == r101.f516876g) goto L30;
            return false;
        L30:
            if (this.f516877h == r101.f516877h) goto L33;
            return false;
        L33:
            if (this.f516878i == r101.f516878i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f516879j, r101.f516879j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f516880k, r101.f516880k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f516870a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f516871b.hashCode()) * 31;
            String r102 = this.f516872c;
            int r103 = 0;
            if (r102 != null) goto L5;
            int r104 = 0;
        L6:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f516873d;
            if (r106 != null) goto L9;
            int r107 = 0;
        L10:
            int r108 = (((r105 + r107) * 31) + this.f516874e.hashCode()) * 31;
            if (this.f516875f == false) goto L13;
            int r109 = 1231;
        L14:
            long r110 = this.f516876g;
            int r111 = (((r108 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            long r112 = this.f516877h;
            int r113 = (((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.f516878i) * 31;
            String r114 = this.f516879j;
            if (r114 == null) goto L19;
            r103 = r114.hashCode();
        L19:
            return ((r113 + r103) * 31) + this.f516880k.hashCode();
        L13:
            r109 = 1237;
            goto L14
        L9:
            r107 = r106.hashCode();
            goto L10
        L5:
            r104 = r102.hashCode();
            goto L6
        }

        public final String toString() {
            return "ExceptionEvent(originalInstanceTime=" + this.f516870a + ", title=" + this.f516871b + ", description=" + this.f516872c + ", location=" + this.f516873d + ", timeZone=" + this.f516874e + ", allDay=" + this.f516875f + ", newStart=" + this.f516876g + ", newEnd=" + this.f516877h + ", status=" + this.f516878i + ", duration=" + this.f516879j + ", reminders=" + this.f516880k + ')';
        }

        public a(long r100, String r101, String r102, String r103, String r104, boolean r105, long r106, long r110, int r111, String r112, List<c> r113) {
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r104, TimeZoneItemV2.TIME_ZONE);
            Intrinsics.checkNotNullParameter(r113, "reminders");
            this.f516870a = r100;
            this.f516871b = r101;
            this.f516872c = r102;
            this.f516873d = r103;
            this.f516874e = r104;
            this.f516875f = r105;
            this.f516876g = r106;
            this.f516877h = r110;
            this.f516878i = r111;
            this.f516879j = r112;
            this.f516880k = r113;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f516881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f516882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f516883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f516884d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f516885e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f516886f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f516887g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<c> f516888h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f516889i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f516890j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f516891k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f516892l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final List<a> f516893m;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f516881a == r101.f516881a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f516882b, r101.f516882b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f516883c, r101.f516883c) == true) goto L18;
            return false;
        L18:
            if (this.f516884d == r101.f516884d) goto L21;
            return false;
        L21:
            if (this.f516885e == r101.f516885e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f516886f, r101.f516886f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f516887g, r101.f516887g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f516888h, r101.f516888h) == true) goto L33;
            return false;
        L33:
            if (this.f516889i == r101.f516889i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f516890j, r101.f516890j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f516891k, r101.f516891k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f516892l, r101.f516892l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f516893m, r101.f516893m) == true) goto L47;
            return false;
        L47:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f516881a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f516882b.hashCode()) * 31;
            String r102 = this.f516883c;
            int r103 = 0;
            if (r102 != null) goto L5;
            int r104 = 0;
        L6:
            long r105 = this.f516884d;
            int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = this.f516885e;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            String r109 = this.f516886f;
            if (r109 != null) goto L9;
            int r110 = 0;
        L10:
            int r111 = (((((r108 + r110) * 31) + this.f516887g.hashCode()) * 31) + this.f516888h.hashCode()) * 31;
            if (this.f516889i == false) goto L13;
            int r112 = 1231;
        L14:
            int r113 = (r111 + r112) * 31;
            String r114 = this.f516890j;
            if (r114 != null) goto L17;
            int r115 = 0;
        L18:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f516891k;
            if (r117 != null) goto L21;
            int r118 = 0;
        L22:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f516892l;
            if (r120 == null) goto L27;
            r103 = r120.hashCode();
        L27:
            return ((r119 + r103) * 31) + this.f516893m.hashCode();
        L21:
            r118 = r117.hashCode();
            goto L22
        L17:
            r115 = r114.hashCode();
            goto L18
        L13:
            r112 = 1237;
            goto L14
        L9:
            r110 = r109.hashCode();
            goto L10
        L5:
            r104 = r102.hashCode();
            goto L6
        }

        public final String toString() {
            return "LocalCalendarEvent(eventId=" + this.f516881a + ", title=" + this.f516882b + ", description=" + this.f516883c + ", start=" + this.f516884d + ", end=" + this.f516885e + ", location=" + this.f516886f + ", timeZone=" + this.f516887g + ", reminders=" + this.f516888h + ", allDay=" + this.f516889i + ", rrule=" + this.f516890j + ", rDate=" + this.f516891k + ", duration=" + this.f516892l + ", exceptions=" + this.f516893m + ')';
        }

        public b(long r100, String r110, String r111, long r112, long r113, String r114, String r115, List<c> r116, boolean r117, String r210, String r211, String r212, List<a> r213) {
            Intrinsics.checkNotNullParameter(r110, "title");
            Intrinsics.checkNotNullParameter(r115, TimeZoneItemV2.TIME_ZONE);
            Intrinsics.checkNotNullParameter(r116, "reminders");
            Intrinsics.checkNotNullParameter(r213, "exceptions");
            this.f516881a = r100;
            this.f516882b = r110;
            this.f516883c = r111;
            this.f516884d = r112;
            this.f516885e = r113;
            this.f516886f = r114;
            this.f516887g = r115;
            this.f516888h = r116;
            this.f516889i = r117;
            this.f516890j = r210;
            this.f516891k = r211;
            this.f516892l = r212;
            this.f516893m = r213;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f516894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f516895b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f516894a == r101.f516894a) goto L12;
            return false;
        L12:
            if (this.f516895b == r101.f516895b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f516894a * 31) + this.f516895b;
        }

        public final String toString() {
            return "Reminder(minutes=" + this.f516894a + ", method=" + this.f516895b + ')';
        }

        public c(int r100, int r101) {
            this.f516894a = r100;
            this.f516895b = r101;
        }
    }

    static {
        Locale r100 = Locale.US;
        SimpleDateFormat r101 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", r100);
        r101.setTimeZone(TimeZone.getTimeZone("UTC"));
        f516867a = r101;
        f516868b = new SimpleDateFormat("yyyyMMdd", r100);
        f516869c = new Regex("^([-+]?)P(?:T?(?:(\\d+(?:\\.\\d+)?)H)?(?:(\\d+(?:\\.\\d+)?)M)?(?:(\\d+(?:\\.\\d+)?)S)?|(?:(\\d+(?:\\.\\d+)?)W)?(?:(\\d+(?:\\.\\d+)?)D)?(?:T(?:(\\d+(?:\\.\\d+)?)H)?(?:(\\d+(?:\\.\\d+)?)M)?(?:(\\d+(?:\\.\\d+)?)S)?)?)$", RegexOption.IGNORE_CASE);
    }

    public static String a(String r110) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r110, "\\", "\\\\", false, 4, null), com.alipay.sdk.m.u.i.f25853b, "\\;", false, 4, null), ",", "\\,", false, 4, null), "\n", "\\n", false, 4, null);
    }

    public static final double c(MatchResult r100, int r101) {
        Double r102 = StringsKt.toDoubleOrNull((String) ListProtector.get(r100.getGroupValues(), r101));
        if (r102 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r102.doubleValue();
    }

    public static String d(long r100, String r101) {
        SimpleDateFormat r102 = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.US);
        r102.setTimeZone(TimeZone.getTimeZone(r101));
        return ";TZID=" + r101 + ':' + r102.format(new Date(r100));
    }

    public static long b(boolean r110, long r210, long r211, String r212) {
        long r100 = 0;
        if (r110 == true) goto L5;
    L9:
        if (r110 == true) goto L35;
        if (r211 != 0) goto L35;
        if (r212 == null) goto L26;
        String r101 = StringsKt.trim(r212).toString();
        int r102 = 1;
        if (r101.length() != 0) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L21;
        MatchResult r104 = f516869c.matchEntire(r101);
        if (r104 == null) goto L21;
        if (Intrinsics.areEqual(ListProtector.get(r104.getGroupValues(), 1), "-") == false) goto L25;
        r102 = -1;
    L25:
        double r105 = c(r104, 2);
        double r106 = c(r104, 3);
        double r107 = c(r104, 4);
        double r111 = c(r104, 5);
        double r112 = c(r104, 6);
        double r113 = c(r104, 7);
        double r108 = c(r104, 8);
        double r114 = c(r104, 9);
        double r109 = 24;
        double r115 = AnnouncementViewModel.HOUR_DURATION;
        r100 = (long) (((((((((r111 * ((double) 7)) * r109) * r115) + ((r112 * r109) * r115)) + ((r105 + r113) * r115)) + ((r106 + r108) * ((double) 60))) + (r107 + r114)) * ((double) 1000)) * ((double) r102));
    L27:
        long r116 = 0;
    L29:
        if (r100 != r116) goto L36;
        int r117 = BaseConstants.Time.HOUR;
    L32:
        r100 = r117;
    L36:
        return r210 + r100;
    L21:
        r116 = 0;
        goto L29
    L16:
        r103 = false;
        goto L17
    L26:
        r100 = 0;
    L35:
        return r211;
    L5:
        if (r211 != 0) goto L7;
    L8:
        r117 = BaseConstants.Time.DAY;
        goto L32
    L7:
        if (r210 != r211) goto L9;
        goto L8
    }
}
