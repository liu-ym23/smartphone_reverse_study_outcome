package ou5;

import android.text.TextUtils;
import com.bytedance.ee.bear.common.DisplayName;
import com.google.gson.Gson;
import idb.f;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static boolean e() {
        return f.a().isEnable("ccm.native_english_name_fallback");
    }

    public static String b(String r100, String r101, String r102) {
        if (Locale.CHINA.getLanguage().equals(r100) == false) goto L10;
        if (TextUtils.isEmpty(r101) == true) goto L8;
        return r101;
    L8:
        return r102;
    L10:
        if (TextUtils.isEmpty(r102) == false) goto L12;
        return r101;
    L12:
        return r102;
    }

    public static String c(String r100, HashMap<String, String> r101, String r102) {
        if (r101 == null) goto L8;
        String r103 = c.c(r101, r100);
        if (TextUtils.isEmpty(r103) == false) goto L10;
        if (f.a().isEnable("ccm.bytedance_english_name_fallback") == false) goto L10;
        r103 = c.b(r101);
    L10:
        if (TextUtils.isEmpty(r103) == false) goto L12;
        return r102;
    L12:
        return r103;
    L8:
        r103 = "";
        goto L10
    }

    public static String a(String r100, DisplayName r101, String r102, String r103) {
        String r104 = "";
        if (r101 == null) goto L23;
        if (e() == false) goto L8;
        r104 = c(r100, r101.getI18n_value(), r101.getValue());
        goto L23
    L8:
        HashMap<String, String> r105 = r101.getI18n_value();
        if (r105 == null) goto L20;
        if (TextUtils.equals(Locale.ENGLISH.getLanguage(), r100) == false) goto L14;
        r104 = c.b(r105);
        goto L20
    L14:
        if (TextUtils.equals(Locale.JAPANESE.getLanguage(), r100) == false) goto L17;
        r104 = c.d(r105);
        goto L20
    L17:
        if (TextUtils.equals(Locale.CHINA.getLanguage(), r100) == false) goto L20;
        r104 = c.a(r105);
    L20:
        if (TextUtils.isEmpty(r104) == false) goto L23;
        r104 = r101.getValue();
    L23:
        if (TextUtils.isEmpty(r104) == true) goto L26;
        return r104;
    L26:
        return b(r100, r102, r103);
    }

    public static String d(String r100, String r101, String r102, String r103) {
        DisplayName r104 = (DisplayName) new Gson().fromJson(r101, DisplayName.class);     // Catch: Throwable -> L4
    L7:
        return a(r100, r104, r102, r103);
    L4:
        th = move-exception;
        tt5.a.e("DisplayNameUtils", "getDisplayNameStr", th, false);
        r104 = null;
        goto L7
    }
}
