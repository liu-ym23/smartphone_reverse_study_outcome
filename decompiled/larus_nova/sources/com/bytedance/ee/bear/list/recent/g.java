package com.bytedance.ee.bear.list.recent;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import com.larus.nova.R;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class g extends com.bytedance.ee.bear.list.u {
    public g() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public Document d(JSONObject r100, JSONObject r101, JSONObject r102, boolean r103) {
        boolean r104 = true;
        Document r105 = super.d(r100, r101, r102, true);
        if (r105 == null) goto L49;
        int r106 = r105.getType();
        String r107 = r100.optString("name");
        int r108 = 0;
        if (TextUtils.isEmpty(r107) == false) goto L8;
    L9:
        boolean r109 = true;
    L11:
        if (r109 == false) goto L48;
        String r110 = r100.optString("title");
        if (TextUtils.isEmpty(r110) == false) goto L17;
    L20:
        if (r104 == true) goto L23;
        r107 = r110;
        goto L48
    L23:
        if (r106 != 2) goto L25;
    L41:
        r108 = R.string.Doc_Facade_UntitledDocument;
    L42:
        if (r108 == 0) goto L48;
        Application r111 = eu5.b.f474075a;
        if (r111 != null) goto L47;
        tt5.a.k("RecentDocListParser", "resolveDocName fallback skipped, context is null, type = " + r106);
        goto L48
    L47:
        r107 = r111.getString(r108);
        goto L48
    L25:
        if (r106 != 3) goto L27;
        r108 = R.string.Doc_Facade_UntitledSheet;
        goto L42
    L27:
        if (r106 != 8) goto L29;
    L39:
        r108 = R.string.Doc_Facade_UntitledBitable;
        goto L42
    L29:
        if (r106 != 12) goto L31;
        r108 = R.string.Doc_List_UntitledFile;
        goto L42
    L31:
        if (r106 == 22) goto L41;
        if (r106 != 30) goto L35;
        r108 = R.string.LarkCCM_Slides_Untitled;
        goto L42
    L35:
        if (r106 == 84) goto L39;
    L17:
        if (TextUtils.getTrimmedLength(r110) == 0) goto L20;
        r104 = false;
    L48:
        r105.f227868a = r107;
        r105.f227887l = r100.optString("open_time");
        r105.M = r100.optString("my_edit_time");
        r105.N = r100.optString("activity_time");
    L50:
        return r105;
    L8:
        if (TextUtils.getTrimmedLength(r107) == 0) goto L9;
        r109 = false;
        goto L11
    L49:
        tt5.a.k("RecentDocListParser", "parseDoc document is null");
        goto L50
    }
}
