package sd5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends com.bytedance.ee.bear.route.b {

    public static final class a {
    }

    static {
    }

    public f() {
        super(new com.bytedance.ee.bear.route.d[0]);
    }

    @Override // com.bytedance.ee.bear.route.a
    public final String e(BearUrl r100, RouteBean r101) {
        return "/list/space/activity";
    }

    public static String h(BearUrl r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f222564e;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L14;
    L12:
        return "";
    L14:
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(r101), "owner_id");     // Catch: Exception -> L10
        if (r102 == null) goto L12;
        return r102;
    L10:
        e = move-exception;
        tt5.a.e("ListRouteInterceptor", "parse starturl err " + r101, e, false);
        goto L12
    L4:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.route.d
    public final boolean b(Context r100, BearUrl r101, RouteBean r102) {
        if (r101 == null) goto L5;
        String r103 = r101.f222560a;
    L7:
        if (TextUtils.equals(r103, "owner_list") == true) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(h(r101)) == true) goto L14;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).w2("/list/space/activity").i("owner_id", h(r101)).j("extra_destination", 14).e();
        return true;
    L14:
        return false;
    L5:
        r103 = null;
        goto L7
    }
}
