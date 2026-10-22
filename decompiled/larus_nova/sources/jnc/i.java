package jnc;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.Calendar;
import kotlin.text.StringsKt;
import v19.b7;

/* JADX INFO: loaded from: classes38.dex */
public final class i {
    public static final String a(Long r110) {
        Long r111 = Long.valueOf(r110.longValue() * 1000);
        if (r111 == null) goto L36;
        r111.longValue();
        if (r111.longValue() <= 0) goto L36;
        long r100 = System.currentTimeMillis();
        long r101 = r100 - r111.longValue();
        if (r101 > 0) goto L9;
    L13:
        boolean r102 = false;
        if (r101 <= 0) goto L19;
        if (r101 >= 3600000) goto L19;
        String r112 = AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_botsComment_commentTime_label_min, new Object[]{String.valueOf(Math.max(1, r101 / 60000))});     // Catch: IllegalArgumentException -> L11
    L38:
        return r112;
    L19:
        if (r101 > 0) goto L21;
    L23:
        if (r101 > 0) goto L25;
    L27:
        if (r101 <= 0) goto L33;
        long r103 = r111.longValue();     // Catch: IllegalArgumentException -> L11
        Calendar r104 = Calendar.getInstance();     // Catch: IllegalArgumentException -> L11
        r104.setTimeInMillis(r103);     // Catch: IllegalArgumentException -> L11
        int r105 = r104.get(1);     // Catch: IllegalArgumentException -> L11
        Calendar r106 = Calendar.getInstance();     // Catch: IllegalArgumentException -> L11
        r106.setTimeInMillis(r100);     // Catch: IllegalArgumentException -> L11
        if (r105 != r106.get(1)) goto L31;
        r102 = true;
    L31:
        if (r102 == false) goto L33;
        int r107 = b7.f552450a;     // Catch: IllegalArgumentException -> L11
        r112 = b7.a(r111.longValue() / ((long) 1000));     // Catch: IllegalArgumentException -> L11
    L33:
        Calendar r108 = Calendar.getInstance();     // Catch: IllegalArgumentException -> L11
        r108.setTimeInMillis(r111.longValue());     // Catch: IllegalArgumentException -> L11
        r112 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_notification_time_yymmdd), "%d_year", String.valueOf(r108.get(1)), false, 4, null), "%d_month", String.valueOf(r108.get(2) + 1), false, 4, null), "%d_day", String.valueOf(r108.get(5)), false, 4, null);     // Catch: IllegalArgumentException -> L11
        goto L38
    L25:
        if (r101 >= 604800000) goto L27;
        r112 = AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_botsComment_commentTime_label_day, new Object[]{String.valueOf(r101 / 86400000)});     // Catch: IllegalArgumentException -> L11
        goto L38
    L21:
        if (r101 >= 86400000) goto L23;
        r112 = AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_botsComment_commentTime_label_hour, new Object[]{String.valueOf(r101 / 3600000)});     // Catch: IllegalArgumentException -> L11
        goto L38
    L9:
        if (r101 >= 60000) goto L13;
        r112 = AppHost.f326268a.getApplication().getApplicationContext().getString(R.string.larus_botsComment_commentTime_label_justNow);     // Catch: IllegalArgumentException -> L11
    L11:
        e = move-exception;
        FLogger.f375446a.e("timestamp2Str", "in exception:" + e.getMessage());
        return "";
    L36:
        return null;
    }
}
