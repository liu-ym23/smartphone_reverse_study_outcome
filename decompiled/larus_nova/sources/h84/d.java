package h84;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdinstall.c1;
import i84.s;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f484118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile String[] f484119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile String f484120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile JSONArray f484121l;

    @Override // h84.a, g84.a
    public final String c() {
        if (TextUtils.isEmpty(this.f484108f) == false) goto L5;
        SharedPreferences r100 = i84.a.a(this.f484103a, this.f484104b.f484151h);     // Catch: Exception -> L23
        String r101 = null;
        String r102 = r100.getString("clientudid", null);     // Catch: Exception -> L23
        if (c1.h(r102) == true) goto L15;
        r102 = UUID.randomUUID().toString();     // Catch: Exception -> L23
        c r103 = this.f484106d;     // Catch: Exception -> L23
        if (r103 == null) goto L12;
        r101 = (String) r103.g(null, r102, new f(r103));     // Catch: Exception -> L23
    L12:
        if (c1.h(r101) == false) goto L14;
        r102 = r101;
    L14:
        SharedPreferences.Editor r104 = r100.edit();     // Catch: Exception -> L23
        r104.putString("clientudid", r102);     // Catch: Exception -> L23
        r104.apply();     // Catch: Exception -> L23
    L19:
        if (TextUtils.isEmpty(r102) == true) goto L21;
        r102 = r102 + this.f484110h;     // Catch: Exception -> L23
    L21:
        this.f484108f = r102;     // Catch: Exception -> L23
        return r102;
    L15:
        c r105 = this.f484106d;     // Catch: Exception -> L23
        if (r105 == null) goto L19;
        String r106 = (String) r105.g(r102, null, new f(r105));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.f484108f;
    }

    @Override // g84.a
    public final void clearAll() {
        this.f484105c.e(Arrays.asList(new String[]{"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", "device_id", "install_id"}));
    }

    @Override // h84.a, g84.a
    public final String getOpenUdid() {
        if (TextUtils.isEmpty(this.f484107e) == false) goto L5;
        String r100 = null;
        String r101 = i84.e.a(this.f484103a.getContentResolver());     // Catch: Exception -> L9
    L11:
        SharedPreferences r102 = i84.a.a(this.f484103a, this.f484104b.f484151h);
        String r103 = r102.getString("openudid", null);
        if (c1.h(r101) == false) goto L22;
        if ("9774d56d682e549c".equals(r101) == true) goto L22;
        if (c1.h(r103) == false) goto L20;
        r101 = this.f484105c.h(r101, r103);     // Catch: Exception -> L43
        goto L45
    L20:
        r101 = this.f484105c.h(null, r101);     // Catch: Exception -> L43
    L22:
        if (c1.h(r103) == true) goto L39;
        r103 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L43
        if (r103.charAt(0) != '-') goto L26;
        r103 = r103.substring(1);     // Catch: Exception -> L43
    L26:
        int r104 = 13 - r103.length();     // Catch: Exception -> L43
        if (r104 <= 0) goto L32;
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L43
    L29:
        if (r104 <= 0) goto L31;
        r105.append('F');     // Catch: Exception -> L43
        r104 = r104 - 1;     // Catch: Exception -> L43
        goto L29
    L31:
        r105.append(r103);     // Catch: Exception -> L43
        r103 = r105.toString();     // Catch: Exception -> L43
    L32:
        c r106 = this.f484106d;     // Catch: Exception -> L43
        if (r106 == null) goto L36;
        r100 = r106.h(null, r103);     // Catch: Exception -> L43
    L36:
        if (c1.h(r100) == false) goto L38;
        r103 = r100;
    L38:
        SharedPreferences.Editor r107 = r102.edit();     // Catch: Exception -> L43
        r107.putString("openudid", r103);     // Catch: Exception -> L43
        r107.apply();     // Catch: Exception -> L43
    L42:
        r101 = r103;
        goto L45
    L39:
        c r108 = this.f484106d;     // Catch: Exception -> L43
        if (r108 == null) goto L42;
        r108.h(r103, null);     // Catch: Exception -> L43
    L45:
        if (TextUtils.isEmpty(r101) == true) goto L48;
        r101 = r101 + this.f484110h;
    L48:
        if (TextUtils.isEmpty(r101) == true) goto L50;
        this.f484107e = r101;
    L50:
        return r101;
    L9:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L11
    L5:
        return this.f484107e;
    }

    public d(Context r100, p r101) {
        super(r100, r101);
    }

    @Override // h84.a
    public final void d(p r210, c r211) {
        String r100 = "ZQLiNFJR+CWEI4px" + s.d();
        String r101 = new String(new char[]{r100.charAt(1), r100.charAt(3), r100.charAt(1), r100.charAt(11), r100.charAt(15), r100.charAt(10), r100.charAt(8), r100.charAt(17), r100.charAt(9), r100.charAt(9), r100.charAt(12), r100.charAt(13), r100.charAt(13), r100.charAt(5), r100.charAt(18), r100.charAt(13), r100.charAt(14), r100.charAt(11), r100.charAt(4), r100.charAt(19), r100.charAt(7)}).substring(2, 18);
        boolean r102 = !r210.f484147d;
        e r103 = new m(r102, Environment.getExternalStorageDirectory().getPath() + s.a("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U=") + this.f484110h, r210.f484144a, r101, r210.f484151h.a());     // Catch: Exception -> L9
        c r104 = r211;
        r104.f484122a = r103;     // Catch: Exception -> L7
    L17:
        r103.f484122a = new m(r102, Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + s.d() + this.f484110h, r210.f484144a, r101, r210.f484151h.a());     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = e;
    L11:
        e.printStackTrace();
        r103 = r104;
    L9:
        e = e;
        r104 = r211;
        goto L11
    }
}
