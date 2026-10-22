package sa5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.i0;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.utils.LarkContext;
import java.util.Locale;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements qu5.a.InterfaceC7393a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i0 f541169a;

    public h() {
    }

    @Override // qu5.a.InterfaceC7393a
    public final Locale getLocale() {
        if (this.f541169a != null) goto L6;
        this.f541169a = (i0) org.koin.java.a.a(i0.class);
    L6:
        return this.f541169a.c();
    }

    @Override // qu5.a.InterfaceC7393a
    public final String getToken() {
        yzb.b r100 = (yzb.b) LarkContext.spiByDwarf(yzb.b.class);     // Catch: Throwable -> L13
        if (r100 == null) goto L6;
        User r101 = r100.getForegroundUser();     // Catch: Throwable -> L13
    L7:
        if (r101 == null) goto L9;
        String r102 = r101.getSession();     // Catch: Throwable -> L13
    L10:
        if (TextUtils.isEmpty(r102) == true) goto L15;
        return r102;
    L15:
        return "";
    L9:
        r102 = "";
        goto L10
    L6:
        r101 = null;
    L13:
        th = move-exception;
        tt5.a.e("CCMCookiesAdapter", "getToken error", th, false);
        goto L15
    }
}
