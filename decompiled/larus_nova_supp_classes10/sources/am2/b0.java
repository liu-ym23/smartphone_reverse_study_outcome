package am2;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b0 {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        boolean r2 = true;
        if (this.a.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r0.put("enter_from_merge", this.a);
    L9:
        if (this.b.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        r0.put("enter_method", this.b);
    L15:
        if (TextUtils.isEmpty(this.e) == true) goto L21;
        String r4 = this.e;
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        r0.put("video_id", r4);
    L21:
        if (TextUtils.isEmpty(this.c) == true) goto L24;
        r0.put("request_id", this.c);
    L24:
        if (TextUtils.isEmpty(this.d) == true) goto L26;
        r0.put("log_pb", this.d);
    L26:
        r0.put("is_vs", "1");
        r0.put("action_type", "click");
        if (this.f.length() > 0) goto L30;
        r2 = false;
    L30:
        if (r2 == false) goto L32;
        r0.put("search_params", this.f);
    L32:
        return r0;
    L11:
        r3 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public b0() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.f = "";
    }
}
