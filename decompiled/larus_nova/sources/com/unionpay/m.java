package com.unionpay;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class m implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462166a;

    public m(UPPayWapActivity r100) {
        this.f462166a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        String r102 = "";
        JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L17
        String r104 = (String) r103.get("resultCode");     // Catch: Exception -> L9
        r102 = (String) r103.get(OnekeyLoginConstants.CU_KEY_RESULT_DATA);     // Catch: Exception -> L7
    L13:
        UPPayWapActivity r105 = this.f462166a;     // Catch: Exception -> L17
        int r106 = UPPayWapActivity.f462117i;     // Catch: Exception -> L17
        r105.a(r104, r102);     // Catch: Exception -> L17
        if (r101 == null) goto L27;
        r101.a(UPPayWapActivity.b("0", "success", null));     // Catch: Exception -> L17
        return;
    L27:
        return;
    L7:
        Exception e100 = e;
    L11:
        if (r101 == null) goto L13;
        r101.a(UPPayWapActivity.b("1", e100.getMessage(), null));     // Catch: Exception -> L17
    L9:
        e = move-exception;
        e100 = e;
        r104 = "";
    L17:
        e = move-exception;
        if (r101 == null) goto L28;
        r101.a(UPPayWapActivity.b("1", e.getMessage(), null));
        return;
    }
}
