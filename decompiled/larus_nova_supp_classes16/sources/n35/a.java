package n35;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final String a(AccountService$Account r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "account");
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.tenantId);
        r0.append('_');
        r0.append(r2.uid);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        Intrinsics.checkNotNullParameter(r3, "type");
        if (TextUtils.equals(r3, sbb.e.g.getType()) == false) goto L9;
    L23:
        String r4 = "_CLIENT_VARS";
    L24:
        r0.append(r4);
        return r0.toString();
    L9:
        if (TextUtils.equals(r3, sbb.e.h.getType()) == false) goto L12;
        r4 = "_SHEET_CLIENT_VARS";
        goto L24
    L12:
        if (TextUtils.equals(r3, sbb.e.k.getType()) == false) goto L15;
        r4 = "_MINDNOTE_CLIENT_VARS";
        goto L24
    L15:
        if (TextUtils.equals(r3, sbb.e.m.getType()) == false) goto L18;
        r4 = "_SLIDES_CLIENT_VARS";
        goto L24
    L18:
        if (TextUtils.equals(r3, sbb.e.i.getType()) == false) goto L21;
        r4 = "_BITABLE_CLIENT_VARS";
        goto L24
    L21:
        if (TextUtils.equals(r3, sbb.e.n.getType()) == false) goto L23;
        r4 = "_WIKI_INFO";
        goto L24
    }

    @JvmStatic
    public static final String b(AccountService$Account r4, String r5, Map<String, String> r6) {
        if (r4 != null) goto L6;
        tt5.a.h("CacheKeyUtils", "account is null");
        return "";
    L6:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.sheet_ssr_cache_by_sheet_id") == true) goto L10;
        return r4.tenantId + '_' + r4.uid + "_doc_cached_html";
    L10:
        if (TextUtils.equals(r5, sbb.e.h.getType()) == false) goto L21;
        if (r6 == null) goto L16;
        boolean r3 = true;
        if (r6.containsKey("sheet") != true) goto L16;
    L17:
        if (r3 == false) goto L21;
        return r4.tenantId + '_' + r4.uid + '_' + r6.get("sheet") + "_doc_cached_html";
    L16:
        r3 = false;
    L21:
        return r4.tenantId + '_' + r4.uid + "_doc_cached_html";
    }
}
