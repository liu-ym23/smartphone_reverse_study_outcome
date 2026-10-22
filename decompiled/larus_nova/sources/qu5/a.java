package qu5;

import android.webkit.CookieManager;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;
import okhttp3.g;
import okhttp3.h;
import sa5.i;

/* JADX INFO: loaded from: classes19.dex */
public class a implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC7393a f534844b;

    /* JADX INFO: renamed from: qu5.a$a, reason: collision with other inner class name */
    public interface InterfaceC7393a {
        Locale getLocale();

        String getToken();
    }

    public a(i.a r100) {
        this.f534844b = r100;
    }

    @Override // okhttp3.h
    public final List<g> a(HttpUrl r100) {
        ArrayList r101 = new ArrayList();
        InterfaceC7393a r102 = this.f534844b;
        String r103 = "";
        if (r102 == null) goto L5;
        String r104 = r102.getToken();
    L6:
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        Locale r105 = Locale.ENGLISH;
        InterfaceC7393a r106 = this.f534844b;
        if (r106 == null) goto L12;
        Locale r107 = r106.getLocale();
    L13:
        if (r107 == null) goto L16;
        r105 = r107;
    L16:
        g.a r108 = new g.a();
        r108.a(r100.host(), true);
        r108.c("bear-session");
        r108.e(r103);
        r101.add(new g(r108));
        g.a r109 = new g.a();
        r109.a(r100.host(), true);
        r109.c(AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r109.e(r103);
        r101.add(new g(r109));
        g.a r110 = new g.a();
        r110.a(r100.host(), true);
        r110.c(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        r110.e(r105.getLanguage());
        r101.add(new g(r110));
        g.a r111 = new g.a();
        r111.a(r100.host(), true);
        r111.c("locale");
        r111.e(r105.getLanguage() + "_" + r105.getCountry().toUpperCase());
        r101.add(new g(r111));
        String r112 = CookieManager.getInstance().getCookie(r100.toString());
        if (r112 != null) goto L19;
    L26:
        return r101;
    L19:
        if (r112.isEmpty() == true) goto L26;
        String[] r113 = r112.split(com.alipay.sdk.m.u.i.f25853b);
        int r114 = r113.length;
        int r115 = 0;
    L21:
        if (r115 >= r114) goto L26;
        String r116 = r113[r115];
        if (r116.contains("sl_session=") == true) goto L24;
        r115 = r115 + 1;
        goto L21
    L24:
        r101.add(g.c(r100, r116));
        goto L26
    L12:
        r107 = r105;
        goto L13
    L5:
        r104 = "";
        goto L6
    }

    @Override // okhttp3.h
    public final void b(HttpUrl r100, List<g> r101) {
        String r102 = r100.toString();
        CookieManager r103 = CookieManager.getInstance();
        Iterator<g> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.setCookie(r102, r104.next().toString());
        goto L4
    }
}
