package com.unionpay;

import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class q implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462170a;

    public q(UPPayWapActivity r100) {
        this.f462170a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r110, c r111) {
        this.f462170a.f462125h = r111;     // Catch: Exception -> L39
        JSONObject r100 = new JSONObject(r110);     // Catch: Exception -> L39
        String r112 = JSONObjectProtectorUtils.getString(r100, "packageName");     // Catch: Exception -> L39
        String r101 = JSONObjectProtectorUtils.getString(r100, "type");     // Catch: Exception -> L39
        String r102 = r100.optString("openParams");     // Catch: Exception -> L39
        String r103 = r100.optString("tn");     // Catch: Exception -> L39
        String r104 = r100.optString("extra");     // Catch: Exception -> L39
        if ("0".equals(r101) == false) goto L21;
        if (TextUtils.isEmpty(r112) == false) goto L9;
    L17:
        if (r111 == null) goto L50;
        r111.a(UPPayWapActivity.b("1", "Parameter error", null));     // Catch: Exception -> L39
        return;
    L50:
        return;
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L17;
        Intent r105 = new Intent();     // Catch: Exception -> L39
        r105.setClassName(r112, "com.unionpay.uppay.PayActivity");     // Catch: Exception -> L39
        r105.putExtra("paydata", r103);     // Catch: Exception -> L39
        int r113 = UPPayWapActivity.f462117i;     // Catch: Exception -> L39
        r105.putExtra("ex_mode", this.f462170a.f462122e);     // Catch: Exception -> L39
        r105.putExtra("extra", r104);     // Catch: Exception -> L39
        this.f462170a.startActivityForResult(r105, 1);     // Catch: Exception -> L13
        return;
    L14:
        if (r111 == null) goto L48;
        r111.a(UPPayWapActivity.b("2", "Call application error", null));     // Catch: Exception -> L39
        return;
    L48:
        return;
    L21:
        if ("2".equals(r101) == true) goto L23;
        if (r111 == null) goto L52;
        r111.a(UPPayWapActivity.b("1", "Parameter error", null));     // Catch: Exception -> L39
        return;
    L52:
        return;
    L23:
        if (TextUtils.isEmpty(r102) == true) goto L33;
        Intent r106 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L39
        r106.setData(UriProtector.parse(r102));     // Catch: Exception -> L39
        r106.putExtra("extra", r104);     // Catch: Exception -> L39
        if (TextUtils.isEmpty(r112) == true) goto L43;
        r106.setPackage(r112);     // Catch: Exception -> L39
    L43:
        this.f462170a.startActivityForResult(r106, 1);     // Catch: Exception -> L29
        return;
    L30:
        if (r111 == null) goto L49;
        r111.a(UPPayWapActivity.b("2", "Call application error", null));     // Catch: Exception -> L39
        return;
    L49:
        return;
    L33:
        if (r111 == null) goto L51;
        r111.a(UPPayWapActivity.b("1", "Parameter error", null));     // Catch: Exception -> L39
        return;
    L51:
        return;
    L39:
        e = move-exception;
        if (r111 == null) goto L53;
        r111.a(UPPayWapActivity.b("1", e.getMessage(), null));
        return;
    }
}
