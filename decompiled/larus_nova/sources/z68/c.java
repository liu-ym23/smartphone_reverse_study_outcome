package z68;

import android.os.SystemClock;
import com.larus.audio.call.f;
import com.larus.flow.capture.model.QualityPreference;
import com.larus.flow.capture.model.StopReason;
import da9.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import q68.d;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f570543a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f570544b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f570545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static z68.a f570546d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f570547a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f570548b = null;

        static {
            int[] r100 = new int[StopReason.values().length];
            r100[StopReason.PERMISSION_REVOKED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[StopReason.SOURCE_INTERRUPTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L33:
            r100[StopReason.RUNTIME_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L25:
            r100[StopReason.RTC_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[StopReason.USER_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L9:
            f570547a = r100;
            int[] r101 = new int[QualityPreference.values().length];
            r101[QualityPreference.CLEAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L21:
            r101[QualityPreference.FLUENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L12:
            f570548b = r101;
        }
    }

    public c() {
    }

    static {
        f570543a = new c();
        f570544b = new Object();
    }

    public static void b() {
        Object r100 = f570544b;
        monitor-enter(r100);
        f570545c = null;     // Catch: Throwable -> L8
        f570546d = null;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void c(z68.a r110) {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = r110.f570537i;
        if (r101 != 0) goto L6;
        r110.f570537i = r100;
        return;
    L6:
        long r102 = r100 - r101;
        if (r102 >= 1000) goto L9;
        return;
    L9:
        double r103 = r102;
        g("flow_screen_share_capture_fps", MapsKt.mapOf(new Pair[]{TuplesKt.to("sample_interval_ms", Integer.valueOf((int) r102)), TuplesKt.to("capture_fps", Double.valueOf((((double) r110.f570538j) * 1000.0d) / r103)), TuplesKt.to("output_fps", Double.valueOf((((double) r110.f570539k) * 1000.0d) / r103)), TuplesKt.to("profile", e(r110.f570533e, r110.f570534f, r110.f570535g)), TuplesKt.to("resolution", k(r110.f570533e, r110.f570534f))}));
        r110.f570537i = r100;
        r110.f570538j = 0;
        r110.f570539k = 0;
    }

    public static void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "startSource");
        e r101 = new e(0);
        Intrinsics.checkNotNullParameter(r100, "startSource");
        Intrinsics.checkNotNullParameter(r101, "policy");
        long r102 = SystemClock.elapsedRealtime();
        Object r103 = f570544b;
        monitor-enter(r103);
        f570545c = new b(r102, r100, r101);     // Catch: Throwable -> L15
        f570546d = null;     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r103);
        Pair[] r105 = new Pair[4];
        r105[0] = TuplesKt.to("start_source", r100);
        QualityPreference r106 = r101.f467727a;
        int r107 = a.f570548b[r106.ordinal()];
        if (r107 == 1) goto L12;
        if (r107 != 2) goto L11;
        String r108 = "smoothness";
    L13:
        r105[1] = TuplesKt.to("policy_quality", r108);
        r105[2] = TuplesKt.to("policy_min_fps", Integer.valueOf(r101.f467728b));
        r105[3] = TuplesKt.to("policy_max_fps", Integer.valueOf(r101.f467729c));
        g("flow_screen_share_start", MapsKt.mapOf(r105));
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        r108 = "clarity";
    L15:
        th = move-exception;
        throw th;
    }

    public static void g(String r100, Map r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        f.c().h().a(r100, d.c(r101));     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static String k(int r100, int r101) {
        int r102 = Math.min(r100, r101);
        boolean r103 = false;
        if (1080 <= r102) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L11;
        return "1080p";
    L11:
        if (720 > r102) goto L14;
        if (r102 >= 1080) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L18;
        return "720p";
    L18:
        if (540 > r102) goto L21;
        if (r102 >= 720) goto L21;
        r103 = true;
    L21:
        if (r103 == false) goto L23;
        return "540p";
    L23:
        return "360p";
    L14:
        r105 = false;
        goto L15
    L5:
        if (r102 > Integer.MAX_VALUE) goto L7;
        r104 = true;
        goto L8
    }

    public static String e(int r100, int r101, int r102) {
        if (Intrinsics.areEqual(k(r100, r101), "1080p") == false) goto L7;
        if (r102 < 15) goto L7;
        return "L0";
    L7:
        if (Intrinsics.areEqual(k(r100, r101), "720p") == false) goto L11;
        if (r102 < 15) goto L11;
        return "L1";
    L11:
        if (Intrinsics.areEqual(k(r100, r101), "720p") == false) goto L14;
        return "L2";
    L14:
        if (Intrinsics.areEqual(k(r100, r101), "540p") == false) goto L16;
        return "L3";
    L16:
        return "L4";
    }

    public static void f(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "exceptionType");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "errorCode");
        Object r104 = f570544b;
        monitor-enter(r104);
        z68.a r105 = f570546d;     // Catch: Throwable -> L13
        monitor-exit(r104);
        LinkedHashMap r106 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("exception_type", r100), TuplesKt.to("reason", r101), TuplesKt.to("error_code", r102), TuplesKt.to("is_fatal", Boolean.valueOf(r103))});
        if (r105 == null) goto L9;
        c r107 = f570543a;
        int r108 = r105.f570533e;
        int r109 = r105.f570534f;
        int r110 = r105.f570535g;
        r107.getClass();
        r106.put("profile", e(r108, r109, r110));
    L9:
        g("flow_screen_share_capture_exception", r106);
        if (r103 == false) goto L18;
        b();
        return;
    L18:
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void h(String r100, int r101, int r110, int r111) {
        Object r102 = f570544b;
        monitor-enter(r102);
        z68.a r103 = f570546d;     // Catch: Throwable -> L16
        if (r103 != null) goto L9;
        monitor-exit(r102);
        return;
    L9:
        if (r103.f570536h == false) goto L12;
        monitor-exit(r102);
        return;
    L12:
        r103.f570529a = r100;     // Catch: Throwable -> L16
        r103.f570533e = r101;     // Catch: Throwable -> L16
        r103.f570534f = r110;     // Catch: Throwable -> L16
        r103.f570535g = r111;     // Catch: Throwable -> L16
        r103.f570536h = true;     // Catch: Throwable -> L16
        monitor-exit(r102);
        g("flow_screen_share_first_frame", MapsKt.mapOf(new Pair[]{TuplesKt.to("cost_ms", Integer.valueOf((int) (SystemClock.elapsedRealtime() - r103.f570530b))), TuplesKt.to("profile", e(r101, r110, r111)), TuplesKt.to("resolution", k(r101, r110)), TuplesKt.to("target_fps", Integer.valueOf(r111))}));
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static void a(String r110, int r111, int r112, int r113, e r114) {
        Intrinsics.checkNotNullParameter(r114, "policy");
        Object r115 = f570544b;
        monitor-enter(r115);
        b r100 = f570545c;     // Catch: Throwable -> L15
        if (r100 != null) goto L7;
        r100 = new b(SystemClock.elapsedRealtime(), "user_click", r114);     // Catch: Throwable -> L15
    L7:
        monitor-exit(r115);
        monitor-enter(r115);
        f570546d = new z68.a(r110, r100.f570540a, r100.f570541b, r114, r111, r112, r113);     // Catch: Throwable -> L12
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r115);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public static void d(String r100, int r101, int r102, int r103, boolean r104) {
        Object r105 = f570544b;
        monitor-enter(r105);
        z68.a r106 = f570546d;     // Catch: Throwable -> L14
        if (r106 != null) goto L8;
        monitor-exit(r105);
        return;
    L8:
        r106.f570529a = r100;     // Catch: Throwable -> L14
        r106.f570533e = r101;     // Catch: Throwable -> L14
        r106.f570534f = r102;     // Catch: Throwable -> L14
        r106.f570535g = r103;     // Catch: Throwable -> L14
        if (r104 == true) goto L11;
        r106.f570539k++;     // Catch: Throwable -> L14
    L11:
        f570543a.getClass();     // Catch: Throwable -> L14
        c(r106);     // Catch: Throwable -> L14
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r105);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void j(boolean r110, int r111, int r112, int r113, e r114, String r115, String r210) {
        Intrinsics.checkNotNullParameter(r114, "policy");
        long r116 = SystemClock.elapsedRealtime();
        Object r117 = f570544b;
        monitor-enter(r117);
        b r100 = f570545c;     // Catch: Throwable -> L40
        if (r100 != null) goto L7;
        r100 = new b(r116, "user_click", r114);     // Catch: Throwable -> L40
    L7:
        z68.a r101 = f570546d;     // Catch: Throwable -> L40
        if (r101 != null) goto L11;
        r101 = new z68.a(null, r100.f570540a, r100.f570541b, r114, r111, r112, r113);     // Catch: Throwable -> L40
    L11:
        r101.f570533e = r111;     // Catch: Throwable -> L40
        r101.f570534f = r112;     // Catch: Throwable -> L40
        r101.f570535g = r113;     // Catch: Throwable -> L40
        f570546d = r101;     // Catch: Throwable -> L40
        monitor-exit(r117);
        Pair[] r102 = new Pair[5];
        if (r110 == false) goto L16;
        String r103 = "success";
    L17:
        r102[0] = TuplesKt.to("result", r103);
        r102[1] = TuplesKt.to("start_cost_ms", Integer.valueOf((int) (r116 - r101.f570530b)));
        r102[2] = TuplesKt.to("profile", e(r111, r112, r113));
        r102[3] = TuplesKt.to("resolution", k(r111, r112));
        r102[4] = TuplesKt.to("target_fps", Integer.valueOf(r113));
        LinkedHashMap r104 = MapsKt.linkedMapOf(r102);
        if (r110 == false) goto L20;
    L28:
        g("flow_screen_share_start_result", r104);
        monitor-enter(r117);
        f570545c = null;     // Catch: Throwable -> L37
        if (r110 == true) goto L34;
        f570546d = null;     // Catch: Throwable -> L37
    L34:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r117);
        return;
    L37:
        th = move-exception;
        throw th;
    L20:
        if (r115 != null) goto L22;
        String r106 = "unknown";
    L23:
        r104.put("reason", r106);
        if (r210 != null) goto L26;
        String r107 = "unknown";
    L27:
        r104.put("error_code", r107);
        goto L28
    L26:
        r107 = r210;
        goto L27
    L22:
        r106 = r115;
        goto L23
    L16:
        r103 = "fail";
    L40:
        th = move-exception;
        throw th;
    }
}
