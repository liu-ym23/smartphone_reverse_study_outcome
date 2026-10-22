package ac5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.leanmode.CCMConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p extends com.bytedance.ee.bear.route.a {
    public ww4.a a;

    public final String e(BearUrl r1, RouteBean r2) {
        return "";
    }

    public p() {
    }

    public final boolean b(Context r11, BearUrl r12, RouteBean r13) {
        String r14 = r12.a;
        String r16 = r12.b;
        if (this.a != null) goto L5;
        this.a = (ww4.a) org.koin.java.a.a(ww4.a.class);
    L5:
        CCMConfig r0 = this.a.a();
        if (r0.d != null) goto L8;
        r0.d = new CCMConfig.SubConfig();
    L8:
        final int r7 = 0;
        if (r0.d.a == true) goto L14;
        if (TextUtils.equals(r14, "star") == false) goto L14;
    L26:
        boolean r17 = false;
    L29:
        if (AppInfoUtils.e().booleanValue() == false) goto L32;
        tt5.a.h("SpaceTabInterceptor", "in mempope, not support space tab, type = " + r12.a + ", token = " + du5.b.h(r12.b));
        return false;
    L32:
        if (r17 == false) goto L61;
        tt5.a.h("SpaceTabInterceptor", "dispatchUrl()..." + r12.a);
        String r18 = r12.f;
        String r19 = r12.b;
        if (TextUtils.equals(r12.a, "folder") == false) goto L39;
        if (TextUtils.isEmpty(r12.b) == false) goto L39;
        r7 = 1;
    L50:
        String r110 = r12.e;
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        HashMap r2 = new HashMap();
        if (r7 != 0) goto L53;
        r2.put("module", "home");
    L59:
        r2.put("url", r110);
        r1.v("enter_explorer_module", r2);
        tt5.a.b("SpaceTabInterceptor", "openDocEditor: isWhiteList. sourceType = " + r18 + "，token = " + du5.b.g(r19) + "，tab = " + r7);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new l()).map(new m(r7)).subscribe(new n(), new o());
        return true;
    L53:
        if (r7 != 2) goto L55;
        r2.put("module", "sharetome");
        goto L59
    L55:
        if (r7 != 4) goto L57;
        r2.put("module", "favorites");
        goto L59
    L57:
        if (r7 != 1) goto L59;
        r2.put("module", "personal");
    L39:
        if (TextUtils.equals(r12.a, "share_root") == false) goto L42;
    L46:
        r7 = 2;
        goto L50
    L42:
        if (TextUtils.equals(r12.a, "recent") == true) goto L50;
        if (TextUtils.equals(r12.a, "share") == true) goto L46;
        if (TextUtils.equals(r12.a, "star") == false) goto L50;
        r7 = 4;
        goto L50
    L61:
        return false;
    L14:
        if (TextUtils.equals(r14, "share") == false) goto L16;
    L27:
        r17 = true;
        goto L29
    L16:
        if (TextUtils.equals(r14, "recent") == true) goto L27;
        if (TextUtils.equals(r14, "star") == true) goto L27;
        if (TextUtils.equals(r14, "share_root") == true) goto L27;
        if (TextUtils.equals(r14, "folder") == false) goto L26;
        if (TextUtils.isEmpty(r16) == false) goto L26;
        goto L26
    }
}
