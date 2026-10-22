package sa5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements qu5.a.a {
    public i0 a;

    public h() {
    }

    public final Locale getLocale() {
        if (this.a != null) goto L6;
        this.a = (i0) org.koin.java.a.a(i0.class);
    L6:
        return this.a.c();
    }

    public final String getToken() {
        yzb.b r1 = (yzb.b) LarkContext.spiByDwarf(yzb.b.class);     // Catch: Throwable -> L13
        if (r1 == null) goto L6;
        User r2 = r1.getForegroundUser();     // Catch: Throwable -> L13
    L7:
        if (r2 == null) goto L9;
        String r3 = r2.getSession();     // Catch: Throwable -> L13
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        return r3;
    L15:
        return "";
    L9:
        r3 = "";
        goto L10
    L6:
        r2 = null;
    L13:
        th = move-exception;
        tt5.a.e("CCMCookiesAdapter", "getToken error", th, false);
        goto L15
    }
}
