package tv3;

import com.larus.platform.service.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static JSONObject a(d r10, boolean r11) {
        JSONObject r0 = new JSONObject();
        r0.put("start_point", r10.b);
        r0.put("end_point", r10.c);
        r0.put("transport_mode", r10.d);
        r0.put("outlink_id", r10.a);
        r0.put("outlink_mode", r10.e);
        r0.put("is_direct_fallback", r11 ? 1 : 0);
        r0.put("installed_app_list", CollectionsKt.joinToString$default(r10.i, ",", null, null, 0, null, null, 62, null));
        r0.put("allowed_app_list", CollectionsKt.joinToString$default(r10.j, ",", null, null, 0, null, null, 62, null));
        r0.put("dialog_app_list", CollectionsKt.joinToString$default(r10.h, ",", null, null, 0, null, null, 62, null));
        r0.put("backup", r10.g);
        r0.put("from_detail", r10.f);
        return r0;
    }

    public static void b(String r2, JSONObject r3) {
        int r0 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.a("nav_chooser_track", r2 + " params=" + r3);
        o.a.reportEvent(r2, r3);
    }

    public static void c(d r6, boolean r7, c r8) {
        Intrinsics.checkNotNullParameter(r6, "session");
        Intrinsics.checkNotNullParameter(r8, "outcome");
        boolean r0 = r8 instanceof c.C0175c;
        if (r0 == false) goto L6;
        StringBuilder r2 = new StringBuilder("Pick(toDetail=");
        c.C0175c r3 = (c.C0175c) r8;
        r2.append(r3.a);
        r2.append(", appRank=");
        r2.append(r3.b);
        r2.append(", isAppStore=");
        r2.append(r3.c);
        r2.append(')');
        String r1 = r2.toString();
    L11:
        int r4 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_chooser_track", "trackPopupClick: enter outlinkId=" + r6.a + " outlinkMode=" + r6.e + " isDirectFallback=" + r7 + " outcome=" + r1);
        JSONObject r9 = a(r6, r7);
        if (r0 == false) goto L15;
        r9.put("is_close", 0);
        c.C0175c r10 = (c.C0175c) r8;
        r9.put("is_app_store", r10.c ? 1 : 0);
        r9.put("app_rank", r10.b);
        r9.put("to_detail", r10.a);
    L20:
        b("doubao_apps_map_nav_outlink_popup_click", r9);
        return;
    L15:
        if (Intrinsics.areEqual(r8, c.a.a) == false) goto L18;
        r9.put("is_close", 1);
        r9.put("is_app_store", 0);
        r9.put("to_detail", "cancel");
        goto L20
    L18:
        if ((r8 instanceof c.b) == false) goto L23;
        r9.put("is_close", 0);
        r9.put("is_app_store", 0);
        r9.put("app_rank", 1);
        r9.put("to_detail", ((c.b) r8).a);
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L6:
        if (Intrinsics.areEqual(r8, c.a.a) == false) goto L9;
        r1 = "Cancel";
        goto L11
    L9:
        if ((r8 instanceof c.b) == false) goto L25;
        r1 = "Direct(toDetail=" + ((c.b) r8).a + ')';
        goto L11
    L25:
        throw new NoWhenBranchMatchedException();
    }
}
