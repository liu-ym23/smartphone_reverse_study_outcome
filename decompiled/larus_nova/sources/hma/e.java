package hma;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f486027a;

    public static final class a implements d<e, LocalDate> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f486028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f486029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f486030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Consumer<LocalDate> f486031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b f486032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public OReelPickerThreeReels f486033f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f486034g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final C6171a f486035h;

        /* JADX INFO: renamed from: hma.e$a$a, reason: collision with other inner class name */
        public final class C6171a implements gma.a.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f486036a;

            public C6171a(a r100) {
                Intrinsics.checkNotNullParameter(r100, "this$0");
                this.f486036a = r100;
            }

            @Override // gma.a.c
            public final void a(int r100, int r101) {
                if (r100 != 0) goto L5;
                a r102 = this.f486036a;
                int r103 = r102.f486029b + r101;
                b r104 = r102.f486032e.a();
                b(r103, r104.f486038b, r104.f486039c);
                if (r104.f486038b != 2) goto L29;
                int r105 = h.f486051a;
                if (h.e(r104.f486037a) == h.e(r103)) goto L29;
                int r106 = r104.f486038b;
                boolean r107 = h.e(r103);
                a r108 = this.f486036a;
                Context r109 = r108.f486028a;
                if (r109 == null) goto L29;
                OReelPickerThreeReels r110 = r108.f486033f;
                if (r110 == null) goto L29;
                r110.U5(r108.f486034g, r108.b(r109, r106, r107));
            L29:
                a r111 = this.f486036a;
                Consumer<LocalDate> r112 = r111.f486031d;
                if (r112 == null) goto L34;
                b r113 = r111.f486032e;
                r112.accept(LocalDate.of(r113.f486037a, r113.f486038b, r113.f486039c));
                return;
            L34:
                return;
            L5:
                if (r100 == 1) goto L9;
                if (r100 != 2) goto L29;
                b r114 = this.f486036a.f486032e;
                int r115 = r114.f486037a;
                int r116 = r114.f486038b;
                b(r115, r116, r101 + 1);
                goto L29
            L9:
                int r117 = r101 + 1;
                b r118 = this.f486036a.f486032e.a();
                b(r118.f486037a, r117, r118.f486039c);
                int r119 = h.f486051a;
                boolean r120 = h.e(r118.f486037a);
                if (h.a(r117, r120) == h.a(r118.f486038b, r120)) goto L29;
                a r121 = this.f486036a;
                Context r122 = r121.f486028a;
                if (r122 == null) goto L29;
                OReelPickerThreeReels r123 = r121.f486033f;
                if (r123 == null) goto L29;
                r123.U5(r121.f486034g, r121.b(r122, r117, r120));
                goto L29
            }

            public final void b(int r100, int r101, int r102) {
                b r103 = this.f486036a.f486032e;
                r103.f486037a = r100;
                r103.f486038b = r101;
                int r104 = h.f486051a;
                r103.f486039c = Math.min(r102, h.a(r101, h.e(r100)));
            }
        }

        public a() {
            this.f486029b = 1900;
            this.f486030c = 2100;
            LocalDate r100 = LocalDate.now();
            this.f486032e = new b(r100.getYear(), r100.getMonthValue(), r100.getDayOfMonth());
            this.f486034g = 2;
            this.f486035h = new C6171a(this);
        }

        public final gma.a.b c(Context r110) {
            int r100 = h.f486051a;
            return new gma.a.b(1, h.b(r110), null, 0.0f, this.f486032e.f486038b - 1, this.f486035h, 124);
        }

        public final gma.a.b d(Context r110) {
            int r100 = h.f486051a;
            List r101 = h.d(this.f486029b, this.f486030c, r110.getString(R.string.oui_reel_picker_year_tag), 0, 8);
            int r102 = Math.min(Math.max(this.f486032e.f486037a - this.f486029b, 0), this.f486030c - this.f486029b);
            b r111 = this.f486032e;
            r111.f486037a = this.f486029b + r102;
            return new gma.a.b(0, r101, null, 0.0f, r102, this.f486035h, 124);
        }

        @Override // hma.d
        public final e a(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            OReelPickerThreeReels.a r103 = new OReelPickerThreeReels.a();
            if (Locale.US.equals(Locale.getDefault()) == false) goto L5;
            r103.a(c(r100));
            b r104 = this.f486032e;
            int r105 = r104.f486038b;
            int r106 = h.f486051a;
            r103.a(b(r100, r105, h.e(r104.f486037a)));
            r103.a(d(r100));
            this.f486034g = 1;
        L6:
            gma.a r107 = r103.b(r100, r101, r102);
            this.f486028a = r100;
            this.f486033f = (OReelPickerThreeReels) r107;
            e r108 = new e();
            r108.f486027a = this;
            return r108;
        L5:
            r103.a(d(r100));
            r103.a(c(r100));
            b r109 = this.f486032e;
            int r110 = r109.f486038b;
            int r111 = h.f486051a;
            r103.a(b(r100, r110, h.e(r109.f486037a)));
            this.f486034g = 2;
            goto L6
        }

        public final gma.a.b b(Context r100, int r110, boolean r111) {
            int r101 = h.f486051a;
            return new gma.a.b(2, h.c(1, h.a(r110, r111), r100.getString(R.string.oui_reel_picker_day_tag), 1), null, 0.0f, this.f486032e.f486039c - 1, this.f486035h, 124);
        }
    }

    public static final class b implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f486037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f486038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f486039c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f486037a == r101.f486037a) goto L12;
            return false;
        L12:
            if (this.f486038b == r101.f486038b) goto L15;
            return false;
        L15:
            if (this.f486039c == r101.f486039c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f486037a * 31) + this.f486038b) * 31) + this.f486039c;
        }

        public final String toString() {
            return "SelectionDate(year=" + this.f486037a + ", month=" + this.f486038b + ", day=" + this.f486039c + ')';
        }

        public final b a() {
            return (b) super.clone();
        }

        public final /* bridge */ /* synthetic */ Object clone() {
            return a();
        }

        public b(int r100, int r101, int r102) {
            this.f486037a = r100;
            this.f486038b = r101;
            this.f486039c = r102;
        }
    }

    public e() {
    }
}
