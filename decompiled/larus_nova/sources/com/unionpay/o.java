package com.unionpay;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class o implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462168a;

    public o(UPPayWapActivity r100) {
        this.f462168a = r100;
    }

    @Override // com.unionpay.f
    public final void a(String r100, c r101) {
        String r102 = "";
        JSONObject r103 = new JSONObject(r100);     // Catch: Exception -> L17
        String r104 = (String) r103.get("url");     // Catch: Exception -> L9
        r102 = (String) r103.get("title");     // Catch: Exception -> L7
    L13:
        Bundle r105 = new Bundle();     // Catch: Exception -> L17
        r105.putString("waptype", "new_page");     // Catch: Exception -> L17
        r105.putString("magic_data", "949A1CC");     // Catch: Exception -> L17
        r105.putString("wapurl", r104);     // Catch: Exception -> L17
        r105.putString("waptitle", r102);     // Catch: Exception -> L17
        r105.putString(ReportConstant.COMMON_ACTION_TYPE, this.f462168a.f462123f);     // Catch: Exception -> L17
        Intent r106 = new Intent();     // Catch: Exception -> L17
        r106.putExtras(r105);     // Catch: Exception -> L17
        r106.setClass(this.f462168a, UPPayWapActivity.class);     // Catch: Exception -> L17
        this.f462168a.startActivity(r106);     // Catch: Exception -> L17
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
