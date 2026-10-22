package n35;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f516924a = 0;

    static {
    }

    @JvmStatic
    public static final String a(AccountService$Account r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "account");
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.tenantId);
        r102.append('_');
        r102.append(r100.uid);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Intrinsics.checkNotNullParameter(r101, "type");
        if (TextUtils.equals(r101, sbb.e.f541296g.getType()) == false) goto L9;
    L23:
        String r103 = "_CLIENT_VARS";
    L24:
        r102.append(r103);
        return r102.toString();
    L9:
        if (TextUtils.equals(r101, sbb.e.f541297h.getType()) == false) goto L12;
        r103 = "_SHEET_CLIENT_VARS";
        goto L24
    L12:
        if (TextUtils.equals(r101, sbb.e.f541300k.getType()) == false) goto L15;
        r103 = "_MINDNOTE_CLIENT_VARS";
        goto L24
    L15:
        if (TextUtils.equals(r101, sbb.e.f541302m.getType()) == false) goto L18;
        r103 = "_SLIDES_CLIENT_VARS";
        goto L24
    L18:
        if (TextUtils.equals(r101, sbb.e.f541298i.getType()) == false) goto L21;
        r103 = "_BITABLE_CLIENT_VARS";
        goto L24
    L21:
        if (TextUtils.equals(r101, sbb.e.f541303n.getType()) == false) goto L23;
        r103 = "_WIKI_INFO";
        goto L24
    }

    @JvmStatic
    public static final String b(AccountService$Account r100, String r101, Map<String, String> r102) {
        if (r100 != null) goto L6;
        tt5.a.h("CacheKeyUtils", "account is null");
        return "";
    L6:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.sheet_ssr_cache_by_sheet_id") == true) goto L10;
        return r100.tenantId + '_' + r100.uid + "_doc_cached_html";
    L10:
        if (TextUtils.equals(r101, sbb.e.f541297h.getType()) == false) goto L21;
        if (r102 == null) goto L16;
        boolean r103 = true;
        if (r102.containsKey(DocumentType.SHEET_NAME) != true) goto L16;
    L17:
        if (r103 == false) goto L21;
        return r100.tenantId + '_' + r100.uid + '_' + r102.get(DocumentType.SHEET_NAME) + "_doc_cached_html";
    L16:
        r103 = false;
    L21:
        return r100.tenantId + '_' + r100.uid + "_doc_cached_html";
    }
}
