package yw0;

import ay0.c;
import bx0.d;
import com.bytedance.android.live.recharge.utils.e;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.recharge.utils.r;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import jta.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f569334a;

    public a() {
        this.f569334a = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bx0.d
    public final boolean g() {
        int r100 = c.a();
        int r101 = e.f90456a;
        boolean r102 = false;
        if (r100 == 0) goto L42;
        if (r.b() == true) goto L66;
        HashMap r103 = (HashMap) r.f90502h.getValue(null, r.f90495a[7]);
        Long r104 = (Long) r103.get("show_times");
        if (r104 != null) goto L10;
        r104 = 0L;
    L10:
        long r105 = r104.longValue();
        Long r106 = (Long) r103.get("timestamp");
        if (r106 != null) goto L13;
        r106 = 0L;
    L13:
        long r110 = r106.longValue();
        if (c.a() != 2) goto L22;
        if (r105 >= 1) goto L19;
        a(r105 + 1);
    L63:
        r102 = true;
        goto L66
    L19:
        if ((System.currentTimeMillis() - r110) < BaseConstants.Time.DAY) goto L66;
        a(1);
        goto L63
    L22:
        if (c.a() == 3) goto L24;
        Long r107 = (Long) r103.get("click_exchange");
        if (r107 != null) goto L32;
        r107 = 0L;
    L32:
        long r108 = r107.longValue();
        Long r111 = (Long) r103.get("click_exchange_timestamp");
        if (r111 != null) goto L35;
        r111 = 0L;
    L35:
        long r112 = r111.longValue();
        if (r108 == 0) goto L63;
        if ((System.currentTimeMillis() - r112) < BaseConstants.Time.WEEK) goto L66;
        r103.put("click_exchange", 0L);
        r103.put("click_exchange_timestamp", Long.valueOf(System.currentTimeMillis()));
        r.d(r103);
        goto L63
    L24:
        if (r105 >= 3) goto L27;
        a(r105 + 1);
        goto L63
    L27:
        if ((System.currentTimeMillis() - r110) < BaseConstants.Time.WEEK) goto L66;
        a(1);
    L66:
        this.f569334a = r102;
        return r102;
    L42:
        if (c.b() == 0) goto L45;
        boolean r109 = r.b();
    L65:
        r102 = !r109;
        goto L66
    L45:
        if (c.c() == 0) goto L47;
        r109 = r.b();
        goto L65
    L47:
        int r113 = j.b();
        if (r113 == 1) goto L64;
        if (r113 == 2) goto L64;
        String r114 = (String) ((Map) r.f90496b.getValue(null, r.f90495a[0])).get(g.d());
        if (r114 == null) goto L63;
        Intrinsics.checkNotNullParameter(r114, "date");
        if (r114.length() != 0) goto L55;
        boolean r115 = true;
    L57:
        if (r115 == false) goto L59;
        Date r116 = null;
    L60:
        if (r116 == null) goto L63;
        SimpleDateFormat r117 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        Date r118 = r117.parse(r117.format(new Date(System.currentTimeMillis())));
        Calendar r119 = Calendar.getInstance();
        r119.setTime(r116);
        Calendar r120 = Calendar.getInstance();
        r120.setTime(r118);
        if (((r120.getTimeInMillis() - r119.getTimeInMillis()) / ((long) BaseConstants.Time.DAY)) <= ((com.bytedance.android.live.recharge.utils.d) j.f90465b.getValue(null, j.f90464a[0])).a()) goto L66;
    L59:
        r116 = new SimpleDateFormat("yyyy-MM-dd-HH-mm").parse(r114);
        goto L60
    L55:
        r115 = false;
    L64:
        r109 = r.b();
        goto L65
    }

    @Override // bx0.d
    public final boolean c() {
        return this.f569334a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(long r100) {
        HashMap r101 = (HashMap) r.f90502h.getValue(null, r.f90495a[7]);
        r101.put("show_times", Long.valueOf(r100));
        r101.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r.d(r101);
    }
}
