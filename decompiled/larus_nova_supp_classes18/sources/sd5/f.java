package sd5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends com.bytedance.ee.bear.route.b {

    public static final class a {
    }

    static {
    }

    public f() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r1, RouteBean r2) {
        return "/list/space/activity";
    }

    public static String h(BearUrl r3) {
        if (r3 == null) goto L4;
        String r4 = r3.e;
    L6:
        if (TextUtils.isEmpty(r4) == false) goto L14;
    L12:
        return "";
    L14:
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(r4), "owner_id");     // Catch: Exception -> L10
        if (r5 == null) goto L12;
        return r5;
    L10:
        e = move-exception;
        tt5.a.e("ListRouteInterceptor", "parse starturl err " + r4, e, false);
        goto L12
    L4:
        r4 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r2, BearUrl r3, RouteBean r4) {
        if (r3 == null) goto L5;
        String r5 = r3.a;
    L7:
        if (TextUtils.equals(r5, "owner_list") == true) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(h(r3)) == true) goto L14;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).w2("/list/space/activity").i("owner_id", h(r3)).j("extra_destination", 14).e();
        return true;
    L14:
        return false;
    L5:
        r5 = null;
        goto L7
    }
}
