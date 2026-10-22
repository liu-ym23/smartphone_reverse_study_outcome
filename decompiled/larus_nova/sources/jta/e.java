package jta;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.common.utility.StringUtils;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f500363h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static JSONArray f500364i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String[] f500365j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f500366k;

    public final String e() {
        if (StringUtils.isEmpty(f500366k) == false) goto L5;
        String r100 = pta.c.q(this.f500346a);     // Catch: Exception -> L11
        if (StringUtils.isEmpty(r100) == true) goto L9;
        r100 = r100 + this.f500349d;     // Catch: Exception -> L11
    L9:
        f500366k = r100;     // Catch: Exception -> L11
        return r100;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return f500366k;
    }

    public final String[] f() {
        String[] r100 = f500365j;
        if (r100 != null) goto L5;
    L18:
        String[] r101 = pta.c.r(this.f500346a);     // Catch: Exception -> L15
        int r102 = 0;
        if (r101 != null) goto L11;
        r101 = new String[0];     // Catch: Exception -> L15
    L11:
        if (r102 >= r101.length) goto L13;
        r101[r102] = r101[r102] + this.f500349d;     // Catch: Exception -> L15
        r102 = r102 + 1;     // Catch: Exception -> L15
        goto L11
    L13:
        f500365j = r101;     // Catch: Exception -> L15
        return r101;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r100.length <= 0) goto L18;
        return r100;
    }

    public final String g() {
        if (StringUtils.isEmpty(f500363h) == true) goto L25;
        return f500363h;
    L25:
        Context r100 = this.f500346a;     // Catch: Exception -> L20
        pta.c.a r101 = pta.c.f530684a;     // Catch: Exception -> L20
        if (r100 != null) goto L10;
    L9:
        String r102 = null;
    L16:
        if (StringUtils.isEmpty(r102) == true) goto L18;
        r102 = r102 + this.f500349d;     // Catch: Exception -> L20
    L18:
        f500363h = r102;     // Catch: Exception -> L20
        return r102;
    L10:
        g r103 = g.f500367a;     // Catch: Exception -> L20
        pta.d.a r104 = pta.d.f530685a;     // Catch: Exception -> L20
        r102 = pta.c.h((TelephonyManager) r100.getSystemService("phone"));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public e(Context r100, boolean r101) {
        super(r100, r101);
    }
}
