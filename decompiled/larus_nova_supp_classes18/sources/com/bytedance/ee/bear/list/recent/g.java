package com.bytedance.ee.bear.list.recent;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class g extends com.bytedance.ee.bear.list.u {
    public g() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public Document d(JSONObject r6, JSONObject r7, JSONObject r8, boolean r9) {
        boolean r10 = true;
        Document r11 = super.d(r6, r7, r8, true);
        if (r11 == null) goto L49;
        int r0 = r11.getType();
        String r1 = r6.optString("name");
        int r3 = 0;
        if (TextUtils.isEmpty(r1) == false) goto L8;
    L9:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L48;
        String r4 = r6.optString("title");
        if (TextUtils.isEmpty(r4) == false) goto L17;
    L20:
        if (r10 == true) goto L23;
        r1 = r4;
        goto L48
    L23:
        if (r0 != 2) goto L25;
    L41:
        r3 = 2131887843;
    L42:
        if (r3 == 0) goto L48;
        Application r12 = eu5.b.a;
        if (r12 != null) goto L47;
        tt5.a.k("RecentDocListParser", "resolveDocName fallback skipped, context is null, type = " + r0);
        goto L48
    L47:
        r1 = r12.getString(r3);
        goto L48
    L25:
        if (r0 != 3) goto L27;
        r3 = 2131887845;
        goto L42
    L27:
        if (r0 != 8) goto L29;
    L39:
        r3 = 2131887842;
        goto L42
    L29:
        if (r0 != 12) goto L31;
        r3 = 2131888008;
        goto L42
    L31:
        if (r0 == 22) goto L41;
        if (r0 != 30) goto L35;
        r3 = 2131889771;
        goto L42
    L35:
        if (r0 == 84) goto L39;
    L17:
        if (TextUtils.getTrimmedLength(r4) == 0) goto L20;
        r10 = false;
    L48:
        r11.a = r1;
        r11.l = r6.optString("open_time");
        r11.M = r6.optString("my_edit_time");
        r11.N = r6.optString("activity_time");
    L50:
        return r11;
    L8:
        if (TextUtils.getTrimmedLength(r1) == 0) goto L9;
        r2 = false;
        goto L11
    L49:
        tt5.a.k("RecentDocListParser", "parseDoc document is null");
        goto L50
    }
}
