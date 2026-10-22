package dk9;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.x3;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements ik7.d {
    public b() {
    }

    @Override // ik7.d
    public final void a() {
    }

    @Override // ik7.d
    public final void b() {
    }

    @Override // ik7.d
    public final void onAppLogEvent(String r100, JSONObject r101) {
        if (r100 == null) goto L41;
        TrackParams r102 = new TrackParams().merge(r101);
        by7.a r103 = new by7.a(r100);
        r103.f21463a.merge(r102);
        r103.b();
        switch(r100.hashCode()) {
            case -372461606: goto L37;
            case 980582315: goto L27;
            case 1323928651: goto L23;
            case 1482991238: goto L19;
            case 1850756396: goto L7;
            default: goto L49;
        };
    L49:
        return;
    L7:
        if (r100.equals("luckydog_counter_monitor") == false) goto L50;
        if (r101 == null) goto L11;
        String r104 = r101.optString("status_type");
    L13:
        if (Intrinsics.areEqual(r104, "start_count") == false) goto L16;
        x3.a("luckydog", "sdk_counter_count_started", null);
        return;
    L16:
        if (Intrinsics.areEqual(r104, "done_success") == false) goto L43;
        x3.a("luckydog", "sdk_counter_task_completed", null);
        return;
    L43:
        return;
    L11:
        r104 = null;
        goto L13
    L50:
        return;
    L19:
        if (r100.equals("lucky_host_deeplink") == false) goto L51;
        x3.a("luckydog", "sdk_deeplink_handled", null);
        return;
    L51:
        return;
    L23:
        if (r100.equals("task_counter_click") == false) goto L52;
        x3.a("luckydog", "sdk_counter_pendant_clicked", null);
        return;
    L52:
        return;
    L27:
        if (r100.equals("luckydog_reack_install_finish") == false) goto L53;
        if (r101 != null) goto L31;
    L33:
        boolean r105 = false;
    L34:
        if (r105 == false) goto L47;
        x3.a("luckydog", "sdk_reack_install_succeeded", null);
        return;
    L47:
        return;
    L31:
        if (r101.optInt("error_code", -1) != 0) goto L33;
        r105 = true;
        goto L34
    L53:
        return;
    L37:
        if (r100.equals("task_counter_show") == false) goto L54;
        x3.a("luckydog", "sdk_counter_pendant_shown", null);
        return;
    L54:
        return;
    }

    @Override // ik7.d
    public final void c(int r100, String r101, String r102) {
        boolean r103 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L58;
        if (r101 != null) goto L11;
    L13:
        r103 = false;
    L14:
        if (r103 == false) goto L17;
        return;
    L17:
        if (r100 != 2) goto L19;
        FLogger r105 = FLogger.f375446a;
        if (r101 != null) goto L54;
        r101 = "";
    L54:
        if (r102 != null) goto L56;
        r102 = "";
    L56:
        r105.v(r101, r102);
        return;
    L19:
        if (r100 != 3) goto L21;
        FLogger r106 = FLogger.f375446a;
        if (r101 != null) goto L48;
        r101 = "";
    L48:
        if (r102 != null) goto L50;
        r102 = "";
    L50:
        r106.d(r101, r102);
        return;
    L21:
        if (r100 != 4) goto L23;
        FLogger r107 = FLogger.f375446a;
        if (r101 != null) goto L42;
        r101 = "";
    L42:
        if (r102 != null) goto L44;
        r102 = "";
    L44:
        r107.i(r101, r102);
        return;
    L23:
        if (r100 != 5) goto L25;
        FLogger r108 = FLogger.f375446a;
        if (r101 != null) goto L36;
        r101 = "";
    L36:
        if (r102 != null) goto L38;
        r102 = "";
    L38:
        r108.w(r101, r102);
        return;
    L25:
        if (r100 != 6) goto L64;
        FLogger r109 = FLogger.f375446a;
        if (r101 != null) goto L30;
        r101 = "";
    L30:
        if (r102 != null) goto L32;
        r102 = "";
    L32:
        r109.e(r101, r102);
        return;
    L64:
        return;
    L11:
        if (StringsKt.contains$default(r101, "InterceptorUtil", false, 2, null) != true) goto L13;
    L58:
        return;
    L5:
        if (StringsKt.contains$default(r101, "LuckyDogFeedbackInterceptor", false, 2, null) != true) goto L7;
        r104 = true;
        goto L8
    }
}
