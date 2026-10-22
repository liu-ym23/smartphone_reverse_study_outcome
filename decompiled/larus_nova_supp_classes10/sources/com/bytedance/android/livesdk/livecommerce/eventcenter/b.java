package com.bytedance.android.livesdk.livecommerce.eventcenter;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final Object a(String r4, String r5) {
        boolean r1 = false;
        switch(r4.hashCode()) {
            case -1973463853: goto L51;
            case -1597897555: goto L48;
            case -978037320: goto L45;
            case -265577398: goto L42;
            case -7280828: goto L39;
            case 99891402: goto L24;
            case 347793079: goto L21;
            case 778154636: goto L18;
            case 973440748: goto L15;
            case 1126556261: goto L12;
            case 1202449897: goto L9;
            case 1812807262: goto L6;
            default: goto L87;
        };
    L87:
        return null;
    L6:
        if (r4.equals("pop_card_show") == false) goto L69;
    L52:
        if (r5 != null) goto L54;
        return null;
    L54:
        if (r5.length() <= 0) goto L56;
        r1 = true;
    L56:
        if (r1 == false) goto L58;
        String r6 = r5;
    L59:
        if (r6 == null) goto L86;
        Object r7 = new JSONObject(r5);     // Catch: Exception -> L62
    L78:
        return r7;
    L62:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L86:
        return null;
    L58:
        r6 = null;
        goto L59
    L69:
        return null;
    L9:
        if (r4.equals("live_guide") == true) goto L52;
        return null;
    L12:
        if (r4.equals("show_toast") == true) goto L52;
        return null;
    L15:
        if (r4.equals("live_report_log") == true) goto L52;
        return null;
    L18:
        if (r4.equals("card_jump_to_order") == true) goto L52;
        return null;
    L21:
        if (r4.equals("pop_card_close") == true) goto L52;
        return null;
    L24:
        if (r4.equals("show_dialog") == true) goto L26;
        return null;
    L26:
        if (r5 != null) goto L28;
        return null;
    L28:
        if (r5.length() <= 0) goto L30;
        r1 = true;
    L30:
        if (r1 == true) goto L33;
        r5 = null;
    L33:
        if (r5 == null) goto L77;
        r7 = u0.b(r5, sl.k.class);     // Catch: Exception -> L36
    L36:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    L77:
        return null;
    L39:
        if (r4.equals("showPopCard") == true) goto L52;
        return null;
    L42:
        if (r4.equals("live_list_close") == true) goto L52;
        return null;
    L45:
        if (r4.equals("live_list_open") == true) goto L52;
        return null;
    L48:
        if (r4.equals("live_list_refresh") == true) goto L52;
        return null;
    L51:
        if (r4.equals("card_jump_to_detail") == true) goto L52;
        return null;
    }
}
