package kv8;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.gamecp.live_impl.GamePromoteDataContext;
import com.larus.platform.service.o;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f506295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C6616a f506296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f506297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f506298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f506299g;

    /* JADX INFO: renamed from: kv8.a$a, reason: collision with other inner class name */
    public static final class C6616a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f506300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f506301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f506302c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f506303d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f506304e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f506305f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f506306g;

        public final void setResult(String r100) {
            this.f506302c = r100;
        }

        public C6616a(int r100, long r101) {
            this.f506300a = r100;
            this.f506301b = r101;
            this.f506305f = NotificationCompat.CATEGORY_TRANSPORT;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f506307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f506308b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f506307a, r101.f506307a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f506308b, r101.f506308b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f506307a.hashCode() * 31) + this.f506308b.hashCode();
        }

        public final String toString() {
            return "Failure(stage=" + this.f506307a + ", code=" + this.f506308b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "stage");
            Intrinsics.checkNotNullParameter(r101, "code");
            this.f506307a = r100;
            this.f506308b = r101;
        }
    }

    static {
    }

    public final void c() {
        if (this.f506297e == false) goto L5;
        return;
    L5:
        d("cancel");
        this.f506297e = true;
        JSONObject r100 = new JSONObject();
        String r101 = this.f506298f;
        if (r101 != null) goto L8;
        r101 = GamePromoteDataContext.ACTION_TYPE_USER_CLOSE;
    L8:
        JSONObject r102 = r100.put("reason", r101);
        String r103 = this.f506299g;
        if (r103 == null) goto L12;
        r102.put("complete_result", r103);
    L12:
        if (Intrinsics.areEqual(this.f506298f, "disconnected") == false) goto L18;
        C6616a r104 = this.f506296d;
        if (r104 == null) goto L18;
        c r105 = r104.f506306g;
        if (r105 == null) goto L18;
        r102.put("failed_stage", r105.f506307a).put("error_code", r105.f506308b);
    L18:
        Intrinsics.checkNotNull(r102);
        long r106 = this.f506295c;
        b(this, "browser_takeover_end", r102, Long.valueOf(RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r106, 0)), null, 8);
    }

    public final void f() {
        C6616a r100 = this.f506296d;
        if (r100 != null) goto L5;
        return;
    L5:
        Long r101 = r100.f506304e;
        if (r101 == null) goto L16;
        long r102 = r101.longValue();
        if (this.f506297e == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r100.f506302c, "success") == true) goto L12;
        return;
    L12:
        if (r100.f506303d == true) goto L19;
        r100.f506303d = true;
        b(this, "browser_takeover_first_frame", null, Long.valueOf(RangesKt.coerceAtLeast(r102 - r100.f506301b, 0)), Integer.valueOf(r100.f506300a), 2);
        return;
    L19:
        return;
    }

    public a(hv8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f506293a = r100.f487352h;
        if ((r100.f487351g instanceof hv8.c.a) == false) goto L5;
        String r101 = "cloud";
    L6:
        this.f506294b = r101;
        this.f506295c = SystemClock.elapsedRealtime();
        this.f506299g = "not_requested";
        return;
    L5:
        r101 = "local_pc";
        goto L6
    }

    public final void d(String r100) {
        C6616a r101 = this.f506296d;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f506297e == false) goto L8;
        return;
    L8:
        if (r101.f506302c != null) goto L18;
        r101.setResult(r100);
        JSONObject r102 = new JSONObject().put("status", r100);
        if (Intrinsics.areEqual(r100, "fail") == false) goto L15;
        c r103 = r101.f506306g;
        if (r103 == null) goto L15;
        r102.put("failed_stage", r103.f506307a).put("error_code", r103.f506308b);
    L15:
        Intrinsics.checkNotNull(r102);
        long r104 = r101.f506301b;
        a("browser_takeover_connect", r102, Long.valueOf(RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r104, 0)), Integer.valueOf(r101.f506300a));
        return;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        if (this.f506297e == true) goto L8;
        C6616a r101 = this.f506296d;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f506305f = r100;
        return;
    L9:
        return;
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "code");
        if (this.f506297e == false) goto L5;
        return;
    L5:
        C6616a r102 = this.f506296d;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.f506306g != null) goto L12;
        r102.f506306g = new c(r100, r101);
        return;
    }

    public final void a(String r100, JSONObject r101, Long r102, Integer r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        r101.put(PickerReporterConstants.KEY.TARGET, this.f506294b);     // Catch: Throwable -> L9
        r101.put("takeover_id", this.f506293a);     // Catch: Throwable -> L9
        if (r102 == null) goto L5;
        r101.put("duration_ms", r102.longValue());     // Catch: Throwable -> L9
    L5:
        if (r103 == null) goto L7;
        r101.put("attempt_seq", r103.intValue());     // Catch: Throwable -> L9
    L7:
        o.f365780a.reportEvent(r100, r101);     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static /* synthetic */ void b(a r100, String r101, JSONObject r102, Long r103, Integer r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = new JSONObject();
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = null;
    L11:
        r100.a(r101, r102, r103, r104);
    }
}
