package r35;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class f extends com.bytedance.ee.bear.route.a {
    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/doc/simple_web";
    }

    public f() {
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (TextUtils.equals(r101.f222560a, "help") == false) goto L19;
        tt5.a.h("HelpInterceptor", "dispatchUrl()..." + r101.f222560a);
        if (TextUtils.isEmpty(r101.f222564e) == false) goto L7;
        String r103 = "https://docs.bytedance.net/app/upgrade/";
    L8:
        b0 r104 = (b0) org.koin.java.a.a(b0.class);
        Uri r105 = UriProtector.parse(r103);
        if (r105 != null) goto L11;
    L17:
        d(r101, r102).i("web_url", r103).e();
        return true;
    L11:
        if (TextUtils.isEmpty(r105.getHost()) == true) goto L17;
        if (TextUtils.isEmpty(r105.getPath()) == true) goto L17;
        if (TextUtils.equals(r105.getHost(), r104.o()) == true) goto L17;
        r103 = r103.replace(r105.getHost(), r104.o());
        goto L17
    L7:
        r103 = r101.f222564e;
        goto L8
    L19:
        return false;
    }
}
