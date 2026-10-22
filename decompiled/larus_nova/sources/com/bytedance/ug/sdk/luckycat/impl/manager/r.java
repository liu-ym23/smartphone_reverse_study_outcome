package com.bytedance.ug.sdk.luckycat.impl.manager;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class r implements pi7.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r f271366b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile JSONObject f271367a;

    static {
        f271366b = new r();
    }

    public r() {
    }

    public final String a(int r100) {
        m r101 = m.a.f271349a;
        com.bytedance.ug.sdk.luckycat.api.depend.j r102 = r101.f271336d;
        String r103 = CJPayConstant.TT_CJ_PAY_FOLLOW_HOST;
        if (r102 == null) goto L13;
        StringBuilder r104 = new StringBuilder();
        bn7.e r105 = ((cn7.e) r101.f271336d).f24556a;
        if (r105 == null) goto L7;
        r105.getHost();
        String r106 = CJPayConstant.TT_CJ_PAY_FOLLOW_HOST;
    L8:
        r104.append(r106);
        r104.append(HTTP.URL_DEFAULT);
        bn7.e r107 = ((cn7.e) r101.f271336d).f24556a;
        if (r107 == null) goto L11;
        r107.c();
        String r108 = "luckycat/aweme_fission";
    L12:
        r104.append(r108);
        r104.append(HTTP.URL_DEFAULT);
        String r109 = r104.toString();
    L14:
        String r110 = com.bytedance.ug.sdk.luckycat.impl.utils.z.c(r109);
        switch(r100) {
            case 1: goto L58;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L16;
        };
    L16:
        String r111 = "";
    L60:
        if (TextUtils.isEmpty(r111) == false) goto L63;
        return "";
    L63:
        if (r111.endsWith(HTTP.URL_DEFAULT) == true) goto L68;
        com.bytedance.ug.sdk.luckycat.api.depend.d r112 = r101.f271337e;
        if (r112 == null) goto L68;
        ((cn7.a) r112).a();
    L68:
        return r111;
    L17:
        r111 = r110 + "page/apprentices";
        goto L60
    L18:
        r111 = r110 + "page/withdraw";
        goto L60
    L19:
        r111 = r110 + "page/strategy";
        goto L60
    L20:
        r111 = r110 + "page/feedback";
        goto L60
    L21:
        r111 = r110 + "page/apprentices";
        goto L60
    L22:
        r111 = r110 + "page/profits?profit_type=cash";
        goto L60
    L23:
        r111 = r110 + "page/profits?profit_type=score";
        goto L60
    L24:
        r111 = r110 + "page/profits";
        goto L60
    L58:
        r111 = r110 + "page/invitation_code";
        goto L60
    L26:
        if (TextUtils.isEmpty("task_page_url") == false) goto L29;
    L36:
        r111 = "";
    L56:
        if (TextUtils.isEmpty(r111) == false) goto L60;
        r111 = r110 + "page/task";
        goto L60
    L29:
        if (this.f271367a == null) goto L36;
        JSONObject r113 = this.f271367a.optJSONObject("task_page_url");
        if (r113 == null) goto L36;
        String r114 = r113.optString("value");
        if (TextUtils.isEmpty(r114) == true) goto L36;
        if (r114.startsWith(HTTP.URL_DEFAULT) == false) goto L47;
        StringBuilder r115 = new StringBuilder();
        com.bytedance.ug.sdk.luckycat.api.depend.j r116 = r101.f271336d;
        if (r116 != null) goto L42;
        r103 = "";
    L46:
        r115.append(r103);
        r115.append(r114);
        r111 = r115.toString();
        goto L56
    L42:
        bn7.e r117 = ((cn7.e) r116).f24556a;
        if (r117 == null) goto L45;
        r117.getHost();
        goto L46
    L45:
        r103 = null;
        goto L46
    L47:
        StringBuilder r118 = new StringBuilder();
        com.bytedance.ug.sdk.luckycat.api.depend.j r119 = r101.f271336d;
        if (r119 != null) goto L50;
        r103 = "";
    L54:
        r118.append(r103);
        r118.append(HTTP.URL_DEFAULT);
        r118.append(r114);
        r111 = r118.toString();
        goto L56
    L50:
        bn7.e r120 = ((cn7.e) r119).f24556a;
        if (r120 == null) goto L53;
        r120.getHost();
        goto L54
    L53:
        r103 = null;
        goto L54
    L11:
        r108 = null;
        goto L12
    L7:
        r106 = null;
        goto L8
    L13:
        r109 = "";
        goto L14
    }

    @Override // pi7.f
    public final void onFailed(int r100) {
        if (r100 == 90043) goto L6;
        this.f271367a = null;
        return;
    }

    @Override // pi7.f
    public final void onSuccess(JSONObject r100) {
        if (r100 == null) goto L4;
        r100.toString();
    L4:
        this.f271367a = r100;
    }
}
