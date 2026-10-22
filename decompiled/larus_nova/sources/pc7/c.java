package pc7;

import android.text.TextUtils;
import com.bytedance.sdk.account.impl.b0;
import com.ss.android.account.k;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements jb7.a {
    public c() {
    }

    @Override // jb7.a
    public final String getName() {
        return "verify";
    }

    @Override // jb7.a
    public final boolean b(int r100, Map r101, ua7.b r102, b0 r103) {
        JSONObject r104 = r102.f549259m;
        if (r104 != null) goto L5;
        return false;
    L5:
        if (r104.optJSONObject("data") == null) goto L47;
        JSONObject r105 = r102.f549259m.optJSONObject("data");
        e r106 = e.c();
        JSONObject r107 = r102.f549259m;
        r106.getClass();
        wqa.f r108 = k.f406318b;
        if (r108 == null) goto L41;
        r108.f();
        boolean r109 = true;
        if (r100 != 2046) goto L13;
    L20:
        boolean r110 = true;
    L21:
        if (r110 == false) goto L23;
        JSONObject r111 = e.f(r107);
    L33:
        if (r110 == false) goto L41;
        if (r111 == null) goto L41;
        String r112 = r111.optString("schema");
        String r113 = r111.optString("url");
        if (TextUtils.isEmpty(r112) == true) goto L41;
        if (TextUtils.isEmpty(r113) == true) goto L41;
    L42:
        if (r109 == true) goto L44;
        return false;
    L44:
        return e.c().i(r105, new b(r101, r103));
    L23:
        r111 = e.f(r107);
        if (r111 == null) goto L41;
        String r114 = r111.optString("account_flow", "");
        if ("verify".equalsIgnoreCase(r114) == false) goto L29;
    L32:
        r110 = true;
        goto L33
    L29:
        if ("dialog_verify".equalsIgnoreCase(r114) == true) goto L32;
        r110 = false;
        goto L33
    L13:
        if (r100 == 2139) goto L20;
        if (r100 == 2148) goto L20;
        if (r100 == 4023) goto L20;
        r110 = false;
    L41:
        r109 = false;
        goto L42
    L47:
        return false;
    }
}
