package com.unionpay;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class p implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462169a;

    public p(UPPayWapActivity r100) {
        this.f462169a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r110, c r111) {
        JSONArray r100 = new JSONArray(r110);     // Catch: Exception -> L56
        if (r100.length() <= 0) goto L53;
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L56
        int r101 = 0;
    L7:
        if (r101 >= r100.length()) goto L50;
        JSONObject r102 = JSONArrayProtectorUtils.getJSONObject(r100, r101);     // Catch: Exception -> L56
        String r103 = JSONObjectProtectorUtils.getString(r102, "packageName");     // Catch: Exception -> L56
        String r104 = JSONObjectProtectorUtils.getString(r102, "packageSign");     // Catch: Exception -> L56
        String r105 = JSONObjectProtectorUtils.getString(r102, "supportVersion");     // Catch: Exception -> L56
        UPPayWapActivity r106 = this.f462169a;     // Catch: Exception -> L56
        HashMap r107 = com.unionpay.utils.b.f462195a;     // Catch: Exception -> L56
        if (r106 != null) goto L68;
    L45:
        boolean r113 = false;
    L46:
        if (r113 == false) goto L48;
        String r108 = "1";
    L49:
        r112.put(r103, r108);     // Catch: Exception -> L56
        r101 = r101 + 1;     // Catch: Exception -> L56
        goto L7
    L48:
        r108 = "0";
        goto L49
    L68:
        if (TextUtils.isEmpty(r103) == true) goto L45;
        if (TextUtils.isEmpty(r104) == true) goto L45;
        if (TextUtils.isEmpty(r105) == true) goto L45;
        if (TextUtils.isEmpty(r103) == false) goto L63;
    L22:
        int r109 = 0;
    L66:
        int r114 = CastIntegerProtector.valueOf(r105, 10).intValue();     // Catch: Exception -> L26
    L61:
        PackageManager r115 = r106.getPackageManager();     // Catch: Exception -> L33
        if (r115 == null) goto L34;
        if (TextUtils.isEmpty(r103) == true) goto L34;
        PackageInfo r116 = r115.getPackageInfo(r103, 0);     // Catch: Exception -> L33
    L35:
        r113 = true;
        if (r116 == null) goto L38;
        boolean r117 = true;
    L39:
        if (r117 == false) goto L45;
        if (r109 < r114) goto L45;
        if (r104.equalsIgnoreCase(com.unionpay.utils.b.c(r106, r103, "SHA256")) == false) goto L45;
    L38:
        r117 = false;
    L34:
        r116 = null;
    L26:
        r114 = Integer.MAX_VALUE;
        goto L61
    L63:
        PackageInfo r118 = r106.getPackageManager().getPackageInfo(r103, 0);     // Catch: Exception -> L60
        if (r118 == null) goto L22;
        r109 = r118.versionCode;     // Catch: Exception -> L60
    L50:
        if (r111 == null) goto L73;
        r111.a(UPPayWapActivity.c("success", r112));     // Catch: Exception -> L56
        return;
    L73:
        return;
    L53:
        if (r111 == null) goto L74;
        r111.a(UPPayWapActivity.b("1", "Parameter error", null));     // Catch: Exception -> L56
        return;
    L74:
        return;
    L56:
        e = move-exception;
        if (r111 == null) goto L75;
        r111.a(UPPayWapActivity.b("1", e.getMessage(), null));
        return;
    }
}
