package r35;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends com.bytedance.ee.bear.route.a {
    public final String e(BearUrl r1, RouteBean r2) {
        return "/doc/simple_web";
    }

    public f() {
    }

    public final boolean b(Context r5, BearUrl r6, RouteBean r7) {
        if (TextUtils.equals(r6.a, "help") == false) goto L19;
        tt5.a.h("HelpInterceptor", "dispatchUrl()..." + r6.a);
        if (TextUtils.isEmpty(r6.e) == false) goto L7;
        String r8 = "https://docs.bytedance.net/app/upgrade/";
    L8:
        b0 r0 = (b0) org.koin.java.a.a(b0.class);
        Uri r1 = UriProtector.parse(r8);
        if (r1 != null) goto L11;
    L17:
        d(r6, r7).i("web_url", r8).e();
        return true;
    L11:
        if (TextUtils.isEmpty(r1.getHost()) == true) goto L17;
        if (TextUtils.isEmpty(r1.getPath()) == true) goto L17;
        if (TextUtils.equals(r1.getHost(), r0.o()) == true) goto L17;
        r8 = r8.replace(r1.getHost(), r0.o());
        goto L17
    L7:
        r8 = r6.e;
        goto L8
    L19:
        return false;
    }
}
