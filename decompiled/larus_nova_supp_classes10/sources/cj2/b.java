package cj2;

import android.os.SystemClock;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static String a;
    public static long b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static boolean f;

    static {
        a = "";
        b = -1;
    }

    public static void c() {
        d r0 = i.a.get(a);
        if (r0 == null) goto L6;
        r0.a("render_end");
        return;
    }

    public static void e(boolean r5) {
        e = true;
        i r0 = i.a;
        d r1 = r0.get(a);
        if (r1 == null) goto L9;
        if (r5 == false) goto L6;
        String r6 = "1";
    L7:
        r1.b("is_complete_load", r6);
        goto L9
    L6:
        r6 = BDLocationException.ERROR_TIMEOUT;
    L9:
        if (b <= 0) goto L13;
        d r7 = r0.get(a);
        if (r7 == null) goto L13;
        r7.b("stay_duration", Long.valueOf(SystemClock.elapsedRealtime() - b));
    L13:
        d r8 = r0.get(a);
        if (r8 == null) goto L16;
        r8.report();
    L16:
        a = "";
        b = -1;
    }

    public static void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        d r0 = i.a.get(a);
        if (r0 == null) goto L6;
        r0.b("video_preload_status", r2);
        return;
    }

    public static void a(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        d r0 = i.a.get(a);
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    public static void d(String r4, String r5) {
        i r0 = i.a;
        d r1 = r0.get(a);
        if (r1 == null) goto L5;
        r1.a("request_end");
    L5:
        d r2 = r0.get(a);
        if (r2 == null) goto L10;
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r2.b("video_url", r4);
    L10:
        d r6 = r0.get(a);
        if (r6 == null) goto L16;
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r6.b("video_id", r5);
    L16:
        if (b <= 0) goto L21;
        d r7 = r0.get(a);
        if (r7 == null) goto L22;
        r7.b("init_to_request_duration", Long.valueOf(SystemClock.elapsedRealtime() - b));
        return;
    L22:
        return;
    }

    public static void b(String r3, Integer r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "failedType");
        f(PromotionCategory.CATEGORY_TYPE_SECOND);
        i r0 = i.a;
        d r1 = r0.get(a);
        if (r1 == null) goto L5;
        r1.b("video_preload_failed_type", r3);
    L5:
        d r6 = r0.get(a);
        if (r6 == null) goto L11;
        if (r4 == null) goto L9;
        int r7 = r4.intValue();
    L10:
        r6.b("video_preload_error_code", Integer.valueOf(r7));
        goto L11
    L9:
        r7 = -1;
    L11:
        d r8 = r0.get(a);
        if (r8 == null) goto L17;
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        r8.b("video_preload_error_msg", r5);
        return;
    }
}
