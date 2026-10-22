package cj2;

import com.bytedance.android.ec.core.utils.g;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideEventServiceFactory;
import com.bytedance.android.livesdk.livecommerce.event.k;
import com.bytedance.bdlocation.exception.BDLocationException;
import el2.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static c a;
    public static boolean b;
    public static final C0001a c = null;

    /* JADX INFO: renamed from: cj2.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        public i a;

        public C0001a() {
            this.a = ECLiveCommerceModel_ProvideEventServiceFactory.proxyProvideEventService(hh2.a.a().f);
        }
    }

    public a() {
    }

    static {
        c = new C0001a();
    }

    public static /* synthetic */ void c(String r6, String r7) {
        b(r6, r7, null, null, null, null);
    }

    public static void e(Integer r2, String r3, String r4) {
        HashMap r0 = new HashMap();
        if (r2 == null) goto L6;
        String r5 = String.valueOf(r2.intValue());
        if (r5 == null) goto L6;
    L7:
        r0.put("duration", r5);
        a("livesdk_explain_replay_tolive_click", r0, r3, r4);
        return;
    L6:
        r5 = "";
        goto L7
    }

    public static void f(String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        HashMap r5 = new HashMap();
        r5.put("duration", "");
        a("livesdk_explain_replay_tolive_show", r5, r2, r3);
    }

    public static void a(String r3, Map r4, String r5, String r6) {
        i r0 = c.a;
        if (r0 == null) goto L31;
        k r7 = r0.a(r3);
        if (r7 == null) goto L32;
        c r1 = a;
        if (r1 == null) goto L15;
        HashMap<String, String> r2 = r1.a;
        if (r2 == null) goto L15;
        Iterator<Map.Entry<String, String>> r8 = r2.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L15;
        Map.Entry<String, String> r9 = r8.next();
        r7.c(r9.getKey(), r9.getValue());
    L15:
        if (b == false) goto L17;
        String r10 = "1";
    L18:
        r7.c("subtitle_status", r10);
        c r11 = a;
        if (r11 == null) goto L21;
        r7.c("system_volume_pct", String.valueOf(Double.valueOf(r11.b).doubleValue()));
    L21:
        r7.c("end_volume_pct", String.valueOf(g.a()));
        if (r4 == null) goto L27;
        Iterator r12 = r4.entrySet().iterator();
    L25:
        if (r12.hasNext() == false) goto L27;
        Map.Entry r13 = (Map.Entry) r12.next();
        r7.c((String) r13.getKey(), (String) r13.getValue());
    L27:
        r7.l(r5, r6);
        return;
    L17:
        r10 = BDLocationException.ERROR_TIMEOUT;
        goto L18
    L32:
        return;
    }

    public static void d(String r2, Integer r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "cardStatus");
        HashMap r0 = new HashMap();
        r0.put("card_status", r2);
        r0.put("ecom_entrance_form", "replay_popup_card");
        if (r3 == null) goto L5;
        String r7 = (String) r0.put("is_replay_default_product", String.valueOf(r3.intValue()));
    L5:
        if (r4 == null) goto L7;
        r0.put("replay_type", r4);
    L7:
        a("livesdk_replay_popup_card_show", r0, r5, r6);
    }

    public static void b(String r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "clickArea");
        HashMap r0 = new HashMap();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("card_status", r3);
        r0.put("click_area", r2);
        r0.put("ecom_entrance_form", "replay_popup_card");
        if (r4 == null) goto L8;
        String r8 = (String) r0.put("is_replay_default_product", r4);
    L8:
        if (r5 == null) goto L10;
        r0.put("replay_type", r5);
    L10:
        a("livesdk_replay_popup_card_click", r0, r6, r7);
    }
}
