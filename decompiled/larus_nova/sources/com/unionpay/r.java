package com.unionpay;

import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462171a;

    public r(UPPayWapActivity r100) {
        this.f462171a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        this.f462171a.f462125h = r101;     // Catch: Exception -> L15
        String r102 = new JSONObject(r100).optString("scheme");     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r102) == true) goto L12;
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L15
        r103.setData(UriProtector.parse(r102));     // Catch: Exception -> L15
        this.f462171a.startActivity(r103);     // Catch: Exception -> L8
        return;
    L9:
        if (r101 == null) goto L22;
        r101.a(UPPayWapActivity.b("2", "Call application error", null));     // Catch: Exception -> L15
        return;
    L22:
        return;
    L12:
        if (r101 == null) goto L23;
        r101.a(UPPayWapActivity.b("1", "Parameter error", null));     // Catch: Exception -> L15
        return;
    L23:
        return;
    L15:
        e = move-exception;
        if (r101 == null) goto L24;
        r101.a(UPPayWapActivity.b("1", e.getMessage(), null));
        return;
    }
}
