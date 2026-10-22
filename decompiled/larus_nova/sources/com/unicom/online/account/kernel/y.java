package com.unicom.online.account.kernel;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    h f462116a;

    public y() {
        this.f462116a = null;
    }

    public final void a(int r100, int r101, String r102, String r103, String r104) {
        aj.a("typeTokenUaid=".concat(String.valueOf(r100)));
    L11:
        e = move-exception;
        aj.a(e);
        return;
    L4:
        if (this.f462116a != null) goto L7;
        return;
    L7:
        if (an.a(r104).booleanValue() == false) goto L9;
        r104 = i.g();     // Catch: Exception -> L11
    L9:
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L11
        r105.put("resultCode", r101);     // Catch: Exception -> L11
        r105.put("resultMsg", r102);     // Catch: Exception -> L11
        r105.put(OnekeyLoginConstants.CU_KEY_RESULT_DATA, r103);     // Catch: Exception -> L11
        r105.put(OnekeyLoginConstants.CU_KEY_SEQ, r104);     // Catch: Exception -> L11
        this.f462116a.onResult(r105.toString());     // Catch: Exception -> L11
        this.f462116a = null;     // Catch: Exception -> L11
    }
}
