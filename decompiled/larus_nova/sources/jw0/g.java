package jw0;

import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.livesdk.utils.r1;
import com.bytedance.android.livesdk.utils.u6;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static u6 a() {
        String r100 = (String) j.f90469f.getValue(null, j.f90464a[4]);
        u6 r101 = new u6(r100);
        String r102 = r101.a("url");
        if (r102 == null) goto L14;
        u6 r103 = new u6(r102);
        String r104 = "1";
        if (((wh6.a) vh6.c.b(wh6.a.class)).Wb() == false) goto L7;
        String r105 = "1";
    L8:
        r103.b("new_exchange_type", r105);
        if (((wh6.a) vh6.c.b(wh6.a.class)).wn() == true) goto L12;
        r104 = "0";
    L12:
        r103.b("show_authorize", r104);
        r103.b("app_name", ((wh6.a) vh6.c.b(wh6.a.class)).getAppName());
        r103.b("exchange_authority_content", ((wh6.a) vh6.c.b(wh6.a.class)).o8());
        r101.b("url", r103.toString());
        r100 = r101.toString();
        goto L14
    L7:
        r105 = "0";
    L14:
        return new u6(r100);
    }

    static {
    }

    public static String b(int r100) {
        if (r100 != 0) goto L5;
        return String.valueOf(r100);
    L5:
        return r1.b("%.2f", new Object[]{Float.valueOf(r100 / 100.0f)});
    }
}
