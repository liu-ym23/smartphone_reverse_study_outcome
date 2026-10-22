package am2;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements k {
    public static n i;
    public final String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;

    public static n f() {
        if (i != null) goto L6;
        i = new n();
    L6:
        return i;
    }

    public final String a() {
        String r0 = this.f;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.h) == false) goto L9;
    L8:
        return "";
    L9:
        return new JSONObject(this.h).optString("task_key");
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public final String c() {
        if (TextUtils.isEmpty(this.b) == false) goto L5;
        return "";
    L5:
        return e(this.b, "creativeID");
    }

    public final String d() {
        if (TextUtils.isEmpty(this.b) == false) goto L5;
        return "";
    L5:
        return e(this.b, "log_extra");
    }

    public final boolean g() {
        if (TextUtils.isEmpty(this.d) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals("dou_plus", this.d) == false) goto L7;
        return true;
    }

    public final boolean h() {
        if (TextUtils.isEmpty(this.d) == false) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals("effective_ad", this.d) == false) goto L7;
        return true;
    }

    public n() {
        this.a = "";
        this.g = false;
    }

    public static String e(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L10:
        return "";
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        return new JSONObject(r2).optString(r3, "");
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
