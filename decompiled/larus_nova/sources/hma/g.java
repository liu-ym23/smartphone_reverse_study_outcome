package hma;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f486043a;

    public static final class a implements d<g, LocalDateTime> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocalDate f486044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LocalDate f486045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Consumer<LocalDateTime> f486046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public LocalDateTime f486047d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public OReelPickerThreeReels f486048e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C6172a f486049f;

        /* JADX INFO: renamed from: hma.g$a$a, reason: collision with other inner class name */
        public final class C6172a implements gma.a.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f486050a;

            public final void b() {
                a r100 = this.f486050a;
                Consumer<LocalDateTime> r101 = r100.f486046c;
                if (r101 == null) goto L7;
                r101.accept(r100.b().withSecond(0));
                return;
            }

            public C6172a(a r100) {
                Intrinsics.checkNotNullParameter(r100, "this$0");
                this.f486050a = r100;
            }

            @Override // gma.a.c
            public final void a(int r100, int r101) {
                if (r100 != 0) goto L4;
                LocalDate r102 = this.f486050a.f486044a.plusDays(r101);
                a r103 = this.f486050a;
                r103.f486047d = r103.b().withYear(r102.getYear()).withDayOfYear(r102.getDayOfYear());
                b();
            L10:
                b();
                return;
            L4:
                if (r100 == 1) goto L8;
                if (r100 != 2) goto L10;
                c(this, 0, r101, 1);
                goto L10
            L8:
                c(this, r101, 0, 2);
                goto L10
            }

            public static void c(C6172a r100, int r101, int r102, int r103) {
                if ((r103 & 1) == 0) goto L6;
                r101 = -1;
            L6:
                if ((r103 & 2) == 0) goto L8;
                r102 = -1;
            L8:
                if (r101 < 0) goto L10;
                a r104 = r100.f486050a;
                r104.f486047d = r104.b().withHour(r101);
            L10:
                if (r102 < 0) goto L12;
                a r105 = r100.f486050a;
                r105.f486047d = r105.b().withMinute(r102);
            L12:
                r100.b();
            }
        }

        public final LocalDateTime b() {
            return this.f486047d.withSecond(0).withNano(0);
        }

        public a() {
            this.f486044a = LocalDate.now();
            this.f486045b = LocalDate.now().plusYears(1);
            this.f486047d = LocalDateTime.now();
            this.f486049f = new C6172a(this);
        }

        @Override // hma.d
        public final g a(final Context r310, AttributeSet r311, int r312) {
            Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
            OReelPickerThreeReels.a r100 = new OReelPickerThreeReels.a();
            final DateTimeFormatter r101 = DateTimeFormatter.ofPattern(r310.getString(R.string.oui_reel_picker_month_day_pattern));
            int r102 = h.f486051a;
            LocalDate r103 = this.f486044a;
            LocalDate r104 = this.f486045b;
            Function r105 = new f(this, r310, r101);
            Intrinsics.checkNotNullParameter(r103, "start");
            Intrinsics.checkNotNullParameter(r104, RemoteMessageConst.TO);
            ArrayList r106 = new ArrayList();
        L4:
            if (r103.isBefore(r104) == false) goto L6;
            r106.add(r105.apply(r103));
            r103 = r103.plusDays(1);
            goto L4
        L6:
            r106.add(r105.apply(r103));
            LocalDate r107 = b().toLocalDate();
            if (r107.isBefore(this.f486044a) == false) goto L10;
            int r110 = 0;
        L13:
            r100.a(new gma.a.b(0, r106, null, 148.0f, r110, this.f486049f, 116));
            r100.a(new gma.a.b(1, h.d(0, 23, null, 2, 4), null, 74.0f, b().getHour(), this.f486049f, 116));
            r100.a(new gma.a.b(2, h.d(0, 59, null, 2, 4), null, 74.0f, b().getMinute(), this.f486049f, 116));
            this.f486048e = (OReelPickerThreeReels) r100.b(r310, r311, r312);
            g r108 = new g();
            r108.f486043a = this;
            return r108;
        L10:
            if (r107.isBefore(this.f486045b) == false) goto L12;
            r110 = (int) ChronoUnit.DAYS.between(this.f486044a, r107);
            goto L13
        L12:
            r110 = r106.size() - 1;
            goto L13
        }
    }

    public g() {
    }
}
