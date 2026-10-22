package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277193a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f277194b = null;

    public class a extends HashSet<String> {
        public a(int r100) {
            super(r100);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    static {
        f277194b = Collections.unmodifiableSet(new a(16));
    }

    private static String a(Context r100, com.huawei.hms.framework.network.grs.e.a r110, String r111, GrsBaseInfo r112, boolean r113) {
        String r101 = r112.getSerCountry();
        String r102 = r112.getRegCountry();
        String r103 = r112.getIssueCountry();
        String[] r114 = r111.split(">");
        int r104 = r114.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L32;
        String r106 = r114[r105];
        if (f277194b.contains(r106.trim()) == false) goto L31;
        if ("ser_country".equals(r106.trim()) == false) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if ("UNKNOWN".equals(r101) == true) goto L15;
        String r107 = f277193a;
        StringBuilder r115 = new StringBuilder("current route_by is serCountry and routerCountry is: ");
    L13:
        r115.append(r101);
        Logger.i(r107, r115.toString());
        return r101;
    L15:
        if ("reg_country".equals(r106.trim()) == false) goto L22;
        if (TextUtils.isEmpty(r102) == true) goto L22;
        if ("UNKNOWN".equals(r102) == true) goto L22;
        Logger.i(f277193a, "current route_by is regCountry and routerCountry is: " + r102);
        return r102;
    L22:
        if ("issue_country".equals(r106.trim()) == false) goto L29;
        if (TextUtils.isEmpty(r103) == true) goto L29;
        if ("UNKNOWN".equals(r103) == true) goto L29;
        Logger.i(f277193a, "current route_by is issueCountry and routerCountry is: " + r103);
        return r103;
    L29:
        if ("geo_ip".equals(r106.trim()) == false) goto L31;
        r101 = new com.huawei.hms.framework.network.grs.g.b(r100, r110, r112).a(r113);
        r107 = f277193a;
        r115 = new StringBuilder("current route_by is geo_ip and routerCountry is: ");
    L31:
        r105 = r105 + 1;
        goto L3
    L32:
        return "";
    }

    public static String b(Context r100, com.huawei.hms.framework.network.grs.e.a r101, String r102, GrsBaseInfo r103, boolean r104) {
        if (TextUtils.isEmpty(r102) == false) goto L7;
        Logger.w(f277193a, "routeBy must be not empty string or null.");
        return null;
    L7:
        if ("no_route".equals(r102) == false) goto L9;
    L13:
        Logger.v(f277193a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    L9:
        if ("unconditional".equals(r102) == true) goto L13;
        return a(r100, r101, r102, r103, r104);
    }
}
