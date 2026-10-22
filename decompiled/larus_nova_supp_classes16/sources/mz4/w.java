package mz4;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w {
    public DocViewModel a;
    public com.bytedance.ee.bear.contract.d b;
    public boolean c;

    public w() {
    }

    public final Map<String, String> b() {
        HashMap r0 = new HashMap();
        BearUrl r1 = this.a.getBearUrl();
        String r2 = "ERR";
        if (r1 != null) goto L6;
    L7:
        String r3 = "ERR";
    L9:
        r0.put("file_id", r3);
        BearUrl r4 = this.a.getBearUrl();
        if (r4 != null) goto L13;
    L16:
        r0.put("file_type", r2);
        r0.put("is_owner", String.valueOf(this.a.isOwner()));
        return r0;
    L13:
        if (TextUtils.isEmpty(r4.a) == true) goto L16;
        r2 = r4.a;
        goto L16
    L6:
        if (TextUtils.isEmpty(r1.b) == true) goto L7;
        r3 = du5.b.g(r1.b);
        goto L9
    }

    public final Map<String, String> a(boolean r5) {
        HashMap r0 = new HashMap();
        BearUrl r1 = this.a.getBearUrl();
        String r2 = "ERR";
        if (r1 != null) goto L6;
    L7:
        String r3 = "ERR";
    L9:
        r0.put("file_id", r3);
        BearUrl r4 = this.a.getBearUrl();
        if (r4 != null) goto L13;
    L16:
        r0.put("file_type", r2);
        r0.put("is_owner", String.valueOf(this.a.isOwner()));
        if (r5 == false) goto L19;
        String r6 = "nav_catalog";
    L20:
        r0.put("source", r6);
        return r0;
    L19:
        r6 = "more";
        goto L20
    L13:
        if (TextUtils.isEmpty(r4.a) == true) goto L16;
        r2 = r4.a;
        goto L16
    L6:
        if (TextUtils.isEmpty(r1.b) == true) goto L7;
        r3 = du5.b.g(r1.b);
        goto L9
    }

    public final void c(boolean r4) {
        this.c = r4;
        if (this.a != null) goto L5;
    L9:
        tt5.a.k("StructureAnalytic", "reportOpenFixedStructure bad state");
        return;
    L5:
        if (this.b == null) goto L9;
        tt5.a.b("StructureAnalytic", "reportOpenFixedStructure:" + r4);
        this.b.v("show_outline_catalog", a(r4));
    }
}
