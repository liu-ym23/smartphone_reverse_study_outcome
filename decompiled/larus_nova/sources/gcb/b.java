package gcb;

import android.text.TextUtils;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static String a(String r100) {
        String r101 = jcb.b.c().a("docs_main_domain");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = "www";
    L6:
        return r100 + '.' + r101;
    }

    public static String b(String r100) {
        String r101 = jcb.b.c().a(IDomainConfigService.DomainAlias.DOCS_MG_MAIN_DOMAIN);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r101 = jcb.b.c().a("docs_main_domain");
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r100 = "www";
    L9:
        return r100 + '.' + r101;
    }
}
